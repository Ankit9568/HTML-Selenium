package com.rsystems.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.LogStatus;
import com.rsystems.config.ObjectRepository;
import com.rsystems.utils.TestInitization;
import com.rsystems.utils.Unicode;

public class Pvr extends TestInitization
{
	WebDriver driver;
    public Pvr(WebDriver driver) 
    {
	this.driver = driver;
	PageFactory.initElements(driver, this);
    }

 public void navigateToTheVODPlayback() throws InterruptedException
	{
	   reports.log(LogStatus.PASS, "Playing VOD");
		sendKeyMultipleTimes("UP", 1, 1000);
		sendKeyMultipleTimes("RIGHT", 1, 1000);
		sendKeyMultipleTimes("ENTER", 1, 1000);
		sendKeyMultipleTimes("DOWN", 1, 1000);
		sendKeyMultipleTimes("ENTER", 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		sendNumaricKeys(1);
		sendNumaricKeys(1);
		sendNumaricKeys(1);
		sendNumaricKeys(1);
		
	}
	
public void PvrPlayBackMenu() throws InterruptedException
{
	reports.log(LogStatus.PASS, "PVR play video");
	sendKeyMultipleTimes("UP", 1, 1000);
	sendKeyMultipleTimes("ENTER", 1, 1000);
	reports.attachScreenshot(captureCurrentScreenshot());
	
	
	reports.log(LogStatus.PASS, "Forwarding the Video Playback");
	sendUnicodeMultipleTimes(Unicode.VK_FORWARD.toString(), 1, 1000);
	reports.attachScreenshot(captureCurrentScreenshot());
	
	
	reports.log(LogStatus.PASS, "Backward the Video Playback");
	sendUnicodeMultipleTimes(Unicode.VK_BACKWARD.toString(),1,1000);
	reports.attachScreenshot(captureCurrentScreenshot());
	
	
	reports.log(LogStatus.PASS, "Playing the Video Playback");
	sendUnicodeMultipleTimes(Unicode.VK_PLAY.toString(), 1, 1000);
	reports.attachScreenshot(captureCurrentScreenshot());
	
	
	reports.log(LogStatus.PASS, "Pause the Video Playback");
	sendUnicodeMultipleTimes(Unicode.VK_PAUSE.toString(), 1, 1000);
	reports.attachScreenshot(captureCurrentScreenshot());
	
	
	reports.log(LogStatus.PASS, "Stop the Video Playback");
	sendUnicodeMultipleTimes(Unicode.VK_STOP_RECORDING.toString(), 1, 1000);
	reports.attachScreenshot(captureCurrentScreenshot());
	
	reports.log(LogStatus.PASS, "Returning to the Hub Menu");
	
}	

public void PvrRcTrickPlay() throws InterruptedException
{
	reports.log(LogStatus.PASS, "PVR play video");
	sendKeyMultipleTimes("UP", 1, 1000);
	sendKeyMultipleTimes("ENTER", 1, 1000);
	reports.attachScreenshot(captureCurrentScreenshot());
	
	reports.log(LogStatus.PASS, "Forwarding the Video Playback");
	sendUnicodeMultipleTimes(Unicode.VK_FORWARD.toString(), 1, 1000);
	reports.attachScreenshot(captureCurrentScreenshot());
	
	
	reports.log(LogStatus.PASS, "Returning to the Main Menu");
	sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(), 1, 1000);
	reports.attachScreenshot(captureCurrentScreenshot());
	
	reports.log(LogStatus.PASS, "Returning to the Hub Menu");
	TestInitization.setApplicationHubPage(2);
	sendKeyMultipleTimes("UP", 1, 1000);
	sendKeyMultipleTimes("ENTER", 1, 1000);
	reports.log(LogStatus.PASS, "Rewinding the video Playback");
	sendUnicodeMultipleTimes(Unicode.VK_BACKWARD.toString(),1,1000);
	reports.attachScreenshot(captureCurrentScreenshot());
	
	
	reports.log(LogStatus.PASS, "Pressing on the Ondemand Hot key");
	sendUnicodeMultipleTimes(Unicode.VK_ONDEMAND.toString(), 1, 1000);
	reports.attachScreenshot(captureCurrentScreenshot());
	
	reports.log(LogStatus.PASS, "Returning to the Hub Menu");
	TestInitization.setApplicationHubPage(2);
	sendKeyMultipleTimes("UP", 1, 1000);
	sendKeyMultipleTimes("ENTER", 1, 1000);
	reports.log(LogStatus.PASS, "Forwarding the Video Playback");
	sendUnicodeMultipleTimes(Unicode.VK_FORWARD.toString(), 1, 1000);
	reports.attachScreenshot(captureCurrentScreenshot());
	
	
	reports.log(LogStatus.PASS, "Pressing on the PVR hot key");
	sendUnicodeMultipleTimes(Unicode.VK_PVR.toString(), 1, 1000);
	reports.attachScreenshot(captureCurrentScreenshot());
	
	reports.log(LogStatus.PASS, "Returning to the Hub Menu");
	TestInitization.setApplicationHubPage(2);
	sendKeyMultipleTimes("UP", 1, 1000);
	sendKeyMultipleTimes("ENTER", 1, 1000);
	reports.log(LogStatus.PASS, "Forwarding the Video Playback");
	sendUnicodeMultipleTimes(Unicode.VK_FORWARD.toString(), 1, 1000);
	reports.attachScreenshot(captureCurrentScreenshot());
	
	
	reports.log(LogStatus.PASS, "Rewinding the video Playback");
	sendUnicodeMultipleTimes(Unicode.VK_BACKWARD.toString(), 1, 1000);
	reports.attachScreenshot(captureCurrentScreenshot());
	
	reports.log(LogStatus.PASS, "Returning to the Hub Menu");
	TestInitization.setApplicationHubPage(2);
	sendKeyMultipleTimes("UP", 1, 1000);
	sendKeyMultipleTimes("ENTER", 1, 1000);
	reports.log(LogStatus.PASS, "Pressing on the Pause button");
	sendUnicodeMultipleTimes(Unicode.VK_PAUSE.toString(), 1, 1000);
	reports.attachScreenshot(captureCurrentScreenshot());
	
	reports.log(LogStatus.PASS, "Rewinding the video Playback");
	sendUnicodeMultipleTimes(Unicode.VK_BACKWARD.toString(), 1, 1000);
	reports.attachScreenshot(captureCurrentScreenshot());
	
	reports.log(LogStatus.PASS, "Pressing on the Pause button");
	sendUnicodeMultipleTimes(Unicode.VK_PAUSE.toString(), 1, 1000);
	reports.attachScreenshot(captureCurrentScreenshot());
	
	reports.log(LogStatus.PASS, "Pressing on the PVR button");
	sendUnicodeMultipleTimes(Unicode.VK_PVR.toString(), 1, 1000);
	reports.attachScreenshot(captureCurrentScreenshot());
	
	reports.log(LogStatus.PASS, "Returning to the Hub Menu");
	TestInitization.setApplicationHubPage(2);
	sendKeyMultipleTimes("UP", 1, 1000);
	sendKeyMultipleTimes("ENTER", 1, 1000);
	reports.log(LogStatus.PASS, "Pressing on the Pause button");
	sendUnicodeMultipleTimes(Unicode.VK_PAUSE.toString(), 1, 1000);
	reports.attachScreenshot(captureCurrentScreenshot());
	
	
	reports.log(LogStatus.PASS, "Pressing on the Ondemand hot key button");
	sendUnicodeMultipleTimes(Unicode.VK_ONDEMAND.toString(),1,1000);
	reports.attachScreenshot(captureCurrentScreenshot());
	
	reports.log(LogStatus.PASS, "Returning to the Hub Menu");
	TestInitization.setApplicationHubPage(2);
	sendKeyMultipleTimes("UP", 1, 1000);
	sendKeyMultipleTimes("ENTER", 1, 1000);
	reports.log(LogStatus.PASS, "Pressing on the Pause button");
	sendUnicodeMultipleTimes(Unicode.VK_PAUSE.toString(), 1, 1000);
	reports.attachScreenshot(captureCurrentScreenshot());
	
	
	reports.log(LogStatus.PASS, "Pressing on the Menu button");
	sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(),1,1000);
	reports.attachScreenshot(captureCurrentScreenshot());
	
