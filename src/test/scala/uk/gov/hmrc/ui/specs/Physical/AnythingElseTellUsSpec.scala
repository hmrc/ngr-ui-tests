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
import uk.gov.hmrc.ui.pages.Physical.{AnythingElseTellUs, CheckAndConfirmChangesToInternalFeatures, HaveYouChangedExternalFeatures, HaveYouChangedInternalFeatures, HaveYouChangedUseOfSpace, HowMuchOfPropertyHasAirConditioning, InformationAndSupportingDocumentsNeed, SelectYourProperty, SupportingDocuments, TellUsChangedPropertyFeaturesOrUseOfSpace, WhenCompleteChange, WhichInternalFeatureHaveChanged}
import uk.gov.hmrc.ui.pages.RALD.WhatDoYouWantToTellUs
import uk.gov.hmrc.ui.pages.{SignOutPage, StubPage}
import uk.gov.hmrc.ui.specs.BaseSpec
import uk.gov.hmrc.ui.utils.login.loginOl
import uk.gov.hmrc.ui.utils.mongo.PhysicalDB

class AnythingElseTellUsSpec extends BaseSpec with StubPage {
  Feature("Testing the 'Anything Else You Want To Tell Us' features functionalities") {
    Scenario("The user selects and adds changes to Add extra information what changed on the property") {
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

      // 'Yes' to internal feature changed
      Then("The ratepayer answer Yes to 'Have you changed internal features?' question")
      HaveYouChangedInternalFeatures.changedInternalFeatureHeader()
      HaveYouChangedInternalFeatures.changedInternalFeatureRadio("Yes")
      continueButtonClick()

      // Adding one Internal Feature

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

      // 'NO' to external feature changed
      Then("The ratepayer answer Yes to 'Have you changed external features?' question")
      HaveYouChangedExternalFeatures.changedExternalFeatureHeader()
      HaveYouChangedExternalFeatures.changedExternalFeatureRadio("No")
      continueButtonClick()

      Then("The ratepayer add an extra information on the 'Anything Else Tell Us' screen")
      AnythingElseTellUs.anythingElseTellUsHeader()
      AnythingElseTellUs.anythingElseTellUsRadio("Yes")
      AnythingElseTellUs.AnythingElseTellUsTextInput("This is an automated UI test.")
      continueButtonClick()
      SupportingDocuments.supportingDocumentsHeader()
      clickLink("Sign out")
      SignOutPage.signOut()

    }
  }
}
