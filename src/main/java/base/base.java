package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class base {

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

	public WebDriver getWebDriver() throws IOException {
		Properties prop = new Properties();
		FileInputStream inpstrm = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\java\\properties\\globalData.properties");
		prop.load(inpstrm);
		String browser = prop.getProperty("Browser");
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriver driver = new ChromeDriver(getChromeOptions());
			return driver;
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriver driver = new EdgeDriver(getEdgeOptions());
			return driver;
		} else {
			// Code runs in Chrome Browser by Default
			WebDriver driver = new ChromeDriver(getChromeOptions());
			return driver;
		}
	}
}
