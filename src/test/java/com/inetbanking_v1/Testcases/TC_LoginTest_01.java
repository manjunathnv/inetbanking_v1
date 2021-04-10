package com.inetbanking_v1.Testcases;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking_v1.pageobjects.Loginpage;

public class TC_LoginTest_01 extends Baseclass {
	
	@Test
	public void LoginTest()
	{
		Loginpage lp = new Loginpage(driver);
		lp.VerifyLoginPage(Expectedtitle);
		logger.info("login page is displayed");
		lp.Login(username, password);
		logger.info("username and password is entered and click on login button");
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("login test passed");
		}
		
		else
		{
			capturescreen(driver,"LoginTest");
			Assert.assertTrue(false);
			logger.info("login test failed");
		}
	}
	

}
