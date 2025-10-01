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

import uk.gov.hmrc.ui.pages.Registration.contactDetails.ConfirmContactDetailsPage.ConfirmContactDetails
import uk.gov.hmrc.ui.pages.Registration.contactDetails.PhoneNumberPage
import uk.gov.hmrc.ui.pages.SignIn.{GGSignInPage, SignInSelectorPage}
import uk.gov.hmrc.ui.pages.{StartNowPage, StubPage}
import uk.gov.hmrc.ui.utils.mongo.RegistrationDB

class RatepayerGGSignInSpec extends BaseSpec with StubPage {

  private val StartNow   = StartNowPage
  private val GgSelector = SignInSelectorPage
  private val GgSignIn   = GGSignInPage
  private val env        = System.getProperty("environment")

  Feature("Authenticate a ratepayer using Government Gateway") {
    RegistrationDB.cleanup()
    Scenario("Authenticate a ratepayer using Government Gateway") {

      Given("Ratepayer on the Register for the business rates valuation service page")
      StartNow.startNow()

      And("Government Gateway option selected on selector page")
      GgSelector.signInSelectorGG()

      Then("Ratepayer authenticate using GG")
      if (env == "local" || env == "staging") {
        stubGgAuthentication()
      } else {
        GgSignIn.ggSignIn("15 83 51 32 56 07", "p2ssword1234", "123456")
      }

      Then("User provide phone number")
      PhoneNumberPage.userProvidesPhoneNumber()

      Then("Ratepayer successfully authenticated navigated to contact details page ")
      ConfirmContactDetails()
    }
  }
}
