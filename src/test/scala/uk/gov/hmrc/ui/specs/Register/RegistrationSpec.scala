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

package uk.gov.hmrc.ui.specs.Register

import uk.gov.hmrc.ui.pages.PropertyLinking.RegisterComplete
import uk.gov.hmrc.ui.pages.PropertyLinking.RegisterComplete.printLinkDisplay
import uk.gov.hmrc.ui.pages.Registration._
import uk.gov.hmrc.ui.pages.StubPage
import uk.gov.hmrc.ui.specs.BaseSpec
import uk.gov.hmrc.ui.utils.login.loginOl
import uk.gov.hmrc.ui.utils.mongo.RegistrationDB

class RegistrationSpec extends BaseSpec with StubPage {
  Feature("The user completes the registration process") {

    Scenario("Ratepayer choose to provide NINO and completes the registration process") {
      RegistrationDB.cleanup()
      Given("Ratepayer logins through one login")
      loginOl()

      Then("User provide phone number")
      PhoneNumberPage.userProvidesPhoneNumber()

      Then("Ratepayer is taken to Provide TRN Page")
      ProvideTRNPage.provideYourTRN()
      click(continueButton)

      /** provide my National Insurance number* */
      Then("User selects 'NO, I want to provide this NINO' and submit")
      ConfirmUTRPage.confirmYourSAUTR()
      ConfirmUTRPage.selectNoProvideNI()
      Then("The ratepayer is taken to the 'Provide your National Insurance number'")
      NinoPage.InputNino("AA000003D")

      Then("The ratepayer is taken to the 'Check your answers' where NINO is masked")
      CheckYourAnswer.checkYourAnswer()
      CheckYourAnswer.confirmMAskedNINO("******03D")
      click(continueButton)

      Then("Ratepayer is taken to the Registration complete page")
      RegisterComplete.RegisterComplete()
      printLinkDisplay("Print this page")

    }

    Scenario("The user completes registration by providing a SAUTR") {
      RegistrationDB.cleanup()

      Given("Ratepayer logins through one login")
      loginOl()

      Then("User provide phone number")
      PhoneNumberPage.userProvidesPhoneNumber()

      Then("Ratepayer is taken to Provide TRN Page")
      ProvideTRNPage.provideYourTRN()
      click(continueButton)

      Then("User selects 'No, I will provide UTR Later' and continue")
      ConfirmUTRPage.confirmYourSAUTR()
      ConfirmUTRPage.provideTRNLater()

      Then("The ratepayer is taken to the 'Check your answers' where SAUTR is not present, and clicks the link")
      CheckYourAnswer.checkYourAnswer()
      clickLink("Provide your UTR")

      /** Selecting 'Yes, I want to provide this UTR' UTR* */
      Then("User selects 'Yes, I want to provide this UTR' and submit")
      ConfirmUTRPage.confirmYourSAUTR()
      ConfirmUTRPage.selectYes()

      Then("The ratepayer is taken to the 'Check your answers' where SAUTR is masked")
      CheckYourAnswer.checkYourAnswer()
      CheckYourAnswer.confirmMAskedUTR("*******333")
      click(continueButton)

      Then("Ratepayer is taken to the Registration complete page")
      RegisterComplete.RegisterComplete()
      RegistrationDB.cleanup()
    }

    Scenario("The user completes registration but decided to provide the SAUTR later") {
      RegistrationDB.cleanup()

      /** Selecting 'No, I will provide a tax reference number later'* */
      Given("Ratepayer logins through one login")
      loginOl()

      Then("User provide phone number")
      PhoneNumberPage.userProvidesPhoneNumber()

      Then("Ratepayer is taken to Provide TRN Page")
      ProvideTRNPage.provideYourTRN()
      click(continueButton)

      Then("User selects 'No, I will provide UTR Later' and continue")
      ConfirmUTRPage.provideTRNLater()

      Then("The ratepayer is taken to the 'Check your answers' where SAUTR is not present, and clicks the link")
      CheckYourAnswer.checkYourAnswer()
      click(continueButton)

      Then("Ratepayer is taken to the Registration complete page")
      RegisterComplete.RegisterComplete()
      RegistrationDB.cleanup()
    }

    /* TOdo Scenario tests for email check, currently correct email is not reflecting on registration complete page  */

//    Scenario("The user goes through the flow to the Registration Complete Page and checks the email") {
//      RegistrationDB.cleanup()
//      Given("Ratepayer logins through one login")
//      loginOl()
//
//      Then("User provide phone number")
//      PhoneNumberPage.userProvidesPhoneNumber()
//
//      Then("Ratepayer is taken to Provide TRN Page")
//      ProvideTRNPage.provideYourTRN()
//      click(continueButton)
//
//      Then("User selects 'Yes, I want to provide this UTR' and submit")
//      ConfirmUTRPage.confirmYourSAUTR()
//      ConfirmUTRPage.selectYes()
//
//      Then("Ratepayer is taken to the Check Your Answers page")
//      CheckYourAnswer.checkYourAnswer()
//      val email = getElementByCssSelector("#email-address-id").toString
//      click(continueButton)
//
//      Then("Ratepayer is taken to the Registration complete page")
//      RegisterComplete.RegisterComplete()
//      regCompleteEmailChangedCheck(email)
//    }
  }
}
