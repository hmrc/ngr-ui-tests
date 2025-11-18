package uk.gov.hmrc.ui.pages.RALD

import org.openqa.selenium.By
import uk.gov.hmrc.ui.pages.BasePage

object MoneyToTakeOnTheLeasePage extends BasePage {

  def moneyToTakeOnTheLease(): Unit =
    headerCheck("Money you got from the landlord or previous tenant to take on the lease")

  def moneyToTakeOnTheLeaseAmountInput(amount: String): Unit =
    sendKeys(By.id("amount"), amount)

  private def dateInput(day: String, month: String, year: String): Unit = {
    sendKeys(By.id("date.day"), day)
    sendKeys(By.id("date.month"), month)
    sendKeys(By.id("date.year"), year)
  }

  def moneyYouPaidInAdvanceToLandlordDateInput(day: String, month: String, year: String): Unit =
    dateInput(day, month, year)

}
