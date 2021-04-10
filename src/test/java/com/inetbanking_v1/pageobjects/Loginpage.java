package com.inetbanking_v1.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Loginpage {
	
	WebDriver driver;
	
	public Loginpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="uid")
	private WebElement UserIDText;
	
	@FindBy(name="password")
	private WebElement PasswordText;
	
	@FindBy(name="btnLogin")
	private WebElement LoginBtn;
	
	@FindBy(xpath="//a[@href='Logout.php']")
	private WebElement Logoutlink;
	
	public void VerifyLoginPage(String Expectedtitle)
	{
		String actualtitle=driver.getTitle();
		Assert.assertEquals(actualtitle, Expectedtitle);
	
	}
	
	public void Login(String username, String password)
	{
		UserIDText.clear();
		UserIDText.sendKeys(username);
		PasswordText.sendKeys(password);
		LoginBtn.click();
	}
	
	public void ClickLogoutLink()
	{
		Logoutlink.click();
	}

}
