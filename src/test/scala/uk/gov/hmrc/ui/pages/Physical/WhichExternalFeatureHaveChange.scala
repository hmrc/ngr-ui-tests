package uk.gov.hmrc.ui.pages.Physical

import uk.gov.hmrc.ui.pages.BasePage

object WhichExternalFeatureHaveChange extends BasePage {
  def whichInternalFeatureHaveChangedHeader(): Unit =
    headerCheck("Which external feature have you changed?")

  def whichExternalFeatureHaveChangedRadio(whichExternalFeature: String): Unit = {
    val radioCheckId = whichExternalFeature match {
      case "Loading bays"           => "value_0"
      case "Lock-up garages"        => "value_1"
      case "Outdoor seating"        => "value_2"
      case "Parking"                => "value_3"
      case "Solar panels"           => "value_4"
      case "Other external feature" => "value_5"
    }
    click(getElementById(radioCheckId))
  }
  def selectOtherExternalFeatures(feature: String): Unit                       = {
    whichExternalFeatureHaveChangedRadio("Other external feature")
    val dropdown = getElementById("other-select")
    selectByValue(dropdown, feature)
  }

}
