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

package uk.gov.hmrc.ui.specs.RALD

import uk.gov.hmrc.ui.pages.Dashboard.DashboardHome.dashboard
import uk.gov.hmrc.ui.pages.PropertyLinking.{AddAProperty, BusinessRateBillPage, CheckYourAnswers, ConnectionToPropertyPage, CurrentRatepayer, DeclarationPage, FindAProperty, PropertySearchResultPage, RegisterComplete, SelectedProperty, UploadYourLease, UploadedYourLease, WhatEvidenceCanYouProvide, WhatYouNeed}
import uk.gov.hmrc.ui.pages.RALD.CheckYourAnswersRald.cyaUrl
import uk.gov.hmrc.ui.pages.RALD._
import uk.gov.hmrc.ui.pages.StubPage
import uk.gov.hmrc.ui.specs.BaseSpec
import uk.gov.hmrc.ui.utils.login.loginGg
import uk.gov.hmrc.ui.utils.mongo.RaldDB

class RaldCYASpec extends BaseSpec with StubPage {
  def completeRaldJourney(): Unit = {

    RaldDB.cleanup()
    Given("Ratepayer logins through one login")
    loginGg()

//    Then("Ratepayer clicks the Add a Property link and is taken to the Add a Property page")
//    clickLink("Add a property")
//    AddAProperty.addAProperty()
//    click(continueButton)
//
//    Then("Ratepayer is taken to the What You Need page")
//    WhatYouNeed.whatYouNeed()
//    click(continueButton)
//
//    Then("Ratepayer is taken to the find a property page and searches for a property")
//    FindAProperty.findProperty()
//    FindAProperty.inputPostCode("BH1 1HU")
//
//    Then("Ratepayer is taken to the search results page")
//    PropertySearchResultPage.searchResult("BH1 1HU")
//    PropertySearchResultPage.selectSortOption("AddressASC")
//    PropertySearchResultPage.clickHelpSpan()
//    clickLink("Select property")
//
//    Then("Ratepayer is taken to the selected property page, clicks the 'yes' radio and continues")
//    SelectedProperty.selectedProperty()
//    SelectedProperty.yesRadio()
//
//    Then("Ratepayer selects 'Before 1 April 2026' on 'When did you become the current ratepayer?' page")
//    CurrentRatepayer.currentRatepayer()
//    CurrentRatepayer.beforeDateRadio()
//
//    /** Tests for NO radio button selection * */
//    And("The ratepayers selects 'No' on 'business rates bill for the property' page")
//    BusinessRateBillPage.businessRateBill()
//    BusinessRateBillPage.selectNo()
//
//    Then("The ratepayer selects 'lease' on 'What evidence can you provide?' page")
//    WhatEvidenceCanYouProvide.whatEvidenceCanYouProvide()
//    WhatEvidenceCanYouProvide.selectEvidenceType("Lease")
//
//    Then("The ratepayer uploads the Lease document on the lease document page")
//    UploadYourLease.uploadYourLeaseHeader()
//    UploadYourLease.uploadYourLeaseDocuments()
//    continueButtonClick()
//
//    Then("The ratepayer can check the uploaded file on the uploaded your lease screen")
//    UploadedYourLease.uploadedYourLeaseHeader()
//    UploadedYourLease.verifyUploadedItem("testFile.png", "Uploaded")
//    continueButtonClick()
//
//    Then("The ratepayer selects the connection to the property")
//    ConnectionToPropertyPage.connectionToPropertyHeader()
//    ConnectionToPropertyPage.connectionTypeRadio("Owner")
//
//    Then("The ratepayer checks the provided details on the Check your answer screen")
//    CheckYourAnswers.checkYourAnswersHeader()
//    continueButtonClick()
//
//    Then("The ratepayer accept the declaration")
//    DeclarationPage.declaration()
//    continueButtonClick()
//
//    Then("The ratepayer is taken to the 'Add a property request sent' screen ")
//    RegisterComplete.RegisterComplete()
//
//    Then("The ratepayers selects the property and proceed through the new agreement journey")
//    YourProperty.yourProperty()
//    clickLink("Select property")
//
//    Then("The user selects new agreement link to tell about their new agreement")
//    WhatDoYouWantToTellUs.whatDoYouWantToTellUs()
//    clickLink("You have a new agreement")
//
//    TellUsAboutYourNewAgreementPage.tellUsAboutYourNewAgreement()
//    continueButtonClick()

//    Then("The user inputs the landlords name and selects family member as type")
//    Landlord.landlord()
//    Landlord.landlordNameInput("Test Testing")
//    Landlord.yesRadio()
//    Landlord.supplyRelationship("I am the tenant")
//    continueButtonClick()
//
//    Then("The user selects lease Or Tenancy as their agreement type")
//    WhatTypeOfAgreement.TypeOfAgreement()
//    WhatTypeOfAgreement.leaseOrTenancyRadio()
//    continueButtonClick()

//    Then("The user enters agreement start date, not open ended, and 'Yes' for break clause")
//    Agreement.agreement()
//    Agreement.enterAgreementStartDate("02", "01", "2005")
//    Agreement.agreementOpenEndedRadio("No")
//    Agreement.enterOpenEndedAgreementDate("02", "01", "2030")
//    Agreement.agreementHaveABreakClauseRadio("Yes")
//    Agreement.agreementBreakClauseReason(
//      "Tenant needs to move due to employer's requirement to work in-office three days a week."
//    )
//    continueButtonClick()
//
//    Then("The user selects other and input reason on 'What is your rent based on?' page and submit")
//    WhatIsRentBasedOn.whatIsRentBasedOn()
//    WhatIsRentBasedOn.selectRentBaseOn("Other")
//    WhatIsRentBasedOn.otherRentBasedOnDescription("VOA budget")
//    continueButtonClick()
//
//    And("The user selects 'No' on rent agreed in advance")
//    HaveYouAgreedInAdvanceRentChanges.haveYouAgreedInAdvanceRentChanges()
//    HaveYouAgreedInAdvanceRentChanges.noRadio()
//    continueButtonClick()
//
//    Then("The user enter how much is total annual rent")
//    HowMuchIsTotalAnnualRent.howMuchIsTotalAnnualRent()
//    HowMuchIsTotalAnnualRent.inputTotalAnnualRent("7000")
//    continueButtonClick()
//
//    Then("The user enters 'Yes' to having a rent period")
//    DoYouHaveRentFreePeriod.doYouHaveRentFreePeriod()
//    DoYouHaveRentFreePeriod.selectRentFreePeriodRadio("Yes")
//    continueButtonClick()
//
//    Then("The user enter how many months of rent free and reasons")
//    RentFreePeriod.rentFreePeriod()
//    RentFreePeriod.enterRentFreePeriodMonths("5")
//    RentFreePeriod.enterReasons("Any reasons")
//    continueButtonClick()
//
//    Then("The user enters their agreement date and start date")
//    RentDatesAgreeStartPage.rentDatesAgreeStartPage()
//    RentDatesAgreeStartPage.agreeDateInput(day = "12", month = "12", year = "2020")
//    RentDatesAgreeStartPage.startDateInput(day = "10", month = "01", year = "2021")
//    continueButtonClick()
//
//    Then("The user selects what their rent includes")
//    WhatYourRentIncludesPage.whatYourRentIncludes()
//    WhatYourRentIncludesPage.livingAccommodationRadio("No")
//    WhatYourRentIncludesPage.rentPartAddressRadio("Yes")
//    WhatYourRentIncludesPage.rentEmptyShellRadio("Yes")
//    WhatYourRentIncludesPage.rentIncBusinessRatesRadio("Yes")
//    WhatYourRentIncludesPage.rentIncWaterChargesRadio("Yes")
//    WhatYourRentIncludesPage.rentIncServiceRadio("Yes")
//    continueButtonClick()
//
//    Then("The user selects no to having parking spaces or garages")
//    DoesYourRentIncludeParkingPage.doesYourRentIncludeParking()
//    DoesYourRentIncludeParkingPage.yesRadio()
//    continueButtonClick()
//
//    Then(
//      "The user enters 3 for uncovered parking spaces, 4000 for how much extra they pay with an agreement date of 19-01-2020"
//    )
//    HowManyParkingSpacesOrGaragesIncludedInRentPage.enterUncoveredSpaces("3")
//    HowManyParkingSpacesOrGaragesIncludedInRentPage.enterUncoveredSpaces("2")
//    HowManyParkingSpacesOrGaragesIncludedInRentPage.enterGarages("1")
//    continueButtonClick()
//
//    Then("The user select yes to pay extra parking spaces not included in rent")
//    DoYouPayExtraForParkingSpaces.doYouPayExtraForParkingSpaces()
//    DoYouPayExtraForParkingSpaces.selectPayExtraRadio("yes")
//    continueButtonClick()

//    Then(
//      "The user enters 3 for uncovered parking spaces, 4000 for how much extra they pay with an agreement date of 19-01-2020"
//    )
//    ParkingSpacesOrGaragesNotIncludedInYourRentPage.enterUncoveredSpaces("3")
//    ParkingSpacesOrGaragesNotIncludedInYourRentPage.totalCost("4000")
//    ParkingSpacesOrGaragesNotIncludedInYourRentPage.agreementDateInput(day = "19", month = "01", year = "1997")
//    continueButtonClick()
//
//    Then("The user selects you to who pays for internal, external and building insurance repairs")
//    RepairsAndInsurancePage.repairsAndInsurance()
//    RepairsAndInsurancePage.whoPaysForInternalRepairsRadio("You")
//    RepairsAndInsurancePage.whoPaysForExternalRepairsRadio("You")
//    RepairsAndInsurancePage.WhoPaysForBuildingInsuranceRepairs("You")
//    continueButtonClick()
//
//    Then("The user select no for rent review and yes for rent go down")
//    RentReviewPage.rentReview()
//    RentReviewPage.hasIncludeRentReview("no")
//    RentReviewPage.canRentGoDown("yes")
//    continueButtonClick()
//
//    Then("The user select no on repairs and fitting out")
//    RepairsAndFittingOutPage.repairsAndFittingOut()
//    RepairsAndFittingOutPage.noRadio()
//    continueButtonClick()
//
//    Then("The user select no for money from the landlord")
//    DidYouGetMoneyFromLandlordPage.didYouGetMoneyFromLandlord()
//    DidYouGetMoneyFromLandlordPage.yesRadio()
//    continueButtonClick()
//
//    Then("The user is on the About Repairs and Fitting Out page")
//    AboutRepairsAndFittingOutPage.verifyPageHeader()
//    AboutRepairsAndFittingOutPage.enterRepairCost("1234.56")
//    AboutRepairsAndFittingOutPage.enterRepairDate("10", "2025")
//    continueButtonClick()
//
//    Then("Did you get any money from the landlord or previous tenant to take on the lease?")
//    DidYouGetMoneyFromLandlordPage.didYouGetMoneyFromLandlord()
//    DidYouGetMoneyFromLandlordPage.yesRadio()
//    continueButtonClick()
//
//    Then("Money you got from the landlord or previous tenant to take on the lease")
//
//    MoneyToTakeOnTheLeasePage.moneyToTakeOnTheLease()
//    MoneyToTakeOnTheLeasePage.moneyToTakeOnTheLeaseAmountInput("500")
//    MoneyToTakeOnTheLeasePage.moneyToTakeOnTheLeaseDateInput("12", "11", "2025")
//    continueButtonClick()
//
//    Then("Did you pay any money in advance to the landlord?")
//    DidYouPayAnyMoneyToLandlordPage.didYouPayAnyMoneyToLandlord()
//    DidYouPayAnyMoneyToLandlordPage.yesRadio()
//    continueButtonClick()
//
//    Then("Money you paid in advance to the landlord")
//    MoneyYouPaidInAdvanceToLandlordPage.moneyYouPaidInAdvanceToLandlord()
//    MoneyYouPaidInAdvanceToLandlordPage.moneyYouPaidInAdvanceToLandlordAmountInput("500")
//    MoneyYouPaidInAdvanceToLandlordPage.moneyYouPaidInAdvanceToLandlordDateInput("12", "11", "2025")
//    continueButtonClick()
//
//    Then("Has anything else affected the rent")
//    HasAnythingElsePage.hasAnythingElseAffectedTheRent()
//    HasAnythingElsePage.hasAffected("yes")
//    HasAnythingElsePage.reasonDescription("test")
//    continueButtonClick()
//
//    Then("The user reaches the Check Your Answers page")
//    CheckYourAnswersRald.checkYourAnswersHeader()
//    CheckYourAnswersRald.checkSectionHeadings()
  }

