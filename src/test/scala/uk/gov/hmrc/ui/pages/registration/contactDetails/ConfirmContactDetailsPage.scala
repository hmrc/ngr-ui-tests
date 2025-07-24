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

package uk.gov.hmrc.ui.pages.registration.contactDetails

import org.openqa.selenium.By
import uk.gov.hmrc.ui.pages.BasePage

object ConfirmContactDetailsPage extends BasePage {

  val changeNameLink        = By.id("name-linkid")
  val changePhoneNumberLink = By.id("number-linkid")
  val changeEmailLink       = By.id("email-linkid")
  val changeAddressLink     = By.id("address-linkid")

  def ConfirmContactDetails(): Unit =
    headerCheck("Confirm your contact details")

  def verifyUpdatedName(expectedName: String): Unit = {
    val actualName = getElementByCssSelector("#contact-name-id")
    assert(actualName == expectedName, "Name doesn't match")
  }

  def verifyUpdatedEmail(expectedEmail: String): Unit = {
    val actualEmail = getElementByCssSelector("#email-address-id")
    assert(actualEmail == expectedEmail, "Email doesn't match")
  }

  def verifyUpdatedContactNo(expectedNumber: String): Unit = {
    val actualNumber = getElementByCssSelector("#phone-number-id")
    assert(expectedNumber == actualNumber, "Contact number doesn't match")
  }

  def verifyUpdatedAddress(expectedAddress: String): Unit = {
    val actualAddress = getElementByCssSelector("#address-id")
    assert(actualAddress == expectedAddress, "Address doesn't match on confirm contact details")
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
