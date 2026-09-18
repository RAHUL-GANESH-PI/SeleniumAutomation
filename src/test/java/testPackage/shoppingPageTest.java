package testPackage;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pageObjects.loginPage;
import pageObjects.shoppingPage;

public class shoppingPageTest {

	@Test
	public void goCartAndBackVerification() {
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
		loginPage loginPage = new loginPage(driver);
		shoppingPage shoppingPage = loginPage.login("rahulganesh6945@gmail.com",
				"newP@ssword1");
		wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']"))));
		driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']")).click();
		wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.cssSelector("button[routerlink='/dashboard']"))));
		driver.findElement(By.cssSelector("button[routerlink='/dashboard']")).click();
		assertEquals(driver.getTitle(), "Let's Shop");
	}
}
