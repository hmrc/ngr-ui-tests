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

package uk.gov.hmrc.ui.pages.RALD

import uk.gov.hmrc.ui.pages.BasePage

object DoYouPayExtraForParkingSpaces extends BasePage {

  def doYouPayExtraForParkingSpaces(): Unit =
    headerCheck("Do you pay extra for parking spaces or garages that are not included in your rent?")

  def selectPayExtraRadio(isPayingExtra: String): Unit = {
    val radioId = isPayingExtra.toLowerCase match {
      case "yes" => "payExtra" /*Used in renewed agreement */
      case _     => "payExtra-2" /*Used in new agreement*/
    }
    click(getElementById(radioId))
  }
}
