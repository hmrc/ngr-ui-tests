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

package uk.gov.hmrc.ui.pages.contactDetails

import org.openqa.selenium.By
import uk.gov.hmrc.ui.pages.BasePage

object ConfirmContactDetailsPage extends BasePage {

  val changeNameLink        = By.id("name-linkid")
  val changePhoneNumberLink = By.id("number-linkid")
  val changeEmailLink       = By.id("email-linkid")
  val changeAddressLink     = By.id("address-linkid")

  def ConfirmContactDetails(): Unit = {
    val text = "Confirm your contact details"
    headerCheck(text)
  }

  def nameDisplay(expectedName: String): Unit = {
    val actualName = getElementByCssSelector("#content > dl > div:nth-child(1) > dd.govuk-summary-list__value")
    assert(actualName == expectedName, "Name doesn't match")
  }

  def emailDisplay(expectedEmail: String): Unit = {
    val actualEmail = getElementByCssSelector("#content > dl > div:nth-child(2) > dd.govuk-summary-list__value")
    assert(actualEmail == expectedEmail, "Email doesn't match")
  }

  def contactNoDisplay(expectedNumber: String): Unit = {
    val actualNumber = getElementByCssSelector("#content > dl > div:nth-child(3) > dd.govuk-summary-list__value")
    assert(expectedNumber == actualNumber, "Contact number doesn't match")
  }

  def addressDisplay(expectedAddress: String): Unit = {
    val actualAddress = getElementByXpath("//*[@id=\"main-content\"]/div/div/form/dl/div[4]/dd[1]")
    assert(actualAddress == expectedAddress, "Address doesn't match")
  }

  def ClickChangeNameLink(): Unit        =
    click(changeNameLink)
  def ClickChangePhoneNumberLink(): Unit =
    click(changePhoneNumberLink)
  def ClickChangeEmailLink(): Unit       =
    click(changeEmailLink)
  def ClickChangeAddressLink(): Unit     =
    click(changeAddressLink)
}
