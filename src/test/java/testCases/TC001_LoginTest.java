package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.CheckOutPage;
import pageObjects.LandingPage;
import pageObjects.ProductCatalogue;
import pageObjects.ThankYouPage;
import testBase.BaseClass;

public class TC001_LoginTest extends BaseClass {
	
	String product_Name="ZARA COAT 3";
	
	@Test(priority=1)
	public void verifyLogin() {
		LandingPage lp=new LandingPage(driver);
		lp.sendEmail("alexalum@gmail.com");
		lp.sendPassword("Admin@12345");
		lp.clickLogin();
	}
	
	@Test(priority=2)
	public void getProductAndAddtoCart() {
		ProductCatalogue pc=new ProductCatalogue(driver);
		pc.getProductList();
		pc.addProductToCart(product_Name);
		pc.clickCart();
	}
	
	@Test(priority=3)
	public void clickOnCart() {
		CartPage cp=new CartPage(driver);
		cp.checkProductName(product_Name);
		cp.clickCheckOut();
	}
	
	@Test(priority=4)
	public void placeOrder() {
		CheckOutPage chepa=new CheckOutPage(driver);
		chepa.selectCountry();
		chepa.placeOrderClick();
	}
	
	@Test(priority=5)
	public void thanksOrder() {
		ThankYouPage typ=new ThankYouPage(driver);
		String message=typ.confirmationMsg();
		Assert.assertTrue(message.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}
	

}
