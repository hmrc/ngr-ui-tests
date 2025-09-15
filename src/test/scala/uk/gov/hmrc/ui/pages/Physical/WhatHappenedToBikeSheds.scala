package uk.gov.hmrc.ui.pages.Physical

import uk.gov.hmrc.ui.pages.BasePage

object WhatHappenedToBikeSheds extends BasePage {

  def whatHappenedToBikeShedsHeader(): Unit =
    headerCheck("What has happened to bike sheds?")

  def whatHappenedToBikeShedsRadio(bikeSheds: String): Unit = {
    val radioCheckId = bikeSheds match {
      case "You added bike sheds"        => "value_0"
      case "You removed some bike sheds" => "value_1"
      case "You removed all bike sheds"  => "value_2"
    }
    click(getElementById(radioCheckId))
  }

}
