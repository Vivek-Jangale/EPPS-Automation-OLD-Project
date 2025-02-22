package com.epps.common.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.seleniumhq.jetty9.util.log.Log;
import org.testng.Assert;
import org.testng.ITestResult;

import com.epps.admin.test.ParsingExcel;
import com.epps.common.constant.ApplicationConstants;
import com.google.common.base.Verify;




public class AutoTestUtil extends BaseClass
{
	
 
	String[] assertion = null;
	String [] output = null;
	String module;
	
	
	/**
	public void login(ParsingExcel userData) throws InterruptedException {

		String url = userData.getCell(1, 0);
		String userName = userData.getCell(1, 1);
		String password = userData.getCell(1, 2);
		module = userData.getCell(1, 3);
	
		//String url = ApplicationConstants.APP_URL;
		//String userName = ApplicationConstants.APP_USERNAME;
		//String password = ApplicationConstants.APP_PASSWARD;
		//module = userData.getCell(1, 3);
		
	// Browser specific calling 
		
		//driver = new FirefoxDriver();
		driver=BaseClass.chromeTest(driver);
		//driver=BaseClass.IETest(driver);
		
		driver.manage().deleteAllCookies();
		driver.get(url);
		driver.findElement(By.id("userNameId")).clear();
		driver.findElement(By.id("userNameId")).sendKeys(userName);
		driver.findElement(By.id("passwordId")).clear();
		driver.findElement(By.id("passwordId")).sendKeys(password);
		driver.findElement(By.id("loginButtonId")).click();
		Thread.sleep(2000);
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		boolean isElemPresent = isElementPresent(By.xpath(ApplicationConstants.HOME_BUTTON));
				
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("In Setup:" + isElemPresent);
		Assert.assertEquals(isElemPresent, true);
		}

	public boolean isElementPresent(By by) {
		try {
			Thread.sleep(1000);
			driver.findElement(by);
			return true;
		} catch (Exception e) {
			return false;
		}
	}   **/
	
	public void login() throws InterruptedException
	{
	
	//driver = new FirefoxDriver();
		driver=BaseClass.chromeTest(driver);
		//driver=BaseClass.IETest(driver);
		
		driver.manage().deleteAllCookies();
		driver.get(ApplicationConstants.APP_URL);
		driver.findElement(By.id("userNameId")).clear();
		driver.findElement(By.id("userNameId")).sendKeys(ApplicationConstants.APP_USERNAME);
		
		
		driver.findElement(By.id("signInDivisionId")).sendKeys(ApplicationConstants.APP_DIVISION);
		WebDriverWait wait = new WebDriverWait(driver, 30);
	    WebElement dropRole =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Select Role'][2]")));
	    dropRole.sendKeys(ApplicationConstants.APP_ROLE);

	    dropRole.sendKeys(Keys.ENTER);

		driver.findElement(By.id("passwordId")).sendKeys(ApplicationConstants.APP_PASSWARD);
		driver.findElement(By.id("loginButtonId")).click();
		Thread.sleep(2000);
		driver.manage().window().maximize();
		
		Thread.sleep(1000);
		boolean isElemPresent = isElementPresent(By.xpath(ApplicationConstants.HOME_BUTTON));
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("In Setup:" + isElemPresent);
		Assert.assertEquals(isElemPresent, true);
		}

