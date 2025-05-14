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

import uk.gov.hmrc.ui.pages.{BasePage, StubPage}

object SignInSelectorPage extends BasePage with StubPage {

  /** ********** SignInSelector page ******************
    */
  def signInSelector(): Unit   =
    headerCheck("Sign in to HMRC")
  def signInSelectorOL(): Unit = {
    click(getElementById("signInType-2"))
    waitForElementToBeClickable(continueButton)
    click(continueButton)
  }
  def signInSelectorGG(): Unit = {
    click(getElementById("signInType"))
    waitForElementToBeClickable(continueButton)
    click(continueButton)
  }
}
