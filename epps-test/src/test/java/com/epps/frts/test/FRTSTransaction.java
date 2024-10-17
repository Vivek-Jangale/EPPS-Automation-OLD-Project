package com.epps.frts.test;
import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epps.admin.test.ParsingExcel;
import com.epps.common.constant.ApplicationConstants;
import com.epps.common.util.AutoTestUtil;
import com.epps.common.util.BaseClass;
public class FRTSTransaction extends BaseClass {
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
	public void testFreightContract() throws Exception {
		Thread.sleep(2000);
		ParsingExcel userData = new ParsingExcel("testdata/FRTS.xlsx", "FreightContract");
		autoTestUtil.performAction(userData);
	}
	@Test(priority = 1)
	public void testAmendFreightContract() throws Exception {
		Thread.sleep(2000);
		ParsingExcel userData = new ParsingExcel("testdata/FRTS.xlsx", "AmendFreightContract");
		autoTestUtil.performAction(userData);
	}
	
	}
	
	


