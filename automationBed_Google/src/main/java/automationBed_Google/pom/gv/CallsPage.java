package automationBed_Google.pom.gv;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import automationBed_Google.utility.ReportManager.AdvanceReporting;
import automationBed_Google.utility.base.Utils;
import automationBed_Google.utility.dataManager.DmConfig;

public class CallsPage
{

	//Locators
	@FindBy(xpath="//*[contains(@ng-class,'isMakeCallDisabled()')]")
	WebElement makeACallBtn;
	@FindBy(xpath="//*[contains(@ng-change,'TextInputChange')]")
	WebElement contactInputField;
	@FindBy(xpath="//md-icon[.='arrow_drop_down']")
	WebElement dropDownArrow;
	@FindBy(xpath="//div[contains(@class,'hlKfD')]/button[1]/md-icon[@role='img']")
	WebElement callOption;
	@FindBy(xpath="//*[contains(@ng-class,'INPUT_ROW')]")
	WebElement inputRow;
	@FindBy(xpath="//*[contains(@class,'{::ctrl.Css.DETAILS}}')]")
	WebElement firstCalltype;
	@FindBy(xpath="//*[@role='gridcell']/*[@role='img']")
	WebElement threeDotsOption;
	@FindBy(xpath="//*[.='Use my phone to call']")
	WebElement useMyPhoneToCallOption;
	@FindBy(xpath="//*[@role='menu']")
	WebElement optionsMenu;
	
	@FindBy(xpath="//div[1]/div/gv-call-log-thread-item/gv-thread-item/div")
	WebElement FirstCallFromList;

	@FindBy(xpath="//md-content/div[1]/gv-nav-tab[1]/div/gv-nav-item/div[1]")
	WebElement CallsIcon;
	
	@FindBy(xpath="//table/tbody/tr")
	WebElement CallsDetails;
	
	@FindBy(xpath="//table/thead/tr")
	WebElement CallsDetailsTableHeader;
	
	@FindBy(xpath="//*[contains(@gv-test-id,'inbox-summary-greeting')]")
	WebElement InboxSummaryGreeting;
	
	@FindBy(xpath="//gv-phone-number-card/div/div[2]")
	WebElement CallsDetailsPhoneNumber;
	
	@FindBy(xpath="//gv-message-list-header/div/div[1]")
	WebElement PhoneNumberMenu;	
	
	@FindBy(xpath="//*[@id='messaging-view']/div/md-content/gv-thread-details/div/gv-message-list/div/gv-call-log/div/div/table/tbody/tr/td[1]")
	WebElement PhoneTypeDetails;
	
	@FindBy(xpath="//*[@id='messaging-view']/div/md-content/div/gv-conversation-list/md-virtual-repeat-container/div/div[2]/div[1]/div/gv-call-log-thread-item/gv-thread-item/div/div[2]/ng-transclude/gv-thread-item-detail/div")
	WebElement PhoneTypeFirstSearchList;
		
	@FindBy(xpath="//*[@id='messaging-view']/div/md-content/gv-thread-details/div/gv-message-list/div/gv-call-log/div/div/table/tbody/tr/td[3]")
	WebElement CallsDetailsDateValue;
	
	@FindBy(xpath="//*[@id='messaging-view']/div/md-content/gv-thread-details/div/gv-message-list/div/gv-call-log/div/div/table/tbody/tr/td[2]")
	WebElement CallsDetailsTimeValue;
	
	@FindBy(xpath="//*[contains(@aria-label,'Make a call') and @type='button']")
	WebElement MakeACallToolTip;
	
	@FindBy(xpath="//*[contains(@aria-label,'Message') and @type='button']")
	WebElement MessageToolTip;
	
	@FindBy(xpath="//*[contains(@aria-label,'More options') and @type='button']")
	WebElement MoreOptionsToolTip;
	
	@FindBy(xpath="//*[@id='messaging-view']/div/md-content/div/gv-conversation-list/md-virtual-repeat-container/div/div[2]")
	WebElement GvSearchList;
	