	reports.log(LogStatus.PASS, "Returning to the Hub Menu");
	
}

public void VODplayback() throws InterruptedException
{
	
	navigateToTheVODPlayback();
	sendKeyMultipleTimes("DOWN", 1, 1000);
	sendKeyMultipleTimes("ENTER", 1, 1000);
	
	reports.log(LogStatus.PASS, "Forward the Video");
	sendUnicodeMultipleTimes(Unicode.VK_FORWARD.toString(), 1, 1000);
	reports.attachScreenshot(captureCurrentScreenshot());
	
	reports.log(LogStatus.PASS, "Pause the Video");
	sendUnicodeMultipleTimes(Unicode.VK_PAUSE.toString(), 1, 1000);
	reports.attachScreenshot(captureCurrentScreenshot());
	
	reports.log(LogStatus.PASS, "Play the Video");
	sendUnicodeMultipleTimes(Unicode.VK_PLAY.toString(), 1, 1000);
	reports.attachScreenshot(captureCurrentScreenshot());
	
	reports.log(LogStatus.PASS, "Stopping the Video");
	sendUnicodeMultipleTimes(Unicode.VK_STOP_RECORDING.toString(), 1, 1000);
	reports.attachScreenshot(captureCurrentScreenshot());
	
	reports.log(LogStatus.PASS, "Returning to the Hub Menu");
}

