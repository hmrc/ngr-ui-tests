package uk.gov.hmrc.ui.pages.Physical

import uk.gov.hmrc.ui.pages.BasePage

object HowMuchOfPropertyHasAirConditioning extends BasePage {
  def howMuchOfPropertyHasAirConditioningHeader(): Unit =
    headerCheck("How much of the property has air conditioning?")

  def howMuchAirConditioningRadio(airConditioning: String): Unit = {
    val radioCheckId = airConditioning match {
      case "All of the property has air conditioning"  => "value_0"
      case "Some of the property has air conditioning" => "value_1"
      case "None of the property has air conditioning" => "value_2"
    }
    click(getElementById(radioCheckId))
  }

}
