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

object WhatIsRentBasedOnPage extends BasePage {

  def whatIsRentBasedOn(): Unit =
    headerCheck("What is your rent based on?")

  val rentBasedOnOtherDescLocation: By = By.id("rent-based-on-other-desc")

  def selectRentBaseOn(rentBasedOnType: String): Unit = {
    val radioId = rentBasedOnType match {
      case "Open market value"                  => "rent-based-on-radio"
      case "A percentage of open market value"  => "rent-based-on-radio-2"
      case "Turnover top-up"                    => "rent-based-on-radio-3"
      case "A percentage of expected turnover"  => "rent-based-on-radio-4"
      case "Total Occupancy Cost leases (TOCs)" => "rent-based-on-radio-5"
      case "Indexation"                         => "rent-based-on-radio-6"
      case "Other"                              => "rent-based-on-radio-7"
    }
    click(getElementById(radioId))
    click(continueButton)
  }

  def otherRentBasedOnDescription(otherDesc: String): Unit =
    sendKeys(rentBasedOnOtherDescLocation, otherDesc)
}
