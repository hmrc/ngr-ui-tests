package uk.gov.hmrc.ui.pages.Physical

import uk.gov.hmrc.ui.pages.BasePage

object SupportingDocuments extends BasePage {

  def supportingDocumentsHeader(): Unit =
    headerCheck("Supporting documents")
}
