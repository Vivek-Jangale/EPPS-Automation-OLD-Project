package com.epps.frts.test;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.ITestResult;
import org.testng.annotations.*;

import com.epps.admin.test.ParsingExcel;
import com.epps.common.constant.ApplicationConstants;
import com.epps.common.util.AutoTestUtil;
import com.epps.common.util.BaseClass;

public class FRTSMasters extends BaseClass {

	Map<String, Object[]> testResults = new LinkedHashMap<String, Object[]>();
	static int i=0;
	AutoTestUtil autoTestUtil = new AutoTestUtil();
	//int count = 1;
	@BeforeClass
	public void setUp() throws Exception {
		autoTestUtil.login();
	}
	@BeforeMethod
	public void selectModule() throws InterruptedException {
		autoTestUtil.beforeMethod(ApplicationConstants.HOME_BUTTON);	
		autoTestUtil.beforeMethod(ApplicationConstants.FRTS_MODULE);		
	}
	@Test(priority = 0)
	public void testFreightZoneMaster() throws Exception {
		Thread.sleep(2000);
		ParsingExcel userData = new ParsingExcel("testdata/FRTS.xlsx", "FreightZoneMaster");
		autoTestUtil.performAction(userData);
	}
}