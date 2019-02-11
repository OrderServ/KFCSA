package KFCSAMavenProject.PageObjects;

import org.openqa.selenium.By;

public class loginPageElements {
	
	public static final By xSignInlink = By.xpath("//*[@id='header-wrap']/div/div[2]/div[3]/a[1]");
	public static final By xEmailAddressTextBox = By.xpath("//*[@id='txtUserId']");
	public static final By xPasswordTextBox = By.xpath("//*[@id='Password']");
	public static final By xSignInButton = By.xpath("//*[@id='signInForm']/div[2]/div/div[2]/div/div/div/div[5]/button");
	public static final By xForgotYourPasswordLink = By.xpath("");
	public static final By xForgotYourPassword_EmailAddressTextBox = By.xpath("");
	public static final By xForgotYourPassword_SubmitButton = By.xpath("");
	public static final By xForgotYourPassword_PopUpCancelButton = By.xpath("");
	public static final By xInvalidLoginCredentialErrorMessage = By.xpath("//*[@id='vaidationerrors']");
	public static final By xUserName = By.xpath("//*[@id='header-wrap']/div/div[2]/div[3]/a");
	
	
		
	

}
