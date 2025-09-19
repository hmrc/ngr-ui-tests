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

object WhatHappenedToShippingContainers extends BasePage {

  def whatHappenedToShippingContainersHeader(): Unit =
    headerCheck("What has happened to shipping containers?")

  def whatHappenedToShippingContainersRadio(shippingContainers: String): Unit = {
    val radioCheckId = shippingContainers match {
      case "You added shipping containers"        => "value_0"
      case "You removed some shipping containers" => "value_1"
      case "You removed all shipping containers"  => "value_2"
    }
    click(getElementById(radioCheckId))
  }

}
