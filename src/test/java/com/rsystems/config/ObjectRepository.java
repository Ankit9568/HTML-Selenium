package com.rsystems.config;

public class ObjectRepository {

	public static final String excelFilePath = System.getProperty("user.dir")
			+ "/src/test/java/com/rsystems/config/testdata.xlsx";

	/*-----------------HUB Menu Item Locators------------------------*/

	public static final String HubTVItem = "//li[@id='menuItem_1']";
	public static final String HubLibraryItem = "//li[@id='menuItem_0']";
	public static final String HubStoreItem = "//li[@id='menuItem_2']";
	public static final String HubSearchItem = "//li[@id='menuItem_3']";
	public static final String HubSettingsItem = "//li[@id='menuItem_4']";
	public static final String[] HubMenuItemsNL = { "mijn bibliotheek", "televisie", "shop", "search_normal1.png",
			"setting_normal.png" };
	public static final String[] HubMenuItemsNLFocused = { "mijn bibliotheek", "televisie", "shop",
			"search_active_bold.png", "setting_active_bold.png" };
	public static final String[] Test1 = { "mijn bibliotheek", "televisie", "shop", "search_active_bold.png",
			"setting_active_bold.png" };
	public static final String[] Test2 = { "mijn bibliotheek", "televisie", "shop", "search_active_bold.png",
			"setting_active_bold.png" };

	public static class EpgSettingScreen {
		public static final String epgType = "epgType";
		public static final String epgBackground = "epgBackground";
		public static final String epgFont = "epgFont";
		public static final String screenBackgroundColor = "//link[@href = './resources/components/epg_custom/css/parentgreen.css']";
		public static final String cancelButton = "item_4";
		public static final String confirmButton = "item_3";
	}

	public static class EpgScreen {
		public static final String focousElement = "//li[@class = 'program focusProgram']/div/p[@class='programTitle']";
		public static final String displayChannelTitle = "title";
		public static final String displayChannelDescription = "vodText";
		public static final String displayChannelprogressbar = "progress";
		public static final String displayChannelStartTime = "startDate";
		public static final String displayChannelEndTime = "endDate";
		public static final String displayChannelCallLetterIcon = "//li[@class='focusedChannel']/div[@class='ch_logo']/span/img";
		public static final String cutvIcon = "//span[@class='channel-cutv']";
		public static final String focousElementProrgamImg = "//li[@class='program focusProgram']/div/span[@class='programLogo']/img";
		public static final String diplayChannelDescImg = "//div[@class='poster']/img";
		public static final String focusElementProgramTiminig = "//li[@class = 'program focusProgram']/div/p[@class='programTiming']";
	}

	public static class LibraryElements {
		public static final String libraryMenuItemsXPath = "//li[contains(@class,'enable')]";
	}

	public static class PIPElements {
		public static final String pipPositonIDElement = "pipPosition";
		public static final String currentPIPClassElement = "//*[@class='logo-wrapper toggle']	";
		public static final String pipHeadingElement = "pipHeading";
		public static final String confirmElement = "//*[@id='item_1']";
		public static final String cancelElement = "//*[@id='item_2']";
	}

	public static class RecordingElements {
		public static final String InfoEpisodeNameXPath = "program-title";
		public static final String ChannelNoClassName = "channel-no";
		public static final String ChannelInfoImageXPath = "/html/body/div/div[2]/div[1]/div/div/div[1]/span/img";
		public static final String EpisodeDurationXPath = "/html/body/div/div[2]/div[1]/div/div/div[3]/div[2]";
		public static final String ProgramDefinitionXPath = "/html/body/div/div[2]/div[1]/div/div/div[3]/div[1]/img";
		public static final String RecordingListCSSSelector = "#recordingContent div[id^='item']";
		public static final String ChannelNoInPlannedRecording = "recordingNumber";
		public static final String ChannelLogoInPlannedRecording = ".logo";
		public static final String ProgramNameInPlannedRecording = ".recordingDetails h2";
		public static final String ProgramDurationInPlannedRecording = ".recordingDetails .duration";
		public static final String ProgramDefinitionInPlannedRecording = ".hd_quality img";
		public static final String StartRecordingXPath = "//*[@id='item_1']";
		public static final String currentRecordingCountID = "countNumbers";
		public static final String totalRecordingsID = "totalItems";
		public static final String focusRecordingElementXPath = "//div[@class='recordingList fillGradient']";
	}

	public static class VerifySystemInfoScreen {
		public static final String systemInfoXpath = "//div[@id='settingInfoHeading']";
		public static final String hardwareVersion = "hardware_version";
		public static final String softwareVersion = "software_version";
		public static final String hpgVersion = "hpg_version";
		public static final String serialNumber = "serial_number";
	}

	public static class FilmsScreen {
		public static final String highlighedMovie = "//li[@class='focusedItem'][2]/span";
	}

	public static class LanguageChange {
		public static final String position = "pipPosition";
		public static final String menuItem = "leftLabel";
		public static final String confirm = "item_1";
		public static final String itemHeading = "item_1";
		public static final String heading = "settingHeading";
		public static final String languagedumenu = "item_0";

	}

	public static class DtvChannel {
		public static final String chnlNoIn_Infobar = "current_channel";
		public static final String programDurationIn_Infobar = "programTime";
		public static final String programTitle = "programTitle";
		public static final String hdIcon = "programHD";
		public static final String channelLogo = "current_channel_logo";
		public static final String pauseAndPlayImg = "//li[@id='play_pause']/div/img";
		public static final String backToLive = "//div[@id='containerDiv']/div[text()='Terug naar leven']";
	}

	public static class ZapListPage {

		public static final String screenTitle = "//p[@id='headerTitle']";
		public static final String focousChannelNumber = "//div[@class='focusBox']/ul/li[2]/div[@class='channel_details']/div/span";
		
	}
}
