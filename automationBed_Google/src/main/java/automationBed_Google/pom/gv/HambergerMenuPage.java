package automationBed_Google.pom.gv;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import automationBed_Google.utility.ReportManager.AdvanceReporting;
import automationBed_Google.utility.base.Utils;

public class HambergerMenuPage
{

	//Locators
	@FindBy(xpath="//*[contains(@aria-label,'Main menu')]")
	WebElement menuIcn;
	@FindBy(xpath="//*[contains(@aria-label,'Settings')]/div[contains(@class,'flex md')]")
	WebElement settingsTab;
	@FindBy(xpath="//*[contains(@aria-label,'Calls')]/div[contains(@class,'flex md')]")
	WebElement callsTab;
	@FindBy(xpath="//*[contains(@aria-label,'Messages')]/div[contains(@class,'flex md')]")
	WebElement messagesTab;
	@FindBy(xpath="//*[contains(@aria-label,'Voicemail')]/div[contains(@class,'flex md')]")
	WebElement voicemailTab;


	public HambergerMenuPage clickMainMenu() throws Exception
	{

		try
		{
			Utils.uBase.waitForElementToBeClickable(menuIcn);
			AdvanceReporting.addLogs("pass", "Home Page","Home Page");
			Utils.uBase.clickWebelement(menuIcn);
			AdvanceReporting.addLogs("pass", "Clicked on Hamberger Menu");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace();
		}

		return this;
	}

	public HambergerMenuPage clickSettings() throws Exception
	{

		try
		{
			Utils.uBase.waitForElementToBeClickable(settingsTab);
			Utils.uBase.clickWebelement(settingsTab);
			AdvanceReporting.addLogs("pass", "Clicked on Settings in Hamberger Menu");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace();
		}

		return this;
	}
	public HambergerMenuPage clickCalls() throws Exception
	{
		try
		{
			Utils.uBase.waitForElementToBeClickable(callsTab);
			Utils.uBase.clickWebelement(callsTab);
			AdvanceReporting.addLogs("pass", "Clicked on Call tab in Hamberger Menu");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace();
		}

		return this;
	}
	public HambergerMenuPage clickMessages() throws Exception
	{
		try
		{
			Utils.uBase.waitForElementToBeClickable(messagesTab);
			Utils.uBase.clickWebelement(messagesTab);
			AdvanceReporting.addLogs("pass", "Clicked on Messages tab in Hamberger Menu");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace();
		}
		return this;
	}
	public HambergerMenuPage clickVoicemail() throws Exception
	{
		try
		{
			Utils.uBase.waitForElementToBeClickable(voicemailTab);
			Utils.uBase.clickWebelement(voicemailTab);
			AdvanceReporting.addLogs("pass", "Clicked on Voice Mail tab in Hamberger Menu");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace();
		}
		return this;
	}
}





