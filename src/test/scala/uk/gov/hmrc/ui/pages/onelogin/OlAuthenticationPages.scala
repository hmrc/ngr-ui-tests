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

package uk.gov.hmrc.ui.pages.onelogin

import org.openqa.selenium.By
import uk.gov.hmrc.ui.pages.BasePage

object OlAuthenticationPages extends BasePage {

  private val continue = By.xpath("//button[@type='Submit']")

  def signInClick(): Unit = {
    val header = "Create your GOV.UK One Login or sign in"
    headerCheck(header)
    click(By.id("sign-in-button"))
  }

  def enterEmail(email: String) = {
    val header = "Enter your email address to sign in to your GOV.UK One Login"
    headerCheck(header)
    sendKeys(By.id("email"), email)
    click(continue)
  }

  def enterPassword(password: String) = {
    sendKeys(By.id("password"), password)
    click(continue)
  }

}