  Feature("Change details on RALD Check Your Answers page") {

    Scenario("Change landlord name") {
      completeRaldJourney()

      //      CheckYourAnswersRald.clickChangeLink("landlord-fullname-change-link")
      //      Landlord.landlordNameInput("Other name")
      //      continueButtonClick()
      //
      //      getUrl(cyaUrl)
      //      CheckYourAnswersRald.verifySummaryRow("Landlord's full name", "Jane Doe")
      //    }
      //
      //    Scenario("Change landlord relationship") {
      //      completeRaldJourney()
      //
      //      CheckYourAnswersRald.clickChangeLink("landlord-relationship-change-link")
      //      Landlord.noRadio()
      //      continueButtonClick()
      //
      //      getUrl(cyaUrl)
      //      CheckYourAnswersRald.verifySummaryRow("Relationship with the landlord", "No")
      //    }
      //
      //    Scenario("Change agreement start date") {
      //      completeRaldJourney()
      //
      //      CheckYourAnswersRald.clickChangeLink("agreement-startdate-change-link")
      //      Agreement.enterAgreementStartDate("15", "06", "2025")
      //      continueButtonClick()
      //
      //      getUrl(cyaUrl)
      //      CheckYourAnswersRald.verifySummaryRow("Agreement start date", "15 June 2025")
      //    }
      //
      //    Scenario("Change agreement break clause details") {
      //      completeRaldJourney()
      //
      //      CheckYourAnswersRald.clickChangeLink("agreement-breakclause-change-link")
      //      Agreement.agreementHaveABreakClauseRadio("No")
      //      continueButtonClick()
      //
      //      getUrl(cyaUrl)
      //      CheckYourAnswersRald.verifySummaryRow("Break clause details", "No")
      //    }
      //
      //    Scenario("Change total annual rent") {
      //      completeRaldJourney()
      //
      //      CheckYourAnswersRald.clickChangeLink("rent-totalannual-change-link")
      //      HowMuchIsTotalAnnualRent.inputTotalAnnualRent("15000")
      //      continueButtonClick()
      //
      //      getUrl(cyaUrl)
      //      CheckYourAnswersRald.verifySummaryRow("Total annual rent", "£15,000")
      //    }
      //
      //    Scenario("Change rent free period months") {
      //      completeRaldJourney()
      //
      //      CheckYourAnswersRald.clickChangeLink("rent-rentfreeperiod-change-link")
      //      RentFreePeriod.enterRentFreePeriodMonths("3")
      //      continueButtonClick()
      //
      //      getUrl(cyaUrl)
      //      CheckYourAnswersRald.verifySummaryRow("How many months is your rent-free period?", "3")
      //    }
      //
      //    Scenario("Change what your rent includes") {
      //      completeRaldJourney()
      //
      //      CheckYourAnswersRald.clickChangeLink("rent-includes-change-link")
      //      WhatYourRentIncludesPage.livingAccommodationRadio("Yes")
      //      continueButtonClick()
      //
      //      getUrl(cyaUrl)
      //      CheckYourAnswersRald.verifySummaryRow("Does your rent include any living accommodation?", "Yes")
      //    }
      //
      //    Scenario("Change repairs and insurance") {
      //      completeRaldJourney()
      //
      //      CheckYourAnswersRald.clickChangeLink("repairs-insurance-change-link")
      //      RepairsAndInsurancePage.whoPaysForInternalRepairsRadio("Landlord")
      //      continueButtonClick()
      //
      //      getUrl(cyaUrl)
      //      CheckYourAnswersRald.verifySummaryRow("Who pays for internal repairs?", "Landlord")
      //    }
      //
      //    Scenario("Change rent review") {
      //      completeRaldJourney()
      //
      //      CheckYourAnswersRald.clickChangeLink("rent-review-change-link")
      //      RentReviewPage.hasIncludeRentReview("Yes")
      //      continueButtonClick()
      //
      //      getUrl(cyaUrl)
      //      CheckYourAnswersRald.verifySummaryRow("Does your agreement include a rent review?", "Yes")
      //    }
      //
      //    Scenario("Change repairs and fitting out") {
      //      completeRaldJourney()
      //
      //      CheckYourAnswersRald.clickChangeLink("repairs-fittingout-change-link")
      //      RepairsAndFittingOutPage.yesRadio()
      //      continueButtonClick()
      //
      //      getUrl(cyaUrl)
      //      CheckYourAnswersRald.verifySummaryRow("Have you done any repairs or fitting out in the property?", "Yes")
      //    }
      //
      //    Scenario("Change payments") {
      //      completeRaldJourney()
      //
      //      CheckYourAnswersRald.clickChangeLink("payments-change-link")
      //      DidYouPayAnyMoneyToLandlordPage.noRadio()
      //      continueButtonClick()
      //
      //      getUrl(cyaUrl)
      //      CheckYourAnswersRald.verifySummaryRow("Did you pay any money in advance to the landlord?", "No")
      //    }
      //
      //    Scenario("Change other details") {
      //      completeRaldJourney()
      //
      //      CheckYourAnswersRald.clickChangeLink("otherdetails-change-link")
      //      HasAnythingElsePage.hasAffected("Yes")
      //      HasAnythingElsePage.reasonDescription("test")
      //      continueButtonClick()
      //
      //      getUrl(cyaUrl)
      //      CheckYourAnswersRald.verifySummaryRow("Can you tell us what else has affected the rent?", "test")
      //    }
    }
  }
}
