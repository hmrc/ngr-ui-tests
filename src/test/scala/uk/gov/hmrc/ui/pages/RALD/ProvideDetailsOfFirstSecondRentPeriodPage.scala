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

  def provideDetailsOfFirstSecondRentPeriod(): Unit =
    headerCheck("Provide details of each rent period")

  val firstDateStartInputLocationDay: By   = By.id("provideDetailsOfFirstSecondRentPeriod.firstPeriod.start.date.day")
  val firstDateStartInputLocationMonth: By = By.id("provideDetailsOfFirstSecondRentPeriod.firstPeriod.start.date.month")
  val firstDateStartInputLocationYear: By  = By.id("provideDetailsOfFirstSecondRentPeriod.firstPeriod.start.date.year")

  val firstDateEndInputLocationDay: By   = By.id("provideDetailsOfFirstSecondRentPeriod.firstPeriod.end.date.day")
  val firstDateEndInputLocationMonth: By = By.id("provideDetailsOfFirstSecondRentPeriod.firstPeriod.end.date.month")
  val firstDateEndInputLocationYear: By  = By.id("provideDetailsOfFirstSecondRentPeriod.firstPeriod.end.date.year")

  val firstRentPeriodRadioInputYes: By = By.id("provideDetailsOfFirstSecondRentPeriod-radio-firstRentPeriodRadio")
  val firstRentPeriodRentAmount: By    = By.id("RentPeriodAmount")
  val firstRentPeriodRadioInputNo: By  = By.id("provideDetailsOfFirstSecondRentPeriod-radio-firstRentPeriodRadio")

  val secondDateStartInputLocationDay: By   = By.id("provideDetailsOfFirstSecondRentPeriod.secondPeriod.start.date.day")
  val secondDateStartInputLocationMonth: By =
    By.id("provideDetailsOfFirstSecondRentPeriod.secondPeriod.start.date.month")
  val secondDateStartInputLocationYear: By  = By.id("provideDetailsOfFirstSecondRentPeriod.secondPeriod.start.date.year")

  val secondDateEndInputLocationDay: By   = By.id("provideDetailsOfFirstSecondRentPeriod.secondPeriod.end.date.day")
  val secondDateEndInputLocationMonth: By = By.id("provideDetailsOfFirstSecondRentPeriod.secondPeriod.end.date.month")
  val secondDateEndInputLocationYear: By  = By.id("provideDetailsOfFirstSecondRentPeriod.secondPeriod.end.date.year")

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
