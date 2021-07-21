package com.justpractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Autocompletegoogleplacesdropdown 
{

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.twoplugs.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[text()='Live Posting']")).click();
		WebElement Searchbox = driver.findElement(By.id("autocomplete"));
		Searchbox.clear();
		Searchbox.sendKeys("Toronto");
		String text;
		
		do
		{
			Searchbox.sendKeys(Keys.ARROW_DOWN);
			text=Searchbox.getAttribute("value");
			
			if(text.equals("Toronto, OH, USA"))
			{
				Searchbox.sendKeys(Keys.ENTER);
				break;
			}
			Thread.sleep(5000);
		}
		while(!text.isEmpty());
		
	}

}
