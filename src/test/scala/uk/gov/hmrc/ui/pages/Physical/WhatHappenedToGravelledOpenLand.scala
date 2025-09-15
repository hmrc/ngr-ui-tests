package uk.gov.hmrc.ui.pages.Physical

import uk.gov.hmrc.ui.pages.BasePage

object WhatHappenedToGravelledOpenLand extends BasePage {

  def whatHappenedToGravelledOpenLandHeader(): Unit =
    headerCheck("What has happened to gravelled, open land?")

  def wwhatHappenedToGravelledOpenLandRadio(gravelledOpenLand: String): Unit = {
    val radioCheckId = gravelledOpenLand match {
      case "You added gravelled, open land"        => "value_0"
      case "You removed some gravelled, open land" => "value_1"
      case "You removed all gravelled, open land"  => "value_2"
    }
    click(getElementById(radioCheckId))
  }

}
