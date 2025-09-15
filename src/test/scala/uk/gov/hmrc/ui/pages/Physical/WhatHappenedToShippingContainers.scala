package uk.gov.hmrc.ui.pages.Physical

import uk.gov.hmrc.ui.pages.BasePage

object WhatHappenedToShippingContainers extends BasePage {

  def whatHappenedToShippingContainersHeader(): Unit =
    headerCheck("What has happened to shipping containers?")

  def whatHappenedToShippingContainersRadio(shippingContainers: String): Unit = {
    val radioCheckId = shippingContainers match {
      case "You added shipping containers"        => "value_0"
      case "You removed some shipping containers" => "value_1"
      case "You removed all shipping containers"  => "value_2"
    }
    click(getElementById(radioCheckId))
  }

}
