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

package uk.gov.hmrc.ui.pages.Physical

import org.openqa.selenium.By
import uk.gov.hmrc.ui.pages.BasePage

object AnythingElseTellUs extends BasePage {

  def anythingElseTellUsHeader(): Unit =
    headerCheck("Is there anything else you want to tell us about the changes?")

  def anythingElseTellUsRadio(anythingElseTellUs: String): Unit = {
    val radioCheckId = anythingElseTellUs match {
      case "Yes" => "value"
      case "No"  => "value-no"
    }
    click(getElementById(radioCheckId))
  }

  val textInputLocation: By = By.id("text")

  def AnythingElseTellUsTextInput(textInput: String): Unit = {
    click(textInputLocation)
    sendKeys(textInputLocation, textInput)
  }

}
