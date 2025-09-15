package uk.gov.hmrc.ui.pages.Physical

import uk.gov.hmrc.ui.pages.BasePage

object AnythingElseTellUs extends BasePage {

  def anythingElseTellUsHeader(): Unit =
    headerCheck("Is there anything else you want to tell us about the changes?")

  def anythingElseTellUsRadio(anythingElseTellUs: String): Unit = {
    val radioCheckId = anythingElseTellUs match {
      case "Yes" => "value"
      case "No"  => "value-no"
    }
    click(getElementById(radioCheckId))
  }

}
