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
import org.testng.annotations.Test;

public class loginPageTest {

	//Gets mail and password and login to website and checks for successful login
	@Test
	public void launchBrowser() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		options.addArguments("window-size=1920,1080");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
		driver.findElement(By.cssSelector("input[id='userEmail']")).sendKeys("rahulganesh6945@gmail.com");
		driver.findElement(By.cssSelector("input[id='userPassword']")).sendKeys("R@hul7821");
		driver.findElement(By.cssSelector("input[id='login']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.titleContains("Let's Shop"));
		assertEquals(true, driver.getTitle().equals("Let's Shop"));
		driver.close();
	}

}
