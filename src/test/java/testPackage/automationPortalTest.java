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
	//	Thread.sleep(3000);
	//	driver.findElement(By.cssSelector(".radioButton")).click();
		driver.quit();
	}
	
}
