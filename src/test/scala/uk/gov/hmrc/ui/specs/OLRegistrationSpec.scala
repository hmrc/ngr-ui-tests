package uk.gov.hmrc.ui.specs

import org.scalactic.Or
import uk.gov.hmrc.ui.pages.{OneLoginPage, RegistrationPage, StubPage}

class OLRegistrationSpec extends BaseSpec {

  private val Stub         = StubPage
  private val Registration = RegistrationPage
  private val OneLogin = OneLoginPage

  Feature("Test for the page: Register for the business rates valuation service") {
    Scenario("Authenticate a user using OneLogin") {

      Given("I'm on the Register for the business rates valuation service page")
      Registration.StartNow()

      And("I select One login on selector page")
        OneLogin.SignInSelectorOL()
        if (System.getProperty("enviornment") == "local" || System.getProperty("enviornment") == "staging") {
          Stub.loginStub()
          Stub.IvStub()
        }

      Then("Ratepayer successfully authenticated")
      Registration.AuthenticationSuccess()
    }
  }

}
