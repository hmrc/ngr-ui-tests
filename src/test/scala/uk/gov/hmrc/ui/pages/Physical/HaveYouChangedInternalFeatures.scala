package uk.gov.hmrc.ui.pages.Physical

import uk.gov.hmrc.ui.pages.BasePage

object HaveYouChangedInternalFeatures extends BasePage {
  def changedInternalFeatureHeader(): Unit =
    headerCheck("Have you changed internal features?")

  def changedInternalFeatureRadio(changedInternalFeature: String): Unit = {
    val radioCheckId = changedInternalFeature match {
      case "Yes" => "value"
      case "No"  => "value-no"
    }
    click(getElementById(radioCheckId))
    click(continueButton)
  }

}
