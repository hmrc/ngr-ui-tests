package uk.gov.hmrc.ui.pages.Physical

import uk.gov.hmrc.ui.pages.BasePage

object WhatHappenedToParking extends BasePage {
  def whatHappenedToParkingHeader(): Unit =
    headerCheck("What has happened to parking?")

  def whatHappenedToParkingRadio(parking: String): Unit = {
    val radioCheckId = parking match {
      case "You added parking"        => "value_0"
      case "You removed some parking" => "value_1"
      case "You removed all parking"  => "value_2"
    }
    click(getElementById(radioCheckId))
  }
}
