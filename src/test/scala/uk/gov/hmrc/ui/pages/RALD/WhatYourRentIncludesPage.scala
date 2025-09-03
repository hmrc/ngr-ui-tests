package uk.gov.hmrc.ui.pages.RALD

import uk.gov.hmrc.ui.pages.BasePage
import uk.gov.hmrc.ui.pages.RALD.Landlord.headerCheck

object WhatYourRentIncludesPage extends BasePage {

  def whatYourRentIncludes(): Unit =
    headerCheck("Rent dates")

  def dayInput(input: String) = {

  }

  def monthInput(input:String) = {

  }

  def yearInput(input:String)

}
