package com.rsystems.exceptionHandling;

public enum ExceptionMesages {

	NoSuchElementException										("Web Element is not found on page"),
	StaleElementReferenceException								("Stale Element Exception throws by Test NG"),
	NullPointerException										("Null Pointer Exception throws by Test BG"),
	NoSuchWindowException										("No such window: target window already closed");


	private final String exceptionMsg;

	private ExceptionMesages(String s) {
		exceptionMsg = s;
	}

}
