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

class RentReviewedSpec extends BaseSpec with StubPage {

  Feature("Testing the 'you reviewed your rent' journey") {
    Scenario("The user reviewed their rent") {
      RaldDB.cleanup()
      Given("Ratepayer logins through one login")
      loginOl()

      When("The ratepayer clicks on 'Tell us about a change' link from dashboard")
      dashboard()
      clickLink("Tell us about a change")

      Then("The ratepayers selects the property and proceed through the new agreement journey")
      YourProperty.yourProperty()
      clickLink("Select property")

      Then("The user selects renewed review your rent link to review their rent")
      WhatDoYouWantToTellUs.whatDoYouWantToTellUs()
      clickLink("You reviewed your rent")
      TellUsAboutYourRent.tellUsAboutYourRent()
      continueButtonClick()

      /* Has relationship With The Landlord*/
      Then("The user inputs the landlords name and selects family member as type")
      Landlord.landlord()
      Landlord.landlordNameInput(landlordName = "Bob")
      Landlord.yesRadio()
      Landlord.supplyRelationship("I am the tenant")
      continueButtonClick()

      /*'What is your rent based on?' = 'Indexation'*/
      Then("The user selects other and input reason on 'What is your rent based on?' page and submit")
      WhatIsRentBasedOn.whatIsRentBasedOn()
      WhatIsRentBasedOn.selectRentBaseOn("Indexation")
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

      Then("The user selects 'Yes' to having parking spaces or garages")
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
      RepairsAndInsurancePage.whoPaysForInternalRepairsRadio("The landlord")
      RepairsAndInsurancePage.whoPaysForExternalRepairsRadio("The landlord")
      RepairsAndInsurancePage.WhoPaysForBuildingInsuranceRepairs("The landlord")
      continueButtonClick()
    }

    Scenario("The user reviewed their rent, rent based on: Total Occupancy Cost leases (TOCs)") {
      RaldDB.cleanup()
      Given("Ratepayer logins through one login")
      loginOl()

      When("The ratepayer clicks on 'Tell us about a change' link from dashboard")
      dashboard()
      clickLink("Tell us about a change")

      Then("The ratepayers selects the property and proceed through the new agreement journey")
      YourProperty.yourProperty()
      clickLink("Select property")

      Then("The user selects renewed review your rent link to review their rent")
      WhatDoYouWantToTellUs.whatDoYouWantToTellUs()
      clickLink("You reviewed your rent")
      TellUsAboutYourRent.tellUsAboutYourRent()
      continueButtonClick()

      /* Has relationship With The Landlord*/
      Then("The user inputs the landlords name and selects family member as type")
      Landlord.landlord()
      Landlord.landlordNameInput(landlordName = "Bob")
      Landlord.yesRadio()
      Landlord.supplyRelationship("I am the tenant")
      continueButtonClick()

      /*'What is your rent based on?' = 'Total Occupancy Cost leases (TOCs)'*/
      Then("The user selects other and input reason on 'What is your rent based on?' page and submit")
      WhatIsRentBasedOn.whatIsRentBasedOn()
      WhatIsRentBasedOn.selectRentBaseOn("Total Occupancy Cost leases (TOCs)")
      continueButtonClick()

      Then("The user selects what their rent includes")
      WhatYourRentIncludesPage.whatYourRentIncludes()
      WhatYourRentIncludesPage.livingAccommodationRadio("No")
      WhatYourRentIncludesPage.rentPartAddressRadio("Yes")
      WhatYourRentIncludesPage.rentEmptyShellRadio("Yes")
      continueButtonClick()

      Then("The user selects 'No' to having parking spaces or garages")
      DoesYourRentIncludeParkingPage.doesYourRentIncludeParking()
      DoesYourRentIncludeParkingPage.noRadio()
      continueButtonClick()

      Then("The user select yes to pay extra parking spaces not included in rent")
      DoYouPayExtraForParkingSpaces.doYouPayExtraForParkingSpaces()
      DoYouPayExtraForParkingSpaces.selectPayExtraRadio("yes")
      continueButtonClick()

      Then(
        "The user enters 3 for uncovered parking spaces, 4000 for how much extra they pay with an agreement date of 19-01-2020"
      )
      ParkingSpacesOrGaragesNotIncludedInYourRentPage.enterUncoveredSpaces("3")
      ParkingSpacesOrGaragesNotIncludedInYourRentPage.totalCost("4000")
      ParkingSpacesOrGaragesNotIncludedInYourRentPage.agreementDateInput(day = "19", month = "01", year = "1997")
      continueButtonClick()

      Then("The user selects you to who pays for internal, external and building insurance repairs")
      RepairsAndInsurancePage.repairsAndInsurance()
      RepairsAndInsurancePage.whoPaysForInternalRepairsRadio("The landlord")
      RepairsAndInsurancePage.whoPaysForExternalRepairsRadio("The landlord")
      RepairsAndInsurancePage.WhoPaysForBuildingInsuranceRepairs("The landlord")
      continueButtonClick()
    }
  }
}
