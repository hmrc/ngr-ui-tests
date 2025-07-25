package uk.gov.hmrc.ui.pages.RALD

import uk.gov.hmrc.ui.pages.BasePage

object WhichPropertyDoYouWantToTellUsAbout extends BasePage {

  def WhichPropertyDoYouWantToTellUsAbout(): Unit =
    headerCheck("Which property do you want to tell us about?")
}
