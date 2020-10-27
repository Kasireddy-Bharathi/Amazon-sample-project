package Pages.AmazonPageObejctModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;


public class LoginPage {
	
	@FindBy(id="ap_email")
	  private WebElement Username;
	 @FindBy(id="ap_password") 
	  private WebElement Password;
	 @FindBy(id="continue") 
	  private WebElement Continuebtn;
	 @FindBy(id="signInSubmit")
	  private WebElement Loginbtn;
	@FindBy(id="nav-link-accountList")
	  private WebElement Signin;
	  
	  static WebDriver driver;
	  
	  public LoginPage(WebDriver driver) {
		  this.driver=driver;
	  }
	  
	  public void clickSignin() {
		  Signin.click();
	  }
	  public void enterusername(String text) {
		  Username.sendKeys(text); 
	  }
	  
	  public void enterpassword(String text) {
		  Password.sendKeys(text);
	  }
	  
	  public void clickContinue() {
		  Continuebtn.click();
	  }
	  
	  public void clickLogin() {
		 Loginbtn.click();
	  }
	  
	  public HomePage validLogin(String uname, String pwd) {
		  clickSignin();
		  enterusername(uname);
		  clickContinue();
		  enterpassword(pwd);
		  clickLogin();
		  HomePage hmpage = new HomePage(driver);
		  return hmpage;
		  
		  
	  }
	
	  
	  
}

 
