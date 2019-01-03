package automationBed_Google.GV;

import java.lang.reflect.Method;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationBed_Google.pom.gv.GVSignInPage;
import automationBed_Google.pom.gv.HambergerMenuPage;
import automationBed_Google.pom.gv.SettingsLinkedNumbersPage;
import automationBed_Google.pom.gv.SettingsPage;
import automationBed_Google.utility.ReportManager.AdvanceReporting;
import automationBed_Google.utility.base.SuiteBase;
import automationBed_Google.utility.base.Utils;

import org.testng.annotations.Parameters;
import automationBed_Google.utility.excelManager.ExcelUtility;


public class Settings extends SuiteBase {

	private String suiteName = this.getClass().getSimpleName();


	@BeforeTest
	@Parameters("browser")

	public void beforeTest(String browser) throws Exception
	{
		Utils.uBase.setupDriver(browser);
		Utils.uBase.intializeReport(suiteName, browser);
	}

	@AfterTest
	public void afterTest() 
	{
		Utils.uBase.finalizeReport();
		Utils.uBase.driver.quit();
	}


	// Data Provider
	@DataProvider(name = "GoogledataProvider")
	public Object[][] GoogledataProvider() {
		return new ExcelUtility().getData(TestSuite, suiteName);
	}

	@Test(dataProvider = "GoogledataProvider")
	public void Googletesting(String testCase, String email, String password, String data) throws Exception
	{
		String status = "pass";
		Utils.uBase.StartTest(testCase);

		try {

			if (new ExcelUtility().getToRunFlag(TestSuite, suiteName, testCase))
			{
				try 
				{
					String methodName=Utils.uBase.lowerCaseFirst(testCase.replaceAll("\\s+",""));

					Method method = this.getClass().getMethod(methodName, String.class, String.class, String.class);
					method.invoke(this, email, password, data);
				} 
				catch (NoSuchMethodException e) 
				{
					status = "skip";
				}
			} else
			{
				status = "skip";
			}

		} catch (Exception e)
		{
			status = "fail";
			e.printStackTrace();
		}

		Utils.uBase.writeResult(suiteName, status);
		AdvanceReporting.addLogs(status, testCase + " " + status);

		Utils.uBase.EndTest();

	}

	/*Settings.GoogleVoiceNumber*/
	public void verifyCorrectGoogleVoiceNumberIsDisplayed(String email, String password, String data) throws Exception
	{

		Utils.uBase.launchApplication();
		
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.driver, GVSignInPage.class);
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton();
		
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.driver, HambergerMenuPage.class);
		hmPage.clickMainMenu().clickSettings();
		
		SettingsPage settingsPage = PageFactory.initElements(Utils.uBase.driver, SettingsPage.class);

//		Verify that, displaying correct google voice phone number.
		settingsPage.getGvNum();

//		Verify that, it also displayed with buttons to "Change" number, "Transfer" number, and "Delete" GV number
		settingsPage.verifyChangeBtn().verifyTransfer().verifyDelete();
		
		Utils.uBase.driver.close();

	}
	
	/*Settings.GVNmber.ChangeOrPort*/
	public void verifyChangeOrPortLinksToTheLegacyPageForTheAction(String email, String password, String data) throws Exception
	{

		Utils.uBase.launchApplication();
		
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.driver, GVSignInPage.class);
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton();
		
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.driver, HambergerMenuPage.class);
		hmPage.clickMainMenu().clickSettings();
		
		SettingsPage settingsPage = PageFactory.initElements(Utils.uBase.driver, SettingsPage.class);

//		Verify that, displaying correct google voice phone number with country code
		settingsPage.getGvNum();
		
//		Verify that, it also displayed with buttons to "Change" number, "Transfer" number, and "Delete" GV number.
		settingsPage.verifyChangeBtn().verifyTransfer().verifyDelete();
		
//		Verify that, by clicking on redirects to legacy page of "Change or port" screen
		settingsPage.changeRedirection();
		Utils.uBase.switchToOldWindow();
		settingsPage.transferRedirection();
		Utils.uBase.switchToOldWindow();
		settingsPage.deleteRedirection();
		Utils.uBase.driver.close();

	}
	/*Settings.LinkedNumbers*/
	public void verifyNewPhoneCanBeAddedToAccount(String email, String password, String data) throws Exception
	{
		Utils.uBase.launchApplication();
		
		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.driver, GVSignInPage.class);
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton();
		
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.driver, HambergerMenuPage.class);
		hmPage.clickMainMenu().clickSettings();
		
		SettingsLinkedNumbersPage settingsLinkednumberPage = PageFactory.initElements(Utils.uBase.driver, SettingsLinkedNumbersPage.class);
		
		//Verify that, all the Google voice forwarding numbers listed
		settingsLinkednumberPage.getGvLinkedNum(data);
		
		//Verify that, each linked numbers displayed in a single row.
		
		//Verify that, name of the linked numbers, "Edit" button, "X" delete button displayed in the same row
		settingsLinkednumberPage.verifyNameoflinkedphone(data).verifyEditIcon(data).verifyCloseIcon(data);		
	}
	/*Click to Call is available in call page*/
}