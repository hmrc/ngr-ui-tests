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

package uk.gov.hmrc.ui.specs.PropertyLinking

import uk.gov.hmrc.ui.pages.Dashboard.DashboardHome
import uk.gov.hmrc.ui.pages.PropertyLinking.RegisterComplete.printLinkDisplay
import uk.gov.hmrc.ui.pages.PropertyLinking._
import uk.gov.hmrc.ui.pages.Registration.{CheckYourAnswer, ConfirmUTRPage, NinoPage, PhoneNumberPage, ProvideTRNPage}
import uk.gov.hmrc.ui.pages.StubPage
import uk.gov.hmrc.ui.specs.BaseSpec
import uk.gov.hmrc.ui.utils.login.loginOl
import uk.gov.hmrc.ui.utils.mongo.{PropertyLinkingDB, RegistrationDB}

class AddAPropertySpec extends BaseSpec with StubPage {

  var contactName: String = "BOB JONES"
  val postCode            = "BH1 1HU"

  Feature("Testing the 'Add Property' functionality") {

    Scenario("The user completes registration and adds a property") {
      RegistrationDB.cleanup()
      PropertyLinkingDB.cleanup()

      Given("Ratepayer logins through one login")
      loginOl()

      Then("User provide phone number")
      PhoneNumberPage.userProvidesPhoneNumber()

      Then("Ratepayer is taken to Provide TRN Page")
      ProvideTRNPage.provideYourTRN()
      continueButtonClick()
      Then("User selects 'NO, I want to provide this NINO' and submit")
      ConfirmUTRPage.confirmYourSAUTR()
      ConfirmUTRPage.selectNoProvideNI()
      Then("The ratepayer is taken to the 'Provide your National Insurance number'")
      NinoPage.NinoDetails()
      NinoPage.InputNino("AA000003D")

      Then("The ratepayer is taken to the 'Check your answers' where NINO is masked")
      CheckYourAnswer.checkYourAnswer()
      CheckYourAnswer.confirmMAskedNINO("******03D")
      click(continueButton)

      Then("Ratepayer is taken to the Registration complete page")
      RegisterComplete.RegisterComplete()
      printLinkDisplay("Print this page")
      continueButtonClick()

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

      /** Tests for NO radio button selection * */
      And("The ratepayers selects 'No' on 'business rates bill for the property' page")
      BusinessRateBillPage.businessRateBill()
      BusinessRateBillPage.selectNo()

      Then("The ratepayer selects 'lease' on 'What evidence can you provide?' page")
      WhatEvidenceCanYouProvide.whatEvidenceCanYouProvide()
      WhatEvidenceCanYouProvide.selectEvidenceType("Lease")

      Then("The ratepayer uploads the Lease document on the lease document page")
      UploadYourLease.uploadYourLeaseHeader()
      UploadYourLease.uploadYourLeaseDocuments()
      continueButtonClick()

      Then("The ratepayer can check the uploaded file on the uploaded your lease screen")
      UploadedYourLease.uploadedYourLeaseHeader()
      UploadedYourLease.verifyUploadedItem("testFile.png", "Uploaded")
      continueButtonClick()

      Then("The ratepayer selects the connection to the property")
      ConnectionToPropertyPage.connectionToPropertyHeader()
      ConnectionToPropertyPage.connectionTypeRadio("Owner")

      Then("The ratepayer checks the provided details on the Check your answer screen")
      CheckYourAnswers.checkYourAnswersHeader()
      CheckYourAnswers.verifyPropertyLinkingDetails(
        "Property to add to account",
        "(INCL STORE R/O 2 & 2A) 2A, RODLEY LANE, RODLEY, LEEDS, BH1 1HU"
      )
      CheckYourAnswers.verifyPropertyLinkingDetails("Property reference", "1322564521")
      CheckYourAnswers.verifyPropertyLinkingDetails("When did you become the current ratepayer?", "Before 1 April 2026")
      CheckYourAnswers.verifyPropertyLinkingDetails("Do you have a business rates bill for this property?", "No")
      CheckYourAnswers.verifyPropertyLinkingDetails("What evidence can you provide?", "Lease")
      CheckYourAnswers.verifyPropertyLinkingDetails("Evidence document", "testFile.png")
      CheckYourAnswers.verifyPropertyLinkingDetails("What is your connection to the property?", "Owner")
      continueButtonClick()

      Then("The ratepayer accept the declaration")
      DeclarationPage.declaration()
      continueButtonClick()

      Then("The ratepayer is taken to the 'Add a property request sent' screen ")
      RegisterComplete.RegisterComplete()

    }

    Scenario("Ratepayer navigates to the add a property page and clicks the account home link") {

      RegistrationDB.cleanup()
      PropertyLinkingDB.cleanup()

      Given("Ratepayer logins through one login")
      loginOl()

      Then("User provide phone number")
      PhoneNumberPage.userProvidesPhoneNumber()

      Then("Ratepayer is taken to Provide TRN Page")
      ProvideTRNPage.provideYourTRN()
      continueButtonClick()
      Then("User selects 'NO, I want to provide this NINO' and submit")
      ConfirmUTRPage.confirmYourSAUTR()
      ConfirmUTRPage.selectNoProvideNI()
      Then("The ratepayer is taken to the 'Provide your National Insurance number'")
      NinoPage.NinoDetails()
      NinoPage.InputNino("AA000003D")

      Then("The ratepayer is taken to the 'Check your answers' where NINO is masked")
      CheckYourAnswer.checkYourAnswer()
      CheckYourAnswer.confirmMAskedNINO("******03D")
      click(continueButton)

      Then("Ratepayer is taken to the Registration complete page")
      RegisterComplete.RegisterComplete()
      printLinkDisplay("Print this page")
      continueButtonClick()

      Then("Ratepayer is now fully registered and is taken to the dashboard")
      DashboardHome.DashboardHome(contactName)

      Then("Ratepayer clicks the add a property link")
      clickLink("Add a property")
      AddAProperty.addAProperty()

      Then("Ratepayer clicks the account home link and is taken to the dashboard")
      clickLink("Account home")
      DashboardHome.DashboardHome(contactName)

    }

    Scenario("Testing 'no Results Found' feature for property search") {
      RegistrationDB.cleanup()
      PropertyLinkingDB.cleanup()

      Given("Ratepayer logins through one login")
      loginOl()

      Then("User provide phone number")
      PhoneNumberPage.userProvidesPhoneNumber()

      Then("Ratepayer is taken to Provide TRN Page")
      ProvideTRNPage.provideYourTRN()
      continueButtonClick()
      Then("User selects 'NO, I want to provide this NINO' and submit")
      ConfirmUTRPage.confirmYourSAUTR()
      ConfirmUTRPage.selectNoProvideNI()
      Then("The ratepayer is taken to the 'Provide your National Insurance number'")
      NinoPage.NinoDetails()
      NinoPage.InputNino("AA000003D")

      Then("The ratepayer is taken to the 'Check your answers' where NINO is masked")
      CheckYourAnswer.checkYourAnswer()
      CheckYourAnswer.confirmMAskedNINO("******03D")
      click(continueButton)

      Then("Ratepayer is taken to the Registration complete page")
      RegisterComplete.RegisterComplete()
      printLinkDisplay("Print this page")
      continueButtonClick()

      Then("Ratepayer is now fully registered and is taken to the dashboard")
      DashboardHome.DashboardHome(contactName)

      Then("Ratepayer clicks the Add a Property link and is taken to the Add a Property page")
      clickLink("Add a property")
      AddAProperty.addAProperty()
      continueButtonClick()

      Then("Ratepayer is taken to the What You Need page")
      WhatYouNeed.whatYouNeed()
      continueButtonClick()

      Then("Ratepayer is taken to the search a property page and searches for a property that does not exist")
      FindAProperty.findProperty()
      FindAProperty.inputPostCode("LS1 9LB")
      FindAProperty.noResultsFound()
    }

    Scenario("Testing manual address search feature for property search") {
      RegistrationDB.cleanup()
      PropertyLinkingDB.cleanup()

      Given("Ratepayer logins through one login")
      loginOl()

      Then("User provide phone number")
      PhoneNumberPage.userProvidesPhoneNumber()

      Then("Ratepayer is taken to Provide TRN Page")
      ProvideTRNPage.provideYourTRN()
      continueButtonClick()
      Then("User selects 'NO, I want to provide this NINO' and submit")
      ConfirmUTRPage.confirmYourSAUTR()
      ConfirmUTRPage.selectNoProvideNI()
      Then("The ratepayer is taken to the 'Provide your National Insurance number'")
      NinoPage.NinoDetails()
      NinoPage.InputNino("AA000003D")

      Then("The ratepayer is taken to the 'Check your answers' where NINO is masked")
      CheckYourAnswer.checkYourAnswer()
      CheckYourAnswer.confirmMAskedNINO("******03D")
      click(continueButton)

      Then("Ratepayer is taken to the Registration complete page")
      RegisterComplete.RegisterComplete()
      printLinkDisplay("Print this page")
      continueButtonClick()

      Then("Ratepayer is now fully registered and is taken to the dashboard")
      DashboardHome.DashboardHome(contactName)

      Then("Ratepayer clicks the Add a Property link and is taken to the Add a Property page")
      clickLink("Add a property")
      AddAProperty.addAProperty()
      continueButtonClick()

      Then("Ratepayer is taken to the What You Need page")
      WhatYouNeed.whatYouNeed()
      continueButtonClick()

      Then("Ratepayer is taken to the search a property page and clicks the enter manual address link")
      FindAProperty.findProperty()
      FindAProperty.clickLink("Enter the address manually")

      Then("Ratepayer is taken to the manual search address page and enters their property details")
      ManualAddressPage.ManualAddress()
      ManualAddressPage.InputAddressLine1Input("2a")
      ManualAddressPage.InputAddressLine2Input("rodley lane")
      ManualAddressPage.InputTownInput("rodley")
      ManualAddressPage.InputCountyInput("Leeds")
      ManualAddressPage.InputPostcodeInput("BH1 1HU")
      continueButtonClick()
      PropertySearchResultPage.searchResult("BH1 1HU")

      /*ManualAddressPage.AdditionalSearchOption()
      ManualAddressPage.PropertyReferenceInput("2191322564521")
      ManualAddressPage.MinRateableValueInput("10000")
      ManualAddressPage.MaxRateableValueInput("8000000")
      ManualAddressPage.findAddress() */
    }
    /*
    Scenario("Registered ratepayer adds the property") {
      PropertyLinkingDB.cleanup()
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
      BusinessRateBillPage.businessRateBill()
      BusinessRateBillPage.selectYes()

//      And("The ratepayers selects 'Owner' on 'connection to the property' page")
//      ConnectionToPropertyPage.ConnectionToProperty()
//      ConnectionToPropertyPage.ConnectionType("Owner")
//
//      And("The ratepayers navigate to confirm your details page")

//      Then("The ratepayer hits the CYA page")
//      PropertyLinkingCYA.hitCYAStep()
//      PropertyLinkingCYA.checkYourAnswer()
//      val propertyAddress = getElementByCssSelector("#property-to-add-to-account-id").toString
//      click(continueButton)
//
//      Then("The ratepayer hits the declaration page, and clicks accept")
//      DeclarationPage.declaration()
//      click(continueButton)
//
//      And("The ratepayer is taken to the Property Request sent page, displaying the correct property address")
//      RequestSentPage.requestSent()
//      RequestSentPage.reqPrintLinkDisplay("Print or save this page")
//      RequestSentPage.requestSentAddressCheck(propertyAddress)
    } */
  }
}
