package Pages.AmazonPageObejctModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	static WebDriver driver;
//Goto menu	
	@FindBy(id="nav-hamburger-menu")
	private WebElement menu;
//Navigate to Mobile category
	@FindBy(xpath="//*[@id=\"hmenu-content\"]/ul[1]/li[10]/a/div")
	private WebElement categoryMNC;
	@FindBy(xpath="//*[@id=\"hmenu-content\"]/ul[8]/li[3]/a")
	private WebElement SubcategoryMobile;
//Navigate to women's Fashion
	@FindBy(xpath="//*[@id=\"hmenu-content\"]/ul[1]/li[13]/a/div")
	private WebElement categoryWomen;
	@FindBy(xpath="//*[@id=\"hmenu-content\"]/ul[11]/li[3]/a")
	private WebElement subcategoryCloth;
//signout amazon app
	@FindBy(xpath="//*[@id=\"hmenu-content\"]/ul[1]/li[30]/a")
	private WebElement signout;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	public void signOutAmazon() {
		signout.click();
	}
	public void selectMenu() {
		menu.click();
	}
	private void selectSubcategory() {
		subcategoryCloth.click();
	}

	private void clickCategory() {
		categoryWomen.click();
		
	}
   
	public void clickCategory1() {
		categoryMNC.click();
	}
	public void selectSubcategory1() {
		SubcategoryMobile.click();
	}
    public ProductPage selectWomenFashion() {
    	selectMenu();
    	clickCategory();
    	selectSubcategory();
    	ProductPage PPage=new ProductPage(driver);
		return PPage;
    }
    
    public ProductPage selectCategory() {
    	selectMenu();
    	clickCategory1();
    	selectSubcategory1();
    	ProductPage PPage=new ProductPage(driver);
		return PPage;
    }
    public void signOutFromAmazon() {
    		selectMenu();
    		signOutAmazon();
    }

}
