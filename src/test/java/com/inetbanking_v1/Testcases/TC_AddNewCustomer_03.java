package com.inetbanking_v1.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking_v1.pageobjects.AddNewCustomerpage;
import com.inetbanking_v1.pageobjects.Loginpage;

public class TC_AddNewCustomer_03 extends Baseclass{
	
	@Test
	public void AddNewCustomer()
	{
		Loginpage lp = new Loginpage(driver);
		lp.VerifyLoginPage(Expectedtitle);
		logger.info("Try to Login to Application");
		lp.Login(username, password);
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
		
		AddNewCustomerpage addcust = new AddNewCustomerpage(driver);
		logger.info("click on New Customer link");
		addcust.ClickNewCustomer();
		addcust.CustomerName("pinkyhacchi");
		addcust.GenderRadiobutton("female");
		addcust.CDateofBirth("29", "12", "1986");
		addcust.custaddress("Hosakerehallicross");
		addcust.custcity("bengaluru");
		addcust.custstate("karnataka");
		addcust.custpin("560032");
		addcust.custtelephone("9060646151");
		addcust.custemail("pinkyhacchi@gmail.com");
		addcust.custpassword("hacchipinky");
		addcust.clicksubmit();
	}

}
