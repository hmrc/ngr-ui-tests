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

package uk.gov.hmrc.ui.pages.propertyLinking

import org.openqa.selenium.By

import java.time.{Clock, Instant, LocalDateTime, ZoneId}
import uk.gov.hmrc.ui.pages.BasePage

object CurrentRatepayer extends BasePage {

  val dayInput: By   = By.id("ratepayerDate.day")
  val monthInput: By = By.id("ratepayerDate.month")
  val yearInput: By  = By.id("ratepayerDate.year")

  def enterDayInput(newDay: String): Unit     =
    sendKeys(dayInput, newDay)
  def enterMonthInput(newMonth: String): Unit =
    sendKeys(monthInput, newMonth)
  def enterYearInput(newYear: String): Unit   =
    sendKeys(yearInput, newYear)

  def currentRatepayer(): Unit =
    headerCheck("When did you become the current ratepayer?")

  def clickHelpSpan(xPath: String = "//*[@id=\"how-to-tell-if-you-are-the-current-rate-payer\"]/summary/span"): Unit =
    click(By.xpath(xPath))

  def beforeDateRadio(): Unit = {
    click(getElementById("current-ratepayer-radio"))
    click(continueButton)
  }

  def afterDateRadio(): Unit =
    click(getElementById("current-ratepayer-radio-2"))

  def timeSkip(clock: Clock): Boolean = {
    val now = LocalDateTime.now(clock)
    now.isAfter(LocalDateTime.of(2026, 6, 5, 0, 0))
  }

}
