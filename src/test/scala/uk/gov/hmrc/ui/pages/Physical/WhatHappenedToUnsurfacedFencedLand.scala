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

package uk.gov.hmrc.ui.pages.Physical

import uk.gov.hmrc.ui.pages.BasePage

object WhatHappenedToUnsurfacedFencedLand extends BasePage {

  def whatHappenedToUnsurfacedFencedLandHeader(): Unit =
    headerCheck("What has happened to unsurfaced, fenced land?")

  def whatHappenedToUnsurfacedFencedLandRadio(unsurfacedFencedLand: String): Unit = {
    val radioCheckId = unsurfacedFencedLand match {
      case "You added unsurfaced, fenced land"        => "value_0"
      case "You removed some unsurfaced, fenced land" => "value_1"
      case "You removed all unsurfaced, fenced land"  => "value_2"
    }
    click(getElementById(radioCheckId))
  }

}
