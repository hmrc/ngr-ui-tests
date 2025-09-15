package uk.gov.hmrc.ui.pages.Physical

import uk.gov.hmrc.ui.pages.BasePage

object WhatHappenedToSolarPanels extends BasePage {

  def whatHappenedToSolarPanelsHeader(): Unit =
    headerCheck("What has happened to solar panels?")

  def whatHappenedToSolarPanelsRadio(solarPanels: String): Unit = {
    val radioCheckId = solarPanels match {
      case "You added solar panels"        => "value_0"
      case "You removed some solar panels" => "value_1"
      case "You removed all solar panels"  => "value_2"
    }
    click(getElementById(radioCheckId))
  }
}
