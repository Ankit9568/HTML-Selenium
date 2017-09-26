package com.rsystems.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.rsystems.config.ObjectRepository;

public class RentMovie {

	WebDriver driver;

	public RentMovie(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = ObjectRepository.FilmsScreen.highlighedMovieCategory)
	public WebElement highlighedMovieCategory;

	@FindBy(how = How.ID, using = ObjectRepository.FilmsScreen.currentSelectedMovieName)
	public WebElement currentSelectedMovieName;

	@FindBy(how = How.ID, using = ObjectRepository.FilmsScreen.rentOption)
	public WebElement rentOption;

	@FindBy(how = How.ID, using = ObjectRepository.FilmsScreen.trailer)
	public WebElement trailer;

	@FindBy(how = How.ID, using = ObjectRepository.FilmsScreen.huren)
	public WebElement huren;

	@FindBy(how = How.ID, using = ObjectRepository.FilmsScreen.addToFaviorite)
	public WebElement addToFaviorite;

	@FindBy(how = How.ID, using = ObjectRepository.FilmsScreen.itemScore)
	public WebElement itemScore;

	@FindBy(how = How.ID, using = ObjectRepository.FilmsScreen.similar)
	public WebElement similar;

	@FindBy(how = How.XPATH, using = ObjectRepository.FilmsScreen.director)
	public WebElement director;
	@FindBy(how = How.XPATH, using = ObjectRepository.FilmsScreen.actor)
	public WebElement actor;

	@FindBy(how = How.ID, using = ObjectRepository.FilmsScreen.priceText)
	public WebElement priceText;

	@FindBy(how = How.CLASS_NAME, using = ObjectRepository.FilmsScreen.audioLanguage)
	public WebElement audioLanguage;

	@FindBy(how = How.XPATH, using = ObjectRepository.FilmsScreen.breadcompSrc)
	public WebElement breadcompSrc;

	@FindBy(how = How.ID, using = ObjectRepository.FilmsScreen.dateTime)
	public WebElement dateTime;
	
	@FindBy(how = How.XPATH, using = ObjectRepository.FilmsScreen.vodDescription)
	public WebElement vodDescription;

}
