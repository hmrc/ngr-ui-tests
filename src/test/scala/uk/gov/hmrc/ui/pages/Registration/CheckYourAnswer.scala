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

package uk.gov.hmrc.ui.pages.Registration

import org.openqa.selenium.By
import uk.gov.hmrc.ui.pages.BasePage
import uk.gov.hmrc.ui.pages.Registration.contactDetails.PhoneNumberPage.reloadPage
import uk.gov.hmrc.ui.pages.Registration.contactDetails.changeAddressPages.DoyouWantToUseAddressPage.headerCheck

object CheckYourAnswer extends BasePage {

  val changeNameLink        = By.id("name-linkid")
  val changePhoneNumberLink = By.id("number-linkid")
  val changeEmailLink       = By.id("email-linkid")
  val changeAddressLink     = By.id("address-linkid")

  def ClickChangeNameLink(): Unit        =
    waitForElementToBeClickable(changeNameLink).click()
  def ClickChangePhoneNumberLink(): Unit =
    waitForElementToBeClickable(changePhoneNumberLink).click()
  def ClickChangeEmailLink(): Unit       =
    waitForElementToBeClickable(changeEmailLink).click()
  def ClickChangeAddressLink(): Unit     =
    waitForElementToBeClickable(changeAddressLink).click()

  def checkYourAnswer(): Unit = {
    reloadPage()
    headerCheck("Check your answers")
  }

  def confirmMAskedTRN(TRN: String): Unit =
    assert(
      getElementByXpath("//*[@id=\"main-content\"]/div/div/form/dl[2]/div/dd[1]") == TRN,
      "Masked TRN verification failed"
    )

  def sautrNoDisplay(sautr: String): Unit = {
    val display = getElementByCssSelector("#sautr-linkid")
    assert(display == sautr, "Provide your UTR link is not present")
  }

  def nameChangedCheck(name: String): Unit = {
    val display = getElementById("contact-name-id")
    assert(display == name, "the contact name was not changed")
  }

  def phoneChangedCheck(phoneNumber: String): Unit = {
    val display = getElementById("phone-number-id")
    assert(display == phoneNumber, "the contact phone number was not changed")
  }

  def emailChangedCheck(email: String): Unit = {
    val display = getElementById("email-address-id")
    assert(display == email, "the email was not changed")
  }

  def verifyAddress(expectedAddress: String): Unit = {
    val actualAddress = getElementById("address-id")
    assert(actualAddress == expectedAddress, "Address doesn't match")
  }
}
