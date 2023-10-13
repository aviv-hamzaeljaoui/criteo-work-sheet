import Utils.{generateIso8601DateFormat, getCurrentOffsetDateTime}
import com.criteo.api.marketingsolutions.v2023_07.model.{PlacementsReportQueryMessage, StatisticsReportQueryMessage}
import com.criteo.api.marketingsolutions.v2023_07.model.StatisticsReportQueryMessage.DimensionsEnum

import java.util
import java.util.ArrayList

object CriteoReportAnalysisApiParameters {

  //case classes
  val dateTimeParams = DateTimeParams(2023, 10, 1, 0, 0, 0, 0, 0)
  //Constants & variables => parameters for my reports analysis
  val CURRENCY = "EUR"
  val START_DATE = generateIso8601DateFormat(dateTimeParams = dateTimeParams)
  val endDate = getCurrentOffsetDateTime()
  val FILE_FORMAT = "csv"
  val DIMENSIONS = new ArrayList[DimensionsEnum]()

  DIMENSIONS.add(DimensionsEnum.ADSETID)
  DIMENSIONS.add(DimensionsEnum.ADSET)
  DIMENSIONS.add(DimensionsEnum.ADVERTISERID)
  DIMENSIONS.add(DimensionsEnum.ADVERTISER)
  DIMENSIONS.add(DimensionsEnum.CATEGORYID)
  DIMENSIONS.add(DimensionsEnum.CATEGORY)
  DIMENSIONS.add(DimensionsEnum.CAMPAIGNID)
  DIMENSIONS.add(DimensionsEnum.CAMPAIGN)
  DIMENSIONS.add(DimensionsEnum.ADID)
  DIMENSIONS.add(DimensionsEnum.AD)
  DIMENSIONS.add(DimensionsEnum.COUPONID)
  DIMENSIONS.add(DimensionsEnum.COUPON)
  DIMENSIONS.add(DimensionsEnum.MARKETINGOBJECTIVEID)
  DIMENSIONS.add(DimensionsEnum.MARKETINGOBJECTIVE)

  val DIMENSIONS_PLACEMENT_LIST = new ArrayList[PlacementsReportQueryMessage.DimensionsEnum]()

  DIMENSIONS_PLACEMENT_LIST.add(PlacementsReportQueryMessage.DimensionsEnum.ADSETID)
  DIMENSIONS_PLACEMENT_LIST.add(PlacementsReportQueryMessage.DimensionsEnum.ADVERTISERID)
  DIMENSIONS_PLACEMENT_LIST.add(PlacementsReportQueryMessage.DimensionsEnum.PLACEMENT)
  DIMENSIONS_PLACEMENT_LIST.add(PlacementsReportQueryMessage.DimensionsEnum.ENVIRONMENT)
  DIMENSIONS_PLACEMENT_LIST.add(PlacementsReportQueryMessage.DimensionsEnum.ADSETNAME)
  DIMENSIONS_PLACEMENT_LIST.add(PlacementsReportQueryMessage.DimensionsEnum.ADVERTISERNAME)
  DIMENSIONS_PLACEMENT_LIST.add(PlacementsReportQueryMessage.DimensionsEnum.CAMPAIGNID)
  DIMENSIONS_PLACEMENT_LIST.add(PlacementsReportQueryMessage.DimensionsEnum.CAMPAIGNNAME)

  val METRICS_PLACEMENT = new util.ArrayList[String]()

  // Add the metrics you have one by one
  METRICS_PLACEMENT.add("clicks")
  METRICS_PLACEMENT.add("displays")
  METRICS_PLACEMENT.add("cost")
  METRICS_PLACEMENT.add("salesPc30d")
  METRICS_PLACEMENT.add("salesPv1d")
  METRICS_PLACEMENT.add("revenuePc30d")
  METRICS_PLACEMENT.add("revenuePv1d")
  METRICS_PLACEMENT.add("cosPc30d")
  METRICS_PLACEMENT.add("cosPv1d")
  METRICS_PLACEMENT.add("roasPc30d")
  METRICS_PLACEMENT.add("roasPv1d")
  METRICS_PLACEMENT.add("cpoPc30d")
  METRICS_PLACEMENT.add("cpoPv1d")
  METRICS_PLACEMENT.add("cvrPc30d")
  METRICS_PLACEMENT.add("cvrPv1d")




