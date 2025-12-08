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

import uk.gov.hmrc.ui.pages.RALD.{AddingAdditionalRentPeriodScenario, Agreement, CheckYourAnswersRald, HaveYouAgreedInAdvanceRentChanges, Landlord, ProvideDetailsOfFirstRentPeriodPage, ProvideDetailsOfSecondRentPeriodPage, RentPeriods, RentReviewPage, WhatIsRentBasedOn, WhatTypeOfAgreement}
import uk.gov.hmrc.ui.pages.SignOutPage.continueButtonClick
import uk.gov.hmrc.ui.specs.BaseSpec
import uk.gov.hmrc.ui.utils.RALD.RenewedAgreement

class CYARenewedAgreementSpec extends BaseSpec {

  Feature("New agreement : Change details on Check Your Answers page") {
    Scenario("New agreement : Verify changed details from 'Check Your Answers' page") {

      RenewedAgreement.RenewedAgreement()

      CheckYourAnswersRald.clickChangeLink("landlord-full-name")
      Landlord.landlord()
      Landlord.landlordNameInput("Periwinkle")
      continueButtonClick()
      CheckYourAnswersRald.verifySummaryRow("Landlord's full name", "Periwinkle")

//      // Check changing relationship with landlord
//      CheckYourAnswersRald.clickChangeLink("landlord-relationship")
//      Landlord.yesRadio()
//      Landlord.supplyRelationship("Tinker family member")
//      continueButtonClick()
//      CheckYourAnswersRald.verifySummaryRow(
//        "Do you have a relationship with the landlord other than as a tenant?",
//        "Yes"
//      )
//      CheckYourAnswersRald.verifySummaryRow(
//        "Relationship with the landlord",
//        "Tinker family member"
//      )
//
//      /** ** Agreement details ***
//        */
//      // Check changing agreement type
//      CheckYourAnswersRald.clickChangeLink("what-type-of-agreement")
//      WhatTypeOfAgreement.leaseOrTenancyRadio()
//      continueButtonClick()
//      CheckYourAnswersRald.verifySummaryRow("What type of agreement do you have?", "Lease or tenancy agreement")
//
//      // Check changing agreement start date
//      CheckYourAnswersRald.clickChangeLink("agreement-start-date")
//      Agreement.enterAgreementStartDate("15", "06", "2025")
//      continueButtonClick()
//      CheckYourAnswersRald.verifySummaryRow("Agreement start date", "15 June 2025")
//
//      // Check changing open-ended agreement
//      CheckYourAnswersRald.clickChangeLink("is-open-ended")
//      Agreement.agreementOpenEndedRadio("Yes")
//      continueButtonClick()
//      CheckYourAnswersRald.verifySummaryRow(
//        "Is your agreement open-ended?",
//        "Yes, it is open-ended"
//      )
//
//      // Check changing break clause details
//      CheckYourAnswersRald.clickChangeLink("break-clause")
//      Agreement.agreementHaveABreakClauseRadio("Yes")
//      Agreement.agreementBreakClauseReason("Periwinkle triggered the break clause")
//      continueButtonClick()
//      CheckYourAnswersRald.verifySummaryRow("Does your agreement have a break clause?", "Yes")
//      CheckYourAnswersRald.verifySummaryRow(
//        "Break clause details",
//        "Periwinkle triggered the break clause"
//      )
//
//      // Rent review details
//      CheckYourAnswersRald.clickChangeLink("has-include-rent-review")
//      RentReviewPage.hasIncludeRentReview("No")
//      RentReviewPage.canRentGoDown("Yes")
//      continueButtonClick()
//      CheckYourAnswersRald.verifySummaryRow("Does your agreement include a rent review?", "No")
//      CheckYourAnswersRald.verifySummaryRow("Can the rent go down when it is reviewed?", "Yes")

//      // Rent details
//      CheckYourAnswersRald.clickChangeLink("what-is-your-rent-based-on")
//      WhatIsRentBasedOn.selectRentBaseOn("A percentage of open market value")
//      continueButtonClick()
//      CheckYourAnswersRald.verifySummaryRow("What is your rent based on?", "A percentage of open market value")
//
//      // First rent period
//      CheckYourAnswersRald.clickChangeLink("provide-details-of-first-period-payable")
//      ProvideDetailsOfFirstRentPeriodPage.rentPayablePeriodRadioYes()
//      ProvideDetailsOfFirstRentPeriodPage.rentPeriodAmount("2200")
//      continueButtonClick()
//      CheckYourAnswersRald.verifySummaryRow("Do you pay rent in this period?", "Yes")
//      CheckYourAnswersRald.verifySummaryRow("Rent for this period (excluding VAT)", "£2,200")
//
//      CheckYourAnswersRald.clickChangeLink("provide-details-of-first-period-start")
//      ProvideDetailsOfFirstRentPeriodPage.startDate("2012-01-02")
//      continueButtonClick()
//      CheckYourAnswersRald.verifySummaryRow("Start date", "2 January 2012")

//      CheckYourAnswersRald.clickChangeLink("provide-details-of-first-period-end")

      // second rent period
      CheckYourAnswersRald.clickChangeLink("rent-period-1-end")
      ProvideDetailsOfSecondRentPeriodPage.secondRentPeriodEndDate("02", "12", "2333")
      continueButtonClick()

      RentPeriods.rentPeriods()

      RentPeriods.addAnotherPeriod("Yes")
      continueButtonClick()

      AddingAdditionalRentPeriodScenario.addingRentPeriod("31", "1", "2334", "1000.45", 3, "No")
      CheckYourAnswersRald.verifySummaryRow("Start date", "2 January 2012")

    }
  }

}
