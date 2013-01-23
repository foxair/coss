package com.github.coss.app.index.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.coss.app.index.task.impl.ImportShoppingSheetSchedule;
import com.github.coss.common.utils.lang.StringUtils;

/**
 * ImportShoppingSheetTask 导入任务执行入口
 * @author azheng
 */
public class ImportShoppingSheetTask extends AbstractStarter {

    private static final String SCHEDULE_BEAN_ID = "importShoppingSheetSchedule";
    private static final Logger logger           = LoggerFactory
                                                         .getLogger(ImportShoppingSheetTask.class);

    @Override
    public void executeTask(String... params) {
        if (logger.isInfoEnabled()) {
            logger.info("ImportShoppingSheetTask executeTask start");
        }
        ImportShoppingSheetSchedule importShoppingSheetSchedule = (ImportShoppingSheetSchedule) this
                .getBean(SCHEDULE_BEAN_ID);
        Integer pageSize = null;
        if (params != null && params.length > 0) {
            pageSize = getPageSize(params[0]);
        }
        Integer maxTableNum = null;
        if (params != null && params.length > 0) {
            maxTableNum = Integer.valueOf(params[1]);
        }
        importShoppingSheetSchedule.execute(pageSize, maxTableNum);
        if (logger.isInfoEnabled()) {
            logger.info("ImportShoppingSheetTask executeTask end");
        }
    }

    private int getPageSize(String numberStr) {
        int sizePage = 0;
        if (numberStr != null && StringUtils.isPositiveInteger(numberStr)) {
            sizePage = Integer.parseInt(numberStr);
        }
        return sizePage;
    }
}
