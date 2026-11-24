package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class base {
	WebDriver driver;
	WebDriverWait wait;
	Properties prop = new Properties();

	public void takeScreenshot(WebDriver driver) throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C://Users//rahul//Downloads//SeleniumAutomation//ScreenShots/screenshot.png"));
		
	}
	public ChromeOptions getChromeOptions() {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("headless");
		chromeOptions.addArguments("window-size=1920,1080");
		return chromeOptions;
	}

	public EdgeOptions getEdgeOptions() {
		EdgeOptions edgeOptions = new EdgeOptions();
		edgeOptions.addArguments("headless");
		edgeOptions.addArguments("window-size=1920,1080");
		return edgeOptions;
	}

	public Properties loadGlobalProperties() throws IOException {
		Properties prop = new Properties();
		FileInputStream inpstrm = new FileInputStream(
				System.getProperty("user.dir") + "/src/test/java/properties/globalData.properties");
		prop.load(inpstrm);
		return prop;
	}

	public WebDriver getWebDriver() throws IOException {
		Properties prop = loadGlobalProperties();
		String browser = prop.getProperty("Browser");
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver(getChromeOptions());
			return driver;
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver(getEdgeOptions());
			return driver;
		} else {
			// Code runs in Chrome Browser by Default
			driver = new ChromeDriver(getChromeOptions());
			return driver;
		}
	}

	public void goToWebsite(WebDriver driver,String URL) throws IOException {
		Properties prop = loadGlobalProperties();
		if(URL.equalsIgnoreCase("Website"))
		driver.get(prop.getProperty("Website"));
		else if(URL.equalsIgnoreCase("AutomationURL"))
		driver.get(prop.getProperty("AutomationURL"));
	}
	
	public String getPassword() throws IOException {
		String password = System.getenv("TEST_PASSWORD"); //used when running in GIT CI
		if (password == null) {
		    password = loadGlobalProperties().getProperty("Password");   // used when running locally in Eclipse
		}
		return password;
	}
	
	public String getUserName() throws IOException {
		String userName = System.getenv("TEST_USERNAME"); //used when running in GIT CI
		if (userName == null) {
			userName = loadGlobalProperties().getProperty("UserName");   // used when running locally in Eclipse
		}
		return userName;
	}
	
	public String getPurchaseItem() throws IOException {
		Properties prop = loadGlobalProperties();
		return prop.getProperty("PurchaseItemName");
	}
	
	public String getProductDetailURL() throws IOException {
		Properties prop = loadGlobalProperties();
		return prop.getProperty("ProductDetailURL");
	}
}
