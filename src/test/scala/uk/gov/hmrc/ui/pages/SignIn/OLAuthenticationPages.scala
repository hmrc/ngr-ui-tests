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
import uk.gov.hmrc.configuration.TestEnvironment
import uk.gov.hmrc.ui.pages.BasePage
import uk.gov.hmrc.ui.pages.StartNowPage.{getUrl, startPage_url}
import uk.gov.hmrc.ui.utils.TotpGenerator.getTotpCode

object OLAuthenticationPages extends BasePage {

  private val betaPage_url: String       = TestEnvironment.url("centralised-authorisation-server") + "/join-private-beta"
  private val accept                     = By.id("continue")
  private val continue                   = By.xpath("//button[@type='Submit']")
  private val continueTotheServiceButton = By.id("submitButton")

  def betaPageStep() = {
    getUrl(betaPage_url)
    waitForElementToBeClickable(accept).click()
  }

  def signInClick(): Unit = {
    waitForElementToBeClickable(By.id("sign-in-button"))
    click(By.id("sign-in-button"))
  }

  def enterEmail(email: String): Unit = {
    sendKeys(By.id("email"), email)
    waitForElementToBeClickable(continue)
    click(continue)
  }

  def enterPassword(password: String): Unit = {
    sendKeys(By.id("password"), password)
    waitForElementToBeClickable(continue)
    click(continue)
  }

  def enterMfaCode(): Unit = {
    val secret = "LIL54VSU56D5FNTM7PU373B3QC6HPWZ3"
    sendKeys(By.id("code"), getTotpCode(secret))
    waitForElementToBeClickable(continue)
    click(continue)
  }

  def approvedIdentity(): Unit = {
    waitForElementToBeClickable(continueTotheServiceButton)
    click(continueTotheServiceButton)
  }

  def returningToService(): Unit =
    waitForElementInvisibility(By.tagName("h1"), "Returning you to the ‘HMRC’ service")

  def olAuthentication(email: String, password: String): Unit = {
    signInClick()
    enterEmail(email)
    enterPassword(password)
    enterMfaCode()
    approvedIdentity()
    returningToService()

  }
}
