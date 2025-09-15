package uk.gov.hmrc.ui.pages.Physical

import uk.gov.hmrc.ui.pages.BasePage

object WhatHappenedToUnsurfacedOpenLand extends BasePage {

  def whatHappenedToUnsurfacedOpenLandHeader(): Unit =
    headerCheck("What has happened to unsurfaced, open land?")

  def whatHappenedToUnsurfacedOpenLandRadio(unsurfacedOpenLand: String): Unit = {
    val radioCheckId = unsurfacedOpenLand match {
      case "You added unsurfaced, open land"        => "value_0"
      case "You removed some unsurfaced, open land" => "value_1"
      case "You removed all unsurfaced, open land"  => "value_2"
    }
    click(getElementById(radioCheckId))
  }

}
