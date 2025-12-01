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

import org.openqa.selenium.By

object DidYouGetIncentiveForNotTriggeringBreakClausePage extends BasePage {

  private val yesIGotALumpSumID         = By.id("Incentive")
  private val yesIGetARentFreePeriodID  = By.id("Incentive-2")
  private val noIDidNotGetAnIncentiveID = By.id("Incentive-4")

  def didYouGetIncentiveForNotTriggeringBreakClause(): Unit =
    headerCheck("Did you get incentive for not triggering the break clause?")

  def yesIGotALumpSum(): Unit =
    click(yesIGotALumpSumID)

  def yesIGetARentFreePeriod(): Unit =
    click(yesIGetARentFreePeriodID)

  def noIDidNotGetAnIncentive(): Unit =
    click(noIDidNotGetAnIncentiveID)
}
