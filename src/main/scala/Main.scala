import CriteoAnalyticsReportsParameters.{adSetEndDate, adSetstartDate}
import CsvMerger.{downloadUnzipAndMergeFiles, extractUrlsFromJson}
import Utils.displayCriteoApiResponse
import com.criteo.api.marketingsolutions.v2023_07.api.{AdvertiserApi, AnalyticsApi, AudienceApi}
import com.criteo.api.marketingsolutions.v2023_07.model.{GetPortfolioResponse, TransparencyQueryMessage}
import com.criteo.api.marketingsolutions.v2023_07.{ApiClient, ApiClientBuilder, ApiException}

import scala.concurrent.Await
import scala.concurrent.duration.DurationInt
import scala.util.{Failure, Success, Try}

object Main extends App {

  //Build Client HTTP
  private lazy val clientId = sys.env("CLIENT_ID")
  private lazy val clientSecret = sys.env("CLIENT_SECRET")
  val defaultClient: ApiClient = ApiClientBuilder.ForClientCredentials(clientId, clientSecret)
  defaultClient.setConnectTimeout(600000)
  defaultClient.setReadTimeout(600000)
  lazy val advertiserApiInstance: AdvertiserApi = new AdvertiserApi(defaultClient)
  lazy val advertiserPortfolioGet: GetPortfolioResponse = advertiserApiInstance.apiPortfolioGet()
  //Construct Client for Analytics API
  val analyticsApi = new AnalyticsApi(defaultClient)
  val maxRetries = 5

  def retry[T](n: Int)(fn: => T): T = {
    Try(fn) match {
      case Success(x) => x
      case Failure(e: ApiException) if (n > 1 && e.getCode == 504) =>
        println(s"Attempt failed. Retrying... ${n - 1} attempts left.")
        Thread.sleep(1000) // Adjust the sleep duration as required
        retry(n - 1)(fn)
      case Failure(e) => throw e
    }
  }

  val apiInstance = new AudienceApi(defaultClient)


  val transparencyQueryMessage = new TransparencyQueryMessage()
  transparencyQueryMessage.setEndDate(adSetEndDate)

  transparencyQueryMessage.setStartDate( adSetstartDate)
  transparencyQueryMessage.setShouldDisplayProductIds(true)

  val transparencyResponse = retry(maxRetries) {
    analyticsApi.getTransparencyReport(1138, transparencyQueryMessage)
  }

  displayCriteoApiResponse(transparencyResponse.toJson)
  println(extractUrlsFromJson(transparencyResponse.toJson))
  val urls = extractUrlsFromJson(transparencyResponse.toJson)
  val mergeFileName = "merged.csv"

  val mergeResult = downloadUnzipAndMergeFiles(urls.toList, mergeFileName)
  Await.result(mergeResult, 10.minutes)

}
