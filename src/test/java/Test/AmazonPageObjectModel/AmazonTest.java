package Test.AmazonPageObjectModel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import Pages.AmazonPageObejctModel.HomePage;
import Pages.AmazonPageObejctModel.LoginPage;
import Pages.AmazonPageObejctModel.ProductPage;
import Pages.AmazonPageObejctModel.CartPage;

public class AmazonTest {
	
	static WebDriver driver;
	static String chromepath;
	String expected="";
	
	String actuals="";
	LoginPage lpage=null;
	HomePage hmpage=null;
	ProductPage ppage=null;
	CartPage cpage=null;
	
	@BeforeClass
	  public void init() {
		  
		  	chromepath = System.getProperty("user.dir") + "/lib/chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", chromepath);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://www.Amazon.in");
		  
	  }


	@Test (priority=1)
  public void loginTest() {
	    lpage = new LoginPage(driver);
		lpage = PageFactory.initElements(driver, LoginPage.class);
		lpage.validLogin("919032687092", "bharathi");
	    
  }
  
  @Test (priority=2)
  public void selectCategoryClothes() {
	    hmpage = new HomePage(driver);
	    hmpage = PageFactory.initElements(driver, HomePage.class);
	    hmpage.selectWomenFashion();
  }
  
  @Test (priority=3)
  public void selectProductClothes() {
	  ppage = new ProductPage(driver);
	  ppage = PageFactory.initElements(driver, ProductPage.class);
	  ppage.selectClothes("Fashion",2);
  }

  @Test (priority=4)
  public void viewCart() throws InterruptedException {
	  cpage = new CartPage(driver);
	  cpage = PageFactory.initElements(driver, CartPage.class);
	  cpage.viewCartPage();
  }

  @Test (priority=5)
  public void selectCategoryMobile() {
	    hmpage = new HomePage(driver);
	    hmpage = PageFactory.initElements(driver, HomePage.class);
	    hmpage.selectCategory();
	  
  }
 //@Ignore
  @Test (priority=6)
  public void selectProductMobile() {
	  ppage = new ProductPage(driver);
	  ppage = PageFactory.initElements(driver, ProductPage.class);
	  ppage.selectMobile("Mobile");
  }
  //@Ignore
  @Test (priority=7)
  public void signOutAndSignin() {
	  hmpage = new HomePage(driver);
	  hmpage=PageFactory.initElements(driver, HomePage.class);
	  hmpage.signOutFromAmazon();
	  lpage.enterusername("919032687092");
	  lpage.clickContinue();
	  lpage.enterpassword("bharathi");
	  lpage.clickLogin();
	  cpage.viewCart();
  }
}


