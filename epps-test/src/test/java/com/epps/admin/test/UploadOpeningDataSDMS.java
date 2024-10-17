package com.epps.admin.test;

import java.awt.AWTException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

public class UploadOpeningDataSDMS  extends BaseClass 
{
	
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
			autoTestUtil.beforeMethod(ApplicationConstants.ADMIN_MODULE);
			
	}

	@Test(priority = 0)
	public void testSoUpload() throws Exception {
		Thread.sleep(1000);
		ParsingExcel userData = new ParsingExcel("testdata/ADMIN-SDMS-Upload.xlsx", "SalesOrder");
		autoTestUtil.performAction(userData);
	}
	@Test(priority = 1)
	public void testPriceBookUpload() throws Exception {

			Thread.sleep(2000);
			ParsingExcel userData = new ParsingExcel("testdata/ADMIN-Upload.xlsx", "PriceBook");
			autoTestUtil.performAction(userData);
	}
	@Test(priority = 2)
	public void testCustomerMasterUpload() throws Exception {
			
			Thread.sleep(2000);
			ParsingExcel userData = new ParsingExcel("testdata/ADMIN-Upload.xlsx", "CustomerMaster");
			autoTestUtil.performAction(userData);
	} 
	@Test(priority = 3)
	public void testDiscountMatrixUpload() throws Exception {

			Thread.sleep(2000);
			ParsingExcel userData = new ParsingExcel("testdata/ADMIN-Upload.xlsx", "DiscountMatrix");
			autoTestUtil.performAction(userData);
	}
	@Test(priority = 4)
	public void testInvoicePOSUpload() throws Exception {
	
			Thread.sleep(2000);
			ParsingExcel userData = new ParsingExcel("testdata/ADMIN-Upload.xlsx", "InvoicePOS");
			autoTestUtil.performAction(userData);
}
	@AfterMethod(alwaysRun = true)
	public void takeScreenShotOnFailure(ITestResult result)throws IOException, InterruptedException, AWTException 
	{
	
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
