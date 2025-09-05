package uk.gov.hmrc.ui.pages.RALD

import org.openqa.selenium.By
import uk.gov.hmrc.ui.pages.BasePage
import uk.gov.hmrc.ui.pages.RALD.AgreementVerbal.headerCheck

object DidYouAgreeRentWithLandlordPage extends BasePage {

  def didYouAgreeRentWithLandlord(): Unit =
    headerCheck("Did you agree the rent with your landlord or their agent?")

  def didYouAgreeRentWithLandlordRadio(option:String):Unit ={
    val radioId = option.toLowerCase match {
      case "yes" => "agreement-breakClause-radio"
      case "no"  => "agreement-breakClause-radio-2"
    }
    click(By.id(radioId))
  }
}
