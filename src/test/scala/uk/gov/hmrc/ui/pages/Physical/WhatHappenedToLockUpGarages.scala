package uk.gov.hmrc.ui.pages.Physical

import uk.gov.hmrc.ui.pages.BasePage

object WhatHappenedToLockUpGarages extends BasePage {

  def whatHappenedToLockUpGaragesHeader(): Unit =
    headerCheck("What has happened to lockup garages?")

  def whatHappenedToLockUpGaragesRadio(lockUpGarages: String): Unit = {
    val radioCheckId = lockUpGarages match {
      case "You added lockup garages"        => "value_0"
      case "You removed some lockup garages" => "value_1"
      case "You removed all lockup garages"  => "value_2"
    }
    click(getElementById(radioCheckId))
  }

}
