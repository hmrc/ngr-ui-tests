package uk.gov.hmrc.ui.pages.RALD
import uk.gov.hmrc.ui.pages.BasePage
object HaveYouAgreedInAdvanceRentChanges extends BasePage {

  def haveYouAgreedInAdvanceRentChanges(): Unit =
    headerCheck("Have you agreed in advance with the landlord when and by how much rent goes up?")

  def yesRadio(): Unit =
    click(getElementById("agreed-rent-change-radio"))

  def noRadio(): Unit =
    click(getElementById("agreed-rent-change-radio-2"))
}
