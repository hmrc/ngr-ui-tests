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

import uk.gov.hmrc.ui.pages.Registration.{PhoneNumberPage, ProvideTRNPage}
import uk.gov.hmrc.ui.pages.SignIn.{OLAuthenticationPages, SignInSelectorPage}
import uk.gov.hmrc.ui.pages.{StartNowPage, StubPage}
import uk.gov.hmrc.ui.utils.mongo.RegistrationDB
class RatePayerOLSignInSpec extends BaseSpec with StubPage {

  private val StartNow         = StartNowPage
  private val OlSignInSelector = SignInSelectorPage
  private val OlAuthentication = OLAuthenticationPages
  private val env              = System.getProperty("environment")

  Feature("Authenticate a ratepayer using OneLogin") {
    RegistrationDB.cleanup()
    Scenario("Authenticate a ratepayer using OneLogin") {

      Given("Ratepayer obtains the centralised-auth private beta cookies")
      OLAuthenticationPages.betaPageStep()

      Given("Ratepayer on the Register for the business rates valuation service page")
      StartNow.startNow()

      When("One login option selected on selector page")
      OlSignInSelector.signInSelectorOL()

      And("Ratepayer authenticate using One Login")
      if (env == "local" || env == "staging") {
        stubOlAuthentication(env)
      } else {
        OlAuthentication.olAuthentication("krutika.patil+11@digital.hmrc.gov.uk", "p2ssword1234")
      }

      Then("User provide phone number")
      PhoneNumberPage.userProvidesPhoneNumber()

      Then("Ratepayer successfully authenticated navigated to Provide TRN Page")
      ProvideTRNPage.provideYourTRN()
    }

  }

}
