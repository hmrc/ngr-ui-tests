package uk.gov.hmrc.ui.specs

import org.openqa.selenium.By
import uk.gov.hmrc.ui.pages.StubPage
import uk.gov.hmrc.ui.pages.dashboard.DashboardHome
import uk.gov.hmrc.ui.pages.propertyLinking._
import uk.gov.hmrc.ui.utils.login.loginOl

class PropertyLinkingCYASpec extends BaseSpec with StubPage {

  var contactName: String = "BOB JONES"
  val postCode            = "BH1 1HU"

  Feature("Tests for the change details feature of the Property Linking Check Your Answers page") {

    Scenario("Registered ratepayer goes through the flow to establish a property, and changes the ratepayer date") {

      Given("Ratepayer logins through one login")
      loginOl()

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

      Then("The ratepayer hits the CYA page")
      PropertyLinkingCYA.checkYourAnswer()

      Then("Clicks the change ratePayer link")
      PropertyLinkingCYA.clickChangeRatepayerDate()

      Then("The 'When did you become the current ratepayer?' page is shown")
      CurrentRatepayer.currentRatepayer()

      Then("Ratepayer selects 'After 1 April 2026' on 'When did you become the current ratepayer?' page")
      CurrentRatepayer.afterDateRadio()

      Then("The Ratepayer is taken back to the Check Your Answers page, with the ratepayer date changed")
      PropertyLinkingCYA.checkYourAnswer()
      PropertyLinkingCYA.dateChangedCheck()
    }

    Scenario("Registered ratepayer goes through the flow to establish a property, and changes the rates bill bool") {

      Given("Ratepayer logins through one login")
      loginOl()

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

      Then("The ratepayer hits the CYA page")
      PropertyLinkingCYA.checkYourAnswer()

      Then("Clicks the change business rates bill link")
      PropertyLinkingCYA.clickChangeBusinessRatesBill()

      Then("The 'business rates bill for the property' page is shown")
      BusinessRateBillPage.BusinessRateBill()

      Then("Ratepayer selects 'After 1 April 2026' on 'When did you become the current ratepayer?' page")
      BusinessRateBillPage.selectNo()

      Then("The Ratepayer is taken back to the Check Your Answers page, with the ratepayer date changed")
      PropertyLinkingCYA.checkYourAnswer()
      PropertyLinkingCYA.dateChangedCheck()
    }

    Scenario("Registered ratepayer goes through the flow to establish a property, and changes the property address") {

      Given("Ratepayer logins through one login")
      loginOl()

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

      Then("The ratepayer hits the CYA page")
      PropertyLinkingCYA.checkYourAnswer()

      Then("Clicks the change property address link")
      PropertyLinkingCYA.clickChangePropertyAddressLink()

      Then("Ratepayer is taken to the find a property page and searches for a property")
      FindAProperty.findProperty()
      FindAProperty.inputPostCode(postCode)

      Then("Ratepayer is taken to the search results page")
      PropertySearchResultPage.searchResult(postCode)

      Then("Ratepayer clicks the second 'Select property' on the search results page")
       val link = By.xpath("//*[@id=\"main-content\"]/div/div/div[2]/div/table/tbody/tr[2]/td[5]/a")
        waitForElementToBeClickable(link)

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
      PropertyLinkingCYA.checkYourAnswer()
      PropertyLinkingCYA.addressChangedCheck()
    }



  }
}
