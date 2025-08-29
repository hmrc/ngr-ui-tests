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

  val firstRentPeriodRadioInputYes: By            = By.id("provideDetailsOfFirstSecondRentPeriod-radio-firstRentPeriodRadio")
  val firstRentPeriodRadioInputYesConditional: By = By.id("RentPeriodAmount")
  val firstRentPeriodRadioInputNo: By             = By.id("provideDetailsOfFirstSecondRentPeriod-radio-firstRentPeriodRadio")

  val secondDateStartInputLocationDay: By   = By.id("provideDetailsOfFirstSecondRentPeriod.secondPeriod.start.date.day")
  val secondDateStartInputLocationMonth: By =
    By.id("provideDetailsOfFirstSecondRentPeriod.secondPeriod.start.date.month")
  val secondDateStartInputLocationYear: By  = By.id("provideDetailsOfFirstSecondRentPeriod.secondPeriod.start.date.year")

  val secondDateEndInputLocationDay: By   = By.id("provideDetailsOfFirstSecondRentPeriod.secondPeriod.end.date.day")
  val secondDateEndInputLocationMonth: By = By.id("provideDetailsOfFirstSecondRentPeriod.secondPeriod.end.date.month")
  val secondDateEndInputLocationYear: By  = By.id("provideDetailsOfFirstSecondRentPeriod.secondPeriod.end.date.year")

  val secondDateStartInput: By = By.id("conditional-rald-new-lease-rent-period-rent-2")

  def firstDateStartDayInput(day: String): Unit     =
    sendKeys(firstDateStartInputLocationDay, day)
  def firstDateStartMonthInput(month: String): Unit =
    sendKeys(firstDateStartInputLocationMonth, month)
  def firstDateStartYearInput(year: String): Unit   =
    sendKeys(firstDateStartInputLocationYear, year)

  def firstRentPeriodRadioYes(): Unit =
    click(firstRentPeriodRadioInputYes)

  def firstRentPeriodRadioNo(): Unit =
    click(firstRentPeriodRadioInputNo)

  def firstRentPeriodRadioYesConditional(amount: String): Unit =
    sendKeys(firstRentPeriodRadioInputYesConditional, amount)

  def secondDateStartDayInput(day: String): Unit     =
    sendKeys(secondDateStartInputLocationDay, day)
  def secondDateStartMonthInput(month: String): Unit =
    sendKeys(secondDateStartInputLocationMonth, month)
  def secondDateStartYearInput(year: String): Unit   =
    sendKeys(secondDateStartInputLocationYear, year)

}
