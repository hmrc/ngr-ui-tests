package uk.gov.hmrc.ui.pages.Physical

import uk.gov.hmrc.ui.pages.BasePage
import org.openqa.selenium.By
import uk.gov.hmrc.ui.pages.RALD.WhatTypeOfAgreement.{click, continueButton}

object AboutChangeToUseOfSpace extends BasePage{

  def aboutTheChangeToUseOfSpace(): Unit =
    headerCheck("About the change to use of space")

  // How did you change the use of space? Checkbox options
  def rearrangedUseOfSpaceCheckbox(): Unit = {
    click(getElementById("selectUseOfSpace_0"))
  }

  def builtAnExtensionCheckbox(): Unit = {
    click(getElementById("selectUseOfSpace_1"))
  }

  def DemolishedPartOfPropertyCheckbox(): Unit = {
    click(getElementById("selectUseOfSpace_2"))
  }

  //Did you get planning permission? Radio button selections

  val planningPermissionNumberInputLocation: By       = By.id("permissionReference")

  def PlanningPermissionRadio(): Unit = {
    click(getElementById("hasPlanningPermission"))
  }

  def planningPermissionNumberInput(planningPermissionNumber: String): Unit = {
    sendKeys(planningPermissionNumberInputLocation, planningPermissionNumber)
    click(continueButton)
  }

  def NoPlanningPermissionRadio(): Unit = {
    click(getElementById("hasPlanningPermission-no"))
    click(continueButton)
  }


}
