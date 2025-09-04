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

object WhatYourRentIncludesPage extends BasePage {

  def whatYourRentIncludes(): Unit =
    headerCheck("What your rent includes")

  def livingAccommodationRadio(select: String): Unit =
    if (select == "Yes") {
      click(By.id("livingAccommodationRadio"))
    } else {
      click(By.id("livingAccommodationRadio-2"))
    }

  def rentPartAddressRadio(select: String): Unit =
    if (select == "Yes") {
      click(By.id("rentPartAddressRadio"))
    } else {
      click(By.id("rentPartAddressRadio-2"))
    }

  def rentEmptyShellRadio(select: String): Unit =
    if (select == "Yes") {
      click(By.id("rentEmptyShellRadio"))
    } else {
      click(By.id("rentEmptyShellRadio-2"))
    }

  def rentIncBusinessRatesRadio(select: String): Unit =
    if (select == "Yes") {
      click(By.id("rentIncBusinessRatesRadio"))
    } else {
      click(By.id("rentIncBusinessRatesRadio-2"))
    }

  def rentIncWaterChargesRadio(select: String): Unit =
    if (select == "Yes") {
      click(By.id("rentIncWaterChargesRadio"))
    } else {
      click(By.id("rentIncWaterChargesRadio-2"))
    }

  def rentIncServiceRadio(select: String): Unit =
    if (select == "Yes") {
      click(By.id("rentIncServiceRadio"))
    } else {
      click(By.id("rentIncServiceRadio-2"))
    }

}
