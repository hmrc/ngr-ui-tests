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

import uk.gov.hmrc.ui.pages.RegisterComplete.printLinkDisplay
import uk.gov.hmrc.ui.pages.{CheckYourAnswer, NinoPage, RegisterComplete, StubPage}
import uk.gov.hmrc.ui.pages.contactDetails.ConfirmContactDetailsPage
import uk.gov.hmrc.ui.pages.provideTRN.{ConfirmUTRPage, ProvideTRNPage}
import uk.gov.hmrc.ui.utils.login.loginOl

class RegistrationCompleteSpec extends BaseSpec with StubPage {
  Feature("Tests for the Registration Complete page") {

    /* Testing the entire flow of the service with a SAUTR */

    Scenario("The user goes through the entire flow to the Registration Complete Page providing a SAUTR") {
      Given("Ratepayer logins through one login")
      loginOl()

      Then("Ratepayer is taken to the Confirm Contact Details page")
      ConfirmContactDetailsPage.ConfirmContactDetails()
      click(continueButton)

      Then("Ratepayer is taken to Provide TRN Page")
      ProvideTRNPage.provideYourTRN()
      click(continueButton)

      Then("User is taken to the confirm UTR page, selects 'Yes, I want to provide this UTR'")
      ConfirmUTRPage.confirmYourSAUTR()
      ConfirmUTRPage.selectYes()

      Then("Ratepayer is taken to the Check Your Answers page")
      CheckYourAnswer.checkYourAnswer()
      click(continueButton)

      Then("Ratepayer is taken to the Registration complete page")
      RegisterComplete.RegisterComplete()
      printLinkDisplay("Print or save this page")
    }

    Scenario("The user goes through the entire flow to the Registration Complete Page choosing to provide NINO") {
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

      Then("User selects 'NO, I want to provide this NINO' and submit")
      ConfirmUTRPage.selectNoProvideNI()

      Then("The ratepayer is taken to the 'Provide your National Insurance number'")
      NinoPage.InputNino("AA000003D")

      Then("The ratepayer is taken to the 'Check your answers' where NINO is masked")
      CheckYourAnswer.checkYourAnswer()
      CheckYourAnswer.confirmMAskedTRN("******03D")
      click(continueButton)

      Then("Ratepayer is taken to the Registration complete page")
      RegisterComplete.RegisterComplete()
      printLinkDisplay("Print or save this page")
    }

    Scenario("The user goes through the entire flow to the Registration Complete and did not provide the SAUTR") {

      Given("Ratepayer logins through one login")
      loginOl()

      Then("Ratepayer is taken to the Confirm Contact Details page")
      ConfirmContactDetailsPage.ConfirmContactDetails()
      click(continueButton)

      Then("Ratepayer is taken to Provide TRN Page")
      ProvideTRNPage.provideYourTRN()
      click(continueButton)

      Then("User selects 'No, I will provide UTR Later' and continue")
      ConfirmUTRPage.selectNoLater()

      Then("The ratepayer is taken to the 'Check your answers' where SAUTR is not present, and clicks continue")
      CheckYourAnswer.checkYourAnswer()
      CheckYourAnswer.sautrNoDisplay("Provide your UTR")
      click(continueButton)

      Then("Ratepayer is taken to the Registration complete page")
      RegisterComplete.RegisterComplete()
      printLinkDisplay("Print or save this page")
    }
  }
}
