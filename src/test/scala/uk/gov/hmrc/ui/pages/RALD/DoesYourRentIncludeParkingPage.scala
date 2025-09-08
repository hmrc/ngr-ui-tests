package uk.gov.hmrc.ui.pages.RALD

import org.openqa.selenium.By
import uk.gov.hmrc.ui.pages.BasePage
import uk.gov.hmrc.ui.pages.RALD.AgreementVerbal.headerCheck
import uk.gov.hmrc.ui.pages.RALD.RentInterimPage.{click, noRadioButton, yesRadioButton}

object DoesYourRentIncludeParkingPage extends BasePage {

  private val yesRadioButton = By.id("doesYourRentIncludeParking-radio-value")
  private val noRadioButton  = By.id("doesYourRentIncludeParking-radio-value-2")

  def doesYourRentIncludeParking(): Unit =
    headerCheck("Does your rent include parking spaces or garages?")

  def yesRadio(): Unit =
    click(yesRadioButton)

  def noRadio(): Unit =
    click(noRadioButton)

}
