package com.epps.wsms.test;

import java.awt.AWTException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

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

public class WSMSReport extends BaseClass {
	
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
		
			autoTestUtil.beforeMethod(ApplicationConstants.WARRANTY_MODULE);	
	}

   // @Test(priority = 0)
	public void testWarrantyAgreementPrint() throws Exception{

			Thread.sleep(2000);
			ParsingExcel userData = new ParsingExcel("testdata/WARRANTY-REPORTS.xlsx", "WarrantyAgreementPrint");
			autoTestUtil.performAction(userData);
	
    }
   // @Test(priority = 1)
	public void testInspectionReportingExportToExcel() throws Exception{

			Thread.sleep(2000);
			ParsingExcel userData = new ParsingExcel("testdata/WARRANTY-REPORTS.xlsx", "InspectionReportingExportToExcel");
			autoTestUtil.performAction(userData);
	
    }
	
	// @Test(priority = 2)
	 public void testWarrantyAgreementExportToExcelReport() throws Exception{

			Thread.sleep(2000);
			ParsingExcel userData = new ParsingExcel("testdata/WARRANTY-REPORTS.xlsx", "WarrantyAgreementExportToExcelReport");
			autoTestUtil.performAction(userData);
		
	}
	 
	 //@Test(priority = 3)
	 public void testInstallationUpdateExportToExcelReport() throws Exception{

			Thread.sleep(2000);
			ParsingExcel userData = new ParsingExcel("testdata/WSMS.xlsx", "InstallationUpdateExportToExcelReport");
			autoTestUtil.performAction(userData);
		
	}
	 
	 @Test(priority = 4)
	 public void testAssignedCallsForInspectionPrint() throws Exception{

			Thread.sleep(2000);
			ParsingExcel userData = new ParsingExcel("testdata/WSMS.xlsx", "AssignedCallsForInspectionPrint");
			autoTestUtil.performAction(userData);
		
	} 
	 
	// @Test(priority = 5)
	 public void testCallStatusReport() throws Exception{

			Thread.sleep(2000);
			ParsingExcel userData = new ParsingExcel("testdata/WSMS.xlsx", "CallStatusReport");
			autoTestUtil.performAction(userData);
		
	} 
	 
	// @Test(priority = 6)
	 public void testInspectionReportPrint() throws Exception{

			Thread.sleep(2000);
			ParsingExcel userData = new ParsingExcel("testdata/WSMS.xlsx", "InspectionReportPrint");
			autoTestUtil.performAction(userData);
		
	}  
	 
	// @Test(priority = 7)
	 public void testServiceInvoiceExportToExcel() throws Exception{

			Thread.sleep(2000);
			ParsingExcel userData = new ParsingExcel("testdata/WSMS.xlsx", "ServiceInvoiceExportToExcel");
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
