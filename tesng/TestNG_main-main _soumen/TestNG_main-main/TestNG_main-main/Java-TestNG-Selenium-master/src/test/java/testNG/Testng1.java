package testNG;

//import java.lang.reflect.Method;
//import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
//import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import org.testng.asserts.SoftAssert;

import org.openqa.selenium.*;

public class Testng1 {

	 public RemoteWebDriver driver = null;
	  @Test(priority=0)
	  public void scenarioOne() throws Exception {
			  
				  WebDriverWait wait = new WebDriverWait(driver, 20);
				  Thread.sleep(3000);
			         //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".text-size-50.text-white.font-bold")));
			         //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".text-size-50.text-white.font-bold"))));
			         wait.until(ExpectedConditions.titleContains("Selenium Grid Online | Run Selenium Test On Cloud"));
			         String title = driver.getTitle();
			         SoftAssert softAssert = new SoftAssert();
			         Thread.sleep(2200);
			         softAssert.assertEquals(title, "LambdaTest");
			         System.out.println(title);
			         System.out.println("First test case passed");
				
			
	  }
	  @Test(priority=1)
	  public void secondScenario() throws InterruptedException
	  {
		  driver.findElement(By.xpath("//a[normalize-space()='Checkbox Demo']")).click();
		  driver.findElement(By.linkText("Checkbox Demo")).click();
			driver.findElement(By.xpath("/html/body/div[1]/div/section[3]/div/div/div[2]/div[1]/div[2]/div[1]/label")).click();
			WebElement checkbox=driver.findElement(By.id("isAgeSelected"));
			if(checkbox.isSelected()) {
				System.out.println("Selected");
				Thread.sleep(2000);
			}
			driver.findElement(By.xpath("/html/body/div[1]/div/section[3]/div/div/div[2]/div[1]/div[2]/div[1]/label")).click();
			if(!checkbox.isSelected()) {
				System.out.println("UnSelected");
				Thread.sleep(2000);
			}
			System.out.println("Second scenario done successfully");
	  }
	  @Test(priority=2)
	  public void thirdScenario() throws Exception
	  {
		  driver.get("https://www.lambdatest.com/selenium-playground/");
		  driver.findElement(By.linkText("Javascript Alerts")).click();
		  driver.findElement(By.xpath("//body/div[@id='__next']/section[4]/div[1]/div[1]/div[2]/div[1]/button[1]")).click();
		  System.out.println(driver.switchTo().alert().getText());
		  driver.switchTo().alert().accept();
		  System.out.println("Third test case passed");
	  }
	  @BeforeMethod
	  @Parameters({ "browser", "version", "platform" })
	  public void setUpClass(String browser, String version, String platform) throws Exception {

	  	String username = "soumenpatra419"; 
			String accesskey = "8LcAWkbiJJKiRt5K5XjZacE6IMLCL72LIAXWCcgdqBWVLic3GS"; 

	  		DesiredCapabilities capability = new DesiredCapabilities();    	
	        
	  		capability.setCapability(CapabilityType.BROWSER_NAME, browser);
	  		capability.setCapability(CapabilityType.VERSION,version);
	  		capability.setCapability(CapabilityType.PLATFORM, platform);		
	  		
	        capability.setCapability("build", "New TestNG");
	  		capability.setCapability("network", true);
	  		capability.setCapability("video", true);
	  		capability.setCapability("console", true);
	  		capability.setCapability("visual", true);

	  		String gridURL = "https://" + username + ":" + accesskey + "@hub.lambdatest.com/wd/hub";
	  		System.out.println(gridURL);
	  		driver = new RemoteWebDriver(new URL(gridURL), capability);
	  		System.out.println(capability);
	  		System.out.println(driver.getSessionId());
	          driver.get("https://www.lambdatest.com/selenium-playground/");
	          driver.manage().deleteAllCookies();
		 
	  }
	  @AfterMethod
	  public void close()
	  {
		  driver.quit();
	  }

}