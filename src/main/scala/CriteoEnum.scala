object CriteoEnum extends Enumeration {
  type MyEnum = Value
  val AdSet, Placement = Value
}

sealed trait CriteoEnum

case object AdSet extends CriteoEnum

case object Placement extends CriteoEnum

