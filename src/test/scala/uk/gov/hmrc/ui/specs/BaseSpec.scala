/*
 * Copyright 2023 HM Revenue & Customs
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

import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.matchers.should.Matchers
import org.scalatest.{BeforeAndAfterEach, GivenWhenThen}
import uk.gov.hmrc.selenium.webdriver.{Browser, Driver, ScreenshotOnFailure}

trait BaseSpec
    extends AnyFeatureSpec
    with GivenWhenThen
    with Matchers
    with BeforeAndAfterEach
    with Browser
    with ScreenshotOnFailure {

  override def beforeEach(): Unit = {
    startBrowser()
    Driver.instance.manage().deleteAllCookies()
  }
  override def afterEach(): Unit  =
    quitBrowser()
}
