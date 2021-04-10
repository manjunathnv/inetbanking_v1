package com.inetbanking_v1.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomerpage 
{
	WebDriver driver;
	
	public AddNewCustomerpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='addcustomerpage.php']")
	private WebElement ClickNewCustomer;
	
	@FindBy(name="name")
	private WebElement CustomerName;
	
	@FindBy(name="rad1")
	private WebElement GenderRadiobutton;
	
	@FindBy(id="dob")
	private WebElement DateofBirth;
	
	@FindBy(xpath="//textarea[@name='addr']")
	private WebElement Address;
	
	@FindBy(name="city")
	private WebElement City;
	
	@FindBy(name="state")
	private WebElement State;
	
	@FindBy(name="pinno")
	private WebElement pinno;
	
	@FindBy(name="telephoneno")
	private WebElement telephoneno;
	
	@FindBy(name="emailid")
	private WebElement emailid;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement submitbtn;
	
	public void ClickNewCustomer()
	{
		ClickNewCustomer.click();
	}
	
	public void CustomerName(String cname)
	{
		CustomerName.sendKeys(cname);
	}
	
	public void GenderRadiobutton(String cgender)
	{
		GenderRadiobutton.click();   
	}
	
	public void CDateofBirth(String dd, String mm, String yyyy)
	{
		DateofBirth.sendKeys(dd);
		DateofBirth.sendKeys(mm);
		DateofBirth.sendKeys(yyyy);
	}
	
	public void custaddress(String caddr)
	{
		Address.sendKeys(caddr);
	}
	
	public void custcity(String ccity)
	{
		City.sendKeys(ccity);
	}
	
	public void custstate(String cstate)
	{
		State.sendKeys(cstate);
	}
	
	public void custpin(String cpin)
	{
		pinno.sendKeys(cpin);
	}
	
	public void custtelephone(String ctele)
	{
		telephoneno.sendKeys(ctele);
	}
	
	public void custemail(String cemail)
	{
		emailid.sendKeys(cemail);
	}
	
	public void custpassword(String cpwd)
	{
		password.sendKeys(cpwd);
	}
	
	public void clicksubmit()
	{
		submitbtn.click();
	}
}
