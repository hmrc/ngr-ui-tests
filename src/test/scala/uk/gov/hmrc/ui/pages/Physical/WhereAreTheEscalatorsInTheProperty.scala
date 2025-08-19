package uk.gov.hmrc.ui.pages.Physical

import uk.gov.hmrc.ui.pages.BasePage

object WhereAreTheEscalatorsInTheProperty extends BasePage {
  def whereAreTheEscalatorsInThePropertyHeader(): Unit =
    headerCheck("Where are escalators in the property?")

  def whereAreTheEscalatorsInThePropertyRadio(escalators: String): Unit = {
    val radioCheckId = escalators match {
      case "There are escalators between all floors"  => "value_0"
      case "There are escalators between some floors" => "value_1"
      case "None of the property has escalators"      => "value_2"
    }
    click(getElementById(radioCheckId))
  }

}
