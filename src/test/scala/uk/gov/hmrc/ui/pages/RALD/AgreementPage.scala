package uk.gov.hmrc.ui.pages.RALD

import org.openqa.selenium.By
import uk.gov.hmrc.ui.pages.BasePage
import uk.gov.hmrc.ui.pages.RALD.WhatTypeOfAgreement.{click, continueButton, getElementById, headerCheck}

object AgreementPage extends BasePage {

  def TypeOfAgreement(): Unit =
    headerCheck("Agreement")

  def agreementEnterStartDateDay(day:String): Unit = {
    click(getElementById("agreementStartDate.day"))
    sendKeys(By.id("agreementStartDate.day"),day)
  }

  def agreementEnterStartDateMonth(month:String): Unit = {
    click(getElementById("agreementStartDate.month"))
    sendKeys(By.id("agreementStartDate.month"),month)
  }

  def agreementEnterStartDateYear(year:String): Unit = {
    click(getElementById("agreementStartDate.year"))
    sendKeys(By.id("agreementStartDate.year"),year)
  }

  def agreementOpenEndedRadioYes(): Unit = {
    click(getElementById("agreement-radio-openEnded"))
  }

  def agreementOpenEndedRadioNo(): Unit = {
    click(getElementById("agreement-radio-openEnded-2"))
  }

  def agreementOpenEndedDateDay(day:String): Unit = {
    click(getElementById("agreementEndDate.day"))
    sendKeys(By.id("agreementEndDate.day"),day)
  }

  def agreementOpenEndedDateMonth(month:String): Unit = {
    click(getElementById("agreementEndDate.month"))
    sendKeys(By.id("agreementEndDate.month"),month)
  }

  def agreementOpenEndedDateYear(year:String): Unit = {
    click(getElementById("agreementEndDate.year"))
    sendKeys(By.id("agreementEndDate.month"),year)
  }

  def agreementHaveABreakClauseRadioYes(): Unit = {
    click(getElementById("agreement-breakClause-radio"))
  }

  def agreementHaveABreakClauseRadioNo(): Unit = {
    click(getElementById("agreement-breakClause-radio-2"))
  }

  def agreementHaveABreakClauseReason(reason: String): Unit = {
    click(getElementById("about-break-clause"))
    sendKeys(By.id("about-break-clause"),reason)
  }
}
