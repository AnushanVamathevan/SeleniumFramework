package QA_Automation.SeleniumFramework;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class EndToEnd {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String product_Name="ZARA COAT 3";
		
		WebDriver driver=new ChromeDriver();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("alexalum@gmail.com");
		driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Admin@12345");
		driver.findElement(By.xpath("//input[@id='login']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

		List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
		WebElement product=products.stream().filter(s->s.findElement(By.cssSelector("b")).getText().equals(product_Name)).findFirst().orElse(null);
		WebElement addTocart=product.findElement(By.cssSelector(".card-body button:last-of-type"));
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()",addTocart);
		
		
		WebElement toast_message=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		System.out.println(toast_message.getText());
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		
		WebElement cart_click=driver.findElement(By.xpath("//ul//li[4]/button"));
		js.executeScript("arguments[0].click()", cart_click);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='cart']//h3")));
		List<WebElement> cartProducts=driver.findElements(By.xpath("//div[@class='cart']//h3"));
		//cartProducts.stream().filter(s->s.getText().equalsIgnoreCase(product_Name)).forEach(s->System.out.println(s));
		boolean match=cartProducts.stream().anyMatch(s->s.getText().equalsIgnoreCase(product_Name));
		Assert.assertTrue(match);
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'sub')]//button")));
		
		driver.findElement(By.xpath("//div[contains(@class,'sub')]//button")).click();
		
		
		driver.findElement(By.xpath("//div[@class='form-group']//input")).sendKeys("Ind");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[contains(@class,'ta-results')]//span")));
	List<WebElement> options=driver.findElements(By.xpath("//section[contains(@class,'ta-results')]//span"));
	for(int i=0;i<options.size();i++) {
		if(options.get(i).getText().equalsIgnoreCase("India")) {
			options.get(i).click();
			break;
		}
	}
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='actions']//a")));
	driver.findElement(By.xpath("//div[@class='actions']//a")).click();
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".hero-primary")));
	
	String confirmMessage =driver.findElement(By.cssSelector(".hero-primary")).getText();
	
	Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}

}
