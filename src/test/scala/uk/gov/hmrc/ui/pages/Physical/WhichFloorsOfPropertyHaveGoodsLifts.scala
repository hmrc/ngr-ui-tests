package uk.gov.hmrc.ui.pages.Physical

import uk.gov.hmrc.ui.pages.BasePage

object WhichFloorsOfPropertyHaveGoodsLifts extends BasePage {
  def whichFloorsOfPropertyHaveGoodsLiftsHeader(): Unit =
    headerCheck("Which floors of the property have goods lifts?")

  def whichFloorsOfPropertyHaveGoodsLiftsRadio(goodsLiftsFloors: String): Unit = {
    val radioCheckId = goodsLiftsFloors match {
      case "All floors have goods lifts"          => "value_0"
      case "Some floors have goods lifts"         => "value_1"
      case "None of the property has goods lifts" => "value_2"
    }
    click(getElementById(radioCheckId))
  }
}
