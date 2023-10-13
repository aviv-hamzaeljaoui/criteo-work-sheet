/*
  lazy val advertiserApiInstance: AdvertiserApi = new AdvertiserApi(defaultClient)
  lazy val advertiserPortfolioGet: GetPortfolioResponse = advertiserApiInstance.apiPortfolioGet()
  //displayCriteoApiResponse(response = advertiserPortfolioGet)



  //TODO : See if the PlacementsReportQueryDataMessage is optional that is return all infos
  val placementsReportQueryDataMessage = new PlacementsReportQueryDataMessage()
  val placementsReport: Array[Byte] = analyticsApi.getPlacementsReport(placementsReportQueryDataMessage)

  displayCriteoApiResponse(placementsReport)

  //getTransparencyReport
val transparencyQueryMessage = new TransparencyQueryMessage()
transparencyQueryMessage.startDate(START_DATE)
transparencyQueryMessage.setEndDate(endDate)
val transparencyReport = analyticsApi.getTransparencyReport(AVDVERTISER_ID, transparencyQueryMessage)

displayCriteoApiResponse(transparencyReport)
*/

/*val placementReportQueryMessage = new PlacementsReportQueryMessage()
placementReportQueryMessage.setDimensions(DIMENSIONS_PLACEMENT_LIST)
placementReportQueryMessage.setMetrics(METRICS_PLACEMENT)
placementReportQueryMessage.setCurrency(CURRENCY)
placementReportQueryMessage.setFormat(FILE_FORMAT)
placementReportQueryMessage.setTimezone(TIME_ZONE)
placementReportQueryMessage.startDate(START_DATE)
placementReportQueryMessage.setEndDate(endDate)
placementReportQueryMessage.setAdvertiserIds(AVDVERTISER_ID.toString)

val placementsReportQueryEntityMessage = new PlacementsReportQueryEntityMessage()
placementsReportQueryEntityMessage.setAttributes(placementReportQueryMessage)
val data = new util.ArrayList[PlacementsReportQueryEntityMessage]()
data.add(placementsReportQueryEntityMessage)
val placementsReportQueryDataMessage = new PlacementsReportQueryDataMessage()
placementsReportQueryDataMessage.setData(data)

lazy val placementReport =  analyticsApi.getPlacementsReport(placementsReportQueryDataMessage)
writeStringToFile(response =placementReport, filePath = s"./placementReport.csv" )*/





/*
val transactionsReportQueryMessage = new TransactionsReportQueryMessage()
// transactionsReportQueryMessage.setAdvertiserIds(AVDVERTISER_ID.toString)
transactionsReportQueryMessage.setCurrency(CURRENCY)
transactionsReportQueryMessage.setFormat(FILE_FORMAT)
transactionsReportQueryMessage.setTimezone(TIME_ZONE)
transactionsReportQueryMessage.startDate(START_DATE)
transactionsReportQueryMessage.endDate(endDate)

val transactionsReportQueryEntityMessage = new TransactionsReportQueryEntityMessage()
transactionsReportQueryEntityMessage.setAttributes(transactionsReportQueryMessage)
val transactionsReportQueryEntityMessageData  = new util.ArrayList[TransactionsReportQueryEntityMessage]()

transactionsReportQueryEntityMessageData.add(transactionsReportQueryEntityMessage)

val transactionsReportQueryDataMessage = new TransactionsReportQueryDataMessage()
transactionsReportQueryDataMessage.setData(transactionsReportQueryEntityMessageData)

lazy val transactionResponse = analyticsApi.getTransactionsReport(transactionsReportQueryDataMessage)

displayCriteoApiResponse(transactionResponse)
 */

/*
//https://developers.criteo.com/marketing-solutions/docs/log-level
val transparencyQueryMessage = new TransparencyQueryMessage()
transparencyQueryMessage.setEndDate(endDate)

transparencyQueryMessage.setStartDate(START_DATE)
transparencyQueryMessage.setShouldDisplayProductIds(true)

val transparencyResponse = analyticsApi.getTransparencyReport(AVDVERTISER_ID, transparencyQueryMessage)
displayCriteoApiResponse(transparencyResponse.toJson)
println(extractUrlsFromJson(transparencyResponse.toJson))
val urls = extractUrlsFromJson(transparencyResponse.toJson)
val mergeFileName = "merged.csv"

val mergeResult = downloadUnzipAndMergeFiles(urls.toList, mergeFileName)
Await.result(mergeResult, 10.minutes)
 */