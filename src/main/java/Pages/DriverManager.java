package Pages;

import helper.OSValidators;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverManager {

	// private static ThreadLocal<WebDriver> driver = new
	// ThreadLocal<WebDriver>();

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public static WebDriver initializeDriver(String browserType) {
		if (driver.get() == null) {
			setWebDriver(createDriver(browserType));
		}
		return driver.get();
	}

	public static void setWebDriver(WebDriver driver) {
		if (driver != null) {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			DriverManager.driver.set(driver);
		}

	}

	public static WebDriver createDriver(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {
			return createChromeDriver();
		} else if (browser.equalsIgnoreCase("PhantomJS")) {
			return createPhantomJSInstance();
		} else {
			return createFirefoxDriver();
		}
	}

	protected static WebDriver createPhantomJSInstance() {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setJavascriptEnabled(true);
		caps.setCapability("takesScreenshot", true);

		if (OSValidators.isUnix()) {

			caps.setCapability(
					PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
					System.getProperty("user.dir")
							+ "/src/main/resources/webdrivers/phantomjs/linux/phantomjs");

		} else if (OSValidators.isWindows()) {

			caps.setCapability(
					PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
					System.getProperty("user.dir")
							+ "/src/main/resources/webdrivers/phantomjs/win/phantomjs.exe");

		}

		WebDriver driver = new PhantomJSDriver(caps);
		driver.manage().window().maximize();
		return driver;
	}
	
	protected static WebDriver createChromeDriver() {
		WebDriver driver;

		if (OSValidators.isMac()) {

			System.setProperty(
					"webdriver.chrome.driver",
					System.getProperty("user.dir")
							+ "/src/main/resources/webdrivers/chrome/mac/chromedriver");
		} else if (OSValidators.isWindows()) {

			System.setProperty(
					"webdriver.chrome.driver",
					System.getProperty("user.dir")
							+ "/src/main/resources/webdrivers/chrome/win/chromedriver.exe");
		} else if (OSValidators.isUnix()) {

			System.setProperty(
					"webdriver.chrome.driver",
					System.getProperty("user.dir")
							+ "/src/main/resources/webdrivers/chrome/linux/chromedriver");
		}

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}

	protected static WebDriver createFirefoxDriver() {
		WebDriver driver;

		if (OSValidators.isMac()) {

			System.setProperty(
					"webdriver.gecko.driver",
					System.getProperty("user.dir")
							+ "/src/main/resources/webdrivers/firefox/mac/geckodriver-v0.11.1-macos.tar");
		} else if (OSValidators.isWindows()) {

			System.setProperty(
					"webdriver.gecko.driver",
					System.getProperty("user.dir")
							+ "/src/main/resources/webdrivers/firefox/win/geckodriver.exe");
		} else if (OSValidators.isUnix()) {

			System.setProperty(
					"webdriver.gecko.driver",
					System.getProperty("user.dir")
							+ "/src/main/resources/webdrivers/firefox/linux/geckodriver-v0.11.1-linux64.tar");
		}

		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		return driver;
	}

}
