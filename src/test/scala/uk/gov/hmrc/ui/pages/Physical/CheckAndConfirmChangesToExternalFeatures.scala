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

package uk.gov.hmrc.ui.pages.Physical

import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions
import uk.gov.hmrc.selenium.webdriver.Driver
import uk.gov.hmrc.ui.pages.BasePage

object CheckAndConfirmChangesToExternalFeatures extends BasePage {
  def checkAndConfirmChangesToExternalFeaturesHeader(): Unit =
    headerCheck("Check and confirm changes to external features")

  def tellAnotherExternalFeatureRadio(anotherExternalFeature: String): Unit = {
    val radioCheckId = anotherExternalFeature match {
      case "Yes" => "value"
      case "No"  => "value-no"
    }
    click(getElementById(radioCheckId))
  }

  def verifyExternalSummaryItem(keyText: String, expectedValue: String): Unit = {
    Wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".govuk-summary-list")))
    Wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".govuk-summary-list__row")))
    val rows = Driver.instance.findElements(By.cssSelector(".govuk-summary-list__row"))

    var found    = false
    val iterator = rows.iterator()
    while (iterator.hasNext && !found) {
      val row        = iterator.next()
      val keyElement = row.findElement(By.cssSelector(".govuk-summary-list__key"))
      if (keyElement.getText.trim == keyText) {
        val valueElement = row.findElement(By.cssSelector(".govuk-summary-list__value"))
        val actualValue  = valueElement.getText.trim
        assert(
          actualValue == expectedValue,
          s"Expected value '$expectedValue' for '$keyText', but found '$actualValue'"
        )
        found = true
      }
    }

    if (!found) {
      throw new NoSuchElementException(s"Could not find summary row with key '$keyText'")
    }
  }

}
