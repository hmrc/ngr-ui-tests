package uk.gov.hmrc.ui.pages.propertyLinking

import uk.gov.hmrc.ui.pages.BasePage

object ConnectionToPropertyPage extends BasePage{


  def ConnectionToProperty() = {
    headerCheck("What is your connection to the property?")
  }

  def ConnectionType(Type :String): Unit = {
    val radioId = Type match {
      case "Owner" => "connection-to-property-radio"
      case "Occupier" => "connection-to-property-radio-2"
      case "OwnerAndOccupier" => "connection-to-property-radio-3"
    }
    click(getElementById(radioId))
  }
   click(continueButton)
}
