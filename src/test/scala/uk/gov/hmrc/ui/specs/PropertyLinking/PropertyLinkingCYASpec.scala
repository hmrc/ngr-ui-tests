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

package uk.gov.hmrc.ui.specs.PropertyLinking

import org.openqa.selenium.By
import uk.gov.hmrc.ui.pages.StubPage
import uk.gov.hmrc.ui.pages.Dashboard.DashboardHome
import uk.gov.hmrc.ui.pages.PropertyLinking.PropertyLinkingCYA.hitCYAStep
import uk.gov.hmrc.ui.pages.PropertyLinking._
import uk.gov.hmrc.ui.specs.BaseSpec
import uk.gov.hmrc.ui.utils.login.loginOl

import java.time.{Clock, Instant, ZoneId}

class PropertyLinkingCYASpec extends BaseSpec with StubPage {

  var contactName: String = "BOB JONES"
  val postCode            = "BH1 1HU"
  val fixedClock          = Clock.fixed(Instant.parse("2026-06-05T12:00:00Z"), ZoneId.of("UTC"))

  Feature("Tests for the change details feature of the Property Linking Check Your Answers page") {

    Scenario("Registered ratepayer goes through the flow to establish a property, and changes the ratepayer date") {

      Given("Ratepayer logins through one login")
      loginOl()

//      Then("User provide phone number")
//      PhoneNumberPage.userProvidesPhoneNumber()
//
//      Then("Ratepayer is taken to the Confirm Contact Details page")
//      ConfirmContactDetailsPage.ConfirmContactDetails()
//      click(continueButton)
//
//      Then("Ratepayer is taken to Provide TRN Page")
//      ProvideTRNPage.provideYourTRN()
//      click(continueButton)
//
//      Then("User selects 'Yes, I want to provide this UTR' and submit")
//      ConfirmUTRPage.selectYes()
//
//      Then("The ratepayer is taken to the 'Check your answers' page")
//      CheckYourAnswer.checkYourAnswer()
//      click(continueButton)
//
//      Then("Ratepayer is taken to the Registration complete page")
//      RegisterComplete.RegisterComplete()
//      click(continueButton)

      Then("Ratepayer is now fully registered and is taken to the dashboard")
      DashboardHome.DashboardHome(contactName)

      Then("Ratepayer clicks the Add a Property link and is taken to the Add a Property page")
      clickLink("Add a property")
      AddAProperty.addAProperty()
      click(continueButton)

      Then("Ratepayer is taken to the What You Need page")
      WhatYouNeed.whatYouNeed()
      click(continueButton)

      Then("Ratepayer is taken to the find a property page and searches for a property")
      FindAProperty.findProperty()
      FindAProperty.inputPostCode(postCode)

      Then("Ratepayer is taken to the search results page")
      PropertySearchResultPage.searchResult(postCode)

      Then("Ratepayer click 'Select property' on the search results page")
      clickLink("Select property")

      Then("Ratepayer is taken to the selected property page, clicks the 'yes' radio and continues")
      SelectedProperty.selectedProperty()
      SelectedProperty.yesRadio()

      Then("Ratepayer selects 'Before 1 April 2026' on 'When did you become the current ratepayer?' page")
      CurrentRatepayer.currentRatepayer()
      CurrentRatepayer.beforeDateRadio()

      Then("The ratepayers selects 'yes' on 'business rates bill for the property' page")
      BusinessRateBillPage.BusinessRateBill()
      BusinessRateBillPage.selectYes()

      Then("ratepayer hits the property-connection page, selects 'owner' and continues")
      ConnectionToPropertyPage.hitConnectionStep()
      ConnectionToPropertyPage.ConnectionToProperty()
      ConnectionToPropertyPage.ConnectionType("Owner")

      Then("The ratepayer hits the CYA page")
      hitCYAStep()
      PropertyLinkingCYA.checkYourAnswer()

      Then("Clicks the change ratePayer link")
      PropertyLinkingCYA.clickChangeRatepayerDate()

      Then("The 'When did you become the current ratepayer?' page is shown")
      CurrentRatepayer.currentRatepayer()

      Then("Ratepayer selects 'After 1 April 2026' on 'When did you become the current ratepayer?' page")

      CurrentRatepayer.timeSkip(fixedClock)
      CurrentRatepayer.afterDateRadio()
      CurrentRatepayer.dateInput("23", "05", "2026")
      click(continueButton)

      Then("The Ratepayer is taken back to the Check Your Answers page, with the ratepayer date changed")
      PropertyLinkingCYA.checkYourAnswer()
      PropertyLinkingCYA.dateChangedCheck("On or after 1 April 2026")
    }

    Scenario("Registered ratepayer goes through the flow to establish a property, and changes the rates bill bool") {

      Given("Ratepayer logins through one login")
      loginOl()

      Then("Ratepayer is now fully registered and is taken to the dashboard")
      DashboardHome.DashboardHome(contactName)

      Then("The ratepayer hits the CYA page")
      hitCYAStep()
      PropertyLinkingCYA.checkYourAnswer()

      Then("Clicks the change business rates bill link")
      PropertyLinkingCYA.clickChangeBusinessRatesBill()

      Then("The 'business rates bill for the property' page is shown")
      BusinessRateBillPage.BusinessRateBill()

      Then("Ratepayer selects 'no' on 'business rates bill for the property' page")
      BusinessRateBillPage.selectNo()

      Then("The Ratepayer is taken back to the Check Your Answers page, with the ratepayer bill bool changed")
      PropertyLinkingCYA.checkYourAnswer()
      PropertyLinkingCYA.billChangedCheck("No")
    }

    Scenario("Registered ratepayer goes through the flow to establish a property, and changes the property address") {

      Given("Ratepayer logins through one login")
      loginOl()

      Then("Ratepayer is now fully registered and is taken to the dashboard")
      DashboardHome.DashboardHome(contactName)

      Then("The ratepayer hits the CYA page")
      hitCYAStep()
      PropertyLinkingCYA.checkYourAnswer()

      Then("Clicks the change property address link")
      PropertyLinkingCYA.clickChangePropertyAddressLink()

      Then("Ratepayer is taken to the find a property page and searches for a property")
      FindAProperty.findProperty()
      FindAProperty.inputPostCode(postCode)

      Then("Ratepayer is taken to the search results page")
      PropertySearchResultPage.searchResult(postCode)

      Then("Ratepayer clicks the second 'Select property' on the search results page")
      val link = By.cssSelector(
        "#main-content > div > div > div:nth-child(2) > div > table > tbody > tr:nth-child(2) > td:nth-child(5) > a"
      )
      waitForElementToBeClickable(link)
      click(
        By.cssSelector(
          "#main-content > div > div > div:nth-child(2) > div > table > tbody > tr:nth-child(2) > td:nth-child(5) > a"
        )
      )

      Then("Ratepayer is taken to the selected property page, clicks the 'yes' radio and continues")
      SelectedProperty.selectedProperty()
      SelectedProperty.yesRadio()

      Then("Ratepayer selects 'Before 1 April 2026' on 'When did you become the current ratepayer?' page")
      CurrentRatepayer.currentRatepayer()
      CurrentRatepayer.beforeDateRadio()

      Then("The ratepayers selects 'yes' on 'business rates bill for the property' page")
      BusinessRateBillPage.BusinessRateBill()
      BusinessRateBillPage.selectYes()

      Then("The Ratepayer is taken back to the Check Your Answers page, with the address changed")
      hitCYAStep()
      PropertyLinkingCYA.checkYourAnswer()
      PropertyLinkingCYA.addressChangedCheck("Bug Me Not PVT LTD, RODLEY LANE, RODLEY, LEEDS, BH1 1HU")
    }

    Scenario(
      "Registered ratepayer goes through the flow to establish a property, and changes the property connection"
    ) {

      Given("Ratepayer logins through one login")
      loginOl()

      Then("Ratepayer is now fully registered and is taken to the dashboard")
      DashboardHome.DashboardHome(contactName)

      Then("The ratepayer hits the CYA page")
      hitCYAStep()
      PropertyLinkingCYA.checkYourAnswer()

      Then("The Ratepayer clicks the change property connection link, and is taken to the property connection page")
      PropertyLinkingCYA.clickChangePropertyConnection()
      ConnectionToPropertyPage.ConnectionToProperty()

      Then("Ratepayer clicks on the 'occupier' radio button")
      ConnectionToPropertyPage.ConnectionType("Occupier")

      And("Ratepayer is taken back to the CYA page with the connection to the property changed")
      PropertyLinkingCYA.checkYourAnswer()
      PropertyLinkingCYA.connectionChangedCheck("Occupier")
    }

  }
}
