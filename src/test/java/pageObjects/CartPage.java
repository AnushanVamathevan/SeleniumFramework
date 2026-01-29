package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CartPage extends BasePage{

	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//div[@class='cart']//h3")
	List<WebElement> cartProducts;
	
	@FindBy(xpath="//div[contains(@class,'sub')]//button")
	WebElement checkout;
	
	By cartP=By.xpath("//div[@class='cart']//h3");
	By button=By.xpath("//div[contains(@class,'sub')]//button");
	
	public boolean checkProductName(String product_Name) {
		waitForElementToAppear(cartP);
		boolean match=cartProducts.stream().anyMatch(s->s.getText().equalsIgnoreCase(product_Name));
		
		return match;
	}
	
	public void clickCheckOut() {
		waitForElementToAppear(button);
		checkout.click();
	}
}