  val METRICS = new ArrayList[String]()

  METRICS.add("Clicks")
  METRICS.add("Displays")
  METRICS.add("ViewableDisplays")
  METRICS.add("NonViewableDisplays")
  METRICS.add("UntrackableDisplays")
  METRICS.add("AdvertiserCost")
  METRICS.add("QualifiedVisits")
  METRICS.add("Visits")
  METRICS.add("CostPerVisit")
  METRICS.add("BounceRate")
  METRICS.add("PotentialDisplays")
  METRICS.add("OverallCompetitionWin")
  METRICS.add("SalesClientAttribution")
  METRICS.add("SalesAllClientAttribution")
  METRICS.add("SalesPc30d")
  METRICS.add("SalesAllPc30d")
  METRICS.add("SalesPv24h")
  METRICS.add("SalesAllPv24h")
  METRICS.add("SalesPc30dPv24h")
  METRICS.add("SalesAllPc30dPv24h")
  METRICS.add("SalesPc1d")
  METRICS.add("SalesAllPc1d")
  METRICS.add("SalesPc7d")
  METRICS.add("SalesAllPc7d")
  METRICS.add("RevenueGeneratedClientAttribution")
  METRICS.add("RevenueGeneratedAllClientAttribution")
  METRICS.add("RevenueGeneratedPc30d")
  METRICS.add("RevenueGeneratedAllPc30d")
  METRICS.add("RevenueGeneratedPv24h")
  METRICS.add("RevenueGeneratedAllPv24h")
  METRICS.add("RevenueGeneratedPc30dPv24h")
  METRICS.add("RevenueGeneratedAllPc30dPv24h")
  METRICS.add("RevenueGeneratedPc1d")
  METRICS.add("RevenueGeneratedAllPc1d")
  METRICS.add("RevenueGeneratedPc7d")
  METRICS.add("RevenueGeneratedAllPc7d")
  METRICS.add("ExposedUsers")
  METRICS.add("Audience")
  METRICS.add("Reach")
  METRICS.add("AverageCartClientAttribution")
  METRICS.add("AverageCartAllClientAttribution")
  METRICS.add("AverageCartPc30d")
  METRICS.add("AverageCartAllPc30d")
  METRICS.add("AverageCartPv24h")
  METRICS.add("AverageCartAllPv24h")
  METRICS.add("AverageCartPc30dPv24h")
  METRICS.add("AverageCartAllPc30dPv24h")
  METRICS.add("AverageCartPc1d")
  METRICS.add("AverageCartAllPc1d")
  METRICS.add("AverageCartPc7d")
  METRICS.add("AverageCartAllPc7d")
  METRICS.add("ClickThroughRate")
  METRICS.add("ConversionRateClientAttribution")
  METRICS.add("ConversionRateAllClientAttribution")
  METRICS.add("ConversionRatePc30d")
  METRICS.add("ConversionRateAllPc30d")
  METRICS.add("ConversionRatePv24h")
  METRICS.add("ConversionRateAllPv24h")
  METRICS.add("ConversionRatePc30dPv24h")
  METRICS.add("ConversionRateAllPc30dPv24h")
  METRICS.add("ConversionRatePc1d")
  METRICS.add("ConversionRateAllPc1d")
  METRICS.add("ConversionRatePc7d")
  METRICS.add("ConversionRateAllPc7d")
  METRICS.add("ECosClientAttribution")
  METRICS.add("ECosAllClientAttribution")
  METRICS.add("ECosPc30d")
  METRICS.add("ECosAllPc30d")
  METRICS.add("ECosPv24h")
  METRICS.add("ECosAllPv24h")
  METRICS.add("ECosPc30dPv24h")
  METRICS.add("ECosAllPc30dPv24h")
  METRICS.add("ECosPc1d")
  METRICS.add("ECosAllPc1d")
  METRICS.add("ECosPc7d")
  METRICS.add("ECosAllPc7d")
  METRICS.add("Cpc")
  METRICS.add("ECpm")
  METRICS.add("RoasClientAttribution")
  METRICS.add("RoasAllClientAttribution")
  METRICS.add("RoasPc30d")
  METRICS.add("RoasAllPc30d")
  METRICS.add("RoasPv24h")
  METRICS.add("RoasAllPv24h")
  METRICS.add("RoasPc30dPv24h")
  METRICS.add("RoasAllPc30dPv24h")
  METRICS.add("RoasPc1d")
  METRICS.add("RoasAllPc1d")
  METRICS.add("RoasPc7d")
  METRICS.add("RoasAllPc7d")
  METRICS.add("AdvertiserValue")
  METRICS.add("AdvertiserAllValue")
  METRICS.add("CostOfAdvertiserValue")
  METRICS.add("CostOfAdvertiserValueAll")
  METRICS.add("PostInstallSales")
  METRICS.add("AppInstalls")
  METRICS.add("PostInstallConversionRate")
  METRICS.add("PostInstallCostOfSale")
  METRICS.add("PostInstallOrderValue")
  METRICS.add("CostPerInstall")
  METRICS.add("InstallRate")
  METRICS.add("PostInstallCostPerOrder")
  METRICS.add("PostInstallRoas")
  METRICS.add("OmnichannelRoasClientAttribution")
  METRICS.add("OmnichannelRoasPc30d")
  METRICS.add("OmnichannelRoasAllPc30d")
  METRICS.add("OmnichannelRoasPv24h")
  METRICS.add("OmnichannelRoasAllPv24h")
  METRICS.add("OmnichannelRevenueClientAttribution")
  METRICS.add("OmnichannelRevenuePc30d")
  METRICS.add("OmnichannelRevenueAllPc30d")
  METRICS.add("OmnichannelRevenuePv24h")
  METRICS.add("OmnichannelRevenueAllPv24h")
  METRICS.add("OmnichannelsalesClientAttribution")
  METRICS.add("OmnichannelSalesPc30d")
  METRICS.add("OmnichannelSalesAllPc30d")
  METRICS.add("OmnichannelSalesPv24h")
  METRICS.add("OmnichannelSalesAllPv24h")
  METRICS.add("RoasOfflinePc30d")
  METRICS.add("RoasOfflinePv24h")
  METRICS.add("SalesOfflinePc30d")
  METRICS.add("SalesOfflinePv24h")
  METRICS.add("RevenueGeneratedOfflinePc30d")
  METRICS.add("RevenueGeneratedOfflinePv24h")

