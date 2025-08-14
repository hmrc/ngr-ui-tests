package uk.gov.hmrc.ui.pages.Physical

import uk.gov.hmrc.ui.pages.BasePage
import uk.gov.hmrc.ui.pages.Physical.AboutChangeToUseOfSpace.headerCheck

object HaveYouChangedUseOfSpace extends BasePage {

  def changedUseOfSpaceHeader(): Unit =
    headerCheck("Have you changed use of space?")

  // Have you changed use of space? Radio button selection

  def changedUseOfSpaceRadio(ChangedUseOfSpace: String): Unit = {
    val radioCheckId = ChangedUseOfSpace match {
      case "Yes" => "value"
      case "No"  => "value-no"
    }
    click(getElementById(radioCheckId))
    click(continueButton)
  }
}
