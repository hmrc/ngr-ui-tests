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

object WhichInternalFeatureHaveChanged extends BasePage {
  def whichInternalFeatureHaveChangedHeader(): Unit =
    headerCheck("Which internal feature have you changed?")

  def whichInternalFeatureHaveChangedRadio(whichInternalFeature: String): Unit = {
    val radioCheckId = whichInternalFeature match {
      case "Air conditioning"       => "value_0"
      case "Escalators"             => "value_1"
      case "Goods lifts"            => "value_2"
      case "Passenger lifts"        => "value_3"
      case "Security cameras"       => "value_4"
      case "Other internal feature" => "value_5"
    }
    click(getElementById(radioCheckId))
  }
  def selectOtherFeatures(feature: String): Unit                               = {
    whichInternalFeatureHaveChangedRadio("Other internal feature")
    val dropdown = getElementById("other-select")
    selectByValue(dropdown, feature)
  }
}
