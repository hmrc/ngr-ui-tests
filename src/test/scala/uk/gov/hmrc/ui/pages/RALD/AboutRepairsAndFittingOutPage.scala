package uk.gov.hmrc.ui.pages.RALD

import org.openqa.selenium.By
import uk.gov.hmrc.ui.pages.BasePage

object AboutRepairsAndFittingOutPage extends BasePage {

  def verifyPageHeader(): Unit =
    headerCheck("About repairs and fitting out")

  def enterRepairCost(amount: String): Unit =
    sendKeys(By.id("cost"), amount)

  def enterRepairDate(month: String, year: String): Unit =
    dateInput(month, year, "date")

  private def dateInput(month: String, year: String, whichDate: String): Unit = {
    sendKeys(By.id(s"$whichDate.month"), month)
    sendKeys(By.id(s"$whichDate.year"), year)
  }

}
