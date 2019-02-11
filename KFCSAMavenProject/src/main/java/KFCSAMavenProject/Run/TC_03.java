package KFCSAMavenProject.Run;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.asserts.Assertion;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import KFCSAMavenProject.Data.Data;
import KFCSAMavenProject.PageObjects.loginPageElements;
import KFCSAMavenProject.Properties.properties;
import KFCSAMavenProject.Utilities.extentFactory;
import KFCSAMavenProject.Utilities.insertIntoLogFile;
import KFCSAMavenProject.Utilities.reusableMethods;
import KFCSAMavenProject.BusinessComponents.*;

public class TC_03 {
	WebDriver driver;
	Data data;
	ExtentReports report;
	ExtentTest logger;
	loginPageComponents loginPageComponents = new loginPageComponents();
	
	
	
	/*@BeforeClass
	  public void beforeClass() throws Exception {
		  
		  String dt = properties.getDataFromProperty("TestData");
		  data = new Data(dt);
		  report = extentFactory.startReport();
		  driver = KFCSAMavenProject.Driver.driver.selectBrowser(data.getData(0, 0, 0));
		
	  }*/
	
	@BeforeMethod
	public void setUp() throws Exception
	{
		  System.out.println("before test");
		  String dt = properties.getDataFromProperty("TestData");
		  data = new Data(dt);
		  report = extentFactory.startReport();
		  driver = KFCSAMavenProject.Driver.driver.selectBrowser(data.getData(0, 0, 0));
		  driver.get("https://order.kfc.co.za");
		  driver.manage().window().maximize();
		
	}
	
	  @Test(retryAnalyzer = KFCSAMavenProject.Utilities.retryAnalyzer.class,priority = 1)
	  public void validateInvalidLoginWithIncorrectPassword() throws Exception {
		 try
		 {
			  logger = report.startTest("validateInvalidLoginWithIncorrectPassword");
			  insertIntoLogFile.insertToLog("starting test case"+TC_03.class.getName(), true);	
			  insertIntoLogFile.insertToLog("browser is up and running", true);
			  loginPageComponents.navigateToLoginPage(driver);
			  loginPageComponents.login(driver,data.getData(0, 3, 2),data.getData(0, 3, 3));
			  insertIntoLogFile.insertToLog("login id : "+data.getData(0, 3, 2)+" login password : "+data.getData(0, 3, 3), true);
			  boolean result = reusableMethods.verifyText(driver, loginPageElements.xInvalidLoginCredentialErrorMessage, data.getData(0, 3, 4));
			  if(result == true)
			  {
				  logger.log(LogStatus.PASS, "validateInvalidLoginWithIncorrectPassword passed");
			  }
			  else
			  {
				  logger.log(LogStatus.FAIL, "validateInvalidLoginWithIncorrectPassword failed");
				  insertIntoLogFile.insertToLog(TC_03.class.getName()+" failed", false);
			  }
		 }
		 catch(Exception e)
		 {
			 insertIntoLogFile.insertToLog(e.toString()+" failed", true);
			 
		 }
			  
	  }
	  @Test(retryAnalyzer = KFCSAMavenProject.Utilities.retryAnalyzer.class,priority = 2)
	  public void validateInvalidLoginWithIncorrectEmailId()throws Exception
	  {
		  try
		  {
			  logger = report.startTest("validateInvalidLoginWithIncorrectEmailId");
			  insertIntoLogFile.insertToLog("starting test case"+TC_03.class.getName(), true);	
			  insertIntoLogFile.insertToLog("browser is up and running", true);
			  loginPageComponents.navigateToLoginPage(driver);
			  //reusableMethods.enterData(driver, loginPageElements.xEmailAddressTextBox, Keys.CLEAR);
			  loginPageComponents.login(driver,data.getData(0, 4, 2),data.getData(0, 4, 3));
			  boolean result = reusableMethods.verifyText(driver, loginPageElements.xInvalidLoginCredentialErrorMessage, data.getData(0, 3, 4));
			  if(result == true)
			  {
				  logger.log(LogStatus.PASS, "validateInvalidLoginWithIncorrectEmailId passed");
			  }
			  else
			  {
				  logger.log(LogStatus.FAIL, "validateInvalidLoginWithIncorrectEmailId failed");
				  insertIntoLogFile.insertToLog(TC_03.class.getName()+" failed", false);
			  }
		  }
		  catch(Exception e)
		  {
			  insertIntoLogFile.insertToLog(e.toString()+" failed", false);
		  }
	  }
	  @AfterMethod
	  public void getResult(ITestResult r)
			{
		  		if(r.getStatus() == ITestResult.FAILURE)
				{
					logger.log(LogStatus.FAIL, "Test Case failed is " + r.getName());
					logger.log(LogStatus.FAIL, "Test Case failed is " + r.getThrowable());
					
				}
				else if(r.getStatus() == ITestResult.SKIP)
				{
					logger.log(LogStatus.FAIL, "Test Case skipped is " + r.getName());
				}
		  		report.endTest(logger);
		  		
		 	}
	  
	  
	  @AfterTest
	  public void endReport()
	  {
		  report.flush();
		  report.close();
	  }
	  @AfterClass
	  public void afterClass() {
		  driver.close();
	  }
	  
	  


}
