package uk.gov.hmrc.ui.pages.provideTRN

import uk.gov.hmrc.ui.pages.BasePage

object ConfirmUTRPage extends BasePage {
  def confirmElements(): Unit = {
    getElementByCssSelector("#main-content > div > div > form > span").contentEquals("Register for the business rates valuation service")
    headerCheck("Confirm your Self Assessment Unique Taxpayer Reference")
    getElementByCssSelector("#main-content > div > div > form > p").contentEquals("We will display the last 3 digits of your Unique Taxpayer Reference (UTR). You can provide this UTR to join up the accounts you use to pay tax.")
    getElementByCssSelector("#main-content > div > div > form > dl > div > dt").contentEquals("Self Assessment Unique Taxpayer Reference")
    getElementByCssSelector("#main-content > div > div > form > div > div > div:nth-child(1) > label").contentEquals("Yes, I want to provide this UTR")
    getElementByCssSelector("#main-content > div > div > form > div > div > div:nth-child(2) > label").contentEquals("No, I want to provide my National Insurance number")
    getElementByCssSelector("#main-content > div > div > form > div > div > div:nth-child(3) > label").contentEquals("No, I will provide a tax reference number later")
    getElementByCssSelector("#continue").contains("Continue")
  }

  def confirmUTR(utr: String): Unit = getElementByCssSelector("#main-content > div > div > form > dl > div > dd").contentEquals(utr)

}