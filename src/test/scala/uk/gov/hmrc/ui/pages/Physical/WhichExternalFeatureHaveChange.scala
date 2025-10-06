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

object WhichExternalFeatureHaveChange extends BasePage {
  def whichInternalFeatureHaveChangedHeader(): Unit =
    headerCheck("Which external feature have you changed?")

  def whichExternalFeatureHaveChangedRadio(whichExternalFeature: String): Unit = {
    val radioCheckId = whichExternalFeature match {
      case "Loading bays"           => "value_0"
      case "Lock-up garages"        => "value_1"
      case "Outdoor seating"        => "value_2"
      case "Parking"                => "value_3"
      case "Solar panels"           => "value_4"
      case "Other external feature" => "value_5"
    }
    click(getElementById(radioCheckId))
  }
  def selectOtherExternalFeatures(feature: String): Unit                       = {
    whichExternalFeatureHaveChangedRadio("Other external feature")
    val dropdown = getElementById("other-select")
    selectByValue(dropdown, feature)
  }

}
