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

import uk.gov.hmrc.ui.pages.contactDetails._
import uk.gov.hmrc.ui.pages.dashboard.DashboardHome
import uk.gov.hmrc.ui.pages.propertyLinking.PropertyLinkingCYA.hitCYAStep
import uk.gov.hmrc.ui.pages.propertyLinking._
import uk.gov.hmrc.ui.pages.provideTRN.{ConfirmUTRPage, ProvideTRNPage}
import uk.gov.hmrc.ui.pages.{CheckYourAnswer, RegisterComplete, StubPage}
import uk.gov.hmrc.ui.utils.login.loginOl
import uk.gov.hmrc.ui.utils.mongo.RegistrationDB

class AddAPropertySpec extends BaseSpec with StubPage {

  var contactName: String = "BOB JONES"
  val postCode            = "BH1 1HU"

  Feature("Testing the 'Add Property' functionality") {

    Scenario("The user completes registration and navigates to the Add a property page") {
      RegistrationDB.cleanup()

      Given("Ratepayer logins through one login")
      loginOl()

      Then("User provide phone number")
      PhoneNumberPage.userProvidesPhoneNumber()

      Then("Ratepayer is taken to the Confirm Contact Details page")
      ConfirmContactDetailsPage.ConfirmContactDetails()
      click(continueButton)

      Then("Ratepayer is taken to Provide TRN Page")
      ProvideTRNPage.provideYourTRN()
      click(continueButton)

      Then("User selects 'Yes, I want to provide this UTR' and submit")
      ConfirmUTRPage.selectYes()

      Then("The ratepayer is taken to the 'Check your answers' page")
      CheckYourAnswer.checkYourAnswer()
      contactName = getElementByCssSelector("#contact-name-id").toString
      click(continueButton)

      Then("Ratepayer is taken to the Registration complete page")
      RegisterComplete.RegisterComplete()
      click(continueButton)

      Then("Ratepayer is now fully registered and is taken to the dashboard")
      DashboardHome.DashboardHome(contactName)

      Then("Ratepayer clicks the Add a Property link and is taken to the Add a Property page")
      clickLink("Add a property")
      AddAProperty.addAProperty()
      click(continueButton)

      Then("Ratepayer is taken to the What You Need page")
      WhatYouNeed.whatYouNeed()

      /** ToDo Add tests for council navigation */
      // contactLinkDisplay("contact your local council (opens in a new tab)")
      click(continueButton)

      Then("Ratepayer is taken to the find a property page and searches for a property")
      FindAProperty.findProperty()
      FindAProperty.inputPostCode(postCode)

      Then("Ratepayer is taken to the search results page")
      PropertySearchResultPage.searchResult(postCode)
      clickLink("Select property")

      Then("Ratepayer is taken to the selected property page, clicks the 'yes' radio and continues")
      SelectedProperty.selectedProperty()
      SelectedProperty.yesRadio()

      Then("Ratepayer selects 'Before 1 April 2026' on 'When did you become the current ratepayer?' page")
      CurrentRatepayer.currentRatepayer()
      CurrentRatepayer.beforeDateRadio()

      And("The ratepayers selects 'yes' on 'business rates bill for the property' page")
      BusinessRateBillPage.BusinessRateBill()
      BusinessRateBillPage.selectNo()

      /** ToDo Add tests for NO radio button selection */

    }

    Scenario("Ratepayer navigates to the add a property page and clicks the account home link") {

      Given("Ratepayer logins through one login")
      loginOl()

      Then("Ratepayer is taken to the dashboard")
      DashboardHome.DashboardHome(contactName)

      Then("Ratepayer clicks the add a property link")
      clickLink("Add a property")
      AddAProperty.addAProperty()

      Then("Ratepayer clicks the account home link and is taken to the dashboard")
      clickLink("Account home")
      DashboardHome.DashboardHome(contactName)

    }

    Scenario("Testing 'no Results Found' feature for property search") {

      Given("Ratepayer logins through one login")
      loginOl()

      Then("Ratepayer is now fully registered and is taken to the dashboard")
      DashboardHome.DashboardHome(contactName)

      Then("Ratepayer clicks the Add a Property link and is taken to the Add a Property page")
      clickLink("Add a property")
      AddAProperty.addAProperty()
      click(continueButton)

      Then("Ratepayer is taken to the What You Need page")
      WhatYouNeed.whatYouNeed()
      click(continueButton)

      Then("Ratepayer is taken to the search a property page and searches for a property that does not exist")
      FindAProperty.findProperty()
      FindAProperty.inputPostCode("LS1 9LB")
      FindAProperty.noResultsFound()
    }

    Scenario("Registered ratepayer adds the property ") {

      Given("Ratepayer logins through one login")
      loginOl()

      Then("Ratepayer is now fully registered and is taken to the dashboard")
      DashboardHome.DashboardHome(contactName)

      Then("Ratepayer clicks the Add a Property link and is taken to the Add a Property page")
      clickLink("Add a property")
      AddAProperty.addAProperty()
      click(continueButton)

      Then("Ratepayer is taken to the What You Need page")
      WhatYouNeed.whatYouNeed()
      click(continueButton)

      Then("Ratepayer is taken to the find a property page and searches for a property")
      FindAProperty.findProperty()
      FindAProperty.inputPostCode(postCode)

      Then("Ratepayer is taken to the search results page")
      PropertySearchResultPage.searchResult(postCode)

      Then("Ratepayer clicks the search again link and is take back to the Find a property page")
      clickLink("Search again")

      Then("Ratepayer searches for a property")
      FindAProperty.findProperty()
      FindAProperty.inputPostCode(postCode)

      Then("Ratepayer is taken to the search results page and opens the help-if-you-cannot-find-your-property span")
      PropertySearchResultPage.searchResult(postCode)
      PropertySearchResultPage.clickHelpSpan()

      Then("Ratepayer clicks the search again link within the span and is take back to the Find a property page")
      PropertySearchResultPage.searchAgainUnderHelpLink()
      FindAProperty.findProperty()

      Then("Ratepayer searches for a property")
      FindAProperty.inputPostCode(postCode)

      Then("Ratepayer click 'Select property' on the search results page")
      PropertySearchResultPage.searchResult(postCode)
      clickLink("Select property")

      Then("Ratepayer is taken to the selected property page, clicks the 'no' radio and continues")
      SelectedProperty.selectedProperty()
      SelectedProperty.noRadio()

      Then("Ratepayer is taken back to the Search Result page and clicks the 'Select property' link")
      PropertySearchResultPage.searchResult(postCode)
      clickLink("Select property")

      Then("Ratepayer is taken to the selected property page, clicks the 'yes' radio and continues")
      SelectedProperty.selectedProperty()
      SelectedProperty.yesRadio()

      Then("Ratepayer selects 'Before 1 April 2026' on 'When did you become the current ratepayer?' page")
      CurrentRatepayer.currentRatepayer()
      CurrentRatepayer.clickHelpSpan()
      CurrentRatepayer.beforeDateRadio()

      Then("The ratepayers selects 'yes' on 'business rates bill for the property' page")
      BusinessRateBillPage.BusinessRateBill()
      BusinessRateBillPage.selectYes()

//      And("The ratepayers selects 'Owner' on 'connection to the property' page")
//      ConnectionToPropertyPage.ConnectionToProperty()
//      ConnectionToPropertyPage.ConnectionType("Owner")
//
//      And("The ratepayers navigate to confirm your details page")

      Then("The ratepayer hits the CYA page")
      PropertyLinkingCYA.hitCYAStep()
      PropertyLinkingCYA.checkYourAnswer()
      val propertyAddress = getElementByCssSelector("#property-to-add-to-account-id").toString
      click(continueButton)

      Then("The ratepayer hits the declaration page, and clicks accept")
      DeclarationPage.declaration()
      click(continueButton)

      And("The ratepayer is taken to the Property Request sent page, displaying the correct property address")
      RequestSentPage.requestSent()
      RequestSentPage.reqPrintLinkDisplay("Print or save this page")
      RequestSentPage.requestSentAddressCheck(propertyAddress)
    }
  }
}
