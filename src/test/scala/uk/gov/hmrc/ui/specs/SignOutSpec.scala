/*
 * Copyright 2025 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.ui.specs

import uk.gov.hmrc.ui.pages.FeedbackPage
import uk.gov.hmrc.ui.pages.SignIn.SignInSelectorPage
import uk.gov.hmrc.ui.pages.{SignOutPage, StubPage}
import uk.gov.hmrc.ui.utils.login.loginOl

class SignOutSpec extends BaseSpec with StubPage {

  Feature("Testing the Sign out functionality") {

    Scenario("Testing the Sign out functionality") {
      Given("Ratepayer logins through one login")
      loginOl()

      And("The user click on Sign out link")
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
      FeedbackPage.giveFeedbackPage()
    }
  }
}
