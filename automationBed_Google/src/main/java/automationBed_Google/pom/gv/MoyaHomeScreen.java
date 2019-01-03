package automationBed_Google.pom.gv;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automationBed_Google.utility.ReportManager.AdvanceReporting;
import automationBed_Google.utility.base.Utils;

public class MoyaHomeScreen 
{
	
	//Locators
		@FindBy(xpath="//*[contains(@gv-test-id,'inbox-summary-greeting')]")
		WebElement InboxSummaryGreeting;
		
		@FindBy(xpath="//*[contains(@placeholder,'Search Google Voice')]")
		WebElement SearchTextBox;
		
		@FindBy(xpath="//*[contains(@gv-test-id,'inbox-summary-text')]")
		WebElement InboxSummaryText;
		
		@FindBy(xpath="(//*[contains(@title,'Google Voice')])[2]")
		WebElement GoogleVoiceMainMenu;
		
		@FindBy(xpath="//*[contains(@tooltip,'Messages')]")
		WebElement MessagesToolTip;
		
		@FindBy(xpath="//*[contains(@tooltip,'Calls')]")
		WebElement CallsToolTip;
		
		@FindBy(xpath="//*[contains(@tooltip,'Voicemail')]")
		WebElement VoicemailToolTip;
		
		@FindBy(xpath="//*[contains(@aria-label,'Search') and @role='button']")
		WebElement SearchToolTip;
		
		@FindBy(xpath="//*[contains(@aria-label,'Google apps') and @role='button']")
		WebElement GoogleappsToolTip;
		
		@FindBy(xpath="//*[@role='button' and contains(@aria-label,'notifications')]")
		WebElement NotificationsToolTip;
		
		@FindBy(xpath="//*[@role='button' and contains(@aria-label,'Google Account:')]")
		WebElement GoogleAccountToolTip;
		
		@FindBy(xpath="//*[@role='button' and contains(@aria-label,'Main menu')]")
		WebElement MainmenuToolTip;
		
		@FindBy(xpath="//*[@id='messaging-view']/div/md-content/div/gv-conversation-list/md-virtual-repeat-container/div/div[2]")
		WebElement GvSearchList;
		
		@FindBy(xpath="//*[@id='messaging-view']/div/md-content/div/gv-conversation-list/div[2]")
		WebElement GvSearchListNoItems;
		
		@FindBy(xpath="(//*[contains(@md-virtual-repeat,'conversation in ctrl.getDisplay()')])[1]")
		WebElement GvSearchListFirstItem;
		
		@FindBy(tagName = "gv-call-log")		
		WebElement GvCallItem;
		
		@FindBy(tagName = "gv-text-message-list")		
		WebElement GvMessageItem;
		
		@FindBy(tagName = "gv-voicemail-player")		
		WebElement GvVoiceMailItem;
		
		@FindBy(xpath="//*[@id='messaging-view']/div/md-content/gv-thread-details/div/div/gv-message-list-header/div/div[2]/div/span[2]/gv-icon-button/button")
		WebElement SearchListCallsMessageButton;
		
		@FindBy(xpath="//*[@id='messaging-view']/div/md-content/gv-thread-details/div/div[2]/div")
		WebElement SearchListSendAMessageButton;
		
		@FindBy(xpath="//*[contains(@id,'gv-message-input')]")		
		WebElement GvMessageTextbox;
		
		@FindBy(xpath="//*[@type='button' and contains(@aria-label,'Send message')]")
		WebElement MessageSendArrowButton;

