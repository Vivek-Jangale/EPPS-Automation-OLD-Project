package com.epps.admin.test;

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

public class Admin {

	Map<String, Object[]> testResults = new LinkedHashMap<String, Object[]>();
	static int i=0;
	AutoTestUtil autoTestUtil = new AutoTestUtil();

	@BeforeClass
	public void setUp() throws Exception {
		autoTestUtil.login();
	}

//	@BeforeMethod
	public void selectModule() throws InterruptedException {
		System.out.println("in @beforemethod");	
		autoTestUtil.beforeMethod(ApplicationConstants.ADMIN_MODULE);
	}
	@Test(priority = 0)
	public void testECodeMaster() throws Exception {
		Thread.sleep(2000);
		ParsingExcel userData = new ParsingExcel("testdata/Admin.xlsx", "ECodeMaster");
		autoTestUtil.performAction(userData);
	}

		
	@AfterMethod
	public void takeScreenShotOnFailure(ITestResult result)throws IOException, InterruptedException {
	
		autoTestUtil.captureScreenshot(result);
	
	}

	@AfterClass
	private void tearDown() throws InterruptedException {
		
		autoTestUtil.tearDownMethod();
		
	}	

}
