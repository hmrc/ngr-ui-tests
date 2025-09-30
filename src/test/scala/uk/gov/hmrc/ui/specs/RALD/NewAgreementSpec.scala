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

class NewAgreementSpec extends BaseSpec with StubPage {
  Feature("Testing the new agreement functionality") {
    Scenario("New agreement, agreement type: Lease or tenancy agreement, agreed in advance: 'No'") {

      Given("Ratepayer logins through one login")
      loginOl()

      When("The ratepayer clicks on 'Tell us about a change' link from dashboard")
      dashboard()
      clickLink("Tell us about a change")

      Then("The ratepayers selects the property and proceed through the new agreement journey")
      YourProperty.yourProperty()
      clickLink("Select property")

      Then("The user selects new agreement link to tell about their new agreement")
      WhatDoYouWantToTellUs.whatDoYouWantToTellUs()
      clickLink("You have a new agreement")
      TellUsAboutYourNewAgreementPage.tellUsAboutYourNewAgreement()
      continueButtonClick()

      /* relationship With The Landlord = 'Landlord and tenant relationship only'*/
      Then("The user inputs the landlords name and selects family member as type")
      Landlord.landlord()
      Landlord.landlordNameInput(landlordName = "Tinker Bell")
      Landlord.landLordAndTenantRadio()
      continueButtonClick()

      /* Agreement type = 'Lease or tenancy agreement'*/
      Then("The user selects lease Or Tenancy as their agreement type")
      WhatTypeOfAgreement.TypeOfAgreement()
      WhatTypeOfAgreement.leaseOrTenancyRadio()
      continueButtonClick()

      /* Open ended agreement = 'No',  Agreement have a break clause = 'Yes' */
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

      /*'What is your rent based on?' = 'Other'*/
      Then("The user selects other and input reason on 'What is your rent based on?' page and submit")
      WhatIsRentBasedOn.whatIsRentBasedOn()
      WhatIsRentBasedOn.selectRentBaseOn("Other")
      WhatIsRentBasedOn.otherRentBasedOnDescription("VOA budget")
      continueButtonClick()

      /*User selects 'No' on rent agreed in advance*/
      And("The user selects 'No' on rent agreed in advance")
      HaveYouAgreedInAdvanceRentChanges.haveYouAgreedInAdvanceRentChanges()
      HaveYouAgreedInAdvanceRentChanges.noRadio()
      continueButtonClick()

      Then("The user enter how much is total annual rent")
      HowMuchIsTotalAnnualRent.howMuchIsTotalAnnualRent()
      HowMuchIsTotalAnnualRent.inputTotalAnnualRent("7000")
      continueButtonClick()

      /*'By selecting Yes the user misses page Rent-free period'*/
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
      DoesYourRentIncludeParkingPage.noRadio()
      continueButtonClick()

      Then("The user select yes to pay extra parking spaces not included in rent")
      DoYouPayExtraForParkingSpaces.doYouPayExtraForParkingSpaces()
      DoYouPayExtraForParkingSpaces.selectPayExtraRadio("yes")
      continueButtonClick()
    }

    Scenario("New agreement, agreement type: Licence or other type of written agreement, agreed in advance: 'Yes'") {

      Given("Ratepayer logins through one login")
      loginOl()

      When("The ratepayer clicks on 'Tell us about a change' link from dashboard")
      dashboard()
      clickLink("Tell us about a change")

      Then("The ratepayers selects the property and proceed through the new agreement journey")
      YourProperty.yourProperty()
      clickLink("Select property")

      Then("The user selects new agreement link to tell about their new agreement")
      WhatDoYouWantToTellUs.whatDoYouWantToTellUs()
      clickLink("You have a new agreement")
      TellUsAboutYourNewAgreementPage.tellUsAboutYourNewAgreement()
      continueButtonClick()

      /* relationship with landlord = 'Other relationship'*/
      Then("The user inputs the landlords name and selects family member as type")
      Landlord.landlord()
      Landlord.landlordNameInput(landlordName = "Tinker Bell")
      Landlord.otherRelationshipRadio()
      Landlord.otherRelationshipInput("Complicated")
      continueButtonClick()

      /* Agreement type ='Licence or other type of written agreement' */
      Then("The user selects licence or other type of written as their agreement type")
      WhatTypeOfAgreement.TypeOfAgreement()
      WhatTypeOfAgreement.writtenRadio()
      continueButtonClick()

      /* Open ended agreement = 'Yes',  Agreement have a break clause = 'No' */
      Then("The user enters agreement start date, open ended, and 'No' for break clause")
      Agreement.agreement()
      Agreement.enterAgreementStartDate("02", "01", "2005")
      Agreement.agreementOpenEndedRadio("Yes")
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
      HaveYouAgreedInAdvanceRentChanges.yesRadio()
      continueButtonClick()

      When("The user provides the start and end date for the first rent period")
      ProvideDetailsOfFirstSecondRentPeriodPage.provideDetailsOfEachRentPeriod()
      ProvideDetailsOfFirstSecondRentPeriodPage.firstRentPeriodStartDate("02", "01", "2011")
      ProvideDetailsOfFirstSecondRentPeriodPage.firstRentPeriodEndDate("02", "03", "2022")

      Then("The user selects 'Yes' radio button and enter the rent amount")
      ProvideDetailsOfFirstSecondRentPeriodPage.firstRentPeriodRadioYes()
      ProvideDetailsOfFirstSecondRentPeriodPage.firstRentPeriodRent("2000.90365")

      When("The user enters the start, end date and rent amount for the second rent period")
      ProvideDetailsOfFirstSecondRentPeriodPage.provideDetailsOfEachRentPeriod()
      ProvideDetailsOfFirstSecondRentPeriodPage.secondRentPeriodStartDate("02", "10", "2012")
      ProvideDetailsOfFirstSecondRentPeriodPage.secondRentPeriodEndDate("02", "12", "2023")
      ProvideDetailsOfFirstSecondRentPeriodPage.SecondRentPeriodRent("9999999.99")
      continueButtonClick()

      When("The user check rent period details on rent periods page")
      RentPeriods.rentPeriods()
      /*These dates should be similar to the dates entered in the previous steps(first and second rent period) */
      RentPeriods.verifyFirstPeriodStartDate("2 January 2011")
      RentPeriods.verifyFirstPeriodEndDate("2 March 2022")
      RentPeriods.verifyFirstPeriodDoYouPay("Yes")
      RentPeriods.verifyFirstPeriodRentValue("£2,000.90")
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
    }

    Scenario("New agreement, agreement type: Verbal") {

      Given("Ratepayer logins through one login")
      loginOl()

      When("The ratepayer clicks on 'Tell us about a change' link from dashboard")
      dashboard()
      clickLink("Tell us about a change")

      Then("The ratepayers selects the property and proceed through the new agreement journey")
      YourProperty.yourProperty()
      clickLink("Select property")

      Then("The user selects new agreement link to tell about their new agreement")
      WhatDoYouWantToTellUs.whatDoYouWantToTellUs()
      clickLink("You have a new agreement")
      TellUsAboutYourNewAgreementPage.tellUsAboutYourNewAgreement()
      continueButtonClick()

      Then("The user inputs the landlords name and selects family member as type")
      Landlord.landlord()
      Landlord.landlordNameInput(landlordName = "Bob")
      Landlord.businessPartnerOrSharedDirectorRadio()
      continueButtonClick()

      Then("The user selects verbal agreement as there agreement type")
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

      /*'By selecting No the user misses page Rent-free period'*/
      Then("The user enters 'No' to having a rent period")
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
    }
  }
}
