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

object DoYouHaveRentFreePeriod extends BasePage {

  def doYouHaveRentFreePeriod(): Unit =
    headerCheck("Do you have a rent-free period at the start of your agreement?")

  def selectRentFreePeriodRadio(isRentFree: String): Unit = {
    val radioId = isRentFree.toLowerCase match {
      case "yes" => "check-rent-period-radio" /*Used in renewed agreement */
      case _     => "check-rent-period-radio-2" /*Used in new agreement*/
    }
    click(getElementById(radioId))
  }
}
