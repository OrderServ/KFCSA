package KFCSAMavenProject.Run;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.asserts.Assertion;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import KFCSAMavenProject.Data.Data;
import KFCSAMavenProject.Properties.properties;
import KFCSAMavenProject.Utilities.extentFactory;
import KFCSAMavenProject.Utilities.insertIntoLogFile;
import KFCSAMavenProject.BusinessComponents.*;

public class TC_01 {
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
	
	@BeforeTest
	public void setUp() throws Exception
	{
		  System.out.println("before test");
		  String dt = properties.getDataFromProperty("TestData");
		  data = new Data(dt);
		  report = extentFactory.startReport();
		  driver = KFCSAMavenProject.Driver.driver.selectBrowser(data.getData(0, 0, 0));
		
	}
	
	  @Test(retryAnalyzer = KFCSAMavenProject.Utilities.retryAnalyzer.class,priority = 1)
	  public void validateLogin() throws Exception {
		 try
		 {
			  logger = report.startTest("validateLogin");
			  insertIntoLogFile.insertToLog("starting test case"+TC_01.class.getName(), true);	
			  driver.get("https://order.kfc.co.za");
			  driver.manage().window().maximize();
			  insertIntoLogFile.insertToLog("browser is up and running", true);
			  loginPageComponents.navigateToLoginPage(driver);
			  loginPageComponents.login(driver,data.getData(0, 1, 2),data.getData(0, 1, 3));
			  insertIntoLogFile.insertToLog("login id : "+data.getData(0, 1, 2)+" login password : "+data.getData(0, 1, 3), true);
			  WebElement userName = driver.findElement(By.xpath("//*[@id='header-wrap']/div/div[2]/div[3]/a"));
			  String actualUserName = userName.getText();
			  if(actualUserName.equalsIgnoreCase(data.getData(0, 1, 4)))
			  {
				  logger.log(LogStatus.PASS, "login passed");
			  }
			  else
			  {
				  logger.log(LogStatus.FAIL, "login failed");
				  insertIntoLogFile.insertToLog(TC_01.class.getName()+" failed", false);
			  }
		 }
		 catch(Exception e)
		 {
			 insertIntoLogFile.insertToLog(e.toString()+" failed", true);
			 
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
