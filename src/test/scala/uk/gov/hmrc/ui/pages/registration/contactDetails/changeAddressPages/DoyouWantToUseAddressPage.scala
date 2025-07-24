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

object DoyouWantToUseAddressPage extends BasePage {

  val YesRadioButton = By.id("confirm-address-radio")
  val NoRadioButton  = By.id("confirm-address-radio-2")

  def SelectYesAddress(): Unit = {
    headerCheck("Do you want to use this address?")
    click(YesRadioButton)
    click(continueButton)
  }

  def SelectNoAddress(): Unit = {
    headerCheck("Do you want to use this address?")
    click(NoRadioButton)
    click(continueButton)
  }

  def confirmAddress(expectedAddress: String): Unit = {
    val actualAddress = getElementByXpath("//*[@id=\"main-content\"]/div/div/form/p[1]")
    assert(actualAddress == expectedAddress, "Address doesn't match on confirmAddress page ")
  }
}
