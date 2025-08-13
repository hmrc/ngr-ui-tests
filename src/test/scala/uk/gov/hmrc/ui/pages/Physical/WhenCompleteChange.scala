package uk.gov.hmrc.ui.pages.Physical

import uk.gov.hmrc.ui.pages.BasePage
import org.openqa.selenium.By
import uk.gov.hmrc.ui.pages.RALD.AgreedRentChange.continueButtonClick
import uk.gov.hmrc.ui.pages.RALD.WhatIsRentBasedOnPage.{click, continueButton}
object WhenCompleteChange extends BasePage {

  def WhenCompleteChangeScreen(): Unit =
    headerCheck("When did you complete the change?")

  val dayInputLocation: By   = By.id("value.day")
  val monthInputLocation: By = By.id("value.month")
  val yearInputLocation: By  = By.id("value.year")

  def dateInput(day: String, month: String, year: String): Unit = {
    sendKeys(dayInputLocation, day)
    sendKeys(monthInputLocation, month)
    sendKeys(yearInputLocation, year)
    click(continueButton)
  }

}
