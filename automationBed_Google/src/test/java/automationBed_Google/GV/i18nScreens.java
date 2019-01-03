package automationBed_Google.GV;

import java.lang.reflect.Method;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationBed_Google.pom.gv.CallsPage;
import automationBed_Google.pom.gv.MoyaHomeScreen;
import automationBed_Google.pom.gv.SettingsPage;
import automationBed_Google.pom.gv.GVSignInPage;
import automationBed_Google.pom.gv.HambergerMenuPage;
import automationBed_Google.pom.gv.MessagePage;
import automationBed_Google.pom.gv.VoicemailPage;
import automationBed_Google.utility.ReportManager.AdvanceReporting;
import automationBed_Google.utility.base.SuiteBase;
import automationBed_Google.utility.base.Utils;

import org.testng.annotations.Parameters;
import automationBed_Google.utility.excelManager.ExcelUtility;

public class i18nScreens extends SuiteBase {

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

	/*Moya Home page validations*/
	public void i18nMoyaHomeScreen(String email, String password, String data) throws Exception
	{
		Utils.uBase.launchApplication();

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.driver, GVSignInPage.class);
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton();
		
		MoyaHomeScreen moyaHomeScreen = PageFactory.initElements(Utils.uBase.driver, MoyaHomeScreen.class);
		moyaHomeScreen.MoyaHomeScreenVerify(data);
	
	}

	/*Moya Home page validations*/
	public void i18nMoyaCallsScreen(String email, String password, String data) throws Exception
	{
		Utils.uBase.launchApplication();

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.driver, GVSignInPage.class);
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton();
		
		CallsPage  CallsPage = PageFactory.initElements(Utils.uBase.driver, CallsPage.class);
		CallsPage.CallsPageVerifications(data);
	
	}
	
	/*Moya Home page validations*/
	public void i18nMoyaSettingsScreen(String email, String password, String data) throws Exception
	{
		Utils.uBase.launchApplication();

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.driver, GVSignInPage.class);
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton();
		
		//CallsPage  CallsPage = PageFactory.initElements(Utils.uBase.driver, CallsPage.class);
		//CallsPage.CallsPageVerifications(data);
		
		HambergerMenuPage goIntoSetting = PageFactory.initElements(Utils.uBase.driver, HambergerMenuPage.class);
		goIntoSetting.clickMainMenu().clickSettings();
		
		SettingsPage SettingPageHeaderVerification = PageFactory.initElements(Utils.uBase.driver, SettingsPage.class);
		SettingPageHeaderVerification.SettingPageHeaderVerification();
	
	}

	/*Moya Home page validations*/
	public void i18nMoyaVoicemailScreen(String email, String password, String data) throws Exception
	{
		Utils.uBase.launchApplication();

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.driver, GVSignInPage.class);
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton();
		
		VoicemailPage VoicemailPageVerifications = PageFactory.initElements(Utils.uBase.driver, VoicemailPage.class);
		VoicemailPageVerifications.VoicemailPageVerifications(data);
	
	}
	
}