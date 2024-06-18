package app.mysitebook.base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	private WebElement mobileVerify;
	private WebElement continueButton;
	private WebElement pwd;
	private WebElement loginButton;

	@BeforeClass
	public void chromeBrowser() throws InterruptedException {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://app.mysitebook.io/app/auth/signin");
		Thread.sleep(5000);
		loginTo("9158482639", "Test@1234");
	}

	public void loginTo(String mobileNumber, String password)  {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		mobileVerify = driver.findElement(By.id("mobileNumber"));
		mobileVerify.sendKeys(mobileNumber);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		continueButton = driver.findElement(By.xpath("//button[text()= ' Continue ']"));
		continueButton.click();

		pwd = driver.findElement(By.id("password"));
		pwd.sendKeys(password);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		loginButton = driver.findElement(By.xpath("//*[@id=\"mobile-align-item\"]/div[3]/div/div/form/div[3]/button"));
		loginButton.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()= 'Create New']")));


	}

	@AfterClass
	public void closeBrowser() {
		driver.close();
	}
}
