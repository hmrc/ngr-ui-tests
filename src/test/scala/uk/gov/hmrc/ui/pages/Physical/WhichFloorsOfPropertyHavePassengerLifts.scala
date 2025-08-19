package uk.gov.hmrc.ui.pages.Physical

import uk.gov.hmrc.ui.pages.BasePage

object WhichFloorsOfPropertyHavePassengerLifts extends BasePage {
  def whichFloorsOfPropertyHavePassengerLiftsHeader(): Unit =
    headerCheck("Which floors of the property have passenger lifts?")

  def whichFloorsOfPropertyHavePassengerLiftsRadio(passengerLiftsFloors: String): Unit = {
    val radioCheckId = passengerLiftsFloors match {
      case "All floors have passenger lifts"          => "value_0"
      case "Some floors have passenger lifts"         => "value_1"
      case "None of the property has passenger lifts" => "value_2"
    }
    click(getElementById(radioCheckId))
  }

}