		public MoyaHomeScreen MoyaHomeScreenVerify(String SearchText) throws Exception
		{

			try
			{
				Utils.uBase.waitForElementToBeClickable(InboxSummaryGreeting);
				AdvanceReporting.addLogs("pass", "Moya Home Page","Moya Home Page");
				
				Utils.uBase.waitForElementToBeClickable(InboxSummaryText);
				AdvanceReporting.addLogs("pass", "Moya Home Page","Moya Home Page");
				
				//check GoogleVoice Tool tip available  
	            Utils.uBase.scrolltoElement(GoogleVoiceMainMenu);
	            Utils.uBase.hoverWebelement(GoogleVoiceMainMenu); 					
				AdvanceReporting.addLogs("pass", "GoogleVoice Tool tip Is avalible successfully");
				AdvanceReporting.addLogs("pass", "GoogleVoice Tool tip Is avalible successfully", "GoogleVoice Tool tip Is avalible successfully");
				
				//check Messages Tool tip available    
	            Utils.uBase.scrolltoElement(MessagesToolTip);
	            Utils.uBase.hoverWebelement(MessagesToolTip); 					
				AdvanceReporting.addLogs("pass", "Messages Tool tip Is avalible successfully");
				AdvanceReporting.addLogs("pass", "Messages Tool tip Is avalible successfully", "Messages Tool tip Is avalible successfully");
				
				//check Calls Tool tip available  
	            Utils.uBase.scrolltoElement(CallsToolTip);
	            Utils.uBase.hoverWebelement(CallsToolTip); 					
				AdvanceReporting.addLogs("pass", "Calls Tool tip Is avalible successfully");
				AdvanceReporting.addLogs("pass", "Calls Tool tip Is avalible successfully", "Calls Tool tip Is avalible successfully");
				
				//check VoicemailToolTip available  
	            Utils.uBase.scrolltoElement(VoicemailToolTip);
	            Utils.uBase.hoverWebelement(VoicemailToolTip); 					
				AdvanceReporting.addLogs("pass", "VoicemailToolTip Is avalible successfully");
				AdvanceReporting.addLogs("pass", "VoicemailToolTip Is avalible successfully", "VoicemailToolTip Is avalible successfully");
				
				//check SearchToolTip available  
	            Utils.uBase.scrolltoElement(SearchToolTip);
	            Utils.uBase.hoverWebelement(SearchToolTip); 					
				AdvanceReporting.addLogs("pass", "SearchToolTip Is avalible successfully");
				AdvanceReporting.addLogs("pass", "SearchToolTip Is avalible successfully", "SearchToolTip Is avalible successfully");
				
				//check GoogleappsToolTip available  
	            Utils.uBase.scrolltoElement(GoogleappsToolTip);
	            Utils.uBase.hoverWebelement(GoogleappsToolTip); 					
				AdvanceReporting.addLogs("pass", "GoogleappsToolTip Is avalible successfully");
				AdvanceReporting.addLogs("pass", "GoogleappsToolTip Is avalible successfully", "GoogleappsToolTip Is avalible successfully");
				
				//check NotificationsToolTip available  
	            Utils.uBase.scrolltoElement(NotificationsToolTip);
	            Utils.uBase.hoverWebelement(NotificationsToolTip); 					
				AdvanceReporting.addLogs("pass", "NotificationsToolTip Is avalible successfully");
				AdvanceReporting.addLogs("pass", "NotificationsToolTip Is avalible successfully", "NotificationsToolTip Is avalible successfully");
				
				//check GoogleAccountToolTip available  
	            Utils.uBase.scrolltoElement(GoogleAccountToolTip);
	            Utils.uBase.hoverWebelement(GoogleAccountToolTip); 					
				AdvanceReporting.addLogs("pass", "GoogleAccountToolTip Is avalible successfully");
				AdvanceReporting.addLogs("pass", "GoogleAccountToolTip Is avalible successfully", "GoogleAccountToolTip Is avalible successfully");
				
				//check MainmenuToolTip available  
	            Utils.uBase.scrolltoElement(MainmenuToolTip);
	            Utils.uBase.hoverWebelement(MainmenuToolTip); 					
				AdvanceReporting.addLogs("pass", "MainmenuToolTip Is avalible successfully");
				AdvanceReporting.addLogs("pass", "MainmenuToolTip Is avalible successfully", "MainmenuToolTip Is avalible successfully");
				
				//Search element is clicked and set text
				Utils.uBase.waitForElementToBeClickable(SearchTextBox);
				Utils.uBase.clickWebelement(SearchTextBox);
				AdvanceReporting.addLogs("pass", "Clicked Search text box succesfully");
				AdvanceReporting.addLogs("pass", "Clicked Search text box succesfully", "Clicked Search text box succesfully");
				Utils.uBase.setText(SearchTextBox, SearchText);
				Utils.uBase.pressKeyEnter(SearchTextBox);
				AdvanceReporting.addLogs("pass", "Search text entered is : " + SearchText);
				AdvanceReporting.addLogs("pass", "Search text entered", "Search text entered");
				
				Utils.uBase.isElementPresentInEitherOf_webelement(GvSearchList, GvSearchListNoItems);
				
				if(Utils.uBase.isElementPresent_webelement(GvSearchListNoItems))
				{
					
				}
				if(Utils.uBase.isElementPresent_webelement(GvSearchList))
				{
					//Click on the first element
					Utils.uBase.waitForElementToBeClickable(GvSearchListFirstItem);
					Utils.uBase.clickWebelement(GvSearchListFirstItem);
					AdvanceReporting.addLogs("pass", "Clicked First Item from the Search list box succesfully");
					AdvanceReporting.addLogs("pass", "Clicked First Item from the Search list box succesfully", "Clicked First Item from the Search list box succesfully");
					
					Utils.uBase.isElementPresentInEitherOf_webelement(GvCallItem, GvMessageItem,GvVoiceMailItem);
					
					if(Utils.uBase.isElementPresent_webelement(GvCallItem))
					{
						//Click on the first element
						Utils.uBase.waitForElementToBeClickable(SearchListCallsMessageButton);
						Utils.uBase.clickWebelement(SearchListCallsMessageButton);
						AdvanceReporting.addLogs("pass", "Clicked Messasge Button succesfully");
						AdvanceReporting.addLogs("pass", "Clicked Messasge Button succesfully", "Clicked Messasge Button succesfully");
						
						//Send message element is clicked and set text
						Utils.uBase.waitForElementToBeClickable(GvMessageTextbox);
						Utils.uBase.clickWebelement(GvMessageTextbox);
						AdvanceReporting.addLogs("pass", "Clicked Message text box succesfully");
						AdvanceReporting.addLogs("pass", "Clicked Message text box succesfully", "Clicked Message text box succesfully");
						Utils.uBase.doubleClickWebelement(GvMessageTextbox);
						Utils.uBase.setText(GvMessageTextbox, SearchText);
						AdvanceReporting.addLogs("pass", " Text is entered : " + SearchText);
						AdvanceReporting.addLogs("pass", " Text entered", "Text entered");
						
						//Click on the Send Arrow Button
						Utils.uBase.waitForElementToBeClickable(MessageSendArrowButton);
						Utils.uBase.clickWebelement(MessageSendArrowButton);
						AdvanceReporting.addLogs("pass", "Clicked on Messasge send arrow Button succesfully");
						AdvanceReporting.addLogs("pass", "Clicked on Messasge send arrow Button succesfully", "Clicked on Messasge send arrow Button succesfully");
						
						
					}
					if(Utils.uBase.isElementPresent_webelement(GvMessageItem))
					{
						//Click on the first element
						Utils.uBase.waitForElementToBeClickable(SearchListSendAMessageButton);
						Utils.uBase.clickWebelement(SearchListSendAMessageButton);
						AdvanceReporting.addLogs("pass", "Clicked First Item from the Search list box succesfully");
						AdvanceReporting.addLogs("pass", "Clicked First Item from the Search list box succesfully", "Clicked First Item from the Search list box succesfully");
						
						//Send message element is clicked and set text
						Utils.uBase.waitForElementToBeClickable(GvMessageTextbox);
						Utils.uBase.clickWebelement(GvMessageTextbox);
						AdvanceReporting.addLogs("pass", "Clicked Message text box succesfully");
						AdvanceReporting.addLogs("pass", "Clicked Message text box succesfully", "Clicked Message text box succesfully");
						Utils.uBase.doubleClickWebelement(GvMessageTextbox);
						Utils.uBase.setText(GvMessageTextbox, SearchText);
						AdvanceReporting.addLogs("pass", " Text is entered : " + SearchText);
						AdvanceReporting.addLogs("pass", " Text entered", "Text entered");
						
						//Click on the Send Arrow Button
						Utils.uBase.waitForElementToBeClickable(MessageSendArrowButton);
						Utils.uBase.clickWebelement(MessageSendArrowButton);
						AdvanceReporting.addLogs("pass", "Clicked on Messasge send arrow Button succesfully");
						AdvanceReporting.addLogs("pass", "Clicked on Messasge send arrow Button succesfully", "Clicked on Messasge send arrow Button succesfully");
						
						
					}
					if(Utils.uBase.isElementPresent_webelement(GvVoiceMailItem))
					{
						//Click on the first element
						Utils.uBase.waitForElementToBeClickable(SearchListCallsMessageButton);
						Utils.uBase.clickWebelement(SearchListCallsMessageButton);
						AdvanceReporting.addLogs("pass", "Clicked Messasge Button succesfully");
						AdvanceReporting.addLogs("pass", "Clicked Messasge Button succesfully", "Clicked Messasge Button succesfully");
						
						//Send message element is clicked and set text
						Utils.uBase.waitForElementToBeClickable(GvMessageTextbox);
						Utils.uBase.clickWebelement(GvMessageTextbox);
						AdvanceReporting.addLogs("pass", "Clicked Message text box succesfully");
						AdvanceReporting.addLogs("pass", "Clicked Message text box succesfully", "Clicked Message text box succesfully");
						Utils.uBase.doubleClickWebelement(GvMessageTextbox);
						Utils.uBase.setText(GvMessageTextbox, SearchText);
						AdvanceReporting.addLogs("pass", " Text is entered : " + SearchText);
						AdvanceReporting.addLogs("pass", " Text entered", "Text entered");
						
						//Click on the Send Arrow Button
						Utils.uBase.waitForElementToBeClickable(MessageSendArrowButton);
						Utils.uBase.clickWebelement(MessageSendArrowButton);
						AdvanceReporting.addLogs("pass", "Clicked on Messasge send arrow Button succesfully");
						AdvanceReporting.addLogs("pass", "Clicked on Messasge send arrow Button succesfully", "Clicked on Messasge send arrow Button succesfully");
						
						
					}
					
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