	@FindBy(xpath="//*[@id='messaging-view']/div/md-content/div/gv-conversation-list/div[2]")
	WebElement GvSearchListNoItems;
	
	
	public CallsPage clickMakeACall() throws Exception
	{
		try
		{
			Utils.uBase.waitForElement(firstCalltype);
			AdvanceReporting.addLogs("pass", "Calls Page","Calls Page");
			Utils.uBase.clickWebelement(makeACallBtn);
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace();
		}
		return this;
	}
	public CallsPage verifyDropDown(String numb) throws Exception
	{
		try
		{
			Utils.uBase.waitForElement(contactInputField);
			Utils.uBase.setText(contactInputField, numb);
			Utils.uBase.waitForElementToBeClickable(callOption);
			if(dropDownArrow.isDisplayed() && dropDownArrow.isEnabled())
			{
//			Utils.uBase.waitForElementToBeClickable(dropDownArrow);
			AdvanceReporting.addLogs("pass", "Dropdown arrow is available");
			AdvanceReporting.addElementImage("info", inputRow);
			}
			else{
				AdvanceReporting.addLogs("info", "Dropdown arrow is not available");
			}
		}
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace();
		}
		return this;
	}
	public CallsPage clickfirstCall() throws Exception
	{
		try
		{
			Utils.uBase.waitForElement(firstCalltype);
			AdvanceReporting.addLogs("pass", "Calls Page","Calls Page");
			Utils.uBase.clickWebelement(firstCalltype);
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace();
		}
		return this;
	}
	public CallsPage clickThreeDots() throws Exception
	{
		try
		{
			Utils.uBase.waitForElement(threeDotsOption);
			Utils.uBase.clickWebelement(threeDotsOption);
			AdvanceReporting.addLogs("info", "Clicked on three dotted more option");
		} 
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace();
		}
		return this;
	}
	public CallsPage verifyUseMyPhoneToCall() throws Exception
	{
		try
		{
			Utils.uBase.waitForElement(optionsMenu);
			if(useMyPhoneToCallOption.isDisplayed() && useMyPhoneToCallOption.isEnabled()) {
			AdvanceReporting.addLogs("pass", "Use my phone to call option is available");
			AdvanceReporting.addElementImage("info", optionsMenu);
			} else {
				AdvanceReporting.addLogs("info", "Use my phone to call option is not available");
			}
		}
		catch (Exception e)
		{
			AdvanceReporting.addLogs("fail", "Error Message: "+e.getMessage());
			e.printStackTrace();
		}
		return this;
	}

	
	public CallsPage CallsPageVerifications(String SearchText) throws Exception
	{

		try
		{
			Utils.uBase.waitForElementToBeClickable(InboxSummaryGreeting);
			AdvanceReporting.addLogs("pass", "Moya Home Page","Moya Home Page");
			
			//Click on Calls Button
			Utils.uBase.waitForElementToBeClickable(CallsIcon);
			Utils.uBase.clickWebelement(CallsIcon);
			AdvanceReporting.addLogs("pass", "Clicked on Calls Icon Button succesfully");
			AdvanceReporting.addLogs("pass", "Clicked on Calls Icon Button succesfully", "Clicked on Calls Icon Button succesfully");
			
			Utils.uBase.isElementPresentInEitherOf_webelement(GvSearchList, GvSearchListNoItems);
				
			//Click on First Calls List
			Utils.uBase.waitForElementToBeClickable(FirstCallFromList);
			Utils.uBase.clickWebelement(FirstCallFromList);
			AdvanceReporting.addLogs("pass", "Clicked on First Calls List Button succesfully");
			AdvanceReporting.addLogs("pass", "Clicked on First Calls List Button succesfully", "Clicked on First Calls List Button succesfully");
			
			Utils.uBase.waitForElementToBeClickable(CallsDetails);
			//AdvanceReporting.addLogs("pass", "Calls Screen is Visiable","Calls Screen is Visiable");
			
			Utils.uBase.waitForElementToBeClickable(CallsDetailsTableHeader);
			AdvanceReporting.addLogs("pass", "Calls Screen is Visiable","Calls Screen is Visiable");
			
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
        	String PhoneNumberActual=Utils.uBase.getText(CallsDetailsPhoneNumber);
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
           	String DateValue = Utils.uBase.getText(CallsDetailsDateValue);           	
           	SimpleDateFormat in = new SimpleDateFormat("EEEE, MMM dd, yyyy");           	                     
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
        	
        	
        	    String myTime = Utils.uBase.getText(CallsDetailsTimeValue);        	    
        	    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");        	        	  
        	    Date  datev = sdf.parse(myTime);
        	 // Validate Time 
            	if(datev.before(date1))
            	{
            		System.out.println("Time is in Correct Format");
               		AdvanceReporting.addLogs("pass", "Time is in Correct Format Is avalible successfully");
        			AdvanceReporting.addLogs("pass", "Time is in Correct Format Is avalible successfully", "Time is in Correct Format Is avalible successfully");    			
            	}
            	else 
            	{
            		System.out.println("Time is not in Correct Format");
               		AdvanceReporting.addLogs("fail", "Time is not in Correct Format");
        			AdvanceReporting.addLogs("fail", "Time is not in Correct Format", "Time is not in Correct Format");
            	}
            	
            	String PhoneTypeDetailsActual = Utils.uBase.getText(PhoneTypeDetails); 
            	String PhoneTypeFirstItemExpected = Utils.uBase.getText(PhoneTypeFirstSearchList);    
        	   
        	 // Validate Type
            	if(PhoneTypeDetailsActual.contains(PhoneTypeFirstItemExpected))
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






