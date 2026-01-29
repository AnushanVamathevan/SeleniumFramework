package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.CheckOutPage;
import pageObjects.LandingPage;
import pageObjects.OrdersPage;
import pageObjects.ProductCatalogue;
import pageObjects.ThankYouPage;
import testBase.BaseClass;

public class TC001_LoginTest extends BaseClass {
	
	String product_Name="ZARA COAT 3";
	
	
	@Test(priority=1)
	public void verifyLogin() {
		LandingPage lp=new LandingPage(driver);
		lp.sendEmail(p.getProperty("email"));
		lp.sendPassword(p.getProperty("password"));
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
		boolean cart_avail=cp.checkProductName(product_Name);
		Assert.assertTrue(cart_avail);
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
	
	@Test(dependsOnMethods= {"thanksOrder"})
	public void orderHistoryTest() {
		ProductCatalogue pc1=new ProductCatalogue(driver);
		pc1.clickOrder();
		OrdersPage or=new OrdersPage(driver);
		Boolean match=or.verifyProductDisplay(product_Name);
		Assert.assertTrue(match);
		
	}

}
