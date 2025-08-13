package uk.gov.hmrc.ui.pages.Physical

import uk.gov.hmrc.ui.pages.BasePage

object InformationAndSupportingDocumentsNeed extends BasePage {

  def InformationAndSupportingDocScreen(): Unit =
    headerCheck(" Information and supporting documents you need")
  click(continueButton)
}