	private WebElement Select(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isElementPresent(By by) {
		try {
			Thread.sleep(1000);
			driver.findElement(by);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	

	/**
	 * This method is use to perform actions on excel data
	 * @param userData
	 * @throws Exception 
	 */
	public void performAction(ParsingExcel userData) throws Exception 
	  {

		ArrayList<Object[]> columnData = new ArrayList<Object[]>();
		int totalRows = userData.getNoOfRows();// the row number of data in the
												// sheet

		String[] dataLine = new String[totalRows];
		for (int i = 1, j = 0; i < totalRows; i++, j++) {
			dataLine[j] = userData.getCell(i, 3);
		}
		columnData.add(dataLine);

		String[] locator = new String[totalRows];
		for (int i = 1, j = 0; i < totalRows; i++, j++) {
			locator[j] = userData.getCell(i, 2);
		}

		String[] values = new String[totalRows];
		for (int i = 1, j = 0; i < totalRows; i++, j++) {
			values[j] = userData.getCell(i, 4);
		}

		assertion = new String[totalRows];
		for (int i = 1, j = 0; i < totalRows; i++, j++) {
			assertion[j] = userData.getCell(i, 5);
		}

		output = new String[totalRows];
		for (int i = 1, j = 0; i < totalRows; i++, j++) {
			output[j] = userData.getCell(i, 6);
		}
		
		String[] positionOFi = new String[totalRows];
		for (int i = 1, j = 0; i < totalRows; i++, j++) {
			positionOFi[j] = userData.getCell(i, 7);
		}
		String[] nextButtonLocator = new String[totalRows];
		for (int i = 1, j = 0; i < totalRows; i++, j++) {
			nextButtonLocator[j] = userData.getCell(i, 8);
		}
		String[] acceptOrApproveBtnLocator = new String[totalRows];
		for (int i = 1, j = 0; i < totalRows; i++, j++) {
			acceptOrApproveBtnLocator[j] = userData.getCell(i, 9);
		}
		String[] uniqueFieldsLocator = new String[totalRows];
		for (int i = 1, j = 0; i < totalRows; i++, j++) {
			uniqueFieldsLocator[j] = userData.getCell(i, 10);
		}
		String[] positionOfJ = new String[totalRows];
		for (int i = 1, j = 0; i < totalRows; i++, j++) {
			positionOfJ[j] = userData.getCell(i, 11);
		}
		String[] fieldDisplayName = new String[totalRows];
		for (int i = 1, j = 0; i < totalRows; i++, j++) {
			fieldDisplayName[j] = userData.getCell(i, 12);
		}
		String[] secondCheckBoxLocator = new String[totalRows];
		for (int i = 1, j = 0; i < totalRows; i++, j++) {
			secondCheckBoxLocator[j] = userData.getCell(i, 13);
		}
		String[] positionOfK = new String[totalRows];
		for (int i = 1, j = 0; i < totalRows; i++, j++) {
			positionOfK[j] = userData.getCell(i, 14);
		}
		String[] noOfPageLocator = new String[totalRows];
		for (int i = 1, j = 0; i < totalRows; i++, j++) {
			noOfPageLocator[j] = userData.getCell(i, 15);
		}
		for (int i = 0; i < dataLine.length - 1; i++) {
		       	if (dataLine[i].equalsIgnoreCase("click")) {
				click(locator[i]);
			}
		  	else if (dataLine[i].equalsIgnoreCase("ClickPDF")) {
		  		ClickPDF(locator[i]);
			}  	
			else if (dataLine[i].equalsIgnoreCase("waitAndClick")) {
				waitAndClick(locator[i]);
			}
			
			else if (dataLine[i].equalsIgnoreCase("waitAndClickCSS")) {
				waitAndClickCSS(locator[i]);
			}

			else if (dataLine[i].equalsIgnoreCase("input")) {
				insert(locator[i], values[i]);
			}

			else if (dataLine[i].equalsIgnoreCase("inputId")) {
				insertId(locator[i], values[i]);
			}

			else if (dataLine[i].equalsIgnoreCase("inputCSS")) {
				inputCSS(locator[i], values[i]);
			}

			else if (dataLine[i].equalsIgnoreCase("substringAndInputCSS")) {
				substringAndInsertCSS(locator[i], values[i]);
			}

			else if (dataLine[i].equalsIgnoreCase("inputNum")) {
				insert(locator[i], values[i].substring(0, values[i].length() - 2));
			}
			
			else if (dataLine[i].equalsIgnoreCase("clickId")) {
				clickId(locator[i]);
			}

			else if (dataLine[i].equalsIgnoreCase("clickNumId")) {
				System.out.println("In clicknumid");
				clickNumId(locator[i]);
				
			}
			
			else if (dataLine[i].equalsIgnoreCase("waitAndclickId")) {
				waitAndclickId(locator[i]);
			}
			
			else if (dataLine[i].equalsIgnoreCase("waitAndinsert")) {
				waitAndinsert(locator[i],values[i]);
			}
			
			
			else if (dataLine[i].equalsIgnoreCase("clickAndwait")) {
				clickAndwait(locator[i]);
			}
			
			else if (dataLine[i].equalsIgnoreCase("clickAndwaitXpath")) {
				clickAndwaitXpath(locator[i]);
			}

			else if (dataLine[i].equalsIgnoreCase("clickCSS")) {
				clickCSS(locator[i]);
			}

			else if (dataLine[i].equalsIgnoreCase("assertion")) {
				assertion(locator[i], output[i]);
			}

			else if (dataLine[i].equalsIgnoreCase("clickToHome")) {
				clickToHome(locator[i]);
			}

			else if (dataLine[i].equalsIgnoreCase("clickAndEnter")) {
				clickAndEnter(locator[i]);
			}

			else if (dataLine[i].equalsIgnoreCase("clickAndEnterCSS")) {
				clickAndEnterCSS(locator[i]);
			}

			else if (dataLine[i].equalsIgnoreCase("print")) {
				print(locator[i]);
			}

			else if (dataLine[i].equalsIgnoreCase("scrollRight")) {
				scrollToRight(locator[i]);
			}

			else if (dataLine[i].equalsIgnoreCase("scrollRightUsingId")) {
				scrollToRightUsingId(locator[i]);
			}

			else if (dataLine[i].equalsIgnoreCase("scrollAndClick")) {
				scrollAndClick(locator[i]);
			}
			
			else if (dataLine[i].equalsIgnoreCase("scrollAndClick")) {
				scrollAndClick(locator[i]);
			}

			else if (dataLine[i].equalsIgnoreCase("selectAndInput")) {
				selectAndInput(locator[i], values[i]);
			}

			else if (dataLine[i].equalsIgnoreCase("selectAndInputId")) {
				selectAndInputId(locator[i], values[i]);
			}
			else if (dataLine[i].equalsIgnoreCase("selectAndInputCSS")) {
				selectAndInputCSS(locator[i], values[i]);
			}
			else if (dataLine[i].equalsIgnoreCase("clickAndinputAndEnter")) {
				clickInputAndEnter(locator[i], values[i]);
	
			}
			else if (dataLine[i].equalsIgnoreCase("assertionXpath")) {
				assertionXpath(locator[i]);
			}

			else if (dataLine[i].equalsIgnoreCase("scrollAndClickXpath")) {
				scrollAndClickXpath(locator[i]);
			}
			else if (dataLine[i].equalsIgnoreCase("scrollDown")) {
				scrollDown(locator[i]);
			}
			else if (dataLine[i].equalsIgnoreCase("rightClick")) {
				rightClick(locator[i]);
			}
			else if (dataLine[i].equalsIgnoreCase("doubleClick")) {
				doubleClick(locator[i]);
			}
			else if (dataLine[i].equalsIgnoreCase("clickAndEnter")) {
				clickAndEnter(locator[i]);
			}	
			else if (dataLine[i].equalsIgnoreCase("inputAndEnter")) {
				inputAndEnter(locator[i],values[i]);
			}
			else if (dataLine[i].equalsIgnoreCase("inputCSSandEnter")) {
				inputCSSandEnter(locator[i], values[i]);
			}
			else if (dataLine[i].equalsIgnoreCase("selectedValueCheckBoxFromGrid")) {
				selectedValueCheckBoxFromGrid(locator[i],values[i], positionOFi[i],nextButtonLocator[i],acceptOrApproveBtnLocator[i]);
			}
			else if (dataLine[i].equalsIgnoreCase("selectOneCheckBoxAndAcceptFromGrid")) {
				selectOneCheckBoxAndAcceptFromGrid(locator[i], positionOFi[i],nextButtonLocator[i],acceptOrApproveBtnLocator[i],uniqueFieldsLocator[i],positionOfJ[i],fieldDisplayName[i]);
			}
			else if (dataLine[i].equalsIgnoreCase("selectTwoCheckBoxAndAcceptFromGrid")) {
				selectTwoCheckBoxAndAcceptFromGrid(locator[i], positionOFi[i],nextButtonLocator[i],acceptOrApproveBtnLocator[i],uniqueFieldsLocator[i],positionOfJ[i],fieldDisplayName[i],secondCheckBoxLocator[i],positionOfK[i]);
			}
			else if (dataLine[i].equalsIgnoreCase("clickSelectAllAndAccept")) {
				clickSelectAllAndAccept(locator[i],nextButtonLocator[i],acceptOrApproveBtnLocator[i],noOfPageLocator[i]);
			}
			else if (dataLine[i].equalsIgnoreCase("saveIfDataInGrid")) {
				saveIfDataInGrid(locator[i],noOfPageLocator[i]);
			}
			else if (dataLine[i].equalsIgnoreCase("clickModuleXpath")) {
				clickModuleXpath(locator[i]);
			}
			
			else if (dataLine[i].equalsIgnoreCase("clickAndinsert")) {
				clickAndinsert(locator[i],values[i]);
			}
			else if (dataLine[i].equalsIgnoreCase("upload")) {
				upload(locator[i], values[i]);
			}
			else if (dataLine[i].equalsIgnoreCase("createName")) {
				createName(locator[i], values[i]);
			}
			else if (dataLine[i].equalsIgnoreCase("inputDate")) {
				inputDate(locator[i], values[i]);
			}
			else if (dataLine[i].equalsIgnoreCase("assertionUpload")) {
				assertionUpload(locator[i]);
			}
	
		}

	}

	private void clickModuleXpath(String module) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement element = driver.findElement(By.xpath(module));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
		Thread.sleep(1000);
	}

	private void saveIfDataInGrid(String locator, String noOfPageLocator) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		 
		WebElement nextButtonElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(noOfPageLocator)));
		String nextElementText=nextButtonElement.getText();
		if(!(nextElementText.equals("No Result Found"))){
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locator)));
			element.click();
			WebElement closseSuccessBox = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#successDialogId .close")));
			closseSuccessBox.click();
		}
		
	}

	private void clickSelectAllAndAccept(String locator, String nextButtonLocator,
			String acceptOrApproveBtnLocator, String noOfPageLocator) throws InterruptedException {
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		Actions action = new Actions(driver);
		WebElement nextButtonElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(noOfPageLocator)));		
		String nextElementText=nextButtonElement.getText();
		if(!(nextElementText.equals("No Result Found"))){
			if(nextElementText.length()<=3){
				int noOfPages=Integer.parseInt(nextButtonElement.getText());
				for(int i=0;i<noOfPages;i++){
					WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locator)));
					element.click();
					WebElement acceptOrApproveBtnElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(acceptOrApproveBtnLocator)));
					acceptOrApproveBtnElement.click();
					WebElement closseSuccessBox = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#successDialogId .close")));
					closseSuccessBox.click();
