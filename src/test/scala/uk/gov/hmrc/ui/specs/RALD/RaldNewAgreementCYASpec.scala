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
import uk.gov.hmrc.ui.pages.RALD._
import uk.gov.hmrc.ui.pages.StubPage
import uk.gov.hmrc.ui.specs.BaseSpec
import uk.gov.hmrc.ui.utils.login.loginOl
import uk.gov.hmrc.ui.utils.mongo.RaldDB

class RaldNewAgreementCYASpec extends BaseSpec with StubPage {
  def completeRaldJourney(
    typeOfAgreement: String,
    rentBasedOn: String,
    hasRentAgreedInAdvance: String,
    hasRentPeriod: String,
    hasRentIncludeParking: String,
    hasPayExtraForParkingSpaces: String,
    hasIncludeRentReview: String,
    hasRepairsAndFittingOut: String,
    didYouGetMoneyFromLandlord: String,
    didYouPayAnyMoneyToLandlord: String,
    hasAnythingElseAffectedTheRent: String
  ): Unit = {

    RaldDB.cleanup()
    Given("Ratepayer logins through one login")
    loginOl()

    When("The ratepayer clicks on 'Tell us about a change' link from dashboard")
    dashboard()
    clickLink("Tell us about a change")

    Then("The ratepayers selects the property and proceed through the new agreement journey")
    YourProperty.yourProperty()
    clickLink("Select property")

    Then("The user selects new agreement link to create their new agreement")
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
    if (typeOfAgreement == "leaseOrTenancy")
      WhatTypeOfAgreement.leaseOrTenancyRadio()
    else if (typeOfAgreement == "verbal")
      WhatTypeOfAgreement.verbalRadio()
    else
      WhatTypeOfAgreement.writtenRadio()
    continueButtonClick()

    if (typeOfAgreement != "verbal") {
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
      if (rentBasedOn == "Other") {
        WhatIsRentBasedOn.selectRentBaseOn("Other")
        WhatIsRentBasedOn.otherRentBasedOnDescription("VOA budget")
      } else
        WhatIsRentBasedOn.selectRentBaseOn(rentBasedOn)
      continueButtonClick()

      if (rentBasedOn != "A percentage of expected turnover") {
        And("The user selects 'No' on rent agreed in advance")
        HaveYouAgreedInAdvanceRentChanges.haveYouAgreedInAdvanceRentChanges()
        if (hasRentAgreedInAdvance == "No")
          HaveYouAgreedInAdvanceRentChanges.noRadio()
        else
          HaveYouAgreedInAdvanceRentChanges.yesRadio()
        continueButtonClick()
      }
    } else {
      AgreementVerbal.agreementVerbal()
      AgreementVerbal.startDateInput("23", "4", "2025")
      AgreementVerbal.notOpenEndedAgreementRadio()
      AgreementVerbal.endDateInput("23", "4", "2027")
      continueButtonClick()
    }

    if (
      typeOfAgreement == "verbal" || rentBasedOn == "A percentage of expected turnover"
      || hasRentAgreedInAdvance == "No"
    ) {
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
    } else {
      When("The user provides the start and end date for the first rent period")
      ProvideDetailsOfFirstRentPeriodPage.provideDetailsOfFirstRentPeriodHeader()
      ProvideDetailsOfFirstRentPeriodPage.startDate("2011-01-02")
      ProvideDetailsOfFirstRentPeriodPage.endDate("2022-03-02")

      Then("The user selects 'Yes' radio button and enter the rent amount")
      ProvideDetailsOfFirstRentPeriodPage.rentPayablePeriodRadioYes()
      ProvideDetailsOfFirstRentPeriodPage.rentPeriodAmount("2,000.90")
      continueButtonClick()

      When("The user provides the end date for the second rent period")
      ProvideDetailsOfSecondRentPeriodPage.provideDetailsOfSecondRentPeriod()
      ProvideDetailsOfSecondRentPeriodPage.secondRentPeriodEndDate("02", "12", "2023")
      ProvideDetailsOfSecondRentPeriodPage.SecondRentPeriodRent("9999999.99")
      continueButtonClick()

      When("The user check rent period details on rent periods page")
      RentPeriods.rentPeriods()

      Then("The user selects 'Yes' for adding rent period")
      RentPeriods.addAnotherPeriod("Yes")
      continueButtonClick()

      AddingAdditionalRentPeriodScenario.addingRentPeriod("31", "1", "2024", "1000.45", 3, "Yes")
      AddingAdditionalRentPeriodScenario.addingRentPeriod("31", "3", "2024", "1500", 4, "No")

      Then("The user enters their rent date")
      RentDatesPage.rentDatesPage()
      RentDatesPage.agreeDateInput("19", "01", "2020")
      continueButtonClick()
    }

    Then("The user selects what their rent includes")
    WhatYourRentIncludesPage.whatYourRentIncludes()
    WhatYourRentIncludesPage.livingAccommodationRadio("No")
    WhatYourRentIncludesPage.rentPartAddressRadio("Yes")
    WhatYourRentIncludesPage.rentEmptyShellRadio("Yes")
    if (rentBasedOn != "Total Occupancy Cost leases (TOCs)") {
      WhatYourRentIncludesPage.rentIncBusinessRatesRadio("Yes")
      WhatYourRentIncludesPage.rentIncWaterChargesRadio("Yes")
      WhatYourRentIncludesPage.rentIncServiceRadio("Yes")
    }
    continueButtonClick()

    Then("The user selects no to having parking spaces or garages")
    DoesYourRentIncludeParkingPage.doesYourRentIncludeParking()
    if (hasRentIncludeParking == "No")
      DoesYourRentIncludeParkingPage.noRadio()
    else
      DoesYourRentIncludeParkingPage.yesRadio()
    continueButtonClick()

    if (hasRentIncludeParking == "Yes") {
      Then(
        "The user enters 3 for covered parking spaces, 2 for uncovered spaces and 1 for garage"
      )
      HowManyParkingSpacesOrGaragesIncludedInRentPage.howManyParkingSpacesOrGaragesIncludedInRent()
      HowManyParkingSpacesOrGaragesIncludedInRentPage.enterCoveredSpaces("3")
      HowManyParkingSpacesOrGaragesIncludedInRentPage.enterUncoveredSpaces("2")
      HowManyParkingSpacesOrGaragesIncludedInRentPage.enterGarages("1")
      continueButtonClick()
    }

    Then("The user select yes to pay extra parking spaces not included in rent")
    DoYouPayExtraForParkingSpaces.doYouPayExtraForParkingSpaces()
    if (hasPayExtraForParkingSpaces == "Yes")
      DoYouPayExtraForParkingSpaces.selectPayExtraRadio("yes")
    else
      DoYouPayExtraForParkingSpaces.selectPayExtraRadio("no")
    continueButtonClick()

    if (hasPayExtraForParkingSpaces == "Yes") {
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
    }

    if (rentBasedOn != "Total Occupancy Cost leases (TOCs)") {
      Then("The user selects you to who pays for internal, external and building insurance repairs")
      RepairsAndInsurancePage.repairsAndInsurance()
      RepairsAndInsurancePage.whoPaysForInternalRepairsRadio("You")
      RepairsAndInsurancePage.whoPaysForExternalRepairsRadio("You")
      RepairsAndInsurancePage.WhoPaysForBuildingInsuranceRepairs("You")
      continueButtonClick()
    }

    Then("The user select no for rent review and yes for rent go down")
    RentReviewPage.rentReview()
    if (hasRentPeriod == "No")
      RentReviewPage.hasIncludeRentReview("no")
    else {
      RentReviewPage.hasIncludeRentReview("yes")
      RentReviewPage.enterRentReviewMonths("12")
    }
    RentReviewPage.canRentGoDown("yes")
    continueButtonClick()

    Then("The user select no on repairs and fitting out")
    RepairsAndFittingOutPage.repairsAndFittingOut()
    if (hasRepairsAndFittingOut == "Yes")
      RepairsAndFittingOutPage.yesRadio()
    else
      RepairsAndFittingOutPage.noRadio()
    continueButtonClick()

    if (hasRepairsAndFittingOut == "Yes") {
      Then("The user is on the About Repairs and Fitting Out page")
      AboutRepairsAndFittingOutPage.aboutRepairsAndFittingOut()
      AboutRepairsAndFittingOutPage.enterRepairCost("1234.56")
      AboutRepairsAndFittingOutPage.enterRepairDate("10", "2025")
      continueButtonClick()
    }

    Then("Did you get any money from the landlord or previous tenant to take on the lease?")
    DidYouGetMoneyFromLandlordPage.didYouGetMoneyFromLandlord()
    if (didYouGetMoneyFromLandlord == "Yes")
      DidYouGetMoneyFromLandlordPage.yesRadio()
    else
      DidYouGetMoneyFromLandlordPage.noRadio()
    continueButtonClick()

    if (didYouGetMoneyFromLandlord == "Yes") {
      Then("Money you got from the landlord or previous tenant to take on the lease")
      MoneyToTakeOnTheLeasePage.moneyToTakeOnTheLease()
      MoneyToTakeOnTheLeasePage.moneyToTakeOnTheLeaseAmountInput("500")
      MoneyToTakeOnTheLeasePage.moneyToTakeOnTheLeaseDateInput("12", "11", "2025")
      continueButtonClick()
    }

    Then("Did you pay any money in advance to the landlord?")
    DidYouPayAnyMoneyToLandlordPage.didYouPayAnyMoneyToLandlord()
    if (didYouPayAnyMoneyToLandlord == "Yes")
      DidYouPayAnyMoneyToLandlordPage.yesRadio()
    else
      DidYouPayAnyMoneyToLandlordPage.noRadio()
    continueButtonClick()

    if (didYouPayAnyMoneyToLandlord == "Yes") {
      Then("Money you paid in advance to the landlord")
      MoneyYouPaidInAdvanceToLandlordPage.moneyYouPaidInAdvanceToLandlord()
      MoneyYouPaidInAdvanceToLandlordPage.moneyYouPaidInAdvanceToLandlordAmountInput("500")
      MoneyYouPaidInAdvanceToLandlordPage.moneyYouPaidInAdvanceToLandlordDateInput("12", "11", "2025")
      continueButtonClick()
    }

    Then("Has anything else affected the rent")
    HasAnythingElsePage.hasAnythingElseAffectedTheRent()
    if (hasAnythingElseAffectedTheRent == "No")
      HasAnythingElsePage.hasAffected("no")
    else {
      HasAnythingElsePage.hasAffected("yes")
      HasAnythingElsePage.reasonDescription("test")
    }
    continueButtonClick()

    Then("The user reaches the Check Your Answers page")
    CheckYourAnswersRald.checkYourAnswersHeader()
    CheckYourAnswersRald.checkSectionHeadings(rentBasedOn == "Total Occupancy Cost leases (TOCs)")
  }

