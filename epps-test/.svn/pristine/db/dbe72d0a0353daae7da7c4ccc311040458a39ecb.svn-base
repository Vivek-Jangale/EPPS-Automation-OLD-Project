package com.epps.bpm.test;

import java.awt.AWTException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Driver;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

//import org.eclipse.jetty.server.Response.OutputType;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.epps.admin.test.ParsingExcel;
import com.epps.common.constant.ApplicationConstants;
import com.epps.common.util.AutoTestUtil;
import com.epps.common.util.BaseClass;
import com.gargoylesoftware.htmlunit.javascript.host.file.File;
//import com.google.common.base.Verify;
//import com.sun.jna.platform.FileUtils;
public class BusinessPolicyManagement extends BaseClass{

	Map<String, Object[]> testResults = new LinkedHashMap<String, Object[]>();
	AutoTestUtil autoTestUtil = new AutoTestUtil();
	int count = 1;
	WebElement element; 
	Actions action =null;
	
	@BeforeClass
	public void setUpBPM() throws Exception {
			
			autoTestUtil.login();	
	}

	@BeforeMethod
	public void selectModule() throws InterruptedException {
		
			autoTestUtil.beforeMethod(ApplicationConstants.HOME_BUTTON);
		
			autoTestUtil.beforeMethod(ApplicationConstants.BPM_MODULE);	
	}

	@Test(priority = 0)
	public void testCountryMaster() throws Exception{

			Thread.sleep(2000);
			ParsingExcel userData = new ParsingExcel("testdata/BPM.xlsx", "CountryMaster");
			autoTestUtil.performAction(userData);
	
	}
	
	@Test(priority = 1)
	public void testStateMaster() throws Exception {

			Thread.sleep(2000);
			ParsingExcel userData = new ParsingExcel("testdata/BPM.xlsx", "StateMaster");
			autoTestUtil.performAction(userData);
	}
	@Test(priority = 3)
	public void testCityMaster() throws Exception {
			
			Thread.sleep(2000);
			ParsingExcel userData = new ParsingExcel("testdata/BPM.xlsx", "CityMaster");
			autoTestUtil.performAction(userData);
	} 
	
	@Test(priority = 4)
	public void testPaymentTermMaster() throws Exception {
	
			Thread.sleep(2000);
			ParsingExcel userData = new ParsingExcel("testdata/BPM.xlsx", "PaymentTermMaster");
			autoTestUtil.performAction(userData);
	}
		
	@Test(priority = 5)
	public void testDepartmentMaster() throws Exception {
	
			Thread.sleep(2000);
			ParsingExcel userData = new ParsingExcel("testdata/BPM.xlsx", "DepartmentMaster");
			autoTestUtil.performAction(userData);
	}
	@Test(priority = 6)
	public void testLocationMaster() throws Exception {
		
			Thread.sleep(2000);
			ParsingExcel userData = new ParsingExcel("testdata/BPM.xlsx", "LocationMaster");
			autoTestUtil.performAction(userData);
	} 
	
	@Test(priority = 7)
	public void testDivisionMaster() throws Exception {
	
			Thread.sleep(2000);
			ParsingExcel userData = new ParsingExcel("testdata/BPM.xlsx", "DivisionMaster");
			autoTestUtil.performAction(userData);
	} 
			
	@Test(priority = 8)
	public void testFinancialYearMaster() throws Exception {
			
			Thread.sleep(2000);
			ParsingExcel userData = new ParsingExcel("testdata/BPM.xlsx", "FinancialYearMaster");
			autoTestUtil.performAction(userData);
	} 
	
	@Test(priority = 9)
	public void testRoleMaster() throws Exception {
		
			Thread.sleep(2000);
			ParsingExcel userData = new ParsingExcel("testdata/BPM.xlsx", "RoleMaster");
			autoTestUtil.performAction(userData);
	} 
	

	@Test(priority = 10)
	public void testCurrencyMaster() throws Exception {
		
			Thread.sleep(2000);
			ParsingExcel userData = new ParsingExcel("testdata/BPM.xlsx", "CurrencyMaster");
			autoTestUtil.performAction(userData);
	}
		
	@Test(priority = 11)
	public void testUnitofMeasurement() throws Exception {
			
			Thread.sleep(2000);
			ParsingExcel userData = new ParsingExcel("testdata/BPM.xlsx", "UnitofMeasurement");
			autoTestUtil.performAction(userData);	
	}	
						
	@Test(priority = 13)
	public void testCurrrencyRateMaster() throws Exception {
			
			Thread.sleep(2000);
			ParsingExcel userData = new ParsingExcel("testdata/BPM.xlsx", "CurrrencyRateMaster");
			autoTestUtil.performAction(userData);		
	}

	
	@Test(priority = 14)
	public void testScreenwiseParameter() throws Exception {
			
			Thread.sleep(2000);
			ParsingExcel userData = new ParsingExcel("testdata/BPM.xlsx", "ScreenwiseParameter");
			autoTestUtil.performAction(userData);		
	}  
	
	@Test(priority = 15)
	public void testEmailServerProperties() throws Exception {
			
			Thread.sleep(2000);
			ParsingExcel userData = new ParsingExcel("testdata/BPM.xlsx", "EmailServerProperties");
			autoTestUtil.performAction(userData);		
	}
	
	@Test(priority = 16)
	public void testResetPassword() throws Exception {
			
			Thread.sleep(2000);
			ParsingExcel userData = new ParsingExcel("testdata/BPM.xlsx", "ResetPassword");
			autoTestUtil.performAction(userData);		
	} 

	@Test(priority = 17)
	public void testChangePassword() throws Exception {
		
			Thread.sleep(2000);
			ParsingExcel userData = new ParsingExcel("testdata/BPM.xlsx", "ChangePassword");
			autoTestUtil.performAction(userData);		
}
	
	@AfterMethod(alwaysRun = true)
	public void takeScreenShotOnFailure(ITestResult result)throws IOException, InterruptedException, AWTException {
	
			autoTestUtil.captureScreenshot(result);	
			Thread.sleep(100);
			driver.navigate().refresh();
			Thread.sleep(500);		
			
		    try
			 {
			    if(result.getStatus() == ITestResult.SUCCESS)
			    {
			        System.out.println("passed **********");
			    }

			    else if(result.getStatus() == ITestResult.FAILURE)
			    {
			        System.out.println("Failed ***********");
			    }

			     else if(result.getStatus() == ITestResult.SKIP ){

			        System.out.println("Skiped***********");

			    }
			}
			   catch(Exception e)
			   {
			     e.printStackTrace();
			   }
	}
	
	@AfterClass(alwaysRun = true)
	private void tearDown() throws InterruptedException {
		
		autoTestUtil.tearDownMethod();
	}	

}
