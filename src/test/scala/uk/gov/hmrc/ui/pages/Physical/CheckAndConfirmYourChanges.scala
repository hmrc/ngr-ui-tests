package uk.gov.hmrc.ui.pages.Physical

import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions
import uk.gov.hmrc.selenium.webdriver.Driver
import uk.gov.hmrc.ui.pages.BasePage
import scala.jdk.CollectionConverters._

object CheckAndConfirmYourChanges extends BasePage {

  def checkAndConfirmYourChangesHeader(): Unit =
    headerCheck("Check and confirm your changes")

  // Use this checkAndConfirmYourChangesH2 check function only when you added at least one feature for all of these below. The h2 title won't show if there is no feature in that section.
  def checkAndConfirmYourChangesH2(): Unit = {
    h2Check("Date of change")
    h2Check("Use of space")
    h2Check("Internal features")
    h2Check("External features")
    h2Check("Additional information")
    h2Check("Supporting documents")
  }

  def verifyAddedFeatureItems(keyText: String, expectedValue: String): Unit = {
    Wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".govuk-summary-list")))
    Wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".govuk-summary-list__row")))
    val rows = Driver.instance.findElements(By.cssSelector(".govuk-summary-list__row")).asScala

    val maybeRow = rows.find { row =>
      row.findElement(By.cssSelector(".govuk-summary-list__key")).getText.trim == keyText
    }

    maybeRow match {
      case Some(row) =>
        val actualValue = row.findElement(By.cssSelector(".govuk-summary-list__value")).getText.trim
        assert(
          actualValue == expectedValue,
          s"Expected value '$expectedValue' for '$keyText', but found '$actualValue'"
        )
      case None      =>
        throw new NoSuchElementException(s"Could not find summary row with key '$keyText'")
    }
  }
}
