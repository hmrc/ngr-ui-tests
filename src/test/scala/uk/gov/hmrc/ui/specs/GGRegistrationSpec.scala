/*
 * Copyright 2024 HM Revenue & Customs
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

import uk.gov.hmrc.ui.pages.GG.{GgSignInPage, signInSelectorPage}
import uk.gov.hmrc.ui.pages.{RegistrationPage, StubPage}

class GGRegistrationSpec extends BaseSpec with StubPage {

  private val Registration = RegistrationPage
  private val GgSelector   = signInSelectorPage
  private val GgSignIn     = GgSignInPage
  private val env          = System.getProperty("enviornment")

  /*Feature("Authenticate user using stub, test for /start endpoint ") {

    Scenario("Authenticate a user using Government Gateway") {

      Given("Load the auth stub and the details in auth stub for One Login")
      getStubUrl()
      enterAuthLoginPageDetails("Government Gateway")

      Then("Ratepayer successfully authenticated using Government Gateway")
      Registration.AuthenticationSuccess()
    }
  }*/

  Feature("Authenticate a ratepayer using Government Gateway") {
    Scenario("Authenticate a ratepayer using Government Gateway") {

      Given("Ratepayer on the Register for the business rates valuation service page")
      Registration.startNow()

      And("Government Gateway option selected on selector page")
      GgSelector.signInSelectorGG()

      Then("Ratepayer successfully authenticated")
      if (env == "qa") GgSignIn.ggSignIn()

    }
  }
}
