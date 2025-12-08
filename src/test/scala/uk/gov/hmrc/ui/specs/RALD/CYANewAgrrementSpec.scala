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

import uk.gov.hmrc.selenium.webdriver.Driver
import uk.gov.hmrc.ui.pages.Dashboard.DashboardHome.dashboard
import uk.gov.hmrc.ui.pages.RALD._
import uk.gov.hmrc.ui.pages.StubPage
import uk.gov.hmrc.ui.specs.BaseSpec
import uk.gov.hmrc.ui.utils.login.loginOl
import uk.gov.hmrc.ui.utils.mongo.RaldDB

class CYANewAgrrementSpec extends BaseSpec with StubPage {
  def completeRaldJourney(): Unit = {

    RaldDB.cleanup()
    Given("Ratepayer logins through one login")
    loginOl()

    When("The ratepayer clicks on 'Tell us about a change' link from dashboard")
    dashboard()
    clickLink("Tell us about a change")

    Then("The ratepayers selects the property and proceed through the new agreement journey")
    YourProperty.yourProperty()
    clickLink("Select property")

    Then("The user selects renewed agreement link to renew their agreement")
    WhatDoYouWantToTellUs.whatDoYouWantToTellUs()

    clickLink("You have a new agreement")
    TellUsAboutYourNewAgreementPage.tellUsAboutYourNewAgreement()
    continueButtonClick()

    Then("The user inputs the landlords name and selects family member as type")
    Landlord.landlord()
    Landlord.landlordNameInput("Test Testing")
    Landlord.yesRadio()
    Landlord.supplyRelationship("I am the tenant")
    continueButtonClick()

    Then("The user selects lease Or Tenancy as their agreement type")
    WhatTypeOfAgreement.TypeOfAgreement()
    WhatTypeOfAgreement.leaseOrTenancyRadio()
    continueButtonClick()

    Then("The user enters agreement start date, not open ended, and 'Yes' for break clause")
    Agreement.agreement()
    Agreement.enterAgreementStartDate("02", "01", "2005")
    Agreement.agreementOpenEndedRadio("No")
    Agreement.enterOpenEndedAgreementDate("02", "01", "2030")
    Agreement.agreementHaveABreakClauseRadio("Yes")
    Agreement.agreementBreakClauseReason(
      "Tenant needs to move due to employer's requirement to work in-office three days a week."
    )
    continueButtonClick()

    Then("The user selects other and input reason on 'What is your rent based on?' page and submit")
    WhatIsRentBasedOn.whatIsRentBasedOn()
    WhatIsRentBasedOn.selectRentBaseOn("Other")
    WhatIsRentBasedOn.otherRentBasedOnDescription("VOA budget")
    continueButtonClick()

    And("The user selects 'No' on rent agreed in advance")
    HaveYouAgreedInAdvanceRentChanges.haveYouAgreedInAdvanceRentChanges()
    HaveYouAgreedInAdvanceRentChanges.noRadio()
    continueButtonClick()

    Then("The user enter how much is total annual rent")
    HowMuchIsTotalAnnualRent.howMuchIsTotalAnnualRent()
    HowMuchIsTotalAnnualRent.inputTotalAnnualRent("7000")
    continueButtonClick()

    Then("The user enters 'Yes' to having a rent period")
    DoYouHaveRentFreePeriod.doYouHaveRentFreePeriod()
    DoYouHaveRentFreePeriod.selectRentFreePeriodRadio("Yes")
    continueButtonClick()

    Then("The user enter how many months of rent free and reasons")
    RentFreePeriod.rentFreePeriod()
    RentFreePeriod.enterRentFreePeriodMonths("5")
    RentFreePeriod.enterReasons("Any reasons")
    continueButtonClick()

    Then("The user enters their agreement date and start date")
    RentDatesAgreeStartPage.rentDatesAgreeStartPage()
    RentDatesAgreeStartPage.agreeDateInput(day = "12", month = "12", year = "2020")
    RentDatesAgreeStartPage.startDateInput(day = "10", month = "01", year = "2021")
    continueButtonClick()

    Then("The user selects what their rent includes")
    WhatYourRentIncludesPage.whatYourRentIncludes()
    WhatYourRentIncludesPage.livingAccommodationRadio("No")
    WhatYourRentIncludesPage.rentPartAddressRadio("Yes")
    WhatYourRentIncludesPage.rentEmptyShellRadio("Yes")
    WhatYourRentIncludesPage.rentIncBusinessRatesRadio("Yes")
    WhatYourRentIncludesPage.rentIncWaterChargesRadio("Yes")
    WhatYourRentIncludesPage.rentIncServiceRadio("Yes")
    continueButtonClick()

    Then("The user selects no to having parking spaces or garages")
    DoesYourRentIncludeParkingPage.doesYourRentIncludeParking()
    DoesYourRentIncludeParkingPage.yesRadio()
    continueButtonClick()

    Then(
      "The user enters 3 for covered parking spaces, 2 for uncovered spaces and 1 for garage"
    )
    HowManyParkingSpacesOrGaragesIncludedInRentPage.howManyParkingSpacesOrGaragesIncludedInRent()
    HowManyParkingSpacesOrGaragesIncludedInRentPage.enterCoveredSpaces("3")
    HowManyParkingSpacesOrGaragesIncludedInRentPage.enterUncoveredSpaces("2")
    HowManyParkingSpacesOrGaragesIncludedInRentPage.enterGarages("1")
    continueButtonClick()

    Then("The user select yes to pay extra parking spaces not included in rent")
    DoYouPayExtraForParkingSpaces.doYouPayExtraForParkingSpaces()
    DoYouPayExtraForParkingSpaces.selectPayExtraRadio("yes")
    continueButtonClick()

    Then(
      "The user enters 2 for covered parking spaces, 3 uncovered, 1 garage, 4000 for how much extra they pay with an agreement date of 19-01-2020"
    )
    ParkingSpacesOrGaragesNotIncludedInYourRentPage.ParkingSpacesOrGaragesNotIncludedInYourRent()
    ParkingSpacesOrGaragesNotIncludedInYourRentPage.enterUncoveredSpaces("3")
    ParkingSpacesOrGaragesNotIncludedInYourRentPage.enterCoveredSpaces("2")
    ParkingSpacesOrGaragesNotIncludedInYourRentPage.enterGarages("1")
    ParkingSpacesOrGaragesNotIncludedInYourRentPage.totalCost("4000")
    ParkingSpacesOrGaragesNotIncludedInYourRentPage.agreementDateInput(day = "19", month = "01", year = "1997")
    continueButtonClick()

    Then("The user selects you to who pays for internal, external and building insurance repairs")
    RepairsAndInsurancePage.repairsAndInsurance()
    RepairsAndInsurancePage.whoPaysForInternalRepairsRadio("You")
    RepairsAndInsurancePage.whoPaysForExternalRepairsRadio("You")
    RepairsAndInsurancePage.WhoPaysForBuildingInsuranceRepairs("You")
    continueButtonClick()

    Then("The user select no for rent review and yes for rent go down")
    RentReviewPage.rentReview()
    RentReviewPage.hasIncludeRentReview("no")
    RentReviewPage.canRentGoDown("yes")
    continueButtonClick()

    Then("The user select no on repairs and fitting out")
    RepairsAndFittingOutPage.repairsAndFittingOut()
    RepairsAndFittingOutPage.yesRadio()
    continueButtonClick()

    Then("The user is on the About Repairs and Fitting Out page")
    AboutRepairsAndFittingOutPage.aboutRepairsAndFittingOut()
    AboutRepairsAndFittingOutPage.enterRepairCost("1234.56")
    AboutRepairsAndFittingOutPage.enterRepairDate("10", "2025")
    continueButtonClick()

    Then("Did you get any money from the landlord or previous tenant to take on the lease?")
    DidYouGetMoneyFromLandlordPage.didYouGetMoneyFromLandlord()
    DidYouGetMoneyFromLandlordPage.yesRadio()
    continueButtonClick()

    Then("Money you got from the landlord or previous tenant to take on the lease")

    MoneyToTakeOnTheLeasePage.moneyToTakeOnTheLease()
    MoneyToTakeOnTheLeasePage.moneyToTakeOnTheLeaseAmountInput("500")
    MoneyToTakeOnTheLeasePage.moneyToTakeOnTheLeaseDateInput("12", "11", "2025")
    continueButtonClick()

    Then("Did you pay any money in advance to the landlord?")
    DidYouPayAnyMoneyToLandlordPage.didYouPayAnyMoneyToLandlord()
    DidYouPayAnyMoneyToLandlordPage.yesRadio()
    continueButtonClick()

    Then("Money you paid in advance to the landlord")
    MoneyYouPaidInAdvanceToLandlordPage.moneyYouPaidInAdvanceToLandlord()
    MoneyYouPaidInAdvanceToLandlordPage.moneyYouPaidInAdvanceToLandlordAmountInput("500")
    MoneyYouPaidInAdvanceToLandlordPage.moneyYouPaidInAdvanceToLandlordDateInput("12", "11", "2025")
    continueButtonClick()

    Then("Has anything else affected the rent")
    HasAnythingElsePage.hasAnythingElseAffectedTheRent()
    HasAnythingElsePage.hasAffected("yes")
    HasAnythingElsePage.reasonDescription("test")
    continueButtonClick()

    Then("The user reaches the Check Your Answers page")
    CheckYourAnswersRald.checkYourAnswersHeader()
    CheckYourAnswersRald.checkSectionHeadings()
  }

