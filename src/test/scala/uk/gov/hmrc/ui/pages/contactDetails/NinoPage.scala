package uk.gov.hmrc.ui.pages.contactDetails

import org.openqa.selenium.By
import uk.gov.hmrc.ui.pages.BasePage

object NinoPage extends BasePage {

  val ninoInput:By = By.id("nino-value")

  def NinoDetails(): Unit = {
    val text = "Provide your National Insurance number"
    headerCheck(text)
  }

  def InputNino(): Unit = {
    sendKeys(ninoInput, "AA000003D")
    click(continueButton)
  }

}
