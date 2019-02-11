package KFCSAMavenProject.Utilities;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;

public class extentFactory {
	
	public static ExtentReports startReport() throws Exception
	  {
		try
		{
		  insertIntoLogFile.insertToLog("initializing extent report", true);	
		  ExtentReports report;
		  report = new ExtentReports(System.getProperty("user.dir")+"/test-output/STMExtentReport.html", false);
		  report.addSystemInfo("Host Name","OrderServ").addSystemInfo("Environment","PROD").addSystemInfo("User","Souvik");
		  report.loadConfig(new File(System.getenv("user.dir")+"/extent-config.xml"));
		  return report;
		}
		catch(Exception e)
		{
			insertIntoLogFile.insertToLog("error occured on initializing extent report"+e.toString(), false);
			return null;
		}
		
	  }

}
