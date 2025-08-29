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

import uk.gov.hmrc.ui.pages.StubPage
import uk.gov.hmrc.ui.specs.BaseSpec
import uk.gov.hmrc.ui.pages.Physical._
import uk.gov.hmrc.ui.utils.login.loginOl
import uk.gov.hmrc.ui.pages.Dashboard.DashboardHome.dashboard
import uk.gov.hmrc.ui.pages.RALD._
import uk.gov.hmrc.ui.utils.mongo.PhysicalDB

class UseOfSpaceSpec extends BaseSpec with StubPage {
  Feature("Testing the changed property features or use of space functionality") {
    Scenario("The user adds all 3 option with planning permission number to the change use of space") {
      PhysicalDB.cleanup()
      Given("Ratepayer logins through one login")
      loginOl()

      When("The ratepayer clicks on 'Tell us about a change' link from dashboard")
      dashboard()
      clickLink("Tell us about a change")

      Then(
        "The ratepayers selects the property and proceed through the changed property feature or use of space journey"
      )
      WhichPropertyDoYouWantToTellUsAbout.whichPropertyDoYouWantToTellUsAbout()
      clickLink("Select property")

      Then("The user selects the changed property features or use of space link")
      WhatDoYouWantToTellUs.whatDoYouWantToTellUs()
      clickLink("You changed property features or use of space")
      TellUsChangedPropertyFeaturesOrUseOfSpace.tellUsChangedPropertyFeatureHeader()
      continueButtonClick()

      InformationAndSupportingDocumentsNeed.InformationAndSupportingDocScreen()

      Then("The ratepayer adds a date when the change was completed")
      WhenCompleteChange.whenCompleteChangeScreen()
      WhenCompleteChange.dateInput("10", "10", "2022")
      continueButtonClick()

      Then("The ratepayer answers to the 'Have you changed use of space' question")
      HaveYouChangedUseOfSpace.changedUseOfSpaceHeader()
      HaveYouChangedUseOfSpace.changedUseOfSpaceRadio("Yes")
      continueButtonClick()

      Then("The ratepayer selects all 'how they changed the use of space' options with planning permission.")
      AboutChangeToUseOfSpace.aboutTheChangeToUseOfSpaceHeader()
      AboutChangeToUseOfSpace.selectUseOfSpace("Rearranged the use of space in the property")
      AboutChangeToUseOfSpace.selectUseOfSpace("Built an extension")
      AboutChangeToUseOfSpace.selectUseOfSpace("Demolished part of the property")
      AboutChangeToUseOfSpace.planningPermissionRadio()
      AboutChangeToUseOfSpace.planningPermissionNumberInput("123456789")
      continueButtonClick()

      Then("The ratepayer completed the 'Use of space' journey and moved to the next 'Internal feature' screen")
      HaveYouChangedInternalFeatures.changedInternalFeatureHeader()

    }
  }

}
