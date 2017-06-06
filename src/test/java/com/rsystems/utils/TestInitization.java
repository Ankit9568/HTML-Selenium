package com.rsystems.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import com.rsystems.config.ObjectRepository;

public class TestInitization {

	public static WebDriver driver;
	public static Logger log;
	public static final ExtentReports reports = ExtentReports.get(TestInitization.class);
	public static Calendar cald;
	public static String captureFilePath;
	public static String currentMethodName;
	public static Xls_Reader excel = new Xls_Reader(ObjectRepository.excelFilePath);
	public static WebDriverWait wait = null;
	private static String currentScreenTitle;

	@BeforeSuite
	public void Setup() throws InterruptedException, IOException {

		cald = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String extentReportFileName = "report_" + formatter.format(cald.getTime()).toString() + ".html";
		String extentReportPath = System.getProperty("user.dir") + "\\src\\test\\java\\com\\rsystems\\testreport\\"
				+ extentReportFileName;

		reports.init(extentReportPath, true);
		reports.config().reportHeadline("HTML Client Automation Testing");
		reports.config().reportTitle("Regression Test Execution");
		reports.config().useExtentFooter(false);

		log = Logger.getLogger("ProximusHTMLLogger");
		log.info("Logger Info:: Inside Setup Method");

		launchWebdriver();
		
		System.out.println("Waiting for the page to load");
		wait = new WebDriverWait(driver, 120L);

		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(
					By.xpath("//img[@src='resources/components/animation/images/logo.png']")));
			System.out.println("Proximus Logo Loaded");

			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ScreenHolder1"));
			System.out.println("Frame loaded");

			Thread.sleep(2000);

