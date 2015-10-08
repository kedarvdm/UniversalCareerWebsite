package com.me.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UDate extends Date{

	Date date;
	SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy");
    
	public UDate()
	{
		date= new Date();
	}
	
	@Override
	public String toString()
	{
		return DATE_FORMAT.format(this.date);
	}

}
