package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Common {
	public WebDriver webDriver;

	public void initBrowser() {
		System.setProperty("webdriver.chrome.driver",
		System.getProperty("user.dir") + "/browserDrivers/chromedriver.exe");
		webDriver = new ChromeDriver();
	}
	
	
}