public void VodRCKeysTrickplay() throws InterruptedException
{
	navigateToTheVODPlayback();
	
	sendKeyMultipleTimes("DOWN", 1, 1000);
	sendKeyMultipleTimes("ENTER", 1, 1000);
	
	reports.log(LogStatus.PASS, "Forward the Video");
	sendUnicodeMultipleTimes(Unicode.VK_FORWARD.toString(), 1,0);
	reports.attachScreenshot(captureCurrentScreenshot());
	
	reports.log(LogStatus.PASS, "Press on the Menu key");
	sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(), 1,0);
	reports.attachScreenshot(captureCurrentScreenshot());
	
	reports.log(LogStatus.PASS, "Returning to the Hub Menu");
	TestInitization.setApplicationHubPage(2);
	navigateToTheVODPlayback();
	reports.log(LogStatus.PASS, "Press on the Forward key");
	sendUnicodeMultipleTimes(Unicode.VK_FORWARD.toString(), 1, 1000);
	reports.attachScreenshot(captureCurrentScreenshot());

	reports.log(LogStatus.PASS, "Press on Demand Hot key");
	sendUnicodeMultipleTimes(Unicode.VK_ONDEMAND.toString(),1, 1000);
	reports.attachScreenshot(captureCurrentScreenshot());
	
	reports.log(LogStatus.PASS, "Returning to the Hub Menu");
	TestInitization.setApplicationHubPage(2);
	navigateToTheVODPlayback();
	reports.log(LogStatus.PASS, "Press on the back key");
	sendUnicodeMultipleTimes(Unicode.VK_BACKWARD.toString(),1, 1000);
	reports.attachScreenshot(captureCurrentScreenshot());
	
	reports.log(LogStatus.PASS, "Press on PVR Hot key");
	sendUnicodeMultipleTimes(Unicode.VK_PVR.toString(),1, 1000);
	reports.attachScreenshot(captureCurrentScreenshot());
	
	reports.log(LogStatus.PASS, "Returning to the Hub Menu");
	TestInitization.setApplicationHubPage(2);
	navigateToTheVODPlayback();
	reports.log(LogStatus.PASS, "Press on the Forward key");
	sendUnicodeMultipleTimes(Unicode.VK_FORWARD.toString(), 1, 1000);
	reports.attachScreenshot(captureCurrentScreenshot());

	
	reports.log(LogStatus.PASS, "Pause the Video");
	sendUnicodeMultipleTimes(Unicode.VK_PAUSE.toString(),1, 1000);
	reports.attachScreenshot(captureCurrentScreenshot());
	
	reports.log(LogStatus.PASS, "Press the Back key");
	sendUnicodeMultipleTimes(Unicode.VK_BACKWARD.toString(),1, 1000);
	reports.attachScreenshot(captureCurrentScreenshot());
	
	reports.log(LogStatus.PASS, "Pause the Video");
	sendUnicodeMultipleTimes(Unicode.VK_PAUSE.toString(),1, 1000);
	reports.attachScreenshot(captureCurrentScreenshot());
	
	reports.log(LogStatus.PASS, "Pressing the PVR key");
	sendUnicodeMultipleTimes(Unicode.VK_PVR.toString(),1, 1000);
	reports.attachScreenshot(captureCurrentScreenshot());
	
	reports.log(LogStatus.PASS, "Returning to the Hub Menu");
	TestInitization.setApplicationHubPage(2);
	navigateToTheVODPlayback();
	reports.log(LogStatus.PASS, "Pause the Video");
	sendUnicodeMultipleTimes(Unicode.VK_PAUSE.toString(),1, 1000);
	reports.attachScreenshot(captureCurrentScreenshot());
	
	reports.log(LogStatus.PASS, "Pressing the on demand hot key");
	sendUnicodeMultipleTimes(Unicode.VK_ONDEMAND.toString(),1, 1000);
	reports.attachScreenshot(captureCurrentScreenshot());
	
	reports.log(LogStatus.PASS, "Returning to the Hub Menu");
	TestInitization.setApplicationHubPage(2);
	navigateToTheVODPlayback();
	reports.log(LogStatus.PASS, "Pause the Video");
	sendUnicodeMultipleTimes(Unicode.VK_PAUSE.toString(),1, 1000);
	reports.attachScreenshot(captureCurrentScreenshot());
	
	reports.log(LogStatus.PASS, "Press Menu key hot key");
	sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(),1, 1000);
	reports.attachScreenshot(captureCurrentScreenshot());	
	
	reports.log(LogStatus.PASS, "Returning to the Hub Menu");

}
}
