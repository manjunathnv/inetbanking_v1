package com.justpractice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Brokenlinks {

	public static void main(String[] args) throws IOException {
		

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();
		List<WebElement> links = driver.findElements(By.tagName("a"));
		int brokenlinks=0;
		for(WebElement element:links)
		{
			String url = element.getAttribute("href");
			
			if(url==null || url.isEmpty())
			{
				System.out.println("url is empty");
				continue;
			}
			
			URL link = new URL(url);
			HttpURLConnection httpconn=(HttpURLConnection) link.openConnection();
			httpconn.connect();
			if(httpconn.getResponseCode()>=400)
			{
				System.out.println(httpconn.getResponseCode()+url+" is" + "Broken Links");
				brokenlinks++;
			}
			else
			{
				System.out.println(httpconn.getResponseCode()+url+" is" + "valid Links");
			}
		}
		System.out.println("no of broken links" + brokenlinks);
		driver.quit();

	}

}
