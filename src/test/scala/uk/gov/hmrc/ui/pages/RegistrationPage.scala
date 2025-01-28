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

package uk.gov.hmrc.ui.pages

object RegistrationPage extends BasePage {

  def SignInSelector(signIn: String): Unit = {
    geElementByTagName("h1").contentEquals("Sign in to HMRC")
    signIn match {
      case "One login"          => click(getElementById("signInType"))
      case "Government Gateway" => click(getElementById("signInType"))
      case _                    => print("did not match any of the expected value")
    }
    click(continueButton)
  }
  def AuthenticationSuccess()              = {
    getTitle.contentEquals("ngr-login-register-frontend")
    geElementByTagName("h1").contentEquals("Auth Details")
    getElementByCssSelector("p.govuk-body").contains("ER787993A")
  }
}
