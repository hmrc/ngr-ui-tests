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
import uk.gov.hmrc.ui.pages.RALD.RentPeriods.{click, getElementById}

object RepairsAndInsurancePage extends BasePage {

  def repairsAndInsurance(): Unit =
    headerCheck("Repairs and insurance")

  def whoPaysForInternalRepairsRadio(person: String): Unit = {
    val radioId = person.toLowerCase match {
      case "You"          => "repairsAndInsurance-internalRepairs-radio-value"
      case "The landlord" => "repairsAndInsurance-internalRepairs-radio-value-2"
      case _              => "repairsAndInsurance-internalRepairs-radio-value-3"
    }
    click(getElementById(radioId))
  }

  def whoPaysForExternalRepairsRadio(person: String): Unit = {
    val radioId = person.toLowerCase match {
      case "You"          => "repairsAndInsurance-externalRepairs-radio-value"
      case "The landlord" => "repairsAndInsurance-externalRepairs-radio-value-2"
      case _              => "repairsAndInsurance-externalRepairs-radio-value-3"
    }
    click(getElementById(radioId))
  }

  def WhoPaysForBuildingInsuranceRepairs(person: String): Unit = {
    val radioId = person.toLowerCase match {
      case "You"          => "repairsAndInsurance-buildingInsurance-radio-value"
      case "The landlord" => "repairsAndInsurance-buildingInsurance-radio-value-2"
      case _              => "repairsAndInsurance-buildingInsurance-radio-value-3"
    }
    click(getElementById(radioId))
  }
}
