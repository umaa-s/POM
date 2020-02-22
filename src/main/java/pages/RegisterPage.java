package pages;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import wrappers.Learnwrapper;

public class RegisterPage extends Learnwrapper{
	public RegisterPage(RemoteWebDriver driver, WebDriverWait wait, ExtentTest test, ExtentTest node) {
		this.driver = driver;
		this.wait = wait;
		this.test = test;
		this.node = node;
		elementIsDisplayed(driver.findElementByXPath("//input[@placeholder='User Name']"));
	}
	
	public RegisterPage enterUserNameInRegisterPage(String UN) {
		if(enterByName("userName", UN)) {
			logStatusInReport("pass", "Username : "+UN+" is entered successfully");
		} else {
			logStatusInReport("fail", "Username : "+UN+" is not entered");
		}
		//enterByXpath("//input[@placeholder='User Name']", UN);
		return this;
	}
}
