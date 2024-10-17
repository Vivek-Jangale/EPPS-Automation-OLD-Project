package com.epps.common.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;


public class BaseClass 
{
	protected static WebDriver driver;	
	
	public static WebDriver chromeTest( WebDriver driver)
	{
		driver = driver;
		String os=System.getProperty("os.name").toLowerCase();
			
		if(os.equalsIgnoreCase("linux")) {
			System.setProperty("webdriver.chrome.driver","/home/share/EPPS_AUTO_TEST/chromedriver");
		}else {
			System.setProperty("webdriver.chrome.driver","C:/EPPS_AUTO_TEST/chromedriver.exe");
		}
		
/*		System.setProperty("webdriver.chrome.driver","D:/WorkspacesAutoSmartERP/epps-test/test-driver/chromedriver.exe");
		Scanner s=new Scanner(System.in);
		System.out.println("Please Enter Chrome Driver path : ");
		String path=s.nextLine();
		System.setProperty("webdriver.chrome.driver",path);*/
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");

		 Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);		
		options.setExperimentalOption("prefs", prefs);

		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(capabilities); 
		return driver;
	}
	
	public static WebDriver IETest( WebDriver driver)
	{
		driver = driver;
		System.setProperty("webdriver.chrome.driver","C:/Users/Atik Pathan/Desktop/epps-selenium(Backup)/Explorer-drivers/IEDriverServer.exe");
		 driver = new ChromeDriver();	
		 return driver;
	}
	

}
