package com.googlecode.coss.common.test;

import java.net.URL;

import javax.xml.parsers.FactoryConfigurationError;

import org.apache.log4j.xml.DOMConfigurator;

/**
 */
public class LogSupport {

    /**
     * @throws FactoryConfigurationError
     */
    private static void init() throws FactoryConfigurationError {
        URL url = LogSupport.class.getClassLoader().getResource("log4j_test.xml");
        if (url != null) {
            DOMConfigurator.configure(url);
        } else {
            System.err.println("not found log4j.xml in classpath");
        }
    }

    public static void initLog4j() {
        init();
    }
}
