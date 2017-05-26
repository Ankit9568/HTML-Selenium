package com.rsystems.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.rsystems.utils.TestInitization;

/** 
 * @author Ankit.Agarwal1
 * return necessary object of EPG Screen
 */

public class EpgScreen extends TestInitization{

	
	public static WebElement getEpgType(){	
		return driver.findElement(By.id("epgType"));
	}
	
	public static WebElement getEpgBackground(){
		return driver.findElement(By.id("epgBackground"));
	}
	
	public static WebElement getEpgFont(){
		return driver.findElement(By.id("epgFont"));
	}
	
}
