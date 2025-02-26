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

package uk.gov.hmrc.ui.specs

import uk.gov.hmrc.ui.pages.onelogin.{OlAuthenticationPages, OlSignInSelectorPage}
import uk.gov.hmrc.ui.pages._

class ContactDetailsSpec extends BaseSpec with StubPage {

  private val StartNow         = StartNowPage
  private val OlSignInSelector = OlSignInSelectorPage
  private val OlAuthentication = OlAuthenticationPages
  private val env              = System.getProperty("environment")

  Feature("Authenticated ratepayer using OneLogin Changes Contact Details") {
    Scenario("Authenticate a ratepayer using OneLogin and change contact details") {
      Given("Ratepayer logins through one login")
      StartNow.startNow()
      OlSignInSelector.signInSelectorOL()
      if (env == "local" || env == "staging") {
        stubOlAuthentication()
      } else {
        OlAuthentication.olAuthentication("krutika.patil+11@digital.hmrc.gov.uk", "p2ssword1234")
      }
      Then("Ratepayer is taken to the Confirm Contact Details page")
      ConfirmContactDetailsPage.ConfirmContactDetails()
      Then("Clicks the name link")
      ConfirmContactDetailsPage.ClickNameLink()
      Then("Name the page is shown")
      ContactNamePage.ContactNameDetails()
      Then("The ratepayer enters their name and clicks continue")
      ContactNamePage.InputName()
      Then("The ratepayer is taken to the Confirm Contact Details page")
      ConfirmContactDetailsPage.ConfirmContactDetails()
      Then("Clicks the name link add phone number link")
      ConfirmContactDetailsPage.ClickAddPhoneNumberLink()
      Then("The ratepayer is taken to the Phone Number Page")
      PhoneNumberPage.PhoneNumberDetails()
      Then("The ratepayer adds their number and clicks continue")
      PhoneNumberPage.InputNumber()
    }

  }

}
