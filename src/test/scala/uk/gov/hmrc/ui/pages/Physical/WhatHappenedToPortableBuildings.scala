package uk.gov.hmrc.ui.pages.Physical

import uk.gov.hmrc.ui.pages.BasePage

object WhatHappenedToPortableBuildings extends BasePage{

  def whatHappenedToPortableBuildingsHeader(): Unit =
    headerCheck("What has happened to portable buildings?")

  def whatHappenedToPortableBuildingsRadio(portableBuildings: String): Unit = {
    val radioCheckId = portableBuildings match {
      case "You added portable buildings"          => "value_0"
      case "You removed some portable buildings"         => "value_1"
      case "You removed all portable buildings" => "value_2"
    }
    click(getElementById(radioCheckId))
  }

}
