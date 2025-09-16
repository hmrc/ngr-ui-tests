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

package uk.gov.hmrc.ui.pages.Physical

import org.openqa.selenium.By
import uk.gov.hmrc.ui.pages.BasePage
object WhenCompleteChange extends BasePage {

  def whenCompleteChangeScreen(): Unit =
    headerCheck("When did you complete the change?")

  val dayInputLocation: By   = By.id("value.day")
  val monthInputLocation: By = By.id("value.month")
  val yearInputLocation: By  = By.id("value.year")

  def dateInput(day: String, month: String, year: String): Unit = {
    click(dayInputLocation)
    sendKeys(dayInputLocation, day)
    click(monthInputLocation)
    sendKeys(monthInputLocation, month)
    click(yearInputLocation)
    sendKeys(yearInputLocation, year)
  }
}
