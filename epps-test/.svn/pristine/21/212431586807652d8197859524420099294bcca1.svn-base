package com.epps.bpm.test;

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

public class BusinessPolicyManagementDep extends BaseClass{
	
	Map<String, Object[]> testResults = new LinkedHashMap<String, Object[]>();
	AutoTestUtil autoTestUtil = new AutoTestUtil();
	int count = 1;
	@BeforeClass
	public void setUpBPM() throws Exception {
	
			autoTestUtil.login();
	}

	@BeforeMethod
	public void selectModule2() throws InterruptedException {

			autoTestUtil.beforeMethod(ApplicationConstants.HOME_BUTTON);
			autoTestUtil.beforeMethod(ApplicationConstants.BPM_MODULE);	
	}
	
	//@Test(priority = 0)
	public void testRoleToEmployeeLink() throws Exception {
		
		Thread.sleep(2000);
		ParsingExcel userData = new ParsingExcel("testdata/BPM.xlsx", "RoleToEmployeeLink");
		autoTestUtil.performAction(userData);
	}
	
	@Test(priority = 1)
	public void testPrintConfiguration() throws Exception {
			
			Thread.sleep(2000);
			ParsingExcel userData = new ParsingExcel("testdata/BPM.xlsx", "PrintConfiguration");
			autoTestUtil.performAction(userData);		
	}
	
	@Test(priority = 2)
	public void testNotificationAsInformation() throws Exception {
			
			Thread.sleep(2000);
			ParsingExcel userData = new ParsingExcel("testdata/BPM.xlsx", "NotificationAsInformation");
			autoTestUtil.performAction(userData);		
	} 

	@Test(priority = 3) 
	public void testEmployeeRoleLinkReport() throws Exception {
			
			Thread.sleep(2000);
			ParsingExcel userData = new ParsingExcel("testdata/BPM.xlsx", "EmployeeRoleLinkReport");
			autoTestUtil.performAction(userData);		
	}
	
	@Test(priority = 4)
	public void testRegisterEmployeeIMEINo() throws Exception {
			
			Thread.sleep(2000);
			ParsingExcel userData = new ParsingExcel("testdata/BPM.xlsx", "RegisterEmployeeIMEINo");
			autoTestUtil.performAction(userData);		
	}  

	@AfterMethod(alwaysRun = true)
	public void takeScreenShotOnFailure(ITestResult result)throws IOException, InterruptedException {
	
		autoTestUtil.captureScreenshot(result);	
		Thread.sleep(200);
		driver.navigate().refresh();
		Thread.sleep(1000);			
	
	}

	@AfterClass(alwaysRun = true)
	private void tearDown() throws InterruptedException {
		autoTestUtil.tearDownMethod();
		
	}	

}
