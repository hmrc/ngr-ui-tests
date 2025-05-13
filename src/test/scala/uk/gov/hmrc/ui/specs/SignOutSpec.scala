package uk.gov.hmrc.ui.specs

import uk.gov.hmrc.ui.pages.SignIn.SignInSelectorPage
import uk.gov.hmrc.ui.pages.{SignOutPage, StubPage}
import uk.gov.hmrc.ui.utils.login.loginOl

class SignOutSpec extends BaseSpec with StubPage {

  Feature("Testing the Sign out functionality"){

    Scenario("Testing the Sign out functionality"){
      Given("Ratepayer logins through one login")
      loginOl()

      And("The user cl;ick on Sign out link")
      clickLink("Sign out")

      Then("The user navigated to 'You have signed out' page")
      SignOutPage.signOut()
    }

    Scenario("Testing 'Sign in' link from Signed out page") {
        Given("Ratepayer logins through one login")
        loginOl()

        And("The user navigated to 'You have signed out' page after clicking on Sign out link")
        clickLink("Sign out")
        SignOutPage.signOut()

        When("the user click on 'Sign in to the service' link")
        clickLink("Sign in to the service")

        Then("The user navigated to 'sign in to HMRC' page")
        SignInSelectorPage.signInSelector()
      }

    Scenario("Testing 'short survey' link from Signed out page") {

      Given("The ratepayer logins through one login")
      loginOl()

      And("The ratepayer Sign out and click on survey link")
      clickLink("Sign out")
      clickLink("Take a short survey")

      Then("The ratepayer navigated to give feedback page")



    }


    }


}
