package com.rsystems.config;

import java.io.File;

public class ObjectRepository {

	public static final String excelFilePath = System.getProperty("user.dir") + File.separator + "src" + File.separator
			+ "test" + File.separator + "java" + File.separator + "com" + File.separator + "rsystems" + File.separator
			+ "config" + File.separator + "testdata.xlsx";

	/*-----------------HUB Menu Item Locators------------------------*/

	public static final String HubTVItem = "//li[@id='menuItem_1']";
	public static final String HubLibraryItem = "//li[@id='menuItem_0']";
	public static final String HubStoreItem = "//li[@id='menuItem_2']";
	public static final String HubSearchItem = "//li[@id='menuItem_3']";
	public static final String HubSettingsItem = "//li[@id='menuItem_4']";
	public static final String[] HubMenuItemsNL = { "mijn bibliotheek", "televisie", "shop", "search_normal.png",
			"setting_normal.png" };
	public static final String[] HubMenuItemsNLFocused = { "mijn bibliotheek", "televisie", "shop",
			"search_active_bold.png", "setting_active_bold.png" };
	public static final String[] HubMenuItemsFocused = { "mijn bibliotheek", "televisie", "shop", "Search", "Setting" };
	public static final String[] Test2 = { "mijn bibliotheek", "televisie", "shop", "search_active_bold.png",
			"setting_active_bold.png" };

	public static class unAssignStbScreen {
		
		public  static final String languageHeading = "//span[@class='left-txt']";
	}

	public static class EpgSettingScreen {
		public static final String epgType = "epgType";
		public static final String epgBackground = "epgBackground";
		public static final String epgFont = "epgFont";
		public static final String screenBackgroundColor = "//link[@href = './resources/components/epg_custom/css/parentgreen.css']";
		public static final String cancelButton = "item_4";
		public static final String confirmButton = "item_3";
	}

	public static class EpgScreen {
		public static final String focousElement = "//li[@class = 'program focusProgram']/div/p[contains(@class,'programTitle')]";
		public static final String displayChannelTitle = "title";
		public static final String displayChannelDescription = "description";
		public static final String displayChannelprogressbar = "progress";
		public static final String displayChannelStartTime = "prog-time";
		public static final String displayChannelEndTime = "endDate";
		public static final String displayChannelCallLetterIcon = "//li[@class='focusedChannel']/div[contains(@class,'ch_logo')]/span/img";
		public static final String cutvIcon = "//span[@class='channel-cutv']";
		public static final String focousElementProrgamImg = "//li[@class='program focusProgram']/div/span[contains(@class,'programLogo')]/img";
		public static final String diplayChannelDescImg = "//div[@class='poster']/img";
		public static final String focusElementProgramTiminig = "//span[@id='prog-time']";
		// public static final String focusElementCUTVIcon = "//li[@class =
		// 'program focusProgram']/div/p[2]/span/img[1]";
		public static final String focusElementCUTVIcon = "//*[@id='groupIcon']/img[@class='cutvicon']";
		public static final String epgFocussedCell = "//li[@class='program focusProgram']/div[@class='focusProgram']";
		public static final String epgNonFocussedCell = "//li[@class='program']/div";
		public static final String focousElementChannelNumber = "//li[@id='colCh0']/span/span[1]";
		public static final String actionList = "//div[@id='containerDiv']/div[contains(@class,'cItem')]";
		public static final String herstarten = "//div[(text()='herstarten')]";
		public static final String focusedProgramTvguide = "//li[@class='program focusProgram']";
		public static final String focusedCurrentLineTvguide = "currentTimeLine";
		public static final String actionMenuItems = "cVodInfoMenu";

		public static final String timeInFocousCell = "//li[@class = 'program focusProgram']/div/p[@class='programTiming ']";
		public static final String summryInFocousCell = "//li[@class = 'program focusProgram']/div/div[@class='programDescription']/div[1]";

