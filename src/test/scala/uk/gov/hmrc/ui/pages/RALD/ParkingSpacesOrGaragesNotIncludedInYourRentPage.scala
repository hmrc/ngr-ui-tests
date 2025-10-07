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

object ParkingSpacesOrGaragesNotIncludedInYourRentPage extends BasePage {

  def ParkingSpacesOrGaragesNotIncludedInYourRent(): Unit =
    headerCheck("Parking spaces or garages not included in your rent")

  def enterUncoveredSpaces(number: String): Unit =
    sendKeys(By.id("uncoveredSpaces"), number)

  def enterCoveredSpaces(number: String): Unit =
    sendKeys(By.id("coveredSpaces"), number)

  def enterGarages(number: String): Unit =
    sendKeys(By.id("garages"), number)

  def totalCost(number: String): Unit =
    sendKeys(By.id("totalCost"), number)

  def agreementDateInput(day: String, month: String, year: String): Unit = {
    sendKeys(By.id("agreementDate.day"), day)
    sendKeys(By.id("agreementDate.month"), month)
    sendKeys(By.id("agreementDate.year"), year)
  }
}
