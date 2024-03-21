package com.utility;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class Utility {
	
	public static String readProperty(String strProperty) {
		String propValue="";
		try {
			File file = new File("./config.properties");
			FileReader fr = new FileReader(file);
			Properties prop = new Properties();
			prop.load(fr);
			propValue = prop.getProperty(strProperty);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return propValue;
	}
	
}
