package uk.gov.hmrc.ui.specs.RALD

import uk.gov.hmrc.ui.pages.Dashboard.DashboardHome.dashboard
import uk.gov.hmrc.ui.pages.RALD._
import uk.gov.hmrc.ui.pages.StubPage
import uk.gov.hmrc.ui.specs.BaseSpec
import uk.gov.hmrc.ui.utils.login.loginOl

class NewAgreementSpec extends BaseSpec with StubPage {

  Feature("Testing the new agreement functionality") {
    Scenario("The user creates the new agreement") {

      Given("Ratepayer logins through one login")
      loginOl()

      When("The ratepayer clicks on 'Tell us about a change' link from dashboard")
      dashboard()
      clickLink("Tell us about a change")

      Then("The ratepayers selects the property and proceed through the new agreement journey")
      WhichPropertyDoYouWantToTellUsAbout.WhichPropertyDoYouWantToTellUsAbout()
      clickLink("Select property")

      Then("The user selects new agreement link to tell about their new agreement")
      WhatDoYouWantToTellUs.WhatDoYouWantToTellUs()
      clickLink("You have a new agreement")
      TellUsAboutYourNewAgreementPage.tellUsAboutYourNewAgreement()
      continueButton



    }
  }
}
