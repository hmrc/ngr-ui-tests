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
import uk.gov.hmrc.ui.pages.BasePage

object AgreementPage extends BasePage {

  def agreement(): Unit =
    headerCheck("Agreement")

  def agreementEnterStartDate(day: String, month: String, year: String): Unit = {
    agreementEnterStartDateDay(day)
    agreementEnterStartDateMonth(month)
    agreementEnterStartDateYear(year)
  }

  def agreementEnterOpenEndedDate(day: String, month: String, year: String): Unit = {
    agreementOpenEndedDateDay(day)
    agreementOpenEndedDateMonth(month)
    agreementOpenEndedDateYear(year)
  }

  def agreementOpenEndedRadioYes(): Unit =
    click(getElementById("agreement-radio-openEnded"))

  def agreementOpenEndedRadioNo(): Unit =
    click(getElementById("agreement-radio-openEnded-2"))

  def agreementHaveABreakClauseRadioYes(): Unit =
    click(getElementById("agreement-breakClause-radio"))

  def agreementHaveABreakClauseRadioNo(): Unit =
    click(getElementById("agreement-breakClause-radio-2"))

  def agreementHaveABreakClauseReason(reason: String): Unit = {
    click(getElementById("about-break-clause"))
    sendKeys(By.id("about-break-clause"), reason)
  }

  private def agreementEnterStartDateDay(day: String): Unit = {
    click(getElementById("agreementStartDate.day"))
    sendKeys(By.id("agreementStartDate.day"), day)
  }

  private def agreementEnterStartDateMonth(month: String): Unit = {
    click(getElementById("agreementStartDate.month"))
    sendKeys(By.id("agreementStartDate.month"), month)
  }

  private def agreementEnterStartDateYear(year: String): Unit = {
    click(getElementById("agreementStartDate.year"))
    sendKeys(By.id("agreementStartDate.year"), year)
  }

  private def agreementOpenEndedDateDay(day: String): Unit = {
    click(getElementById("agreementEndDate.day"))
    sendKeys(By.id("agreementEndDate.day"), day)
  }

  private def agreementOpenEndedDateMonth(month: String): Unit = {
    click(getElementById("agreementEndDate.month"))
    sendKeys(By.id("agreementEndDate.month"), month)
  }

  private def agreementOpenEndedDateYear(year: String): Unit = {
    click(getElementById("agreementEndDate.year"))
    sendKeys(By.id("agreementEndDate.month"), year)
  }
}
