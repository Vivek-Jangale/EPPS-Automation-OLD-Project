package com.epps.common.util;

import org.testng.TestNG;
import com.epps.sdms.test.SDMSMasters;
import com.epps.sdms.test.SDMSMastersDep;

public class TestRunner {
	static TestNG testng;
	public static void main(String[] args) {
		testng = new TestNG();
		testng.setTestClasses(new Class[] {SDMSMasters.class,SDMSMastersDep.class});
		testng.run();

	}

}
