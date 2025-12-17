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

import uk.gov.hmrc.ui.pages.BasePage

object WhatYourRentIncludesPage extends BasePage {

  def whatYourRentIncludes(): Unit =
    headerCheck("What your rent includes")

  def livingAccommodationRadio(select: String): Unit =
    if (select == "Yes") {
      click(getByCssSelector("#livingAccommodationRadio"))
    } else {
      click(getByCssSelector("#livingAccommodationRadio-2"))
    }

  def bedroomNumbers(numbers: String): Unit =
    sendKeys(getByCssSelector("#bedroomNumbers"), numbers)

  def rentPartAddressRadio(select: String): Unit =
    if (select == "Yes") {
      click(getByCssSelector("#rentPartAddressRadio")) /*Used in NewedAgreement scenario 3*/
    } else {
      click(getByCssSelector("#rentPartAddressRadio-2")) /*Used in renewedAgreement scenario 1*/
    }

  def rentEmptyShellRadio(select: String): Unit =
    if (select == "Yes") {
      click(getByCssSelector("#rentEmptyShellRadio"))
    } else {
      click(getByCssSelector("#rentEmptyShellRadio-2")) /*Used in renewedAgreement scenario 1*/
    }

  def rentIncBusinessRatesRadio(select: String): Unit =
    if (select == "Yes") {
      click(getByCssSelector("#rentIncBusinessRatesRadio"))
    } else {
      click(getByCssSelector("#rentIncBusinessRatesRadio-2"))
    }

  def rentIncWaterChargesRadio(select: String): Unit =
    if (select == "Yes") {
      click(getByCssSelector("#rentIncWaterChargesRadio"))
    } else {
      click(getByCssSelector("#rentIncWaterChargesRadio-2"))
    }

  def rentIncServiceRadio(select: String): Unit =
    if (select == "Yes") {
      click(getByCssSelector("#rentIncServiceRadio"))
    } else {
      click(getByCssSelector("#rentIncServiceRadio-2"))
    }

}
