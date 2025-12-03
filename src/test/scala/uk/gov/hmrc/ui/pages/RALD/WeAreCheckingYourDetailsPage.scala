package uk.gov.hmrc.ui.pages.RALD

import uk.gov.hmrc.ui.pages.BasePage

object WeAreCheckingYourDetailsPage extends BasePage{

  def weAreCheckingYourDetails(): Unit =
    headerCheck("We are checking your details")
}
