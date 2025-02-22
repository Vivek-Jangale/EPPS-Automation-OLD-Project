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

public class QualityParameterMaster extends BaseClass {
	
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
	
	@Test(priority = 0)
	public void testQualityParameterMaster() throws Exception {
		Thread.sleep(2000);
		ParsingExcel userData = new ParsingExcel("testdata/PQMS-Master.xlsx", "QualityParameterMaster");
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
