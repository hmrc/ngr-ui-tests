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

object CheckYourAnswer extends BasePage {

  def checkYourAnswer(): Unit =
    headerCheck("Check your answers")

  def confirmMAskedTRN(TRN: String): Unit =
    assert(
      getElementByXpath("//*[@id=\"main-content\"]/div/div/dl[2]/div/dd[1]") == TRN,
      "Masked TRN verification failed"
    )

  def sautrNoDisplay(sautr: String): Unit = {
    val display = getElementByCssSelector("#sautr-linkid")
    assert(sautr == display, "Provide your UTR")
  }
}
