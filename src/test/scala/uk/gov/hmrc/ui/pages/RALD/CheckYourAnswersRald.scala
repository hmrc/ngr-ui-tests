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

package uk.gov.hmrc.ui.pages.RALD

import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions
import uk.gov.hmrc.selenium.webdriver.Driver
import uk.gov.hmrc.ui.pages.BasePage
import scala.jdk.CollectionConverters._

object CheckYourAnswersRald extends BasePage {

  def checkYourAnswersHeader(): Unit =
    headerCheck("Check your answers")

  def checkSectionHeadings(): Unit = {
    headerCheck2("Landlord details")
    headerCheck2("Agreement details")
    headerCheck2("Rent details")
    headerCheck2("What your rent includes details")
    headerCheck2("Repairs and insurance details")
    headerCheck2("Rent review details")
    headerCheck2("Repairs and fitting out")
    headerCheck2("Payments")
    headerCheck2("Other details")
  }

  def clickChangeLink(linkId: String): Unit = {
    val locator = By.id(linkId)
    try {
      Wait.until(ExpectedConditions.visibilityOfElementLocated(locator))
      Wait.until(ExpectedConditions.elementToBeClickable(locator))
      val linkElement = Driver.instance.findElement(locator)
      linkElement.click()
    } catch {
      case e: Exception =>
        println(s"Click change link failed for '$linkId' due to exception: ${e.getMessage}")
    }
  }

  def verifySummaryRow(keyText: String, expectedValue: String): Unit = {
    Wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".govuk-summary-list")))
    Wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".govuk-summary-list__row")))
    val rows = Driver.instance.findElements(By.cssSelector(".govuk-summary-list__row")).asScala

    val maybeRow = rows.find(_.findElement(By.cssSelector(".govuk-summary-list__key")).getText.trim == keyText)

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