//					action.sendKeys(Keys.ESCAPE);#successDialogId .close
					Thread.sleep(2000);
				}
			}else{
				WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locator)));
				element.click();
				WebElement acceptOrApproveBtnElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(acceptOrApproveBtnLocator)));
				acceptOrApproveBtnElement.click();
				action.sendKeys(Keys.ESCAPE);
				WebElement closseSuccessBox = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#successDialogId .close")));
				closseSuccessBox.click();
				Thread.sleep(2000);
			}
		}
		action.sendKeys(Keys.ESCAPE);
	}

	private void selectTwoCheckBoxAndAcceptFromGrid(String locator,String positionOFi, String nextButtonLocator, 
			String acceptOrApproveBtnLocator, String uniqueFieldsLocator,String positionOfJ, String fieldDisplayName, String secondCheckBoxLocator, String positionOfK) {
		int pos=Integer.parseInt(positionOFi.substring(0, positionOFi.length()-2));
		String xPathPre=(String) locator.subSequence(0, pos);
		String xPathPost=(String) locator.subSequence(pos+1, locator.length());
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		String temp="";
		pos=Integer.parseInt(positionOfJ.substring(0, positionOfJ.length()-2));
		String xPathPreForUnique=(String) uniqueFieldsLocator.subSequence(0, pos);
		String xPathPostForUnique=(String) uniqueFieldsLocator.subSequence(pos+1, uniqueFieldsLocator.length());
		
		pos=Integer.parseInt(positionOfK.substring(0, positionOfK.length()-2));
		String xPathPreForSecondCB=(String) secondCheckBoxLocator.subSequence(0, pos);
		String xPathPostForSecondCB=(String) secondCheckBoxLocator.subSequence(pos+1, secondCheckBoxLocator.length());
		
		boolean canSearch = false;
		do{
			canSearch = false;
			for(int i=2,j=1;i<32&&j<31;i++,j++){

				WebElement testText1Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPathPreForUnique+j+xPathPostForUnique)));
				temp=testText1Element.getText();
				if(temp.equals(fieldDisplayName)){
					String newLocator=xPathPre+i+xPathPost;
					WebElement element = driver.findElement(By.xpath(newLocator));
					element.click();
					String secondCBLocator=xPathPreForSecondCB+i+xPathPostForSecondCB;
					WebElement nextCBelement = driver.findElement(By.xpath(secondCBLocator));
					nextCBelement.click();
					WebElement acceptOrApproveBtnElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(acceptOrApproveBtnLocator)));
					acceptOrApproveBtnElement.click();
					break;
				}
			}
			if(!nextButtonLocator.equals("NA")){
				WebElement nextButtonElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(nextButtonLocator)));			
				String classes =nextButtonElement.getAttribute("class");
				if(!classes.contains("ui-state-disabled")){
					nextButtonElement.click();
					canSearch = true;
				}else{
					canSearch = false;
				}
			}else{
				canSearch = false;
			}
		}while(canSearch);
	}

	private void selectOneCheckBoxAndAcceptFromGrid(String locator,String positionOFi, String nextButtonLocator, 
			String acceptOrApproveBtnLocator, String uniqueFieldsLocator,String positionOfJ, String fieldDisplayName) {
		
		int pos=Integer.parseInt(positionOFi.substring(0, 2));
		String xPathPre=(String) locator.subSequence(0, pos-1);
		String xPathPost=(String) locator.subSequence(pos, locator.length());
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		String temp="";
		pos=Integer.parseInt(positionOfJ.substring(0, 1));
		String xPathPreForUnique=(String) uniqueFieldsLocator.subSequence(0, pos);
		String xPathPostForUnique=(String) uniqueFieldsLocator.subSequence(pos+1, uniqueFieldsLocator.length());
		
		boolean canSearch = false;
		do{
			canSearch = false;
			WebElement nextButtonElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(nextButtonLocator)));
			for(int i=2,j=1;i<32&&j<31;i++,j++){

				WebElement testText1Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPathPreForUnique+j+xPathPostForUnique)));
				temp=testText1Element.getText();
				if(temp.equals(fieldDisplayName)){
					String newLocator=xPathPre+i+xPathPost;
					WebElement element = driver.findElement(By.xpath(newLocator));
					element.click();
					WebElement acceptOrApproveBtnElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(acceptOrApproveBtnLocator)));
					acceptOrApproveBtnElement.click();
					break;
				}
			}
			String classes =nextButtonElement.getAttribute("class");
			if(!classes.contains("ui-state-disabled")){
				nextButtonElement.click();
				canSearch = true;
			}else{
				canSearch = false;
			}
		}while(canSearch);
	}

	private void selectedValueCheckBoxFromGrid(String locator,String values, String positionOFi, String nextButtonLocator, String acceptOrApproveBtnLocator) throws InterruptedException {
		int pos=Integer.parseInt(positionOFi.substring(0, 2));
		String xPathPre=(String) locator.subSequence(0, pos-1);
		String xPathPost=(String) locator.subSequence(pos, locator.length());
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		
		
		String temp="";
		
		boolean canSearch = false;
		do{
			canSearch = false;
			WebElement nextButtonElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(nextButtonLocator)));
			for(int i=2,j=1;i<32&&j<31;i++,j++){
				String temp1="//*[@id="+j+"]/td[1]";
				WebElement testText1Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(temp1)));
				temp=testText1Element.getText();
				if(temp.equalsIgnoreCase(values)){
					String newLocator=xPathPre+i+xPathPost;
					WebElement element = driver.findElement(By.xpath(newLocator));
					element.click();
					WebElement acceptOrApproveBtnElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(acceptOrApproveBtnLocator)));
					acceptOrApproveBtnElement.click();
					break;
				}
			}
			String classes =nextButtonElement.getAttribute("class");
			if(!classes.contains("ui-state-disabled")){
				nextButtonElement.click();
				canSearch = true;
			}else{
				canSearch = false;
			}
			/*if(nextButtonElement.isEnabled()){
				nextButtonElement.click();
				canSearch = true;
			}
			else{
				canSearch = false;
			}*/
			
		}while(canSearch);
		
		/*if(nextButtonElement.isEnabled()){
			for(int i=2,j=1;i<32&&j<31;i++,j++){
				String temp1="//*[@id="+j+"]/td[1]";
				WebElement testText1Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(temp1)));
				temp=testText1Element.getText();
				if(temp.equals("DEPARTMENT3 AUTO")){
					String newLocator=xPathPre+i+xPathPost;
					WebElement element = driver.findElement(By.xpath(newLocator));
					element.click();
					break;
				}
			}
			nextButtonElement.click();
		}else{
			 Actions action = new Actions(driver);
			   action.sendKeys(Keys.ESCAPE);
		}*/
		
