package com.github.coss.app.index.task.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.coss.app.index.po.BillShoppingSheet;
import com.github.coss.app.index.service.ImportShoppingSheetService;
import com.github.coss.common.utils.lang.DateTime.DateUtils;

/**
 * ShoppingSheet表数据导入mongodb的任务处理执行对象
 * 多个线程执行
 * @author azheng
 */
public class ImportShoppingSheetWorker implements Runnable {
    private static final Logger        logger = LoggerFactory
                                                      .getLogger(ImportShoppingSheetWorker.class);

    private ImportShoppingSheetService importShoppingSheetService;
    private List<BillShoppingSheet>    shoppingSheetList;
    private int                        tnum;

    public ImportShoppingSheetWorker(ImportShoppingSheetService importShoppingSheetService,
                                     List<BillShoppingSheet> shoppingSheetList, int tnum) {
        super();
        this.importShoppingSheetService = importShoppingSheetService;
        this.shoppingSheetList = shoppingSheetList;
        this.tnum = tnum;
    }

    @Override
    public void run() {
        if (logger.isDebugEnabled()) {
            logger.debug("[ImportShoppingSheetWorker] Sub Thread Start....... startTime:"
                    + DateUtils.getNowTime() + " - " + System.currentTimeMillis());
        }
        importShoppingSheetService.importShoppingSheet(shoppingSheetList, tnum);
        if (logger.isDebugEnabled()) {
            logger.debug("[ImportShoppingSheetWorker] Sub Thread End....... endTime:"
                    + DateUtils.getNowTime() + " - " + System.currentTimeMillis());
        }
    }
}
