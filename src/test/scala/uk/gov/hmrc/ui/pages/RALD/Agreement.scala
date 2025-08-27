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

object Agreement extends BasePage {

  def agreement(): Unit =
    headerCheck("Agreement")

  def enterAgreementStartDate(day: String, month: String, year: String): Unit = {
    click(getElementById("agreementStartDate.day"))
    sendKeys(By.id("agreementStartDate.day"), day)

    click(getElementById("agreementStartDate.month"))
    sendKeys(By.id("agreementStartDate.month"), month)

    click(getElementById("agreementStartDate.year"))
    sendKeys(By.id("agreementStartDate.year"), year)
  }

  def enterOpenEndedAgreementDate(day: String, month: String, year: String): Unit = {
    click(getElementById("agreementEndDate.day"))
    sendKeys(By.id("agreementEndDate.day"), day)

    click(getElementById("agreementEndDate.month"))
    sendKeys(By.id("agreementEndDate.month"), month)

    click(getElementById("agreementEndDate.year"))
    sendKeys(By.id("agreementEndDate.year"), year)
  }

  def agreementOpenEndedRadio(option: String): Unit = {
    val radioId = option match {
      case "Yes" => "agreement-radio-openEnded" /*used*/
      case "No"  => "agreement-radio-openEnded-2" /*used*/
    }
    click(getElementById(radioId))
  }

  def agreementHaveABreakClauseRadio(option: String): Unit = {
    val radioId = option.toLowerCase match {
      case "yes" => "agreement-breakClause-radio" /*used*/
      case "no"  => "agreement-breakClause-radio-2" /*used*/
    }
    click(getElementById(radioId))
  }

  def agreementBreakClauseReason(reason: String): Unit = {
    click(getElementById("about-break-clause"))
    sendKeys(By.id("about-break-clause"), reason)
  }

}
