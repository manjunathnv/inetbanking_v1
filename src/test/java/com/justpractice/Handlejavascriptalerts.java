package com.justpractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Handlejavascriptalerts {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		// For alert with one OK button
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]")).click();
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
		
		// For alert window with 2 buttons, OK and Cancel
		
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]")).click();
		Thread.sleep(5000);
		driver.switchTo().alert().dismiss();
		
		//For alert window with input text box and ok and cancel button and capture text from the alert
		
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]")).click();
		Thread.sleep(5000);
		Alert alertwindow=driver.switchTo().alert();
		System.out.println("the message in alert window is: " + alertwindow.getText());
		alertwindow.sendKeys("i love you");
		alertwindow.accept();
		
	}

}
