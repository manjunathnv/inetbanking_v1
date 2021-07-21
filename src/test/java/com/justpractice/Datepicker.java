package com.justpractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Datepicker {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		String year = "2021";
		String month = "July";
		String date = "10";
		
		driver.findElement(By.id("onward_cal")).click();  ///opens the date picker
		
		while(true)
		{
			String monthyear = driver.findElement(By.xpath("//td[@class='monthTitle']")).getText();  //captures month and year from the date picker
			
			String arr[] = monthyear.split(" ");
			String mon= arr[0];
			String yr = arr[1];
			
			if(mon.equalsIgnoreCase(month) && yr.equals(year))
			break;
			
		}

	}

}
