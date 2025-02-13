package uk.gov.hmrc.ui.pages



object GGPage extends BasePage {


  /************ SignInSelector page *******************/
  def SignInSelectorGG(): Unit = {
    geElementByTagName("h1").contentEquals("Sign in to HMRC")
    click(getElementById("signInType-2"))
    click(continueButton)
  }
}
