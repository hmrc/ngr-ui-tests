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

package uk.gov.hmrc.ui.pages.RALD

import org.openqa.selenium.By
import uk.gov.hmrc.ui.pages.BasePage
import uk.gov.hmrc.ui.pages.RALD.Landlord.{click, getElementById, headerCheck}

object DidTheCourtSetTheInterimRent extends BasePage {

  val yesRadioButton = By.id("rent-interim-radio") /*Renewed agreement scenario: 1*/
  val noRadioButton  = By.id("rent-interim-radio-2")

  def rentInterim(): Unit =
    headerCheck("Did the court also set an interim rent?")

  def yesRadio(): Unit =
    click(yesRadioButton) /*used*/

  def noRadio(): Unit =
    click(noRadioButton) /*used*/
}
