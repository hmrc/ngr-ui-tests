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

object DidYouGetMoneyFromLandlordPage extends BasePage {

  val didYouGetMoneyFromLandlordID: By = By.id("didYouGetMoneyFromLandlord-radio-value")

  def didYouGetMoneyFromLandlord(): Unit =
    headerCheck("Did you get any money from the landlord or previous tenant to take on the lease?")

  def didYouGetMoneyFromLandlordInput(didYouGetMoneyFromLandlord: String): Unit =
    sendKeys(didYouGetMoneyFromLandlordID, didYouGetMoneyFromLandlord)

  def yesRadio(): Unit =
    click(getElementById("didYouGetMoneyFromLandlord-radio-value"))

  def noRadio(): Unit =
    click(getElementById("didYouGetMoneyFromLandlord-radio-value-2"))

}
