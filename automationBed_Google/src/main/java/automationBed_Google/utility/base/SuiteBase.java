package automationBed_Google.utility.base;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import automationBed_Google.utility.excelManager.Read_XLS;
import automationBed_Google.utility.logsManager.LogsManager;

public class SuiteBase {

	public static Read_XLS TestSuite= null;


	@BeforeSuite
	public void beforeSuite() throws Exception {
		init();
	}

	@AfterSuite
	public void afterSuite() {
		//		MailManager.sendMail();
	}

	public void init(){
		TestSuite = new Read_XLS(System.getProperty("user.dir")+"//src//main//resources//datafiles//TestSuite.xlsx");
		Utils.uBase=new BaseUtility();
		Utils.addLog=LogsManager.createLogger("application");
	}

}
