package com.epps.admin.test;

import static org.testng.AssertJUnit.assertEquals;
import org.testng.Assert;

import java.awt.AWTException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.epps.admin.test.ParsingExcel;
import com.epps.common.constant.ApplicationConstants;
import com.epps.common.util.AutoTestUtil;
import com.epps.common.util.BaseClass;
//import com.sun.tools.javac.util.Assert;

public class UploadOpeningDataMMS  extends BaseClass 
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
	public void UploadOpeningdata() throws Exception
	{
		Thread.sleep(2000);
		ParsingExcel userData = new ParsingExcel("testdata/ADMIN-Upload.xlsx", "Upload Opening data");
		autoTestUtil.performAction(userData);
		
		/*WebElement input = driver.findElement(By.xpath("//input[@class=\"select2-search__field\"]"));
		input.sendKeys("Stock Opening");
		input.sendKeys(Keys.ENTER);	
					
		driver.findElement(By.id("uploadOpeningDataFileId")).sendKeys("/home/epps/Applications/SMART-ERP-AUTOMATION/epps-test/testdata/UploadOpeningData/MMS-OPNG/STOCK OPENING/SingleItem Stock Opening/Stock Opening.xlsx");
		Thread.sleep(1000);
		driver.findElement(By.id("validateDataBtn")).click();
		Thread.sleep(1000);
		
		//String str = driver.findElement(By.id("validationStaus")).getText();
		//System.out.println(str);
		
		///Assert.assertionXpath("Data Successfully Validated !\n" + 
	  //"This data set can now be upload in the Application",driver.findElement(By.id("validationStaus")).getText());
		
		driver.findElement(By.id("uploadDataBtn")).click();
		
		String abc = driver.findElement(By.xpath("//*[@id=\"uploadedStaus\"]/b[1]")).getText();
		System.out.println(abc);
	    Assert.assertEquals("Successfully Uploaded : ", driver.findElement(By.xpath("//*[@id=\"uploadedStaus\"]/b[1]")).getText());
		*/
		
		

		
		Thread.sleep(1000);
		
					
	}
	

	
	
	@AfterMethod(alwaysRun = true)
	public void takeScreenShotOnFailure(ITestResult result)throws IOException, InterruptedException, AWTException 
	{
	
			autoTestUtil.captureScreenshot(result);	
			Thread.sleep(100);
			//driver.navigate().refresh();
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
	
	//@AfterClass(alwaysRun = true)
	private void tearDown() throws InterruptedException {
		
		autoTestUtil.tearDownMethod();
	}	


}
