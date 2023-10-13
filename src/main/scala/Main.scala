import CriteoReportAnalysisApiParameters._
import CsvMerger.{downloadUnzipAndMergeFiles, extractUrlsFromJson}
import Utils.displayCriteoApiResponse
import com.criteo.api.marketingsolutions.v2023_07.api.{AdvertiserApi, AnalyticsApi}
import com.criteo.api.marketingsolutions.v2023_07.model.{GetPortfolioResponse, TransparencyQueryMessage}
import com.criteo.api.marketingsolutions.v2023_07.{ApiClient, ApiClientBuilder}

import scala.concurrent.Await
import scala.concurrent.duration.DurationInt

object Main extends App {

  //Build Client HTTP
  private lazy val clientId = sys.env("CLIENT_ID")
  private lazy val clientSecret = sys.env("CLIENT_SECRET")
  val defaultClient: ApiClient = ApiClientBuilder.ForClientCredentials(clientId, clientSecret)

  lazy val advertiserApiInstance: AdvertiserApi = new AdvertiserApi(defaultClient)
  lazy val advertiserPortfolioGet: GetPortfolioResponse = advertiserApiInstance.apiPortfolioGet()
  //Construct Client for Analytics API
  val analyticsApi = new AnalyticsApi(defaultClient)
  //https://developers.criteo.com/marketing-solutions/docs/log-level
  val transparencyQueryMessage = new TransparencyQueryMessage()
  transparencyQueryMessage.setEndDate(endDate)

  transparencyQueryMessage.setStartDate(START_DATE)
  transparencyQueryMessage.setShouldDisplayProductIds(true)

  val transparencyResponse = analyticsApi.getTransparencyReport(AVDVERTISER_ID, transparencyQueryMessage)
  displayCriteoApiResponse(transparencyResponse.toJson)
  println(extractUrlsFromJson(transparencyResponse.toJson))
  /*val urls = extractUrlsFromJson(transparencyResponse.toJson)
  val mergeFileName = "merged.csv"

  val mergeResult = downloadUnzipAndMergeFiles(urls.toList, mergeFileName)
  Await.result(mergeResult, 10.minutes)*/
}
