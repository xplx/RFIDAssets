package com.daoben.rfid.utils;

import java.io.IOException;
import java.util.Properties;


public class ReadProperties extends Properties {
	 private static ReadProperties instance;
	    /**
	 * @param path
	 */
		public static ReadProperties getInstance(String path) throws IOException{
	        if (instance != null){
	            return instance;
	        }else {
	            makeInstance(path);
	            return instance;
	        }
	    }

	    private static synchronized void makeInstance(String path) throws IOException{
	        if (instance == null){
	            instance = new ReadProperties(path);
	        }
	    }

	    private  ReadProperties (String path) throws IOException{
	            load(ReadProperties.class.getClassLoader().getResourceAsStream(path));
	    }
	
}