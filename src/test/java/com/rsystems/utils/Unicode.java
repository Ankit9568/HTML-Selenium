package com.rsystems.utils;

public enum Unicode {

	
	TV_GUIDE										  ( "\u0074");


	private final String unicode;

	private Unicode(String unicode) {
		this.unicode = unicode;
	}

	 @Override
	    public String toString() {
	        return unicode;
	    }
}
