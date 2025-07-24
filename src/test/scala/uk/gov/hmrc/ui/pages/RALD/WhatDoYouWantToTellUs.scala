package uk.gov.hmrc.ui.pages.RALD

import uk.gov.hmrc.ui.pages.BasePage

object WhatDoYouWantToTellUs extends BasePage{

  def WhatDoYouWantToTellUs(): Unit =
    headerCheck("What do you want to tell us?")
}
