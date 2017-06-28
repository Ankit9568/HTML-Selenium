package com.rsystems.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;
import com.rsystems.config.ObjectRepository;
import com.rsystems.utils.TestInitization;

public class Movie extends TestInitization {

	WebDriver driver;

	public Movie(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = ObjectRepository.FilmsScreen.highlighedMovie)
	public WebElement highlihgtedMovie;

	public void rentMovie() throws InterruptedException {

		TestInitization.setApplicationHubPage(2);

		reports.log(LogStatus.PASS, "Navigate to the Flims Screen");
		TestInitization.sendKeySequence("RIGHT,ENTER,ENTER", 2000,
				TestInitization.getExcelKeyValue("screenTitles", "Shop", "name_nl"));

		int maxRightMoveCount = 20;

		while (maxRightMoveCount > 0 && highlihgtedMovie.getText()
				.equalsIgnoreCase(TestInitization.getExcelKeyValue("Films", "RentedMovieCategorie", "name_nl"))) {

			TestInitization.sendKeyMultipleTimes("RIGHT", 1, 1000);
			maxRightMoveCount--;

		}

	}
}
