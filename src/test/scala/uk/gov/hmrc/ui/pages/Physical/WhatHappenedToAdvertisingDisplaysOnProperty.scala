package uk.gov.hmrc.ui.pages.Physical

import uk.gov.hmrc.ui.pages.BasePage

object WhatHappenedToAdvertisingDisplaysOnProperty extends BasePage {

  def whatHappenedToAdvertisingDisplaysOnPropertyHeader(): Unit =
    headerCheck("What has happened to advertising displays on your property?")

  def whatHappenedToAdvertisingDisplaysOnPropertyRadio(advertisingDisplaysOnProperty: String): Unit = {
    val radioCheckId = advertisingDisplaysOnProperty match {
      case "You added advertising displays on your property"        => "value_0"
      case "You removed some advertising displays on your property" => "value_1"
      case "You removed all advertising displays on your property"  => "value_2"
    }
    click(getElementById(radioCheckId))
  }

}
