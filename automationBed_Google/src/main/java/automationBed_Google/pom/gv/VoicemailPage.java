package automationBed_Google.pom.gv;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import automationBed_Google.utility.ReportManager.AdvanceReporting;
import automationBed_Google.utility.base.Utils;
import automationBed_Google.utility.dataManager.DmConfig;

public class VoicemailPage
{

	//Locators
	@FindBy(xpath="//*[contains(@content,'ProfileNames')]")
	WebElement firstVoicemail;
	@FindBy(xpath="//*[@role='gridcell']/*[@role='img']")
	WebElement threeDotsOption;
	
	@FindBy(xpath="//*[contains(@gv-test-id,'inbox-summary-greeting')]")
	WebElement InboxSummaryGreeting;
	
	
	@FindBy(xpath="//md-content/div[1]/gv-nav-tab[3]/div/gv-nav-item/div[1]")
	WebElement VoiceMailIcon;
	
	@FindBy(xpath="//*[@id='messaging-view']/div/md-content/div/gv-conversation-list/md-virtual-repeat-container/div/div[2]")
	WebElement GvSearchList;
	
	@FindBy(xpath="//*[@id='messaging-view']/div/md-content/div/gv-conversation-list/div[2]")
	WebElement GvSearchListNoItems;
	
	@FindBy(xpath="//div[1]/div/gv-voicemail-thread-item/gv-thread-item/div")
	WebElement FirstvoicemailFromList;
	

	@FindBy(xpath="//div/gv-message-list/div/gv-voicemail-player/div/div[1]/md-content/div")
	WebElement voicemailDetailsSection;
	
	@FindBy(xpath="//*[contains(@aria-label,'Make a call') and @type='button']")
	WebElement MakeACallToolTip;
	
	@FindBy(xpath="//*[contains(@aria-label,'Message') and @type='button']")
	WebElement MessageToolTip;
	
	@FindBy(xpath="//*[contains(@aria-label,'More options') and @type='button']")
	WebElement MoreOptionsToolTip;
	
	@FindBy(xpath="//gv-phone-number-card/div/div[2]")
	WebElement voicemailDetailsPhoneNumber;
	
	@FindBy(xpath="//gv-message-list-header/div/div[1]")
	WebElement PhoneNumberMenu;	
	
	@FindBy(xpath="//*[@id='messaging-view']/div/md-content/gv-thread-details/div/gv-message-list/div/gv-voicemail-player/div/div[1]/md-content/div/div/div")
	WebElement voicemailDetailsDateValue;
	
	@FindBy(xpath="//*[@id='messaging-view']/div/md-content/gv-thread-details/div/gv-message-list/div/gv-voicemail-player/div/div[1]/md-content/div/div/gv-annotation")
	WebElement voicemailTypeDetails;
	
	@FindBy(xpath="//*[@id='messaging-view']/div/md-content/div/gv-conversation-list/md-virtual-repeat-container/div/div[2]/div[1]/div/gv-voicemail-thread-item/gv-thread-item/div/div[2]/ng-transclude/gv-thread-item-detail/div/div[1]")
	WebElement voicemailTypeFirstSearchList;
	
	public VoicemailPage clickfirstVoicemail() throws Exception
	{
		try
		{
			Utils.uBase.waitForElement(firstVoicemail);
			AdvanceReporting.addLogs("pass", "Calls Page","Calls Page");
			Utils.uBase.clickWebelement(firstVoicemail);
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace();
		}
		return this;
	}

