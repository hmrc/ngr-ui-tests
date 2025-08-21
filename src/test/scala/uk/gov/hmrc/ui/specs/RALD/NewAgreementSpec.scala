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
      WhichPropertyDoYouWantToTellUsAbout.whichPropertyDoYouWantToTellUsAbout()
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
      Landlord.relationshipWithTheLandlord("Landlord and tenant relationship only")
      continueButtonClick()

      /* Agreement type = 'Lease or tenancy agreement'*/
      Then("The user selects lease Or Tenancy as their agreement type")
      WhatTypeOfAgreement.TypeOfAgreement()
      WhatTypeOfAgreement.leaseOrTenancyRadio()
      continueButtonClick()

      Then("The user enters agreement start date, not open ended, and 'Yes' for break clause")
      Agreement.agreement()
      Agreement.enterAgreementStartDate("02", "01", "2005")
      Agreement.agreementOpenEndedRadio("No")
      Agreement.enterOpenEndedAgreementDate("02", "01", "2030")
      Thread.sleep(1000)
      Agreement.agreementHaveABreakClauseRadio("Yes")
      Thread.sleep(1000)
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
      click(continueButton)
    }

    Scenario("New agreement, agreement type: Licence or other type of written agreement, agreed in advance: 'Yes'") {

      Given("Ratepayer logins through one login")
      loginOl()

      When("The ratepayer clicks on 'Tell us about a change' link from dashboard")
      dashboard()
      clickLink("Tell us about a change")

      Then("The ratepayers selects the property and proceed through the new agreement journey")
      WhichPropertyDoYouWantToTellUsAbout.whichPropertyDoYouWantToTellUsAbout()
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
      Landlord.relationshipWithTheLandlord("Other relationship")
      Landlord.otherRelationshipInput("Complicated")
      continueButtonClick()

      /* Agreement type ='Licence or other type of written agreement' */
      Then("The user selects lease Or Tenancy as their agreement type")
      WhatTypeOfAgreement.TypeOfAgreement()
      WhatTypeOfAgreement.writtenRadio()
      continueButtonClick()

      Then("The user enters agreement start date, not open ended, and 'Yes' for break clause")
      Agreement.agreement()
      Agreement.enterAgreementStartDate("02", "01", "2005")
      Agreement.agreementOpenEndedRadio("Yes")
      Agreement.agreementHaveABreakClauseRadio("No")
      continueButtonClick()

      /*'What is your rent based on?' = 'Open market value'*/
      Then("The user selects other and input reason on 'What is your rent based on?' page and submit")
      WhatIsRentBasedOn.whatIsRentBasedOn()
      WhatIsRentBasedOn.selectRentBaseOn("Open market value")
      WhatIsRentBasedOn.otherRentBasedOnDescription("VOA budget")
      continueButtonClick()

      /*User selects 'Yes' on rent agreed in advance*/
      And("The user selects 'No' on rent agreed in advance")
      HaveYouAgreedInAdvanceRentChanges.haveYouAgreedInAdvanceRentChanges()
      HaveYouAgreedInAdvanceRentChanges.yesRadio()
      click(continueButton)
    }

    Scenario("New agreement, agreement type: Verbal") {

      Given("Ratepayer logins through one login")
      loginOl()

      When("The ratepayer clicks on 'Tell us about a change' link from dashboard")
      dashboard()
      clickLink("Tell us about a change")

      Then("The ratepayers selects the property and proceed through the new agreement journey")
      WhichPropertyDoYouWantToTellUsAbout.whichPropertyDoYouWantToTellUsAbout()
      clickLink("Select property")

      Then("The user selects new agreement link to tell about their new agreement")
      WhatDoYouWantToTellUs.whatDoYouWantToTellUs()
      clickLink("You have a new agreement")
      TellUsAboutYourNewAgreementPage.tellUsAboutYourNewAgreement()
      click(continueButton)

      Then("The user inputs the landlords name and selects family member as type")
      Landlord.landlord()
      Landlord.landlordNameInput(landlordName = "Bob")
      Landlord.relationshipWithTheLandlord("business partner or shared director")
      click(continueButton)

      Then("The user selects verbal agreement as there agreement type")
      WhatTypeOfAgreement.TypeOfAgreement()
      WhatTypeOfAgreement.verbalRadio()
      click(continueButton)

      Then("The user input agreement start date and end date")
      AgreementVerbal.agreementVerbal()
      AgreementVerbal.startDateInput("23", "4", "2025")
      AgreementVerbal.selectOpenEndedRadio("No")
      AgreementVerbal.endDateInput("23", "4", "2027")
      click(continueButton)

      Then("The user enter how much is total annual rent")
      HowMuchIsTotalAnnualRent.howMuchIsTotalAnnualRent()
      HowMuchIsTotalAnnualRent.inputTotalAnnualRent("7500")
      click(continueButton)
    }
  }
}
