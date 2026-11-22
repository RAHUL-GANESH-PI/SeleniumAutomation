package testPackage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.base;
import pageObjects.loginPage;
import pageObjects.shoppingPage;

public class loginPageTest extends base{

	@Test
	public void launchBrowser() throws IOException {
		WebDriver driver = getWebDriver();
		goToWebsite(driver);
		loginPage loginPage = new loginPage(driver);
		shoppingPage object = loginPage.login(getUserName(), getPassword());
		loginPage.waitForTitle();
		assertEquals(true, driver.getTitle().equals("Let's Shop"));
		driver.quit();
	}

	@Test
	public void forgotpswrd() throws IOException, InterruptedException {
		WebDriver driver = getWebDriver();
		loginPage loginPage = new loginPage(driver);
		goToWebsite(driver);
		loginPage.forgotpwrd(getUserName(), getPassword(), getPassword());
		loginPage.waitforElements();
		shoppingPage object = loginPage.login(getUserName(), getPassword());
		loginPage.waitForTitle();
		assertEquals(true, driver.getTitle().equals("Let's Shop"));
		driver.quit();
	}
}
