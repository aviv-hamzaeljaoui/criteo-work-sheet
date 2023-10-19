import io.circe.Decoder
import io.circe.generic.auto._
import io.circe.parser.decode

import java.io.{File, PrintWriter}
import java.nio.charset.StandardCharsets
import java.time.format.DateTimeFormatter
import java.time.{LocalDate, OffsetDateTime}

object CriteoUtils {
  case class DateRange(start_date: OffsetDateTime, end_date: OffsetDateTime)

  def avivCreationDate(): String = {
    val currentDate = LocalDate.now()
    val formatter = DateTimeFormatter.ofPattern("yyyyMMdd")
    val formattedDate = currentDate.format(formatter)
    formattedDate
  }

  def generateDateRange(enum: CriteoEnum.MyEnum): DateRange = {
    val now = OffsetDateTime.now()
    val start_date = enum match {
      case CriteoEnum.AdSet => now.minusYears(2)
      case CriteoEnum.Placement => now.minusYears(1)
      case _ => throw new IllegalArgumentException("Invalid enum type")
    }
    val end_date = now

    DateRange(start_date, end_date)
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
