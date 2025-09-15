package uk.gov.hmrc.ui.pages.Physical

import uk.gov.hmrc.ui.pages.BasePage

object WhatHappenedToOutdoorSeating extends BasePage{

  def whatHappenedToOutdoorSeatingHeader(): Unit =
    headerCheck("What has happened to outdoor seating?")

  def whatHappenedToOutdoorSeatingRadio(outdoorSeating: String): Unit = {
    val radioCheckId = outdoorSeating match {
      case "You added outdoor seating"          => "value_0"
      case "You removed some outdoor seating"         => "value_1"
      case "You removed all outdoor seating" => "value_2"
    }
    click(getElementById(radioCheckId))
  }

}
