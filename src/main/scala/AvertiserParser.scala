import play.api.libs.json._

import scala.collection.mutable

object AdvertiserParser {





  def parseJsonAndExtractData(jsonString: String): mutable.Map[String, String] = {
    val json = Json.parse(jsonString)
    val advertiserData = (json \ "data").as[JsArray]

    val dataMap = mutable.Map[String, String]()

    for (entry <- advertiserData.value) {
      val advertiserName = (entry \ "attributes" \ "advertiserName").as[String]
      val id = (entry \ "id").as[String]

      dataMap += (id -> advertiserName)
    }

    dataMap
  }



  }

