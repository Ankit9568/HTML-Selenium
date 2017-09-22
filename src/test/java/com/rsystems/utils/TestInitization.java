package com.rsystems.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.CommandInfo;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.HttpCommandExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.internal.ApacheHttpClient;
import org.openqa.selenium.remote.internal.HttpClientFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import com.rsystems.config.ObjectRepository;
import com.rsystems.pages.Hub;
import com.rsystems.pages.MiniEPGScreen;

public class TestInitization {

	public static WebDriver driver;
	public static Logger log;
	public static final ExtentReports reports = ExtentReports.get(TestInitization.class);
	public static Calendar cald = Calendar.getInstance();
	public static String captureFilePath;
	public static String currentMethodName;
	public static Xls_Reader excel = new Xls_Reader(ObjectRepository.excelFilePath);
	public static WebDriverWait wait = null;
	static SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
	public static String currentExecutionFoldername;
	public static String currentExecutionReportPath;
	public static ArrayList<ReportsData> testResult = new ArrayList<ReportsData>();
	public static Date executionStartTime = cald.getTime();
	public static int STBRebootAfterTestCase = 30;
	public static int executedMethodCount = 0;

	protected static String configFilePath = System.getProperty("user.dir") + File.separator + "src" + File.separator
			+ "test" + File.separator + "java" + File.separator + "com" + File.separator + "rsystems" + File.separator
			+ "config" + File.separator + "config.properties";

	@BeforeSuite
	public void Setup() throws InterruptedException, IOException {

		System.setOut(createLoggingProxy(System.out));
		System.setErr(createLoggingProxy(System.err));

		currentExecutionFoldername = "BuildVer_" + getBuildVersion() + "_ExecutionReport_"
				+ formatter.format(executionStartTime).toString();

		currentExecutionReportPath = System.getProperty("user.dir") + File.separator + "ExecutionReports"
				+ File.separator + currentExecutionFoldername;

		String extentReportFileName = "index.html";
		new File(currentExecutionReportPath).mkdirs();

		String extentReportPath = new File(currentExecutionReportPath + "/" + extentReportFileName).getAbsolutePath();
		String seleniumLogs = new File(
				currentExecutionReportPath + File.separator + "Logs" + File.separator + "Selenium.log")
						.getAbsolutePath();
		String applicationLogs = new File(
				currentExecutionReportPath + File.separator + "Logs" + File.separator + "Application.log")
						.getAbsolutePath();

		System.setProperty("seleniumLogs", seleniumLogs);
		System.setProperty("ApplicationLogs", applicationLogs);

		Properties props = new Properties();
		props.load(new FileInputStream(System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
				+ File.separator + "java" + File.separator + "log4j.properties"));
		PropertyConfigurator.configure(props);

		reports.init(extentReportPath, true);
		reports.config().reportHeadline("HTML Client Automation Testing");
		reports.config().reportTitle("Regression Test Execution");
		reports.config().useExtentFooter(false);

		log = Logger.getLogger("ProximusHTMLLogger");
		log.info("Logger Info:: Inside Setup Method");

		
		/*SSH_Connection sshConnection = new SSH_Connection();

		String stbIP = null;
		stbIP = System.getProperty("STBIP");
		if (stbIP == null || stbIP.contentEquals("")) {
			stbIP = TestInitization.getUpdatedProptiesFile().getProperty("STBIP");
		}

		sshConnection.rebootSTBAndSetup(stbIP, "root",
				"yanjebipBoathHairgonpexUkkuarcIgjafbijKodgiNuflathsyepNujAvTetef");
	Thread.sleep(5000);*/
		
		
		launchWebdriver();
		launchApplication();
			
		
		

	}

