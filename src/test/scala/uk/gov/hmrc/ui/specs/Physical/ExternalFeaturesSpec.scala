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
import uk.gov.hmrc.ui.pages.Physical._
import uk.gov.hmrc.ui.pages.RALD.WhatDoYouWantToTellUs
import uk.gov.hmrc.ui.pages.{SignOutPage, StubPage}
import uk.gov.hmrc.ui.specs.BaseSpec
import uk.gov.hmrc.ui.utils.login.loginOl
import uk.gov.hmrc.ui.utils.mongo.PhysicalDB

class ExternalFeaturesSpec extends BaseSpec with StubPage {

  Feature("Testing the External features functionalities") {
    Scenario("The user selects and adds changes to all External features") {
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

      // 'NO' to use of space changed
      Then("The ratepayer answers NO to the 'Have you changed use of space' question")
      HaveYouChangedUseOfSpace.changedUseOfSpaceHeader()
      HaveYouChangedUseOfSpace.changedUseOfSpaceRadio("No")
      continueButtonClick()

      // 'NO' to internal feature changed
      Then("The ratepayer answer NO to 'Have you changed internal features?' question")
      HaveYouChangedInternalFeatures.changedInternalFeatureHeader()
      HaveYouChangedInternalFeatures.changedInternalFeatureRadio("No")
      continueButtonClick()

      // 'YES' to external feature changed
      Then("The ratepayer answer Yes to 'Have you changed external features?' question")
      HaveYouChangedExternalFeatures.changedExternalFeatureHeader()
      HaveYouChangedExternalFeatures.changedExternalFeatureRadio("Yes")
      continueButtonClick()

      // Selecting external features
      Then("The ratepayer adds 'Loading bays - You added loading bays' to the property")
      WhichExternalFeatureHaveChange.whichInternalFeatureHaveChangedHeader()
      WhichExternalFeatureHaveChange.whichExternalFeatureHaveChangedRadio("Loading bays")
      continueButtonClick()
      WhatHappenedToLoadingBays.whatHappenedToLoadingBaysHeader()
      WhatHappenedToLoadingBays.whatHappenedToLoadingBaysRadio("You added loading bays")
      continueButtonClick()
      CheckAndConfirmChangesToExternalFeatures.checkAndConfirmChangesToExternalFeaturesHeader()
      CheckAndConfirmChangesToExternalFeatures.verifyExternalSummaryItem("Loading bays", "Added")
      CheckAndConfirmChangesToExternalFeatures.tellAnotherExternalFeatureRadio("Yes")
      continueButtonClick()

      Then("The ratepayer adds 'Lock-up garages - You added lock-up garages' to the property")
      WhichExternalFeatureHaveChange.whichInternalFeatureHaveChangedHeader()
      WhichExternalFeatureHaveChange.whichExternalFeatureHaveChangedRadio("Lock-up garages")
      continueButtonClick()
      WhatHappenedToLockUpGarages.whatHappenedToLockUpGaragesHeader()
      WhatHappenedToLockUpGarages.whatHappenedToLockUpGaragesRadio("You added lock-up garages")
      continueButtonClick()
      CheckAndConfirmChangesToExternalFeatures.checkAndConfirmChangesToExternalFeaturesHeader()
      CheckAndConfirmChangesToExternalFeatures.verifyExternalSummaryItem("Lock-up garages", "Added")
      CheckAndConfirmChangesToExternalFeatures.tellAnotherExternalFeatureRadio("Yes")
      continueButtonClick()

      Then("The ratepayer adds 'Outdoor seating - You added outdoor seating' to the property")
      WhichExternalFeatureHaveChange.whichInternalFeatureHaveChangedHeader()
      WhichExternalFeatureHaveChange.whichExternalFeatureHaveChangedRadio("Outdoor seating")
      continueButtonClick()
      WhatHappenedToOutdoorSeating.whatHappenedToOutdoorSeatingHeader()
      WhatHappenedToOutdoorSeating.whatHappenedToOutdoorSeatingRadio("You added outdoor seating")
      continueButtonClick()
      CheckAndConfirmChangesToExternalFeatures.checkAndConfirmChangesToExternalFeaturesHeader()
      CheckAndConfirmChangesToExternalFeatures.verifyExternalSummaryItem("Outdoor seating", "Added")
      CheckAndConfirmChangesToExternalFeatures.tellAnotherExternalFeatureRadio("Yes")
      continueButtonClick()

      Then("The ratepayer adds 'Parking - You added parking' to the property")
      WhichExternalFeatureHaveChange.whichInternalFeatureHaveChangedHeader()
      WhichExternalFeatureHaveChange.whichExternalFeatureHaveChangedRadio("Parking")
      continueButtonClick()
      WhatHappenedToParking.whatHappenedToParkingHeader()
      WhatHappenedToParking.whatHappenedToParkingRadio("You added parking")
      continueButtonClick()
      CheckAndConfirmChangesToExternalFeatures.checkAndConfirmChangesToExternalFeaturesHeader()
      CheckAndConfirmChangesToExternalFeatures.verifyExternalSummaryItem("Parking", "Added")
      CheckAndConfirmChangesToExternalFeatures.tellAnotherExternalFeatureRadio("Yes")
      continueButtonClick()

      Then("The ratepayer adds 'Solar panels - You added solar panels' to the property")
      WhichExternalFeatureHaveChange.whichInternalFeatureHaveChangedHeader()
      WhichExternalFeatureHaveChange.whichExternalFeatureHaveChangedRadio("Solar panels")
      continueButtonClick()
      WhatHappenedToSolarPanels.whatHappenedToSolarPanelsHeader()
      WhatHappenedToSolarPanels.whatHappenedToSolarPanelsRadio("You added solar panels")
      continueButtonClick()
      CheckAndConfirmChangesToExternalFeatures.checkAndConfirmChangesToExternalFeaturesHeader()
      CheckAndConfirmChangesToExternalFeatures.verifyExternalSummaryItem("Solar panels", "Added")
      CheckAndConfirmChangesToExternalFeatures.tellAnotherExternalFeatureRadio("Yes")
      continueButtonClick()

      // Selecting Other external features
      Then(
        "The ratepayer adds 'Other external feature - Advertising displays on your property - You added advertising displays on your property' to the property"
      )
      WhichExternalFeatureHaveChange.whichInternalFeatureHaveChangedHeader()
      WhichExternalFeatureHaveChange.selectOtherExternalFeatures("advertisingDisplays")
      continueButtonClick()
      WhatHappenedToAdvertisingDisplaysOnProperty.whatHappenedToAdvertisingDisplaysOnPropertyHeader()
      WhatHappenedToAdvertisingDisplaysOnProperty.whatHappenedToAdvertisingDisplaysOnPropertyRadio(
        "You added advertising displays on your property"
      )
      continueButtonClick()
      CheckAndConfirmChangesToExternalFeatures.checkAndConfirmChangesToExternalFeaturesHeader()
      CheckAndConfirmChangesToExternalFeatures.verifyExternalSummaryItem(
        "Advertising displays on your property",
        "Added"
      )
      CheckAndConfirmChangesToExternalFeatures.tellAnotherExternalFeatureRadio("Yes")
      continueButtonClick()

      Then("The ratepayer adds 'Other external feature - Bike sheds - You added bike sheds' to the property")
      WhichExternalFeatureHaveChange.whichInternalFeatureHaveChangedHeader()
      WhichExternalFeatureHaveChange.selectOtherExternalFeatures("bikeSheds")
      continueButtonClick()
      WhatHappenedToBikeSheds.whatHappenedToBikeShedsHeader()
      WhatHappenedToBikeSheds.whatHappenedToBikeShedsRadio("You added bike sheds")
      continueButtonClick()
      CheckAndConfirmChangesToExternalFeatures.checkAndConfirmChangesToExternalFeaturesHeader()
      CheckAndConfirmChangesToExternalFeatures.verifyExternalSummaryItem("Bike sheds", "Added")
      CheckAndConfirmChangesToExternalFeatures.tellAnotherExternalFeatureRadio("Yes")
      continueButtonClick()

      Then("The ratepayer adds 'Other external feature - Canopies - You added canopies' to the property")
      WhichExternalFeatureHaveChange.whichInternalFeatureHaveChangedHeader()
      WhichExternalFeatureHaveChange.selectOtherExternalFeatures("canopies")
      continueButtonClick()
      WhatHappenedToCanopies.whatHappenedToCanopiesHeader()
      WhatHappenedToCanopies.whatHappenedToCanopiesRadio("You added canopies")
      continueButtonClick()
      CheckAndConfirmChangesToExternalFeatures.checkAndConfirmChangesToExternalFeaturesHeader()
      CheckAndConfirmChangesToExternalFeatures.verifyExternalSummaryItem("Canopies", "Added")
      CheckAndConfirmChangesToExternalFeatures.tellAnotherExternalFeatureRadio("Yes")
      continueButtonClick()

      Then(
        "The ratepayer adds 'Other external feature - Gravelled, fenced land - You added gravelled, fenced land' to the property"
      )
      WhichExternalFeatureHaveChange.whichInternalFeatureHaveChangedHeader()
      WhichExternalFeatureHaveChange.selectOtherExternalFeatures("landGravelledFenced")
      continueButtonClick()
      WhatHappenedToGravelledFencedLand.whatHappenedToGravelledFencedLandHeader()
      WhatHappenedToGravelledFencedLand.whatHappenedToGravelledFencedLandRadio("You added gravelled, fenced land")
      continueButtonClick()
      CheckAndConfirmChangesToExternalFeatures.checkAndConfirmChangesToExternalFeaturesHeader()
      CheckAndConfirmChangesToExternalFeatures.verifyExternalSummaryItem("Gravelled, fenced land", "Added")
      CheckAndConfirmChangesToExternalFeatures.tellAnotherExternalFeatureRadio("Yes")
      continueButtonClick()

      Then(
        "The ratepayer adds 'Other external feature - Gravelled, open land - You added gravelled, open land' to the property"
      )
      WhichExternalFeatureHaveChange.whichInternalFeatureHaveChangedHeader()
      WhichExternalFeatureHaveChange.selectOtherExternalFeatures("landGravelledOpen")
      continueButtonClick()
      WhatHappenedToGravelledOpenLand.whatHappenedToGravelledOpenLandHeader()
      WhatHappenedToGravelledOpenLand.wwhatHappenedToGravelledOpenLandRadio("You added gravelled, open land")
      continueButtonClick()
      CheckAndConfirmChangesToExternalFeatures.checkAndConfirmChangesToExternalFeaturesHeader()
      CheckAndConfirmChangesToExternalFeatures.verifyExternalSummaryItem("Gravelled, open land", "Added")
      CheckAndConfirmChangesToExternalFeatures.tellAnotherExternalFeatureRadio("Yes")
      continueButtonClick()

      Then(
        "The ratepayer adds 'Other external feature - Hard-surfaced, fenced land - You added hard-surfaced, fenced land' to the property"
      )
      WhichExternalFeatureHaveChange.whichInternalFeatureHaveChangedHeader()
      WhichExternalFeatureHaveChange.selectOtherExternalFeatures("landHardSurfacedFenced")
      continueButtonClick()
      WhatHappenedToHardSurfacedFencedLand.whatHappenedToHardSurfacedFencedLandHeader()
      WhatHappenedToHardSurfacedFencedLand.whatHappenedToHardSurfacedFencedLandRadio(
        "You added hard-surfaced, fenced land"
      )
      continueButtonClick()
      CheckAndConfirmChangesToExternalFeatures.checkAndConfirmChangesToExternalFeaturesHeader()
      CheckAndConfirmChangesToExternalFeatures.verifyExternalSummaryItem("Hard-surfaced, fenced land", "Added")
      CheckAndConfirmChangesToExternalFeatures.tellAnotherExternalFeatureRadio("Yes")
      continueButtonClick()

      Then(
        "The ratepayer adds 'Other external feature - Hard-surfaced, open land - You added hard-surfaced, open land' to the property"
      )
      WhichExternalFeatureHaveChange.whichInternalFeatureHaveChangedHeader()
      WhichExternalFeatureHaveChange.selectOtherExternalFeatures("landHardSurfacedOpen")
      continueButtonClick()
      WhatHappenedToHardSurfacedOpenLand.whatHappenedToHardSurfacedOpenLandHeader()
      WhatHappenedToHardSurfacedOpenLand.whatHappenedToHardSurfacedOpenLandRadio("You added hard-surfaced, open land")
      continueButtonClick()
      CheckAndConfirmChangesToExternalFeatures.checkAndConfirmChangesToExternalFeaturesHeader()
      CheckAndConfirmChangesToExternalFeatures.verifyExternalSummaryItem("Hard-surfaced, open land", "Added")
      CheckAndConfirmChangesToExternalFeatures.tellAnotherExternalFeatureRadio("Yes")
      continueButtonClick()

      Then(
        "The ratepayer adds 'Other external feature - Unsurfaced, fenced land - You added unsurfaced, fenced land' to the property"
      )
      WhichExternalFeatureHaveChange.whichInternalFeatureHaveChangedHeader()
      WhichExternalFeatureHaveChange.selectOtherExternalFeatures("landUnsurfacedFenced")
      continueButtonClick()
      WhatHappenedToUnsurfacedFencedLand.whatHappenedToUnsurfacedFencedLandHeader()
      WhatHappenedToUnsurfacedFencedLand.whatHappenedToUnsurfacedFencedLandRadio("You added unsurfaced, fenced land")
      continueButtonClick()
      CheckAndConfirmChangesToExternalFeatures.checkAndConfirmChangesToExternalFeaturesHeader()
      CheckAndConfirmChangesToExternalFeatures.verifyExternalSummaryItem("Unsurfaced, fenced land", "Added")
      CheckAndConfirmChangesToExternalFeatures.tellAnotherExternalFeatureRadio("Yes")
      continueButtonClick()

      Then(
        "The ratepayer adds 'Other external feature - Unsurfaced, open land - You added unsurfaced, open land' to the property"
      )
      WhichExternalFeatureHaveChange.whichInternalFeatureHaveChangedHeader()
      WhichExternalFeatureHaveChange.selectOtherExternalFeatures("landUnsurfacedOpen")
      continueButtonClick()
      WhatHappenedToUnsurfacedOpenLand.whatHappenedToUnsurfacedOpenLandHeader()
      WhatHappenedToUnsurfacedOpenLand.whatHappenedToUnsurfacedOpenLandRadio("You added unsurfaced, open land")
      continueButtonClick()
      CheckAndConfirmChangesToExternalFeatures.checkAndConfirmChangesToExternalFeaturesHeader()
      CheckAndConfirmChangesToExternalFeatures.verifyExternalSummaryItem("Unsurfaced, open land", "Added")
      CheckAndConfirmChangesToExternalFeatures.tellAnotherExternalFeatureRadio("Yes")
      continueButtonClick()

      Then(
        "The ratepayer adds 'Other external feature - Portable buildings - You added portable buildings ' to the property"
      )
      WhichExternalFeatureHaveChange.whichInternalFeatureHaveChangedHeader()
      WhichExternalFeatureHaveChange.selectOtherExternalFeatures("portableBuildings")
      continueButtonClick()
      WhatHappenedToPortableBuildings.whatHappenedToPortableBuildingsHeader()
      WhatHappenedToPortableBuildings.whatHappenedToPortableBuildingsRadio("You added portable buildings")
      continueButtonClick()
      CheckAndConfirmChangesToExternalFeatures.checkAndConfirmChangesToExternalFeaturesHeader()
      CheckAndConfirmChangesToExternalFeatures.verifyExternalSummaryItem("Portable buildings", "Added")
      CheckAndConfirmChangesToExternalFeatures.tellAnotherExternalFeatureRadio("Yes")
      continueButtonClick()

      Then(
        "The ratepayer adds 'Other external feature Shipping containers - You added shipping containers ' to the property"
      )
      WhichExternalFeatureHaveChange.whichInternalFeatureHaveChangedHeader()
      WhichExternalFeatureHaveChange.selectOtherExternalFeatures("shippingContainers")
      continueButtonClick()
      WhatHappenedToShippingContainers.whatHappenedToShippingContainersHeader()
      WhatHappenedToShippingContainers.whatHappenedToShippingContainersRadio("You added shipping containers")
      continueButtonClick()
      CheckAndConfirmChangesToExternalFeatures.checkAndConfirmChangesToExternalFeaturesHeader()
      CheckAndConfirmChangesToExternalFeatures.verifyExternalSummaryItem("Shipping containers", "Added")
      CheckAndConfirmChangesToExternalFeatures.tellAnotherExternalFeatureRadio("No")
      continueButtonClick()
      AnythingElseTellUs.anythingElseTellUsHeader()
      clickLink("Sign out")
      SignOutPage.signOut()

    }
  }
}
