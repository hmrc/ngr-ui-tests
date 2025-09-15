package uk.gov.hmrc.ui.pages.Physical

import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions
import uk.gov.hmrc.selenium.webdriver.Driver
import uk.gov.hmrc.ui.pages.BasePage

object CheckAndConfirmChangesToExternalFeatures extends BasePage {
  def checkAndConfirmChangesToExternalFeaturesHeader(): Unit =
    headerCheck("Check and confirm changes to external features")

  def tellAnotherExternalFeatureRadio(anotherExternalFeature: String): Unit = {
    val radioCheckId = anotherExternalFeature match {
      case "Yes" => "value"
      case "No"  => "value-no"
    }
    click(getElementById(radioCheckId))
  }

  def verifyExternalSummaryItem(keyText: String, expectedValue: String): Unit = {
    Wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".govuk-summary-list")))
    Wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".govuk-summary-list__row")))
    val rows = Driver.instance.findElements(By.cssSelector(".govuk-summary-list__row"))

    var found    = false
    val iterator = rows.iterator()
    while (iterator.hasNext && !found) {
      val row        = iterator.next()
      val keyElement = row.findElement(By.cssSelector(".govuk-summary-list__key"))
      if (keyElement.getText.trim == keyText) {
        val valueElement = row.findElement(By.cssSelector(".govuk-summary-list__value"))
        val actualValue  = valueElement.getText.trim
        assert(
          actualValue == expectedValue,
          s"Expected value '$expectedValue' for '$keyText', but found '$actualValue'"
        )
        found = true
      }
    }

    if (!found) {
      throw new NoSuchElementException(s"Could not find summary row with key '$keyText'")
    }
  }

}
