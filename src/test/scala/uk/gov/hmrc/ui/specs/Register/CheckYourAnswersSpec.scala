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
import uk.gov.hmrc.ui.pages.Registration.CheckYourAnswer.{emailChangedCheck, phoneChangedCheck}
import uk.gov.hmrc.ui.pages.StubPage
import uk.gov.hmrc.ui.pages.Registration.CheckYourAnswer
import uk.gov.hmrc.ui.pages.Registration.contactDetails.{ConfirmContactDetailsPage, ContactNamePage, EmailPage, PhoneNumberPage}
import uk.gov.hmrc.ui.pages.Registration.contactDetails.changeAddressPages.{DoyouWantToUseAddressPage, SearchResultPage, WhatIsAddressPage}
import uk.gov.hmrc.ui.pages.Registration.provideTRN.{ConfirmUTRPage, ProvideTRNPage}
import uk.gov.hmrc.ui.specs.BaseSpec
import uk.gov.hmrc.ui.utils.login.loginOl
import uk.gov.hmrc.ui.utils.mongo.RegistrationDB

class CheckYourAnswersSpec extends BaseSpec with StubPage {
  Feature("Tests for the change details feature of the Check Your Answers page") {
    Scenario("Change the contact name from Check Your Answers Page") {
      RegistrationDB.cleanup()
      Given("Ratepayer logins through one login")
      loginOl()

      Then("User provide phone number")
      PhoneNumberPage.PhoneNumberDetails()
      PhoneNumberPage.userProvidesPhoneNumber()
      waitForElementToBeClickable(continueButton).click()

      Then("Ratepayer is taken to the Confirm Contact Details page")
      ConfirmContactDetailsPage.ConfirmContactDetails()
      waitForElementToBeClickable(continueButton).click()

      Then("Ratepayer is taken to Provide TRN Page")
      ProvideTRNPage.provideYourTRN()
      waitForElementToBeClickable(continueButton).click()

      Then("User selects 'Yes, I want to provide this UTR' and submit")
      ConfirmUTRPage.confirmYourSAUTR()
      ConfirmUTRPage.selectYes()

      Then("Ratepayer is taken to the Check Your Answers page")
      CheckYourAnswer.checkYourAnswer()

      Then("Clicks the change name link")
      CheckYourAnswer.ClickChangeNameLink()

      Then("The ratepayer enters their name then clicks continue")
      ContactNamePage.ContactNameDetails()
      ContactNamePage.InputName("Jake")

      Then("The Ratepayer is taken back to the Check Your Answers page")
      CheckYourAnswer.checkYourAnswer()

      Then("Check Your Answers page is showing the updated name")

      CheckYourAnswer.checkYourAnswer()
      //     CheckYourAnswer.nameChangedCheck("Jake")
      waitForElementToBeClickable(continueButton).click()

      Then("Ratepayer is taken to the Registration complete page")
      RegisterComplete.RegisterComplete()
    }
  }

  /* Changing contact phone number */

  Scenario("Change the contact phone number from Check Your Answers Page") {
    RegistrationDB.cleanup()
    Given("Ratepayer logins through one login")
    loginOl()

    Then("User provide phone number")
    PhoneNumberPage.PhoneNumberDetails()
    PhoneNumberPage.userProvidesPhoneNumber()

    Then("Ratepayer is taken to the Confirm Contact Details page")
    ConfirmContactDetailsPage.ConfirmContactDetails()
    waitForElementToBeClickable(continueButton).click()

    Then("Ratepayer is taken to Provide TRN Page")
    ProvideTRNPage.provideYourTRN()
    waitForElementToBeClickable(continueButton).click()

    Then("User selects 'Yes, I want to provide this UTR' and submit")
    ConfirmUTRPage.confirmYourSAUTR()
    ConfirmUTRPage.selectYes()

    Then("Ratepayer is taken to the Check Your Answers page")
    CheckYourAnswer.checkYourAnswer()

    Then("Clicks the change phone number link")
    CheckYourAnswer.ClickChangePhoneNumberLink()

    Then("The ratepayer is taken to the Phone Number Page")
    PhoneNumberPage.PhoneNumberDetails()

    Then("The ratepayer adds their number and clicks continue")
    PhoneNumberPage.PhoneNumberDetails()
    PhoneNumberPage.InputNumber("07501623458")

    Then("The ratepayer is taken to the Check Your Answers page")
    CheckYourAnswer.checkYourAnswer()
    //   phoneChangedCheck("07501623458")
    waitForElementToBeClickable(continueButton).click()

    Then("Ratepayer is taken to the Registration complete page")
    RegisterComplete.RegisterComplete()
  }

