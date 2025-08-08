package uk.gov.hmrc.ui.pages.RALD

import uk.gov.hmrc.ui.pages.BasePage


object AgreedRentChange extends BasePage{

  def AgreedRentChange(): Unit =
    headerCheck("Have you agreed in advance with the landlord when and by how much rent goes up?")

  def YesRadio(): Unit = {
    click(getElementById("agreed-rent-change-radio"))
    ContinueButtonClick()
  }

  def NoRadio(): Unit = {
    click(getElementById("agreed-rent-change-radio-2"))
    ContinueButtonClick()
  }
}
