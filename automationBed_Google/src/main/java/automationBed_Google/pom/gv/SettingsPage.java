package automationBed_Google.pom.gv;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import automationBed_Google.utility.ReportManager.AdvanceReporting;
import automationBed_Google.utility.base.Utils;
import automationBed_Google.utility.dataManager.DmConfig;

public class SettingsPage
{

	//Locators
	@FindBy(xpath="//*[contains(@class,'lQP0Od-wKtwcc')]")
	WebElement gvNumb;
	@FindBy(xpath="//*[contains(@aria-label,'Change Google Voice number')]")
	WebElement gvChangeBtn;
	@FindBy(xpath="//*[contains(@aria-label,'Transfer Google Voice number')]")
	WebElement gvTransferBtn;
	@FindBy(xpath="//*[contains(@aria-label,'Delete Google Voice number')]")
	WebElement gvDeleteBtn;
	@FindBy(xpath="//*[contains(@ng-click,'BillingHistoryClick')]")
	WebElement gvBillingHistoryBtn;
	
	
	//ListofSelectedFirst
	String TableRowSelectedFirst="//gv-settings-view/div/md-content[1]/div[";	
	//ListofSelectedLast
	String TableRowSelectedLast="]";
	
	String ListofHeader="//div/h3";
	
	@FindBy(xpath="//gv-settings-view/div/md-content[1]/h2")
	WebElement SettingHeading;
	

	public SettingsPage getGvNum() throws Exception
	{
		try
		{
			Utils.uBase.waitForElement(gvNumb);
			AdvanceReporting.addLogs("pass", "Settings Page","Settings Page");
			String gvNumber = gvNumb.getText();
			String expGVNum = DmConfig.getString("GV.Number");
			assertEquals(gvNumber, expGVNum);
			AdvanceReporting.addLogs("pass", "Google Voice Number is : "+gvNumber);
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace();
		}
		return this;
	}
	public SettingsPage verifyChangeBtn() throws Exception
	{
		try
		{
			Utils.uBase.waitForElementToBeClickable(gvChangeBtn);
			AdvanceReporting.addLogs("pass", "Google Voice Change Number Button is Available");
			AdvanceReporting.addElementImage("pass", gvChangeBtn);
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace();
		}
		return this;
	}
	public SettingsPage verifyTransfer() throws Exception
	{
		try
		{
			Utils.uBase.waitForElementToBeClickable(gvTransferBtn);
			AdvanceReporting.addLogs("pass", "Google Voice Transfer Number Button is Available");
			AdvanceReporting.addElementImage("pass", gvTransferBtn);
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace();
		}
		return this;
	}
	public SettingsPage verifyDelete() throws Exception
	{
		try
		{
			Utils.uBase.waitForElementToBeClickable(gvDeleteBtn);
			AdvanceReporting.addLogs("pass", "Google Voice Delete Number Button is Available");
			AdvanceReporting.addElementImage("pass", gvDeleteBtn);
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace();
		}
		return this;
	}
	public SettingsPage changeRedirection() throws Exception
	{
		try
		{
			Utils.uBase.waitForElementToBeClickable(gvChangeBtn);
			Utils.uBase.clickWebelement(gvChangeBtn);
			AdvanceReporting.addLogs("pass", "Clicked on Change Button");
			Utils.uBase.switchToNewWindow();
			Utils.uBase.getCurrentUrl();
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace();
		}
		return this;
	}
	public SettingsPage transferRedirection() throws Exception
	{
		try
		{
			Utils.uBase.waitForElementToBeClickable(gvTransferBtn);
			Utils.uBase.clickWebelement(gvTransferBtn);
			AdvanceReporting.addLogs("pass", "Clicked on Transfer Button");
			Utils.uBase.switchToNewWindow();
			Utils.uBase.getCurrentUrl();
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace();
		}
		return this;
	}
	public SettingsPage deleteRedirection() throws Exception
	{
		try
		{
			Utils.uBase.waitForElementToBeClickable(gvDeleteBtn);
			Utils.uBase.clickWebelement(gvDeleteBtn);
			AdvanceReporting.addLogs("pass", "Clicked on Delete Button");
			Utils.uBase.switchToNewWindow();
			Utils.uBase.getCurrentUrl();
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace();
		}
		return this;
	}
	public SettingsPage clickBillingHistoryBtn() throws Exception
	{
		try
		{
			Utils.uBase.scrolltoElement(gvBillingHistoryBtn);
			AdvanceReporting.addElementImage("info", gvBillingHistoryBtn);
			Utils.uBase.clickWebelement(gvBillingHistoryBtn);
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace();
		}
		return this;
	}

	public SettingsPage SettingPageHeaderVerification() throws Exception
	{
		try
		{
			Utils.uBase.waitForElement(SettingHeading);
			List<WebElement> element  = Utils.uBase.driver.findElements(By.xpath(ListofHeader));
			int i= 1;
			for(WebElement count:element)
			{
				String ValueActual = count.getText();
				Utils.uBase.driver.findElement(By.xpath(TableRowSelectedFirst + i + TableRowSelectedLast)).click();
				String ValueExpect = Utils.uBase.driver.findElement(By.xpath(TableRowSelectedFirst + i + TableRowSelectedLast)).getText();
			
				if(ValueActual.contains(ValueExpect))
	           	{
	           		System.out.println("Verify settings page texts is Matched with the menu Tab "+ValueActual+" and with Header Value "+ValueExpect+" ");
	           		AdvanceReporting.addLogs("pass", "Verify settings page texts is Matched with the menu Tab "+ValueActual+" and with Header Value "+ValueExpect+" successfully");
	    			AdvanceReporting.addLogs("pass", "Verify settings page texts is Matched with the menu Tab "+ValueActual+" and with Header Value "+ValueExpect+" successfully", "Verify settings page texts is Matched with the menu Tab "+ValueActual+" and with Header Value "+ValueExpect+" successfully");    			
	           	}
	           	else 
	           	{
	           		System.out.println("Verify settings page texts is Not Matched with the menu Tab "+ValueActual+" and with Header Value "+ValueExpect+"");
	           		AdvanceReporting.addLogs("fail", "texts is Not Matched with the menu Tab "+ValueActual+" and with Header Value "+ValueExpect+"");
	    			AdvanceReporting.addLogs("fail", "texts is Not Matched with the menu Tab "+ValueActual+" and with Header Value "+ValueExpect+"", "texts is Not Matched with the menu Tab "+ValueActual+" and with Header Value "+ValueExpect+"");    			
	           	}
				i++;
			}
			

		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace();
		}
		return this;
	}

}





