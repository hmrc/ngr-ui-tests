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

package uk.gov.hmrc.ui.pages.RALD

import uk.gov.hmrc.ui.pages.BasePage

object WhatTypeOfAgreement extends BasePage {

  def TypeOfAgreement(): Unit =
    headerCheck("What type of agreement do you have?")

  def leaseOrTenancyRadio(): Unit =
    click(getElementById("what-type-of-agreement-radio")) /*used*/

  def writtenRadio(): Unit =
    click(getElementById("what-type-of-agreement-radio-2")) /*used*/

  def verbalRadio(): Unit =
    click(getElementById("what-type-of-agreement-radio-3"))
}
