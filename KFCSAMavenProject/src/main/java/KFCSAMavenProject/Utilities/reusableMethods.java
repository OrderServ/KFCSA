package KFCSAMavenProject.Utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class reusableMethods {
	
	public static boolean clickObject(WebDriver driver, By obj )throws Exception
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(obj));
			driver.findElement(obj).click();
			return true;
			
		}
		catch(Exception e)
		{
			e.getMessage();
			return false;
		}
	}
	
	public static void takeScreenShot(WebDriver driver, String screenShotname)
	{
		try 
		{
			TakesScreenshot ts =  (TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File ("./Screenshots/"+screenShotname+".png"));
			System.out.println("ScreenShot Taken");
								
		}
		catch(Exception e)
		{
			System.out.println("Exception occur while capturing screenshot"+e.getMessage());
		}
	}
	
	public static boolean enterData(WebDriver driver, By obj, String testData) throws Exception
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.elementToBeClickable(obj));
			driver.findElement(obj).sendKeys(testData);
			return true;
		}
		catch(Exception e)
		{
			e.getMessage();
			return false;
		}
	}
	
	public static boolean enterData(WebDriver driver, By obj, Keys key) throws Exception
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.elementToBeClickable(obj));
			driver.findElement(obj).sendKeys(key);
			return true;
		}
		catch(Exception e)
		{
			e.getMessage();
			return false;
		}
	}
	
	public static boolean verifyText(WebDriver driver, By obj, String testData)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.elementToBeClickable(obj));
			String output = driver.findElement(obj).getText();
			Assert.assertTrue(output.equalsIgnoreCase(testData));
			return true;
		}
		catch(Exception e)
		{
			e.getMessage();
			return false;
		}
		
		
	}
	
	public static boolean verifyElementPresence(WebDriver driver, By obj)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj));
			WebElement e = driver.findElement(obj);
			if(e.isEnabled())
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			return false;
		}
	}


}
