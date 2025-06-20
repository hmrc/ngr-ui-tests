package uk.gov.hmrc.ui.pages.propertyLinking

import org.openqa.selenium.By
import uk.gov.hmrc.ui.pages.BasePage

object PropertyLinkingCYA extends BasePage {

  val changePropertyAddressLink = By.id("property-address")
  val changeRatepayerDate       = By.id("current-ratepayer")
  val changeBusinessRatesBill   = By.id("business-rates-bill")
  val changeEvidenceDocument    = By.id("evidence-document")

  def clickChangePropertyAddressLink(): Unit =
    click(changePropertyAddressLink)
  def clickChangeRatepayerDate(): Unit =
    click(changeRatepayerDate)
  def clickChangeBusinessRatesBill(): Unit =
    click(changeBusinessRatesBill)
  def clickChangeEvidenceDocument(): Unit =
    click(changeEvidenceDocument)

  def checkYourAnswer(): Unit =
    headerCheck("Check and confirm your details")

  def dateChangedCheck(date: String = "On or after 1 April 2026"): Unit = {
    val display = getElementByCssSelector("#when-did-you-become-the-current-ratepayer?-id")
    assert(date == display, "the date was not changed")
  }
    def addressChangedCheck(address: String = "Bug me not pvt ltd, rodley lane, rodley, leeds, BH1 1HU"): Unit = {
      val display = getElementByCssSelector("#property-to-add-to-account-id")
      assert(address == display, "the address was not changed")
    }

}
