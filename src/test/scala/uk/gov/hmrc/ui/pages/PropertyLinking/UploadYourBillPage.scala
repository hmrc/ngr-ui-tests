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

import org.openqa.selenium.WebElement
import uk.gov.hmrc.ui.pages.BasePage

import java.nio.file.Paths

object UploadYourBillPage extends BasePage {

  def uploadYourBillHeader(): Unit =
    headerCheck("Upload your business rates bill")

  def uploadYourBill(): Unit = {
    val absolutePath          = Paths.get("src/test/resources/UploadTestFiles/testFile.png").toAbsolutePath.toString
    val fileInput: WebElement = findElementById("file-input")
    fileInput.sendKeys(absolutePath)

    click(continueButton)
  }

}