  val TIME_ZONE = "UTC"


  //First of All we have to set the statisticsReportQueryMessage for our reports
  val statisticsReportQueryMessage = new StatisticsReportQueryMessage()
  //SET Parameters for StatisticsReportQueryMessage
  statisticsReportQueryMessage.setCurrency(CURRENCY)
  statisticsReportQueryMessage.setStartDate(START_DATE)
  statisticsReportQueryMessage.setEndDate(endDate)
  statisticsReportQueryMessage.setFormat(FILE_FORMAT)
  statisticsReportQueryMessage.setDimensions(DIMENSIONS)
  statisticsReportQueryMessage.setMetrics(METRICS)
  statisticsReportQueryMessage.setTimezone(TIME_ZONE)
  statisticsReportQueryMessage.setAdvertiserIds("1138")

  val AVDVERTISER_ID = 1138

  val LOG_LEVEL_HEADER_REPORT = List(
    "DAY",
    "HOUR",
    "TIMESTAMP",
    "EVENT_TYPE",
    "ADSET_ID",
    "ADSET_NAME",
    "AD_FORMAT",
    "BANNER_ID",
    "CATEGORY_ID",
    "CATEGORY_NAME",
    "REFERRER",
    "ENVIRONMENT",
    "DEVICE_FAMILY",
    "OS_FAMILY",
    "APP_ID",
    "APP_NAME",
    "VIEWABILITY",
    "DISPLAY_COST_CURRENCY",
    "DISPLAY_COST",
    "DISPLAY_COST_USD",
    "CLICK_COST_CURRENCY",
    "CLICK_COST",
    "CLICK_COST_USD"
  )


}
