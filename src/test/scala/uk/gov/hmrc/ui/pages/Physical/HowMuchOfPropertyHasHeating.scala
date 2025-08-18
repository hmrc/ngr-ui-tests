package uk.gov.hmrc.ui.pages.Physical

import uk.gov.hmrc.ui.pages.BasePage

object HowMuchOfPropertyHasHeating extends BasePage {
  def howMuchOfPropertyHasHeatingHeader(): Unit =
    headerCheck("How much of the property has heating?")

  def howMuchOfPropertyHasHeatingRadio(heating: String): Unit = {
    val radioCheckId = heating match {
      case "All of the property has heating"  => "value_0"
      case "Some of the property has heating" => "value_1"
      case "None of the property has heating" => "value_2"
    }
    click(getElementById(radioCheckId))
  }
}
