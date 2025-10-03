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

import uk.gov.hmrc.ui.pages.Dashboard.DashboardHome
import uk.gov.hmrc.ui.pages.PropertyLinking.RegisterComplete
import uk.gov.hmrc.ui.pages.RALD.YourProperty
import uk.gov.hmrc.ui.pages.Registration.CheckYourAnswer
import uk.gov.hmrc.ui.pages.Registration.contactDetails.{ConfirmContactDetailsPage, PhoneNumberPage}
import uk.gov.hmrc.ui.pages.Registration.provideTRN.{ConfirmUTRPage, ProvideTRNPage}
import uk.gov.hmrc.ui.pages.{FeedbackPage, StubPage}
import uk.gov.hmrc.ui.utils.login.loginOl
import uk.gov.hmrc.ui.utils.mongo.RegistrationDB

class DashboardSpec extends BaseSpec with StubPage {

  var contactName: String = _

  Feature("Testing the dashboard functionality") {

    Scenario("The user isn't registered and must complete registration before accessing the dashboard") {
      RegistrationDB.cleanup()
      Given("Ratepayer logins through one login")
      loginOl()

      Then("User provide phone number")
      PhoneNumberPage.userProvidesPhoneNumber()

      Then("Ratepayer is taken to the Confirm Contact Details page")
      ConfirmContactDetailsPage.ConfirmContactDetails()
      click(continueButton)

      Then("Ratepayer is taken to Provide TRN Page")
      ProvideTRNPage.provideYourTRN()
      click(continueButton)

      Then("User selects 'Yes, I want to provide this UTR' and submit")
      ConfirmUTRPage.selectYes()

      Then("The ratepayer is taken to the 'Check your answers' page")
      CheckYourAnswer.checkYourAnswer()
      contactName = getElementByCssSelector("#contact-name-id").toString
      click(continueButton)

      Then("Ratepayer is taken to the Registration complete page")
      RegisterComplete.RegisterComplete()
      click(continueButton)

      Then("Ratepayer is now fully registered and is taken to the dashboard")
      DashboardHome.DashboardHome(contactName)
    }

    Scenario("Ratepayer is already registered and lands on the dashboard after login") {

      Given("Ratepayer logins through one login")
      loginOl()
      Then("Ratepayer is taken to the dashboard")
      DashboardHome.DashboardHome(contactName)

    }

    Scenario("Ratepayer lands on the dashboard and clicks the feedback link") {

      Given("Ratepayer logins through one login")
      loginOl()
      Then("Ratepayer is taken to the dashboard")
      DashboardHome.DashboardHome(contactName)
      Then("Ratepayer clicks the feedback link and is taken to the feedback page")
      DashboardHome.feedbackLinkDisplay()
      clickLink("feedback")
      FeedbackPage.sendFeedbackPage()

    }

    Scenario("Test to check 'Review your property details' link on dashboard") {
      Given("Ratepayer logins through one login")
      loginOl()
      Then("Ratepayer is taken to the dashboard")
      DashboardHome.DashboardHome(contactName)
      Then("Ratepayer clicks the 'Review your property details' link and navigated to yourProperty page")
      clickLink("Review your property details")
      YourProperty.yourProperty()

    }

  }
}
