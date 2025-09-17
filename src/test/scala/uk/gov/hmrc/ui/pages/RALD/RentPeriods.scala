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

object RentPeriods extends BasePage {

  def rentPeriods(): Unit =
    headerCheck("Rent periods")

  def addAnotherPeriod(isAdding: String): Unit = {
    val radioId = isAdding.toLowerCase match {
      case "yes" => "rent-periods-radio"
      case _     => "rent-periods-radio-2"
    }
    click(getElementById(radioId))
  }

  def verifyFirstPeriodStartDate(expectedDate: String): Unit = {
    val actual = getElementByCssSelector("#first-period-start-date-id")
    assert(actual == expectedDate, "First period start date doesn't match")
  }

  def verifyFirstPeriodEndDate(expectedDate: String): Unit = {
    val actual = getElementByCssSelector("#first-period-end-date-id")
    assert(actual == expectedDate, "First period end date doesn't match")
  }

  def verifyFirstPeriodRentValue(expectedValue: String): Unit = {
    val actual = getElementByCssSelector("#first-period-rent-value-id")
    assert(actual == expectedValue, s"First period rent value doesn't match $actual")
  }

  def verifyFirstPeriodDoYouPay(expectedAnswer: String): Unit = {
    val actual = getElementByCssSelector("#first-period-has-pay-id")
    assert(actual == expectedAnswer, "First period do you pay answer doesn't match")
  }

  def verifySecondPeriodStartDate(expectedDate: String): Unit = {
    val actual = getElementByCssSelector("#second-period-start-date-id")
    assert(actual == expectedDate, "Second period start date doesn't match")
  }

  def verifySecondPeriodEndDate(expectedDate: String): Unit = {
    val actual = getElementByCssSelector("#second-period-end-date-id")
    assert(actual == expectedDate, "Second period end date doesn't match")
  }

  def verifySecondPeriodRentValue(expectedValue: String): Unit = {
    val actual = getElementByCssSelector("#second-period-rent-value-id")
    assert(actual == expectedValue, "Second period rent value doesn't match")
  }
}
