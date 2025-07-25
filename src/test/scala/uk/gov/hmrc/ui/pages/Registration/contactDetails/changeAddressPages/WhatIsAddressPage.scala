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

package uk.gov.hmrc.ui.pages.Registration.contactDetails.changeAddressPages

import uk.gov.hmrc.ui.pages.BasePage

object WhatIsAddressPage extends BasePage {

  def whatIsTheAddress(): Unit =
    headerCheck("What is the address?")

  def clearAllTheField(): Unit = {
    findElementById("AddressLine1").clear()
    findElementById("AddressLine2").clear()
    findElementById("City").clear()
    findElementById("County").clear()
    findElementById("PostalCode").clear()

  }

  def postCodeError(text: String): Unit = {
    val error = findElementById("PostalCode-error").getText
    assert(error == text, "Post code error doesn't match")
  }

  def inputAddressLine1(address: String): Unit = {
    findElementById("AddressLine1").clear()
    sendKeys(getElementById("AddressLine1"), address)
  }

  def inputPostCode(postcode: String): Unit = {
    findElementById("PostalCode").clear()
    sendKeys(getElementById("PostalCode"), postcode)
    click(continueButton)
  }
}
