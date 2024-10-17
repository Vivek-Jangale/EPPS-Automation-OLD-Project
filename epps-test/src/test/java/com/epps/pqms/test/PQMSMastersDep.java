package com.epps.pqms.test;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

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

public class PQMSMastersDep extends BaseClass{
	
	Map<String, Object[]> testResults = new LinkedHashMap<String, Object[]>();
	static int i=0;
	AutoTestUtil autoTestUtil = new AutoTestUtil();
	int count = 1;

	@BeforeClass
	public void setUp() throws Exception {
		autoTestUtil.login();
	}
	
	@BeforeMethod
	public void selectModule() throws InterruptedException {
		
	
		autoTestUtil.beforeMethod(ApplicationConstants.HOME_BUTTON);		
		autoTestUtil.beforeMethod(ApplicationConstants.PQMS_MODULE);
		
	
		}
	
    // call for cost center heads & cost center head Location Link in FAS also separate process line master class
	// Also call cost center heads & cost center head Location Link will also require before the SBCD call
	@Test(priority = 0)
	public void testProcessingLineMaster() throws Exception {
		Thread.sleep(2000);
		ParsingExcel userData = new ParsingExcel("testdata/PQMS-Master.xlsx", "ProcessingLineMaster");
		autoTestUtil.performAction(userData);
	}
		
	@Test(priority = 1)
	public void testProcessLineTypeLink() throws Exception {
			Thread.sleep(2000);
			ParsingExcel userData = new ParsingExcel("testdata/PQMS-Master.xlsx", "ProcessLineTypeLink");
			autoTestUtil.performAction(userData);
	}	

	//Note: SBCT process will required first before 2 & 3 method
	
	@Test(priority = 2)
		public void testProductionMonthlyCostDtl() throws Exception {
			Thread.sleep(2000);
			ParsingExcel userData = new ParsingExcel("testdata/PQMS-Master.xlsx", "ProductionMonthlyCostDtl");
			autoTestUtil.performAction(userData);
		}	
				
	
	@Test(priority = 3)
		public void testBillOfMaterial() throws Exception {
			Thread.sleep(2000);
			ParsingExcel userData = new ParsingExcel("testdata/PQMS-Master.xlsx", "BillOfMaterial");
			autoTestUtil.performAction(userData);
		}
	@Test(priority = 4)
		public void testBOMLocationLink() throws Exception {
			Thread.sleep(2000);
			ParsingExcel userData = new ParsingExcel("testdata/PQMS-Master.xlsx", "BOMLocationLink");
			autoTestUtil.performAction(userData);
		}	
	
	
		@AfterMethod
		public void takeScreenShotOnFailure(ITestResult result)throws IOException, InterruptedException {
		
			autoTestUtil.captureScreenshot(result);	
			Thread.sleep(200);
			driver.navigate().refresh();
			Thread.sleep(1000);	
		
		}

		@AfterClass
		private void tearDown() throws InterruptedException {
			autoTestUtil.tearDownMethod();
		}	
		
}
