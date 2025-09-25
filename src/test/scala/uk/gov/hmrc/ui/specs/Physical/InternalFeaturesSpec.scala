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

package uk.gov.hmrc.ui.specs.Physical

import uk.gov.hmrc.ui.pages.Dashboard.DashboardHome.dashboard
import uk.gov.hmrc.ui.pages.Physical.{CheckAndConfirmChangesToInternalFeatures, HaveYouChangedExternalFeatures, HaveYouChangedInternalFeatures, HaveYouChangedUseOfSpace, HowManySecurityCamerasInsideProperty, HowMuchOfPropertyHasAirConditioning, HowMuchOfPropertyHasHeating, HowMuchOfPropertyHasSprinklers, InformationAndSupportingDocumentsNeed, SelectYourProperty, TellUsChangedPropertyFeaturesOrUseOfSpace, WhatHappenedToCompressedAirSystems, WhenCompleteChange, WhereAreTheEscalatorsInTheProperty, WhichFloorsOfPropertyHaveGoodsLifts, WhichFloorsOfPropertyHavePassengerLifts, WhichInternalFeatureHaveChanged}
import uk.gov.hmrc.ui.pages.RALD.{WhatDoYouWantToTellUs, WhichPropertyDoYouWantToTellUsAbout}
import uk.gov.hmrc.ui.pages.{SignOutPage, StubPage}
import uk.gov.hmrc.ui.specs.BaseSpec
import uk.gov.hmrc.ui.utils.login.loginOl
import uk.gov.hmrc.ui.utils.mongo.PhysicalDB

class InternalFeaturesSpec extends BaseSpec with StubPage {

