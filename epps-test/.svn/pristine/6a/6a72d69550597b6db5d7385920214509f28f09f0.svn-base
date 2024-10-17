package com.epps.cucumberTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When; 

public class CucumberJava { 
   WebDriver driver = null; 
	
 @Given("^I have open the browser$") 
   public void openBrowser() { 
      //driver = new FirefoxDriver(); 
      
      System.setProperty("webdriver.chrome.driver","C:/Users/Atik Pathan/Desktop/epps-selenium(Backup)/Explorer-drivers/chromedriver.exe");
		 driver = new ChromeDriver();	
   } 
	
   @When("^I open Facebook website$") 
   public void goToFacebook() { 
	   driver.get("https://www.facebook.com/");
     // driver.navigate().to("https://www.gmail.com/"); 
   } 
	
   @Then("^Login button should exits$") 
   public void loginButton() { 
      if(driver.findElement(By.id("u_0_v")).isEnabled()) { 
         System.out.println("Test 1 Pass"); 
      } else { 
         System.out.println("Test 1 Fail"); 
      } 
      driver.close(); 
   } 
}