			if (driver.findElement(By.xpath(ObjectRepository.HubTVItem)).getText()
					.equalsIgnoreCase(getExcelKeyValue("hub", "TV", "name_nl"))) {
				System.out.println("HUB TV text returned is :: "
						+ driver.findElement(By.xpath(ObjectRepository.HubTVItem)).getText());
				System.out.println("HUB is loaded with TV showcase focused");

			} else {

				System.out.println("HUB TV text returned is :: "
						+ driver.findElement(By.xpath(ObjectRepository.HubTVItem)).getText());
				System.out.println("This is not equal to Televisie ");

			}

		} catch (Throwable t) {
			System.out.println("HUB is not loaded with TV showcase focused " + t);

		}

		log.info("Logger Info:: Going out of Setup Method");
	}

	@BeforeMethod
	public void beforeMethodCalled(Method method) throws InterruptedException {
		reports.startTest("Starting the Test: + " + method.getName());
		log.info("Testcase name is :::::: " + method.getName());
		System.out.println("Testcase name is :::::: " + method.getName());
		currentMethodName = method.getName();
		reports.log(LogStatus.INFO, "Start Step : Start with the focus on HUB Text Line");
		TestInitization.setApplicationHubPage(2);

	}

	@AfterMethod()
	public void afterMethodCalled() throws InterruptedException {

		reports.log(LogStatus.INFO, "END Step : Leave the test case with focus on HUB Text Line");

		TestInitization.setApplicationHubPage(2);

		reports.endTest();

	}

	@AfterSuite
	public void suiteEndReached() {

		log.info("Logger Info:: Inside suiteEndReached Method");
		driver.quit();

	}

	public static String captureCurrentScreenshot() {

		cald = Calendar.getInstance();

		SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

		// System.out.println("Current unformatted time is ::::::::::::::: " +
		// cald.getTime());
		// System.out.println("Current formatted time is ::::::::::::::: " +
		// formatter.format(cald.getTime()).toString());
		String captureFileName = currentMethodName + formatter.format(cald.getTime()).toString() + ".jpg";

		captureFilePath = System.getProperty("user.dir") + "\\src\\test\\java\\com\\rsystems\\testreport\\screenshots\\"
				+ captureFileName;

		// System.out.println("Image to be captured as :: " + captureFilePath);
		// log.info("Image to be captured as :: " + captureFilePath);
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File(captureFilePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception while taking screenshot");
			log.info("Exception while taking screenshot");

			e.printStackTrace();
		}

		return captureFilePath;

	}

	public static String getExcelKeyValue(String sheetname, String objectname, String keyname) {

		// System.out.println("Inside getExcelKeyValue Function");

		String sheetName = sheetname;
		String objectName = objectname;
		String keyName = keyname;
		String errorMessage = "Something wrong with your Key-Value Pair";

		int rows = excel.getRowCount(sheetName);

		for (int rowNum = 2; rowNum <= rows; rowNum++) {

			if (excel.getCellData(sheetName, "objectID", rowNum).equalsIgnoreCase(objectName)) {

				// System.out.println("Going out of getExcelKeyValue Function
				// with valid value");
				return excel.getCellData(sheetName, keyName, rowNum);

			}

		}

		System.out.println("NOT VALIDDDDDDDDDDDDD");
		System.out.println("Going out of getExcelKeyValue Function without any valid value");
		return errorMessage;

	}

	public static boolean loadHubFocusedDTVTextLine() {
		System.out.println("Inside method ::::::::::::::::::::::::::::::::::::::::: loadHubFocusedDTVShowcase");
		driver.navigate().refresh();

		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(
					By.xpath("//img[@src='resources/components/animation/images/logo.png']")));
			System.out.println("Proximus Logo Loaded");

			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ScreenHolder1"));
			System.out.println("Frame loaded");

			Thread.sleep(2000);

			if (driver.findElement(By.xpath(ObjectRepository.HubTVItem)).getText()
					.equalsIgnoreCase(getExcelKeyValue("hub", "TV", "name_nl"))) {

				sendKeyMultipleTimes("DOWN", 1, 1000);
				reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
				return true;
			}

		} catch (Throwable t) {

			System.out.println("Element not found:: " + t);
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			return false;

		}
		reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		return false;

	}

	public static boolean loadHubFocusedDTVShowcase() {
		System.out.println("Inside method ::::::::::::::::::::::::::::::::::::::::: loadHubFocusedDTVShowcase");
		driver.navigate().refresh();

		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(
					By.xpath("//img[@src='resources/components/animation/images/logo.png']")));
			System.out.println("Proximus Logo Loaded");

			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ScreenHolder1"));
			System.out.println("Frame loaded");

			Thread.sleep(2000);

			if (driver.findElement(By.xpath(ObjectRepository.HubTVItem)).getText()
					.equalsIgnoreCase(getExcelKeyValue("hub", "TV", "name_nl"))) {

				System.out.println("Focus is on HUB TV showcase");
				reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
				return true;
			}

		} catch (Throwable t) {

			System.out.println("Element not found:: " + t);
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			return false;

		}
		reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		return false;

	}

	public static int getCurrentFrameIndex() {
		int lastFrameIndex;
		driver.switchTo().defaultContent();
		lastFrameIndex = driver.findElements(By.xpath("//iframe[contains(@id,'ScreenHolder')]")).size() - 1;
		System.out.println("Last opened frame index is returned as :: " + lastFrameIndex);
		log.info("Last opened frame index is returned as :: " + lastFrameIndex);

		return lastFrameIndex;

	}

	public static void sendKeyMultipleTimes(String keyname, int numberoftimes, long delaybetweemKeys)
			throws InterruptedException {

		System.out.println("Sending : " + keyname + " numberoftimes : " + numberoftimes
				+ "  with delay in each key as : " + delaybetweemKeys);

		Thread.sleep(1000);

		Actions action = new Actions(driver);

		for (int noOfTimes = 0; noOfTimes < numberoftimes; noOfTimes++) {
			action.sendKeys(Keys.valueOf(keyname)).perform();
			Thread.sleep(delaybetweemKeys);
			// reports.attachScreenshot(TestInitization.captureCurrentScreenshot());

		}

	}

	public static void sendKeySequence(String commaSeparatedKeySequence, int timeOutMiliSec, String screenTitle)
			throws InterruptedException {

		String myname = commaSeparatedKeySequence;
		String expectedScreenTitle = screenTitle;
		String screenTitleAfterNavigation = null;

		System.out.println("Inside keySequence method");
		String[] splitedKeys = myname.split("\\s*,\\s*");

		Actions action = new Actions(driver);

		System.out.println("Size of Keys list is : " + splitedKeys.length);
		for (int i = 0; i < splitedKeys.length; i++) {

			System.out.println("Key value passed is : " + splitedKeys[i]);
			action.sendKeys(Keys.valueOf(splitedKeys[i])).perform();
			Thread.sleep(timeOutMiliSec);
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());

			driver.switchTo().frame(getCurrentFrameIndex());
			// screenTitleAfterNavigation =
			// driver.findElement(By.xpath("//p[@id='headerTitle']")).getText();
			// System.out.println("Current Screen Title is :: " +
			// currentScreenTitle);

		}
		driver.switchTo().defaultContent();
		screenTitleAfterNavigation = driver.findElement(By.xpath("//p[@id='headerTitle']")).getText();

		if (expectedScreenTitle.equalsIgnoreCase(screenTitleAfterNavigation)) {
			System.out.println("Correctly reached at the desired screen");

		} else {
			System.out.println("Not reached at the desired screen");
			throw new SkipException("Not reached at the desired screen" + "Actual Screen Title : "
					+ screenTitleAfterNavigation + "Expected Screen Title : " + expectedScreenTitle);
		}

	}

	public static void setApplicationHubPage(int noOfRetry) throws InterruptedException {

		System.out.println("Trying to set home page ");

		int retryForHubScreen = 5;
		Actions action = new Actions(driver);

		// Needs to switch home screen
		driver.switchTo().defaultContent();

		while (((driver.findElements(By.xpath("//iframe[contains(@id,'ScreenHolder')]")).size()) > 1)
				&& retryForHubScreen > 0) {
			System.out.println("Trying to press page down");
			Thread.sleep(500);
			action.sendKeys(Keys.PAGE_DOWN).perform();
			retryForHubScreen--;
		}

		if (retryForHubScreen == 0) {
			// Application is not on the HUB page
			driver.navigate().refresh();
		}

		driver.switchTo().frame(0);
		action.sendKeys(Keys.DOWN).perform();

		String className = driver.findElement(By.id("menuItem_1")).getAttribute("class");

		if (className.contains("cActiveMenuItem_Bold")) {
			System.out.println("Control already on HUB page");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			return;
		}

		while (noOfRetry > 0) {

			int leftMove = 5;
			int rightMove = 5;

			for (int iterator = 0; iterator <= 10; iterator++) {

				className = driver.findElement(By.id("menuItem_1")).getAttribute("class");
				if (className.contains("cActiveMenuItem_Bold")) {
					System.out.println("Successfully set hub");
					reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
					Thread.sleep(1000);
					noOfRetry = 0;
					break;
				} else {
					// need to move left or right
					if (leftMove > 0) {
						action.sendKeys(Keys.LEFT).perform();
						Thread.sleep(500);
						leftMove--;

					}
					if (rightMove > 0 && leftMove == 0) {
						action.sendKeys(Keys.RIGHT).perform();
						Thread.sleep(500);
						rightMove--;
					}
				}
			}
			noOfRetry--;
		}
	}

	public static void sendKeysSequenceUpdated(String commaSeparatedKeySequence, int timeOutMiliSec, String screenTitle)
			throws InterruptedException {

		String myname = commaSeparatedKeySequence;
		String expectedScreenTitle = screenTitle;
		String screenTitleAfterNavigation = null;

		System.out.println("Inside keySequence method");
		String[] splitedKeys = myname.split("\\s*,\\s*");

		Actions action = new Actions(driver);

		System.out.println("Size of Keys list is : " + splitedKeys.length);

		for (int i = 0; i < splitedKeys.length; i++) {

			System.out.println("Key value passed is : " + splitedKeys[i]);
			action.sendKeys(Keys.valueOf(splitedKeys[i])).perform();
			Thread.sleep(timeOutMiliSec);

			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}

		driver.switchTo().frame(getCurrentFrameIndex());
		WebElement webElement = driver.findElement(By.xpath("//div[contains(@class,'Heading')]"));
		screenTitleAfterNavigation = webElement.getText();

		if (expectedScreenTitle.equalsIgnoreCase(screenTitleAfterNavigation)) {
			System.out.println("Correctly reached at the desired screen");

		} else {
			System.out.println("Not reached at the desired screen");
			throw new SkipException("Not reached at the desired screen" + "Actual Screen Title : "
					+ screenTitleAfterNavigation + "Expected Screen Title : " + expectedScreenTitle);
		}

	}

	private void launchWebdriver() throws IOException {

		String url = null;
		FileInputStream FI = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\java\\com\\rsystems\\config\\config.properties");
		Properties PR = new Properties();
		PR.load(FI);

		url = PR.getProperty("URL");

		boolean executionOnHTV = false;
		executionOnHTV = Boolean.valueOf(PR.getProperty("RunOnHTV"));

		if (executionOnHTV) {
			Capabilities caps = new DesiredCapabilities();
			driver = new RemoteWebDriver(new URL("http://10.67.181.112:9517"), caps);
			// override URL in case of HTV
			url = "http://hpg.nat.myrio.net/boot_webkit.html";
		}

		else {

			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.navigate().to(url);
	}
	
}
