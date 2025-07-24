package uk.gov.hmrc.ui.pages.dashboard

import uk.gov.hmrc.ui.pages.BasePage
import uk.gov.hmrc.ui.pages.propertyLinking.PropertySearchResultPage.{click, getElementByLink}

object SelectYourProperty extends BasePage {

  def SelectYourProperty(name: String): Unit =
    headerCheck(name)

  def selectProperty(): Unit =
    click(getElementByLink("Select Property"))

}
