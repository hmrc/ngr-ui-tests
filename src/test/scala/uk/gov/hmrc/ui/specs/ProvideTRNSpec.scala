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

package uk.gov.hmrc.ui.specs

import org.openqa.selenium.By
import uk.gov.hmrc.ui.pages.StubPage
import uk.gov.hmrc.ui.pages.contactDetails.ConfirmContactDetailsPage
import uk.gov.hmrc.ui.pages.provideTRN.{ConfirmUTRPage, ProvideTRNPage}
import uk.gov.hmrc.ui.utils.login.loginOl

class ProvideTRNSpec extends BaseSpec with StubPage {
  Feature("Test for Provide TRN and Confirm UTR") {
    Scenario("Navigate to ProvideTRN page through journey") {
      Given("Ratepayer logins through one login")
      loginOl()

      Then("Ratepayer is taken to the Confirm Contact Details page")
      ConfirmContactDetailsPage.ConfirmContactDetails()
      click(By.id("continue"))

      Then("Ratepayer is taken to Provide TRN Page")
      ProvideTRNPage.confirmElements()
      click(By.id("continue"))

      Then("Ratepayer is taken to ConfirmUTR Page")
      ConfirmUTRPage.confirmElements()
      ConfirmUTRPage.confirmUTR("*******333")
    }
  }
}
