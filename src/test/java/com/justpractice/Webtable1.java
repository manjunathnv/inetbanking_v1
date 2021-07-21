package com.justpractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Webtable1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.selenium.dev/downloads/");
		driver.manage().window().maximize();
		
		/* How many rows in the table */
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='data-list']//tbody/tr"));
		int numberrows= rows.size();
		System.out.println("number of rows in the table is: " + numberrows);
		
		/* How many columns in the table */
		
		List<WebElement> columns = driver.findElements(By.xpath("//table[@class='data-list']//thead/tr/th"));
		int numbercolumns = columns.size();
		System.out.println("number of columns in the table is : " + numbercolumns);
		
		/*Retrieve data from specific row
		 */
		
		String value =driver.findElement(By.xpath("//table[@class='data-list']//tr[2]/td[1]")).getText();
		System.out.println("the value is : " + value);
		
		/* Retrieve data from all the rows and columns*/
		
		for(int r=1;r<=numberrows;r++)
			
		{
			for(int c=1;c<=numbercolumns;c++)
			{
				String data =driver.findElement(By.xpath("//table[@class='data-list']//tr["+r+"]/td["+c+"]")).getText();
				System.out.print(data + " ");
			}
			
			System.out.println();
		}
		
		/* Retrieve version number and release date from the java table row*/
		
		for(int r=1;r<=numberrows;r++)
		{
			String language =driver.findElement(By.xpath("//table[@class='data-list']//tr["+r+"]/td[1]")).getText();
			System.out.print(language);
			if(language.equals("Java"))
			{
				String version =driver.findElement(By.xpath("//table[@class='data-list']//tr["+r+"]/td[2]")).getText();
				String release =driver.findElement(By.xpath("//table[@class='data-list']//tr["+r+"]/td[3]")).getText();
				System.out.println(version + release);
			}
		}

	}

}
