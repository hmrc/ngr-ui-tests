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
import uk.gov.hmrc.selenium.webdriver.Driver

trait StubPage extends BasePage {

  val redirect_url: String = TestEnvironment.url("ngr-login-register-frontend") + "/start"
  val authStub_url: String = TestEnvironment.url("service-name-frontend") + "/gg-sign-in"

  private val confidenceLevel = By.id("confidenceLevel")
  private val nino            = By.id("nino")
  private val authorityId     = By.id("authorityId")
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

  def IvNinoStub(): Unit = {
    headerCheck("Test Only Nino access")
    click(secondarySubmit)
  }

  def linkToHMRCRecordStub(): Unit = {
    headerCheck("We need to link your GOV.UK One Login to your HMRC records")
    click(answer)
    click(submit)
  }

  def enterNinoStub(): Unit = {
    headerCheck("Enter your National Insurance number")
    sendKeys(nino, "AA000003D")
    click(submit)
  }

  def checkNino(): Unit = {
    headerCheck("Check your National Insurance number")
    click(answer)
    click(submit)
  }

  def provideTaxReference(): Unit = {
    headerCheck("Provide your tax reference number")
    click(continue)
  }

  def confirmSAReference(): Unit = {
    headerCheck("Confirm your Self Assessment Unique Taxpayer Reference")
    click(confirmUTR)
    click(continue)
  }

  def provideNino(): Unit = {
    headerCheck("Provide your National Insurance number")
    sendKeys(ninoValue, "AA000003D")
    click(continue)
  }

  def checkYourAnswer(): Unit = {
    headerCheck("Check your answers")
    click(continue)
  }

  def complete(): Unit               = {
    headerCheck("GOV.UK One Login set up complete")
    click(submit)
  }
  def registrationSuccessful(): Unit = {
    headerCheck("Registration Successful")
    click(continue)
  }

  def stubOlAuthentication(): Unit = {
    loginStub()
    // This page will be added in the future time.
//    proveYourIdentity()
    IvStub()
  }

  def stubGgAuthentication(): Unit = {
    sendKeys(authorityId, "9900000000000101")
    selectByValue(confidenceLevel, "250")
    sendKeys(nino, "AA000003D")
    click(submitAuthStub)
    def getCurrentPageUrl: String = Driver.instance.getCurrentUrl
    println()
    println("Current Page URL: " + getCurrentPageUrl)
    if (!getCurrentPageUrl.contains("dashboard")) {
      provideTaxReference()
      confirmSAReference()
      provideNino()
      checkYourAnswer()
      registrationSuccessful()
    }
  }

}
