package uk.gov.hmrc.ui.pages.Physical

import uk.gov.hmrc.ui.pages.BasePage

object WhichInternalFeatureHaveChanged extends BasePage {
  def whichInternalFeatureHaveChangedHeader(): Unit =
    headerCheck("Which internal feature have you changed?")

  def whichInternalFeatureHaveChangedRadio(whichInternalFeature: String): Unit = {
    val radioCheckId = whichInternalFeature match {
      case "Air conditioning"       => "value_0"
      case "Escalators"             => "value_1"
      case "Goods lifts"            => "value_2"
      case "Passenger lifts"        => "value_3"
      case "Security cameras"       => "value_4"
      case "Other internal feature" => "value_5"
    }
    click(getElementById(radioCheckId))
  }
  def selectOtherFeatures(feature: String): Unit                               = {
    whichInternalFeatureHaveChangedRadio("value_5")
    selectDropdownByValue("other-select", feature)
  }
}
