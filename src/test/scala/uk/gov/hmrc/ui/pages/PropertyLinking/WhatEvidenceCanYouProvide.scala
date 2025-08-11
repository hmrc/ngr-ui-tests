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

import uk.gov.hmrc.ui.pages.BasePage

object WhatEvidenceCanYouProvide extends BasePage {

  def whatEvidenceCanYouProvide(): Unit =
    headerCheck("What evidence can you provide?")

  def selectEvidenceType(Type: String): Unit = {

    val radioId = Type match {

      case "Lease"                     => "upload-evidence-radio"
      case "Land Registry title"       => "upload-evidence-radio-2"
      case "Licence to occupy"         => "upload-evidence-radio-3"
      case "Service charges statement" => "upload-evidence-radio-4"
      case "Stamp Duty Land Tax form"  => "upload-evidence-radio-5"
      case "Utility bill"              => "upload-evidence-radio-6"
      case "Water rate demand"         => "upload-evidence-radio-7"
    }
    click(getElementById(radioId))
    continueButtonClick()
  }

}
