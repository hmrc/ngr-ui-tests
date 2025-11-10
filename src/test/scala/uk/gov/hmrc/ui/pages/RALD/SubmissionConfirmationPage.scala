package uk.gov.hmrc.ui.pages.RALD

import uk.gov.hmrc.ui.pages.BasePage

object SubmissionConfirmationPage extends BasePage {

  def declarationHeader(): Unit =
    headerCheck("Renewed agreement details sent")

  def checkReferenceNumber(expectedRef: String): Unit = {
    val actualRef = getElementByCssSelector("#main-content > div > div.govuk-grid-column-two-thirds > form > div > div")
    assert(
      actualRef == expectedRef,
      "Reference number is not correct"
    )
  }

}
