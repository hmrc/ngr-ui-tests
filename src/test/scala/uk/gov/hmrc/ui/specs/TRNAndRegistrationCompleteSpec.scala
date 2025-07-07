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

///*
// * Copyright 2025 HM Revenue & Customs
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// *     http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//
//package uk.gov.hmrc.ui.specs
//
//import uk.gov.hmrc.ui.pages.RegisterComplete.{printLinkDisplay, regCompleteEmailChangedCheck}
//import uk.gov.hmrc.ui.pages.{CheckYourAnswer, RegisterComplete, StubPage}
//import uk.gov.hmrc.ui.pages.contactDetails.{ConfirmContactDetailsPage, PhoneNumberPage}
//import uk.gov.hmrc.ui.pages.provideTRN.{ConfirmUTRPage, NinoPage, ProvideTRNPage}
//import uk.gov.hmrc.ui.utils.login.loginOl
//import uk.gov.hmrc.ui.utils.mongo.RegistrationDB
//
//class TRNAndRegistrationCompleteSpec extends BaseSpec with StubPage {
//  Feature("The user completes the registration process providing a NINO") {
//    RegistrationDB.cleanup()
//    Scenario("Ratepayer choose to provide NINO") {
//      Given("Ratepayer logins through one login")
//      loginOl()
//
//      Then("User provide phone number")
//      PhoneNumberPage.userProvidesPhoneNumber()
//
//      Then("Ratepayer is taken to the Confirm Contact Details page")
//      ConfirmContactDetailsPage.ConfirmContactDetails()
//      click(continueButton)
//      Then("Ratepayer is taken to Provide TRN Page")
//      ProvideTRNPage.provideYourTRN()
//      click(continueButton)
//
//      /** Testing for masked UTR* */
//      Then("Ratepayer is taken to ConfirmSAUTR Page where SAUTR is masked ")
//      ConfirmUTRPage.confirmYourSAUTR()
//      ConfirmUTRPage.confirmUTR("*******333")
//
//      /** No, I want to provide my National Insurance number* */
//      Then("User selects 'NO, I want to provide this NINO' and submit")
//      ConfirmUTRPage.selectNoProvideNI()
//      Then("The ratepayer is taken to the 'Provide your National Insurance number'")
//      NinoPage.InputNino("AA000003D")
//      Then("The ratepayer is taken to the 'Check your answers' where NINO is masked")
//      CheckYourAnswer.checkYourAnswer()
//      CheckYourAnswer.confirmMAskedTRN("******03D")
//      click(continueButton)
//
//      Then("Ratepayer is taken to the Registration complete page")
//      RegisterComplete.RegisterComplete()
//      printLinkDisplay("Print or save this page")
//
//    }
//
//    Scenario("The user completes registration by providing a SAUTR") {
//      RegistrationDB.cleanup()
//
//      /** Selecting 'Yes, I want to provide this UTR' UTR* */
//      Given("Ratepayer logins through one login")
//      loginOl()
//
//      Then("User provide phone number")
//      PhoneNumberPage.userProvidesPhoneNumber()
//
//      Then("Ratepayer is taken to the Confirm Contact Details page")
//      ConfirmContactDetailsPage.ConfirmContactDetails()
//      click(continueButton)
//      Then("Ratepayer is taken to Provide TRN Page")
//      ProvideTRNPage.provideYourTRN()
//      click(continueButton)
//
//      Then("User selects 'Yes, I want to provide this UTR' and submit")
//      ConfirmUTRPage.selectYes()
//
//      Then("The ratepayer is taken to the 'Check your answers' where SAUTR is masked")
//      CheckYourAnswer.checkYourAnswer()
//      CheckYourAnswer.confirmMAskedTRN("*******333")
//      click(continueButton)
//
//      Then("Ratepayer is taken to the Registration complete page")
//      RegisterComplete.RegisterComplete()
//    }
//
//    Scenario("The user completes registration but do not provide the SAUTR") {
//      RegistrationDB.cleanup()
//
//      /** Selecting 'No, I will provide a tax reference number later'* */
//      Given("Ratepayer logins through one login")
//      loginOl()
//
//      Then("User provide phone number")
//      PhoneNumberPage.userProvidesPhoneNumber()
//
//      Then("Ratepayer is taken to the Confirm Contact Details page")
//      ConfirmContactDetailsPage.ConfirmContactDetails()
//      click(continueButton)
//
//      Then("Ratepayer is taken to Provide TRN Page")
//      ProvideTRNPage.provideYourTRN()
//      click(continueButton)
//
//      Then("User selects 'No, I will provide UTR Later' and continue")
//      ConfirmUTRPage.selectNoLater()
//
//      Then("The ratepayer is taken to the 'Check your answers' where SAUTR is not present, and clicks the link")
//      CheckYourAnswer.checkYourAnswer()
//      CheckYourAnswer.sautrNoDisplay("Provide your UTR")
//      click(continueButton)
//
//      Then("Ratepayer is taken to the Registration complete page")
//      RegisterComplete.RegisterComplete()
//    }
//
//    Scenario("Tests to verify the functionality of the 'Provide your UTR' link.") {
//      RegistrationDB.cleanup()
//      Given("Ratepayer logins through one login")
//      loginOl()
//
//      Then("User provide phone number")
//      PhoneNumberPage.userProvidesPhoneNumber()
//
//      Then("Ratepayer is taken to the Confirm Contact Details page")
//      ConfirmContactDetailsPage.ConfirmContactDetails()
//      click(continueButton)
//
//      Then("Ratepayer is taken to Provide TRN Page")
//      ProvideTRNPage.provideYourTRN()
//      click(continueButton)
//
//      Then("User selects 'No, I will provide UTR Later' and continue")
//      ConfirmUTRPage.selectNoLater()
//
//      Then("The ratepayer is taken to the 'Check your answers' where SAUTR is not present, and clicks the link")
//      CheckYourAnswer.checkYourAnswer()
//      CheckYourAnswer.sautrNoDisplay("Provide your UTR")
//      clickLink("Provide your UTR")
//
//      Then("Ratepayer is taken back to the Confirm SAUTR Page, where the SAUTR is masked")
//      ConfirmUTRPage.confirmYourSAUTR()
//      ConfirmUTRPage.confirmUTR("*******333")
//    }
//
//    /* Scenario tests for email check */
//
//    Scenario("The user goes through the flow to the Registration Complete Page and checks the email") {
//      RegistrationDB.cleanup()
//      Given("Ratepayer logins through one login")
//      loginOl()
//
//      Then("User provide phone number")
//      PhoneNumberPage.userProvidesPhoneNumber()
//
//      Then("Ratepayer is taken to the Confirm Contact Details page")
//      ConfirmContactDetailsPage.ConfirmContactDetails()
//      click(continueButton)
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
//  }
//}
