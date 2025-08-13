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
import org.openqa.selenium.By
import uk.gov.hmrc.ui.pages.RALD.WhatTypeOfAgreement.{click, continueButton}

object AboutChangeToUseOfSpace extends BasePage {

  def aboutTheChangeToUseOfSpace(): Unit =
    headerCheck("About the change to use of space")

  // How did you change the use of space? Checkbox options
  def selectUseOfSpace(UseOfSpace: String): Unit = {
    val checkId = UseOfSpace match {
      case "Rearranged the use of space in the property" => "selectUseOfSpace_0"
      case "Built an extension"                          => "selectUseOfSpace_1"
      case "Demolished part of the property"             => "selectUseOfSpace_2"
    }
    click(getElementById(checkId))
    click(continueButton)
  }

  // Did you get planning permission? Radio button selections

  val planningPermissionNumberInputLocation: By = By.id("permissionReference")

  def PlanningPermissionRadio(): Unit =
    click(getElementById("hasPlanningPermission"))

  def planningPermissionNumberInput(planningPermissionNumber: String): Unit = {
    sendKeys(planningPermissionNumberInputLocation, planningPermissionNumber)
    click(continueButton)
  }

  def NoPlanningPermissionRadio(): Unit = {
    click(getElementById("hasPlanningPermission-no"))
    click(continueButton)
  }

}
