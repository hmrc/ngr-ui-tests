package uk.gov.hmrc.ui.pages.propertyLinking

import org.openqa.selenium.By
import uk.gov.hmrc.ui.pages.BasePage

object CurrentRatepayer  extends BasePage {

  def currentRatepayer(): Unit =
    headerCheck("When did you become the current ratepayer")

  def clickHelpSpan(xPath: String = "//*[@id=\"how-to-tell-if-you-are-the-current-rate-payer\"]/summary/span"): Unit = {
    click(By.xpath(xPath))
  }

  def beforeDateRadio(): Unit = {
    click(getElementById("confirm-address-radio"))
  }

  def afterDateRadio(): Unit = {
    click(getElementById("confirm-address-radio-2"))
  }

}
