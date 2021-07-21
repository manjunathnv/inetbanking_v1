package com.justpractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Jquerydropdown {
	
	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.manage().window().maximize();
		driver.findElement(By.id("justAnInputBox")).click();
		
		//selectchoicevalue(driver,"choice 1");
		
		//selectchoicevalue(driver,"choice 1","choice 2","choice 2 3","choice 6 2 1");
		
		selectchoicevalue(driver,"all");
		
	}
	
	
	public static void selectchoicevalue(WebDriver driver, String... value) ///* String... can hold one value, multiple value, all values
	
	{
		
		List<WebElement> choicelist=driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));
		
		
		
		if(!value[0].equalsIgnoreCase("all"))  // check if the value contains one value or multiple values or all values
		{
			for(WebElement item:choicelist)
			{
				String text = item.getText(); ///in case of multiple values, this text variable contains many values
				
				for(String val:value)   // here val contains one of the values of value items
				{
					if(text.equals(val)) /// compare each value from text with the value from value items
					{
						item.click();
						break;
					}
				}
			}
		}
			else
				
			{
				try
				{
					for(WebElement item:choicelist)
					{
						item.click();
					}
				}
				
				catch(Exception e)
				{
					
				}
				
				
			}
		}
	}
	
