package uk.gov.hmrc.ui.pages.Physical

import uk.gov.hmrc.ui.pages.BasePage

object WhatHappenedToCompressedAirSystems extends BasePage {
  def whatHappenedToCompressedAirSystemsHeader(): Unit =
    headerCheck("What has happened to compressed air systems?")

  def whatHappenedToCompressedAirSystemsRadio(compressedAirSystems: String): Unit = {
    val radioCheckId = compressedAirSystems match {
      case "You added compressed air systems"        => "value_0"
      case "You removed some compressed air systems" => "value_1"
      case "You removed all compressed air systems"  => "value_2"
    }
    click(getElementById(radioCheckId))
  }

}
