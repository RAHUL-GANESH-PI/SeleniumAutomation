package testPackage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Utils.base;

public class automationPortalTest extends base{

	@Test
	public void radioButtonTest() throws IOException, InterruptedException {
		WebDriver driver = getWebDriver();
		goToWebsite(driver, "AutomationURL");
		driver.findElement(By.cssSelector("input[value='radio1']")).click();
		takeScreenshot(driver);
		driver.quit();
	}
	
	@Test
	public void dropdownTest() {
		
	}
	
	
	
}
