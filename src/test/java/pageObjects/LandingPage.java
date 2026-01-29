package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends BasePage{

	public LandingPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath= "//input[@id='userEmail']")
	WebElement userEmail;
	
	@FindBy(xpath="//input[@id='userPassword']")
	WebElement userPassword;
	
	@FindBy(xpath="//input[@id='login']")
	WebElement submit;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	By eM=By.cssSelector("[class*='flyInOut']");
	
	public void sendEmail(String email) {
		userEmail.sendKeys(email);
	}
	
	public void sendPassword(String pass) {
		userPassword.sendKeys(pass);
	}
	public void clickLogin() {
		submit.click();
	}
	
	public String getErrorMessage() {
		waitForElementToAppear(eM);
		return errorMessage.getText();
	}
}
