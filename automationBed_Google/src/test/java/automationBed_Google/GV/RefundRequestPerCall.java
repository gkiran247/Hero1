package automationBed_Google.GV;

import java.lang.reflect.Method;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationBed_Google.pom.gv.BillingHistoryPage;
import automationBed_Google.pom.gv.GVSignInPage;
import automationBed_Google.pom.gv.HambergerMenuPage;
import automationBed_Google.pom.gv.SettingsPage;
import automationBed_Google.utility.ReportManager.AdvanceReporting;
import automationBed_Google.utility.base.SuiteBase;
import automationBed_Google.utility.base.Utils;

import org.testng.annotations.Parameters;
import automationBed_Google.utility.excelManager.ExcelUtility;


public class RefundRequestPerCall extends SuiteBase {

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

	/*Hovering over the billing history log should highlight the three dots menu*/
	public void verifyThatHoveringOverTheBillingHistoryLogWillHighlightTheThreeDotsMenu(String email, String password, String data) throws Exception
	{

		Utils.uBase.launchApplication();

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.driver, GVSignInPage.class);
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton();

		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.driver, HambergerMenuPage.class);
		hmPage.clickMainMenu().clickSettings();

		SettingsPage settingsPage = PageFactory.initElements(Utils.uBase.driver, SettingsPage.class);
		settingsPage.clickBillingHistoryBtn();

		BillingHistoryPage billingHistoryPage = PageFactory.initElements(Utils.uBase.driver, BillingHistoryPage.class);
		/*Hovering over the log should highlight the items in the list.
		If the call is eligible for a refund then there will be a three dots menu on the highlighted item*/
		billingHistoryPage.refundOption();
		Utils.uBase.driver.close();

	}
	public void verifyThatClickingOnTheThreeDotsOptionWillOpenRefundRequest(String email, String password, String data) throws Exception
	{

		Utils.uBase.launchApplication();

		GVSignInPage gvSignInPage = PageFactory.initElements(Utils.uBase.driver, GVSignInPage.class);
		gvSignInPage.clickHomeSignIn().enterLoginID(email).clickNextButton().enterPassword(password).clickNextButton();

		HambergerMenuPage hmPage = PageFactory.initElements(Utils.uBase.driver, HambergerMenuPage.class);
		hmPage.clickMainMenu().clickSettings();

		SettingsPage settingsPage = PageFactory.initElements(Utils.uBase.driver, SettingsPage.class);
		settingsPage.clickBillingHistoryBtn();

		BillingHistoryPage billingHistoryPage = PageFactory.initElements(Utils.uBase.driver, BillingHistoryPage.class);
		/*'Request Refund' button should pop up while clicking on the threedots menu*/
		billingHistoryPage.refundRequest();
		Utils.uBase.driver.close();

	}
}