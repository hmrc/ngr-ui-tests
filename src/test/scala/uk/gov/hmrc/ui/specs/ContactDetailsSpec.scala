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

import uk.gov.hmrc.ui.pages._
import uk.gov.hmrc.ui.pages.contactDetails.{ConfirmContactDetailsPage, ContactNamePage, DoyouWantToUseAddressPage, EmailPage, FindContactAddressPage, PhoneNumberPage, SearchResultPage}
import uk.gov.hmrc.ui.utils.login.loginOl

class ContactDetailsSpec extends BaseSpec with StubPage {

  Feature("Tests for the Changes Contact Details page, OL route") {

//    Scenario("Verify contact details after Authentication") {
//      Given("Ratepayer logins through one login")
//      loginOl()
//
//      Then("Ratepayer is taken to the Confirm Contact Details page")
//      ConfirmContactDetailsPage.ConfirmContactDetails()
//
//      Then("All the rate payers details are present on the contact details page")
//      ConfirmContactDetailsPage.nameDisplay("BOB JONES")
//      ConfirmContactDetailsPage.emailDisplay("66666666email@email.com")
//      ConfirmContactDetailsPage.addressDisplay("11 Test Street\nTesttown\nFX97 4TU\nGREAT BRITAIN")
//    }

    Scenario("Change the contact details of ratepayer, OL route") {
      Given("Ratepayer logins through one login")
      loginOl()

      Then("Ratepayer is taken to the Confirm Contact Details page")
      ConfirmContactDetailsPage.ConfirmContactDetails()

      /*Change name*/
      Then("Clicks the name link")
      ConfirmContactDetailsPage.ClickChangeNameLink()
      Then("Name the page is shown")
      ContactNamePage.ContactNameDetails()
      Then("The ratepayer enters their name and clicks continue")
      ContactNamePage.InputName()
      Then("The ratepayer is taken to the Confirm Contact Details page")
      ConfirmContactDetailsPage.ConfirmContactDetails()

      /*Change phone number*/
      Then("Clicks the change phone number link")
      ConfirmContactDetailsPage.ClickChangePhoneNumberLink()
      Then("The ratepayer is taken to the Phone Number Page")
      PhoneNumberPage.PhoneNumberDetails()
      Then("The ratepayer adds their number and clicks continue")
      PhoneNumberPage.InputNumber()
      Then("The ratepayer is taken to the Confirm Contact Details page")
      ConfirmContactDetailsPage.ConfirmContactDetails()

      /*Change email*/
      Then("Clicks the change email link")
      ConfirmContactDetailsPage.ClickChangeEmailLink()
      Then("The ratepayer is taken to the Email Page")
      EmailPage.EmailDetails()
      Then("The ratepayer adds their number and clicks continue")
      EmailPage.InputEmail()
      Then("The ratepayer is taken to the Confirm Contact Details page")
      ConfirmContactDetailsPage.ConfirmContactDetails()

      /*Change Address*/
      Then("Clicks the change address link")
      ConfirmContactDetailsPage.ClickChangeAddressLink()
      Then("The ratepayer enters postcode and clicks continue on Find the contact address page")
      FindContactAddressPage.findAddress()
      FindContactAddressPage.InputPostcode()
      And("The ratepayer selects property on search result page")
      SearchResultPage.selectProperty()

      /** Selecting Yes radio button* */
      And("The ratepayer selects Yes on use this address page")
      DoyouWantToUseAddressPage.SelectYesAddress()
      Then("I verifify the contact details on Confirm Contact Details page")
      ConfirmContactDetailsPage.ConfirmContactDetails()
      ConfirmContactDetailsPage.addressDisplay("34 Manor Road\nDawley\nTelford\nTF4 3ED\nGREAT BRITAIN")
    }

    Scenario("Testing of different flow for change address, OL route") {
      Given("Ratepayer logins through one login")
      loginOl()

      Then("Clicks the change address link on the Confirm Contact Details page")
      ConfirmContactDetailsPage.ConfirmContactDetails()
      ConfirmContactDetailsPage.ClickChangeAddressLink()
      Then("The ratepayer enters postcode and clicks continue on Find the contact address page")
      FindContactAddressPage.InputPostcode()

      /** Search again link* */
      And("Clicking on 'Search again' link on search result page taken back to Find the contact address page")
      SearchResultPage.searchResult()
      SearchResultPage.searchAgain()
      FindContactAddressPage.findAddress()
      Then("The ratepayer enters postcode and clicks continue")
      FindContactAddressPage.InputPostcode()

      /** Selecting property from 2nd page* */
      And("The user selects first property from the 2nd page of the 'search result'")
      SearchResultPage.paginationLink("2")
      SearchResultPage.selectProperty()
      And("The ratepayer selects Yes on use this address page")
      DoyouWantToUseAddressPage.addressdisplay("44 Manor Road, Dawley, Telford TF4 3ED")
      DoyouWantToUseAddressPage.SelectYesAddress()
      Then("I verifify the contact details on Confirm Contact Details page")
      ConfirmContactDetailsPage.ConfirmContactDetails()
      ConfirmContactDetailsPage.addressDisplay("44 Manor Road\nDawley\nTelford\nTF4 3ED\nGREAT BRITAIN")

      /** Selecting No radio button on use this address page * */
      Then("Clicks the change address link on the Confirm Contact Details page")
      ConfirmContactDetailsPage.ClickChangeAddressLink()
      Then("The ratepayer enters postcode and clicks continue on Find the contact address page")
      FindContactAddressPage.InputPostcode()
      And("The ratepayer selects property on search result page")
      SearchResultPage.paginationLink("2")
      SearchResultPage.paginationLink("1")
      SearchResultPage.selectProperty()
      And("The ratepayer selects No on use this address page")
      DoyouWantToUseAddressPage.addressdisplay("34 Manor Road, Dawley, Telford TF4 3ED")
      DoyouWantToUseAddressPage.SelectNoAddress()
      Then("The ratepayer is taken to the Confirm Contact Details page")
      ConfirmContactDetailsPage.ConfirmContactDetails()
      ConfirmContactDetailsPage.addressDisplay("44 Manor Road\nDawley\nTelford\nTF4 3ED\nGREAT BRITAIN")
    }

  }

}
