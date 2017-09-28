package com.rsystems.test;

import org.testng.annotations.Test;

import com.rsystems.pages.Pvr;
import com.rsystems.utils.TestInitization;

public class PvrTestCase extends TestInitization
{
	@Test
	public void TP007_PVRTrickplaymenufromPVR() throws InterruptedException
	{
		Pvr p = new Pvr(driver);
		p.PvrPlayBackMenu();
		
	}
	
    @Test      
	public void TP008_PVRRCKeysduringTrickplay() throws InterruptedException
	{
		Pvr p = new Pvr(driver);
		p.PvrRcTrickPlay();
		
	}
	

    /**
	 * @author Pritam.Dutta
	 * This test cases is used to Play any of the recordings up to the end, with and without using trickplay. the recording in normal speed.
	 * @throws InterruptedException
	 */
	@Test
	public void tc_BCDTVCP1440_Playback_Till_End() throws InterruptedException
	{
		Pvr p = new Pvr(driver);
		p.playback_Till_End();
		
	}
	
	
	



	
	
	
	
	
	
	
}
