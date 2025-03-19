package uk.gov.hmrc.ui.specs

import org.openqa.selenium.By
import uk.gov.hmrc.ui.pages.StubPage
import uk.gov.hmrc.ui.pages.contactDetails.ConfirmContactDetailsPage
import uk.gov.hmrc.ui.pages.provideTRN.{ConfirmUTRPage, ProvideTRNPage}
import uk.gov.hmrc.ui.utils.login.loginOl

class ProvideTRNSpec extends BaseSpec with StubPage{
  Feature("Test for Provide TRN and Confirm UTR") {
    Scenario("Navigate to ProvideTRN page through journey") {
      Given("Ratepayer logins through one login")
      loginOl()

      Then("Ratepayer is taken to the Confirm Contact Details page")
      ConfirmContactDetailsPage.ConfirmContactDetails()
      click(By.id("continue"))

      Then("Ratepayer is taken to Provide TRN Page")
      ProvideTRNPage.confirmElements()
      click(By.id("continue"))

      Then("Ratepayer is taken to ConfirmUTR Page")
      ConfirmUTRPage.confirmElements()
      ConfirmUTRPage.confirmUTR("*******333")
    }
  }
}
