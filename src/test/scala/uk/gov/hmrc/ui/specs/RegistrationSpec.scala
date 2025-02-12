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

import uk.gov.hmrc.ui.pages.{AuthStubPage, RegistrationPage}

class RegistrationSpec extends BaseSpec {

  private val AuthStub     = AuthStubPage
  private val Registration = RegistrationPage

  Feature("Authenticate a VOA user") {
    Scenario("Authenticate a user using OneLogin") {

      Given("Given load the auth stub")
      AuthStub.getStubUrl()

      When("Enter the details in auth stub for One Login")
      AuthStub.enterAuthLoginPageDetails("One login")

      And("I select One login on selector page")
      Registration.SignInSelector("One login")
      AuthStub.loginStub()
      AuthStub.IvStub()

      Then("Ratepayer successfully authenticated")
      Registration.AuthenticationSuccess()
    }

    Scenario("Authenticate a user using Government Gateway") {

      Given("Given load the auth stub")
      AuthStub.getStubUrl()

      When("Enter the details in auth stub for One Login")
      AuthStub.enterAuthLoginPageDetails("Government Gateway")

      Then("Ratepayer successfully authenticated")
      Registration.AuthenticationSuccess()
    }
  }

}
