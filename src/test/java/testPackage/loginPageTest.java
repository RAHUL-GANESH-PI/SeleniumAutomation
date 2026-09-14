package testPackage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.loginPage;
import pageObjects.shoppingPage;

public class loginPageTest {
	ChromeOptions options = new ChromeOptions();

	@BeforeTest
	public void optionsetup() {
		options.addArguments("headless");
		options.addArguments("window-size=1920,1080");
	}
	//Gets mail and password and login to website and checks for successful login
	@Test
	public void launchBrowser() {
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
		loginPage loginPage = new loginPage(driver);
		shoppingPage object = loginPage.login("rahulganesh6945@gmail.com", "newP@ssword1");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.titleContains("Let's Shop"));
		assertEquals(true, driver.getTitle().equals("Let's Shop"));
		driver.close();
	}
	
	@Test
	public void forgotpswrd() throws InterruptedException {
		WebDriver driver = new ChromeDriver(options);
		loginPage loginPage = new loginPage(driver);
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
		loginPage.forgotpwrd("rahulganesh6945@gmail.com", "newP@ssword1", "newP@ssword1");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[id='userEmail']")));
		shoppingPage object = loginPage.login("rahulganesh6945@gmail.com", "newP@ssword1");
		wait.until(ExpectedConditions.titleContains("Let's Shop"));
		assertEquals(true, driver.getTitle().equals("Let's Shop"));
		driver.quit();
	}
	

}
