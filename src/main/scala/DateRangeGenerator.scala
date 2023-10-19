object MyEnum extends Enumeration {
  type MyEnum = Value
  val AdSet, Placement = Value
}

import MyEnum._

import java.time.OffsetDateTime

case class DateRange(start_date: OffsetDateTime, end_date: OffsetDateTime)

object DateRangeGenerator {
  def generateDateRange(enum: MyEnum): DateRange = {
    val now = OffsetDateTime.now()
    val start_date = enum match {
      case AdSet => now.minusYears(1)
      case Placement => now.minusYears(1)
      case _ => throw new IllegalArgumentException("Invalid enum type")
    }
    val end_date = now

    DateRange(start_date, end_date)
  }

  def main(args: Array[String]): Unit = {
    val dateRangeAdSet = generateDateRange(AdSet)
    val dateRangePlacement = generateDateRange(Placement)

    println("Date Range for AdSet:")
    println(s"Start Date: ${dateRangeAdSet.start_date}")
    println(s"End Date: ${dateRangeAdSet.end_date}")

    println("\nDate Range for Placement:")
    println(s"Start Date: ${dateRangePlacement.start_date}")
    println(s"End Date: ${dateRangePlacement.end_date}")
  }
}