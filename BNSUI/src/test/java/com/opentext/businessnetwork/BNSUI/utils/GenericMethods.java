package com.opentext.businessnetwork.BNSUI.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class GenericMethods {
	
	/**This function will add Year,Month and date as Map elements. Both todays date and yesterdays date are considered for mapping
	 * 
	 * @param dataTracking - Mapping element
	 * @return - returns mapped elements
	 */
	public static Map<String, String> getPreviousAndCurrentDate(Map<String,String> dataTracking){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		//Format the current date
		String currentdate= dateFormat.format(date);		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		//Format yesterday's date
		String previousDate= dateFormat.format(cal.getTime());
		dataTracking.put("syear", previousDate.split("-")[0]);
		dataTracking.put("smonth", previousDate.split("-")[1]);
		dataTracking.put("sday", previousDate.split("-")[2]);
		dataTracking.put("eyear", currentdate.split("-")[0]);
		dataTracking.put("emonth", currentdate.split("-")[1]);
		dataTracking.put("eday", currentdate.split("-")[2]);
		return dataTracking;		
	}
}
