package com.kitchen.util;

import java.io.IOException;
import java.util.Properties;

/**
 * Util class to read properties
 */
public class PropertyMgr {

    static Properties props = new Properties();

    /**
     * Init
     *
     */
    static {
        try {
            props.load(PropertyMgr.class.getClassLoader()
                                        .getResourceAsStream("application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Return the value in file
     *
     * @param key
     * @return
     */
    public static String get(String key) {
        if (props == null) {
            return null;
        }
        return props.getProperty(key);
    }
}
