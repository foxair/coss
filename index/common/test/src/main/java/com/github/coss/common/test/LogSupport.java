package com.github.coss.common.test;

import java.net.URL;

import javax.xml.parsers.FactoryConfigurationError;

import org.apache.log4j.xml.DOMConfigurator;

/**
 */
public class LogSupport {

    private static final String LOG4J_CONFIG_FILE = "log4j-test.xml";

    /**
     * @throws FactoryConfigurationError
     */
    private static void init() throws FactoryConfigurationError {
        URL url = LogSupport.class.getClassLoader().getResource(LOG4J_CONFIG_FILE);
        if (url != null) {
            DOMConfigurator.configure(url);
        } else {
            System.err.println("not found " + LOG4J_CONFIG_FILE + " in classpath");
        }
    }

    public static void initLog4j() {
        init();
    }
}
