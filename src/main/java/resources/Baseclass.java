package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class Baseclass {
	// browser code --
	public static WebDriver driver;
	public Properties prop;

	public static String email = generateRandomEmailID();

	public void driverInitilization() throws IOException {
		// this is to having run ur code in any system u want
		// as user.dir will help u to get directly at ur src main java file in ur system

		// Properties file data reading --
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");
		// Access the data from properties file --

		prop = new Properties();

		prop.load(fis);

		// this is for driver code

		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {

			driver = new EdgeDriver();
		} else {

			System.out.println("please choose proper driver value");
		}

	}

	// This will help us to create uniq email addresss
	public static String generateRandomEmailID() {
		return "abc" + System.currentTimeMillis() + "@gmail.com";

	}

	// this will help u launch browser and url commonly for each method(testcase)
	// since the browser has to be launched for every testcase
	// so we have used beforemethod
	@BeforeMethod
	public void launchBrowserAndUrl() throws IOException {
		driverInitilization(); // driver has been initialised once here as its common for all testcases
		driver.get(prop.getProperty("url")); // this is our url which have declared using properties file
	}

	// while generating test report
	// this will help you To take the screenshot and store in one folder-
	public static String screenShot(WebDriver driver, String filename) {
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		// 20240426083712

		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\ScreenShot\\" + filename + "_" + dateAndTime + ".png";
		File finalDestination = new File(destination);
		try {
			FileUtils.copyFile(source, finalDestination);
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;
	}

	// since its the first thing to be done so we use beforesuite
	@BeforeSuite
	public void ExtentReport() {
		ExtentManager.setup();
	}

	// as report is generated at the last
	@AfterSuite
	public void endReport() {
		ExtentManager.endReport();
	}
}