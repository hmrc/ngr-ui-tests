package uk.gov.hmrc.ui.pages

import org.openqa.selenium.By

object FindAProperty extends BasePage {

  val postCode          = By.id("postcode-value")
  val findAddressButton = By.id("continue")

  def findProperty(): Unit =
    headerCheck("Find a property")

  def noResultsFound(): Unit =
    headerCheck("No results found")

  def inputPostCode(code: String): Unit = {
    sendKeys(postCode, code)
    click(findAddressButton)
  }

}




Scenario("The user completes registration and navigates to the Add a property page") {

  Then("Ratepayer is now fully registered and is taken to the dashboard")
  DashboardHome.DashboardHome(contactName)
  Then("Ratepayer clicks the Add a Property link and is taken to the Add a Property page")
  clickLink("Add a property")
  AddAProperty.addAProperty()
  click(continueButton)

  Then("Ratepayer is taken to the What You Need page")
  WhatYouNeed.whatYouNeed()
  contactLinkDisplay()
  click(continueButton)

  Then("Rateplayer is taken to the seach a property page and searchs for a propety that does not exist")
  FindAProperty.findProperty()
  FindAProperty.inputPostCode("LS1 9LB")
  FindAProperty.noResultsFound()