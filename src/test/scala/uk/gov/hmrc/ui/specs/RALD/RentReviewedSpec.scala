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

class RentReviewedSpec extends BaseSpec with StubPage {

  Feature("Testing the 'you reviewed your rent' journey") {
    Scenario("The user reviewed their rent") {
      Given("Ratepayer logins through one login")
      loginOl()

      When("The ratepayer clicks on 'Tell us about a change' link from dashboard")
      dashboard()
      clickLink("Tell us about a change")

      Then("The ratepayers selects the property and proceed through the new agreement journey")
      WhichPropertyDoYouWantToTellUsAbout.whichPropertyDoYouWantToTellUsAbout()
      clickLink("Select property")

      Then("The user selects renewed review your rent link to review their rent")
      WhatDoYouWantToTellUs.whatDoYouWantToTellUs()
      clickLink("You reviewed your rent")
      TellUsAboutYourRent.tellUsAboutYourRent()
      continueButtonClick()

      Then("The user inputs the landlords name and selects family member as type")
      Landlord.landlord()
      Landlord.landlordNameInput(landlordName = "Bob")
      Landlord.familyMemberRadio()

      Then("The user selects verbal agreement as there agreement type")
      WhatTypeOfAgreement.TypeOfAgreement()
      WhatTypeOfAgreement.verbalRadio()
    }
  }
}
