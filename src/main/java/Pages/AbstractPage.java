package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class AbstractPage {

	// WebDriver driver = DriverManager.initializeDriver("CHROME");

	WebDriver driver;

	public AbstractPage(WebDriver driver) {
		this.driver = driver;
	}

	public HomePage NavigateToPropertyFinder(String country) {

		//String locale = country.toUpperCase();

		switch(country) {

		case "QA":
			driver.navigate().to("https://www.propertyfinder.qa/");
			break;
		case "UAE":
			driver.navigate().to("https://www.propertyfinder.ae/");
			break;
		}
		return new HomePage(driver);
	}
}
