package com.inetbanking_v1.Testcases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking_v1.pageobjects.Loginpage;
import com.inetbanking_v1.utilities.XLUtils;

public class TC_LoginDD_02 extends Baseclass{
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String uname, String pword)
	{
		Loginpage lp = new Loginpage(driver);
		logger.info("Try login");
		lp.Login(uname, pword);	
		
		if(IsAlertPresent() == true)
		{
			
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.info("warning login failed");
			Assert.assertTrue(false);	
		}
		
		else
		{
			Assert.assertTrue(true);
			logger.info("login passed");
			lp.ClickLogoutLink();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	}

	public boolean IsAlertPresent() //user defined method to check if alert is present or not
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}
	
	@DataProvider(name="LoginData")
	String [][] getdata() throws IOException
	{
		String path = System.getProperty("user.dir") + "/src/test/java/com/inetbanking_v1/Testdata/LoginData.xlsx";
		int rownumber = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1",1);
		
		String logindata[][]=new String[rownumber][colcount];// Two dimensional array to store value which is read from the excel
		
		for(int i=1; i<=rownumber;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]= XLUtils.getCellData(path, "Sheet1", i, j);// as we are getting data from excel and storing in 2 dimentional array in excel sheet the row number 0 is header but in array there is no header so we use i-1 which is 0 in 2 dimentional array
			}
		}
		
		return logindata;
	}

}
