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

package uk.gov.hmrc.ui.pages.propertyLinking

import uk.gov.hmrc.configuration.TestEnvironment
import uk.gov.hmrc.ui.pages.BasePage

object PropertyConnectionPage extends BasePage {

  private val connection_url: String = TestEnvironment.url("ngr-property-linking-frontend") + "/connection-to-property"

  def hitConnectionStep() =
    getUrl(connection_url)

  def propertyConnection(): Unit =
    headerCheck("What is your connection to the property?")

  def ownerRadio(): Unit = {
    click(getElementById("connection-to-property-radio"))
    click(continueButton)
  }

  def occupierRadio(): Unit = {
    click(getElementById("connection-to-property-radio-2"))
    click(continueButton)
  }

}
