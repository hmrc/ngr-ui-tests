package uk.gov.hmrc.ui.pages.Physical

import uk.gov.hmrc.ui.pages.BasePage

object WhatHappenedToHardSurfacedFencedLand extends BasePage {

  def whatHappenedToHardSurfacedFencedLandHeader(): Unit =
    headerCheck("What has happened to hard-surfaced, fenced land?")

  def whatHappenedToHardSurfacedFencedLandRadio(hardSurfacedFencedLand: String): Unit = {
    val radioCheckId = hardSurfacedFencedLand match {
      case "You added hard-surfaced, fenced land"        => "value_0"
      case "You removed some hard-surfaced, fenced land" => "value_1"
      case "You removed all hard-surfaced, fenced land"  => "value_2"
    }
    click(getElementById(radioCheckId))
  }

}
