package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrdersPage extends BasePage {

	public OrdersPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//tbody//tr//td[2]")
	List<WebElement> name;
	
	
	public Boolean verifyProductDisplay(String product_name) {
		
		Boolean match=name.stream().anyMatch(s->s.getText().equalsIgnoreCase(product_name));
		return match;
	}
}

