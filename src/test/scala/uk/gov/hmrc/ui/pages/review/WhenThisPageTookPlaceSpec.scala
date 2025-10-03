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

package uk.gov.hmrc.ui.pages.review

import org.openqa.selenium.By
import uk.gov.hmrc.configuration.TestEnvironment
import uk.gov.hmrc.ui.pages.BasePage

object WhenThisPageTookPlaceSpec extends BasePage {

  def checkTheHeading(): Unit =
    headerCheck("Do you know when this change took place?")

  def selectRadioOption(ChangedUseOfSpace: String): Unit = {
    val radioCheckId = ChangedUseOfSpace match {
      case "Yes" => "value"
      case "No"  => "value-no"
    }
    click(getElementById(radioCheckId))
  }

  val dayInputLocation: By   = By.id("date.day")
  val monthInputLocation: By = By.id("date.month")
  val yearInputLocation: By  = By.id("date.year")

  def dateInput(day: String, month: String, year: String): Unit = {
    click(dayInputLocation)
    sendKeys(dayInputLocation, day)
    click(monthInputLocation)
    sendKeys(monthInputLocation, month)
    click(yearInputLocation)
    sendKeys(yearInputLocation, year)
  }

  private val connection_url: String = TestEnvironment.url("ngr-review-frontend") + "/review/when-change-took-place"

  def renderThePageStep(): Unit =
    getUrl(connection_url)
}
