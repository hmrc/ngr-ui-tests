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

object RentReviewDetailsPage extends BasePage {

  def rentReviewDetails(): Unit =
    headerCheck("Rent review")

  def whatHappensAtRentReview(value: String): Unit =
    value.toLowerCase match {
      case "goupordown" => click(getElementById("what-happens-at-rent-review-radio"))
      case _            => click(getElementById("what-happens-at-rent-review-radio-2"))
    }

  def hasAgreedNewRent(value: String): Unit =
    value.toLowerCase match {
      case "yes" => click(getElementById("has-agreed-new-rent-radio"))
      case _     => click(getElementById("has-agreed-new-rent-radio-2"))
    }

  def whoAgreedNewRent(value: String): Unit =
    value.toLowerCase match {
      case "arbitrator" => click(getElementById("who-agreed-radio"))
      case _            => click(getElementById("who-agreed-radio-2"))
    }

  def enterAnnualRentAmount(amount: String): Unit =
    sendKeys(By.id("annualAmount"), amount)

  def enterStartDate(day: String, month: String, year: String): Unit = {
    sendKeys(By.id("startDate.day"), day)
    sendKeys(By.id("startDate.month"), month)
    sendKeys(By.id("startDate.year"), year)
  }
}
