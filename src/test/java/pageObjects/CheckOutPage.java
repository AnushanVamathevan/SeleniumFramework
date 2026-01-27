package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends BasePage {
	
	public CheckOutPage(WebDriver driver) {
		super(driver);
	}

	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement country;
	
	@FindBy(xpath="//section[contains(@class,'ta-results')]//span")
	List<WebElement> options;
	
	@FindBy(xpath="//div[@class='actions']//a")
	WebElement placeOrder;
	
	By cou=By.xpath("//section[contains(@class,'ta-results')]//span");
	By pl=By.xpath("//div[@class='actions']//a");
	
	public void selectCountry() {
		country.sendKeys("Ind");
		waitForElementToAppear(cou);

		for(int i=0;i<options.size();i++) {
			if(options.get(i).getText().equalsIgnoreCase("India")) {
				options.get(i).click();
				break;
			}
		}
		
	}
	
	public void placeOrderClick() {
		waitForElementToAppear(pl);
		placeOrder.click();
	}
}
