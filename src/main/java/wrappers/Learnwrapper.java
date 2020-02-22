package wrappers;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ExtentReport;

public class Learnwrapper extends ExtentReport implements Wrappers {

	public WebDriverWait wait;

	public RemoteWebDriver driver;

	public void invokeApp(String browser, String url) {
		// TODO Auto-generated method stub

		try {

			if (browser.contentEquals("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.contentEquals("ie")) {
				System.setProperty("webdriver.ie.driver", "\\drivers\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			} else {
				System.setProperty("webdriver.gecko.driver", "\\drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(url);
			System.out.println("the browser is launched with URL : " + url);
			wait = new WebDriverWait(driver, 30);
		} catch (WebDriverException e) {
			System.err.println("browser not found" + e.getMessage());

		} catch (Exception e) {
			System.err.println("browser not found" + e.getMessage());

		} finally {
			// TODO: handle finally clause
			takeSnap();
		}
	}

	public boolean elementIsDisplayed(WebElement ele) {
		return ele.isDisplayed();
	}

	public void enterById(String idValue, String data)  {
		// TODO Auto-generated method stub
		try {
			// WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(idValue))).sendKeys(data);
			// driver.findElementById(idValue).sendKeys(data);
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean enterByName(String nameValue, String data) {
		// TODO Auto-generated method stub
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.name(nameValue))).sendKeys(data);
			System.out.println("The value " + data + " is entered at element " + nameValue);
			return true;
		} catch (TimeoutException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/*------------------------------------------------------------------------------*/

	public void enterByXpath(String xpathValue, String data) {
		// TODO Auto-generated method stub

		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathValue))).sendKeys(data);
			System.out.println("The value " + data + " is " + xpathValue);
		} catch (NullPointerException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (WebDriverException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			// TODO: handle finally clause
			takeSnap();
		}
	}

	/*-------------------------------------------------------------------*/
	public boolean verifyTitle(String title) {
		// TODO Auto-generated method stub

		try {
			if (wait.until(ExpectedConditions.titleIs(title))) {
				System.out.println("Actual Title is matched with expected title");
			} else {
				System.out.println("Actual Title doesnot matches with expected title");
			}
		} catch (WebDriverException e) {
			System.err.println("The Browser could not be found " + e.getMessage());
			throw new RuntimeException("FAILED");
		} catch (Exception e) {
			System.err.println("Error in title:" + title + e.getMessage());
			throw new RuntimeException("FAILED");
		}
		return false;

	}

	public void verifyTextById(String id, String text) {
		// TODO Auto-generated method stub
		String t1 = driver.findElement(By.id(id)).getText();
		System.out.println("text is " + t1);
		if (t1.contentEquals(text)) {
			System.out.println("Actual text is matched with expected text");
		} else {
			System.out.println("Actual text doesnot matches with expected text");
		}

	}

	public void verifyTextByXpath(String xpath, String text) {
		// TODO Auto-generated method stub
		String t1 = driver.findElement(By.xpath(xpath)).getText();
		System.out.println("text is " + t1);
		if (t1.contentEquals(text)) {
			System.out.println("Actual text is matched with expected text");
		} else {
			System.out.println("Actual text doesnot matches with expected text");
		}
	}

	public void verifyAttributeTextByXpath(String xpath, String text, String Attribute) {
		// TODO Auto-generated method stub
		String t1 = driver.findElement(By.xpath(xpath)).getAttribute(Attribute);
		System.out.println("text is " + t1);
		if (t1.contentEquals(text)) {
			System.out.println("Actual text is matched with expected text");
		} else {
			System.out.println("Actual text doesnot matches with expected text");
		}
	}

	public void verifyTextContainsByXpath(String xpath, String text) {
		// TODO Auto-generated method stub
		/*
		 * String t1= driver.findElement(By.xpath(xpath)).getText();
		 * System.out.println("text is "+ t1);
		 */

		try {
			if (wait.until(ExpectedConditions.textToBe(By.xpath(xpath), text))) {
				System.out.println("Actual text is matched with expected text");
			} else {
				System.out.println("Actual text doesnot matches with expected text");
			}
		} catch (TimeoutException e) {
			System.err.println("The element with xpath value : " + xpath + " doesn't exists " + e.getMessage());
		}
	}

	public void clickById(String id) {
		// TODO Auto-generated method stub
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.className(id)));
			System.out.println("ClickById");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickByClassName(String classVal) {
		// TODO Auto-generated method stub

	}

	public void clickByName(String name) {
		// TODO Auto-generated method stub

	}

	public void clickByLink(String name) {
		// TODO Auto-generated method stub

	}

	public void clickByLinkNoSnap(String name) {
		// TODO Auto-generated method stub

	}

	public void clickByXpath(String xpathVal) {
		// TODO Auto-generated method stub
		driver.findElementByXPath(xpathVal).click();
	}

	public boolean clickElement(WebElement ele) {
		ele.click();
		return true;
	}

	public void clickByXpathNoSnap(String xpathVal) {
		// TODO Auto-generated method stub
		driver.findElementByXPath(xpathVal).click();
	}

	public String getTextById(String idVal) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTextByXpath(String xpathVal) {
		// TODO Auto-generated method stub
		return null;
	}

	public void selectVisibileTextById(String id, String value) {
		// TODO Auto-generated method stub
		try {
			Select selectVtext = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id))));
			selectVtext.selectByVisibleText(value);
			System.out.println("DropDown option " + value + " is selected at element " + id);
		} catch (TimeoutException e) {
			System.err.println("The element with id value :" + id + " doesn't exists " + e.getMessage());
			throw new RuntimeException("FAILED");
		}
	}

	public void selectIndexById(String id, int value) {
		// TODO Auto-generated method stub

	}

	public void switchToParentWindow() {
		// TODO Auto-generated method stub

	}

	public void switchToLastWindow() {
		// TODO Auto-generated method stub

	}

	public void acceptAlert() {
		// TODO Auto-generated method stub
		try {
			wait.until(ExpectedConditions.alertIsPresent()).accept();
			System.out.println("Alert Accepted");
		} catch (Exception e) {
			System.err.println("Alert is not present in page" + e.getMessage());
			throw new RuntimeException("FAILED");
		}

	}

	public void dismissAlert() {
		// TODO Auto-generated method stub

	}

	public String getAlertText() {
		// TODO Auto-generated method stub

		try {
			String textAlert = wait.until(ExpectedConditions.alertIsPresent()).getText();
			System.out.println("Alert Text " + textAlert);
		} catch (Exception e) {
			System.err.println("Alert is not present in page" + e.getMessage());
			throw new RuntimeException("FAILED");
		}
		return null;
	}

	public String takeSnap() {
		/*
		 * // TODO Auto-generated method stub
		 * 
		 * 
		 * TakesScreenshot webdriver = null; TakesScreenshot scrShot
		 * =((TakesScreenshot)webdriver);
		 * 
		 * //Call getScreenshotAs method to create image file File
		 * SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		 * 
		 * //Move image file to new destination
		 * 
		 * Object fileWithPath = null; File DestFile=new File((String) fileWithPath);
		 * 
		 * //Copy file at destination
		 * 
		 * try { FileUtils.copyFile(SrcFile, DestFile); } catch (IOException e) { //
		 * TODO Auto-generated catch block e.printStackTrace();
		 * System.out.println("error in srncapture"+ e ); }
		 */String destPath = null;
		try {
			File src = driver.getScreenshotAs(OutputType.FILE);
			destPath = "./screenshots/image_" + (int) (Math.random() * (999999)) + ".jpg";
			File dest = new File(destPath);
			FileUtils.copyFile(src, dest);

		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return destPath;
	}

	public void closeBrowser() {
		// TODO Auto-generated method stub
		driver.close();

	}

	public void closeAllBrowsers() {
		// TODO Auto-generated method stub

		driver.quit();
	}

}
