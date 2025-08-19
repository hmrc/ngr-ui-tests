package uk.gov.hmrc.ui.pages.Physical

import uk.gov.hmrc.ui.pages.BasePage

object HowMuchOfPropertyHasSprinklers extends BasePage {
  def howMuchOfPropertyHasSprinklersHeader(): Unit =
    headerCheck("How much of the property has sprinklers?")

  def howMuchOfPropertyHasSprinklersRadio(sprinklers: String): Unit = {
    val radioCheckId = sprinklers match {
      case "All of the property has sprinklers"  => "value_0"
      case "Some of the property has sprinklers" => "value_1"
      case "None of the property has sprinklers" => "value_2"
    }
    click(getElementById(radioCheckId))
  }
}
