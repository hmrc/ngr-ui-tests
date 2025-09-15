package uk.gov.hmrc.ui.pages.Physical

import uk.gov.hmrc.ui.pages.BasePage

object WhatHappenedToHardSurfacedOpenLand extends BasePage {

  def whatHappenedToHardSurfacedOpenLandHeader(): Unit =
    headerCheck("What has happened to hard-surfaced, open land?")

  def whatHappenedToHardSurfacedOpenLandRadio(hardSurfacedOpenLand: String): Unit = {
    val radioCheckId = hardSurfacedOpenLand match {
      case "You added hard-surfaced, open land"        => "value_0"
      case "You removed some hard-surfaced, open land" => "value_1"
      case "You removed all hard-surfaced, open land"  => "value_2"
    }
    click(getElementById(radioCheckId))
  }
}
