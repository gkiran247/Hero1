package automationBed_Google.pom.gv;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import automationBed_Google.utility.ReportManager.AdvanceReporting;
import automationBed_Google.utility.base.Utils;

public class GVSignInPage
{

	//Locators
	@FindBy(xpath="//*[@id='header']//*[contains(@href,'/signup')]")
	WebElement signInBtn;
	@FindBy(xpath="//input[@id='identifierId']")
	WebElement logInID;
	@FindBy(xpath="//span[.='Next']")
	WebElement logInNxtBtn;
	@FindBy(xpath="//*[contains(@name,'password')]")
	WebElement logInPWD;

	
	public GVSignInPage clickHomeSignIn() throws Exception
	{
		try
		{
			Utils.uBase.waitForElementToBeClickable(signInBtn);
			AdvanceReporting.addLogs("pass", "SignIn Page","SignIn Page");
			Utils.uBase.clickWebelement(signInBtn);
			AdvanceReporting.addLogs("pass", "Clicked on SignIn Button");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace();
		}

		return this;
	}
	public GVSignInPage enterLoginID(String email) throws Exception
	{

		try
		{
			Utils.uBase.waitForElementToBeClickable(logInID);
			AdvanceReporting.addLogs("pass", "logInID Page","logInID Page");
			Utils.uBase.setText(logInID, email);
			AdvanceReporting.addLogs("pass", "Email Id entered is : "+email);
			AdvanceReporting.addLogs("pass", "Email Id entered", "Email Id entered");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace();
		}

		return this;
	}
	
	public GVSignInPage clickNextButton() throws Exception
	{
		try
		{
			Utils.uBase.waitForElementToBeClickable(logInNxtBtn);
			Utils.uBase.clickWebelement(logInNxtBtn);
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace();
		}
		return this;
	}
	
	public GVSignInPage enterPassword(String password) throws Exception
	{
		try
		{
			Utils.uBase.waitForElementToBeClickable(logInPWD);
			AdvanceReporting.addLogs("pass", "Password Page");
			AdvanceReporting.addLogs("pass", "logInPWD Page","logInPWD Page");
			Utils.uBase.setText(logInPWD, password);
			AdvanceReporting.addLogs("pass", "Password entered");
			AdvanceReporting.addLogs("pass", "Password entered", "Password entered");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace();
		}

		return this;
	}
}





