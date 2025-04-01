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

package uk.gov.hmrc.ui.pages.provideTRN

import org.openqa.selenium.By
import uk.gov.hmrc.ui.pages.BasePage

object ConfirmUTRPage extends BasePage {

  val yes: By     = By.id("confirmUTR")
  val noNI: By    = By.id("confirmUTR-2")
  val noLater: By = By.id("confirmUTR-3")

  def confirmYourSAUTR(): Unit =
    headerCheck("Confirm your Self Assessment Unique Taxpayer Reference")

  def confirmUTR(utr: String): Unit = {

    val maskedUtr = getElementByCssSelector("#main-content > div > div > form > dl > div > dd")
    assert(maskedUtr == utr, "Masked TRN verification failed")

  }

  def selectYes(): Unit = {
    click(yes)
    click(continueButton)
  }

  def selectNoProvideNI(): Unit = {
    click(noNI)
    click(continueButton)
  }

  def selectNoLater(): Unit = {
    click(noLater)
    click(continueButton)
  }

}
