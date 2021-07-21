package com.justpractice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Handlebrowserwindows {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		//String wndid=driver.getWindowHandle(); ////return window id of the single browser window
		//System.out.println(wndid);
		
		driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click(); ///opens another browser window
		
		Set<String> windowsid = driver.getWindowHandles(); ///return id's of multiple windows
		
		//By using iterator() we can find the id's of all windows
		
		/*
		 * Iterator<String> it = windowsid.iterator(); String parentid=it.next(); String
		 * childid=it.next(); System.out.println(parentid); System.out.println(childid);
		 */
		///or by using List also we can do
		
		/*List<String> wndidlist = new ArrayList(windowsid);
		String parentid=wndidlist.get(0);
		String childid=wndidlist.get(1);
		System.out.println(parentid);
		System.out.println(childid);*/
		
		// how to switch other window using window id
		
		/*
		 * driver.switchTo().window(parentid); System.out.println("Parent window id:" +
		 * driver.getTitle());
		 * 
		 * driver.switchTo().window(childid); System.out.println("Parent window id:" +
		 * driver.getTitle());
		 */
		
		// For each loop
		
		for(String winids:windowsid)
		{
			String title =driver.switchTo().window(winids).getTitle();
			System.out.println(title);
		}


	}

}
