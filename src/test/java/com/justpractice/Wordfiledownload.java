package com.justpractice;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Wordfiledownload {

	public static void main(String[] args) {
		
		// To download files to a specific path(inside the framework structure
		
		String location =System.getProperty("user.dir")+"\\Downloads\\";
		
		///Chrome Browser
		
		HashMap preferences = new HashMap();
		preferences.put("download.default_directory", location);
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", preferences);
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://file-examples.com/index.php/sample-documents-download/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a[1]")).click();

	}

}
