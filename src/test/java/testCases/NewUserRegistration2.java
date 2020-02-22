package testCases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.MainPage;
import wrappers.ProjectWrappers;

public class NewUserRegistration2 extends ProjectWrappers{

	@BeforeTest
	public void bt() {
		TestCaseName = "NewUserRegistration";
		TestCaseDesc="NewUserRegistration in irctc page";
		Category="Smoke";
		iterationName="One";
	}
	
	@Test
	public void newUserReg() {
		new MainPage(driver,wait,test,node)
		.clickRegisterButtonInMainPage()
		.enterUserNameInRegisterPage("Umaa");
	}
	
}

