import com.criteo.api.marketingsolutions.v2023_07.ApiException
import com.criteo.api.marketingsolutions.v2023_07.model.{PlacementsReportQueryMessage, StatisticsReportQueryMessage}

import java.io.{File, PrintWriter}
import java.time.format.DateTimeFormatter
import java.time.{OffsetDateTime, ZoneId, ZoneOffset}
import java.nio.charset.StandardCharsets
import io.circe.parser.decode
import io.circe.generic.auto._
import io.circe.{Decoder, Json}

case class DateTimeParams(year: Int, month: Int, day: Int, hour: Int, minute: Int, second: Int, timeZoneOffsetHours: Int, timeZoneOffsetMinutes: Int)

object Utils {

  def displayCriteoApiResponse[T](response: T): Unit = {
    try {
      response match {
        case r: Array[Byte] => val responseString = new String(r, StandardCharsets.UTF_8);
          println(responseString)
        case _ => println(response)
      }
      println(response)
    } catch {
      case e: ApiException =>
        println("Exception when calling AdvertiserApi#apiPortfolioGet")
        println("Status code: " + e.getCode())
        println("Reason: " + e.getResponseBody())
        println("Response headers: " + e.getResponseHeaders())
        e.printStackTrace()
    }
  }

  def generateIso8601DateFormat(dateTimeParams: DateTimeParams): OffsetDateTime = {
    // Destructure the DateTimeParams object
    val DateTimeParams(year, month, day, hour, minute, second, timeZoneOffsetHours, timeZoneOffsetMinutes) = dateTimeParams

    // Create an OffsetDateTime object with the specified date and time components
    val dateTime = OffsetDateTime.of(year, month, day, hour, minute, second, 0, ZoneOffset.ofHoursMinutes(timeZoneOffsetHours, timeZoneOffsetMinutes))

    // Format the OffsetDateTime object as a string in ISO 8601 format
    val iso8601String = dateTime.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME)


    // Return the OffsetDateTime object
    dateTime
  }


  def getCurrentOffsetDateTime(): OffsetDateTime = {
    // Get the current date and time in the UTC timezone
    val currentDateTime = java.time.LocalDateTime.now(ZoneId.of("UTC"))

    // Convert the current date and time to OffsetDateTime
    val offsetDateTime = currentDateTime.atOffset(ZoneOffset.UTC)

    // Print the current OffsetDateTime
    println("Current OffsetDateTime: " + offsetDateTime)

    // Return the OffsetDateTime object
    offsetDateTime
  }

  def writeStringToFile[T](response: T, filePath: String): Unit = {

    val stringResponse: String = response match {
      case r: Array[Byte] => val responseString = new String(r, StandardCharsets.UTF_8)
        responseString

      case string: String => string
    }
    val writer = new PrintWriter(new File(filePath))
    writer.write(stringResponse)
    writer.close()
  }

 // def getAvertiserIdList()
 // Define case classes to represent the JSON structure
 case class PortfolioMessage(advertiserName: String)
  case class EntityOfPortfolioMessage(id: Int, attributes: PortfolioMessage)
  case class GetPortfolioResponse(data: List[EntityOfPortfolioMessage])

  // Define a custom decoder for GetPortfolioResponse
  implicit val portfolioMessageDecoder: Decoder[GetPortfolioResponse] = Decoder.instance { c =>
    c.downField("data").as[List[EntityOfPortfolioMessage]].map(GetPortfolioResponse)
  }

  // Function to parse the JSON response and create a Map of AdvertiserName to AdvertiserID
  def parseApiResponse(jsonStr: String): Map[String, Int] = {
    println(jsonStr)
    // Parse the JSON response
    val parsedResponse = decode[GetPortfolioResponse](jsonStr)

    // Extract the data and convert it to a Map of AdvertiserName to AdvertiserID
    val advertiserMap = parsedResponse match {
      case Right(response) =>
        response.data.map(entity => entity.attributes.advertiserName -> entity.id).toMap
      case Left(error) =>
        Map.empty[String, Int] // Handle the case where parsing fails
    }

    advertiserMap
  }



}
