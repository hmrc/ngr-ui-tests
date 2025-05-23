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

package uk.gov.hmrc.ui.specs

import uk.gov.hmrc.ui.pages.StubPage
import uk.gov.hmrc.ui.pages.dashboard.DashboardHome
import uk.gov.hmrc.ui.pages.propertyLinking.WhatYouNeed.contactLinkDisplay
import uk.gov.hmrc.ui.pages.propertyLinking.{AddAProperty, WhatYouNeed}
import uk.gov.hmrc.ui.utils.login.loginOl

class WhatYouNeedSpec extends BaseSpec with StubPage {

  Scenario("Ratepayer navigates to the What You Need page and clicks the contact link") {

    Given("Ratepayer logins through one login")
    loginOl()

    Then("Ratepayer is taken to the dashboard")
    DashboardHome.DashboardHome("Bob Jones")

    Then("Ratepayer clicks the add a property link")
    clickLink("Add a property")
    AddAProperty.addAProperty()
    click(continueButton)

    Then("Ratepayer is taken to the What You Need page and clicks the link")
    WhatYouNeed.whatYouNeed()
    contactLinkDisplay()
    clickLink("contact your local council (opens in a new tab)")

  }

  Scenario("Ratepayer navigates to the What You Need page and clicks the back link") {

    Given("Ratepayer logins through one login")
    loginOl()

    Then("Ratepayer is taken to the dashboard")
    DashboardHome.DashboardHome("Bob Jones")

    Then("Ratepayer clicks the add a property link")
    clickLink("Add a property")
    AddAProperty.addAProperty()
    click(continueButton)

    Then("Ratepayer is taken to the What You Need page")
    WhatYouNeed.whatYouNeed()
    contactLinkDisplay()
    clickLink("contact your local council (opens in a new tab)")

    Then("Ratepayer clicks the back link and is taken to the Add a property page")
    clickLink("Back")
    AddAProperty.addAProperty()
  }

}
