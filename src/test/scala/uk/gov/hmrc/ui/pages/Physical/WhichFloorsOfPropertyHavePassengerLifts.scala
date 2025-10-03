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

package uk.gov.hmrc.ui.pages.Physical

import uk.gov.hmrc.ui.pages.BasePage

object WhichFloorsOfPropertyHavePassengerLifts extends BasePage {
  def whichFloorsOfPropertyHavePassengerLiftsHeader(): Unit =
    headerCheck("Which floors of the property have passenger lifts?")

  def whichFloorsOfPropertyHavePassengerLiftsRadio(passengerLiftsFloors: String): Unit = {
    val radioCheckId = passengerLiftsFloors match {
      case "All floors have passenger lifts"          => "value_0"
      case "Some floors have passenger lifts"         => "value_1"
      case "None of the property has passenger lifts" => "value_2"
    }
    click(getElementById(radioCheckId))
  }

}
