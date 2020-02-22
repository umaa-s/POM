package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import wrappers.Learnwrapper;

public class MainPage extends Learnwrapper {
	public MainPage(RemoteWebDriver driver, WebDriverWait wait, ExtentTest test, ExtentTest node) {
		this.driver = driver;
		this.wait = wait;
		this.test = test;
		this.node = node;
		PageFactory.initElements(driver, this);
		if (elementIsDisplayed(fromTextBox)) {
			logStatusInReport("pass", "Main page is displayed");
		} else {
			logStatusInReport("fail", "Main page is not displayed");
		}
	}

	@FindBy(xpath = "//input[@placeholder=\"From*\"]")
	WebElement fromTextBox;

	@FindBy(xpath = "//a[text()=' REGISTER ']")
	WebElement registerButton;

	public RegisterPage clickRegisterButtonInMainPage() {
		// clickByXpath("//a[text()=' REGISTER ']");
		if (clickElement(registerButton)) {
			logStatusInReport("pass", "Register button is clicked in Main page");
		} else {
			logStatusInReport("fail", "Register button is clicked in not Main page");
		}
		return new RegisterPage(driver,wait,test,node);
	}

}
