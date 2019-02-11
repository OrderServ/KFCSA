package KFCSAMavenProject.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import KFCSAMavenProject.Properties.*;

public class driver {
	
	 static WebDriver driver = null;
	 
	 public static WebDriver selectBrowser(String browser)
	 {
		 if(browser.equalsIgnoreCase("Chrome"))
		 {
			 try
			 {
				 String cd = properties.getDataFromProperty("ChromeDriver");
				 System.setProperty("webdriver.chrome.driver", cd);
				 driver = new ChromeDriver();
			 }
			 catch(Exception e)
			 {
				 e.getMessage();
			 }
		 }
		 return driver;
	 }
	

}