		public static final String iconElementListInFocousCell = "//li[@class = 'program focusProgram']/div/span[@class='epggroupicon']/img";
		public static final String focousElementCell = "//li[@class = 'program focusProgram']/div[2]";
		public static final String dayNavigator = "dayHeading";

		public static final String channelGenere = "category-detail";

		public static final String channelLogo = "//li[@id='colCh0']/div[@class='ch_logo']";
		public static final String cutvChannelIcon = "//li[@id='colCh0']/span/span[2]";
		public static final String nonFocussedCell = "//li[@class='program']/div[1]";
		public static final String focussedCell = "//li[@class='program focusProgram']";
		public static final String ChannelCells = "programChannels";

		public static final String nonFocussedProgramTitle = "//li[@class='program']/div/p[contains(@class,'programTitle')]";
		public static final String programTimingInProgramCell = "//li[@class = 'program']/div/p[contains(@class,'programTiming ')]";

		public static final String timeInNonFocousCell = "//li[@class = 'program']/div/p[contains(@class,'programTiming')]";
		public static final String summryInNonFocousCell = "//li[@class = 'program']/div/div[@class='programDescription']/div[1]";
		public static final String iconElementListInNonFocousCell = "//li[@class='program']/div/span[@class='epggroupicon']/img";

		public static final String largeRecordingIcon = "//*[@id='groupIcon']/img[@id='recording']";
		public static final String smallRecordingIcon = "//li[@class = 'program focusProgram']/div/span[@class='epggroupicon']/img[@class='recording']";

		public static final String timeLineGradient = "currentTimeLine";
		public static final String epgPoster = "poster";
		public static final String epgTitleHighlightedProgram = "title";
		public static final String remainingTime = "//div[@class='channelsDetails']/div[contains(@class,'descriptions')]/div[@class='title-group']/span[contains(@class,'remaining-time')]";
		public static final String titleGroup = "//div[@class='channelsDetails']/div[contains(@class,'descriptions')]/div[@class='title-group']";
		public static final String programSummary = "description";
		public static final String groupIconImage = "//*[@id='groupIcon']/img";
		public static final String groupIcon = "groupIcon";
		public static final String barIcon = "//div[@class='channelsDetails']/div[contains(@class,'descriptions')]/div[@class='title-group']/span[contains(@class,'remaining-time')]/b";
		public static final String lastIcon = "//span[@id='groupIcon']/img[last()]";
		public static final String focusedChannlDetails = "//div[@class='channelsDetails']";
		public static final String channelBar = "//section[@class='channels_container channels_container_box_shadow']";
		public static final String epgGroupIcon = "//li[@class = 'program focusProgram']/div/span[@class='epggroupicon']/img";
		public static final String channelsIcon="//li[@id='colCh0']/span/span[@class='channel-cutv']";
		public static final String stopRecordigMsgTitle = "dtvText";
		
	}

	public static class LibraryElements {
		public static final String libraryMenuItemsXPath = "//li[contains(@class,'enable')]";
		public static final String libraryCanvas = "//*[@id='dCanvasUpLine']";
		public static final String libraryElementRowContainer = "rowContainer";
		public static final String titleHeadingOfScreen = "titleHeading";
	}

	public static class PIPElements {
		public static final String pipPositonIDElement = "pipPosition";
		public static final String currentPIPClassElement = "//*[@class='logo-wrapper']	";
		public static final String pipHeadingElement = "pipHeading";
		public static final String confirmElement = "//*[@id='item_1']";
		public static final String cancelElement = "//*[@id='item_2']";
	}

	public static class RecordingElements {

