package com.epps.hrms.test;

import java.awt.AWTException;
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
import com.epps.bpm.test.BusinessPolicyManagement;
import com.epps.common.constant.ApplicationConstants;
import com.epps.common.util.AutoTestUtil;
import com.epps.common.util.BaseClass;

public class EmployeeSetupMaster extends BaseClass{
	
	Map<String, Object[]> testResults = new LinkedHashMap<String, Object[]>();
	static int i=0;
	AutoTestUtil autoTestUtil = new AutoTestUtil();

	@BeforeClass
	public void setUp() throws Exception {
		
		autoTestUtil.login();
		
	}
	
	@BeforeMethod
	public void selectModule() throws InterruptedException {
		
		autoTestUtil.beforeMethod(ApplicationConstants.HOME_BUTTON);
		autoTestUtil.beforeMethod(ApplicationConstants.HRMS_MODULE);
		
	}

	@Test(priority = 0)
	public void testQualificationMaster() throws Exception {
		
		Thread.sleep(2000);
		ParsingExcel userData = new ParsingExcel("testdata/HRMS-Master.xlsx", "QualificationMaster");
		autoTestUtil.performAction(userData);
	}
	@Test(priority = 1)
	public void testProfileMaster() throws Exception {
		
		Thread.sleep(2000);
		ParsingExcel userData = new ParsingExcel("testdata/HRMS-Master.xlsx", "ProfileMaster");
		autoTestUtil.performAction(userData);
	}
	
	@Test(priority = 2)
	public void testEmployeeMaster() throws Exception {
		
		Thread.sleep(2000);
		ParsingExcel userData = new ParsingExcel("testdata/HRMS-Master.xlsx", "EmployeeMaster");
		autoTestUtil.performAction(userData);
		BusinessPolicyManagement obj = new BusinessPolicyManagement();
		
	}
	
	@Test(priority = 3)
	public void testExportToExcelEmployeeMaster() throws Exception {
		Thread.sleep(2000);
		ParsingExcel userData = new ParsingExcel("testdata/HRMS-Master.xlsx", "ExportToExcelEmployeeMaster");
		autoTestUtil.performAction(userData);
	}
	
	@AfterMethod(alwaysRun = true)
	public void takeScreenShotOnFailure(ITestResult result)throws IOException, InterruptedException, AWTException {
	
			autoTestUtil.captureScreenshot(result);	
			Thread.sleep(100);
			driver.navigate().refresh();
			Thread.sleep(500);			
	}
	
	@AfterClass(alwaysRun = true)
	private void tearDown() throws InterruptedException {
		
		autoTestUtil.tearDownMethod();
	}	
	
}
