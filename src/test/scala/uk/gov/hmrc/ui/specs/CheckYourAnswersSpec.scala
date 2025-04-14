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

import uk.gov.hmrc.ui.pages.CheckYourAnswer.{emailChangedCheck, phoneChangedCheck}
import uk.gov.hmrc.ui.pages.contactDetails.changeAddressPages.{DoyouWantToUseAddressPage, FindContactAddressPage, SearchResultPage}
import uk.gov.hmrc.ui.pages.{CheckYourAnswer, StubPage}
import uk.gov.hmrc.ui.pages.contactDetails.{ConfirmContactDetailsPage, ContactNamePage, EmailPage, PhoneNumberPage}
import uk.gov.hmrc.ui.pages.provideTRN.{ConfirmUTRPage, ProvideTRNPage}
import uk.gov.hmrc.ui.utils.login.loginOl

class CheckYourAnswersSpec extends BaseSpec with StubPage {
  Feature("Tests for the change details feature of the Check Your Answers page") {

    /* Changing contact name */

    Scenario("Change the contact name from Check Your Answers Page") {
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

      Then("Clicks the name link")
      CheckYourAnswer.ClickChangeNameLink()

      Then("Name the page is shown")
      ContactNamePage.ContactNameDetails()

      Then("The ratepayer enters their name and clicks continue")
      ContactNamePage.InputName("Unfunny Jake")

      Then("The Ratepayer is taken back to the Check Your Answers page, with the name changed")
      CheckYourAnswer.checkYourAnswer()
      CheckYourAnswer.nameChangedCheck("Unfunny Jake")

    }

    /* Changing contact phone number */

    Scenario("Change the contact phone number from Check Your Answers Page") {
      Given("Ratepayer logins through one login")
      loginOl()

      Then("Ratepayer is taken to the Confirm Contact Details page")
      ConfirmContactDetailsPage.ConfirmContactDetails()
      click(continueButton)

      Then("Ratepayer is taken to Provide TRN Page")
      ProvideTRNPage.provideYourTRN()
      click(continueButton)

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
      PhoneNumberPage.InputNumber("07501623458")

      Then("The ratepayer is taken to the Check Your Answers page")
      CheckYourAnswer.checkYourAnswer()
      phoneChangedCheck("07501623458")
    }

    /* Changing contact E-mail */

    Scenario("Change the contact email from Check Your Answers Page") {
      Given("Ratepayer logins through one login")
      loginOl()

      Then("Ratepayer is taken to the Confirm Contact Details page")
      ConfirmContactDetailsPage.ConfirmContactDetails()
      click(continueButton)

      Then("Ratepayer is taken to Provide TRN Page")
      ProvideTRNPage.provideYourTRN()
      click(continueButton)

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
      CheckYourAnswer.checkYourAnswer()
      emailChangedCheck("newEmail@email.com")
    }

    /* Changing contact address */

    Scenario("Change the contact address from Check Your Answers Page") {
      Given("Ratepayer logins through one login")
      loginOl()

      Then("Ratepayer is taken to the Confirm Contact Details page")
      ConfirmContactDetailsPage.ConfirmContactDetails()
      click(continueButton)

      Then("Ratepayer is taken to Provide TRN Page")
      ProvideTRNPage.provideYourTRN()
      click(continueButton)

      Then("User selects 'Yes, I want to provide this UTR' and submit")
      ConfirmUTRPage.confirmYourSAUTR()
      ConfirmUTRPage.selectYes()

      Then("Ratepayer is taken to the Check Your Answers page")
      CheckYourAnswer.checkYourAnswer()

      Then("Clicks the change address link")
      CheckYourAnswer.ClickChangeAddressLink()

      Then("The ratepayer enters postcode and clicks continue on Find the contact address page")
      FindContactAddressPage.findAddress()
      FindContactAddressPage.inputPostCode("TF4 3ED")

      And("The ratepayer selects property on search result page")
      SearchResultPage.searchResult()
      SearchResultPage.selectProperty()

      /* Changing selecting Yes on the radio button */

      And("The ratepayer selects Yes on use this address page")
      DoyouWantToUseAddressPage.SelectYesAddress()
      Then("I verify the contact details on Check Your Answers page")
      CheckYourAnswer.checkYourAnswer()
      CheckYourAnswer.verifyAddress("34 Manor Road\nDawley\nTelford\nTF4 3ED")
    }
  }

}
