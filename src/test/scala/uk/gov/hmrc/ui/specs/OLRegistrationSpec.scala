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

import uk.gov.hmrc.ui.pages.onelogin.{OlAuthenticationPages, OlSignInSelectorPage}
import uk.gov.hmrc.ui.pages.{RegistrationPage, StubPage}

class OLRegistrationSpec extends BaseSpec with StubPage {

  private val Registration     = RegistrationPage
  private val OlSignInSelector = OlSignInSelectorPage
  private val OlAuthentication = OlAuthenticationPages
  private val env              = System.getProperty("enviornment")

  Feature("Test for /start endpoint, using stub") {

    Scenario("Authenticate a user using OneLogin") {

      Given("Load the auth stub and the details in auth stub for One Login")
      getStubUrl()
      enterAuthLoginPageDetails("One login")

      Then("Ratepayer successfully authenticated using One Login")
      Registration.authenticationSuccess()
    }
  }

  Feature("Authenticate a ratepayer using OneLogin") {
    Scenario("Authenticate a ratepayer using OneLogin") {

      Given("Ratepayer on the Register for the business rates valuation service page")
      Registration.startNow()

      And("One login option selected on selector page")
      OlSignInSelector.signInSelectorOL()

      Then("Ratepayer successfully authenticated using One Login")
      if (env == "local" || env == "staging") {
        Registration.authenticationSuccess()
      } else {
        OlAuthentication.olAuthentication("krutika.patil+11@digital.hmrc.gov.uk", "p2ssword1234")
        Registration.authenticationSuccess()
      }
    }

  }

}
