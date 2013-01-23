package com.github.coss.app.index.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.coss.common.core.context.SpringContextHolder;
import com.github.coss.common.utils.lang.StringUtils;

public abstract class AbstractStarter {

    private static final Logger logger = LoggerFactory.getLogger(AbstractStarter.class);

    protected Object getBean(String beanName) {
        if (StringUtils.isBlank(beanName)) {
            logger.error("beanName can't be null!");
            return null;
        }
        return SpringContextHolder.getBean(StringUtils.trim(beanName));
    }

    public void execute(String... params) {
        try {
            this.executeTask(params);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    public abstract void executeTask(String... params);

}
