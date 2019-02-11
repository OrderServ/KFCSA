package KFCSAMavenProject.BusinessComponents;

import org.openqa.selenium.WebDriver;

import KFCSAMavenProject.PageObjects.myAccountPageElements;
import KFCSAMavenProject.Utilities.insertIntoLogFile;
import KFCSAMavenProject.Utilities.reusableMethods;

public class myAccountPageComponents {
	
	
	public boolean logOut(WebDriver driver) throws Exception
	{
		try
		{
			insertIntoLogFile.insertToLog("logOut method invoked", true);
			reusableMethods.clickObject(driver, myAccountPageElements.xUserName);
			reusableMethods.clickObject(driver, myAccountPageElements.xLogOutLink);
			return true;
		}	
		catch(Exception e)
		{
			insertIntoLogFile.insertToLog(e.toString(), false);
			return false;
		}
	}

}
