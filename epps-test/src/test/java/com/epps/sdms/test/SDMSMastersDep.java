package com.epps.sdms.test;

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

public class SDMSMastersDep extends BaseClass {
	
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
		autoTestUtil.beforeMethod(ApplicationConstants.SDMS_MODULE);		
	
	}
	
	@Test(priority = 0)
	public void testBusinessZoneMaster() throws Exception {
		Thread.sleep(2000);
		ParsingExcel userData = new ParsingExcel("testdata/SDMS-Master.xlsx", "BusinessTerritoryMaster");
		autoTestUtil.performAction(userData);
	}	
	@Test(priority = 1)
	public void testCustomerMaster() throws Exception {
		Thread.sleep(2000);
		ParsingExcel userData = new ParsingExcel("testdata/SDMS-Master.xlsx", "CustomerMaster");
		autoTestUtil.performAction(userData);
	}
	@Test(priority = 2)
	public void testCustomerMasterExpMer() throws Exception {
		Thread.sleep(2000);
		ParsingExcel userData = new ParsingExcel("testdata/SDMS-Master.xlsx", "CustomerMasterExpMer");
		autoTestUtil.performAction(userData);
	}
	
	@Test(priority = 3)
	public void testProjectMaster() throws Exception {
		Thread.sleep(2000);
		ParsingExcel userData = new ParsingExcel("testdata/SDMS-Master.xlsx", "ProjectMaster");
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
