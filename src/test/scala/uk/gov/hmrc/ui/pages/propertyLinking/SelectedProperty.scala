package uk.gov.hmrc.ui.pages.propertyLinking

import uk.gov.hmrc.ui.pages.BasePage

object SelectedProperty extends BasePage {

  def selectedProperty(): Unit =
    headerCheck("Property selected")

  def yesRadio(): Unit = {
    click(getElementById("confirm-property-radio"))
  }

}
