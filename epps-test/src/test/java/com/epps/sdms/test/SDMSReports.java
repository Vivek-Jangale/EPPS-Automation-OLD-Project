package com.epps.sdms.test;

import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.epps.admin.test.ParsingExcel;
import com.epps.common.constant.ApplicationConstants;
import com.epps.common.util.AutoTestUtil;
import com.epps.common.util.BaseClass;

public class SDMSReports extends BaseClass{
	
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
	
	public void testSalesEnquiryExportToExcel() throws Exception {
		Thread.sleep(2000);
		ParsingExcel userData = new ParsingExcel("testdata/SDMS-Report.xlsx", "SalesEnquiryExportToExcel");
		autoTestUtil.performAction(userData);
	}	
}


