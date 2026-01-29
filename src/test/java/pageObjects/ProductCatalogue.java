package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductCatalogue extends BasePage {

	public ProductCatalogue(WebDriver driver) {
		super(driver);
	}
	
	By productsListWait=By.cssSelector(".mb-3");
	By addtoCart=By.cssSelector(".card-body button:last-of-type");
	By toastContainer=By.id("toast-container");
	By animationCircle=By.cssSelector(".ng-animating");
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(xpath="//ul//li[3]//button")
	WebElement order;
	
	public List<WebElement>getProductList() {
		waitForElementToAppear(productsListWait);
		return products;
	}
	
	public WebElement getProductByName(String productName) {
		WebElement prod=getProductList().stream().filter(s->s.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	
	public void addProductToCart(String productName) {
		WebElement addTocart=getProductByName(productName).findElement(addtoCart);
		executorClick(addTocart);
		waitForElementToAppear(toastContainer);
		waitForElementToDisAppear(animationCircle);
	}
	
	public void clickOrder() {
		order.click();
	}
	
}
