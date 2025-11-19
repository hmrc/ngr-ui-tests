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

object AdditionalRentPeriodPage extends BasePage {

  val periodSequence: Map[Int, String] = Map(
    3  -> "Third",
    4  -> "Fourth",
    5  -> "Fifth",
    6  -> "Sixth",
    7  -> "Seventh",
    8  -> "Eighth",
    9  -> "Ninth",
    10 -> "Tenth"
  )

  def additionalRentPeriod(sequence: Int): Unit =
    headerCheck(s"${periodSequence.getOrElse(sequence, "")} rent period")

  val additionalDateEndInputLocationDay: By   = By.id("endDate.day")
  val additionalDateEndInputLocationMonth: By = By.id("endDate.month")
  val additionalDateEndInputLocationYear: By  = By.id("endDate.year")

  val rentForAdditionalRentPeriod: By = By.id("rentPeriodAmount")

  def additionalRentPeriodEndDate(day: String, month: String, year: String): Unit = {
    sendKeys(additionalDateEndInputLocationDay, day)
    sendKeys(additionalDateEndInputLocationMonth, month)
    sendKeys(additionalDateEndInputLocationYear, year)
  }

  def additionalRentPeriodRent(amount: String): Unit =
    sendKeys(rentForAdditionalRentPeriod, amount)
}
