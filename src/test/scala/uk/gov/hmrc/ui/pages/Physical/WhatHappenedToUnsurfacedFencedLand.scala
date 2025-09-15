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