	public VoicemailPage VoicemailPageVerifications(String SearchText) throws Exception
	{

		try
		{
			Utils.uBase.waitForElementToBeClickable(InboxSummaryGreeting);
			AdvanceReporting.addLogs("pass", "Moya Home Page","Moya Home Page");
			
			//Click on Voice Mail Icon Button
			Utils.uBase.waitForElementToBeClickable(VoiceMailIcon);
			Utils.uBase.clickWebelement(VoiceMailIcon);
			AdvanceReporting.addLogs("pass", "Clicked on Voice Mail Icon Button succesfully");
			AdvanceReporting.addLogs("pass", "Clicked on Voice Mail Icon Button succesfully", "Clicked on Voice Mail Icon Button succesfully");
			
			Utils.uBase.isElementPresentInEitherOf_webelement(GvSearchList, GvSearchListNoItems);
				
			//Click on First voice mail From List
			Utils.uBase.waitForElementToBeClickable(FirstvoicemailFromList);
			Utils.uBase.clickWebelement(FirstvoicemailFromList);
			AdvanceReporting.addLogs("pass", "Clicked on First voice mail From List Button succesfully");
			AdvanceReporting.addLogs("pass", "Clicked on First voice mail From List Button succesfully", "Clicked on First voice mail From List Button succesfully");
			
			Utils.uBase.waitForElementToBeClickable(voicemailDetailsSection);
	    	AdvanceReporting.addLogs("pass", "voicemail Screen is Visiable","voicemail Screen is Visiable");
			
			//check MakeACallToolTip available  
            Utils.uBase.scrolltoElement(MakeACallToolTip);
            Utils.uBase.hoverWebelement(MakeACallToolTip); 					
			AdvanceReporting.addLogs("pass", "MakeACallToolTip Is avalible successfully");
			AdvanceReporting.addLogs("pass", "MakeACallToolTip Is avalible successfully", "MakeACallToolTip Is avalible successfully");
			
			//check MessageToolTip available  
            Utils.uBase.scrolltoElement(MessageToolTip);
            Utils.uBase.hoverWebelement(MessageToolTip); 					
			AdvanceReporting.addLogs("pass", "MessageToolTip Is avalible successfully");
			AdvanceReporting.addLogs("pass", "MessageToolTip Is avalible successfully", "MessageToolTip Is avalible successfully");
			
			//check MoreOptionsToolTip available  
            Utils.uBase.scrolltoElement(MoreOptionsToolTip);
            Utils.uBase.hoverWebelement(MoreOptionsToolTip); 					
			AdvanceReporting.addLogs("pass", "MoreOptionsToolTip Is avalible successfully");
			AdvanceReporting.addLogs("pass", "MoreOptionsToolTip Is avalible successfully", "MoreOptionsToolTip Is avalible successfully");
			
			//get actual row text
        	String PhoneNumberActual=Utils.uBase.getText(voicemailDetailsPhoneNumber);
        	String PhoneNumberExcepted=Utils.uBase.getText(PhoneNumberMenu);
           	if( PhoneNumberExcepted.contains(PhoneNumberActual))
           	{
           		System.out.println("Got Phone Number");
           		AdvanceReporting.addLogs("pass", "Phone Number Is avalible successfully");
    			AdvanceReporting.addLogs("pass", "Phone Number Is avalible successfully", "Phone Number Is avalible successfully");    			
           	}
           	else 
           	{
           		System.out.println("No Phone Number");
           		AdvanceReporting.addLogs("fail", "Phone Number Is not avalible");
    			AdvanceReporting.addLogs("fail", "Phone Number Is not avalible", "Phone Number Is not avalible");    			
           	}
			
           	//Convert date 
           	String DateValue = Utils.uBase.getText(voicemailDetailsDateValue);           	
           	SimpleDateFormat in = new SimpleDateFormat("MMM dd, yyyy, hh:mm a");           	                     
           	Date date = in.parse(DateValue);
           	
           //	present date 
           	Date date1 = new Date();
          
           	// Validate date 
        	if(date.before(date1))
        	{
        		System.out.println("Date is in Correct Format");
           		AdvanceReporting.addLogs("pass", "Date is in Correct Format Is avalible successfully");
    			AdvanceReporting.addLogs("pass", "Date is in Correct Format Is avalible successfully", "Date is in Correct Format Is avalible successfully");    			
        	}
        	else 
        	{
        		System.out.println("Date is not in Correct Format");
           		AdvanceReporting.addLogs("fail", "Date is not in Correct Format");
    			AdvanceReporting.addLogs("fail", "Date is not in Correct Format", "Date is not in Correct Format");
        	}
        	
        	
        	 
            	
            	String voicemailTypeDetailsActual = Utils.uBase.getText(voicemailTypeDetails); 
            	String voicemailTypeFirstItemExpected = Utils.uBase.getText(voicemailTypeFirstSearchList);    
        	   
        	 // Validate Type
            	if(voicemailTypeDetailsActual.contains(voicemailTypeFirstItemExpected))
            	{
            		System.out.println("Type is in Correct Format");
               		AdvanceReporting.addLogs("pass", "Type is in Correct Format Is avalible successfully");
        			AdvanceReporting.addLogs("pass", "Type is in Correct Format Is avalible successfully", "Type is in Correct Format Is avalible successfully");    			
            	}
            	else 
            	{
            		System.out.println("Type is not in Correct Format");
               		AdvanceReporting.addLogs("fail", "Type is not in Correct Format");
        			AdvanceReporting.addLogs("fail", "Type is not in Correct Format", "Type is not in Correct Format");
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





