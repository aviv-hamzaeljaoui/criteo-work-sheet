import CriteoUtils.generateDateRange
import Utils.{generateIso8601DateFormat, getCurrentOffsetDateTime}
import com.criteo.api.marketingsolutions.v2023_07.model.{PlacementsReportQueryMessage, StatisticsReportQueryMessage}
import com.criteo.api.marketingsolutions.v2023_07.model.StatisticsReportQueryMessage.DimensionsEnum

import java.util
import java.util.ArrayList

object CriteoAnalyticsReportsParameters {

  // TODO Reports File names

  // GENERAL CONFIGURATION AND CONSTANTS
  val CURRENCY = "EUR"
  val FILE_FORMAT = "csv"
  val TIME_ZONE = "UTC"


  // adSet Report Configuration
  val ctieoAdSetDateRange = CriteoUtils.generateDateRange(enum = CriteoEnum.AdSet)
  val adSetstartDate = ctieoAdSetDateRange.start_date
  val adSetEndDate = ctieoAdSetDateRange.end_date

  val DIMENSIONS_AD_SET = new util.ArrayList[DimensionsEnum]()

  DIMENSIONS_AD_SET.add(DimensionsEnum.ADSETID)
  DIMENSIONS_AD_SET.add(DimensionsEnum.ADSET)
  DIMENSIONS_AD_SET.add(DimensionsEnum.ADVERTISERID)
  DIMENSIONS_AD_SET.add(DimensionsEnum.ADVERTISER)
  DIMENSIONS_AD_SET.add(DimensionsEnum.CATEGORYID)
  DIMENSIONS_AD_SET.add(DimensionsEnum.CATEGORY)
  DIMENSIONS_AD_SET.add(DimensionsEnum.CAMPAIGNID)
  DIMENSIONS_AD_SET.add(DimensionsEnum.CAMPAIGN)
  DIMENSIONS_AD_SET.add(DimensionsEnum.ADID)
  DIMENSIONS_AD_SET.add(DimensionsEnum.AD)
  DIMENSIONS_AD_SET.add(DimensionsEnum.COUPONID)
  DIMENSIONS_AD_SET.add(DimensionsEnum.COUPON)
  DIMENSIONS_AD_SET.add(DimensionsEnum.MARKETINGOBJECTIVEID)
  DIMENSIONS_AD_SET.add(DimensionsEnum.MARKETINGOBJECTIVE)

  val METRICS_AD_SET = new ArrayList[String]()

