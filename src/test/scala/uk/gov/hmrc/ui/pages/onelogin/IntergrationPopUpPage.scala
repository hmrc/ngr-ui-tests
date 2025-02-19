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

package uk.gov.hmrc.ui.pages.onelogin
import uk.gov.hmrc.selenium.webdriver.Driver
import uk.gov.hmrc.ui.pages.BasePage
import org.openqa.selenium.Alert

object IntergrationPopUpPage extends BasePage {

  val signInUrl: String                                       = "https://integration-user:winter2021@signin.integration.account.gov.uk/sign-in-or-create"
  def signInToGDSIntegrationEnvironment(): Unit               =
    get(signInUrl)
  def integrationEnvLogin(username: String, password: String) = {
    val alert: Alert = Driver.instance.switchTo().alert()
    alert.sendKeys(username + "\t" + password)
    alert.accept()
  }

}