		public static final String InfoEpisodeNameXPath = "program-title";
		public static final String ChannelNoClassName = "channel-no";
		public static final String ChannelInfoImageXPath = "//div[@class='dtv-infoplayer-container']/span[@class='dtvinfo-poster']/img";
		public static final String EpisodeDurationXPath = "//div[@class='program-info']/div[@class='duration']";
		public static final String ProgramDefinitionXPath = "//div[@class='program-info']/div[@class='dtv-info-ratings']/img";
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
		public static final String focusProgramCalssName = "focusProgram";
		public static final String activeMenuItemElement = "cActiveItem";
		public static final String ongoingRecordingIconElement = ".videoQuality .ongoing_recording img";
		public static final String plannedRecordingTitleElement = "sTitlebar";
		public static final String epgGuideElement = "epgGuide";
		public static final String futureRecordingIconElement = ".epggroupicon img[src='./resources/common/images/ico_Future_recording.png']";
		public static final String recordingIconElement = "//*[@id='recording']";
	}

	public static class VerifySystemInfoScreen {
		public static final String systemInfoXpath = "//div[@id='settingInfoHeading']";
		public static final String hardwareVersion = "hardware_version";
		public static final String softwareVersion = "software_version";
		public static final String hpgVersion = "hpg_version";
		public static final String serialNumber = "serial_number";
	}

	public static class FilmsScreen {
		public static final String highlighedMovieCategory = "//li[@class='focusedItem current']/span";
		public static final String currentSelectedMovieName = "selectedVodTitle";
		public static final String rentOption = "item_rent";
		public static final String trailer = "item_trailer";
		public static final String huren = "item_rent";
		public static final String addToFaviorite = "item_bookmarks";
		public static final String itemScore = "item_score";
		public static final String similar = "item_comparable";
		public static final String director = "//div[@id='actor-director']/p";
		public static final String actor = "//div[@id='actor-director']/p[2]";
		public static final String priceText = "price-text";
		public static final String audioLanguage = "language";
		public static final String breadcompSrc = "//article[@class='logo']/img[@src='resources/components/animation/images/logo.png']";
		public static final String dateTime = "headerDateTime";
		public static final String vodDescription = "//div[@class='vodText']/p";
		public static final String vodHeading = "//div[@id='vodDetail']/div/div[@class='vod-heading-main']";
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
		public static final String rewindBtn = "rewind";
		public static final String errorMsg = "error-message";
		public static final String forward = "forward";
		public static final String infoBanner = "player_controls";
		public static final String enablePausePlayButton = "play_pause";
		public static final String stopBtn = "stop";
		public static final String playerBar = "//div[@id='player_controls']";
		//New Element
		public static final String programEndTime="//div[@id='programProgressBar']/span[@class='program-time end-time']";
		public static final String toastMessage="//div[@class='NotAvailble']/currently";
	}

	public static class ZapListPage {

		public static final String screenTitle = "//p[@id='headerTitle']";
		public static final String focousChannelNumber = "//div[@class='focusBox']/ul/li[2]/div[@class='channel_details']/div/span";

	}

	public static class HubScreen {
		public static final String headerElement = "//*[@id='headerTitle']";
		public static final String upCanvasLineElement = "dUpperCanvasContainer";
		public static final String downCanvasLineElement = "dLowerCanvasContainer";
		public static final String libraryItemsElement = "//li[contains(@id,'item_m0')]";
		public static final String shopItemsElement = "//li[contains(@id,'item_m2')]";
		public static final String hubSearchElement = "//*[@id='dItemImage_30']/span";
		public static final String hubSettingElement = "//*[@id='dItemImage_40']/span";
		public static final String hubFocusElement = "cActiveMenuItem";
		public static final String menuItemContainer = "dMenuList";
		public static final String recordingMenu = "//section[@id='dMenuList']/ul/li[@id='menuItem_0']";
		public static final String tvGuideFilter = "//section[@id='dMenuList']/ul/li[@id='menuItem_1']";
		public static final String storeFilter = "//section[@id='dMenuList']/ul/li[@id='menuItem_2']";
		public static final String search = "//section[@id='dMenuList']/ul/li[@id='menuItem_3']";
		public static final String setting = "//section[@id='dMenuList']/ul/li[@id='menuItem_4']";
		public static final String assetLineList = "//ul[@id='dMinimizedSlider']/li";

	}

