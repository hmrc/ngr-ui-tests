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

import uk.gov.hmrc.ui.pages.StartNowPage.startNow
import uk.gov.hmrc.ui.pages.SignIn.OLAuthenticationPages.olAuthentication
import uk.gov.hmrc.ui.pages.SignIn.SignInSelectorPage.{signInSelectorOL, stubOlAuthentication}

object login {

  private val env     = System.getProperty("environment")
  def loginOl(): Unit = {
    startNow()
    signInSelectorOL()
    if (env == "local" || env == "staging") {
      stubOlAuthentication()
    } else {
      olAuthentication("krutika.patil+11@digital.hmrc.gov.uk", "p2ssword1234")
    }
  }
}
