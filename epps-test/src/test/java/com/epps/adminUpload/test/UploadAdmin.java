package com.epps.adminUpload.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;

import com.epps.admin.test.ParsingExcel;
import com.epps.common.constant.ApplicationConstants;
import com.epps.common.util.AutoTestUtil;
import com.epps.common.util.BaseClass;


public class UploadAdmin extends BaseClass
{	
	/**String Url="/testdata/upload/salesorder/Sales Order.xlsx";
	//String path = System.getProperty("user.dir")+Url;
	private void upload(String locator, String values)
			throws InterruptedException {
		String path = System.getProperty("user.dir")+values;
		File exl = new File(path);
		String getAbsPath = exl.getAbsolutePath();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement element = driver.findElement(By.xpath(locator));
		Thread.sleep(100);
		element.sendKeys(getAbsPath);
		Thread.sleep(200);
		element.sendKeys(Keys.RETURN);
		Thread.sleep(600);
	}	
	String path = System.getProperty("user.dir")+"";
	@Test
	public void run() throws InterruptedException, Exception 
	{		
	driver=BaseClass.chromeTest(driver);
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.get("http://164.52.192.41:8287/epps-protest");
	driver.findElement(By.id("userNameId")).clear();
	driver.findElement(By.id("userNameId")).sendKeys("sys_admin5@eppsinfotech.com");
	WebDriverWait waitForDiv = new WebDriverWait(driver, 60);
    WebElement dropDiv =  waitForDiv.until(ExpectedConditions.elementToBeClickable((By.id("signInDivisionId"))));
    dropDiv.sendKeys(ApplicationConstants.APP_DIVISION);
    dropDiv.sendKeys(Keys.ENTER);
	WebDriverWait waitForRole = new WebDriverWait(driver, 60);
    WebElement dropRole =  waitForRole.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Select Role'][2]")));
    dropRole.sendKeys(ApplicationConstants.APP_ROLE);
    dropRole.sendKeys(Keys.ENTER);
	driver.findElement(By.id("passwordId")).sendKeys("00005");
	driver.findElement(By.id("loginButtonId")).click();
	Thread.sleep(2000);
	WebElement element = driver.findElement(By.xpath("//*[text()= 'EPPS Administration']"));
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	Thread.sleep(700);
	element.click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//li/a[@id='549']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//span[@id='select2-uploadOpeningDataMastersListId-container']")).click();
	driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys("Sales Order");
	driver.findElement(By.xpath("//li[text()='Sales order']")).click();
	File  FL = new File(path);
	String abc = FL.getAbsolutePath();
	driver.findElement(By.xpath("//input[@id='uploadOpeningDataFileId']")).sendKeys(a);
	//driver.findElement(By.xpath("//input[@id='uploadOpeningDataFileId']")).sendKeys("/testdata/upload/salesorder/Sales Order.xlsx");
	Thread.sleep(1000);
	driver.findElement(By.id("validateDataBtn")).click();
//driver.findElement(By.xpath("//*[@id='validateDataBtn']"));
	Thread.sleep(1000);
	driver.findElement(By.id("uploadDataBtn")).click();	
//	driver.findElement(By.xpath("//*[@id='uploadDataBtn']"));
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();	}}**/



	Map<String, Object[]> testResults = new LinkedHashMap<String, Object[]>();
	static int i=0;
	AutoTestUtil autoTestUtil = new AutoTestUtil();

	//@BeforeClass
	@BeforeMethod
	public void setUp() throws Exception {
	autoTestUtil.login();}
	

//	@BeforeMethod
	public void selectModule() throws InterruptedException {
		System.out.println("in @beforemethod");	
   autoTestUtil.beforeMethod(ApplicationConstants.ADMIN_MODULE);}
	
	@Test(priority = 0)
	public void testSoUpload() throws Exception {
		Thread.sleep(1000);
		ParsingExcel userData = new ParsingExcel("testdata/ADMIN-SDMS-Upload.xlsx", "SalesOrder");
		autoTestUtil.performAction(userData);}	
	
	@Test(priority = 1)
	public void testPriceBookUpload() throws Exception {

			Thread.sleep(2000);
			ParsingExcel userData = new ParsingExcel("testdata/ADMIN-Upload.xlsx", "PriceBook");
			autoTestUtil.performAction(userData);
	}
	@Test(priority = 2)
	public void testCustomerMasterUpload() throws Exception {
			
			Thread.sleep(2000);
			ParsingExcel userData = new ParsingExcel("testdata/ADMIN-Upload.xlsx", "CustomerMaster");
			autoTestUtil.performAction(userData);
	} 
	
	@Test(priority = 3)
	public void testDiscountMatrixUpload() throws Exception {

			Thread.sleep(2000);
			ParsingExcel userData = new ParsingExcel("testdata/ADMIN-Upload.xlsx", "DiscountMatrix");
			autoTestUtil.performAction(userData);
	}
	@Test(priority = 4)
	public void testInvoicePOSUpload() throws Exception {
	
			Thread.sleep(2000);
			ParsingExcel userData = new ParsingExcel("testdata/ADMIN-Upload.xlsx", "InvoicePOS");
			autoTestUtil.performAction(userData);
}}


