/*
 * Copyright 2024 HM Revenue & Customs
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
import org.openqa.selenium.{By, WebElement}
import org.openqa.selenium.support.ui.Select
import uk.gov.hmrc.selenium.component.PageObject
import uk.gov.hmrc.selenium.webdriver.Driver

trait BasePage extends PageObject {
  val continueButton: By                        = By.id("continue")
  def getElementByLink(text: String): By        = By.linkText(text)
  def getElementByPartialLink(text: String): By = By.partialLinkText(text)

  def geElementByTagName(tagName: String): String = {
    val element = Driver.instance.findElement(By.tagName(tagName))
    element.getText
  }

  def headerCheck(headerText: String): Unit = {
    val elementText = geElementByTagName("h1")
    assert(elementText == headerText)
  }

  def getElementById(id: String): By = By.id(id)

  def getByCssSelector(cssSelector: String): By = By.cssSelector(cssSelector)

  def getElementByCssSelector(cssSelector: String): String = {
    val element = Driver.instance.findElement(getByCssSelector(cssSelector))
    element.getText
  }

  def findElement(locator: String): WebElement =
    Driver.instance.findElement(By.id(locator))

  def findDropDownElement(name: String, text: String): Unit = {
    val dropdownElement: WebElement = findElement(name)
    val select                      = new Select(dropdownElement)
    select.selectByVisibleText(text)
  }
  def getUrl(url: String): Unit                             =
    get(url)
}
