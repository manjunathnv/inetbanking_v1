package com.justpractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Keyboardactions {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.get("https://the-internet.herokuapp.com/key_presses");
		driver.get("https://text-compare.com/");
		driver.manage().window().maximize();
		
		WebElement src = driver.findElement(By.xpath("//textarea[@id='inputText1']"));
		WebElement dest = driver.findElement(By.xpath("//textarea[@id='inputText2']"));
		src.sendKeys("india is my country");
		
		Actions act = new Actions(driver);
		///src.sendKeys(Keys.CONTROL,"a");
		//src.sendKeys(Keys.CONTROL,"c");
		//dest.sendKeys(Keys.CONTROL,"v");
		
		//act.sendKeys(Keys.ENTER).perform();
		//act.sendKeys(Keys.CANCEL).perform();
		
		
		////or
		
		//CTRL+A
		
		act.keyDown(Keys.CONTROL);
		act.sendKeys("a");
		act.keyUp(Keys.CONTROL);
		act.perform();
		
		//CTRL+C
		
		act.keyDown(Keys.CONTROL);
		act.sendKeys("c");
		act.keyUp(Keys.CONTROL);
		act.perform();
		
		//tab to move to destination
		
		act.sendKeys(Keys.TAB).perform();
		
		//CTRL+v
		
		act.keyDown(Keys.CONTROL);
		act.sendKeys("v");
		act.keyUp(Keys.CONTROL);
		act.perform();
		
	
		
		

	}

}
