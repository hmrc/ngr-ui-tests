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

package uk.gov.hmrc.ui.pages.PropertyLinking

import org.openqa.selenium.By
import uk.gov.hmrc.ui.pages.BasePage

import java.time.{Clock, LocalDateTime}

object CurrentRatepayer extends BasePage {

  val dayInput: By   = By.id("ratepayerDate.day")
  val monthInput: By = By.id("ratepayerDate.month")
  val yearInput: By  = By.id("ratepayerDate.year")

  def dateInput(day: String, month: String, year: String): Unit = {
    sendKeys(dayInput, day)
    sendKeys(monthInput, month)
    sendKeys(yearInput, year)
  }

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
