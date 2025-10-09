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

object CheckAndConfirmYourChanges extends BasePage {

  def checkAndConfirmYourChangesHeader(): Unit =
    headerCheck("Check and confirm your changes")

  // Use this checkAndConfirmYourChangesH2 check function only when you added at least one feature for all of these below. The h2 title won't show if there is no feature in that section.
  def checkAndConfirmYourChangesH2(): Unit = {
    headerCheck2("Date of change")
    headerCheck2("Use of space")
    headerCheck2("Internal features")
    headerCheck2("External features")
    headerCheck2("Additional information")
    headerCheck2("Supporting documents")
  }

  def verifyAddedFeatureItems(keyText: String, expectedValue: String): Unit = {
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
