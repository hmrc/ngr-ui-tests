package uk.gov.hmrc.ui.pages.propertyLinking

import org.openqa.selenium.By
import uk.gov.hmrc.ui.pages.BasePage

import java.net.URLDecoder

object UploadBusinessRatesBill extends BasePage {

  val fileUploadButton: By        = By.id("file")

  def uploadBusinessRatesBill(): Unit =
    headerCheck("When did you become the current ratepayer?")

  def uploadFile(file: String): Unit = {
    val directory   = getClass.getResource(s"/testfiles/$file").toURI.toString.split("file:")
    val decodedPath = URLDecoder.decode(directory(1), "utf-8")
    find(fileUploadButton).sendKeys(decodedPath)
  }

  def fileUploadedCheck(file: String): Unit = {
    val display = getElementByXpath("//*[@id=\"main-content\"]/div/div/form/div/dl/div/dt/a")
    assert(file == display, "the file name is not present")
  }

}
