package testPackage;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Utils.base;
import pageObjects.loginPage;
import pageObjects.shoppingPage;

public class loginPageTest extends base{

	@Test
	public void launchBrowser() throws IOException {
		WebDriver driver = getWebDriver();
		goToWebsite(driver,"Website");
		loginPage loginPage = new loginPage(driver);
		shoppingPage object = loginPage.login(getUserName(), getPassword());
		loginPage.waitForTitle();
		assertEquals(true, driver.getTitle().equals("Let's Shop"));
		driver.quit();
	}

	@Test
	public void forgotpswrd() throws IOException{
		WebDriver driver = getWebDriver();
		loginPage loginPage = new loginPage(driver);
		goToWebsite(driver,"Website");
		loginPage.forgotpwrd(getUserName(), getPassword(), getPassword());
		loginPage.waitforElements();
		shoppingPage object = loginPage.login(getUserName(), getPassword());
		loginPage.waitForTitle();
		assertEquals(true, driver.getTitle().equals("Let's Shop"));
		driver.quit();
	}
}
