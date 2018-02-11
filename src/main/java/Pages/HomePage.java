package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends AbstractPage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	SearchResultsPage searchResultsPage;
	

	public void searchLocation(String location) throws Exception {
		driver.findElement(
				By.xpath("//*[@id='search-form-property']/div[3]/div[1]/span/input"))
				.sendKeys(location);
	}
	
	public AgentSearchResultsPage clickAgentTab() throws Exception {
		driver.findElement(
				By.xpath("//*[@id='header']/div[2]/nav/ul/li[4]/a")).click();
		return new AgentSearchResultsPage(driver);
	}

	public void selectCategory(String category_type) throws Exception {
		// Select Category = new Select(category);
		// Category.selectByVisibleText(category_type);

		driver.findElement(
				By.xpath("//*[@id='search-form-property']/div[3]/div[2]/div/button"))
				.click();

		WebElement Category = driver
				.findElement(By
						.xpath("//*[@id='search-form-property']/div[3]/div[2]/div/div/ul"));
		List<WebElement> CategoryList = Category.findElements(By.tagName("li"));
		for (WebElement li : CategoryList) {
			if (li.getText().equals(category_type)) {
				li.click();
			}
		}
	}

	public void selectPropertyType(String property) throws Exception {
		// //Select Type = new Select(propertyType);
		// Select Type = new Select(driver.findElement(By.name("t")));
		// Type.selectByVisibleText(property);
		// Type.selectByValue("35");
		driver.findElement(
				By.xpath("//*[@id='search-form-property']/div[4]/div/div[1]/div/button"))
				.click();

		WebElement Type = driver
				.findElement(By
						.xpath("//*[@id='search-form-property']/div[4]/div/div[1]/div/div/ul"));
		List<WebElement> countriesList = Type.findElements(By.tagName("li"));
		for (WebElement li : countriesList) {
			if (li.getText().equals(property)) {
				li.click();
			}
		}
	}

	public void selectMinBed(int minbed) throws Exception {
		String Min = Integer.toString(minbed);
		Min = Min + " Beds";

		driver.findElement(
				By.xpath("//*[@id='bedroom_group']/div[1]/div/button")).click();

		WebElement list = driver.findElement(By
				.xpath("//*[@id='bedroom_group']/div[1]/div/div/ul"));
		List<WebElement> minBedList = list.findElements(By.tagName("li"));
		for (WebElement li : minBedList) {
			if (li.getText().equals(Min)) {
				li.click();
			}
		}
	}

	public void selectMaxBed(int maxbed) throws Exception {
		String Max = Integer.toString(maxbed);
		Max = Max + " Beds";

		driver.findElement(
				By.xpath("//*[@id='bedroom_group']/div[2]/div/button")).click();

		WebElement list = driver.findElement(By
				.xpath("//*[@id='bedroom_group']/div[2]/div/div/ul"));
		List<WebElement> maxBedList = list.findElements(By.tagName("li"));
		for (WebElement li : maxBedList) {
			if (li.getText().equals(Max)) {
				li.click();
			}
		}
	}

	public SearchResultsPage clickFind() throws Exception {
		driver.findElement(By.xpath("//*[@id='search-form-property']/div[3]/div[1]/button/div[1]")).click();
		return new SearchResultsPage (driver);
	}

}