  METRICS_AD_SET.add("Clicks")
  METRICS_AD_SET.add("Displays")
  METRICS_AD_SET.add("ViewableDisplays")
  METRICS_AD_SET.add("NonViewableDisplays")
  METRICS_AD_SET.add("UntrackableDisplays")
  METRICS_AD_SET.add("AdvertiserCost")
  METRICS_AD_SET.add("QualifiedVisits")
  METRICS_AD_SET.add("Visits")
  METRICS_AD_SET.add("CostPerVisit")
  METRICS_AD_SET.add("BounceRate")
  METRICS_AD_SET.add("PotentialDisplays")
  METRICS_AD_SET.add("OverallCompetitionWin")
  METRICS_AD_SET.add("SalesClientAttribution")
  METRICS_AD_SET.add("SalesAllClientAttribution")
  METRICS_AD_SET.add("SalesPc30d")
  METRICS_AD_SET.add("SalesAllPc30d")
  METRICS_AD_SET.add("SalesPv24h")
  METRICS_AD_SET.add("SalesAllPv24h")
  METRICS_AD_SET.add("SalesPc30dPv24h")
  METRICS_AD_SET.add("SalesAllPc30dPv24h")
  METRICS_AD_SET.add("SalesPc1d")
  METRICS_AD_SET.add("SalesAllPc1d")
  METRICS_AD_SET.add("SalesPc7d")
  METRICS_AD_SET.add("SalesAllPc7d")
  METRICS_AD_SET.add("RevenueGeneratedClientAttribution")
  METRICS_AD_SET.add("RevenueGeneratedAllClientAttribution")
  METRICS_AD_SET.add("RevenueGeneratedPc30d")
  METRICS_AD_SET.add("RevenueGeneratedAllPc30d")
  METRICS_AD_SET.add("RevenueGeneratedPv24h")
  METRICS_AD_SET.add("RevenueGeneratedAllPv24h")
  METRICS_AD_SET.add("RevenueGeneratedPc30dPv24h")
  METRICS_AD_SET.add("RevenueGeneratedAllPc30dPv24h")
  METRICS_AD_SET.add("RevenueGeneratedPc1d")
  METRICS_AD_SET.add("RevenueGeneratedAllPc1d")
  METRICS_AD_SET.add("RevenueGeneratedPc7d")
  METRICS_AD_SET.add("RevenueGeneratedAllPc7d")
  METRICS_AD_SET.add("ExposedUsers")
  METRICS_AD_SET.add("Audience")
  METRICS_AD_SET.add("Reach")
  METRICS_AD_SET.add("AverageCartClientAttribution")
  METRICS_AD_SET.add("AverageCartAllClientAttribution")
  METRICS_AD_SET.add("AverageCartPc30d")
  METRICS_AD_SET.add("AverageCartAllPc30d")
  METRICS_AD_SET.add("AverageCartPv24h")
  METRICS_AD_SET.add("AverageCartAllPv24h")
  METRICS_AD_SET.add("AverageCartPc30dPv24h")
  METRICS_AD_SET.add("AverageCartAllPc30dPv24h")
  METRICS_AD_SET.add("AverageCartPc1d")
  METRICS_AD_SET.add("AverageCartAllPc1d")
  METRICS_AD_SET.add("AverageCartPc7d")
  METRICS_AD_SET.add("AverageCartAllPc7d")
  METRICS_AD_SET.add("ClickThroughRate")
  METRICS_AD_SET.add("ConversionRateClientAttribution")
  METRICS_AD_SET.add("ConversionRateAllClientAttribution")
  METRICS_AD_SET.add("ConversionRatePc30d")
  METRICS_AD_SET.add("ConversionRateAllPc30d")
  METRICS_AD_SET.add("ConversionRatePv24h")
  METRICS_AD_SET.add("ConversionRateAllPv24h")
  METRICS_AD_SET.add("ConversionRatePc30dPv24h")
  METRICS_AD_SET.add("ConversionRateAllPc30dPv24h")
  METRICS_AD_SET.add("ConversionRatePc1d")
  METRICS_AD_SET.add("ConversionRateAllPc1d")
  METRICS_AD_SET.add("ConversionRatePc7d")
  METRICS_AD_SET.add("ConversionRateAllPc7d")
  METRICS_AD_SET.add("ECosClientAttribution")
  METRICS_AD_SET.add("ECosAllClientAttribution")
  METRICS_AD_SET.add("ECosPc30d")
  METRICS_AD_SET.add("ECosAllPc30d")
  METRICS_AD_SET.add("ECosPv24h")
  METRICS_AD_SET.add("ECosAllPv24h")
  METRICS_AD_SET.add("ECosPc30dPv24h")
  METRICS_AD_SET.add("ECosAllPc30dPv24h")
  METRICS_AD_SET.add("ECosPc1d")
  METRICS_AD_SET.add("ECosAllPc1d")
  METRICS_AD_SET.add("ECosPc7d")
  METRICS_AD_SET.add("ECosAllPc7d")
  METRICS_AD_SET.add("Cpc")
  METRICS_AD_SET.add("ECpm")
  METRICS_AD_SET.add("RoasClientAttribution")
  METRICS_AD_SET.add("RoasAllClientAttribution")
  METRICS_AD_SET.add("RoasPc30d")
  METRICS_AD_SET.add("RoasAllPc30d")
  METRICS_AD_SET.add("RoasPv24h")
  METRICS_AD_SET.add("RoasAllPv24h")
  METRICS_AD_SET.add("RoasPc30dPv24h")
  METRICS_AD_SET.add("RoasAllPc30dPv24h")
  METRICS_AD_SET.add("RoasPc1d")
  METRICS_AD_SET.add("RoasAllPc1d")
  METRICS_AD_SET.add("RoasPc7d")
  METRICS_AD_SET.add("RoasAllPc7d")
  METRICS_AD_SET.add("AdvertiserValue")
  METRICS_AD_SET.add("AdvertiserAllValue")
  METRICS_AD_SET.add("CostOfAdvertiserValue")
  METRICS_AD_SET.add("CostOfAdvertiserValueAll")
  METRICS_AD_SET.add("PostInstallSales")
  METRICS_AD_SET.add("AppInstalls")
  METRICS_AD_SET.add("PostInstallConversionRate")
  METRICS_AD_SET.add("PostInstallCostOfSale")
  METRICS_AD_SET.add("PostInstallOrderValue")
  METRICS_AD_SET.add("CostPerInstall")
  METRICS_AD_SET.add("InstallRate")
  METRICS_AD_SET.add("PostInstallCostPerOrder")
  METRICS_AD_SET.add("PostInstallRoas")
  METRICS_AD_SET.add("OmnichannelRoasClientAttribution")
  METRICS_AD_SET.add("OmnichannelRoasPc30d")
  METRICS_AD_SET.add("OmnichannelRoasAllPc30d")
  METRICS_AD_SET.add("OmnichannelRoasPv24h")
  METRICS_AD_SET.add("OmnichannelRoasAllPv24h")
  METRICS_AD_SET.add("OmnichannelRevenueClientAttribution")
  METRICS_AD_SET.add("OmnichannelRevenuePc30d")
  METRICS_AD_SET.add("OmnichannelRevenueAllPc30d")
  METRICS_AD_SET.add("OmnichannelRevenuePv24h")
  METRICS_AD_SET.add("OmnichannelRevenueAllPv24h")
  METRICS_AD_SET.add("OmnichannelsalesClientAttribution")
  METRICS_AD_SET.add("OmnichannelSalesPc30d")
  METRICS_AD_SET.add("OmnichannelSalesAllPc30d")
  METRICS_AD_SET.add("OmnichannelSalesPv24h")
  METRICS_AD_SET.add("OmnichannelSalesAllPv24h")
  METRICS_AD_SET.add("RoasOfflinePc30d")
  METRICS_AD_SET.add("RoasOfflinePv24h")
  METRICS_AD_SET.add("SalesOfflinePc30d")
  METRICS_AD_SET.add("SalesOfflinePv24h")
  METRICS_AD_SET.add("RevenueGeneratedOfflinePc30d")
  METRICS_AD_SET.add("RevenueGeneratedOfflinePv24h")
  // First of All we have to set the statisticsReportQueryMessage for our reports
  val statisticsReportQueryMessage = new StatisticsReportQueryMessage()
  // SET Parameters for StatisticsReportQueryMessage
  statisticsReportQueryMessage.setCurrency(CURRENCY)
  statisticsReportQueryMessage.setStartDate(adSetstartDate)
  statisticsReportQueryMessage.setEndDate(adSetEndDate)
  statisticsReportQueryMessage.setFormat(FILE_FORMAT)
  statisticsReportQueryMessage.setDimensions(DIMENSIONS_AD_SET)
  statisticsReportQueryMessage.setMetrics(METRICS_AD_SET)
  statisticsReportQueryMessage.setTimezone(TIME_ZONE)
  // statisticsReportQueryMessage.setAdvertiserIds("1138")

