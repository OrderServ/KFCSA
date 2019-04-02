package KFCSAMavenProject.Run.Registration;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import KFCSAMavenProject.Data.Data;
import KFCSAMavenProject.Properties.properties;
import KFCSAMavenProject.Run.Login.TC_01;
import KFCSAMavenProject.Utilities.extentFactory;
import KFCSAMavenProject.Utilities.insertIntoLogFile;
import KFCSAMavenProject.BusinessComponents.*;

public class NewTest {
	WebDriver driver;
	Data data;
	ExtentReports report;
	ExtentTest logger;
	loginPageComponents loginPageComponents = new loginPageComponents();
	
	
	@BeforeTest
	public void setUp() throws Exception
	{
		  System.out.println("before test");
		  String dt = properties.getDataFromProperty("TestData");
		  data = new Data(dt);
		  report = extentFactory.startReport();
		  driver = KFCSAMavenProject.Driver.driver.selectBrowser(data.getData(0, 0, 0));
		
	}
  @Test
  public void verifyPresenceOfElements()throws Exception {
	  logger = report.startTest("validateLogin");
	  insertIntoLogFile.insertToLog("starting test case"+TC_01.class.getName(), true);	
	  driver.get("https://order.kfc.co.za");
	  driver.manage().window().maximize();
	  insertIntoLogFile.insertToLog("browser is up and running", true);
	  loginPageComponents.navigateToLoginPage(driver);
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
