package automationBed_Google.GV;

import java.lang.reflect.Method;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationBed_Google.pom.gv.CallsPage;
import automationBed_Google.pom.gv.GVSignInPage;
import automationBed_Google.pom.gv.HambergerMenuPage;
import automationBed_Google.pom.gv.MessagePage;
import automationBed_Google.pom.gv.VoicemailPage;
import automationBed_Google.utility.ReportManager.AdvanceReporting;
import automationBed_Google.utility.base.SuiteBase;
import automationBed_Google.utility.base.Utils;

import org.testng.annotations.Parameters;
import automationBed_Google.utility.excelManager.ExcelUtility;

public class InlineClick2Call extends SuiteBase {

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


	/*Click to Call is available in call page*/
	public void uiCheckForClick2Call(String email, String password, String data) throws Exception
	{
		Utils.uBase.launchApplication();

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.driver, GVSignInPage.class);
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton();

		CallsPage callsPage = PageFactory.initElements(Utils.uBase.driver, CallsPage.class);
		//		A "v" icon appear along with call icon and its clickable
		callsPage.clickMakeACall().verifyDropDown(data);
	}

	/*Wolverine check inline click to call is not available*/
	public void uiCheckForClickToCallForWolverineAccount(String email, String password, String data) throws Exception
	{
		Utils.uBase.launchApplication();

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.driver, GVSignInPage.class);
		CallsPage callsPage = PageFactory.initElements(Utils.uBase.driver, CallsPage.class);
		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.driver, HambergerMenuPage.class);
		MessagePage messagePage = PageFactory.initElements(Utils.uBase.driver, MessagePage.class);
		VoicemailPage vMPage = PageFactory.initElements(Utils.uBase.driver, VoicemailPage.class);
		
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton();

		//		No "v" is present beside the call icon
		callsPage.clickMakeACall().verifyDropDown(data);

		//		No "Use my phone to call" option is present for
		
		hmPage.clickMainMenu().clickCalls();
//		Calls 
		callsPage.clickfirstCall().clickThreeDots().verifyUseMyPhoneToCall();
//		Messages 
		hmPage.clickMainMenu().clickMessages();
		messagePage.clickfirstMessage();
		callsPage.clickThreeDots().verifyUseMyPhoneToCall();
//		Voicemails 
		hmPage.clickMainMenu().clickVoicemail();
		vMPage.clickfirstVoicemail();
		callsPage.clickThreeDots().verifyUseMyPhoneToCall();
	}
}