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

package uk.gov.hmrc.ui.utils.RALD

import uk.gov.hmrc.ui.pages.BasePage
import uk.gov.hmrc.ui.pages.Dashboard.DashboardHome.dashboard
import uk.gov.hmrc.ui.pages.RALD._
import uk.gov.hmrc.ui.pages.SignOutPage.clickLink
import uk.gov.hmrc.ui.utils.login.loginOl
import uk.gov.hmrc.ui.utils.mongo.RaldDB

object RenewedAgreement extends BasePage {

  def RenewedAgreement(): Unit = {
    RaldDB.cleanup()
    loginOl()

    dashboard()
    clickLink("Tell us about a change")

    YourProperty.yourProperty()
    clickLink("Select property")

    WhatDoYouWantToTellUs.whatDoYouWantToTellUs()
    clickLink("You renewed your agreement")
    TellUsAboutYourRenewedAgreementPage.tellUsAboutYourRenewedAgreement()
    continueButtonClick()

    WhatTypeOfLeaseRenewal.typeOfLeaseRenewal()
    WhatTypeOfLeaseRenewal.renewedAgreementRadio()
    continueButtonClick()

    Landlord.landlord()
    Landlord.landlordNameInput(landlordName = "Tinker")
    Landlord.noRadio()
    continueButtonClick()

    WhatTypeOfAgreement.TypeOfAgreement()
    WhatTypeOfAgreement.writtenRadio()
    continueButtonClick()

    Agreement.agreement()
    Agreement.enterAgreementStartDate("02", "01", "2015")
    Agreement.agreementOpenEndedRadio("No")
    Agreement.enterOpenEndedAgreementDate("11", "11", "2027")
    Agreement.agreementHaveABreakClauseRadio("No")
    continueButtonClick()

    WhatIsRentBasedOn.whatIsRentBasedOn()
    WhatIsRentBasedOn.selectRentBaseOn("Open market value")
    continueButtonClick()

    HaveYouAgreedInAdvanceRentChanges.haveYouAgreedInAdvanceRentChanges()
    HaveYouAgreedInAdvanceRentChanges.yesRadio()
    continueButtonClick()

    ProvideDetailsOfFirstRentPeriodPage.provideDetailsOfFirstRentPeriodHeader()
    ProvideDetailsOfFirstRentPeriodPage.startDate("2011-01-02")
    ProvideDetailsOfFirstRentPeriodPage.endDate("2022-03-02")
    ProvideDetailsOfFirstRentPeriodPage.rentPayablePeriodRadioNo()
    continueButtonClick()

    ProvideDetailsOfSecondRentPeriodPage.secondRentPeriodEndDate("02", "12", "2023")
    ProvideDetailsOfSecondRentPeriodPage.SecondRentPeriodRent("1111.99")
    continueButtonClick()

    RentPeriods.rentPeriods()

    RentPeriods.addAnotherPeriod("Yes")
    continueButtonClick()

    AddingAdditionalRentPeriodScenario.addingRentPeriod("31", "1", "2024", "1000.45", 3, "Yes")
    AddingAdditionalRentPeriodScenario.addingRentPeriod("31", "3", "2024", "1500", 4, "No")

    DidYouAgreeRentWithLandlordPage.didYouAgreeRentWithLandlord()
    DidYouAgreeRentWithLandlordPage.didYouAgreeRentWithLandlordRadio("Yes")
    continueButtonClick()

    RentDatesPage.rentDatesPage()
    RentDatesPage.agreeDateInput("19", "01", "2020")
    continueButtonClick()

    WhatYourRentIncludesPage.whatYourRentIncludes()
    WhatYourRentIncludesPage.livingAccommodationRadio("Yes")
    WhatYourRentIncludesPage.bedroomNumbers("5")
    WhatYourRentIncludesPage.rentPartAddressRadio("No")
    WhatYourRentIncludesPage.rentEmptyShellRadio("No")
    WhatYourRentIncludesPage.rentIncBusinessRatesRadio("No")
    WhatYourRentIncludesPage.rentIncWaterChargesRadio("No")
    WhatYourRentIncludesPage.rentIncServiceRadio("No")
    continueButtonClick()

    DoesYourRentIncludeParkingPage.doesYourRentIncludeParking()
    DoesYourRentIncludeParkingPage.noRadio()
    continueButtonClick()

    DoYouPayExtraForParkingSpaces.doYouPayExtraForParkingSpaces()
    DoYouPayExtraForParkingSpaces.selectPayExtraRadio("no")
    continueButtonClick()

    RepairsAndInsurancePage.repairsAndInsurance()
    RepairsAndInsurancePage.whoPaysForInternalRepairsRadio("You")
    RepairsAndInsurancePage.whoPaysForExternalRepairsRadio("You")
    RepairsAndInsurancePage.WhoPaysForBuildingInsuranceRepairs("You")
    continueButtonClick()

    RentReviewPage.rentReview()
    RentReviewPage.hasIncludeRentReview("yes")
    RentReviewPage.enterRentReviewYears("12")
    RentReviewPage.canRentGoDown("no")
    continueButtonClick()

    DidYouGetMoneyFromLandlordPage.didYouGetMoneyFromLandlord()
    DidYouGetMoneyFromLandlordPage.noRadio()
    continueButtonClick()

    DidYouPayAnyMoneyToLandlordPage.didYouPayAnyMoneyToLandlord()
    DidYouPayAnyMoneyToLandlordPage.yesRadio()
    continueButtonClick()

    MoneyYouPaidInAdvanceToLandlordPage.moneyYouPaidInAdvanceToLandlord()
    MoneyYouPaidInAdvanceToLandlordPage.moneyYouPaidInAdvanceToLandlordAmountInput("500")
    MoneyYouPaidInAdvanceToLandlordPage.moneyYouPaidInAdvanceToLandlordDateInput("12", "11", "2025")
    continueButtonClick()

    HasAnythingElsePage.hasAnythingElseAffectedTheRent()
    HasAnythingElsePage.hasAffected("yes")
    HasAnythingElsePage.reasonDescription("test")
    continueButtonClick()

    CheckYourAnswersRald.checkYourAnswersHeader()
  }
}
