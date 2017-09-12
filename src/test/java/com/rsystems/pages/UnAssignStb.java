package com.rsystems.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.rsystems.config.ObjectRepository;

public class UnAssignStb {

	WebDriver driver;

	public UnAssignStb(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = ObjectRepository.unAssignStbScreen.languageHeading)
	public WebElement languageHeading;

}
