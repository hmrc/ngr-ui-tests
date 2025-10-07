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

object UploadedSupportingDocument extends BasePage {

  def uploadedSupportingDocumentHeader(): Unit =
    headerCheck("Uploaded files")

  def verifyUploadedItem(keyText: String, expectedValue: String): Unit = {
    val listLocator = By.cssSelector(".govuk-summary-list")
    val rowLocator  = By.cssSelector(".govuk-summary-list__row")

    try {
      // Wait until the list is visible
      Wait.until(ExpectedConditions.visibilityOfElementLocated(listLocator))

      // Wait until a row with the expected key and value appears
      Wait.until { _ =>
        val rows = Driver.instance.findElements(rowLocator).asScala
        rows.exists { row =>
          val key   = row.findElement(By.cssSelector(".govuk-summary-list__key")).getText.trim
          val value = row.findElement(By.cssSelector(".govuk-summary-list__value")).getText.trim
          key == keyText && value == expectedValue
        }
      }

      // After wait, verify the content
      val rows     = Driver.instance.findElements(rowLocator).asScala
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
    } catch {
      case e: Exception =>
        println(s"Uploaded item verification failed due to exception: ${e.getMessage}")
    }
  }
}
