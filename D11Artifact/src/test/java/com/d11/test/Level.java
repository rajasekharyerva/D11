package com.d11.test;

public enum Level {
    HIGH("H"),
    MEDIUM("M"),
    LOW("L");
	
	// declaring private variable for getting values
    private String action;
 
    // getter method
    public String getLocatorValue()
    {
        return this.action;
    }
	
	// enum constructor - cannot be public or protected
    private Level(String action)
    {
        this.action = action;
    }
}



