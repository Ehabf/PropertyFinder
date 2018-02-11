package Pages;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AgentPersonalPage extends AbstractPage {

	public AgentPersonalPage(WebDriver driver) {
		super(driver);
	}

	public String getAgentInfo() throws Exception {

		String name = driver
				.findElement(
						By.xpath("/html/body/main/div[1]/div[2]/div[1]/div/div/div[1]/div[2]/h1"))
				.getText();
		String nationality = driver
				.findElement(
						By.xpath("/html/body/main/div[1]/div[2]/div[1]/div/div/div[1]/div[2]/div/div/p[1]/span[2]"))
				.getText();
		String language = driver
				.findElement(
						By.xpath("/html/body/main/div[1]/div[2]/div[1]/div/div/div[1]/div[2]/div/div/p[2]/span[2]"))
				.getText();
		String licenseNo = driver
				.findElement(
						By.xpath("/html/body/main/div[1]/div[2]/div[1]/div/div/div[2]/div/div[1]/p[2]/span[2]"))
				.getText();
		String activeListing = driver
				.findElement(
						By.xpath("/html/body/main/div[1]/div[2]/div[1]/div/div/div[2]/div/div[1]/p[1]/span[2]/a"))
				.getText();
		String linkedin = driver
				.findElement(
						By.xpath("/html/body/main/div[1]/div[2]/div[1]/div/div/div[2]/div/div[1]/p[4]/span[2]/a"))
				.getText();

		String experiance = driver
				.findElement(
						By.xpath("/html/body/main/div[1]/div[2]/div[1]/div/div/div[2]/div/div[1]/p[3]/span[2]"))
				.getText();

		String companyName = driver
				.findElement(
						By.xpath("/html/body/main/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/p[1]"))
				.getText();
		String phone = getPhoneNumber();

		String aboutMe = getAboutMe();

		String info =  name + ";" + nationality + ";" + language + ";" + licenseNo + ";" +activeListing+ ";" + linkedin + ";" + experiance +";" + companyName+";" + phone +";" + aboutMe;

		return info;

	}

	public String getPhoneNumber() throws Exception {
		driver.findElement(
				By.xpath("/html/body/main/div[1]/div[2]/div[2]/div[1]/div/a[1]"))
				.click();
		String phone = driver
				.findElement(
						By.xpath("/html/body/main/div[1]/div[2]/div[2]/div[1]/div/a[1]/span[2]"))
				.getText();
		return phone;
	}

	public String getAboutMe() throws Exception {
		driver.findElement(
				By.xpath("/html/body/main/div[1]/div[4]/div/div[1]/a[1]/span"))
				.click();

		String aboutMe = driver.findElement(
				By.xpath("/html/body/main/div[1]/div[4]/div/div[2]")).getText();
		return aboutMe;

	}

	public void takeScreenshot() throws Exception {
		String fileName = new SimpleDateFormat("yyyy-MM-dd''HHmmss''")
				.format(new Date());
		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("C:\\screenshot\\screenshot" + fileName + ".png"));
	}

	public void changePageLanguage() throws Exception {
		driver.findElement(By.xpath("/html/body/header/div/div[2]/div[2]/a"))
				.click();
	}

}
