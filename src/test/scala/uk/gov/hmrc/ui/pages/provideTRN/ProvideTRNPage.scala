package uk.gov.hmrc.ui.pages.provideTRN

import uk.gov.hmrc.ui.pages.BasePage

object ProvideTRNPage extends BasePage {
  def confirmElements(): Unit = {
    getElementByCssSelector("#main-content > div > div > form > span").contentEquals("Register for the business rates valuation service")
    headerCheck("Provide your Tax Reference Number")
    getElementByCssSelector("#main-content > div > div > form > p:nth-child(4)").contentEquals("Your Tax Reference Number (TRN) is used to match your tax data with your property data. This information helps the government provide targeted support and improve business rates compliance.")
    getElementByCssSelector("#main-content > div > div > form > h2").contentEquals("Types of Tax Reference Numbers")
    getElementByCssSelector("#main-content > div > div > form > p:nth-child(6)").contentEquals("The type of TRN you provide will depend on whether you are paying business rates as an individual or organisation.")
    getElementByCssSelector("#main-content > div > div > form > p:nth-child(7)").contentEquals("Individual rate payers can provide either:")
    getElementByCssSelector("#main-content > div > div > form > ul > li:nth-child(1)").contentEquals("Self-assessment Unique Tax Reference (UTR)")
    getElementByCssSelector("#main-content > div > div > form > ul > li:nth-child(2)").contentEquals("National Insurance number (NINO)")
    getElementByCssSelector("#main-content > div > div > form > p:nth-child(9)").contentEquals("It is a legal requirement to provide a TRN. While you can provide one later, we advise you to do so as soon as possible.")
    getElementByCssSelector("#continue").contains("Continue")
  }
}
