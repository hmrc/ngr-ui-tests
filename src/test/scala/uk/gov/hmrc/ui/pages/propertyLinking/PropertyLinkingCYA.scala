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

package uk.gov.hmrc.ui.pages.propertyLinking

import org.openqa.selenium.By
import uk.gov.hmrc.configuration.TestEnvironment
import uk.gov.hmrc.ui.pages.BasePage

object PropertyLinkingCYA extends BasePage {

  private val cya_url: String = TestEnvironment.url("ngr-property-linking-frontend") + "/check-your-answers"

  def hitCYAStep() =
    getUrl(cya_url)

  val changePropertyAddressLink = By.id("property-address")
  val changeRatepayerDate       = By.id("current-ratepayer")
  val changeBusinessRatesBill   = By.id("business-rates-bill")
  val changeEvidenceDocument    = By.id("evidence-document")
  val changePropertyConnection  = By.id("property-connection")

  def clickChangePropertyAddressLink(): Unit =
    click(changePropertyAddressLink)

  def clickChangeRatepayerDate(): Unit =
    click(changeRatepayerDate)

  def clickChangeBusinessRatesBill(): Unit =
    click(changeBusinessRatesBill)

  def clickChangeEvidenceDocument(): Unit   =
    click(changeEvidenceDocument)

  def clickChangePropertyConnection(): Unit =
    click(changePropertyConnection)

  def checkYourAnswer(): Unit =
    headerCheck("Check and confirm your details")

  def dateChangedCheck(date: String): Unit = {
    val display = getElementByXpath("//*[@id=\"when-did-you-become-the-current-ratepayer?-id\"]")
    assert(date == display, "the date was not changed")
  }

  def billChangedCheck(yesNo: String): Unit = {
    val display = getElementByXpath("//*[@id=\"do-you-have-a-business-rates-bill-for-this-property?-id\"]")
    assert(yesNo == display, "the business rates bool was not changed")
  }

  def evidenceChangedCheck(file: String): Unit = {
    val display = getElementByXpath("//*[@id=\"evidence-document-id\"]")
    assert(file == display, "the evidence document was not changed")
  }

  def addressChangedCheck(address: String): Unit = {
    val display = getElementByCssSelector("#property-to-add-to-account-id")
    assert(address == display, "the address was not changed")
  }

  def connectionChangedCheck(connection: String): Unit = {
    val display = getElementByCssSelector("#what-is-your-connection-to-the-property-id")
    assert(connection == display, "the property connection was not changed")
  }

}
