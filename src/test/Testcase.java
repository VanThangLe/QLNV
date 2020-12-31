package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import core.Common;
import modules.Login;

public class Testcase extends Common {
	@BeforeMethod
	public void beforeTest() {
		initBrowser();
	}
	
	@Test
	public void TC01_Phan_xu_ly() {
		Login login = new Login(webDriver);
		login.getURL();
		
		
		
		
		
	}
	
	@AfterMethod
	public void afterTest() {
		webDriver.close();
	}
}
