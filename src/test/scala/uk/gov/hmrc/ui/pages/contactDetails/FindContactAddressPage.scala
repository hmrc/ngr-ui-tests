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

object FindContactAddressPage extends BasePage {

  val postCode          = By.id("postcode-value")
  val propertyName      = By.id("property-name-value")
  val findAddressButton = By.id("continue")
  val propertyNumber    = By.id("property-name-value")

  def findAddress(): Unit =
    headerCheck("Find the contact address")

  def inputPostCode(code: String): Unit = {
    sendKeys(postCode, code)
    click(findAddressButton)
  }

  def inputPostCodePropertyNumber(code: String, number: String): Unit = {
    sendKeys(postCode, code)
    sendKeys(propertyNumber, number)
    click(findAddressButton)
  }
}
