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

import base.base;
import pageObjects.loginPage;
import pageObjects.shoppingPage;

public class shoppingPageTest extends base {

	ChromeOptions options = new ChromeOptions();

	@Test
	public void goCartAndBackVerification() throws IOException {
		WebDriver driver = getWebDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
		loginPage loginPage = new loginPage(driver);
		shoppingPage shoppingPage = loginPage.login("rahulganesh6945@gmail.com", "newP@ssword1");
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[routerlink='/dashboard/cart']")));
		driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[routerlink='/dashboard']")));
		driver.findElement(By.cssSelector("button[routerlink='/dashboard']")).click();
		assertEquals(driver.getTitle(), "Let's Shop");
		driver.quit();
	}

	@Test
	public void addToCart() throws IOException {
		WebDriver driver = getWebDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
		loginPage loginPage = new loginPage(driver);
		shoppingPage shoppingPage = loginPage.login("rahulganesh6945@gmail.com", "newP@ssword1");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".col-lg-4")));
		List<WebElement> cartItems = driver.findElements(By.cssSelector(".col-lg-4"));
		for (WebElement element : cartItems) {
			if (element.findElement(By.cssSelector(".card .card-body h5[style*='text-transform']")).getText()
					.equalsIgnoreCase("ZARA COAT 3")) {
				element.findElement(By.cssSelector(".card .card-body button[class*=w-40]")).click();
				break;
			}
		}
		wait.until(ExpectedConditions.urlContains("https://rahulshettyacademy.com/client/#/dashboard/product-details/"));
		wait.until(ExpectedConditions.textToBe(By.cssSelector(".col-lg-6 div h2"), "ZARA COAT 3"));
		assertEquals(driver.findElement(By.cssSelector(".col-lg-6 div h2")).getText(), "ZARA COAT 3");
		driver.quit();
	}
}
