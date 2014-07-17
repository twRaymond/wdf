package com.wdf.common.config;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class ConfigLoader {
	private static Properties prop = null;
	private static String defaultName = "/initContext.properties";
	
	public void load(){
		load("");
	}

	public void load(String configName){
		prop = new Properties();
		try {
			String tmpFileName = "".equalsIgnoreCase(configName)?defaultName:configName;
			System.out.println("load file ... > " + tmpFileName );
			InputStream resourcePath = getClass().getResourceAsStream(tmpFileName);
			prop.load(resourcePath);
		} catch(Exception e){
			System.out.println(e.toString());
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
	
	public static void main(String args[]) {
		System.out.println(ConfigLoader.class.getResource("/"));
	}
}