  Feature("Change details on RALD Check Your Answers page") {
    Scenario("Change multiple details after completing RALD journey") {
      RaldDB.cleanup()
      completeRaldJourney(
        typeOfAgreement = "leaseOrTenancy",
        rentBasedOn = "Other",
        hasRentAgreedInAdvance = "No",
        hasRentPeriod = "No",
        hasRentIncludeParking = "Yes",
        hasPayExtraForParkingSpaces = "Yes",
        hasIncludeRentReview = "No",
        hasRepairsAndFittingOut = "Yes",
        didYouGetMoneyFromLandlord = "Yes",
        didYouPayAnyMoneyToLandlord = "Yes",
        hasAnythingElseAffectedTheRent = "Yes"
      )

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

      // Check changing agreement start date
      CheckYourAnswersRald.clickChangeLink("agreement-start-date")
      Agreement.enterAgreementStartDate("15", "06", "2025")
      continueButtonClick()
      CheckYourAnswersRald.verifySummaryRow("Agreement start date", "15 June 2025")

      // Check changing open-ended agreement
      CheckYourAnswersRald.clickChangeLink("is-open-ended")
      Agreement.agreementOpenEndedRadio("Yes")
      continueButtonClick()
      CheckYourAnswersRald.verifySummaryRow("Is your agreement open-ended?", "Yes, it is open-ended")

      // Check changing break clause details
      CheckYourAnswersRald.clickChangeLink("break-clause")
      Agreement.agreementHaveABreakClauseRadio("No")
      continueButtonClick()
      CheckYourAnswersRald.verifySummaryRow("Does your agreement have a break clause?", "No")

      // Check changing total annual rent
      CheckYourAnswersRald.clickChangeLink("how-much-is-total-annual-rent")
      HowMuchIsTotalAnnualRent.inputTotalAnnualRent("15000")
      continueButtonClick()
      CheckYourAnswersRald.verifySummaryRow("Total annual rent", "£15,000")

      // Check changing rent-free period
      CheckYourAnswersRald.clickChangeLink("check-rent-free-period")
      DoYouHaveRentFreePeriod.selectRentFreePeriodRadio("no")
      continueButtonClick()
      CheckYourAnswersRald.verifySummaryRow("Do you have a rent-free period at the start of your agreement?", "No")

      // Check changing rent date
      CheckYourAnswersRald.clickChangeLink("when-did-you-agree")
      RentDatesAgreeStartPage.agreeDateInput(day = "30", month = "12", year = "2020")
      continueButtonClick()
      CheckYourAnswersRald.verifySummaryRow("When did you agree your rent?", "30 December 2020")

      CheckYourAnswersRald.clickChangeLink("start-paying-date")
      RentDatesAgreeStartPage.startDateInput(day = "15", month = "01", year = "2021")
      continueButtonClick()
      CheckYourAnswersRald.verifySummaryRow("When will you start paying rent?", "15 January 2021")

      // Check changing rent includes living accommodation
      CheckYourAnswersRald.clickChangeLink("living-accommodation")
      WhatYourRentIncludesPage.livingAccommodationRadio("Yes")
      WhatYourRentIncludesPage.bedroomNumbers("5")
      continueButtonClick()
      CheckYourAnswersRald.verifySummaryRow("Does your rent include any living accommodation?", "Yes")
      CheckYourAnswersRald.verifySummaryRow("How many bedrooms does the living accommodation have?", "5")

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

      // Check changing uncovered spaces included in rent
      CheckYourAnswersRald.clickChangeLink("how-many-uncovered-spaces-included-in-rent")
      HowManyParkingSpacesOrGaragesIncludedInRentPage.enterUncoveredSpaces("4")
      continueButtonClick()
      CheckYourAnswersRald.verifySummaryRow("Uncovered spaces included in you rent", "4")

      // Check changing covered spaces included in rent
      CheckYourAnswersRald.clickChangeLink("how-many-covered-spaces-included-in-rent")
      HowManyParkingSpacesOrGaragesIncludedInRentPage.enterCoveredSpaces("2")
      continueButtonClick()
      CheckYourAnswersRald.verifySummaryRow("Covered spaces included in you rent", "2")

      // Check changing garages included in rent
      CheckYourAnswersRald.clickChangeLink("how-many-garages-included-in-rent")
      HowManyParkingSpacesOrGaragesIncludedInRentPage.enterGarages("3")
      continueButtonClick()
      CheckYourAnswersRald.verifySummaryRow("Garages included in you rent", "3")

      // Check changing rent includes parking/garages
      CheckYourAnswersRald.clickChangeLink("rent-inc-parking")
      DoesYourRentIncludeParkingPage.noRadio()
      continueButtonClick()
      CheckYourAnswersRald.verifySummaryRow("Does your rent include parking spaces or garages?", "No")

      // Check changing extra payment for uncovered spaces
      CheckYourAnswersRald.clickChangeLink("how-many-uncovered-spaces-not-included-in-rent")
      ParkingSpacesOrGaragesNotIncludedInYourRentPage.enterUncoveredSpaces("1")
      continueButtonClick()
      CheckYourAnswersRald.verifySummaryRow("Uncovered spaces not included in your rent", "1")

      // Check changing extra payment for covered spaces
      CheckYourAnswersRald.clickChangeLink("how-many-covered-spaces-not-included-in-rent")
      ParkingSpacesOrGaragesNotIncludedInYourRentPage.enterCoveredSpaces("3")
      continueButtonClick()
      CheckYourAnswersRald.verifySummaryRow("Covered spaces not included in your rent", "3")

      // Check changing extra payment for garages
      CheckYourAnswersRald.clickChangeLink("how-many-garages-not-included-in-rent")
      ParkingSpacesOrGaragesNotIncludedInYourRentPage.enterGarages("2")
      continueButtonClick()
      CheckYourAnswersRald.verifySummaryRow("Garages not included in your rent", "2")

      // Check changing extra payment for total cost
      CheckYourAnswersRald.clickChangeLink("parking-spaces-or-garages-not-included-in-your-rent-value")
      ParkingSpacesOrGaragesNotIncludedInYourRentPage.totalCost("15000")
      continueButtonClick()
      CheckYourAnswersRald.verifySummaryRow(
        "How much extra do you pay for parking and garages (excluding VAT)?",
        "£15,000"
      )

      // Check changing extra payment for agreement date
      CheckYourAnswersRald.clickChangeLink("parking-spaces-or-garages-not-included-in-your-rent-value")
      ParkingSpacesOrGaragesNotIncludedInYourRentPage.agreementDateInput(day = "19", month = "02", year = "1997")
      continueButtonClick()
      CheckYourAnswersRald.verifySummaryRow("When was this payment agreed for parking and garages?", "19 February 1997")

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
      CheckYourAnswersRald.verifySummaryRow("Who pays for external repairs?", "The landlord")

      // Check changing insurance responsibility
      CheckYourAnswersRald.clickChangeLink("building-insurance")
      RepairsAndInsurancePage.WhoPaysForBuildingInsuranceRepairs("the landlord")
      continueButtonClick()
      CheckYourAnswersRald.verifySummaryRow("Who pays for building insurance repairs?", "The landlord")

      // Rent review details
      // Check changing rent review inclusion
      CheckYourAnswersRald.clickChangeLink("has-include-rent-review")
      RentReviewPage.hasIncludeRentReview("Yes")
      RentReviewPage.enterRentReviewMonths("12")
      continueButtonClick()
      CheckYourAnswersRald.verifySummaryRow("Does your agreement include a rent review?", "Yes")
      CheckYourAnswersRald.verifySummaryRow("How often is your rent reviewed?", "Every 12 months")

      // Check changing rent review can go down
      CheckYourAnswersRald.clickChangeLink("can-rent-go-down")
      RentReviewPage.canRentGoDown("No")
      continueButtonClick()
      CheckYourAnswersRald.verifySummaryRow("Can the rent go down when it is reviewed?", "No")

      // Repairs and fitting out
      // Check changing repairs and fitting out date
      CheckYourAnswersRald.clickChangeLink("repairs-and-fitting-out-date")
      AboutRepairsAndFittingOutPage.enterRepairDate("12", "2025")
      continueButtonClick()
      CheckYourAnswersRald.verifySummaryRow("When did you do the repairs or fitting out?", "December 2025")

      // Check changing repairs and fitting out cost
      CheckYourAnswersRald.clickChangeLink("repairs-and-fitting-out-cost")
      AboutRepairsAndFittingOutPage.enterRepairCost("15234.56")
      continueButtonClick()
      CheckYourAnswersRald.verifySummaryRow(
        "How much did the repairs or fitting out cost (excluding VAT)?",
        "£15,234.56"
      )

      // Check changing repairs/fitting out done by tenant
      CheckYourAnswersRald.clickChangeLink("repairs-and-fitting-out")
      RepairsAndFittingOutPage.noRadio()
      continueButtonClick()
      CheckYourAnswersRald.verifySummaryRow("Have you done any repairs or fitting out in the property?", "No")

      // Payments
      // Check changing money received from landlord for the amount
      CheckYourAnswersRald.clickChangeLink("money-to-take-on-the-lease-amount")
      MoneyToTakeOnTheLeasePage.moneyToTakeOnTheLeaseAmountInput("1500")
      continueButtonClick()
      CheckYourAnswersRald.verifySummaryRow(
        "How much money did you get to take on the lease (excluding VAT)?",
        "£1,500"
      )

      // Check changing money received from landlord for the date
      CheckYourAnswersRald.clickChangeLink("money-to-take-on-the-lease-date")
      MoneyToTakeOnTheLeasePage.moneyToTakeOnTheLeaseDateInput("12", "10", "2025")
      continueButtonClick()
      CheckYourAnswersRald.verifySummaryRow("When did you get the money?", "12 October 2025")

      // Check changing money received from landlord
      CheckYourAnswersRald.clickChangeLink("did-you-get-money-from-landlord")
      DidYouGetMoneyFromLandlordPage.noRadio()
      continueButtonClick()
      CheckYourAnswersRald.verifySummaryRow(
        "Did you get any money from the landlord or previous tenant to take on the lease?",
        "No"
      )

      // Check changing money paid in advance for the amount
      CheckYourAnswersRald.clickChangeLink("money-you-paid-in-advance-to-landlord-amount")
      MoneyYouPaidInAdvanceToLandlordPage.moneyYouPaidInAdvanceToLandlordAmountInput("700")
      continueButtonClick()
      CheckYourAnswersRald.verifySummaryRow(
        "How much money did you pay in advance to the landlord (excluding VAT)?",
        "£700"
      )

      // Check changing money paid in advance for the amount
      CheckYourAnswersRald.clickChangeLink("money-you-paid-in-advance-to-landlord-date")
      MoneyYouPaidInAdvanceToLandlordPage.moneyYouPaidInAdvanceToLandlordDateInput("12", "09", "2025")
      continueButtonClick()
      CheckYourAnswersRald.verifySummaryRow("When did you pay the money?", "12 September 2025")

      // Check changing money paid in advance
      CheckYourAnswersRald.clickChangeLink("did-you-pay-money-to-landlord")
      DidYouPayAnyMoneyToLandlordPage.noRadio()
      continueButtonClick()
      CheckYourAnswersRald.verifySummaryRow("Did you pay any money in advance to the landlord?", "No")

      // Other details
      // Check changing for affecting rent details
      CheckYourAnswersRald.clickChangeLink("other-details-reason")
      HasAnythingElsePage.reasonDescription("Affected the rent")
      continueButtonClick()
      CheckYourAnswersRald.verifySummaryRow("Can you tell us what else has affected the rent?", "Affected the rent")

      // Check changing other factors affecting rent
      CheckYourAnswersRald.clickChangeLink("other-details")
      HasAnythingElsePage.hasAffected("")
      continueButtonClick()
      CheckYourAnswersRald.verifySummaryRow("Has anything else affected the rent?", "No")
    }
    Scenario("Change rent periods end date after completing RALD journey") {
      RaldDB.cleanup()
      completeRaldJourney(
        typeOfAgreement = "leaseOrTenancy",
        rentBasedOn = "Total Occupancy Cost leases (TOCs)",
        hasRentAgreedInAdvance = "Yes",
        hasRentPeriod = "No",
        hasRentIncludeParking = "Yes",
        hasPayExtraForParkingSpaces = "Yes",
        hasIncludeRentReview = "No",
        hasRepairsAndFittingOut = "No",
        didYouGetMoneyFromLandlord = "No",
        didYouPayAnyMoneyToLandlord = "No",
        hasAnythingElseAffectedTheRent = "No"
      )

      // Checking changing for first rent period
      CheckYourAnswersRald.clickChangeLink("provide-details-of-first-period-start")
      ProvideDetailsOfFirstRentPeriodPage.startDate("2011-01-01")
      continueButtonClick()
      // Second rent period
      continueButtonClick()
      RentPeriods.addAnotherPeriod("No")
      continueButtonClick()

      CheckYourAnswersRald.verifySummaryRow("Start date", "1 January 2011")

      CheckYourAnswersRald.clickChangeLink("rent-period-1-end")
      ProvideDetailsOfSecondRentPeriodPage.secondRentPeriodEndDate("31", "12", "2023")
      continueButtonClick()
      RentPeriods.addAnotherPeriod("Yes")
      continueButtonClick()
      AddingAdditionalRentPeriodScenario.addingRentPeriod("31", "1", "2024", "1000.45", 3, "No")

      headerCheck2("First rent period")
      headerCheck2("Second rent period")
      headerCheck2("Third rent period")

      CheckYourAnswersRald.clickChangeLink("provide-details-of-first-period-amount")
      ProvideDetailsOfFirstRentPeriodPage.rentPeriodAmount("1000.90")
      continueButtonClick()
      // Second rent period
      continueButtonClick()
      RentPeriods.addAnotherPeriod("No")
      continueButtonClick()

      CheckYourAnswersRald.verifySummaryRow("Rent for this period (excluding VAT)", "£1,000.90")
    }
    Scenario("Change rent based on from TOC to open market value after completing RALD journey") {
      RaldDB.cleanup()
      completeRaldJourney(
        typeOfAgreement = "leaseOrTenancy",
        rentBasedOn = "Total Occupancy Cost leases (TOCs)",
        hasRentAgreedInAdvance = "Yes",
        hasRentPeriod = "No",
        hasRentIncludeParking = "Yes",
        hasPayExtraForParkingSpaces = "Yes",
        hasIncludeRentReview = "No",
        hasRepairsAndFittingOut = "No",
        didYouGetMoneyFromLandlord = "No",
        didYouPayAnyMoneyToLandlord = "No",
        hasAnythingElseAffectedTheRent = "No"
      )
      // Rent details
      // Checking what is the rent based on
      CheckYourAnswersRald.clickChangeLink("what-is-your-rent-based-on")
      WhatIsRentBasedOn.whatIsRentBasedOn()
      WhatIsRentBasedOn.selectRentBaseOn("Open market value")
      continueButtonClick()

      WhatYourRentIncludesPage.livingAccommodationRadio("No")
      WhatYourRentIncludesPage.rentPartAddressRadio("Yes")
      WhatYourRentIncludesPage.rentEmptyShellRadio("Yes")
      WhatYourRentIncludesPage.rentIncBusinessRatesRadio("Yes")
      WhatYourRentIncludesPage.rentIncWaterChargesRadio("Yes")
      WhatYourRentIncludesPage.rentIncServiceRadio("Yes")
      continueButtonClick()

      RepairsAndInsurancePage.whoPaysForInternalRepairsRadio("You and the landlord")
      RepairsAndInsurancePage.whoPaysForExternalRepairsRadio("You and the landlord")
      RepairsAndInsurancePage.WhoPaysForBuildingInsuranceRepairs("You and the landlord")
      continueButtonClick()

      CheckYourAnswersRald.verifySummaryRow("What is your rent based on?", "Open market value")
      CheckYourAnswersRald.verifySummaryRow("Does your rent include business rates?", "Yes")
      CheckYourAnswersRald.verifySummaryRow("Does your rent include water charges?", "Yes")
      CheckYourAnswersRald.verifySummaryRow("Does your rent include service charges?", "Yes")
      CheckYourAnswersRald.verifySummaryRow("Who pays for internal repairs?", "You and the landlord")
      CheckYourAnswersRald.verifySummaryRow("Who pays for external repairs?", "You and the landlord")
      CheckYourAnswersRald.verifySummaryRow("Who pays for building insurance repairs?", "You and the landlord")
    }
    Scenario("Change rent based on from TOC to A percentage of expected turnover after completing RALD journey") {
      RaldDB.cleanup()
      completeRaldJourney(
        typeOfAgreement = "leaseOrTenancy",
        rentBasedOn = "Total Occupancy Cost leases (TOCs)",
        hasRentAgreedInAdvance = "Yes",
        hasRentPeriod = "No",
        hasRentIncludeParking = "Yes",
        hasPayExtraForParkingSpaces = "Yes",
        hasIncludeRentReview = "No",
        hasRepairsAndFittingOut = "No",
        didYouGetMoneyFromLandlord = "No",
        didYouPayAnyMoneyToLandlord = "No",
        hasAnythingElseAffectedTheRent = "No"
      )
      // Rent details
      // Checking what is the rent based on
      CheckYourAnswersRald.clickChangeLink("what-is-your-rent-based-on")
      WhatIsRentBasedOn.selectRentBaseOn("A percentage of expected turnover")
      continueButtonClick()

      HowMuchIsTotalAnnualRent.howMuchIsTotalAnnualRent()
      HowMuchIsTotalAnnualRent.inputTotalAnnualRent("5000")
      continueButtonClick()

      DoYouHaveRentFreePeriod.selectRentFreePeriodRadio("Yes")
      continueButtonClick()

      RentFreePeriod.enterRentFreePeriodMonths("7")
      RentFreePeriod.enterReasons("Any reasons 2")
      continueButtonClick()

      RentDatesAgreeStartPage.agreeDateInput(day = "12", month = "10", year = "2020")
      RentDatesAgreeStartPage.startDateInput(day = "10", month = "03", year = "2021")
      continueButtonClick()

      WhatYourRentIncludesPage.rentIncWaterChargesRadio("Yes")
      WhatYourRentIncludesPage.rentIncBusinessRatesRadio("Yes")
      WhatYourRentIncludesPage.rentIncServiceRadio("Yes")
      continueButtonClick()

      RepairsAndInsurancePage.whoPaysForExternalRepairsRadio("The landlord")
      RepairsAndInsurancePage.whoPaysForInternalRepairsRadio("The landlord")
      RepairsAndInsurancePage.WhoPaysForBuildingInsuranceRepairs("The landlord")
      continueButtonClick()

      CheckYourAnswersRald.verifySummaryRow("Total annual rent", "£5,000")
      CheckYourAnswersRald.verifySummaryRow("Do you have a rent-free period at the start of your agreement?", "Yes")
      CheckYourAnswersRald.verifySummaryRow("How many months is your rent-free period?", "7 months")
      CheckYourAnswersRald.verifySummaryRow("Why do you have a rent-free period?", "Any reasons 2")
      CheckYourAnswersRald.verifySummaryRow("When did you agree your rent?", "12 October 2020")
      CheckYourAnswersRald.verifySummaryRow("When will you start paying rent?", "10 March 2021")
      CheckYourAnswersRald.verifySummaryRow("What is your rent based on?", "A percentage of expected turnover")
      CheckYourAnswersRald.verifySummaryRow("Does your rent include business rates?", "Yes")
      CheckYourAnswersRald.verifySummaryRow("Does your rent include water charges?", "Yes")
      CheckYourAnswersRald.verifySummaryRow("Does your rent include service charges?", "Yes")
      CheckYourAnswersRald.verifySummaryRow("Who pays for internal repairs?", "The landlord")
      CheckYourAnswersRald.verifySummaryRow("Who pays for external repairs?", "The landlord")
      CheckYourAnswersRald.verifySummaryRow("Who pays for building insurance repairs?", "The landlord")
    }
    Scenario(
      "Change rent based on from A percentage of expected turnover to A percentage of open market value after completing RALD journey"
    ) {
      RaldDB.cleanup()
      completeRaldJourney(
        typeOfAgreement = "leaseOrTenancy",
        rentBasedOn = "A percentage of expected turnover",
        hasRentAgreedInAdvance = "Yes",
        hasRentPeriod = "No",
        hasRentIncludeParking = "Yes",
        hasPayExtraForParkingSpaces = "Yes",
        hasIncludeRentReview = "No",
        hasRepairsAndFittingOut = "No",
        didYouGetMoneyFromLandlord = "No",
        didYouPayAnyMoneyToLandlord = "No",
        hasAnythingElseAffectedTheRent = "No"
      )
      CheckYourAnswersRald.clickChangeLink("what-is-your-rent-based-on")
      WhatIsRentBasedOn.selectRentBaseOn("A percentage of open market value")
      continueButtonClick()

      HaveYouAgreedInAdvanceRentChanges.yesRadio()
      continueButtonClick()

      ProvideDetailsOfFirstRentPeriodPage.startDate("2011-01-02")
      ProvideDetailsOfFirstRentPeriodPage.endDate("2022-03-02")
      ProvideDetailsOfFirstRentPeriodPage.rentPayablePeriodRadioYes()
      ProvideDetailsOfFirstRentPeriodPage.rentPeriodAmount("2,000.90")
      continueButtonClick()

      ProvideDetailsOfSecondRentPeriodPage.secondRentPeriodEndDate("02", "12", "2023")
      ProvideDetailsOfSecondRentPeriodPage.SecondRentPeriodRent("9999999.99")
      continueButtonClick()

      RentPeriods.addAnotherPeriod("No")
      continueButtonClick()

      RentDatesPage.agreeDateInput("19", "01", "2020")
      continueButtonClick()

      CheckYourAnswersRald.verifySummaryRow("What is your rent based on?", "A percentage of open market value")
      CheckYourAnswersRald.verifySummaryRow("Start date", "2 January 2011")
    }
    Scenario("Change type of agreement from after leaseOrTenancy to verbal completing RALD journey") {
      RaldDB.cleanup()
      completeRaldJourney(
        typeOfAgreement = "leaseOrTenancy",
        rentBasedOn = "Total Occupancy Cost leases (TOCs)",
        hasRentAgreedInAdvance = "Yes",
        hasRentPeriod = "No",
        hasRentIncludeParking = "Yes",
        hasPayExtraForParkingSpaces = "Yes",
        hasIncludeRentReview = "No",
        hasRepairsAndFittingOut = "No",
        didYouGetMoneyFromLandlord = "No",
        didYouPayAnyMoneyToLandlord = "No",
        hasAnythingElseAffectedTheRent = "No"
      )
      // Agreement details
      // Check changing agreement type to verbal
      CheckYourAnswersRald.clickChangeLink("what-type-of-agreement")
      WhatTypeOfAgreement.verbalRadio()
      continueButtonClick()

      AgreementVerbal.agreementVerbal()
      AgreementVerbal.startDateInput("23", "4", "2025")
      AgreementVerbal.notOpenEndedAgreementRadio()
      AgreementVerbal.endDateInput("23", "4", "2027")
      continueButtonClick()

      HowMuchIsTotalAnnualRent.howMuchIsTotalAnnualRent()
      HowMuchIsTotalAnnualRent.inputTotalAnnualRent("7000")
      continueButtonClick()

      DoYouHaveRentFreePeriod.doYouHaveRentFreePeriod()
      DoYouHaveRentFreePeriod.selectRentFreePeriodRadio("Yes")
      continueButtonClick()

      RentFreePeriod.rentFreePeriod()
      RentFreePeriod.enterRentFreePeriodMonths("5")
      RentFreePeriod.enterReasons("Any reasons")
      continueButtonClick()

      RentDatesAgreeStartPage.rentDatesAgreeStartPage()
      RentDatesAgreeStartPage.agreeDateInput(day = "12", month = "12", year = "2020")
      RentDatesAgreeStartPage.startDateInput(day = "10", month = "01", year = "2021")
      continueButtonClick()

      WhatYourRentIncludesPage.rentIncWaterChargesRadio("Yes")
      WhatYourRentIncludesPage.rentIncBusinessRatesRadio("Yes")
      WhatYourRentIncludesPage.rentIncServiceRadio("Yes")
      continueButtonClick()

      RepairsAndInsurancePage.whoPaysForExternalRepairsRadio("The landlord")
      RepairsAndInsurancePage.whoPaysForInternalRepairsRadio("The landlord")
      RepairsAndInsurancePage.WhoPaysForBuildingInsuranceRepairs("The landlord")
      continueButtonClick()

      CheckYourAnswersRald.verifySummaryRow("What type of agreement do you have?", "Verbal agreement")
      CheckYourAnswersRald.verifySummaryRow("Agreement start date", "23 April 2025")
      CheckYourAnswersRald.verifySummaryRow(
        "Is your agreement open-ended?",
        "No, it runs for a defined term or has an agreed end date"
      )
      CheckYourAnswersRald.verifySummaryRow("What type of agreement do you have?", "Verbal agreement")
      CheckYourAnswersRald.verifySummaryRow("Total annual rent", "£7,000")
      CheckYourAnswersRald.verifySummaryRow("Do you have a rent-free period at the start of your agreement?", "Yes")
      CheckYourAnswersRald.verifySummaryRow("How many months is your rent-free period?", "5 months")
      CheckYourAnswersRald.verifySummaryRow("Why do you have a rent-free period?", "Any reasons")
      CheckYourAnswersRald.verifySummaryRow("When did you agree your rent?", "12 December 2020")
      CheckYourAnswersRald.verifySummaryRow("When will you start paying rent?", "10 January 2021")
      CheckYourAnswersRald.verifySummaryRow("Who pays for internal repairs?", "The landlord")
      CheckYourAnswersRald.verifySummaryRow("Who pays for external repairs?", "The landlord")
      CheckYourAnswersRald.verifySummaryRow("Who pays for building insurance repairs?", "The landlord")
    }
    Scenario("Change type of agreement from after verbal to written completing RALD journey") {
      RaldDB.cleanup()
      completeRaldJourney(
        typeOfAgreement = "verbal",
        rentBasedOn = "Indexation",
        hasRentAgreedInAdvance = "Yes",
        hasRentPeriod = "No",
        hasRentIncludeParking = "Yes",
        hasPayExtraForParkingSpaces = "Yes",
        hasIncludeRentReview = "No",
        hasRepairsAndFittingOut = "No",
        didYouGetMoneyFromLandlord = "No",
        didYouPayAnyMoneyToLandlord = "No",
        hasAnythingElseAffectedTheRent = "No"
      )
      // Agreement details
      // Check changing agreement type to written
      CheckYourAnswersRald.clickChangeLink("what-type-of-agreement")
      WhatTypeOfAgreement.writtenRadio()
      continueButtonClick()

      Agreement.enterAgreementStartDate("02", "01", "2005")
      Agreement.agreementOpenEndedRadio("No")
      Agreement.enterOpenEndedAgreementDate("02", "01", "2030")
      Agreement.agreementHaveABreakClauseRadio("Yes")
      Agreement.agreementBreakClauseReason(
        "Tenant needs to move due to employer's requirement to work in-office three days a week."
      )
      continueButtonClick()

      WhatIsRentBasedOn.selectRentBaseOn("Total Occupancy Cost leases (TOCs)")
      continueButtonClick()

      HaveYouAgreedInAdvanceRentChanges.noRadio()
      continueButtonClick()

      HowMuchIsTotalAnnualRent.inputTotalAnnualRent("7000")
      continueButtonClick()

      DoYouHaveRentFreePeriod.selectRentFreePeriodRadio("Yes")
      continueButtonClick()

      RentFreePeriod.enterRentFreePeriodMonths("5")
      RentFreePeriod.enterReasons("Any reasons")
      continueButtonClick()

      RentDatesAgreeStartPage.agreeDateInput(day = "12", month = "12", year = "2020")
      RentDatesAgreeStartPage.startDateInput(day = "10", month = "01", year = "2021")
      continueButtonClick()

      WhatYourRentIncludesPage.livingAccommodationRadio("No")
      WhatYourRentIncludesPage.rentPartAddressRadio("Yes")
      WhatYourRentIncludesPage.rentEmptyShellRadio("Yes")
      continueButtonClick()

      CheckYourAnswersRald.verifySummaryRow(
        "What type of agreement do you have?",
        "Licence or other type of written agreement"
      )
      CheckYourAnswersRald.verifySummaryRow("Total annual rent", "£7,000")
      CheckYourAnswersRald.verifySummaryRow("Do you have a rent-free period at the start of your agreement?", "Yes")
      CheckYourAnswersRald.verifySummaryRow("How many months is your rent-free period?", "5 months")
      CheckYourAnswersRald.verifySummaryRow("Why do you have a rent-free period?", "Any reasons")
      CheckYourAnswersRald.verifySummaryRow("When did you agree your rent?", "12 December 2020")
      CheckYourAnswersRald.verifySummaryRow("When will you start paying rent?", "10 January 2021")
    }
  }
}
