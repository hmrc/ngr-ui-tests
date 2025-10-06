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

import org.openqa.selenium.By
import uk.gov.hmrc.ui.pages.BasePage

object ProvideDetailsOfFirstSecondRentPeriodPage extends BasePage {

  def provideDetailsOfEachRentPeriod(): Unit =
    headerCheck("Provide details of each rent period")

  val firstDateStartInputLocationDay: By   = By.id("first.startDate.day")
  val firstDateStartInputLocationMonth: By = By.id("first.startDate.month")
  val firstDateStartInputLocationYear: By  = By.id("first.startDate.year")

  val firstDateEndInputLocationDay: By   = By.id("first.endDate.day")
  val firstDateEndInputLocationMonth: By = By.id("first.endDate.month")
  val firstDateEndInputLocationYear: By  = By.id("first.endDate.year")

  val firstRentPeriodRadioInputYes: By = By.id("provideDetailsOfFirstSecondRentPeriod-radio-firstRentPeriodRadio")

  val firstRentPeriodRentAmount: By   = By.id("RentPeriodAmount")
  val firstRentPeriodRadioInputNo: By = By.id("provideDetailsOfFirstSecondRentPeriod-radio-firstRentPeriodRadio-2")

  val secondDateStartInputLocationDay: By   = By.id("second.startDate.day")
  val secondDateStartInputLocationMonth: By = By.id("second.startDate.month")
  val secondDateStartInputLocationYear: By  = By.id("second.startDate.year")

  val secondDateEndInputLocationDay: By   = By.id("second.endDate.day")
  val secondDateEndInputLocationMonth: By = By.id("second.endDate.month")
  val secondDateEndInputLocationYear: By  = By.id("second.endDate.year")

  val rentForSecondRentPeriod: By = By.id("SecondRentPeriodAmount")

  def firstRentPeriodStartDate(day: String, month: String, year: String): Unit = {
    sendKeys(firstDateStartInputLocationDay, day)
    sendKeys(firstDateStartInputLocationMonth, month)
    sendKeys(firstDateStartInputLocationYear, year)
  }

  def firstRentPeriodEndDate(day: String, month: String, year: String): Unit = {
    sendKeys(firstDateEndInputLocationDay, day)
    sendKeys(firstDateEndInputLocationMonth, month)
    sendKeys(firstDateEndInputLocationYear, year)
  }

  def firstRentPeriodRadioYes(): Unit =
    click(firstRentPeriodRadioInputYes) /* used in new agreement */

  def firstRentPeriodRadioNo(): Unit =
    click(firstRentPeriodRadioInputNo) /* used in renewed agreement*/

  def firstRentPeriodRent(amount: String): Unit =
    sendKeys(firstRentPeriodRentAmount, amount)

  def secondRentPeriodStartDate(day: String, month: String, year: String): Unit = {
    sendKeys(secondDateStartInputLocationDay, day)
    sendKeys(secondDateStartInputLocationMonth, month)
    sendKeys(secondDateStartInputLocationYear, year)
  }

  def secondRentPeriodEndDate(day: String, month: String, year: String): Unit = {
    sendKeys(secondDateEndInputLocationDay, day)
    sendKeys(secondDateEndInputLocationMonth, month)
    sendKeys(secondDateEndInputLocationYear, year)
  }

  def SecondRentPeriodRent(amount: String): Unit =
    sendKeys(rentForSecondRentPeriod, amount)
}
