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

package uk.gov.hmrc.ui.specs.Review

import uk.gov.hmrc.ui.pages.StubPage
import uk.gov.hmrc.ui.pages.review.WhenThisPageTookPlaceSpec
import uk.gov.hmrc.ui.specs.BaseSpec
import uk.gov.hmrc.ui.utils.login.loginOl
import uk.gov.hmrc.ui.utils.mongo.ReviewDB

class ReviewSpec extends BaseSpec with StubPage {
  Feature("Testing the Review journey") {
    Scenario("The user is able update 'Do you know when this change took place' page") {
      ReviewDB.cleanup()
      Given("Ratepayer logins through one login")
      loginOl()

      When("The ratepayer loads the 'Do you know when this change took place' page")
      WhenThisPageTookPlaceSpec.renderThePageStep()
      WhenThisPageTookPlaceSpec.checkTheHeading()
      WhenThisPageTookPlaceSpec.selectRadioOption("Yes")
      WhenThisPageTookPlaceSpec.dateInput("20", "5", "2025")
      continueButtonClick()
    }
  }

}