	public static class MiniEPGScreen {
		public static final String headerTimeElement = "headerDateTime";
		public static final String currentEpisodeElement = "current";
		public static final String activeZapBlockElement = "active";
		public static final String currentChannelNumber = "//*[contains(@class,'active')]/div[1]/div[1]/span";
		public static final String cuTVIcon = "programCUTV";
		//public static final String miniEPGCurrentChannelName = "//div[@class='focusBox']/ul/li[2]/div[3]/h2";
		public static final String miniEPGCurrentChannelName = "//ul[@id='focusedItemContainer']/li[2]/div[@class='media-content']/div[@class='title-animate']";
		public static final String miniEPGCurrentEpisodeDuration = "//div[@class='focusBox']/ul/li[2]/div[3]/p";
		public static final String miniEPGChannelNumber = "//div[@class='focusBox']/ul/li[2]/div[1]/div[1]/span";
		public static final String progressBar = "//div[@class='focusBox']/ul/li[2]/div[2]";
		public static final String cutvIconZapScreen = "//div[@class='focusBox']/ul/li[2]/div[3]/div/span[2]/img";
		public static final String cutvIconOnZapTile = "//div[@class='focusBox']/ul/li[2]/div[@class='channel_details']/div/span[@class='cutv-icon']";
		public static final String replaybleOrNoReplayableIcon = "//div[@class='focusBox']/ul/li[2]/div[@class='media-content']/div/span/img";
		public static final String textWithDurationInEPG = "//div[@class='focusBox']/ul/li[2]/div[3]/span[@class='future_past']";
		public static final String recordingIconMiniEpg = "//div[@class='focusBox']/ul/li[2]/div[3]/div/span[@class='recording-icon ongoing']";
		public static final String cutvIconMiniEpg = "//div[@class='focusBox']/ul/li[2]/div[3]/div/span[contains(@class,'recording-icon')]/../span[2]/img";
		public static final String hdratingIcon = "//div[@class='focusBox']/ul/li[2]/div[3]/div/span[1]/../span[@class = 'hd-rating']";
		public static final String highligheVideotitle = "//li[@class='active']/span";
		public static final String videoPlayer = "//ul[@id='focusedItemContainer']/li[2]/div[@class='videoPlayer']";
		public static final String highlightVideoLeftTitle = "//li[@class='active']/span/../../li[1]/span";
		public static final String highlightVideoRightTitle = "//li[@class='active']/span/../../li[3]/span";
		public static final String activeTileProgramTime = "//ul[@id='focusedItemContainer']/li[2]/div[@class='media-content']/p";
		public static final String activeTileHeading = "//ul[@id='focusedItemContainer']/li[2]/div[@class='media-content']/div[@class='title-animate']";
		public static final String lastTileInMiniEPG = "//ul[@id='focusedItemContainer']/li[2]/div[@class='media-content']/h2";
		public static final String onGoingRecordingIcon = "//ul[@id='focusedItemContainer']/li[2]/div[@class='media-content']/div/span[@class='recording-icon ongoing']";
		public static final String previousProgramTitle = "//*[@id='VH_0']/span";
		public static final String centerTitle = "//*[@id='VH_1']/span";
		public static final String nextProgramTitle = "//*[@id='VH_2']/span";
		public static final String programDetailsScreen = "dtvName";
		public static final String actionItemList = "cItem";
		public static final String recordingIconOnInfo = "programRecording";
		public static final String programTitle = "//ul[@id='focusedItemContainer']/li[2]/div[@class='media-content']/h2";
		public static final String futureRecordingIcon = "//ul[@id='focusedItemContainer']/li[2]/div[@class='media-content']/div/span[@class='recording-icon ongoingfuture']";
		public static final String logo = "//ul[@id='focusedItemContainer']/li[2]/div[@class='channel_details']/div[@class='logo']/img";
		public static final String programTiming = "//ul[@id='focusedItemContainer']/li[2]/div[@class='media-content']/p";
	}

