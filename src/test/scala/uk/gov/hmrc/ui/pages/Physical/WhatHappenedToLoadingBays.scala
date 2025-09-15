package uk.gov.hmrc.ui.pages.Physical

import uk.gov.hmrc.ui.pages.BasePage

object WhatHappenedToLoadingBays extends BasePage {

  def whatHappenedToLoadingBaysHeader(): Unit =
    headerCheck("What has happened to loading bays?")

  def whatHappenedToLoadingBaysRadio(loadingBays: String): Unit = {
    val radioCheckId = loadingBays match {
      case "You added loading bays"        => "value_0"
      case "You removed some loading bays" => "value_1"
      case "You removed all loading bays"  => "value_2"
    }
    click(getElementById(radioCheckId))
  }

}
