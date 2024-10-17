package com.epps.mms.test;

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

public class MaterialMangement extends BaseClass{
	
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
		autoTestUtil.beforeMethod(ApplicationConstants.MMS_MODULE);	
	
	}

	@Test(priority = 0)
	public void testItemBrandMaster() throws Exception {
		
		Thread.sleep(2000);
		ParsingExcel userData = new ParsingExcel("testdata/MMS-Master.xlsx", "ItemBrandMaster");
		autoTestUtil.performAction(userData);
	}
	@Test(priority = 1)
	public void testItemPhysicalParameterMaster() throws Exception {
		
		Thread.sleep(2000);
		ParsingExcel userData = new ParsingExcel("testdata/MMS-Master.xlsx", "ItemPhysicalParameterMaster");
		autoTestUtil.performAction(userData);
	}
	
	@Test(priority = 2)
	public void testHSNSACMasterr() throws Exception {
		
		Thread.sleep(2000);
		ParsingExcel userData = new ParsingExcel("testdata/MMS-Master.xlsx", "HSNSACMaster");
		autoTestUtil.performAction(userData);
	}
	
	@Test(priority = 3)
	public void testItemGroupMaster() throws Exception {
		
		Thread.sleep(2000);
		ParsingExcel userData = new ParsingExcel("testdata/MMS-Master.xlsx", "ItemGroupMaster");
		autoTestUtil.performAction(userData);
	}
	@Test(priority = 4)
	public void testItemSubGroupMaster() throws Exception {
		
		Thread.sleep(2000);
		ParsingExcel userData = new ParsingExcel("testdata/MMS-Master.xlsx", "ItemSubGroupMaster");
		autoTestUtil.performAction(userData);
	}
			
	@Test(priority = 5)
	public void testItemSubSubGroupMaster() throws Exception {
		
		Thread.sleep(2000);
		ParsingExcel userData = new ParsingExcel("testdata/MMS-Master.xlsx", "ItemSubSubGroupMaster");
		autoTestUtil.performAction(userData);
	} 
	
	@Test(priority = 6)
	public void testStorageLocationMaster() throws Exception {
		
		Thread.sleep(2000);
		ParsingExcel userData = new ParsingExcel("testdata/MMS-Master.xlsx", "StorageLocationMaster");
		autoTestUtil.performAction(userData);
	}	
	
	//@Test(priority = 7)
	public void testItemMaster() throws Exception {
		
		Thread.sleep(2000);
		ParsingExcel userData = new ParsingExcel("testdata/MMS-Master.xlsx", "ItemMaster");
		autoTestUtil.performAction(userData);
	}
			
	//@Test(priority = 8)
	public void testApproveItem() throws Exception {
		
		Thread.sleep(2000);
		ParsingExcel userData = new ParsingExcel("testdata/MMS-Master.xlsx", "ApproveItem");
		autoTestUtil.performAction(userData);
	}
			
	//@Test(priority = 9)
	public void testItemLocationStorageLocationLink() throws Exception {
		
		Thread.sleep(2000);
		ParsingExcel userData = new ParsingExcel("testdata/MMS-Master.xlsx", "ItemLocationStorageLocationLink");
		autoTestUtil.performAction(userData);
	}	

	@Test(priority = 10)
	public void testSupplierMaster() throws Exception {
		Thread.sleep(2000);
		ParsingExcel userData = new ParsingExcel("testdata/MMS-Master.xlsx", "SupplierMaster");
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
