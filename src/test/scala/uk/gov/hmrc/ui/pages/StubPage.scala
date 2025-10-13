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

package uk.gov.hmrc.ui.pages

import org.openqa.selenium.By
import uk.gov.hmrc.configuration.TestEnvironment

trait StubPage extends BasePage {

  val redirect_url: String = TestEnvironment.url("ngr-login-register-frontend") + "/start"
  val authStub_url: String = TestEnvironment.url("service-name-frontend") + "/gg-sign-in"

  private val confidenceLevel = By.id("confidenceLevel")
  private val nino            = By.id("nino")
  private val ninoValue       = By.id("nino-value")
  private val submitAuthStub  = By.id("submit")
  private val continue        = By.id("continue")
  private val submit          = By.xpath("//button[@value='submit']")
  private val secondarySubmit = By.xpath("//button[@value='submit'][2]")
  private val answer          = By.id("answer")
  private val confirmUTR      = By.id("confirmUTR-2")

  def getStubUrl(): Unit =
    getUrl(authStub_url)
  def loginStub(): Unit  = {
    val text = "Gov UK One Login Sign In"
    headerCheck(text)
    click(submit)
  }

  def proveYourIdentity(): Unit = {
    headerCheck("You need to prove your identity")
    click(continueButton)
  }

  def IvStub(): Unit = {
    headerCheck("GDS IV Sign")
    click(submit)
  }

  def stubOlAuthentication(): Unit = {
    loginStub()
    // This page will be added in the future time.
//    proveYourIdentity()
    IvStub()
  }

  def stubGgAuthentication(): Unit = {
    selectByValue(confidenceLevel, "250")
    sendKeys(nino, "AA000003D")
    click(submitAuthStub)
    provideTaxReference()
    confirmSAReference()
    provideNino()
    checkYourAnswer()
    registrationSuccessful()

  }

}
