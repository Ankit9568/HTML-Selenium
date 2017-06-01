package com.rsystems.exceptionHandling;

import java.util.ArrayList;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;
import com.rsystems.utils.TestInitization;

public class ExceptionTrap extends TestInitization {

	private ArrayList<Exception> registeredException = new ArrayList<>();
	private ITestResult testResult = null;

	public ExceptionTrap(ITestResult result) {
		this.testResult = result;
		// Add run time exception here
		registeredException.add(new NoSuchElementException(ExceptionMesages.NoSuchElementException.toString()));
		registeredException
				.add(new StaleElementReferenceException(ExceptionMesages.StaleElementReferenceException.toString()));
		registeredException.add(new NullPointerException(ExceptionMesages.NullPointerException.toString()));
		registeredException.add(new NoSuchWindowException(ExceptionMesages.NoSuchWindowException.toString()));
	}

	public void setExtendReportStatus() {

		boolean matchedRegisteredException = false;
		if (testResult.getStatus() == ITestResult.SKIP) {
			reports.log(LogStatus.ERROR, testResult.getThrowable().getLocalizedMessage());
			return;
		}

		for (Exception exception : registeredException) {
			if (exception.getClass().getName().equalsIgnoreCase(testResult.getThrowable().getClass().getName())) {
				reports.log(LogStatus.FAIL, exception.getMessage());
				matchedRegisteredException = true;
			}
		}
		if(!matchedRegisteredException){
			reports.log(LogStatus.FAIL, testResult.getThrowable().getMessage());
		}
	}
}