  // Placements Report Configuration
  val DIMENSIONS_PLACEMENT_LIST = new util.ArrayList[PlacementsReportQueryMessage.DimensionsEnum]()

  DIMENSIONS_PLACEMENT_LIST.add(PlacementsReportQueryMessage.DimensionsEnum.ADSETID)
  DIMENSIONS_PLACEMENT_LIST.add(PlacementsReportQueryMessage.DimensionsEnum.ADVERTISERID)
  DIMENSIONS_PLACEMENT_LIST.add(PlacementsReportQueryMessage.DimensionsEnum.PLACEMENT)
  DIMENSIONS_PLACEMENT_LIST.add(PlacementsReportQueryMessage.DimensionsEnum.ENVIRONMENT)
  DIMENSIONS_PLACEMENT_LIST.add(PlacementsReportQueryMessage.DimensionsEnum.ADSETNAME)
  DIMENSIONS_PLACEMENT_LIST.add(PlacementsReportQueryMessage.DimensionsEnum.ADVERTISERNAME)
  DIMENSIONS_PLACEMENT_LIST.add(PlacementsReportQueryMessage.DimensionsEnum.CAMPAIGNID)
  DIMENSIONS_PLACEMENT_LIST.add(PlacementsReportQueryMessage.DimensionsEnum.CAMPAIGNNAME)

  val METRICS_PLACEMENT = new util.ArrayList[String]()

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



  // Transparency/Log-Level Report  Configuration
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
