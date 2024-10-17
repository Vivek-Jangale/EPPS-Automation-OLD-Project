package com.epps.crm.test;

import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epps.admin.test.ParsingExcel;
import com.epps.common.constant.ApplicationConstants;
import com.epps.common.util.AutoTestUtil;
import com.epps.common.util.BaseClass;

public class CRMMaster extends BaseClass{

	Map<String, Object[]> testResults = new LinkedHashMap<String, Object[]>();
	AutoTestUtil autoTestUtil = new AutoTestUtil();
	int count = 1;
	WebElement element; 
	Actions action =null;
	
	@BeforeClass
	public void setUpBPM() throws Exception {
			
			autoTestUtil.login();	
	}

	@BeforeMethod
	public void selectModule() throws InterruptedException {
		
			autoTestUtil.beforeMethod(ApplicationConstants.HOME_BUTTON);
		
			autoTestUtil.beforeMethod(ApplicationConstants.CRM_MODULE);
			Thread.sleep(3000);
	}

	@Test(priority = 0)
	public void testContact() throws Exception{

			Thread.sleep(2000);
			ParsingExcel userData = new ParsingExcel("testdata/CRM.xlsx", "Contact");
			autoTestUtil.performAction(userData);
	
	} 
	
}	


