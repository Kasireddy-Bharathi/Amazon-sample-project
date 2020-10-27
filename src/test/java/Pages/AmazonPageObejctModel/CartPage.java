package Pages.AmazonPageObejctModel;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CartPage {
  static WebDriver driver;
  
  @FindBy(name="quantity")
  private WebElement quantity;
  @FindBy(xpath="//*[@id=\"nav-cart-count-container\"]/span[2]")
  private WebElement viewcart;
  
  public CartPage(WebDriver driver){
	  this.driver=driver;
  }
  
  public void viewCart() {
	  viewcart.click();
  }
  public void changeQuantity() {
	  Select qua=new Select(quantity);
	  qua.selectByIndex(2);
  }
  public void cartPageScreenshot() {
		File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File("D:/TestAutomation/AmazonPageObejctModel/Screenshots/Afterquantityupdated.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }
  
  public void viewCartPage() throws InterruptedException {
	  changeQuantity();
	  Thread.sleep(2000);
	  cartPageScreenshot();
	  
	  Thread.sleep(2000);
  }
  
  
  
  
}
