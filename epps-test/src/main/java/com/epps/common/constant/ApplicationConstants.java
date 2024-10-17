package com.epps.common.constant;
import org.openqa.selenium.WebDriver;


public class ApplicationConstants   {
	
	
public static final String APP_URL = "http://164.52.192.41:8287/epps-protest";	

public static final String APP_USERNAME = "sys_admin5@eppsinfotech.com";

public static final String APP_DIVISION = "5";

public static final String APP_ROLE = "2";

public static final String APP_PASSWARD = "00005";
	
public static final String FAS_MODULE = "//*[@class='caption'][text() = 'finance and accounting management']";

public static final String SDMS_MODULE = "//div[@data-id='SDMS']"; 
	
public static final String HRMS_MODULE = "//*[@class='caption'][text() = 'human resource management']";
	  
public static final String MMS_MODULE = "//*[@class='caption'][text() = 'materials management']";
	
public static final String MIS_MODULE = "//*[@class='caption'][text()= 'management information system']";

public static final String PQMS_MODULE = "//*[@class='caption'][text()= 'production and quality management']";

public static final String FRTS_MODULE = "//*[@class='caption'][text()= 'freight  management']";

public static final String OUTSOURC_MODULE = "//*[@class='caption'][text()= 'sub contract management']"; //Previously known as SBCT_MODULE

public static final String INSOUR_MODULE = "//*[@class='caption'][text()= 'job works']"; // Previously known as JOB_MODULE

public static final String OTHERS_MODULE = "//*[@class='caption'][text()= 'Other']"; 

public static final String ADMIN_MODULE = "//*[@class='caption'][text()= 'epps administration']";

public static final String HOME_BUTTON = "//*[@title='Home']";

public static final String LOGIN_BUTTON = "//button[@id= 'loginButtonId']";

public static final String BPM_MODULE = "//div[@data-id='BPM']"; // Previously known as SYSAD_MODULE

public static final String CRM_MODULE = "//div[@class='caption'][text()='crm']";

public static final String CRM_PLUGIN = "//div[@class='caption'][text()='crm - plug-in']";

public static final String WARRANTY_MODULE = "//div[@class='caption'][text()='warranty service management system']"; 

public static final String Path_ScreenShot = "D:/WorkspacesAutoSmartERP/epps-test/Screenshots";

private String sTestCaseName;

public static final String Error_Msg = "//*[@class='modal-title'][text()='Error']";
}
