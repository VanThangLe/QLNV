package modules;

import org.openqa.selenium.WebDriver;

import core.Common;

public class Login extends Common{
	public Login(WebDriver driver) {
		webDriver = driver;
	}
	
	public void getURL() {
		webDriver.get("http://qlnv-uat.vhtcddh.com/dang-nhap");
	}
	
	//public void 

}
