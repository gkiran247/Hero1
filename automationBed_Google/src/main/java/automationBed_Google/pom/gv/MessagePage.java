package automationBed_Google.pom.gv;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import automationBed_Google.utility.ReportManager.AdvanceReporting;
import automationBed_Google.utility.base.Utils;
import automationBed_Google.utility.dataManager.DmConfig;

public class MessagePage
{

	//Locators
	@FindBy(xpath="//*[contains(@content,'ProfileNames')]")
	WebElement firstMessage;
	@FindBy(xpath="//*[@role='gridcell']/*[@role='img']")
	WebElement threeDotsOption;
	

	
	public MessagePage clickfirstMessage() throws Exception
	{
		try
		{
			Utils.uBase.waitForElement(firstMessage);
			AdvanceReporting.addLogs("pass", "Calls Page","Calls Page");
			Utils.uBase.clickWebelement(firstMessage);
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace();
		}
		return this;
	}
}