	public static class Vod {
		public static final String vodHeading = "vod-heading-main";
		public static final String filmTitle = "poster-right-heading";
		public static final String itemPrice = "//*[@id='price-text']";
		public static final String rowId = "row_1";
		public static final String menuText = "//*[@id='main-hub-nav']";
		public static final String actie = "//*[@id='item_3']";
		public static final String mubiPass = "//*[@id='item_4']";
		public static final String rows = "row-active";
		public static final String pinContainer = "//*[@id='addPin']/div";
		public static final String count = "selectedVodPg";
		public static final String container = "focusedItemContainer";
		public static final String forwardkey = "//*[@id='rewind']";
		public static final String movieName = "//div[contains(@id,'item_')]/div[@class='poster-info']/h2";
		public static final String dateTime = "//*[@id='item_0_0']/div[2]/div";
		public static final String duration = "//*[@id='item_0_0']/div[2]/span";
		public static final String totalItems = "//*[@id='totalItems']";
		public static final String lookOption = "//*[@id='item_watch']";
		public static final String highlightFilm = "//div[@id='rowContainer']/ul[1]/li[@class='active']/span[@id='store-left-title']";
		public static final String leftPannelPosition = "//div[@id='dStoreRightSection']/../div[1]";
		public static final String activeSortOption = "//div[@class='cSortOption cActiveSortOption']/span[1]";
		public static final String topMovieHeading = "flavour-title";
		public static final String filmsCategoryPoster = "//ul[@id='focusedItemContainer']/li[2]/img";
		public static final String leafPoster = "//*[@id='dItemImageHalf_00']";
		public static final String continueWatchVideo = "//*[@id='rightContainer']/div[@class='rentSuccess']/div";
		public static final String wrongPinEnterMessage="//div[@id='addPin']/p";
	}

	public static class HotKeys {
		public static final String currentChannel = "channel-no";
		public static final String channelLogo = "channel-logo";
		public static final String headerTitle = "//*[@id='headerTitle']";
		public static final String headerTime = "headerDateTime";
	}

	public static class RcArrowKey {
		public static final String heading = "epgHeading";
		public static final String type = "leftLabel";
		public static final String epgInfo = "epgType";
		public static final String background = "epgBackground";
		
		public static final String notificationMsg = "confimation-popup";
		public static final String firstChannelNumberInEPG = "//*[@id='colCh0']/span/span";

	}

	public static class TvfilterLayer {
		public static final String televiosntitle = "menuItem_1";
		public static final String tvId = "//*[@id='VH_0']/span";
		public static final String now = "//*[@id='item_0_1']/span";
		public static final String nowOnTv = "//*[@id='VH_1']/span";
		public static final String footballTv = "//*[@id='VH_2']/span";
		public static final String footballCalendar = "//*[@id='VH_3']/span";
		public static final String radioStations = "//*[@id='VH_4']/span";
		public static final String search = "//*[@id='VH_5']/span";
	}

	public static class ActiveInfoBanner {
		public static final String channelInfo = "current_channel";
		public static final String imgId = "icon-active-preview";
		public static final String programID = "programTitle";
		public static final String duration = "programTime";

	}

	public static class StoreFilterLayer {
		public static final String dramaScreenDetails = "//div[contains(@id,'vodDetail')]";
		public static final String shopScreen = "//li[@id='VH_0']/span";
		public static final String screenID = "suggesties";
		public static final String dramaScreen = "cTitleField";
	}

	public static class SettingScreen {
		public static final String activeOption = "//div[@class='cItem cActiveItem']";
	}

}
