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
import uk.gov.hmrc.ui.pages.{CheckYourAnswer, NinoPage, StubPage}
import uk.gov.hmrc.ui.pages.contactDetails.ConfirmContactDetailsPage
import uk.gov.hmrc.ui.pages.provideTRN.{ConfirmUTRPage, ProvideTRNPage}
import uk.gov.hmrc.ui.utils.login.loginOl

class ProvideTRNSpec extends BaseSpec with StubPage {
  Feature("Test for Provide TRN and Confirm NINO") {
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

      /** No, I want to provide my National Insurance number* */
      Then("User selects 'NO, I want to provide this NINO' and submit")
      ConfirmUTRPage.selectNoProvideNI()
      Then("The ratepayer is taken to the 'Provide your National Insurance number'")
      NinoPage.InputNino("AA000003D")
      Then("The ratepayer is taken to the 'Check your answers' where NINO is masked")
      CheckYourAnswer.checkYourAnswer()
      CheckYourAnswer.confirmMAskedTRN("******03D")

      /** Selecting 'Yes, I want to provide this UTR' UTR* */
      Given("Ratepayer logins through one login")
      loginOl()

      Then("Ratepayer is taken to the Confirm Contact Details page")
      ConfirmContactDetailsPage.ConfirmContactDetails()
      click(continueButton)
      Then("Ratepayer is taken to Provide TRN Page")
      ProvideTRNPage.provideYourTRN()
      click(continueButton)

      Then("Ratepayer is taken to ConfirmSAUTR Page where SAUTR is masked ")
      ConfirmUTRPage.confirmYourSAUTR()
      ConfirmUTRPage.confirmUTR("*******333")

      Then("User selects 'Yes, I want to provide this UTR' and submit")
      ConfirmUTRPage.selectYes()
      click(continueButton)

      Then("The ratepayer is taken to the 'Check your answers' where SAUTR is masked")
      CheckYourAnswer.checkYourAnswer()
      CheckYourAnswer.confirmMAskedTRN("*******333")

//      click(continueButton)
//      Then("Ratepayer is navigating to Provide TRN Page then ConfirmUTR Page ")
//      ProvideTRNPage.provideYourTRN()
//      click(continueButton)
//      ConfirmUTRPage.confirmYourSAUTR()
//
      /** Selecting 'No, I will provide a tax reference number later'* */
      Given("Ratepayer logins through one login")
      loginOl()

      Then("Ratepayer is taken to the Confirm Contact Details page")
      ConfirmContactDetailsPage.ConfirmContactDetails()
      click(continueButton)

      Then("Ratepayer is taken to Provide TRN Page")
      ProvideTRNPage.provideYourTRN()
      click(continueButton)

      Then("Ratepayer is taken to ConfirmSAUTR Page where SAUTR is masked ")
      ConfirmUTRPage.confirmYourSAUTR()
      ConfirmUTRPage.confirmUTR("*******333")

      Then("User selects 'No, I will provide UTR Later' and continue")
      ConfirmUTRPage.selectNoLater()
      click(continueButton)

      Then("The ratepayer is taken to the 'Check your answers' where SAUTR is not present")
      CheckYourAnswer.checkYourAnswer()
      CheckYourAnswer.sautrNoDisplay("*******333")

      Then("The ratepayer is taken to the Confirm Contact Details page")
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
