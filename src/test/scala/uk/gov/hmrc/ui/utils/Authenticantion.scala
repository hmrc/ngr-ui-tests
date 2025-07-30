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

package uk.gov.hmrc.ui.utils

import org.openqa.selenium.By
import uk.gov.hmrc.ui.pages.SignIn.GGSignInPage.ggSignIn
import uk.gov.hmrc.ui.pages.SignIn.OLAuthenticationPages.{betaPageStep, olAuthentication}
import uk.gov.hmrc.ui.pages.SignIn.SignInSelectorPage.{getElementByTagName, reloadPage, signInSelectorGG, signInSelectorOL, stubGgAuthentication, waitForElementToBeClickable}
import uk.gov.hmrc.ui.pages.StartNowPage.startNow

object login {

  private val env     = System.getProperty("environment")
  def loginOl(): Unit = {
    betaPageStep()
    reloadPage()
    startNow()
    reloadPage()
    signInSelectorOL()
    if ("GDS IV Sign" == getElementByTagName("h1")) {
      waitForElementToBeClickable(By.name("submit"))
    }
  }

  def loginGg(): Unit = {
    startNow()
    signInSelectorGG()
    if (env == "local" || env == "staging") {
      stubGgAuthentication()
    } else {
      ggSignIn("15 83 51 32 56 07", "p2ssword1234", "123456")
    }
  }
}
