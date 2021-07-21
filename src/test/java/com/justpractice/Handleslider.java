package com.justpractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Handleslider {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().window().maximize();
		WebElement minslider = driver.findElement(By.xpath("//span[1]"));
		System.out.println(minslider.getLocation());  ////get the location of the minimum slider
		System.out.println(minslider.getSize());  //// Height and width of the element
		Actions act = new Actions(driver);
		act.dragAndDropBy(minslider, 108, 0).build().perform();  ////to drag and drop the slider(x axis and y axis) this doesnt has y axis
		System.out.println(minslider.getLocation());  ////get the location of the minimum slider
		System.out.println(minslider.getSize());  //// Height and width of the element
		
		WebElement maxslider = driver.findElement(By.xpath("//span[2]"));
		System.out.println(maxslider.getLocation());  ////get the location of the minimum slider
		System.out.println(maxslider.getSize());  
		act.dragAndDropBy(maxslider, -108, 0).build().perform();

		
	}

}
