package Pages.AmazonPageObejctModel;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {
	static WebDriver driver;
	
//Mobile category	
	@FindBy(xpath="//input[@name=\"s-ref-checkbox-OnePlus\"]")
	private WebElement brand;
	@FindBy(xpath="//span[text()='Over ₹20,000']")
	private WebElement Price;
	@FindBy(xpath="//span[text()='OnePlus Nord 5G (Gray Onyx, 8GB RAM, 128GB Storage)']")
	private WebElement Product;
	@FindBy(xpath="//*[@id=\"a-autoid-17-announce\"]/div/div[1]/img")
	private WebElement color;
	
//Women Fashion 
	@FindBy(xpath="//input[@name='s-ref-checkbox-ANNI DESIGNER']")
	private WebElement wbrand;
	@FindBy(xpath="//*[@id=\"p_36/4595085031\"]/span/a/span")
	private WebElement Wprice;
	@FindBy(xpath="//*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[2]/div[2]/div/span/div/div/div[2]/div/span/a/div/img")
	private WebElement Wproduct;
	@FindBy(id="native_dropdown_selected_size_name")
	private WebElement Wsize;
	
//Common to	categories
	@FindBy(xpath="//*[@id=\"p_72/1318476031\"]/span/a/section/i")
	private WebElement Rating;
	@FindBy(id="add-to-cart-button")
	private WebElement addtocart;
	@FindBy(id="hlb-view-cart-announce")
	private WebElement gotocart;
	
	
	public ProductPage(WebDriver driver) {
		this.driver=driver;
	}
//Methods for women category	
	public void womenBrand() {
		wbrand.click();
	}
	public void womenPrice() {
		Wprice.click();
	}
	public void womenProduct() {
		Wproduct.click();
	}
	public void selectSize(int S) {
		Select drop=new Select(Wsize);
		drop.selectByIndex(S);
	}
	
//Methods for Mobile category	
	public void selectBrand() {
		brand.click();
	}
	
	public void selectPrice() {
		Price.click();
	}
	public void clickProduct() {
		Product.click();
	}
	public void selectColor() {
		color.click();
	}
	
//Methods common to both categories
	
	public void selectRating() {
		Rating.click();
	}	
	public void windowHandle() {
		String addToCart=driver.getWindowHandle();
		Set<String> window=driver.getWindowHandles();
		Iterator<String> iterator=window.iterator();
		while(iterator.hasNext()) {
			driver.switchTo().window(iterator.next());	
		}
		
	}
	
	
	public void addToCart() {
		addtocart.click();
	}
	public void goToCart() {
		gotocart.click();
	}
	
	public void cartPageScreenshot(String filename){
	File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	try {
		FileUtils.copyFile(screenshot, new File("D:/TestAutomation/AmazonPageObejctModel/Screenshots/"+filename+".jpg"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
//Workflow	for selecting particular product
	public CartPage selectClothes(String fname,int size) {
		womenBrand();
		selectRating();
		womenPrice();
		womenProduct();
		tabHandle();
		selectSize(size);
		addToCart();
		goToCart();
		cartPageScreenshot(fname);
		CartPage cpage = new CartPage(driver);
		return cpage ;
	}
	public CartPage selectMobile(String fname) {
		selectBrand();
		selectRating();
		selectPrice();
		clickProduct();
		tabHandle();
		selectColor();
		addToCart();
		goToCart();
		cartPageScreenshot(fname);
		return null;
	}
}
