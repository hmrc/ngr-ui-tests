package uk.gov.hmrc.ui.pages

import org.openqa.selenium.By
import uk.gov.hmrc.ui.pages.BasePage

object DidYouGetIncentiveForNotTriggeringBreakClausePage extends BasePage {

  private val yesIGotALumpSumID = By.id("incentive_0")
  private val yesIGetARentFreePeriodID = By.id("incentive_1")
  private val noIDidNotGetAnIncentiveID = By.id("incentive_2")

  def didYouGetIncentiveForNotTriggeringBreakClause(): Unit =
    headerCheck("Did you get incentive for not triggering the break clause?")

  def yesIGotALumpSum(): Unit =
    click(yesIGotALumpSumID)

  def yesIGetARentFreePeriod(): Unit =
    click(yesIGetARentFreePeriodID)

  def noIDidNotGetAnIncentive(): Unit =
    click(noIDidNotGetAnIncentiveID)
}
