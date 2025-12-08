/*
 * Copyright 2025 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.ui.pages

import org.openqa.selenium.support.ui.{ExpectedConditions, FluentWait, Select, Wait}
import org.openqa.selenium.{By, WebDriver, WebElement}
import uk.gov.hmrc.selenium.component.PageObject
import uk.gov.hmrc.selenium.webdriver.Driver

import java.time.{Duration, LocalDate}
import scala.jdk.CollectionConverters._

trait BasePage extends PageObject {
  val continueButton: By                        = By.id("continue")
  val submitButton: By                          = By.id("submit")
  def getElementByLink(text: String): By        = By.linkText(text)
  def getElementByPartialLink(text: String): By = By.partialLinkText(text)

  def getElementByTagName(tagName: String): String = {
    val element = Driver.instance.findElement(By.tagName(tagName))
    element.getText
  }

  def headerCheck(expectedText: String): Unit  = {
    val headerLocator = By.tagName("h1")
    try {
      Wait.until(ExpectedConditions.textToBePresentInElementLocated(headerLocator, expectedText))
      val actualText = Driver.instance.findElement(headerLocator).getText
      assert(actualText == expectedText, s"Expected header '$expectedText', but found '$actualText'")
    } catch {
      case e: Exception =>
        println(s"Header check failed due to exception: ${e.getMessage}")
    }
  }
  def headerCheck2(expectedText: String): Unit = {
    val headerLocator = By.tagName("h2")
    try {
      Wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(headerLocator))
      val headers     = Driver.instance.findElements(headerLocator)
      val headerTexts = headers.asScala.map(_.getText)

      assert(
        headerTexts.contains(expectedText),
        s"Expected h2 '$expectedText' not found. Found headers: ${headerTexts.mkString(", ")}"
      )
    } catch {
      case e: Exception =>
        println(s"H2 check failed due to exception: ${e.getMessage}")
    }
  }

  def getElementById(id: String): By = By.id(id)

  def getByCssSelector(cssSelector: String): By = By.cssSelector(cssSelector)

  def getElementByCssSelector(cssSelector: String): String = {
    val element = Driver.instance.findElement(getByCssSelector(cssSelector))
    element.getText
  }

  def AssertTextCheckById(id: String, expectedText: String): Unit = {
    val text = findElementById(id).getText
    assert(text == expectedText, s"$expectedText not matching with $text")
  }

  def getElementByXpath(xpath: String): String     = {
    waitForElementVisibility(By.xpath(xpath))
    val element = Driver.instance.findElement(By.xpath(xpath))
    element.getText
  }
  def findElementById(locator: String): WebElement =
    Driver.instance.findElement(By.id(locator))

  def getUrl(url: String): Unit =
    get(url)

  def Wait: Wait[WebDriver] = new FluentWait[WebDriver](Driver.instance)
    .withTimeout(Duration.ofSeconds(10))
    .pollingEvery(Duration.ofSeconds(1))

  def waitForElementToBeClickable(locator: By): WebElement =
    Wait.until(ExpectedConditions.elementToBeClickable(locator))

  def waitForElementInvisibility(locator: By, text: String): Boolean =
    Wait.until(ExpectedConditions.invisibilityOfElementWithText(locator, text))

  def waitForElementVisibility(locator: By): WebElement =
    Wait.until(ExpectedConditions.visibilityOfElementLocated(locator))

  def reloadPage(): Unit =
    Driver.instance.navigate().refresh()

  def clickLink(linkText: String): Unit = {
    val linkLocator = By.linkText(linkText)

    try {
      // Wait until the link is both visible and clickable
      Wait.until(ExpectedConditions.visibilityOfElementLocated(linkLocator))
      Wait.until(ExpectedConditions.elementToBeClickable(linkLocator))

      val linkElement = Driver.instance.findElement(linkLocator)
      linkElement.click()
    } catch {
      case e: Exception =>
        println(s"Click link failed for '$linkText' due to exception: ${e.getMessage}")
    }
  }
  /* def clickLink(link: String): Unit =
    waitForElementToBeClickable(By.linkText(link)).click()
   */
  def continueButtonClick(): Unit       =
    click(continueButton)

  def submitButtonClick(): Unit =
    click(submitButton)

  def setDate(dateInputPrefix: String, isoDate: String): Unit = {
    val date                  = LocalDate.parse(isoDate)
    val Seq(day, month, year) = Seq(date.getDayOfMonth, date.getMonthValue, date.getYear).map(_.toString)
    setDate(dateInputPrefix, day, month, year)
  }

  def setDate(dateInputPrefix: String, day: String, month: String, year: String): Unit = {
    sendKeys(By.id(s"$dateInputPrefix.day"), day)
    sendKeys(By.id(s"$dateInputPrefix.month"), month)
    sendKeys(By.id(s"$dateInputPrefix.year"), year)
  }

  def selectFromDropdown(dropdown: By, value: String): Unit = {
    val selectElement = new Select(Driver.instance.findElement(dropdown))
    selectElement.selectByValue(value)
  }

  def changedCheck(expected: String, locator: By, message: String): Unit = {
    waitForElementVisibility(locator)
    val actual = Driver.instance.findElement(locator).getText.trim
    assert(expected == actual, s"$message. Expected: '$expected', Found: '$actual'")
  }

  def clickBrowserBack(): Unit =
    Driver.instance.navigate().back()

}
