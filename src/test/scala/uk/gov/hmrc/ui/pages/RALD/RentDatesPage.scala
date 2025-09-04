package uk.gov.hmrc.ui.pages.RALD

import org.openqa.selenium.By
import uk.gov.hmrc.ui.pages.BasePage
import uk.gov.hmrc.ui.pages.RALD.RentDatesAgreeStartPage.sendKeys
import uk.gov.hmrc.ui.pages.RALD.RentFreePeriod.{click, getElementById, headerCheck}

object RentDatesPage extends BasePage {

  def rentDatesPage(): Unit =
    headerCheck("Rent Dates")

  def agreeDateInput(day: String, month: String, year: String): Unit =
    dateInput(day, month, year, "rentDatesAgreeInput")

  private def dateInput(day: String, month: String, year: String, whichDate: String): Unit = {
    sendKeys(By.id(s"$whichDate.day"), day)
    sendKeys(By.id(s"$whichDate.month"), month)
    sendKeys(By.id(s"$whichDate.year"), year)
  }
}
