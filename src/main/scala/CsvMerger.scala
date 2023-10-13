import CriteoReportAnalysisApiParameters.LOG_LEVEL_HEADER_REPORT

import java.io.{File, FileOutputStream}
import java.nio.file.{Files, Paths}
import java.util.zip.GZIPInputStream
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import org.apache.commons.csv.{CSVFormat, CSVParser, CSVPrinter}
import play.api.libs.json._


import scala.collection.JavaConverters._
object CsvMerger {
  def downloadUnzipAndMergeFiles(urls: List[String], mergeFileName: String): Future[Unit] = {
    // Define a function to download and unzip a single file
    def downloadAndUnzip(url: String, fileName: String): Unit = {
      val urlStream = new java.net.URL(url).openStream()
      val gzis = new GZIPInputStream(urlStream)
      val fos = new FileOutputStream(fileName)
      val buffer = new Array[Byte](1024)
      var len = gzis.read(buffer)
      while (len > 0) {
        fos.write(buffer, 0, len)
        len = gzis.read(buffer)
      }
      gzis.close()
      fos.close()
      urlStream.close()
    }

    // Define a function to merge CSV files
    def mergeCsvFiles(fileNames: List[String], mergeFileName: String): Unit = {
      val mergedFile = new File(mergeFileName)
      val csvFormat = CSVFormat.DEFAULT.withHeader(LOG_LEVEL_HEADER_REPORT: _*).withDelimiter(',')

      val writer = Files.newBufferedWriter(Paths.get(mergeFileName))
      val printer = new CSVPrinter(writer, csvFormat)

      try {
        for (fileName <- fileNames) {
          val file = new File(fileName)
          val parser = CSVParser.parse(file, java.nio.charset.StandardCharsets.UTF_8, csvFormat)
          val records = parser.getRecords.asScala
          for (record <- records.tail) { // Skip the header row
            printer.printRecord(record.asScala)
          }
        }
      } finally {
        writer.close()
        printer.close()
      }
    }
    val downloadFutures = urls.zipWithIndex.map { case (url, index) =>
      Future {
        val fileName = s"temp_${index}.csv.gz"
        downloadAndUnzip(url, fileName)
        fileName
      }
    }

    Future.sequence(downloadFutures).map { downloadedFiles =>
      mergeCsvFiles(downloadedFiles, mergeFileName)
      // Clean up temporary files
      downloadedFiles.foreach(fileName => new File(fileName).delete())
    }
  }

  def extractUrlsFromJson(jsonString: String): Seq[String] = {
    // Parse the JSON string
    val json = Json.parse(jsonString)

    // Extract the 'files' array from the JSON
    val filesArray = (json \ "data" \\ "files").headOption.getOrElse(Json.arr())

    // Define a regular expression to match URLs between 'https' and '?sv'
    val urlPattern = "https://[^?]+(?=\\?sv)".r

    // Extract URLs matching the pattern from the 'url' field in each file object
    val urls = filesArray.asOpt[Seq[JsObject]].getOrElse(Seq.empty)
      .flatMap { file =>
        (file \ "url").asOpt[String].toList
      }
      .flatMap { url =>
        urlPattern.findAllIn(url)
      }

    urls
  }

  /*def main(args: Array[String]): Unit = {
    val json = """{"data":[{"type":"TransparencyReport","attributes":{"advertiserId":"1138","tokenValidUntil":"2023-10-12T15:38:05.0888424Z","files":[{"fileName":"2023-09-12_v2.csv.gz","url":"https://criteocpp.blob.core.windows.net/0001138/2023-09-12_v2.csv.gz?sv\u003d2017-04-17\u0026sr\u003dc\u0026sig\u003dSjzZNJ18a86HRVFDi13gfFQSCqe43LnPPoq8R%2FhwUck%3D\u0026se\u003d2023-10-12T15%3A38%3A05Z\u0026sp\u003dr"},{"fileName":"2023-09-13_v2.csv.gz","url":"https://criteocpp.blob.core.windows.net/0001138/2023-09-13_v2.csv.gz?sv\u003d2017-04-17\u0026sr\u003dc\u0026sig\u003dSjzZNJ18a86HRVFDi13gfFQSCqe43LnPPoq8R%2FhwUck%3D\u0026se\u003d2023-10-12T15%3A38%3A05Z\u0026sp\u003dr"}]}}]}"""
    val urls = List("https://criteocpp.blob.core.windows.net/0001138/2023-09-12_v2.csv.gz?sv=2017-04-17&sr=c&sig=SjzZNJ18a86HRVFDi13gfFQSCqe43LnPPoq8R%2FhwUck%3D&se=2023-10-12T15%3A38%3A05Z&sp=r", "https://criteocpp.blob.core.windows.net/0001138/2023-09-13_v2.csv.gz?sv=2017-04-17&sr=c&sig=SjzZNJ18a86HRVFDi13gfFQSCqe43LnPPoq8R%2FhwUck%3D&se=2023-10-12T15%3A38%3A05Z&sp=r")
    val mergeFileName = "merged.csv"

    val mergeResult = downloadUnzipAndMergeFiles(urls, mergeFileName)
    Await.result(mergeResult, 10.minutes)
  }*/
}