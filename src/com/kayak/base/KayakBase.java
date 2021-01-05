package com.kayak.base;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KayakBase {
	
	//public static Properties prop;
	public static WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest logger;	
	
	/*
	 * Name of the Method: createReport 
	 * Brief Description : This will create a empty Extent Report. 
	 * Arguments : No Arguments 
	 * Created By : Sirisha
	 * Created Date : 10/2/2020 
	 * Last Modified : 10/2/2020
	 */
	public static void createReport() {
		String fileName = new SimpleDateFormat("'Kayak_Report_'YYYYMMddHHmmss'.html'").format(new Date());
		String path = "Reports\\" + fileName;
		report = new ExtentReports(path);
	}
	
	/*
	 * Name of the Method : InitializeDriver 
	 * Brief Description : This will initialize browser (chrome, firefox, edge, opera, ie) 
	 * Arguments : No Arguments
	 * Created By : 
	 * Created Date : 10/2/2020 
	 * Last Modified : 10/2/2020
	 */
	public static void initializeDriver() throws Exception {
		//String browserName = prop.getProperty("browsername");
		String browserName = "chrome";

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("opera")) {
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else {
			// If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}
	}
	

	/*
	 * name of the Method : OpenUrl
	 * Brief Description  : This will open the url passed and maximizes the window screen
	 * Arguments		  : No Arguments
	 * Created By 		  : 
	 * created Date		  : 10/2/2020
	 * Last Modified	  : 10/2/2020
	 */
	public static void openUrl() throws InterruptedException {
		//driver.get(prop.getProperty("url"));
		//driver.get("https://kayak.com/");
		driver.get("https://www.kayak.com/flights");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	/*
	 * name of the Method : CloseBrowser
	 * Brief Description  : This will close the browser
	 * Arguments		  : No Arguments
	 * Created By 		  : 
	 * created Date		  : 10/2/2020
	 * Last Modified	  : 10/2/2020
	 */
	public static void closeBrowser() {
		driver.close();
		//driver.quit();
	}

	/*
	 * name of the Method : CloseReport
	 * Brief Description  : This will generate the report
	 * Arguments		  : No Arguments
	 * Created By 		  : 
	 * created Date		  : 10/2/2020
	 * Last Modified	  : 10/2/2020
	 */
	public static void closeReport() {
		//report.endTest(logger);
		report.flush();
	}	


}
