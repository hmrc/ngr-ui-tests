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

class RenewedAgreementSpec extends BaseSpec with StubPage {

  Feature("Testing the renewed agreement functionality") {
    Scenario(
      "The user renewed their agreement, agreement type: Licence or other type of written agreement, rent based on: A percentage of expected turnover"
    ) {
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
      clickLink("You renewed your agreement")
      TellUsAboutYourRenewedAgreementPage.tellUsAboutYourRenewedAgreement()
      continueButtonClick()

      Then("The user selects renewed agreement type of lease renewal")
      WhatTypeOfLeaseRenewal.typeOfLeaseRenewal()
      WhatTypeOfLeaseRenewal.renewedAgreementRadio()
      continueButtonClick()

      /* relationship With The Landlord = 'family Member'*/
      Then("The user inputs the landlords name and selects family member as type")
      Landlord.landlord()
      Landlord.landlordNameInput(landlordName = "Bob")
      Landlord.noRadio()
      continueButtonClick()

      Then("The user selects licence or other type of written agreement as there agreement type")
      WhatTypeOfAgreement.TypeOfAgreement()
      WhatTypeOfAgreement.writtenRadio()
      continueButtonClick()

      Then("The user entered agreement start and end date")
      Agreement.agreement()
      Agreement.enterAgreementStartDate("02", "01", "2015")
      Agreement.agreementOpenEndedRadio("No")
      Agreement.enterOpenEndedAgreementDate("11", "11", "2027")
      Agreement.agreementHaveABreakClauseRadio("No")
      continueButtonClick()

      /*'What is your rent based on?' = 'A percentage of expected turnover'*/
      Then("The user selects other and input reason on 'What is your rent based on?' page and submit")
      WhatIsRentBasedOn.whatIsRentBasedOn()
      WhatIsRentBasedOn.selectRentBaseOn("A percentage of expected turnover")
      continueButtonClick()

      Then("The user enter how much is total annual rent")
      HowMuchIsTotalAnnualRent.howMuchIsTotalAnnualRent()
      HowMuchIsTotalAnnualRent.inputTotalAnnualRent("999900")
      continueButtonClick()

      Then("The user selects 'Yes' with agreeing the rent with their landlord or their agent")
      DidYouAgreeRentWithLandlordPage.didYouAgreeRentWithLandlord()
      DidYouAgreeRentWithLandlordPage.didYouAgreeRentWithLandlordRadio("Yes")
      continueButtonClick()

      Then("The user selects 'Yes' to having a rent free period")
      DoYouHaveRentFreePeriod.doYouHaveRentFreePeriod()
      DoYouHaveRentFreePeriod.selectRentFreePeriodRadio("Yes")
      continueButtonClick()

      Then("The user states 10 rent free months with a reason")
      RentFreePeriod.rentFreePeriod()
      RentFreePeriod.enterRentFreePeriodMonths("10")
      RentFreePeriod.enterReasons("Was out the country")
      continueButtonClick()

      Then("The user enters the date they agreed their rent")
      RentDatesAgreeStartPage.rentDatesAgreeStartPage()
      RentDatesAgreeStartPage.agreeDateInput("03", "12", "2023")
      RentDatesAgreeStartPage.startDateInput("19", "12", "2023")
      continueButtonClick()

      Then("The user selects what their rent includes")
      WhatYourRentIncludesPage.whatYourRentIncludes()
      WhatYourRentIncludesPage.livingAccommodationRadio("Yes")
      WhatYourRentIncludesPage.bedroomNumbers("5")
      WhatYourRentIncludesPage.rentPartAddressRadio("No")
      WhatYourRentIncludesPage.rentEmptyShellRadio("No")
      WhatYourRentIncludesPage.rentIncBusinessRatesRadio("No")
      WhatYourRentIncludesPage.rentIncWaterChargesRadio("No")
      WhatYourRentIncludesPage.rentIncServiceRadio("No")
      continueButtonClick()

      Then("The user selects 'No' to having parking spaces or garages")
      DoesYourRentIncludeParkingPage.doesYourRentIncludeParking()
      DoesYourRentIncludeParkingPage.noRadio()
      continueButtonClick()

      Then("The user select no to pay extra parking spaces not included in rent")
      DoYouPayExtraForParkingSpaces.doYouPayExtraForParkingSpaces()
      DoYouPayExtraForParkingSpaces.selectPayExtraRadio("no")
      continueButtonClick()

      Then("The user selects you to who pays for internal, external and building insurance repairs")
      RepairsAndInsurancePage.repairsAndInsurance()
      RepairsAndInsurancePage.whoPaysForInternalRepairsRadio("You")
      RepairsAndInsurancePage.whoPaysForExternalRepairsRadio("You")
      RepairsAndInsurancePage.WhoPaysForBuildingInsuranceRepairs("You")
      continueButtonClick()

      Then("The user select yes for rent review and no for rent go down")
      RentReviewPage.rentReview()
      RentReviewPage.hasIncludeRentReview("yes")
      RentReviewPage.enterRentReviewYears("12")
      RentReviewPage.canRentGoDown("no")
      continueButtonClick()

      Then("The user select no for money from the landlord")
      DidYouGetMoneyFromLandlordPage.didYouGetMoneyFromLandlord()
      DidYouGetMoneyFromLandlordPage.noRadio()
      continueButtonClick()

      Then("The user select yes for money in advance to landlord")
      DidYouPayAnyMoneyToLandlordPage.didYouPayAnyMoneyToLandlord()
      DidYouPayAnyMoneyToLandlordPage.yesRadio()

      Then("The user selects yes they got money from the previous landlord or tenant to taking on the lease")
      DidYouGetMoneyFromLandlordPage.didYouGetMoneyFromLandlord()
      DidYouGetMoneyFromLandlordPage.yesRadio()
      continueButtonClick()
    }

    Scenario(
      "The user renewed their agreement, agreement type: Lease or tenancy agreement, rent agreed in advance: Yes"
    ) {
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
      clickLink("You renewed your agreement")
      TellUsAboutYourRenewedAgreementPage.tellUsAboutYourRenewedAgreement()
      continueButtonClick()

      Then("The user selects renewed agreement type of lease renewal")
      WhatTypeOfLeaseRenewal.typeOfLeaseRenewal()
      WhatTypeOfLeaseRenewal.renewedAgreementRadio()
      continueButtonClick()

      /* relationship With The Landlord = 'family Member'*/
      Then("The user inputs the landlords name and selects family member as type")
      Landlord.landlord()
      Landlord.landlordNameInput(landlordName = "Bob")
      Landlord.noRadio()
      continueButtonClick()

      Then("The user selects lease or tenancy agreement as there agreement type")
      WhatTypeOfAgreement.TypeOfAgreement()
      WhatTypeOfAgreement.leaseOrTenancyRadio()
      continueButtonClick()

      Then("The user entered agreement start and end date")
      Agreement.agreement()
      Agreement.enterAgreementStartDate("02", "01", "2015")
      Agreement.agreementOpenEndedRadio("No")
      Agreement.enterOpenEndedAgreementDate("11", "11", "2027")
      Agreement.agreementHaveABreakClauseRadio("No")
      continueButtonClick()

      /*'What is your rent based on?' = 'Total Occupancy Cost leases (TOCs)'*/
      Then("The user selects other and input reason on 'What is your rent based on?' page and submit")
      WhatIsRentBasedOn.whatIsRentBasedOn()
      WhatIsRentBasedOn.selectRentBaseOn("Total Occupancy Cost leases (TOCs)")
      continueButtonClick()

      /*User selects 'Yes' on rent agreed in advance*/
      And("The user selects 'Yes' on rent agreed in advance")
      HaveYouAgreedInAdvanceRentChanges.haveYouAgreedInAdvanceRentChanges()
      HaveYouAgreedInAdvanceRentChanges.yesRadio()
      continueButtonClick()

      When("The user provides the start and end date for the first rent period")
      ProvideDetailsOfFirstSecondRentPeriodPage.provideDetailsOfEachRentPeriod()
      ProvideDetailsOfFirstSecondRentPeriodPage.firstRentPeriodStartDate("02", "01", "2011")
      ProvideDetailsOfFirstSecondRentPeriodPage.firstRentPeriodEndDate("02", "03", "2022")

      Then("The user selects 'Yes' radio button and enter the rent amount")
      ProvideDetailsOfFirstSecondRentPeriodPage.firstRentPeriodRadioYes()
      ProvideDetailsOfFirstSecondRentPeriodPage.firstRentPeriodRent("2000.00")

      When("The user enters the start, end date and rent amount for the second rent period")
      ProvideDetailsOfFirstSecondRentPeriodPage.provideDetailsOfEachRentPeriod()
      ProvideDetailsOfFirstSecondRentPeriodPage.secondRentPeriodStartDate("02", "10", "2012")
      ProvideDetailsOfFirstSecondRentPeriodPage.secondRentPeriodEndDate("02", "12", "2023")
      ProvideDetailsOfFirstSecondRentPeriodPage.SecondRentPeriodRent("9999999.99")
      continueButtonClick()

      When("The user check rent period details on rent periods page")
      RentPeriods.rentPeriods()
      RentPeriods.verifyFirstPeriodStartDate("2 January 2011")
      RentPeriods.verifyFirstPeriodEndDate("2 March 2022")
      RentPeriods.verifyFirstPeriodDoYouPay("Yes")
      RentPeriods.verifyFirstPeriodRentValue("£2,000")
      RentPeriods.verifySecondPeriodStartDate("2 October 2012")
      RentPeriods.verifySecondPeriodEndDate("2 December 2023")
      RentPeriods.verifySecondPeriodRentValue("£9,999,999.99")

      Then("The user selects 'No' for adding rent period")
      RentPeriods.addAnotherPeriod("No")
      continueButtonClick()

      When("The user enters yes to agree rent with the landlord")
      DidYouAgreeRentWithLandlordPage.didYouAgreeRentWithLandlord()
      DidYouAgreeRentWithLandlordPage.didYouAgreeRentWithLandlordRadio("Yes")
      continueButtonClick()

      Then("The user enters their rent date")
      RentDatesPage.rentDatesPage()
      RentDatesPage.agreeDateInput("19", "01", "2020")
      continueButtonClick()

      Then("The user selects what their rent includes")
      WhatYourRentIncludesPage.whatYourRentIncludes()
      WhatYourRentIncludesPage.livingAccommodationRadio("Yes")
      WhatYourRentIncludesPage.bedroomNumbers("5")
      WhatYourRentIncludesPage.rentPartAddressRadio("No")
      WhatYourRentIncludesPage.rentEmptyShellRadio("No")
      continueButtonClick()

      Then("The user selects no to having parking spaces or garages")
      DoesYourRentIncludeParkingPage.doesYourRentIncludeParking()
      DoesYourRentIncludeParkingPage.noRadio()
      continueButtonClick()

      Then("The user select no to pay extra parking spaces not included in rent")
      DoYouPayExtraForParkingSpaces.doYouPayExtraForParkingSpaces()
      DoYouPayExtraForParkingSpaces.selectPayExtraRadio("no")
      continueButtonClick()

      Then("The user selects you to who pays for internal, external and building insurance repairs")
      RepairsAndInsurancePage.repairsAndInsurance()
      RepairsAndInsurancePage.whoPaysForInternalRepairsRadio("You and the landlord")
      RepairsAndInsurancePage.whoPaysForExternalRepairsRadio("You and the landlord")
      RepairsAndInsurancePage.WhoPaysForBuildingInsuranceRepairs("You and the landlord")
      continueButtonClick()

      Then("The user select yes for rent review and no for rent go down")
      RentReviewPage.rentReview()
      RentReviewPage.hasIncludeRentReview("yes")
      RentReviewPage.enterRentReviewMonths("12")
      RentReviewPage.canRentGoDown("no")
      continueButtonClick()

      Then("The user selects yes they got money from the previous landlord or tenant to taking on the lease")
      DidYouGetMoneyFromLandlordPage.didYouGetMoneyFromLandlord()
      DidYouGetMoneyFromLandlordPage.yesRadio()
      continueButtonClick()
    }

    Scenario(
      "The user renewed their agreement, agreement type: Lease or tenancy agreement, rent agreed in advance: No " +
        "Rent free period: Yes"
    ) {
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
      clickLink("You renewed your agreement")
      TellUsAboutYourRenewedAgreementPage.tellUsAboutYourRenewedAgreement()
      continueButtonClick()

      Then("The user selects renewed agreement type of lease renewal")
      WhatTypeOfLeaseRenewal.typeOfLeaseRenewal()
      WhatTypeOfLeaseRenewal.renewedAgreementRadio()
      continueButtonClick()

      /* relationship With The Landlord = 'family Member'*/
      Then("The user inputs the landlords name and selects family member as type")
      Landlord.landlord()
      Landlord.landlordNameInput(landlordName = "Bob")
      Landlord.noRadio()
      continueButtonClick()

      Then("The user selects lease or tenancy agreement as there agreement type")
      WhatTypeOfAgreement.TypeOfAgreement()
      WhatTypeOfAgreement.leaseOrTenancyRadio()
      continueButtonClick()

      Then("The user entered agreement start and end date")
      Agreement.agreement()
      Agreement.enterAgreementStartDate("02", "01", "2015")
      Agreement.agreementOpenEndedRadio("No")
      Agreement.enterOpenEndedAgreementDate("11", "11", "2027")
      Agreement.agreementHaveABreakClauseRadio("No")
      continueButtonClick()

      /*'What is your rent based on?' = 'Open market value'*/
      Then("The user selects other and input reason on 'What is your rent based on?' page and submit")
      WhatIsRentBasedOn.whatIsRentBasedOn()
      WhatIsRentBasedOn.selectRentBaseOn("Open market value")
      continueButtonClick()

      /*User selects 'Yes' on rent agreed in advance*/
      And("The user selects 'Yes' on rent agreed in advance")
      HaveYouAgreedInAdvanceRentChanges.haveYouAgreedInAdvanceRentChanges()
      HaveYouAgreedInAdvanceRentChanges.noRadio()
      continueButtonClick()

      Then("The user enter how much is total annual rent")
      HowMuchIsTotalAnnualRent.howMuchIsTotalAnnualRent()
      HowMuchIsTotalAnnualRent.inputTotalAnnualRent("999900")
      continueButtonClick()

      Then("The user selects no with agreeing the rent with their landlord or their agent")
      DidYouAgreeRentWithLandlordPage.didYouAgreeRentWithLandlord()
      DidYouAgreeRentWithLandlordPage.didYouAgreeRentWithLandlordRadio("No")
      continueButtonClick()

      Then("The ratepayer selects the 'Yes' on the 'Did the court also set an interim rent?' page")
      DidTheCourtSetTheInterimRent.rentInterim()
      DidTheCourtSetTheInterimRent.yesRadio()
      continueButtonClick()

      And("The ratepayer enter the details of Interim rent set by court")
      InterimRentSetByTheCourtPage.interimRentSetByTheCourt()
      InterimRentSetByTheCourtPage.interimHowMuchInput("1111111.11")
      InterimRentSetByTheCourtPage.interimRentSetByTheCourtDateInput("3", "2019")
      continueButtonClick()

      Then("The user selects 'No' to having a rent free period")
      DoYouHaveRentFreePeriod.doYouHaveRentFreePeriod()
      DoYouHaveRentFreePeriod.selectRentFreePeriodRadio("No")
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

      Then("The user selects yes to having parking spaces or garages")
      DoesYourRentIncludeParkingPage.doesYourRentIncludeParking()
      DoesYourRentIncludeParkingPage.yesRadio()
      continueButtonClick()

      Then("The user enters uncovered, covered spaces and garages")
      HowManyParkingSpacesOrGaragesIncludedInRentPage.howManyParkingSpacesOrGaragesIncludedInRent()
      HowManyParkingSpacesOrGaragesIncludedInRentPage.enterUncoveredSpaces("2")
      HowManyParkingSpacesOrGaragesIncludedInRentPage.enterCoveredSpaces("10")
      HowManyParkingSpacesOrGaragesIncludedInRentPage.enterGarages("5")
      continueButtonClick()

      Then("The user select no to pay extra parking spaces not included in rent")
      DoYouPayExtraForParkingSpaces.doYouPayExtraForParkingSpaces()
      DoYouPayExtraForParkingSpaces.selectPayExtraRadio("no")
      continueButtonClick()

      Then("The user selects you to who pays for internal, external and building insurance repairs")
      RepairsAndInsurancePage.repairsAndInsurance()
      RepairsAndInsurancePage.whoPaysForInternalRepairsRadio("You")
      RepairsAndInsurancePage.whoPaysForExternalRepairsRadio("You")
      RepairsAndInsurancePage.WhoPaysForBuildingInsuranceRepairs("You")
      continueButtonClick()

      Then("The user select yes for rent review and no for rent go down")
      RentReviewPage.rentReview()
      RentReviewPage.hasIncludeRentReview("yes")
      RentReviewPage.enterRentReviewYears("2")
      RentReviewPage.enterRentReviewMonths("6")
      RentReviewPage.canRentGoDown("no")
      continueButtonClick()

      Then("The user selects yes they got money from the previous landlord or tenant to taking on the lease")
      DidYouGetMoneyFromLandlordPage.didYouGetMoneyFromLandlord()
      DidYouGetMoneyFromLandlordPage.yesRadio()
      continueButtonClick()
    }

    Scenario(
      "The user renewed their agreement, agreement type: Licence or other type of written agreement, agreement type: Verbal"
    ) {
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
      clickLink("You renewed your agreement")
      TellUsAboutYourRenewedAgreementPage.tellUsAboutYourRenewedAgreement()
      continueButtonClick()

      Then("The user selects renewed agreement type of lease renewal")
      WhatTypeOfLeaseRenewal.typeOfLeaseRenewal()
      WhatTypeOfLeaseRenewal.renewedAgreementRadio()
      continueButtonClick()

      /* relationship With The Landlord = 'family Member'*/
      Then("The user inputs the landlords name and selects family member as type")
      Landlord.landlord()
      Landlord.landlordNameInput(landlordName = "Bob")
      Landlord.noRadio()
      continueButtonClick()

      Then("The user selects verbal as there agreement type")
      WhatTypeOfAgreement.TypeOfAgreement()
      WhatTypeOfAgreement.verbalRadio()
      continueButtonClick()

      Then("The user input agreement start date and end date")
      AgreementVerbal.agreementVerbal()
      AgreementVerbal.startDateInput("23", "4", "2025")
      AgreementVerbal.notOpenEndedAgreementRadio()
      AgreementVerbal.endDateInput("23", "4", "2027")
      continueButtonClick()

      Then("The user enter how much is total annual rent")
      HowMuchIsTotalAnnualRent.howMuchIsTotalAnnualRent()
      HowMuchIsTotalAnnualRent.inputTotalAnnualRent("7500")
      continueButtonClick()

      Then("The user selects 'Yes' with agreeing the rent with their landlord or their agent")
      DidYouAgreeRentWithLandlordPage.didYouAgreeRentWithLandlord()
      DidYouAgreeRentWithLandlordPage.didYouAgreeRentWithLandlordRadio("Yes")
      continueButtonClick()

      Then("The user selects 'Yes' to having a rent free period")
      DoYouHaveRentFreePeriod.doYouHaveRentFreePeriod()
      DoYouHaveRentFreePeriod.selectRentFreePeriodRadio("Yes")
      continueButtonClick()

      Then("The user states 10 rent free months with a reason")
      RentFreePeriod.rentFreePeriod()
      RentFreePeriod.enterRentFreePeriodMonths("10")
      RentFreePeriod.enterReasons("Was out the country")
      continueButtonClick()

      Then("The user enters the date they agreed their rent")
      RentDatesAgreeStartPage.rentDatesAgreeStartPage()
      RentDatesAgreeStartPage.agreeDateInput("03", "12", "2023")
      RentDatesAgreeStartPage.startDateInput("19", "12", "2023")
      continueButtonClick()

      Then("The user selects what their rent includes")
      WhatYourRentIncludesPage.whatYourRentIncludes()
      WhatYourRentIncludesPage.livingAccommodationRadio("Yes")
      WhatYourRentIncludesPage.bedroomNumbers("5")
      WhatYourRentIncludesPage.rentPartAddressRadio("No")
      WhatYourRentIncludesPage.rentEmptyShellRadio("No")
      WhatYourRentIncludesPage.rentIncBusinessRatesRadio("No")
      WhatYourRentIncludesPage.rentIncWaterChargesRadio("No")
      WhatYourRentIncludesPage.rentIncServiceRadio("No")
      continueButtonClick()

      Then("The user selects 'No' to having parking spaces or garages")
      DoesYourRentIncludeParkingPage.doesYourRentIncludeParking()
      DoesYourRentIncludeParkingPage.noRadio()
      continueButtonClick()

      Then("The user select no to pay extra parking spaces not included in rent")
      DoYouPayExtraForParkingSpaces.doYouPayExtraForParkingSpaces()
      DoYouPayExtraForParkingSpaces.selectPayExtraRadio("no")
      continueButtonClick()

      Then("The user selects you to who pays for internal, external and building insurance repairs")
      RepairsAndInsurancePage.repairsAndInsurance()
      RepairsAndInsurancePage.whoPaysForInternalRepairsRadio("You")
      RepairsAndInsurancePage.whoPaysForExternalRepairsRadio("You")
      RepairsAndInsurancePage.WhoPaysForBuildingInsuranceRepairs("You")
      continueButtonClick()

      Then("The user select yes for rent review and no for rent go down")
      RentReviewPage.rentReview()
      RentReviewPage.hasIncludeRentReview("yes")
      RentReviewPage.enterRentReviewYears("12")
      RentReviewPage.canRentGoDown("no")
      continueButtonClick()

      Then("The user selects yes they got money from the previous landlord or tenant to taking on the lease")
      DidYouGetMoneyFromLandlordPage.didYouGetMoneyFromLandlord()
      DidYouGetMoneyFromLandlordPage.yesRadio()
      continueButtonClick()
    }
  }
}
