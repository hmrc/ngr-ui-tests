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

import uk.gov.hmrc.configuration.TestEnvironment
import uk.gov.hmrc.ui.pages.BasePage

object ConnectionToPropertyPage extends BasePage {

  def ConnectionToProperty() =
    headerCheck("What is your connection to the property?")

  def ConnectionType(Type: String): Unit = {
    val radioId = Type match {
      case "Owner"            => "connection-to-property-radio"
      case "Occupier"         => "connection-to-property-radio-2"
      case "OwnerAndOccupier" => "connection-to-property-radio-3"
    }
    click(getElementById(radioId))
    click(continueButton)
  }

  private val connection_url: String = TestEnvironment.url("ngr-property-linking-frontend") + "/connection-to-property"

  def hitConnectionStep() =
    getUrl(connection_url)
}
