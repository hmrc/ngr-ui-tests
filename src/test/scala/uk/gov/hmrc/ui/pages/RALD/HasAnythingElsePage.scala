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

object HasAnythingElsePage extends BasePage {

  val reasonLocator: By = By.id("reason")

  def hasAnythingElseAffectedTheRent(): Unit =
    headerCheck("Has anything else affected the rent?")

  def hasAffected(answer: String): Unit = {
    val radioId = answer.toLowerCase match {
      case "yes" => "hasAnythingElseAffectedTheRent"
      case _     => "hasAnythingElseAffectedTheRent-2"
    }
    click(getElementById(radioId))
  }

  def reasonDescription(reasonDesc: String): Unit =
    sendKeys(reasonLocator, reasonDesc)
}
