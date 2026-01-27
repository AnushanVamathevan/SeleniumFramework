package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ThankYouPage extends BasePage {
	
	public ThankYouPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css=".hero-primary")
	WebElement confirmMsg;
	
	
	public String confirmationMsg() {
		return confirmMsg.getText();
		
	}
	
	

	
	
}
