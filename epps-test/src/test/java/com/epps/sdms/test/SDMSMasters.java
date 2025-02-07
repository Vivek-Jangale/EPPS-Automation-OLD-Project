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

public class SDMSMasters extends BaseClass{
	
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
	//Make the consignee & customer different : Future enhancement
	@Test(priority = 0)
	public void testCustomerConsigneeLink() throws Exception {
		Thread.sleep(2000);
		ParsingExcel userData = new ParsingExcel("testdata/SDMS-Master.xlsx", "CustomerConsigneeLink");
		autoTestUtil.performAction(userData);
	}	
	
	//Changes is going on in system(same case with MMS): Future Enhancement
	@Test(priority = 1)
	public void testItemToCustomerLinkMaster() throws Exception {
		Thread.sleep(2000);
		ParsingExcel userData = new ParsingExcel("testdata/SDMS-Master.xlsx", "ItemToCustomerLinkMaster");
		autoTestUtil.performAction(userData);
	}	
	
	@Test(priority = 2)
	public void testPriceBook() throws Exception {
		Thread.sleep(2000);
		ParsingExcel userData = new ParsingExcel("testdata/SDMS-Master.xlsx", "PriceBook");
		autoTestUtil.performAction(userData);
	}	
	@Test(priority = 3)
	public void testPriceBookItemList() throws Exception {
		Thread.sleep(2000);
		ParsingExcel userData = new ParsingExcel("testdata/SDMS-Master.xlsx", "PriceBookItemList");
		autoTestUtil.performAction(userData);
	}
	@Test(priority = 4)
	public void testApprovePriceBook() throws Exception {
		Thread.sleep(2000);
		ParsingExcel userData = new ParsingExcel("testdata/SDMS-Master.xlsx", "ApprovePriceBook");
		autoTestUtil.performAction(userData);
	}
	@Test(priority = 5)
	public void testVehicalMaster() throws Exception {
		Thread.sleep(2000);
		ParsingExcel userData = new ParsingExcel("testdata/SDMS-Master.xlsx", "VehicalMaster");
		autoTestUtil.performAction(userData);
}
	@Test(priority = 6)
	public void testVehicalInMaster() throws Exception {
		Thread.sleep(2000);
		ParsingExcel userData = new ParsingExcel("testdata/SDMS-Master.xlsx", "VehicalInMaster");
		autoTestUtil.performAction(userData);
	}
	@Test(priority = 7)
	public void testVehicalOutMaster() throws Exception {
		Thread.sleep(2000);
		ParsingExcel userData = new ParsingExcel("testdata/SDMS-Master.xlsx", "VehicalOutMaster");
		autoTestUtil.performAction(userData);
	}
	
	@Test(priority = 8)
	public void testCAMCSACutomerLink() throws Exception {
		Thread.sleep(2000);
		ParsingExcel userData = new ParsingExcel("testdata/SDMS-Master.xlsx", "CAMCSACutomerLink");
		autoTestUtil.performAction(userData);
	}
	
    @Test(priority = 9)
	public void testLocationToCustomerLink() throws Exception {
		Thread.sleep(2000);
		ParsingExcel userData = new ParsingExcel("testdata/SDMS-Master.xlsx", "LocationToCustomerLink");
		autoTestUtil.performAction(userData);
	}
    @Test(priority = 10)
 	public void testSalesChannelMaster() throws Exception {
 		Thread.sleep(2000);
 		ParsingExcel userData = new ParsingExcel("testdata/SDMS-Master.xlsx", "SalesChannelMaster");
 		autoTestUtil.performAction(userData);
 	}
    @Test(priority = 11)
 	public void testExportInvoiceClause() throws Exception {
 		Thread.sleep(2000);
 		ParsingExcel userData = new ParsingExcel("testdata/SDMS-Master.xlsx", "ExportInvoiceClause");
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
