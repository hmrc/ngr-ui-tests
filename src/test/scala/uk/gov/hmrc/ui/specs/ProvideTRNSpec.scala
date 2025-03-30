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
import uk.gov.hmrc.ui.pages.StubPage
import uk.gov.hmrc.ui.pages.contactDetails.ConfirmContactDetailsPage
import uk.gov.hmrc.ui.pages.provideTRN.{ConfirmUTRPage, ProvideTRNPage}
import uk.gov.hmrc.ui.pages.CheckYourAnswer
import uk.gov.hmrc.ui.utils.login.loginOl

class ProvideTRNSpec extends BaseSpec with StubPage {
  Feature("Test for Provide TRN and Confirm UTR") {
    Scenario("Navigate to ProvideTRN page through journey") {
      Given("Ratepayer logins through one login")
      loginOl()

      Then("Ratepayer is taken to the Confirm Contact Details page")
      ConfirmContactDetailsPage.ConfirmContactDetails()
      click(continueButton)
      Then("Ratepayer is taken to Provide TRN Page")
      ProvideTRNPage.provideYourTRN()
      click(continueButton)

      /** Testing for masked UTR* */
      Then("Ratepayer is taken to ConfirmSAUTR Page where SAUTR is masked ")
      ConfirmUTRPage.confirmYourSAUTR()
      ConfirmUTRPage.confirmUTR("*******333")

      /** Selecting 'Yes, I want to provide this UTR' UTR* */
      Then("User selects 'Yes, I want to provide this UTR' and submit")
      ConfirmUTRPage.selectYes()
      click(continueButton)
      Then("The ratepayer is taken to the 'Check your answers' page")
      CheckYourAnswer.checkYourAnswer()
//      click(continueButton)
//      Then("Ratepayer is navigating to Provide TRN Page then ConfirmUTR Page ")
//      ProvideTRNPage.provideYourTRN()
//      click(continueButton)
//      ConfirmUTRPage.confirmYourSAUTR()
//
//      /** Selecting 'No, I will provide a tax reference number later'* */
//      Then("User selects 'No, I will provide UTR Later' and continue")
//      ConfirmUTRPage.selectNoLater()
//      click(continueButton)
//      Then("The ratepayer is taken to the Confirm Contact Details page")
//      ConfirmContactDetailsPage.ConfirmContactDetails()
//      click(continueButton)
//      Then("Ratepayer is navigating to Provide TRN Page then ConfirmUTR Page ")
//      ProvideTRNPage.provideYourTRN()
//      click(continueButton)
//      ConfirmUTRPage.confirmYourSAUTR()
//
//      /** Selecting 'No, I will provide NI'* */
//      Then("User selects 'No, I will provide NI' and submit")
//      ConfirmUTRPage.selectNoProvideNI()
//      click(continueButton)

    }
  }
}
