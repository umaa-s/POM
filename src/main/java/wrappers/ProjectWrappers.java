package wrappers;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class ProjectWrappers extends Learnwrapper {
	public static String TestCaseName, TestCaseDesc, Category,iterationName;

	@BeforeMethod
	public void bm() {
		createIteration(iterationName);
		invokeApp("chrome", "https://www.irctc.co.in");
	}

	@AfterMethod
	public void am() {
		closeAllBrowsers();
	}

	@BeforeSuite
	public void bs() {
		initializeReport();
	}

	@BeforeClass
	public void bc() {
		createTest(TestCaseName, TestCaseDesc, Category);
	}
	
	@AfterSuite
	public void as() {
		saveReport();
	}

}
