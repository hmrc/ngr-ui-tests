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
import uk.gov.hmrc.ui.pages.RALD.{WhatDoYouWantToTellUs, YourProperty}
import uk.gov.hmrc.ui.pages.{SignOutPage, StubPage}
import uk.gov.hmrc.ui.specs.BaseSpec
import uk.gov.hmrc.ui.utils.login.loginGg
import uk.gov.hmrc.ui.utils.mongo.PhysicalDB

class EndToEndTestSpec extends BaseSpec with StubPage {

  Feature("End to end Physical journey") {
    Scenario("The user adds features and complete the journey") {
      PhysicalDB.cleanup()
      Given("Ratepayer logins through one login")
      loginGg()
      PhysicalDB.insertPropertyLinkingData()

      When("The ratepayer clicks on 'Tell us about a change' link from dashboard")
      dashboard()
      clickLink("Tell us about a change")

      Then(
        "The ratepayers selects the property and proceed through the changed property feature or use of space journey"
      )
      YourProperty.yourProperty()
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
      HaveYouChangedUseOfSpace.changedUseOfSpaceRadio("Yes")
      continueButtonClick()

      Then("The ratepayer selects all 'how they changed the use of space' options with no planning permission.")
      AboutChangeToUseOfSpace.aboutTheChangeToUseOfSpaceHeader()
      AboutChangeToUseOfSpace.selectUseOfSpace("Rearranged the use of space in the property")
      AboutChangeToUseOfSpace.noPlanningPermissionRadio()
      continueButtonClick()

      // selecting one internal feature
      Then("The ratepayer answer Yes to 'Have you changed internal features?' question")
      HaveYouChangedInternalFeatures.changedInternalFeatureHeader()
      HaveYouChangedInternalFeatures.changedInternalFeatureRadio("Yes")
      continueButtonClick()

      Then("The ratepayer adds 'Air condition - Some of the property has air conditioning' to the property")
      WhichInternalFeatureHaveChanged.whichInternalFeatureHaveChangedHeader()
      WhichInternalFeatureHaveChanged.whichInternalFeatureHaveChangedRadio("Air conditioning")
      continueButtonClick()
      HowMuchOfPropertyHasAirConditioning.howMuchOfPropertyHasAirConditioningLegend()
      HowMuchOfPropertyHasAirConditioning.howMuchAirConditioningRadio("Some of the property has air conditioning")
      continueButtonClick()
      CheckAndConfirmChangesToInternalFeatures.checkAndConfirmChangesToInternalFeaturesHeader()
      CheckAndConfirmChangesToInternalFeatures.verifySummaryItem("Air conditioning", "In some of the property")
      CheckAndConfirmChangesToInternalFeatures.tellAnotherInternalFeatureRadio("No")
      continueButtonClick()

      Then("The ratepayer answer Yes to 'Have you changed external features?' question")
      HaveYouChangedExternalFeatures.changedExternalFeatureHeader()
      HaveYouChangedExternalFeatures.changedExternalFeatureRadio("Yes")
      continueButtonClick()

      // Selecting external one features
      Then("The ratepayer adds 'Loading bays - You removed all loading bays' to the property")
      WhichExternalFeatureHaveChange.whichInternalFeatureHaveChangedHeader()
      WhichExternalFeatureHaveChange.whichExternalFeatureHaveChangedRadio("Loading bays")
      continueButtonClick()
      WhatHappenedToLoadingBays.whatHappenedToLoadingBaysHeader()
      WhatHappenedToLoadingBays.whatHappenedToLoadingBaysRadio("You removed all loading bays")
      continueButtonClick()
      CheckAndConfirmChangesToExternalFeatures.checkAndConfirmChangesToExternalFeaturesHeader()
      CheckAndConfirmChangesToExternalFeatures.verifyExternalSummaryItem("Loading bays", "Removed all")
      CheckAndConfirmChangesToExternalFeatures.tellAnotherExternalFeatureRadio("No")
      continueButtonClick()

      // adding extra information to Anything Else To Tell Us
      Then("The ratepayer add an extra information on the 'Anything Else Tell Us' screen")
      AnythingElseTellUs.anythingElseTellUsHeader()
      AnythingElseTellUs.anythingElseTellUsRadio("Yes")
      AnythingElseTellUs.AnythingElseTellUsTextInput("This is an automated UI test.")
      continueButtonClick()
      SupportingDocuments.supportingDocumentsHeader()
      continueButtonClick()

      // uploading supporting documents
      Then("The ratepayer can upload supporting document")
      UploadSupportingDocument.uploadSupportingDocumentsHeader()
      UploadSupportingDocument.uploadSupportingDocuments()
      continueButtonClick()

      // verifying the upload
      Then("The ratepayer can see the uploaded document status")
      UploadedSupportingDocument.uploadedSupportingDocumentHeader()
      UploadedSupportingDocument.verifyUploadedItem("testFile.png", "Uploaded")
      continueButtonClick()

      // it verify that the features are added and shows on the Check and Confirm Changes
      Then("The ratepayer can check the added features on the summary screen")
      CheckAndConfirmYourChanges.checkAndConfirmYourChangesHeader()
      CheckAndConfirmYourChanges.checkAndConfirmYourChangesH2()

      CheckAndConfirmYourChanges.verifyAddedFeatureItems("When did you complete the change?", "10 October 2022")
      CheckAndConfirmYourChanges.verifyAddedFeatureItems("Have you changed use of space?", "Yes")
      CheckAndConfirmYourChanges.verifyAddedFeatureItems(
        "How did you change the use of space?",
        "Rearranged the use of space in the property"
      )
      CheckAndConfirmYourChanges.verifyAddedFeatureItems("Did you get planning permission?", "No")
      CheckAndConfirmYourChanges.verifyAddedFeatureItems("Air conditioning", "In some of the property")
      CheckAndConfirmYourChanges.verifyAddedFeatureItems("Loading bays", "Removed all")
      CheckAndConfirmYourChanges.verifyAddedFeatureItems(
        "Is there anything else you want to tell us about the changes?",
        "Yes"
      )
      /*    CheckAndConfirmYourChanges.verifyAddedFeatureItems(
        "What do you want to tell us?",
        "This is an automated UI test."
      )*/
      CheckAndConfirmYourChanges.verifyAddedFeatureItems("testFile.png", "")
      submitButtonClick()

      // Declaration screen
      Then("The ratepayer can accept the declaration")
      Declaration.declarationHeader()
      continueButtonClick()

      // Confirmation screen
      Then("The ratepayer can see the confirmation with a reference number that the details was sent.")
      PropertyChangeDetailsSent.propertyChangeDetailsSentHeader()
      clickLink("Sign out")
      SignOutPage.signOut()
    }
  }
}
