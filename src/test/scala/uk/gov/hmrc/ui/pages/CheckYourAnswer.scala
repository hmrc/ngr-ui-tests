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

package uk.gov.hmrc.ui.pages

import org.openqa.selenium.By
import uk.gov.hmrc.ui.pages.contactDetails.ConfirmContactDetailsPage.getElementByXpath

object CheckYourAnswer extends BasePage {

  val changeNameLink        = By.id("name-linkid")
  val changePhoneNumberLink = By.id("number-linkid")
  val changeEmailLink       = By.id("email-linkid")
  val changeAddressLink     = By.id("address-linkid")

  def ClickChangeNameLink(): Unit        =
    click(changeNameLink)
  def ClickChangePhoneNumberLink(): Unit =
    click(changePhoneNumberLink)
  def ClickChangeEmailLink(): Unit       =
    click(changeEmailLink)
  def ClickChangeAddressLink(): Unit     =
    click(changeAddressLink)

  def checkYourAnswer(): Unit =
    headerCheck("Check your answers")

  def confirmMAskedTRN(TRN: String): Unit =
    assert(
      getElementByXpath("//*[@id=\"main-content\"]/div/div/form/dl[2]/div/dd[1]") == TRN,
      "Masked TRN verification failed"
    )

  def sautrNoDisplay(sautr: String): Unit = {
    val display = getElementByCssSelector("#sautr-linkid")
    assert(sautr == display, "Provide your UTR link is not present")
  }

  def nameChangedCheck(name: String): Unit = {
    val display = getElementByCssSelector(
      "#main-content > div > div > form > dl:nth-child(6) > div:nth-child(1) > dd.govuk-summary-list__value"
    )
    assert(name == display, "the contact name was not changed")
  }

  def phoneChangedCheck(phoneNumber: String): Unit = {
    val display = getElementByCssSelector(
      "#main-content > div > div > form > dl:nth-child(6) > div:nth-child(3) > dd.govuk-summary-list__value"
    )
    assert(phoneNumber == display, "the contact phone number was not changed")
  }

  def emailChangedCheck(email: String): Unit = {
    val display = getElementByCssSelector(
      "#main-content > div > div > form > dl:nth-child(6) > div:nth-child(2) > dd.govuk-summary-list__value"
    )
    assert(email == display, "the email was not changed")
  }

  def verifyAddress(expectedAddress: String): Unit = {
    val actualAddress = getElementByXpath("//*[@id=\"main-content\"]/div/div/form/dl/div[4]/dd[1]")
    assert(actualAddress == expectedAddress, "Address doesn't match")
  }
}
