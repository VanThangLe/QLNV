package test;

import java.util.List;
import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import core.Common;
import modules.Login;

public class Testcase extends Common {
	private WebDriver driver = null;
	
	@BeforeTest
	public void beforeTest() {
		initBrowser();
	}
	
	//@Test
	/*public void readExcelHashMap() {
		try {
			Map<String, String> testdata = Common.getMapData();
			for(Entry<String, String> map: testdata.entrySet()) {
				System.out.println(map.getKey() + "," + map.getValue());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/
	
	@Test
	public void readExcelTestData() throws InterruptedException{
		try {
			List<Map<String, String>> testDataInMap = Common.getTestDataInMap();
			((Login) webDriver).getURL();
			webDriver.findElement(By.xpath("//input[@id='ten_dang_nhap']")).sendKeys(testDataInMap.get(1).get("User"));
			webDriver.findElement(By.xpath("//input[@id='mat_khau']")).sendKeys(testDataInMap.get(1).get("Password"));
			webDriver.findElement(By.xpath("//button[contains(text(), 'Đăng nhập')]")).click();
			Thread.sleep(5000);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//@Test
	/*public void TC01_Phan_xu_ly() {
		Login login = new Login(webDriver);
		login.getURL();
		
		
		
		
		
	}*/
	
	@AfterTest
	public void afterTest() {
		webDriver.quit();
	}
}
