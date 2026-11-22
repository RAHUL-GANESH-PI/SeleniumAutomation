package testPackage;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Utils.base;
import pageObjects.loginPage;
import pageObjects.shoppingPage;

public class shoppingPageTest extends base {

	ChromeOptions options = new ChromeOptions();

	@Test
	public void goCartAndBackVerification() throws IOException {
		WebDriver driver = getWebDriver();
		goToWebsite(driver);
		loginPage loginPage = new loginPage(driver);
		shoppingPage shoppingPage = loginPage.login(getUserName(), getPassword());
		shoppingPage.clickCartButton(driver);
		shoppingPage.clickContinueShoppingBtn(driver);
		assertEquals(driver.getTitle(), "Let's Shop");
		driver.quit();
	}

	@Test
	public void addToCart() throws IOException {
		WebDriver driver = getWebDriver();
		goToWebsite(driver);
		loginPage loginPage = new loginPage(driver);
		shoppingPage shoppingPage = loginPage.login(getUserName(), getPassword());
		List<WebElement> cartItems = shoppingPage.getAllShoppingListItems(driver);
		shoppingPage.selectingPurchaseItem(getPurchaseItem());
		assertEquals(shoppingPage.getProductDetailsTitle(getProductDetailURL()).toLowerCase(), getPurchaseItem().toLowerCase());
		driver.quit();
	}

}
