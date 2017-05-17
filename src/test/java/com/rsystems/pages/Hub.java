package com.rsystems.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Hub {
	
	WebDriver driver;
	
	public Hub(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="")
	public WebElement hubTelevisionTextLine;
	
	@FindBy(how=How.XPATH,using="")
	public WebElement hubLibraryTextLine;
	
	@FindBy(how=How.XPATH,using="")
	public WebElement hubStoreTextLine;
		
	public void hubTextlineNavigation()
	{
					
		
	}
	
	public void hubUIValidation()
	{
					
		
	}
	
	public void hubShowcaselineNavigation()
	{
					
		
	}
	
}