  Feature("New agreement : Change details on Check Your Answers page") {
    Scenario("Change multiple details after completing RALD journey") {
      completeRaldJourney()

      // Landlord details
      // Check changing landlord full name
      CheckYourAnswersRald.clickChangeLink("landlord-full-name")
      Landlord.landlord()
      Landlord.landlordNameInput("test-2")
      continueButtonClick()
      CheckYourAnswersRald.verifySummaryRow("Landlord's full name", "test-2")

      // Check changing relationship with landlord
      CheckYourAnswersRald.clickChangeLink("landlord-relationship")
      Landlord.noRadio()
      continueButtonClick()
      CheckYourAnswersRald.verifySummaryRow(
        "Do you have a relationship with the landlord other than as a tenant?",
        "No"
      )

      // Agreement details
      // Check changing agreement type
      CheckYourAnswersRald.clickChangeLink("what-type-of-agreement")
      WhatTypeOfAgreement.verbalRadio()
      continueButtonClick()
      CheckYourAnswersRald.verifySummaryRow("What type of agreement do you have?", "Verbal agreement")

      // Check changing agreement start date
      CheckYourAnswersRald.clickChangeLink("agreement-start-date")
      Agreement.enterAgreementStartDate("15", "06", "2025")
      continueButtonClick()
      CheckYourAnswersRald.verifySummaryRow("Agreement start date", "15 June 2025")

      // Check changing open-ended agreement
      CheckYourAnswersRald.clickChangeLink("is-open-ended")
      Agreement.agreementOpenEndedRadio("No")
      continueButtonClick()
      CheckYourAnswersRald.verifySummaryRow(
        "Is your agreement open-ended?",
        "No, it runs for a defined term or has an agreed end date"
      )

      // Check changing break clause details
      CheckYourAnswersRald.clickChangeLink("break-clause")
      Agreement.agreementHaveABreakClauseRadio("No")
      continueButtonClick()
      CheckYourAnswersRald.verifySummaryRow("Does your agreement have a break clause?", "No")

//      // Rent details TODO Uncomment when bugs fixed
//     // Checking what is the rent based on
//      CheckYourAnswersRald.clickChangeLink("what-is-your-rent-based-on")
//      WhatIsRentBasedOn.whatIsRentBasedOn()
//      WhatIsRentBasedOn.selectRentBaseOn("A percentage of expected turnover")
//      continueButtonClick()
//      CheckYourAnswersRald.verifySummaryRow("What is your rent based on?", "A percentage of expected turnover")

      // Check changing total annual rent
      CheckYourAnswersRald.clickChangeLink("how-much-is-total-annual-rent")
      HowMuchIsTotalAnnualRent.inputTotalAnnualRent("15000")
      continueButtonClick()
      CheckYourAnswersRald.verifySummaryRow("Total annual rent", "£15000.0")

      // Check changing rent-free period
      CheckYourAnswersRald.clickChangeLink("check-rent-free-period")
      DoYouHaveRentFreePeriod.selectRentFreePeriodRadio("no")
      continueButtonClick()
      CheckYourAnswersRald.verifySummaryRow("Do you have a rent-free period at the start of your agreement?", "No")

      // Check changing rent includes living accommodation
      CheckYourAnswersRald.clickChangeLink("living-accommodation")
      WhatYourRentIncludesPage.livingAccommodationRadio("Yes")
      WhatYourRentIncludesPage.bedroomNumbers("5")
      WhatYourRentIncludesPage.rentPartAddressRadio("No")
      WhatYourRentIncludesPage.rentEmptyShellRadio("No")
      continueButtonClick()
      CheckYourAnswersRald.verifySummaryRow("Does your rent include any living accommodation?", "Yes")

      // Check changing rent covers whole property
      CheckYourAnswersRald.clickChangeLink("rent-part-address")
      WhatYourRentIncludesPage.rentPartAddressRadio("No")
      continueButtonClick()
      CheckYourAnswersRald.verifySummaryRow("Is the rent you pay for all of this property?", "No")

      // Check changing rent for empty shell
      CheckYourAnswersRald.clickChangeLink("rent-empty-shell")
      WhatYourRentIncludesPage.rentEmptyShellRadio("No")
      continueButtonClick()
      CheckYourAnswersRald.verifySummaryRow("Is your rent for an empty shell building?", "No")

      // Check changing rent includes business rates
      CheckYourAnswersRald.clickChangeLink("rent-inc-business-rates")
      WhatYourRentIncludesPage.rentIncBusinessRatesRadio("No")
      continueButtonClick()
      CheckYourAnswersRald.verifySummaryRow("Does your rent include business rates?", "No")

      // Check changing rent includes water charges
      CheckYourAnswersRald.clickChangeLink("rent-inc-water-charges")
      WhatYourRentIncludesPage.rentIncWaterChargesRadio("No")
      continueButtonClick()
      CheckYourAnswersRald.verifySummaryRow("Does your rent include water charges?", "No")

      // Check changing rent includes service charges
      CheckYourAnswersRald.clickChangeLink("rent-inc-service")
      WhatYourRentIncludesPage.rentIncServiceRadio("No")
      continueButtonClick()
      CheckYourAnswersRald.verifySummaryRow("Does your rent include service charges?", "No")

      // Check changing rent includes parking/garages
      CheckYourAnswersRald.clickChangeLink("rent-inc-parking")
      DoesYourRentIncludeParkingPage.noRadio()
      continueButtonClick()
      CheckYourAnswersRald.verifySummaryRow("Does your rent include parking spaces or garages?", "No")

      // Check changing extra payment for garages
      CheckYourAnswersRald.clickChangeLink("do-you-pay-extra-for-parking-spaces")
      DoYouPayExtraForParkingSpaces.selectPayExtraRadio("no")
      continueButtonClick()
      CheckYourAnswersRald.verifySummaryRow(
        "Do you pay extra for parking spaces or garages that are not included in your rent?",
        "No"
      )

      // Repairs and insurance
      // Check changing internal repairs responsibility
      CheckYourAnswersRald.clickChangeLink("internal-repairs")
      RepairsAndInsurancePage.whoPaysForInternalRepairsRadio("the landlord")
      continueButtonClick()
      CheckYourAnswersRald.verifySummaryRow("Who pays for internal repairs?", "The landlord")

      // Check changing external repairs responsibility
      CheckYourAnswersRald.clickChangeLink("external-repairs")
      RepairsAndInsurancePage.whoPaysForExternalRepairsRadio("the landlord")
      continueButtonClick()
      CheckYourAnswersRald.verifySummaryRow("Who pays for internal repairs?", "The landlord")

      // Check changing insurance responsibility
      CheckYourAnswersRald.clickChangeLink("building-insurance")
      RepairsAndInsurancePage.WhoPaysForBuildingInsuranceRepairs("the landlord")
      continueButtonClick()
      CheckYourAnswersRald.verifySummaryRow("Who pays for internal repairs?", "The landlord")

      // Rent review details
      // Check changing rent review inclusion
      CheckYourAnswersRald.clickChangeLink("has-include-rent-review")
      RentReviewPage.hasIncludeRentReview("No")
      continueButtonClick()
      CheckYourAnswersRald.verifySummaryRow("Does your agreement include a rent review?", "No")

//      // Check changing rent review can go down TODO Uncomment when bugs fixed
//      CheckYourAnswersRald.clickChangeLink("can-rent-go-down")
//      RentReviewPage.canRentGoDown("No")
//      continueButtonClick()
//      CheckYourAnswersRald.verifySummaryRow("Can the rent go down when it is reviewed?", "No")

      // Repairs and fitting out
      // Check changing repairs/fitting out done by tenant
      CheckYourAnswersRald.clickChangeLink("repairs-and-fitting-out")
      RepairsAndFittingOutPage.noRadio()
      continueButtonClick()
      CheckYourAnswersRald.verifySummaryRow("Have you done any repairs or fitting out in the property?", "No")

      // Payments
      // Check changing money received from landlord
      CheckYourAnswersRald.clickChangeLink("did-you-get-money-from-landlord")
      DidYouGetMoneyFromLandlordPage.noRadio()
      continueButtonClick()
      CheckYourAnswersRald.verifySummaryRow(
        "Did you get any money from the landlord or previous tenant to take on the lease?",
        "No"
      )

      // Check changing money paid in advance
      CheckYourAnswersRald.clickChangeLink("did-you-pay-money-to-landlord")
      DidYouPayAnyMoneyToLandlordPage.noRadio()
      continueButtonClick()
      CheckYourAnswersRald.verifySummaryRow("Did you pay any money in advance to the landlord?", "No")

      // Other details
      // Check changing other factors affecting rent
      CheckYourAnswersRald.clickChangeLink("other-details")
      HasAnythingElsePage.hasAffected("")
      continueButtonClick()
      CheckYourAnswersRald.verifySummaryRow("Has anything else affected the rent?", "No")
    }
  }
}
