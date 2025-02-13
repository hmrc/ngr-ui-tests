package uk.gov.hmrc.ui.pages

object OneLoginPage extends BasePage{

  override val url: String = "https://signin.integration.account.gov.uk/enter-authenticator-app-code"

  /************ SignInSelector page *******************/
  def SignInSelectorOL(): Unit = {
    geElementByTagName("h1").contentEquals("Sign in to HMRC")
    click(getElementById("signInType"))


    click(continueButton)
  }

}
