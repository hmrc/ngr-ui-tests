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

object ProvideDetailsOfFirstRentPeriodPage extends BasePage {

  private val isRentPayablePeriodRadioInputYes: By = By.id("provideDetailsOfFirstRentPeriod-radio-isRentPayablePeriod")
  private val isRentPayablePeriodRadioInputNo: By  = By.id("provideDetailsOfFirstRentPeriod-radio-isRentPayablePeriod-2")
  private val rentPeriodAmount: By                 = By.id("rentPeriodAmount")

  def provideDetailsOfFirstRentPeriodHeader(): Unit =
    headerCheck("First rent period")

  def startDate(isoDate: String): Unit =
    setDate("startDate", isoDate)

  def endDate(isoDate: String): Unit =
    setDate("endDate", isoDate)

  def rentPayablePeriodRadioYes(): Unit =
    click(isRentPayablePeriodRadioInputYes)

  def rentPayablePeriodRadioNo(): Unit =
    click(isRentPayablePeriodRadioInputNo)

  def rentPeriodAmount(amount: String): Unit =
    sendKeys(rentPeriodAmount, amount)

}
