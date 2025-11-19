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

import uk.gov.hmrc.ui.pages.RALD.AdditionalRentPeriodPage.periodSequence
import uk.gov.hmrc.ui.pages.SignOutPage.continueButtonClick
import uk.gov.hmrc.ui.specs.BaseSpec

object AddingAdditionalRentPeriodScenario extends BaseSpec {

  def addingRentPeriod(
    day: String,
    month: String,
    year: String,
    rentAmount: String,
    sequence: Int,
    hasMorePeriod: String
  ) {
    When(s"The user provides the end date for the ${periodSequence.getOrElse(sequence, "").toLowerCase()} rent period")
    AdditionalRentPeriodPage.additionalRentPeriod(sequence)
    AdditionalRentPeriodPage.additionalRentPeriodEndDate(day, month, year)
    AdditionalRentPeriodPage.additionalRentPeriodRent(rentAmount)
    continueButtonClick()

    When("The user check rent period details on rent periods page")
    RentPeriods.rentPeriods()

    Then(s"The user selects '$hasMorePeriod' for adding rent period")
    RentPeriods.addAnotherPeriod(hasMorePeriod)
    continueButtonClick()
  }
}
