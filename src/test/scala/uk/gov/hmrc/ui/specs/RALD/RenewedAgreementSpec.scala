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
import uk.gov.hmrc.ui.pages.RALD.{Agreement, Landlord, TellUsAboutYourRenewedAgreementPage, WhatDoYouWantToTellUs, WhatTypeOfAgreement, WhatTypeOfLeaseRenewal, WhichPropertyDoYouWantToTellUsAbout}
import uk.gov.hmrc.ui.pages.StubPage
import uk.gov.hmrc.ui.specs.BaseSpec
import uk.gov.hmrc.ui.utils.login.loginOl

class RenewedAgreementSpec extends BaseSpec with StubPage {

  Feature("Testing the renewed agreement functionality") {
    Scenario("The user renewed their agreement") {

      Given("Ratepayer logins through one login")
      loginOl()

      When("The ratepayer clicks on 'Tell us about a change' link from dashboard")
      dashboard()
      clickLink("Tell us about a change")

      Then("The ratepayers selects the property and proceed through the new agreement journey")
      WhichPropertyDoYouWantToTellUsAbout.whichPropertyDoYouWantToTellUsAbout()
      clickLink("Select property")

      Then("The user selects renewed agreement link to renew their agreement")
      WhatDoYouWantToTellUs.whatDoYouWantToTellUs()
      clickLink("You renewed your agreement")
      TellUsAboutYourRenewedAgreementPage.tellUsAboutYourRenewedAgreement()
      continueButtonClick()

      Then("The user selects renewed agreement type of lease renewal")
      WhatTypeOfLeaseRenewal.typeOfLeaseRenewal()
      WhatTypeOfLeaseRenewal.renewedAgreementRadio()
      continueButtonClick()

      Then("The user inputs the landlords name and selects family member as type")
      Landlord.landlord()
      Landlord.landlordNameInput(landlordName = "Bob")
      Landlord.relationshipWithTheLandlord("family Member")
      click(continueButton)

      Then("The user selects verbal agreement as there agreement type")
      WhatTypeOfAgreement.TypeOfAgreement()
      WhatTypeOfAgreement.writtenRadio()
      click(continueButton)

      Then("The user entered agreement started date and end date also gave break clause")
      Agreement.agreement()
      Agreement.enterAgreementStartDate("02", "01", "2015")
      Agreement.agreementOpenEndedRadio("No")
      Agreement.enterOpenEndedAgreementDate("11", "11", "2027")
      Agreement.agreementHaveABreakClauseRadio("No")
      Agreement.agreementBreakClauseReason("VOA budget issue")
      continueButtonClick()
    }
  }
}
