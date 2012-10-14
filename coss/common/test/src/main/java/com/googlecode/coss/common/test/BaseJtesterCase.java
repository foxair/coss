package com.googlecode.coss.common.test;

import org.jtester.testng.JTester;

/**
 * jtester单测基类
 */
//@SpringApplicationContext({ "test/biz-dao.xml", "test/datasource.xml",
//        "test/lpmonitor-config-service.xml" })
public class BaseJtesterCase extends JTester {

    public BaseJtesterCase() {
        // 初始化log4j
        LogSupport.initLog4j();
    }

}
