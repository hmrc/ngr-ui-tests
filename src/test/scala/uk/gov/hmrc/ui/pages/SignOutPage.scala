package uk.gov.hmrc.ui.pages

object SignOutPage extends BasePage {

  def signOut(): Unit = {
    headerCheck("You have signed out")
  }


}
