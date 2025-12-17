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
import uk.gov.hmrc.ui.pages.PropertyLinking._
import uk.gov.hmrc.ui.pages.StubPage
import uk.gov.hmrc.ui.specs.BaseSpec
import uk.gov.hmrc.ui.utils.login.loginOl
import uk.gov.hmrc.ui.utils.mongo.PropertyLinkingDB

import java.time.{Clock, Instant, ZoneId}

class PropertyLinkingCYASpec extends BaseSpec with StubPage {

  var contactName: String = "BOB JONES"
  val postCode            = "BH1 1HU"
  val fixedClock: Clock   = Clock.fixed(Instant.parse("2026-06-05T12:00:00Z"), ZoneId.of("UTC"))

  def reachCheckYourAnswers(): Unit = {

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
    PropertySearchResultPage.clickHelpSpan()
    PropertySearchResultPage.selectSortOption("AddressASC")

    Then("Ratepayer click 'Select property' on the search results page")
    clickLink("Select property")

    Then("Ratepayer is taken to the selected property page, clicks the 'yes' radio and continues")
    SelectedProperty.selectedProperty()
    SelectedProperty.yesRadio()

    Then("Ratepayer selects 'Before 1 April 2026' on 'When did you become the current ratepayer?' page")
    CurrentRatepayer.currentRatepayer()
    CurrentRatepayer.beforeDateRadio()

    Then("The ratepayers selects 'yes' on 'business rates bill for the property' page")
    BusinessRateBillPage.businessRateBill()
    BusinessRateBillPage.selectYes()

    Then("The ratepayer can upload business rates bill")
    UploadYourBillPage.uploadYourBillHeader()
    UploadYourBillPage.uploadYourBill()

    Then("The ratepayer can confirm uploaded business rates bill")
    UploadYourBillConfirmationPage.uploadYourBillConfirmationHeader()
    UploadYourBillConfirmationPage.continueWhenUploaded()

    Then("ratepayer hits the property-connection page, selects 'owner' and continues")
    ConnectionToPropertyPage.hitConnectionStep()
    ConnectionToPropertyPage.connectionToPropertyHeader()
    ConnectionToPropertyPage.connectionTypeRadio("Owner")

    Then("The ratepayer hits the CYA page")
    PropertyLinkingCYA.checkYourAnswer()
  }

  Feature("Tests for the change details feature of the Property Linking Check Your Answers page") {

    Scenario("Registered ratepayer goes through the flow to establish a property, and changes the ratepayer date") {
      PropertyLinkingDB.cleanup()

      reachCheckYourAnswers()

      Then("Clicks the change ratePayer link")
      PropertyLinkingCYA.clickChangeRatepayerDate()

      Then("The 'When did you become the current ratepayer?' page is shown")
      CurrentRatepayer.currentRatepayer()

      Then("Ratepayer selects 'After 1 April 2026' on 'When did you become the current ratepayer?' page")

      CurrentRatepayer.timeSkip(fixedClock)
      CurrentRatepayer.afterDateRadio()
      CurrentRatepayer.dateInput("23", "05", "2026")
      click(continueButton)

      Then("The Ratepayer is taken back to the Check Your Answers page, with the ratepayer date changed")
      PropertyLinkingCYA.checkYourAnswer()
      PropertyLinkingCYA.dateChangedCheck("On or after 1 April 2026")
    }

    Scenario("Registered ratepayer goes through the flow to establish a property, and changes the rates bill bool") {

      reachCheckYourAnswers()

      Then("Clicks the change business rates bill link")
      PropertyLinkingCYA.clickChangeBusinessRatesBill()

      Then("The 'business rates bill for the property' page is shown")
      BusinessRateBillPage.businessRateBill()

      Then("Ratepayer selects 'no' on 'business rates bill for the property' page")
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

      Then("The Ratepayer is taken back to the Check Your Answers page, with the ratepayer bill bool changed")
      PropertyLinkingCYA.checkYourAnswer()
      PropertyLinkingCYA.billChangedCheck("No")
    }

    Scenario("Registered ratepayer goes through the flow to establish a property, and changes the property address") {

      reachCheckYourAnswers()

      Then("Clicks the change property address link")
      PropertyLinkingCYA.clickChangePropertyAddressLink()

      Then("Ratepayer is taken to the find a property page and searches for a property")
      FindAProperty.findProperty()
      FindAProperty.inputPostCode(postCode)

      Then("Ratepayer clicks the fourth 'Select property' on the search results page")
      PropertySearchResultPage.searchResult(postCode)
      PropertySearchResultPage.selectSortOption("AddressASC")
      PropertySearchResultPage.selectLink("Select property", 4)

      Then("Ratepayer is taken to the selected property page, clicks the 'yes' radio and continues")
      SelectedProperty.selectedProperty()
      SelectedProperty.yesRadio()

      Then("Ratepayer selects 'Before 1 April 2026' on 'When did you become the current ratepayer?' page")
      CurrentRatepayer.currentRatepayer()
      CurrentRatepayer.beforeDateRadio()

      Then("The ratepayers selects 'yes' on 'business rates bill for the property' page")
      BusinessRateBillPage.businessRateBill()
      BusinessRateBillPage.selectYes()

      Then("The ratepayer can upload business rates bill")
      UploadYourBillPage.uploadYourBillHeader()
      UploadYourBillPage.uploadYourBill()

      Then("The ratepayer can confirm uploaded business rates bill")
      UploadYourBillConfirmationPage.uploadYourBillConfirmationHeader()
      UploadYourBillConfirmationPage.continueWhenUploaded()

      Then("ratepayer hits the property-connection page, selects 'owner' and continues")
      ConnectionToPropertyPage.hitConnectionStep()
      ConnectionToPropertyPage.connectionToPropertyHeader()
      ConnectionToPropertyPage.connectionTypeRadio("Owner")

      Then("The Ratepayer is taken back to the Check Your Answers page, with the address changed")
      PropertyLinkingCYA.checkYourAnswer()
      PropertyLinkingCYA.addressChangedCheck("Bug Me Not PVT LTD, RODLEY LANE, RODLEY, LEEDS, BH1 1HU")

    }

    Scenario(
      "Registered ratepayer goes through the flow to establish a property, and changes the property connection"
    ) {

      reachCheckYourAnswers()

      Then("The Ratepayer clicks the change property connection link, and is taken to the property connection page")
      PropertyLinkingCYA.clickChangePropertyConnection()
      ConnectionToPropertyPage.connectionToPropertyHeader()

      Then("Ratepayer clicks on the 'occupier' radio button")
      ConnectionToPropertyPage.connectionTypeRadio("Occupier")

      And("Ratepayer is taken back to the CYA page with the connection to the property changed")
      PropertyLinkingCYA.checkYourAnswer()
      PropertyLinkingCYA.connectionChangedCheck("Occupier")
    }
  }
}
