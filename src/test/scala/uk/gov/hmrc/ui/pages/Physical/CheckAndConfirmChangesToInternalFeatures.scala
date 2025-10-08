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

import scala.jdk.CollectionConverters._

object CheckAndConfirmChangesToInternalFeatures extends BasePage {

  def checkAndConfirmChangesToInternalFeaturesHeader(): Unit =
    headerCheck("Check and confirm changes to internal features")

  def tellAnotherInternalFeatureRadio(anotherInternalFeature: String): Unit = {
    val radioCheckId = anotherInternalFeature match {
      case "Yes" => "value"
      case "No"  => "value-no"
    }
    click(getElementById(radioCheckId))
  }

  def verifySummaryItem(keyText: String, expectedValue: String): Unit = {
    Wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".govuk-summary-list")))
    Wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".govuk-summary-list__row")))
    val rows = Driver.instance.findElements(By.cssSelector(".govuk-summary-list__row")).asScala

    val maybeRow = rows.find { row =>
      row.findElement(By.cssSelector(".govuk-summary-list__key")).getText.trim == keyText
    }

    maybeRow match {
      case Some(row) =>
        val actualValue = row.findElement(By.cssSelector(".govuk-summary-list__value")).getText.trim
        assert(
          actualValue == expectedValue,
          s"Expected value '$expectedValue' for '$keyText', but found '$actualValue'"
        )
      case None      =>
        throw new NoSuchElementException(s"Could not find summary row with key '$keyText'")
    }
  }
}
