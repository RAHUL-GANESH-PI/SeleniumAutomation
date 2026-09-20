package testPackage;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pageObjects.loginPage;
import pageObjects.shoppingPage;

public class shoppingPageTest {

	@Test
	public void goCartAndBackVerification() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		options.addArguments("window-size=1920,1080");
		WebDriver driver = new ChromeDriver(options);
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
}
