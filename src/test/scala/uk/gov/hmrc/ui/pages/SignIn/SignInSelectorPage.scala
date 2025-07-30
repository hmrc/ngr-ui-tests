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

import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.{By, JavascriptExecutor, WebDriver}
import uk.gov.hmrc.ui.pages.SignIn.OLAuthenticationPages.betaPageStep
import uk.gov.hmrc.ui.pages.StartNowPage.{headerCheck, startNow}
import uk.gov.hmrc.ui.pages.registration.contactDetails.PhoneNumberPage.headerCheck
import uk.gov.hmrc.ui.pages.{BasePage, StubPage}
import uk.gov.hmrc.ui.utils.login.loginOl

import scala.concurrent.duration.Duration

object SignInSelectorPage extends BasePage with StubPage {

  /** ********** SignInSelector page ******************
    */
  def signInSelector(): Unit =
    headerCheck("Sign in to HMRC")

  def signInSelectorOL(): Unit = {
    reloadPage()
    reloadPage()
    reloadPage()
    if ("GDS IV Sign" == getElementByTagName("h1")) {
      waitForElementToBeClickable(By.name("submit"))
    } else if ("Sign in to HMRC" == getElementByTagName("h1")) {
      headerCheck("Sign in to HMRC")
      click(By.id("signInType-2"))
      waitForElementToBeClickable(By.id("continue")).click()
      waitForElementToBeClickable(By.name("submit")).click()
      waitForElementToBeClickable(By.name("submit")).click()
    } else {
      waitForElementToBeClickable(By.name("submit")).click()
    }
  }

  def signInSelectorGG(): Unit = {
    click(getElementById("signInType"))
    waitForElementToBeClickable(continueButton).click()
    waitForElementToBeClickable(continueButton).click()
  }
}
