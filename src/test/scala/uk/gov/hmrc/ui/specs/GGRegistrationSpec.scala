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

import uk.gov.hmrc.ui.pages.{GGPage, OneLoginPage, RegistrationPage, StubPage}

class GGRegistrationSpec extends BaseSpec {

  private val Stub         = StubPage
  private val Registration = RegistrationPage
  private val OneLogin = OneLoginPage
  private val GG = GGPage


 /* Feature("Authenticate a VOA user") {
    Scenario("Authenticate a user using OneLogin") {

      Given("Given load the auth stub")
      Stub.getStubUrl()

      When("Enter the details in auth stub for One Login")
      Stub.enterAuthLoginPageDetails("One login")

      And("I select One login on selector page")
      OneLogin.SignInSelector("One login")
      Stub.loginStub()
      Stub.IvStub()

      Then("Ratepayer successfully authenticated using one login")
      Registration.AuthenticationSuccess()
    }

    Scenario("Authenticate a user using Government Gateway") {

      Given("Given load the auth stub")
      Stub.getStubUrl()

      When("Enter the details in auth stub for One Login")
      Stub.enterAuthLoginPageDetails("Government Gateway")

      Then("Ratepayer successfully authenticated using Government Gateway")
      Registration.AuthenticationSuccess()
    }
  }*/

  Feature("Test for the page: Register for the business rates valuation service") {
    Scenario("Authenticate a user using OneLogin") {

      Given("I'm on the Register for the business rates valuation service page")
      Registration.StartNow()

      And("I select One login on selector page")
      GG.SignInSelectorGG()


      Then("Ratepayer successfully authenticated")
      Registration.AuthenticationSuccess()
    }

  }
}
