package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SearchResultsPage extends AbstractPage {

	public SearchResultsPage(WebDriver driver) {
		super(driver);
	}

	public void sortByPriceHigh() throws Exception {

		driver.findElement(
				By.xpath("//*[@id='serp-nav']/div[1]/div/div/button")).click();

		WebElement list = driver.findElement(By
				.xpath("//*[@id='serp-nav']/div[1]/div/div/div/ul"));
		List<WebElement> sortByList = list.findElements(By.tagName("li"));
		for (WebElement li : sortByList) {
			if (li.getText().equals("Price (high)")) {
				li.click();
				break;
			}
		}
	}
	
	public String getSearchResultCount() throws Exception {
		String count = driver.findElement(By.cssSelector("div.list-count"))
				.getText();
		return count;
	}

	public void savePrices(String count) throws Exception {

		// The sheet should be saved under the following path with type "Excel
		// 97-2003 Workbook(*.xls)
		String excelSheetLocation = System.getProperty("user.dir")+ "\\listing title - price.xls";

		int results = Integer.parseInt(count);

//		for (int i = 1; i < 3; i++) {
//			String values = driver.findElement(
//					By.xpath("//*[@id='content']/ul/li[" + i
//							+ "]/div/div[3]/div[2]/span[5]/span[1]")).getText();
//			helper.WriteToExcelHelper.SetCellValue(excelSheetLocation, 0,
//					values);
//		}

		for (int i = 1; i <= results + 1; i++) {
			if (i != 4) {
				String values = driver.findElement(
						By.xpath("//*[@id='serp']/ul/li[" + i
								+ "]/div[3]/div[2]/div/span/span[1]"))
						.getText();
				helper.WriteToExcelHelper.SetCellValue(excelSheetLocation, 0,
						values);
			}

		}

	}
}