  Feature("Testing the Internal features functionalities") {
    Scenario("The user selects and adds changes to all Internal features") {
      PhysicalDB.cleanup()
      Given("Ratepayer logins through one login")
      loginOl()

      When("The ratepayer clicks on 'Tell us about a change' link from dashboard")
      dashboard()
      clickLink("Tell us about a change")

      Then(
        "The ratepayers selects the property and proceed through the changed property feature or use of space journey"
      )
      SelectYourProperty.yourPropertyHeader()
      clickLink("Select property")

      Then("The user selects the changed property features or use of space link")
      WhatDoYouWantToTellUs.whatDoYouWantToTellUs()
      clickLink("You changed property features or use of space")
      TellUsChangedPropertyFeaturesOrUseOfSpace.tellUsChangedPropertyFeatureHeader()
      continueButtonClick()

      InformationAndSupportingDocumentsNeed.InformationAndSupportingDocScreen()
      continueButtonClick()

      Then("The ratepayer adds a date when the change was completed")
      WhenCompleteChange.whenCompleteChangeScreen()
      WhenCompleteChange.dateInput("10", "10", "2022")
      continueButtonClick()

      Then("The ratepayer answers NO to the 'Have you changed use of space' question")
      HaveYouChangedUseOfSpace.changedUseOfSpaceHeader()
      HaveYouChangedUseOfSpace.changedUseOfSpaceRadio("No")
      continueButtonClick()

      Then("The ratepayer answer Yes to 'Have you changed internal features?' question")
      HaveYouChangedInternalFeatures.changedInternalFeatureHeader()
      HaveYouChangedInternalFeatures.changedInternalFeatureRadio("Yes")
      continueButtonClick()

      Then("The ratepayer adds 'Air condition - All of the property has air conditioning' to the property")
      WhichInternalFeatureHaveChanged.whichInternalFeatureHaveChangedHeader()
      WhichInternalFeatureHaveChanged.whichInternalFeatureHaveChangedRadio("Air conditioning")
      continueButtonClick()
      HowMuchOfPropertyHasAirConditioning.howMuchOfPropertyHasAirConditioningLegend()
      HowMuchOfPropertyHasAirConditioning.howMuchAirConditioningRadio("All of the property has air conditioning")
      continueButtonClick()
      CheckAndConfirmChangesToInternalFeatures.checkAndConfirmChangesToInternalFeaturesHeader()
      CheckAndConfirmChangesToInternalFeatures.verifySummaryItem("Air conditioning", "In all of the property")
      CheckAndConfirmChangesToInternalFeatures.tellAnotherInternalFeatureRadio("Yes")
      continueButtonClick()

      Then("The ratepayer adds 'Escalators - There are escalators between all floors' to the property")
      WhichInternalFeatureHaveChanged.whichInternalFeatureHaveChangedHeader()
      WhichInternalFeatureHaveChanged.whichInternalFeatureHaveChangedRadio("Escalators")
      continueButtonClick()
      WhereAreTheEscalatorsInTheProperty.whereAreTheEscalatorsInThePropertyLegend()
      WhereAreTheEscalatorsInTheProperty.whereAreTheEscalatorsInThePropertyRadio(
        "There are escalators between all floors"
      )
      continueButtonClick()
      CheckAndConfirmChangesToInternalFeatures.checkAndConfirmChangesToInternalFeaturesHeader()
      CheckAndConfirmChangesToInternalFeatures.verifySummaryItem("Escalators", "Between all floors")
      CheckAndConfirmChangesToInternalFeatures.tellAnotherInternalFeatureRadio("Yes")
      continueButtonClick()

      Then("The ratepayer adds 'Goods lifts - All floors have goods lifts' to the property")
      WhichInternalFeatureHaveChanged.whichInternalFeatureHaveChangedHeader()
      WhichInternalFeatureHaveChanged.whichInternalFeatureHaveChangedRadio("Goods lifts")
      continueButtonClick()
      WhichFloorsOfPropertyHaveGoodsLifts.whichFloorsOfPropertyHaveGoodsLiftsHeader()
      WhichFloorsOfPropertyHaveGoodsLifts.whichFloorsOfPropertyHaveGoodsLiftsRadio("All floors have goods lifts")
      continueButtonClick()
      CheckAndConfirmChangesToInternalFeatures.checkAndConfirmChangesToInternalFeaturesHeader()
      CheckAndConfirmChangesToInternalFeatures.verifySummaryItem("Goods lifts", "On all floors")
      CheckAndConfirmChangesToInternalFeatures.tellAnotherInternalFeatureRadio("Yes")
      continueButtonClick()

      Then("The ratepayer adds 'Passenger lifts - All floors have Passenger lifts' to the property")
      WhichInternalFeatureHaveChanged.whichInternalFeatureHaveChangedHeader()
      WhichInternalFeatureHaveChanged.whichInternalFeatureHaveChangedRadio("Passenger lifts")
      continueButtonClick()
      WhichFloorsOfPropertyHavePassengerLifts.whichFloorsOfPropertyHavePassengerLiftsHeader()
      WhichFloorsOfPropertyHavePassengerLifts.whichFloorsOfPropertyHavePassengerLiftsRadio(
        "All floors have passenger lifts"
      )
      continueButtonClick()
      CheckAndConfirmChangesToInternalFeatures.checkAndConfirmChangesToInternalFeaturesHeader()
      CheckAndConfirmChangesToInternalFeatures.verifySummaryItem("Passenger lifts", "On all floors")
      CheckAndConfirmChangesToInternalFeatures.tellAnotherInternalFeatureRadio("Yes")
      continueButtonClick()

      Then("The ratepayer adds 'Security cameras - 15' to the property")
      WhichInternalFeatureHaveChanged.whichInternalFeatureHaveChangedHeader()
      WhichInternalFeatureHaveChanged.whichInternalFeatureHaveChangedRadio("Security cameras")
      continueButtonClick()
      HowManySecurityCamerasInsideProperty.howManySecurityCamerasInsidePropertyHeader()
      HowManySecurityCamerasInsideProperty.inputHowManyCameras("15")
      continueButtonClick()
      CheckAndConfirmChangesToInternalFeatures.checkAndConfirmChangesToInternalFeaturesHeader()
      CheckAndConfirmChangesToInternalFeatures.verifySummaryItem("Security cameras", "15")
      CheckAndConfirmChangesToInternalFeatures.tellAnotherInternalFeatureRadio("Yes")
      continueButtonClick()

      Then("The ratepayer adds 'Other internal feature - Compressed air systems - Added")
      WhichInternalFeatureHaveChanged.whichInternalFeatureHaveChangedHeader()
      WhichInternalFeatureHaveChanged.selectOtherFeatures("compressedAir")
      continueButtonClick()
      WhatHappenedToCompressedAirSystems.whatHappenedToCompressedAirSystemsHeader()
      WhatHappenedToCompressedAirSystems.whatHappenedToCompressedAirSystemsRadio("You added compressed air systems")
      continueButtonClick()
      CheckAndConfirmChangesToInternalFeatures.verifySummaryItem("Compressed air systems", "Added")
      CheckAndConfirmChangesToInternalFeatures.tellAnotherInternalFeatureRadio("Yes")
      continueButtonClick()

      Then("The ratepayer adds 'Other internal feature - Heating - In all of the property")
      WhichInternalFeatureHaveChanged.whichInternalFeatureHaveChangedHeader()
      WhichInternalFeatureHaveChanged.selectOtherFeatures("heating")
      continueButtonClick()
      HowMuchOfPropertyHasHeating.howMuchOfPropertyHasHeatingHeader()
      HowMuchOfPropertyHasHeating.howMuchOfPropertyHasHeatingRadio("All of the property has heating")
      continueButtonClick()
      CheckAndConfirmChangesToInternalFeatures.verifySummaryItem("Heating", "In all of the property")
      CheckAndConfirmChangesToInternalFeatures.tellAnotherInternalFeatureRadio("Yes")
      continueButtonClick()

      Then("The ratepayer adds 'Other internal feature - Sprinklers - All of the property has sprinklers")
      WhichInternalFeatureHaveChanged.whichInternalFeatureHaveChangedHeader()
      WhichInternalFeatureHaveChanged.selectOtherFeatures("sprinklers")
      continueButtonClick()
      HowMuchOfPropertyHasSprinklers.howMuchOfPropertyHasSprinklersHeader()
      HowMuchOfPropertyHasSprinklers.howMuchOfPropertyHasSprinklersRadio("All of the property has sprinklers")
      continueButtonClick()
      CheckAndConfirmChangesToInternalFeatures.verifySummaryItem("Sprinklers", "In all of the property")
      CheckAndConfirmChangesToInternalFeatures.tellAnotherInternalFeatureRadio("No")
      continueButtonClick()
      HaveYouChangedExternalFeatures.changedExternalFeatureHeader()
      clickLink("Sign out")
      SignOutPage.signOut()
    }
  }
}
