package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AgentSearchResultsPage extends AbstractPage {

	public AgentSearchResultsPage(WebDriver driver) {
		super(driver);
	}

	public void selectLanguages() throws Exception {

		driver.findElement(
				By.xpath("/html/body/main/div[1]/div[2]/div[3]/form/div[4]/div/div[2]"))
				.click();

		driver.findElement(
				By.xpath("/html/body/main/div[1]/div[2]/div[3]/form/div[4]/div/div[2]/div/div[2]/div[25]"))
				.click();

		driver.findElement(
				By.xpath("/html/body/main/div[1]/div[2]/div[3]/form/div[4]/div/div[2]"))
				.click();

		driver.findElement(
				By.xpath("/html/body/main/div[1]/div[2]/div[3]/form/div[4]/div/div[2]/div/div[2]/div[5]"))
				.click();

		driver.findElement(
				By.xpath("/html/body/main/div[1]/div[2]/div[3]/form/div[4]/div/div[2]"))
				.click();

		driver.findElement(
				By.xpath("/html/body/main/div[1]/div[2]/div[3]/form/div[4]/div/div[2]/div/div[2]/div[19]"))
				.click();
	}

	public void clickFind() throws Exception {
		driver.findElement(By.xpath("/html/body/main/div[1]/div[2]/div[3]/form/div[3]/div/div[2]/button")).click();
	}
	
	public AgentPersonalPage selectAgent() throws Exception {
		driver.findElement(By.xpath("/html/body/main/div[1]/div[3]/div/div[2]/a[1]")).click();
		return new AgentPersonalPage(driver);
	}

	public void selectNationality(String country) throws Exception {
		driver.findElement(
				By.xpath("/html/body/main/div[1]/div[1]/div/form/div[2]/div/div[3]/div/div[1]"))
				.click();

		driver.findElement(
				By.xpath("/html/body/main/div[1]/div[1]/div/form/div[2]/div/div[3]/div/div[2]/div[33]"))
				.click();
	}

	public String getAgentSearchResultsCount() throws Exception {
		String Count = driver.findElement(By.xpath("/html/body/main/div[1]/div[2]/div[2]/div/div[1]/h1")).getText();
		return Count;
	}
	
}
