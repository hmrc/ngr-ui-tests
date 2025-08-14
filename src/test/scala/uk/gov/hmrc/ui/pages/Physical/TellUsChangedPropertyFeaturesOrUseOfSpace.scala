package uk.gov.hmrc.ui.pages.Physical

import uk.gov.hmrc.ui.pages.BasePage

object TellUsChangedPropertyFeaturesOrUseOfSpace extends BasePage {
  def tellUsChangedPropertyFeature(): Unit =
    headerCheck("Tell us you changed property features or use of space")
    click(continueButton)

}
