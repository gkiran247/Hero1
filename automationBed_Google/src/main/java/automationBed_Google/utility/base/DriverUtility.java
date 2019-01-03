package automationBed_Google.utility.base;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import automationBed_Google.utility.webDriverManager.Architecture;
import automationBed_Google.utility.webDriverManager.ChromeDriverManager;
import automationBed_Google.utility.webDriverManager.EdgeDriverManager;
import automationBed_Google.utility.webDriverManager.FirefoxDriverManager;
import automationBed_Google.utility.webDriverManager.InternetExplorerDriverManager;
import automationBed_Google.utility.webDriverManager.OperaDriverManager;
import automationBed_Google.utility.webDriverManager.PhantomJsDriverManager;
import automationBed_Google.utility.webDriverManager.WdmConfig;

public class DriverUtility {
	
	private static WebDriver driver;
	private static String browser;
	private static String architecture;
	private static String version;
	
	public static void stpDriver(String browser,String architecture,String version) throws Exception {
		DriverUtility.browser =browser;
		DriverUtility.architecture=architecture;
		DriverUtility.version=version;
		Utils.addLog.traceEntry();
		Architecture arch=getArchitecture(architecture);
	    	
		Utils.addLog.info("setting {} Driver(Architecture= {}, Version={})",browser,arch, version);
	    switch (browser) {
	    	case "gecko":
	            FirefoxDriverManager.getInstance().setup(arch, version);
	            break;

	        case "chrome":
	            ChromeDriverManager.getInstance().setup(arch, version);
	            break;

	        case "opera":
	            OperaDriverManager.getInstance().setup(arch, version);
	            break;

	        case "internet":
	            InternetExplorerDriverManager.getInstance().setup(arch, version);
	            break;

	        case "edge":
	            EdgeDriverManager.getInstance().setup(arch, version);
	            break;

	        case "phantom":
	            PhantomJsDriverManager.getInstance().setup(arch, version);
	            break;

	        default:
	        	Utils.addLog.traceExit("Invalid browser entry in webdrivermanager.properties");
	            throw new Exception("not a valid browser entry");
	        }
	        Utils.addLog.traceExit();
	    }
	 
	 public static Architecture getArchitecture(String architecture) {
	    	Utils.addLog.traceEntry();
	        if (architecture.equalsIgnoreCase("32")) {
	        	return Utils.addLog.traceExit(Architecture.x32); 
	        } else {
	            return Utils.addLog.traceExit(Architecture.x64); 
	        }
	        
	    }

	    public static Capabilities getCapabilities() {
	    	Utils.addLog.traceEntry();
	        DesiredCapabilities capInstance = new DesiredCapabilities();

	        if (WdmConfig.getBoolean("wdm.capabilities.ACCEPT_SSL_CERTS")){
	        	Utils.addLog.info("Adding ACCEPT_SSL_CERTS capapility to driver");
	            capInstance.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	        }
	        if (WdmConfig.getBoolean("wdm.capabilities.javascriptEnabled")){
	        	Utils.addLog.info("Adding javascriptEnabled capapility to driver");
	            capInstance.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
	        }
	        /*IE specific capabilities*/
	        if(browser.equalsIgnoreCase("internet")){
	            if(WdmConfig.getBoolean("wdm.capabilities.session")){
	            	Utils.addLog.info("Adding IE_ENSURE_CLEAN_SESSION capapility to IE driver");
	                capInstance.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
	            }
	            if(WdmConfig.getBoolean("wdm.capabilities.protectedMode")){
	            	Utils.addLog.info("Adding INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS capapility to IE driver");
	                capInstance.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
	            }
	        }
	       return Utils.addLog.traceExit(capInstance);
	    }
	    
	    public static WebDriver getDriverInstance() throws Exception {
	    	
	    	Utils.addLog.traceEntry();
	    	Utils.addLog.info("Instantaiting : {}",browser);
	        switch (browser) {

	        case "gecko":
	            driver = new FirefoxDriver(getCapabilities());
	            break;

	        case "chrome":
	            driver = new ChromeDriver(getCapabilities());
	            break;

	        case "opera":
	            driver = new OperaDriver(getCapabilities());
	            break;

	        case "internet":
	            driver = new InternetExplorerDriver(getCapabilities());
	            break;

	        case "edge":
	            driver = new EdgeDriver(getCapabilities());
	            break;

	        case "phantom":
	            driver = new PhantomJSDriver(getCapabilities());
	            break;

	        default:
	        	Utils.addLog.traceExit("Invalid browser entry in webdrivermanager.properties");
	            throw new Exception("not a valid browser entry");
	        }
	        return driver;
	    }
	   
}
