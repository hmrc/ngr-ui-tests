package uk.gov.hmrc.ui.pages.RALD

import org.openqa.selenium.By
import uk.gov.hmrc.ui.pages.BasePage
import uk.gov.hmrc.ui.pages.RALD.AgreementVerbal.sendKeys

object RentDatesAgreeStartPage extends BasePage {

  def rentDatesAgreeStartPage(): Unit =
    headerCheck("Rent dates")

  def agreeDateInput(day: String, month: String, year: String): Unit =
    dateInput(day, month, year, "agreedDate")

  def startDateInput(day: String, month: String, year: String): Unit =
    dateInput(day, month, year, "startPayingDate")

  private def dateInput(day: String, month: String, year: String, whichDate: String): Unit = {
    sendKeys(By.id(s"$whichDate.day"), day)
    sendKeys(By.id(s"$whichDate.month"), month)
    sendKeys(By.id(s"$whichDate.year"), year)
  }

}
