package com.comcast.tourism.generic.javaUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
/**
 * @author rohit
 *This class Contains Various java utlity which can use in every test Script
 *made up by using java
 */
public class JavaUtility {
/**
 * This method return Random Number
 * 
 * @return
 */
	public int getRandomNumber() {
		Random randm = new Random();
		int random = randm.nextInt(100000);
		return random;
	}
	/**
	 * This method return System Date/Curent Date
	 * @author rohit
	 * @return
	 */
	public String getSystemDate() {
		Date date = new Date();
		SimpleDateFormat sim = new SimpleDateFormat();
		String Date = sim.format(date);
		return Date;
	}
	/**
	 * This method return Required Date ;
	 * @author rohit
	 * @return
	 */
	public String getRequiredDate() {
		Date date = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		String Date = sim.format(date);
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, 30);
		String Data = sim.format(cal.getTime());
		return Data;

	}
}
