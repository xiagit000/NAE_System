package com.boventech.gplearn.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class LoadProperties {

	private static Properties PROPERTIES;
	
	private static final String DEFAULT_STUDYSPACE_PROPERTIES="restful.properties";
	
	
	public static String getProperty(String key){
		
		return getProperties().getProperty(key);
	}
	
	
	private static synchronized Properties getProperties() {
        if (null == PROPERTIES) {
            loadProperties();
        }
        return PROPERTIES;
    }
	
	private static void loadProperties() {
		PROPERTIES = new Properties();
        InputStream is = LoadProperties.class.getClassLoader().getResourceAsStream(DEFAULT_STUDYSPACE_PROPERTIES);
        try {
        	PROPERTIES.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
