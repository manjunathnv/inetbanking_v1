package com.justpractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dynamicwebtable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.opencart.com/admin/index.php");
		driver.manage().window().maximize();
		WebElement uname = driver.findElement(By.name("username"));
		uname.clear();
		uname.sendKeys("demo");
		WebElement pwrd = driver.findElement(By.name("password"));
		pwrd.clear();
		pwrd.sendKeys("demo");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//a[contains(.,'Sales')]")).click();
		driver.findElement(By.xpath("//a[contains(.,'Orders')]")).click();
		
		/* Find total number of pages */
		
		String text = driver.findElement(By.xpath("//div[@class='col-sm-6 text-right']")).getText();
		System.out.println(text);
		int numberofpages = Integer.valueOf(text.substring(text.indexOf("(")+1, text.indexOf("Pages")-1));
		System.out.println(numberofpages);
		
		
		/* Find number of rows in each page */
		
		for(int p=1; p<=3; p++)
		{
			WebElement active_page=driver.findElement(By.xpath("//ul[@class='pagination']//li/span")); ///xpath to find the page which is active
			System.out.println("Active Page is: " + active_page.getText());
			active_page.click();
			
			int rows = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr")).size();
			System.out.println("number of rows:" + rows);
			
			/* Get values from particular column in a row */
			
			for(int r=1; r<=rows; r++)
			{
				String orderid = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[1]")).getText();
				String customername = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[2]")).getText();
				System.out.println(orderid+"	"+customername);
			}
			
			String pageno = Integer.toString(p+1);
			driver.findElement(By.xpath("//ul[@class='pagination']//li//a[text()='"+pageno+"']")).click();  /// to click on next page link
		}
		

	}

}
