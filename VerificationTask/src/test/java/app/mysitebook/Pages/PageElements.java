package app.mysitebook.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PageElements {
	private WebDriver driver;

	public String actualTitle;
	public int rowSize;
	public int cellSize;

	public String[] actualRate;
	public String[] actualDesc;
	public String[] actualQuan;
	private List<WebElement> rows;

	public PageElements(WebDriver driver) {
		this.driver = driver;
	}

	public void selectSampleProject() {
		WebElement selectProject = driver
				.findElement(By.xpath("//span[text()= ' Sample Bungalow Project G+1 - Detailed Estimate']"));
		Actions action = new Actions(driver);
		action.moveToElement(selectProject).perform();
		selectProject.click();

	}

	public void selectQuoteId() {
		WebElement quoteId = driver.findElement(By.xpath("//a[text()= ' Q005']"));
		quoteId.click();
	}

	public String quotationTitle() {
		WebElement getQuotationTitle = driver.findElement(By.xpath("//label[text()= 'BSTPL']"));
		return getQuotationTitle.getText();
	}

	public String[] getDesc() {

		rows = driver.findElements(By.xpath(
				"//*[@id=\"tpl-app\"]/mbc-app/mbc-project-cost/div/div/mbc-create-quotes/div/div[2]/mbc-quote-items-preview/div/table/tbody/tr"));
		rowSize = rows.size();

		actualDesc = new String[rows.size()];

		for (int i = 2; i <= 41; i++) {
			WebElement actualDescVar = driver.findElement(By.xpath(
					"/html/body/div[1]/mbc-app/mbc-project-cost/div/div/mbc-create-quotes/div/div[2]/mbc-quote-items-preview/div/table/tbody/tr["
							+ i + "]/td[2]"));
			actualDesc[i] = actualDescVar.getText();
		}
		return actualDesc;

	}

	public String[] getQuantity() {

		actualQuan = new String[rows.size()];

		for (int i = 2; i <= 41; i++) {
			WebElement actualQuantityVar = driver.findElement(By.xpath(
					"/html/body/div[1]/mbc-app/mbc-project-cost/div/div/mbc-create-quotes/div/div[2]/mbc-quote-items-preview/div/table/tbody/tr["
							+ i + "]/td[3]"));
			actualQuan[i] = actualQuantityVar.getText();
		}
		return actualQuan;

	}
	
	public String[] getRate() {

		actualRate = new String[rows.size()];

		for (int i = 2; i <= 41; i++) {
			WebElement actualRateVar = driver.findElement(By.xpath(
					"/html/body/div[1]/mbc-app/mbc-project-cost/div/div/mbc-create-quotes/div/div[2]/mbc-quote-items-preview/div/table/tbody/tr["
							+ i + "]/td[5]"));
			actualRate[i] = actualRateVar.getText();
		}
		return actualRate;

	}

}
