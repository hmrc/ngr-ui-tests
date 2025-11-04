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

package uk.gov.hmrc.ui.pages.PropertyLinking

import org.openqa.selenium.By
import uk.gov.hmrc.selenium.webdriver.Driver
import uk.gov.hmrc.ui.pages.BasePage

object PropertySearchResultPage extends BasePage {

  def searchResult(string: String): Unit =
    headerCheck("Search results for " + string)

  def selectProperty(): Unit =
    click(getElementByLink("Select Property"))

  def searchAgainUnderHelpLink(): Unit =
    click(By.xpath("//*[@id=\"help-if-you-cannot-find-your-property\"]/div/p[4]/a"))

  def clickHelpSpan(): Unit =
    click(By.xpath("//*[@id=\"help-if-you-cannot-find-your-property\"]/summary/span"))

  def selectSortOption(optionValue: String): Unit = {
    selectFromDropdown(getElementById("sortBy"), optionValue)
    click(continueButton)
  }

  def selectLink(text: String, index: Int): Unit = {
    val links   = Driver.instance.findElements(By.linkText(text))
    val element = links.get(index - 1)
    val locator = By.linkText(text)
    waitForElementToBeClickable(locator)
    element.click()
  }
}
