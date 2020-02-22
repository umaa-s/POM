package utils;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public abstract class ExtentReport {
	public static ExtentHtmlReporter html;
	public static ExtentReports extent;
	public ExtentTest test, node;

	public void createIteration(String iterationName) {
		node = test.createNode(iterationName);
	}

	public void createTest(String TestCaseName, String TestCaseDesc, String Category) {
		test = extent.createTest(TestCaseName, TestCaseDesc);
		test.assignAuthor("Umaa");
		test.assignCategory(Category);

	}

	public void initializeReport() {
		html = new ExtentHtmlReporter("./Reports.html");
		extent = new ExtentReports();
		extent.attachReporter(html);
	}

	public void saveReport() {
		extent.flush();
	}

	public abstract String takeSnap();
	
	public void logStatusInReport(String status, String desc) {
		MediaEntityModelProvider ss=null;
		try {
			ss = MediaEntityBuilder.createScreenCaptureFromPath(takeSnap()).build();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (status.equalsIgnoreCase("pass"))
			node.log(Status.PASS, desc,ss);
		else if (status.equalsIgnoreCase("fail"))
			node.log(Status.FAIL, desc,ss);
	}
}
