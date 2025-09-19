package com.comcast.tourism.generic.fileUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
/**
*  This is the generic utiltiy class for  fetching  the Commom Data From the 
*  property files
* @author rohit
*/
public class PropertyFileUtility {
/**
 * To get Data from The propoerty Files
 * @param key
 * @return
 * @throws IOException
 */
	public  String getDataFromPropertyFiles(String key) throws IOException {
		FileInputStream file=new FileInputStream("D:\\Work_Space\\ComcastTourismFramework\\ComcastTourismFramework\\src\\main\\resources\\ConfigData\\commonData.properties");
		Properties pro=new Properties();
		pro.load(file);
	String value=pro.getProperty(key);
	return value;
		
		
	}
	/**
	 * To write Data to the Property Files
	 * @throws IOException 
	 */
	public void setDataToThePropertyFiles(String key,String value) throws IOException {
		FileInputStream File=new FileInputStream("D:\\Work_Space\\ComcastTourismFramework\\ComcastTourismFramework\\src\\main\\resources\\ConfigData\\commonData.properties");
		Properties pro=new Properties();
	    pro.setProperty(key,value);
	
	FileOutputStream fos=new FileOutputStream("D:\\\\Work_Space\\\\ComcastTourismFramework\\\\ComcastTourismFramework\\\\src\\\\main\\\\resources\\\\ConfigData\\\\commonData.properties");
       pro.store(fos, value);
       fos.close();
       
	}
}