//		String temp1="#\31 > td:nth-child(2)";
//		WebElement testTextElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(temp1)));
//		System.out.println(testTextElement.getText());
//		if(nextButtonElement.isEnabled()){
//			for(int i=2;i<32;i++){
//				String newLocator=xPathPre+i+xPathPost;
//				WebElement element = driver.findElement(By.xpath(newLocator));
//				element.click();
//			}
//			Thread.sleep(2000);
//			WebElement acceptOrApproveBtnElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(acceptOrApproveBtnLocator)));
//			acceptOrApproveBtnElement.click();
		/*}else{
			 Actions action = new Actions(driver);
			   action.sendKeys(Keys.ESCAPE);
		}*/
	}

	private void inputCSSandEnter(String locator, String values) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//WebElement element = driver.findElement(By.cssSelector(locator));
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element = wait.until(ExpectedConditions
				.elementToBeClickable(By.cssSelector(locator)));
		Thread.sleep(1500);
		element.clear();
		Thread.sleep(2000);
		element.sendKeys(values);
		element.sendKeys(Keys.RETURN);
		//element.sendKeys(Keys.RETURN);
	}

	private void selectAndInputCSS(String locator, String values) {
		// TODO Auto-generated method stub
		values = values.substring(0, values.length() - 2);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement elem = driver.findElement(By.cssSelector(locator));
		// WebElement elem = driver.findElement(By.cssSelector(xPath));
		elem.sendKeys(Keys.CONTROL + "a");
		elem.sendKeys(Keys.DELETE);
		elem.sendKeys(values);
		elem.sendKeys(Keys.RETURN);
	}

	private void rightClick(String locator) throws InterruptedException {
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement element = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath(locator)));
		//element.click();
		Actions action = new Actions(driver).contextClick(element);
		action.build().perform();
		System.out.println("Sucessfully Right clicked on the element");
	}
	
	private void doubleClick(String locator) throws InterruptedException {
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement element = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath(locator)));
		/*element.click();*/
		Actions action = new Actions(driver).doubleClick(element);
		action.build().perform();
		System.out.println("Sucessfully Right clicked on the element");
	}
	
	private void insert(String locator, String values)
			throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement element = driver.findElement(By.xpath(locator));
		Thread.sleep(100);
		element.clear();
		element.sendKeys(values);
		Thread.sleep(200);
		element.sendKeys(Keys.RETURN);
		Thread.sleep(600);
	}
	
	private void clickAndinsert(String locator, String values)
			throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
		Thread.sleep(500);
		element.sendKeys(values);
		element.sendKeys(Keys.RETURN);
		Thread.sleep(500);
	}
	
	private void waitAndinsert(String locator, String values)
			throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(1000);
		WebElement element = driver.findElement(By.xpath(locator));
		element.sendKeys(values);
		element.sendKeys(Keys.RETURN);
		Thread.sleep(500);
	}
	

	private void insertId(String locator, String values)
			throws InterruptedException {
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement element = driver.findElement(By.id(locator));
		Thread.sleep(1000);
		element.clear();
		Thread.sleep(1000);
		element.sendKeys(values);
		element.sendKeys(Keys.RETURN);
	}

	private void click(String locator) throws InterruptedException {
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement element = wait.until(ExpectedConditions
		
				.elementToBeClickable(By.xpath(locator)));
		Thread.sleep(1000);
		element.click();
		Thread.sleep(400);
	}
	
	private void waitAndClick(String locator) throws InterruptedException {
		Thread.sleep(4000);
		click(locator);
		Thread.sleep(1000);
	}

	private void clickId(String locator) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement element = wait.until(ExpectedConditions
				.elementToBeClickable(By.id(locator)));
		element.click();
		Thread.sleep(500);
	}

	private void waitAndclickId(String locator) throws InterruptedException {
		Thread.sleep(2000);
		clickId(locator);
	}
	
	private void clickAndwait(String locator) throws InterruptedException {
		clickId(locator);
		Thread.sleep(2000);
	}
	
	private void clickAndwaitXpath(String locator) throws InterruptedException {
		click(locator);
		Thread.sleep(2000);
	}

	private void clickCSS(String locator) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 400);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locator)));
		element.click();
		Thread.sleep(1000);
	}
	
	private void waitAndClickCSS(String locator) throws InterruptedException {
		Thread.sleep(2000);
		clickCSS(locator);
	}

	//giving input text using css
	private void inputCSS(String locator, String values)
			throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		//WebElement element = driver.findElement(By.cssSelector(locator));
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element = wait.until(ExpectedConditions
				.elementToBeClickable(By.cssSelector(locator)));
		Thread.sleep(1500);
		element.clear();
		Thread.sleep(2000);
		element.sendKeys(values);
		element.sendKeys(Keys.RETURN);
		Thread.sleep(100);
	}
	

	private void substringAndInsertCSS(String locator, String values)
			throws InterruptedException {
		values = values.substring(0, values.length() - 2);
		inputCSS(locator, values);
	}

	private void assertion(String locator, String output)
			throws InterruptedException {
		boolean isElemPresent = isElementPresent(By.cssSelector(locator));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("In assertion: " + isElemPresent);
		Assert.assertEquals(isElemPresent, true, output);
	}
	private void assertionXpath(String locator) throws InterruptedException {
		boolean isElemPresent = isElementPresent(By.xpath(locator));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("In assertion Xpath: " + isElemPresent);
		Assert.assertEquals(isElemPresent, true);
		
	}

	private void clickToHome(String locator) throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(locator)).click();
		Thread.sleep(3000);

	}

	private void clickAndEnter(String locator) throws InterruptedException {
		WebElement element = driver.findElement(By.xpath(locator));
		Thread.sleep(1000);
		element.click();
		Thread.sleep(2000);
		element.sendKeys(Keys.RETURN);
	}

	private void clickAndEnterCSS(String locator) throws InterruptedException {
		WebElement element = driver.findElement(By.cssSelector(locator));
		Thread.sleep(1000);
		element.click();
		Thread.sleep(500);
		element.sendKeys(Keys.RETURN);
	}
	private void clickInputAndEnter(String locator, String Values) throws InterruptedException {
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
		Thread.sleep(1000);
		element.sendKeys(Values);
		Thread.sleep(2000);
		element.sendKeys(Keys.RETURN);
	}
	
	private void inputAndEnter(String locator, String Values) throws InterruptedException {
		WebElement element = driver.findElement(By.xpath(locator));
		//element.click();
		Thread.sleep(1000);
		element.sendKeys(Values);
		Thread.sleep(2000);
		element.sendKeys(Keys.RETURN);
	}
	
	private void clickNumId(String locator) throws InterruptedException {
		System.out.println("In clicknumidimpl");
		Thread.sleep(1000);
		locator = locator.substring(0, locator.length() - 2);
		clickId(locator);
	}

	/**
	 * It used to click on print so print label
	 * @param locator
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	private void print(String locator) throws InterruptedException, AWTException {
		Thread.sleep(5000);		
		WebDriverWait wait = new WebDriverWait(driver, 80);
		WebElement element = wait.until(ExpectedConditions
				.elementToBeClickable(By.id(locator)));
		element.click();
		Thread.sleep(7000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_W);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_W);
	}

	private void ClickPDF(String locator) throws InterruptedException {
		Thread.sleep(3000);
		ArrayList tabs = new ArrayList (driver.getWindowHandles());
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
		Thread.sleep(1000);
		element.click();
		Thread.sleep(400);
		driver.switchTo().window((String)tabs.get(0));
	}
	private void scrollToRight(String locator) throws InterruptedException {
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.cssSelector(locator));
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true);", element);
		element.click();
		Thread.sleep(1000);
	}

	private void scrollToRightUsingId(String locator) throws InterruptedException {
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.id(locator));
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true);", element);
		element.click();
		Thread.sleep(1000);
	}

	private void scrollAndClick(String locator) throws InterruptedException {
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.cssSelector(locator));
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(0,250);", element);
		element.click();
		Thread.sleep(1000);
	}
	
	
	
	
	
	private void scrollDown(String locator) throws InterruptedException {
		Thread.sleep(1000);
		WebElement element = driver.findElement(By.xpath(locator));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)", element);
		
		element.click();
		Thread.sleep(1000);
	}
	

	private void scrollAndClickXpath(String locator) throws InterruptedException {
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.xpath(locator));
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true);", element);
		Thread.sleep(700);
		element.click();
		Thread.sleep(1000);
	}

	private void selectAndInput(String locator, String values)
			throws InterruptedException {
		Thread.sleep(500);
		//values = values.substring(0, values.length() - 2);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement elem = driver.findElement(By.xpath(locator));
		// WebElement elem = driver.findElement(By.cssSelector(xPath));
		elem.sendKeys(Keys.CONTROL + "a");
		elem.sendKeys(Keys.DELETE);
		elem.sendKeys(values);
		elem.sendKeys(Keys.RETURN);
		Thread.sleep(1000);
	}

	private void selectAndInputId(String locator, String values)
			throws InterruptedException {
		values = values.substring(0, values.length() - 2);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement elem = driver.findElement(By.id(locator));
		// WebElement elem = driver.findElement(By.cssSelector(xPath));
		elem.sendKeys(Keys.CONTROL + "a");
		elem.sendKeys(Keys.DELETE);
		elem.sendKeys(values);
		elem.sendKeys(Keys.RETURN);
	}
	
	private void upload(String locator, String values)
			throws InterruptedException {
		String path = System.getProperty("user.dir")+values;
		File exl = new File(path);
		String getAbsPath = exl.getAbsolutePath();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement element = driver.findElement(By.xpath(locator));
		Thread.sleep(100);
		element.sendKeys(getAbsPath);
		Thread.sleep(1000);
//		element.sendKeys(Keys.RETURN);
//		Thread.sleep(800);
	}
	private void createName(String locator, String values)
			throws InterruptedException {
		int no= (int)(Math.random()*1000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement element = driver.findElement(By.xpath(locator));
		Thread.sleep(100);
		element.sendKeys(values+no);
		Thread.sleep(1000);	
	}
	/*	private void inputDate(String locator, String values) throws InterruptedException, Exception {
			Thread.sleep(3000);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
			Thread.sleep(1000);		
			datePickerPage = new DatePickerPage(driver);
		   // SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		    Date date = formatter.parse(values);
	        element.sendKeys(formatter.format(date));
		    element.sendKeys(Keys.TAB);
					Thread.sleep(400);	}*/
		private void inputDate(String locator, String values) {
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			By calendarXpath=By.xpath(locator+"/a[text()='"+values+"']");
			//By calendarXpath=By.xpath("table//td/a[text()='"+values+"']");
			driver.findElement(calendarXpath).click();
		}
		
		private void assertionUpload(String locator)
				throws InterruptedException {
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				String s = driver.findElement(By.xpath(locator)).getText();
				if(!s.equals("0")) { 
				   System.out.println("In assertion: true");
				   System.out.println("Uploaded:"+ s );
				}
				else {
				   System.out.println("In assertion: false");
				   System.out.println("Uploaded 0 Records: " );
				}}
	
	public void beforeMethod(String module) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement element = driver.findElement(By.xpath(module));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoViewIfNeeded();", element);
		element.click();
		Thread.sleep(1000);		
	}

	public void tearDownMethod() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@title='Home']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@title='Profile']")).click();
		driver.findElement(By.id("btnLogout")).click();
		Thread.sleep(1000);
		boolean isElemPresent = isElementPresent(By.xpath(ApplicationConstants.LOGIN_BUTTON));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("In Teardown:" + isElemPresent);
		Assert.assertEquals(isElemPresent, true);
		Thread.sleep(1000);
		driver.close();
		driver.quit();
		
	}
	

	
	/** public void takeScreenshot(WebDriver driver, String sTestCaseName, ITestResult result) throws Exception {
		
		try{
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(ApplicationConstants.Path_ScreenShot + sTestCaseName +".jpg"));	
		} catch (Exception e){
		//use Log.error : future enhancement
			Log.getLogger("Class Utils | Method takeScreenshot | Exception occured while capturing ScreenShot : "+e.getMessage());
			throw new Exception();
		}
		
	} **/
	
	public void captureScreenshot(ITestResult result)throws InterruptedException
	{
	 
	if(ITestResult.FAILURE==result.getStatus())
	{
		try 
		{
				TakesScreenshot ts=(TakesScreenshot)driver;
	
				File source=ts.getScreenshotAs(OutputType.FILE);
	 
				FileUtils.copyFile(source, new File("D:/Working/workspaces/epps-automation/epps-test/Screenshots/"+result.getName()+".png"));
	 
				System.out.println("Screenshot taken");
		} 
		catch (Exception e)
		{
	 
				System.out.println("Exception while taking screenshot "+e.getMessage());
		} 
	 
	}

	}
	
}
	
