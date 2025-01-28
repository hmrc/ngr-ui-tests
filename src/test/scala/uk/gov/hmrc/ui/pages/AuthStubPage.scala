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

object AuthStubPage extends BasePage {

  val redirect_url: String = TestEnvironment.url("Auth-stub-redirect-url") + "/ngr-login-register-frontend/start"
  val authStub_url: String = TestEnvironment.url("service-name-frontend") + "/gg-sign-in"

  private val redirectUrl     = By.id("redirectionUrl")
  private val confidenceLevel = By.id("confidenceLevel")
  private val nino            = By.id("nino")
  private val submitAuthStub  = By.id("submit")
  private val submit          = By.xpath("//button[@value='submit']")

  def getStubUrl()                =
    getUrl(authStub_url)
  def enterAuthLoginPageDetails() = {
    sendKeys(redirectUrl, redirect_url)
    selectByValue(confidenceLevel, "250")
    sendKeys(nino, "ER787993A")
    click(submitAuthStub)
    geElementByTagName("h1").contentEquals("Sign in to HMRC")
  }

  def loginStub() = {
    geElementByTagName("h1").contentEquals("Gov UK One Login Sign In")
    click(submit)
  }

  def IvStub() = {
    geElementByTagName("h1").contentEquals("GDS IV Sign")
    click(submit)
  }

}
