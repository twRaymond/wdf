package com.wdf.common.config;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
	private static Properties prop = null;
	private static String defaultName = "initConfig.properties";
	
	public void load(){
		load(null);
	}

	public void load(String configName){
		prop = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream("".equalsIgnoreCase(configName)?defaultName:configName);
			prop.load(input);
		} catch(Exception e){
			
		}
	}
	
	public static Properties getProp() {
		return prop;
	}

	public static void setProp(Properties prop) {
		ConfigLoader.prop = prop;
	}
	
	public String getKey(String key){
		return prop.getProperty(key);
	}

	public static String getKey(Properties resource, String key){
		return resource.getProperty(key);
	}
}
