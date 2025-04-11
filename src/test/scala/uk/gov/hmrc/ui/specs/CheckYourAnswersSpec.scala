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

import uk.gov.hmrc.ui.pages.contactDetails.changeAddressPages.{DoyouWantToUseAddressPage, FindContactAddressPage, SearchResultPage}
import uk.gov.hmrc.ui.pages.{CheckYourAnswer, StubPage}
import uk.gov.hmrc.ui.pages.contactDetails.{ConfirmContactDetailsPage, ContactNamePage, EmailPage, PhoneNumberPage}
import uk.gov.hmrc.ui.pages.provideTRN.{ConfirmUTRPage, ProvideTRNPage}
import uk.gov.hmrc.ui.utils.login.loginOl

class CheckYourAnswersSpec extends BaseSpec with StubPage {
  Feature("Tests for the change of the Check Your Answers page") {
    Scenario("Change the contact name") {
      Given("Ratepayer logins through one login")
      loginOl()

      Then("Ratepayer is taken to the Confirm Contact Details page")
      ConfirmContactDetailsPage.ConfirmContactDetails()
      click(continueButton)

      Then("Ratepayer is taken to Provide TRN Page")
      ProvideTRNPage.provideYourTRN()
      click(continueButton)

      Then("User selects 'Yes, I want to provide this UTR' and submit")
      ConfirmUTRPage.selectYes()
      click(continueButton)

      Then("Ratepayer is taken to the Check Your Answers page")
      CheckYourAnswer.checkYourAnswer()

      Then("Clicks the name link")
      CheckYourAnswer.ClickChangeNameLink()

      Then("Name the page is shown")
      ContactNamePage.ContactNameDetails()

      Then("The ratepayer enters their name and clicks continue")
      ContactNamePage.InputName()

      Then("The Ratepayer is taken back to the Check Your Answers page")
      CheckYourAnswer.checkYourAnswer()

    }
    Scenario("Change the contact phone number") {
      Given("Ratepayer logins through one login")
      loginOl()

      Then("Ratepayer is taken to the Confirm Contact Details page")
      ConfirmContactDetailsPage.ConfirmContactDetails()
      click(continueButton)

      Then("Ratepayer is taken to Provide TRN Page")
      ProvideTRNPage.provideYourTRN()
      click(continueButton)

      Then("User selects 'Yes, I want to provide this UTR' and submit")
      ConfirmUTRPage.selectYes()
      click(continueButton)

      Then("Ratepayer is taken to the Check Your Answers page")
      CheckYourAnswer.checkYourAnswer()

      Then("Clicks the change phone number link")
      CheckYourAnswer.ClickChangePhoneNumberLink()

      Then("The ratepayer is taken to the Phone Number Page")
      PhoneNumberPage.PhoneNumberDetails()

      Then("The ratepayer adds their number and clicks continue")
      PhoneNumberPage.InputNumber()

      Then("The ratepayer is taken to the Check Your Answers page")
      CheckYourAnswer.checkYourAnswer()
    }

    Scenario("Change the contact email") {
      Given("Ratepayer logins through one login")
      loginOl()

      Then("Ratepayer is taken to the Confirm Contact Details page")
      ConfirmContactDetailsPage.ConfirmContactDetails()
      click(continueButton)

      Then("Ratepayer is taken to Provide TRN Page")
      ProvideTRNPage.provideYourTRN()
      click(continueButton)

      Then("User selects 'Yes, I want to provide this UTR' and submit")
      ConfirmUTRPage.selectYes()
      click(continueButton)

      Then("Ratepayer is taken to the Check Your Answers page")
      CheckYourAnswer.checkYourAnswer()

      Then("Clicks the change email link")
      CheckYourAnswer.ClickChangeEmailLink()

      Then("The ratepayer is taken to the Email Page")
      EmailPage.EmailDetails()

      Then("The ratepayer adds their number and clicks continue")
      EmailPage.InputEmail()

      Then("The ratepayer is taken to the Check Your Answers page")
      CheckYourAnswer.checkYourAnswer()
    }

    Scenario("Change the contact address") {
      Given("Ratepayer logins through one login")
      loginOl()

      Then("Ratepayer is taken to the Confirm Contact Details page")
      ConfirmContactDetailsPage.ConfirmContactDetails()
      click(continueButton)

      Then("Ratepayer is taken to Provide TRN Page")
      ProvideTRNPage.provideYourTRN()
      click(continueButton)

      Then("User selects 'Yes, I want to provide this UTR' and submit")
      ConfirmUTRPage.selectYes()
      click(continueButton)

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

      /** Selecting Yes radio button* */
      And("The ratepayer selects Yes on use this address page")
      DoyouWantToUseAddressPage.SelectYesAddress()
      Then("I verifify the contact details on Check Your Answers page")
      CheckYourAnswer.checkYourAnswer()
      CheckYourAnswer.verifyAddress("34 Manor Road\nDawley\nTelford\nTF4 3ED")
    }

    Scenario("Testing 'search again' link for change address") {
      Given("Ratepayer logins through one login")
      loginOl()

      Then("Ratepayer is taken to the Confirm Contact Details page")
      ConfirmContactDetailsPage.ConfirmContactDetails()
      click(continueButton)

      Then("Ratepayer is taken to Provide TRN Page")
      ProvideTRNPage.provideYourTRN()
      click(continueButton)

      Then("User selects 'Yes, I want to provide this UTR' and submit")
      ConfirmUTRPage.selectYes()
      click(continueButton)

      Then("Clicks the change address link on the Check Your Answers page")
      CheckYourAnswer.checkYourAnswer()
      CheckYourAnswer.ClickChangeAddressLink()
      Then("The ratepayer enters postcode and clicks continue on Find the contact address page")
      FindContactAddressPage.inputPostCode("TF4 3ED")

      And("Clicking on 'Search again' link on search result page taken back to Find the contact address page")
      SearchResultPage.searchResult()
      SearchResultPage.searchAgain()
      FindContactAddressPage.findAddress()
      Then("The ratepayer enters postcode and clicks continue")
      FindContactAddressPage.inputPostCode("SL3 0AX")
      SearchResultPage.selectProperty()
      And("The ratepayer selects Yes on use this address page")
      DoyouWantToUseAddressPage.confirmAddress(
        "Unit 13, Trident Industrial Estate Blackthor, Colnbrook, Slough SL3 0AX"
      )
      DoyouWantToUseAddressPage.SelectYesAddress()
      Then("I verifify the contact details on Check Your Answers page")
      CheckYourAnswer.checkYourAnswer()
      CheckYourAnswer.verifyAddress(
        "Unit 13\nTrident Industrial Estate Blackthor, Colnbrook\nSlough\nSL3 0AX"
      )
    }

    Scenario("Testing search using property number/name") {
      Given("Ratepayer logins through one login")
      loginOl()

      Then("Ratepayer is taken to the Confirm Contact Details page")
      ConfirmContactDetailsPage.ConfirmContactDetails()
      click(continueButton)

      Then("Ratepayer is taken to Provide TRN Page")
      ProvideTRNPage.provideYourTRN()
      click(continueButton)

      Then("User selects 'Yes, I want to provide this UTR' and submit")
      ConfirmUTRPage.selectYes()
      click(continueButton)

      Then("Clicks the change address link on the Check Your Answers page")
      CheckYourAnswer.ClickChangeAddressLink()
      Then("The ratepayer enters postcode and property number")
      FindContactAddressPage.inputPostCodePropertyNumber("TF4 3ED", "40")
      And("The ratepayer selects property on search result page")
      SearchResultPage.selectProperty()

      And("The ratepayer selects No on use this address page")
      DoyouWantToUseAddressPage.confirmAddress("40 Manor Road, Dawley, Telford TF4 3ED")
      DoyouWantToUseAddressPage.SelectNoAddress()
      Then("The ratepayer is taken to the Check Your Answers page")
      CheckYourAnswer.checkYourAnswer()
      CheckYourAnswer.verifyAddress(
        "Unit 13\nTrident Industrial Estate Blackthor, Colnbrook\nSlough\nSL3 0AX"
      )
    }

    Scenario("Testing manual search") {
      Given("Ratepayer logins through one login")
      loginOl()

      Then("Clicks the change address link on the Check Your Answers page")
      CheckYourAnswer.ClickChangeAddressLink()

      And("The user click on the link 'Enter the address manually'")
      clickLink("Enter the address manually")

    }
  }

}
