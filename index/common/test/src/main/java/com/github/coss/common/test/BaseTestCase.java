package com.github.coss.common.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 单测基类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/META-INF/spring/applicationContext-test.xml" })
public abstract class BaseTestCase extends AbstractJUnit4SpringContextTests {
    public BaseTestCase() {
        // 初始化log4j
        LogSupport.initLog4j();
    }
}
