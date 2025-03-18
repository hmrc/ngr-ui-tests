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
import uk.gov.hmrc.ui.pages.contactDetails.{ConfirmContactDetailsPage, ContactNamePage, EmailPage, FindContactAddressPage, PhoneNumberPage, SearchResultPage}
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

      Then("Clicks the name link")
      ConfirmContactDetailsPage.ClickChangeNameLink()
      Then("Name the page is shown")
      ContactNamePage.ContactNameDetails()
      Then("The ratepayer enters their name and clicks continue")
      ContactNamePage.InputName()
      Then("The ratepayer is taken to the Confirm Contact Details page")
      ConfirmContactDetailsPage.ConfirmContactDetails()

      Then("Clicks the add phone number link")
      ConfirmContactDetailsPage.ClickChangePhoneNumberLink()
      Then("The ratepayer is taken to the Phone Number Page")
      PhoneNumberPage.PhoneNumberDetails()
      Then("The ratepayer adds their number and clicks continue")
      PhoneNumberPage.InputNumber()
      Then("The ratepayer is taken to the Confirm Contact Details page")
      ConfirmContactDetailsPage.ConfirmContactDetails()

      Then("Clicks the change email link")
      ConfirmContactDetailsPage.ClickChangeEmailLink()
      Then("The ratepayer is taken to the Email Page")
      EmailPage.EmailDetails()
      Then("The ratepayer adds their number and clicks continue")
      EmailPage.InputEmail()
      Then("The ratepayer is taken to the Confirm Contact Details page")
      ConfirmContactDetailsPage.ConfirmContactDetails()

      Then("Clicks the change address link")
      ConfirmContactDetailsPage.ClickChangeAddressLink()
      Then("The ratepayer enters postcode and clicks continue on Find the contact address page")
      FindContactAddressPage.findAddress()
      FindContactAddressPage.InputPostcode()
      Then("The ratepayer selects property on search result page")
      SearchResultPage.selectProperty()

    }

  }

}
