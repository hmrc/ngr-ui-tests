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

package uk.gov.hmrc.ui.pages.registration.contactDetails.changeAddressPages

import org.openqa.selenium.By
import uk.gov.hmrc.ui.pages.BasePage

object ManualAddressPage extends BasePage {

  val AddressLine1Input: By = By.id("AddressLine1")
  val AddressLine2Input: By = By.id("AddressLine2")
  val CityInput: By         = By.id("City")
  val CountyInput: By       = By.id("County")
  val PostalCodeInput: By   = By.id("PostalCode")

  def ManualAddressDetails(): Unit =
    headerCheck("What is the address?")

  def InputManualAddress(): Unit = {
    sendKeys(AddressLine1Input, "11a Madeup Street")
    sendKeys(CityInput, "Testtown-upon-Test")
    sendKeys(PostalCodeInput, "FX1 7RR")
    click(continueButton)
  }

}
