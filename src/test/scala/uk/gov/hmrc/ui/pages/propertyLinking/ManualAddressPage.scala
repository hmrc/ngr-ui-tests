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
import uk.gov.hmrc.ui.pages.BasePage

object ManualAddressPage extends BasePage {

  def ManualAddress(): Unit =
    headerCheck("What is the address?")

  val addressLine1Input: By = By.id("addressLine1")
  val addressLine2Input: By = By.id("addressLine2")
  val townInput: By = By.id("town")
  val countyInput: By = By.id("county")
  val postcodeInput: By = By.id("postcode")
  val additionalSearchOptions: By = By.xpath("//*[@id=\"additional-search-options\"]/summary/span")
  val propertyReferenceInput: By = By.id("propertyReference")
  val minRateableValueInput: By = By.id("miniRateableValue")
  val maxRateableValueInput: By = By.id("maxRateableValue")

  def InputAddressLine1Input(newAddressLine1: String): Unit = {
    sendKeys(addressLine1Input, newAddressLine1)
  }
  def InputAddressLine2Input(newAddressLine2: String): Unit = {
    sendKeys(addressLine2Input, newAddressLine2)
  }
  def InputTownInput(newTown: String): Unit = {
    sendKeys(townInput, newTown)
  }
  def InputCountyInput(newCounty: String): Unit = {
    sendKeys(countyInput, newCounty)
  }
  def InputPostcodeInput(newPostcodeInput: String): Unit = {
    sendKeys(postcodeInput, newPostcodeInput)
  }
  def AdditionalSearchOption():Unit = {
   click(additionalSearchOptions)
  }
  def PropertyReferenceInput(newPropertyReferenceInput:String):Unit = {
    sendKeys(postcodeInput, newPropertyReferenceInput)
  }
  def MinRateableValueInput(newMinRateableValueInput:String):Unit = {
    sendKeys(minRateableValueInput, newMinRateableValueInput)
  }
  def MaxRateableValueInput(newMaxRateableValueInput:String):Unit = {
    sendKeys(maxRateableValueInput, newMaxRateableValueInput)
  }
  def findAddress():Unit = {
    click(continueButton)
  }
}
