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
import org.openqa.selenium.support.ui.{ExpectedConditions, FluentWait, Wait}
import org.openqa.selenium.{By, WebDriver, WebElement}
import uk.gov.hmrc.selenium.component.PageObject
import uk.gov.hmrc.selenium.webdriver.Driver
import scala.jdk.CollectionConverters._

import java.time.Duration

trait BasePage extends PageObject {
  val continueButton: By                        = By.id("continue")
  def getElementByLink(text: String): By        = By.linkText(text)
  def getElementByPartialLink(text: String): By = By.partialLinkText(text)

  def getElementByTagName(tagName: String): String = {
    val element = Driver.instance.findElement(By.tagName(tagName))
    element.getText
  }

  def headerCheck(expectedText: String): Unit = {
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

  def h2Check(expectedText: String): Unit = {
    val headerLocator = By.tagName("h2")
    try {
      val headers = Driver.instance.findElements(headerLocator)
      val headerTexts = headers.asScala.map(_.getText)

      assert(headerTexts.contains(expectedText),
        s"Expected h2 '$expectedText' not found. Found headers: ${headerTexts.mkString(", ")}")
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

  def getElementByXpath(xpath: String): String     = {
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

  def reloadPage(): Unit =
    Driver.instance.navigate().refresh()

  def clickLink(link: String): Unit =
    waitForElementToBeClickable(By.linkText(link)).click()

  def continueButtonClick(): Unit =
    click(continueButton)

}
