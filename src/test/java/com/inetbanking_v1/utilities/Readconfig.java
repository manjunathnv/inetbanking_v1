package com.inetbanking_v1.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Readconfig {
	
	Properties pro;
	
	public Readconfig()
	{
		File src = new File("./ConfigurationFiles\\config.properties");
		FileInputStream fis;
		try 
		{
			fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} 
		
		catch (FileNotFoundException e) 
		{
				// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}
	
		public String getApplicationURL()
		{
			String url=pro.getProperty("baseurl");
			return url;
		}
		
		public String getusername()
		{
			String username=pro.getProperty("username");
			return username;
		}
		
		public String getpassword()
		{
			String password=pro.getProperty("password");
			return password;
		}
		
		public String getExpectedTitle()
		{
			String ExpectedTitle=pro.getProperty("Expectedtitle");
			return ExpectedTitle;
		}
		
		public String getchromepath()
		{
			String chromepath=pro.getProperty("chromepath");
			return chromepath;
		}
		
		public String getFirefoxpath()
		{
			String Firefoxpath=pro.getProperty("Firefoxpath");
			return Firefoxpath;
		}
		
		
		
	}


