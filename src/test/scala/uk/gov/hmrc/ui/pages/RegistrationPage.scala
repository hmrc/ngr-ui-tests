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
  val startNowButton        = By.id("continue")
  val cookiesAcceptButton   = By.name("cookies")

//  waitForInvisibilityOfElementWithText(By.name("cookiesAccept"), "Accept analytics cookies")

  def startNow() = {

    getUrl(startPage_url)
    click(cookiesAcceptButton)
    click(startNowButton)
  }

  def authenticationSuccess() = {
//    Thread.sleep(5000)
    waitForElementInvisibility(By.tagName("h1"), "Returning you to the ‘HMRC’ service")
    val header = "Auth Details"
    headerCheck(header)
    getElementByCssSelector("p.govuk-body").contains("MY504956B")
  }
}