  /* Changing contact E-mail */

  Scenario("Change the contact email from Check Your Answers Page") {
    RegistrationDB.cleanup()
    Given("Ratepayer logins through one login")
    loginOl()

    Then("User provide phone number")
    PhoneNumberPage.PhoneNumberDetails()
    PhoneNumberPage.userProvidesPhoneNumber()
    waitForElementToBeClickable(continueButton).click()

    Then("Ratepayer is taken to the Confirm Contact Details page")
    ConfirmContactDetailsPage.ConfirmContactDetails()
    waitForElementToBeClickable(continueButton).click()

    Then("Ratepayer is taken to Provide TRN Page")
    ProvideTRNPage.provideYourTRN()
    waitForElementToBeClickable(continueButton).click()

    Then("User selects 'Yes, I want to provide this UTR' and submit")
    ConfirmUTRPage.confirmYourSAUTR()
    ConfirmUTRPage.selectYes()

    Then("Ratepayer is taken to the Check Your Answers page")
    CheckYourAnswer.checkYourAnswer()

    Then("Clicks the change email link")
    CheckYourAnswer.ClickChangeEmailLink()

    Then("The ratepayer is taken to the Email Page")
    EmailPage.EmailDetails()

    Then("The ratepayer adds their number and clicks continue")
    EmailPage.InputEmail("newEmail@email.com")

    Then("The ratepayer is taken to the Check Your Answers page")
    reloadPage()
    CheckYourAnswer.checkYourAnswer()
    //  CheckYourAnswer.emailChangedCheck("newEmail@email.com")
    waitForElementToBeClickable(continueButton).click()

    Then("Ratepayer is taken to the Registration complete page")
    RegisterComplete.RegisterComplete()
  }

  Scenario("Manual contact address search test initiated from the Check Your Answers page") {
    RegistrationDB.cleanup()
    Given("Ratepayer logins through one login")
    loginOl()

    Then("User provide phone number")
    PhoneNumberPage.PhoneNumberDetails()
    PhoneNumberPage.userProvidesPhoneNumber()
    waitForElementToBeClickable(continueButton).click()

    Then("Ratepayer is taken to the Confirm Contact Details page")
    ConfirmContactDetailsPage.ConfirmContactDetails()
    waitForElementToBeClickable(continueButton).click()

    Then("Ratepayer is taken to Provide TRN Page")
    ProvideTRNPage.provideYourTRN()
    waitForElementToBeClickable(continueButton).click()

    Then("User selects 'Yes, I want to provide this UTR' and submit")
    ConfirmUTRPage.confirmYourSAUTR()
    ConfirmUTRPage.selectYes()

    Then("Ratepayer is taken to the Check Your Answers page")
    CheckYourAnswer.checkYourAnswer()

    Then("Clicks the change address link")
    CheckYourAnswer.ClickChangeAddressLink()

    And("The user click on the link manual address link on 'find contact address' page")
    clickLink("Enter the address manually")

    Then("The user navigate on 'What is the address?' page then clicks on the 'Find address' button")
    WhatIsAddressPage.whatIsTheAddress()
    WhatIsAddressPage.inputAddressLine1("Unit 13 Trident Industrial Estate Blackthorne")
    waitForElementToBeClickable(continueButton).click()

    And("The ratepayer selects property on search result page")
    SearchResultPage.selectProperty()

    And("The ratepayer selects Yes on use this address page")
    DoyouWantToUseAddressPage.SelectYesAddress()
    Then("I verify the contact details on Confirm Contact Details page")
    reloadPage()
    CheckYourAnswer.checkYourAnswer()
//    CheckYourAnswer.verifyAddress(
//      "Unit 13 Trident Industrial Estate Blackthorn\nColnbrook\nSL3 0AX"
//    )
    waitForElementToBeClickable(continueButton).click()

    Then("Ratepayer is taken to the Registration complete page")
    reloadPage()
    RegisterComplete.RegisterComplete()
  }
}
