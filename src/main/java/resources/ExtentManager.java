package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	public static ExtentSparkReporter htmlReporter; // repsosnible for look
	public static ExtentReports extent; // Resposnisble for entries
	public static ExtentTest test; // Respossible for test status pass/fail

	public static void setup() {

		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/MyTestCasesReport.html");
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Functional Report");
		htmlReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("hostname", "LocalHost");
		extent.setSystemInfo("os", "windows8.1");
		extent.setSystemInfo("browserName", "Chrome");
		extent.setSystemInfo("testername", "Asma");
	}

	public static void endReport() {
		extent.flush(); //flush output to the html file--
	}

}
