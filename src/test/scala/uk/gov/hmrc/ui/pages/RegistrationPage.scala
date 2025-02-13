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

import org.openqa.selenium.By
import uk.gov.hmrc.configuration.TestEnvironment

object RegistrationPage extends BasePage {

  val startPage_url: String = TestEnvironment.url("ngr-login-register-frontend") + "/register"
  val startNow              = By.id("continue")

  def StartNow() = {

    getUrl(startPage_url)
    click(startNow)
  }

  def AuthenticationSuccess() = {
    val elementText  = geElementByTagName("h1")
    val expectedText = "Auth Details"
    assert(elementText == expectedText)
    getElementByCssSelector("p.govuk-body").contains("ER787993A")
  }
}
