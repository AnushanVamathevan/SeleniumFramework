package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import testBase.BaseClass;

public class TC002_ErrorValidations extends BaseClass {
	
	@Test
	public void submiOrder() {
		LandingPage lp=new LandingPage(driver);
		lp.sendEmail(p.getProperty("in_email"));
		lp.sendPassword(p.getProperty("in_pass"));
		lp.clickLogin();
		
		Assert.assertEquals(lp.getErrorMessage(),"Incorrect email or password.");
		
	}

}
