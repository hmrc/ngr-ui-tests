package uk.gov.hmrc.ui.pages.Physical

import uk.gov.hmrc.ui.pages.BasePage

object WhatHappenedToCanopies extends BasePage {

  def whatHappenedToCanopiesHeader(): Unit =
    headerCheck("What has happened to canopies?")

  def whatHappenedToCanopiesRadio(canopies: String): Unit = {
    val radioCheckId = canopies match {
      case "You added canopies"        => "value_0"
      case "You removed some canopies" => "value_1"
      case "You removed all canopies"  => "value_2"
    }
    click(getElementById(radioCheckId))
  }

}