	@BeforeMethod
	public void beforeMethodCalled(Method method) throws InterruptedException {
		reports.startTest("Starting the Test: + " + method.getName());
		log.info("Testcase name is :::::: " + method.getName());
		System.out.println("Testcase name is :::::: " + method.getName());
		currentMethodName = method.getName();
		reports.log(LogStatus.PASS, "Start Step : Start with the focus on HUB Text Line");
		try {
			TestInitization.setApplicationHubPage(2);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@AfterClass
	public void afterClass(ITestContext result) throws IOException {
		/** Add test result for each module */
		ReportsData tcResult = new ReportsData(result);
		testResult.add(tcResult);
	}

	@AfterMethod()
	public void afterMethodCalled() throws InterruptedException, IOException {

		reports.log(LogStatus.PASS, "END Step : Leave the test case with focus on HUB Text Line");
		try {
			TestInitization.setApplicationHubPage(2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		reports.endTest();
		executedMethodCount = executedMethodCount + 1;

		System.out.println(" Executed Method Count :: " + executedMethodCount + " STB Reboot Aftre Test case :: "
				+ STBRebootAfterTestCase);
		if (executedMethodCount > STBRebootAfterTestCase || executedMethodCount == STBRebootAfterTestCase) {

			SSH_Connection sshConnection = new SSH_Connection();

			String stbIP = null;
			stbIP = System.getProperty("STBIP");
			if (stbIP == null || stbIP.contentEquals("")) {
				stbIP = TestInitization.getUpdatedProptiesFile().getProperty("STBIP");
			}

			sshConnection.rebootSTBAndSetup(stbIP, "root",
					"yanjebipBoathHairgonpexUkkuarcIgjafbijKodgiNuflathsyepNujAvTetef");
			Thread.sleep(5000);
			launchWebdriver();
			launchApplication();
			executedMethodCount = 0;
		}

	}

	@AfterSuite
	public void suiteEndReached() throws IOException {

		log.info("Logger Info:: Inside suiteEndReached Method");
		System.out.println("Trying to quit webdriver");
		new ReportGenerationForGraph().createRunWiseReport(testResult);
		new ReportGeneration().dashBoardGenerator();
		driver.quit();
	}

	public static String captureCurrentScreenshot() throws InterruptedException {

		// Wait for page load
		Thread.sleep(2000);
		cald = Calendar.getInstance();

		SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

		// System.out.println("Current unformatted time is ::::::::::::::: " +
		// cald.getTime());
		// System.out.println("Current formatted time is ::::::::::::::: " +
		// formatter.format(cald.getTime()).toString());
		String captureFileName = currentMethodName + formatter.format(cald.getTime()).toString() + ".jpg";

		captureFilePath = currentExecutionReportPath + "/screenshots" + "/" + captureFileName;

		// System.out.println("Image to be captured as :: " + captureFilePath);
		// log.info("Image to be captured as :: " + captureFilePath);

		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File(captureFilePath));
		} catch (IOException e) {
			System.out.println("Exception while taking screenshot");
			log.info("Exception while taking screenshot");

			e.printStackTrace();
		}

		captureFilePath = "./screenshots" + File.separator + captureFileName;
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

	public static boolean loadHubFocusedDTVTextLine() throws InterruptedException {
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

	public static boolean loadHubFocusedDTVShowcase() throws InterruptedException {
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

	public static void sendUnicodeMultipleTimes(String keyname, int numberoftimes, long delaybetweemKeys)
			throws InterruptedException {

		System.out.println("Sending : " + keyname + " numberoftimes : " + numberoftimes
				+ "  with delay in each key as : " + delaybetweemKeys);

		Thread.sleep(1000);

		Actions action = new Actions(driver);

		for (int noOfTimes = 0; noOfTimes < numberoftimes; noOfTimes++) {

			action.sendKeys(String.valueOf(keyname)).perform();
			Thread.sleep(delaybetweemKeys);

		}

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
					+ screenTitleAfterNavigation + " Expected Screen Title : " + expectedScreenTitle);
		}

	}

	public static void sendNumaricKeys(int numaricVal) throws InterruptedException {

		if (numaricVal == 0) {
			sendKeyMultipleTimes("NUMPAD" + numaricVal, 1, 0);
		}
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		int modval;

		while (numaricVal > 0) {
			modval = numaricVal % 10;
			arrList.add(modval);
			numaricVal = numaricVal / 10;
		}

		// reverse of arraylist
		Collections.reverse(arrList);
		for (Integer digit : arrList) {
			sendKeyMultipleTimes("NUMPAD" + digit, 1, 0);
		}

	}

	public static void setApplicationHubPage(int noOfRetry) throws InterruptedException {

		System.out.println("Trying to set home page ");

		if (!(Boolean.valueOf(getUpdatedProptiesFile().getProperty("RunOnUnassignedSTB")))) {

			sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 2000);
			sendNumaricKeys(1);
			Thread.sleep(3000);
			handlePopupIfExist();

			sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(), 1, 1000);
			int retryForHubScreen = 5;
			Actions action = new Actions(driver);

			// Needs to switch home screen
			System.out.println("Trying to switch to default content");

			driver.switchTo().defaultContent();
			System.out.println("Default content switcg successfully.");

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
		} else {
			System.out.println("STB is UnAssigned");
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

	private void launchWebdriver() throws IOException, InterruptedException {

		String url = null;
		Properties PR = getUpdatedProptiesFile();
		url = PR.getProperty("URL");

		boolean executionOnHTV = false;
		executionOnHTV = Boolean.valueOf(PR.getProperty("RunOnHTV"));

		if (executionOnHTV) {

			DesiredCapabilities capability = new DesiredCapabilities();
			// Start WebDriver by reusing existing widget UI
			capability.setCapability("browserStartWindow", "*");
			capability.setCapability(CapabilityType.TAKES_SCREENSHOT, true);

			String stbIP = null;
			stbIP = System.getProperty("STBIP");
			if (stbIP == null || stbIP.contentEquals("")) {
				stbIP = TestInitization.getUpdatedProptiesFile().getProperty("STBIP");
			}

			int connectionTimeout = 5000;
			int socketTimeout = 15000;

			ApacheHttpClient.Factory clientFactory = new ApacheHttpClient.Factory(
					new HttpClientFactory(connectionTimeout, socketTimeout));
			HttpCommandExecutor executor = new HttpCommandExecutor(new HashMap<String, CommandInfo>(),
					new URL("http://" + stbIP + ":9517"), clientFactory);
			driver = new RemoteWebDriver(executor, capability);

			selectWindow("http");
			// override URL in case of HTV
			url = "http://hpg.nat.myrio.net/boot_webkit.html";
		}

		else {

			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.navigate().to(url);

	}

	private String selectWindow(String protocol) {
		Set<String> windowHandles = driver.getWindowHandles();

		for (Iterator<String> iterator = windowHandles.iterator(); iterator.hasNext();) {
			String w = iterator.next();

			driver.switchTo().window(w);
			if (driver.getCurrentUrl().startsWith(protocol)) {

				return w;
			}
		}
		return null;
	}

	public void FailTestCase(String reason) throws InterruptedException {
		Assert.fail(reason);
	}

	public void isDisplayed(WebElement we, String webElementName) throws InterruptedException {

		try {
			if (we.isDisplayed()) {

				reports.log(LogStatus.PASS, webElementName + " is visible on webpage");
				reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			} else {

				FailTestCase(webElementName + " exist on webpage but it is not visible on webpage");

			}
		} catch (NoSuchElementException e) {
			FailTestCase(webElementName + " is not found on webpage");

		}

	}

	public void isNotDisplayed(WebElement we, String webElementName) throws InterruptedException {

		try {
			if (!we.isDisplayed()) {

				reports.log(LogStatus.PASS, webElementName + " is not visible on webpage");
				reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			} else {
				FailTestCase(webElementName + "is visible on webpage");

			}
		} catch (NoSuchElementException e) {
			FailTestCase(webElementName + " is not found on webpage");

		}

	}

	public void assignLanguageToStB(String language, String accountNumber, String pinCode)
			throws InterruptedException, FileNotFoundException, IOException {

		Properties PR = getUpdatedProptiesFile();
		Boolean runOnUnassignedSTB = Boolean.valueOf(PR.getProperty("RunOnUnassignedSTB"));

		if (!runOnUnassignedSTB) {
			// if above variable in false in config file than unable to execute
			// test case
			throw new SkipException(
					"Check STB is unassigned and set the variable RunOnUnassignedSTB=True in configuration file");
		}

		Hub hubScreen = new Hub(driver);
		reports.log(LogStatus.PASS, "Select Language ");
		if (language.toUpperCase().contentEquals("NL")) {
			sendKeyMultipleTimes("ENTER", 1, 1000);
			reports.attachScreenshot(captureCurrentScreenshot());
			selectLanguage(accountNumber, pinCode);
			// Validation for language
			reports.log(LogStatus.PASS, "Navigate the setting screen");
			TestInitization.sendKeysSequenceUpdated("RIGHT,RIGHT,RIGHT,ENTER", 2000,
					TestInitization.getExcelKeyValue("screenTitles", "Setting", "name_nl"));
			driver.switchTo().defaultContent();
			reports.log(LogStatus.PASS,
					"Language changed to NL Actual Title is :" + hubScreen.headerText.getText()
							+ "and expected title is : "
							+ TestInitization.getExcelKeyValue("screenTitles", "Setting", "name_nl"));
			reports.attachScreenshot(captureCurrentScreenshot());

		}

		else if (language.toUpperCase().contentEquals("FR")) {

			sendKeyMultipleTimes("UP", 1, 1000);
			sendKeyMultipleTimes("ENTER", 1, 1000);
			reports.attachScreenshot(captureCurrentScreenshot());

			selectLanguage(accountNumber, pinCode);
			reports.log(LogStatus.PASS, "Navigate the setting screen");
			// Validation for language
			TestInitization.sendKeysSequenceUpdated("RIGHT,RIGHT,RIGHT,ENTER", 2000,
					TestInitization.getExcelKeyValue("screenTitles", "Setting", "name_fr"));
			driver.switchTo().defaultContent();
			reports.log(LogStatus.PASS,
					"Language changed to NL Actual Title is :" + hubScreen.headerText.getText()
							+ "and expected title is : "
							+ TestInitization.getExcelKeyValue("screenTitles", "Setting", "name_fr"));
			reports.attachScreenshot(captureCurrentScreenshot());

		}

		else {
			FailTestCase("Given language not found.Expected Language are FL or NL");
		}
		ProximusContext.setLanguage(language);
	}

	private void selectLanguage(String accountNumber, String pinCode)
			throws InterruptedException, FileNotFoundException, IOException {

		boolean isFirstCharZeroForAccount = false;
		boolean isFirstCharZeroForpinCode = false;
		Properties PR = getUpdatedProptiesFile();

		if (accountNumber.substring(0, 1).contentEquals("0")) {
			isFirstCharZeroForAccount = true;
		}

		if (pinCode.substring(0, 1).contentEquals("0")) {
			isFirstCharZeroForpinCode = true;
		}

		reports.log(LogStatus.PASS, "Enter account number");
		if (isFirstCharZeroForAccount) {
			sendNumaricKeys(0);
		}

		sendNumaricKeys(Integer.parseInt(accountNumber));
		reports.attachScreenshot(captureCurrentScreenshot());
		sendKeyMultipleTimes("ENTER", 1, 1000);

		reports.log(LogStatus.PASS, "Enter Pin code");
		if (isFirstCharZeroForpinCode) {
			sendNumaricKeys(0);
		}

		reports.attachScreenshot(captureCurrentScreenshot());
		sendNumaricKeys(Integer.parseInt(pinCode));

		// update the value of configuration properties file
		PR.setProperty("RunOnUnassignedSTB", "FALSE");
		PR.put("RunOnUnassignedSTB", "FALSE");
		PR.store(new FileOutputStream(configFilePath), null);

		driver.switchTo().defaultContent();

		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//img[@src='resources/components/animation/images/logo.png']")));
		System.out.println("Proximus Logo Loaded");

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ScreenHolder1"));

		System.out.println("Frame loaded");
		Thread.sleep(2000);

		setApplicationHubPage(1);
	}

	public static Properties getUpdatedProptiesFile() {
		Properties PR = new Properties();
		FileInputStream FI;
		try {
			FI = new FileInputStream(configFilePath);
			PR.load(FI);
		} catch (IOException e) {

			e.printStackTrace();
		}

		return PR;
	}

	private static String getBuildVersion() {
		String buildVersion = null;
		buildVersion = System.getProperty("BuildVersion");
		if (buildVersion == null || buildVersion.contentEquals("")) {
			buildVersion = TestInitization.getUpdatedProptiesFile().getProperty("BuildVersion");
		}
		return buildVersion;
	}

	/**
	 * @param realPrintStream
	 * @return override the console logger with proximus logger also add time
	 *         and date in console
	 */
	public static PrintStream createLoggingProxy(final PrintStream realPrintStream) {
		return new PrintStream(realPrintStream) {
			public void print(final String string) {
				log.info(string);
			}
		};
	}

	public static void handlePopupIfExist() throws InterruptedException {
		MiniEPGScreen miniEPGScreen = new MiniEPGScreen(driver);
		driver.switchTo().frame(getCurrentFrameIndex());
		try {
			if (miniEPGScreen.notificationMsg.isDisplayed()) {
				sendKeyMultipleTimes("ENTER", 1, 1000);
			}
		} catch (NoSuchElementException e) {
		}
	}
	
	public static void main(String arr[]) throws InterruptedException{
		SSH_Connection  sshConnection = new SSH_Connection();
		sshConnection.rebootSTBAndSetup("10.67.181.116", "root",
				"yanjebipBoathHairgonpexUkkuarcIgjafbijKodgiNuflathsyepNujAvTetef");
	}
	
	
	private void launchApplication(){
		
		
		System.out.println("Waiting for the page to load");
		wait = new WebDriverWait(driver, 120L);

		try {

			wait.until(ExpectedConditions.presenceOfElementLocated(
					By.xpath("//img[@src='resources/components/animation/images/logo.png']")));
			System.out.println("Proximus Logo Loaded");

			if (!(Boolean.valueOf(getUpdatedProptiesFile().getProperty("RunOnUnassignedSTB")))) {

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

			} else {
				System.out.println("STB is Unassigned");
				// Thread.sleep(5000);
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ScreenHolder0"));
				System.out.println("Frame loaded");
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("heading1")));
				Thread.sleep(2000);
			}
		}

		catch (Throwable t) {
			t.printStackTrace();
			System.out.println("HUB is not loaded with TV showcase focused " + t);

		}

		log.info("Logger Info:: Going out of Setup Method");
	}
}
