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

package uk.gov.hmrc.ui.pages.SignIn

import org.openqa.selenium.By
import uk.gov.hmrc.ui.pages.BasePage

object GGSignInPage extends BasePage {

  /** ********** GG login page **************
    */
  def ggSignIn(userId: String, password: String, accessCode: String): Unit = {
    enterUserId(userId)
    enterPassword(password)
    signInClick()
    enterAccessCode(accessCode)
    signInClick()
  }

  def signInClick(): Unit = {
    waitForElementToBeClickable(By.id("continue"))
    click(By.id("continue"))
  }

  def enterUserId(userId: String): Unit =
    sendKeys(By.id("user_id"), userId)

  def enterPassword(password: String): Unit =
    sendKeys(By.id("password"), password)

  def enterAccessCode(accessCode: String): Unit =
    sendKeys(By.id("oneTimePassword"), accessCode)

}
