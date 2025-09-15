package uk.gov.hmrc.ui.pages.Physical

import uk.gov.hmrc.ui.pages.BasePage

object WhatHappenedToGravelledFencedLand extends BasePage{
  def whatHappenedToGravelledFencedLandHeader(): Unit =
    headerCheck("What has happened to gravelled, fenced land?")

  def whatHappenedToGravelledFencedLandRadio(gravelledFencedLand: String): Unit = {
    val radioCheckId = gravelledFencedLand match {
      case "You added gravelled, fenced land"          => "value_0"
      case "You removed some gravelled, fenced land"         => "value_1"
      case "You removed all gravelled, fenced land" => "value_2"
    }
    click(getElementById(radioCheckId))
  }

}
