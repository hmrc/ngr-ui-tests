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

import org.openqa.selenium.By
import uk.gov.hmrc.ui.pages.BasePage

import java.net.URLDecoder

object UploadBusinessRatesBill extends BasePage {

  val fileUploadButton = By.id("file")

  def uploadBusinessRatesBill(): Unit =
    headerCheck("Upload your business rates bill")

  def uploadFile(file: String): Unit =
    findElementById("file").sendKeys(System.getProperty("user.dir") + "/src/test/resources/testFiles/" + file)

  def fileUploadedCheck(file: String): Unit = {
    val display = getElementByXpath("//*[@id=\"main-content\"]/div/div/form/div/dl/div/dt/a")
    assert(file == display, "the file name is not present")
  }

}
