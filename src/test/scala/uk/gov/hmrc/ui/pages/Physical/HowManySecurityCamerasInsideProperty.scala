package uk.gov.hmrc.ui.pages.Physical

import uk.gov.hmrc.ui.pages.BasePage
import org.openqa.selenium.By

object HowManySecurityCamerasInsideProperty extends BasePage {
  def howManySecurityCamerasInsidePropertyHeader(): Unit =
    headerCheck("How many security cameras are there inside the property?")

  val howManyCamerasID: By = By.id("value")

  def inputHowManyCameras(howManyCameras: String): Unit =
    sendKeys(howManyCamerasID, howManyCameras)
}
