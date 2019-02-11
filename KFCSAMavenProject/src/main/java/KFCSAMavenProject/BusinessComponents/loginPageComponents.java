package KFCSAMavenProject.BusinessComponents;

import org.openqa.selenium.WebDriver;
import KFCSAMavenProject.PageObjects.loginPageElements;
import KFCSAMavenProject.Utilities.insertIntoLogFile;
import KFCSAMavenProject.Utilities.reusableMethods;

public class loginPageComponents {
	
	
	public boolean navigateToLoginPage(WebDriver driver) throws Exception
	{
		try
		{
			insertIntoLogFile.insertToLog("navigateToLoginPage method", true);
			Thread.sleep(3000);
			reusableMethods.clickObject(driver, loginPageElements.xSignInlink);
			return true;
			
		}
		catch(Exception e)
		{
			insertIntoLogFile.insertToLog("navigateToLoginPage method failed "+e.toString(), false);
			return false;
		}
	}
	
	public boolean login(WebDriver driver,String emailID, String password) throws Exception
	{
		try
		{
			insertIntoLogFile.insertToLog("login method invoked", true);
			reusableMethods.enterData(driver, loginPageElements.xEmailAddressTextBox, emailID);
			reusableMethods.enterData(driver, loginPageElements.xPasswordTextBox, password);
			reusableMethods.clickObject(driver, loginPageElements.xSignInButton);
			return true;
			
			
		}
		catch(Exception e)
		{
			insertIntoLogFile.insertToLog("login method failed "+e.toString(), false);
			return false;
		}
	}
	
}
