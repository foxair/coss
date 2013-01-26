package com.github.coss.app.index.task.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import com.github.coss.app.index.constant.IndexConstant;
import com.github.coss.app.index.dao.TransferRecordDao;
import com.github.coss.app.index.po.BillShoppingSheet;
import com.github.coss.app.index.po.TransferRecord;
import com.github.coss.app.index.service.BillShoppingSheetService;
import com.github.coss.app.index.service.ImportShoppingSheetService;
import com.github.coss.app.index.utils.IndexUtils;
import com.github.coss.common.core.orm.mybatis.Page;
import com.github.coss.common.utils.thread.ConcurrencyUtils;

/**
 * ShoppingSheet表数据导入 异步线程调度
 * @author azheng
 */
@Service("importShoppingSheetSchedule")
public class ImportShoppingSheetSchedule {

    private static final Logger        logger                     = LoggerFactory
                                                                          .getLogger(ImportShoppingSheetSchedule.class);
    @Resource
    private BillShoppingSheetService   billShoppingSheetService;
    @Resource
    private ImportShoppingSheetService importShoppingSheetService;
    @Resource
    private TransferRecordDao          transferRecordDao;
    @Resource(name = "threadPoolTaskExecutor")
    private ThreadPoolTaskExecutor     executor;

    private Integer                    sizePerPage;

    //每线程处理条数
    private final static int           DEFAULT_SIZE_PER_PAGE_SIZE = 10000;
    //分表数
    private final static int           DEFAULT_MAX_TABLE_NUM      = 100;

    /**
     * 异步执行调度
     * @param pageSize 单线程每次导入数量
     * @param maxTableNum 
     */
    public void execute(Integer pageSize, Integer maxTableNum) {
        //每次导入数据量:默认取Task执行时传入的参数,未取到则取任务调度的配置的量
        if (pageSize == null || pageSize != 0) {
            if (sizePerPage != null && sizePerPage != 0) {
                pageSize = this.sizePerPage;
            } else {
                pageSize = DEFAULT_SIZE_PER_PAGE_SIZE;
            }
        }
        if (maxTableNum == null) {
            maxTableNum = DEFAULT_MAX_TABLE_NUM;
        }
        int tnum = -1;//表编号 -1:表示没有标号后缀
        for (; tnum < maxTableNum; tnum++) {
            String tableName = IndexUtils.getTableNameByTableNum(
                    IndexConstant.TABLE_NAME_Bill_ShoppingSheet, tnum);
            if (logger.isDebugEnabled()) {
                logger.debug("Execute: " + tableName + " import");
            }
            TransferRecord trQuery = new TransferRecord(
                    IndexConstant.TABLE_NAME_Bill_ShoppingSheet, tnum);
            TransferRecord transferRecord = transferRecordDao.getUnique(trQuery);
            if (transferRecord == null) {
                transferRecord = new TransferRecord(IndexConstant.TABLE_NAME_Bill_ShoppingSheet,
                        tnum);
            }
            long recordCount = billShoppingSheetService.getCountByTableNameGtId(tableName,
                    transferRecord.getStepEndId(), null);
            if (recordCount > 0) {
                int pageCount = calculatePageSize(recordCount, pageSize);
                List<Future<String>> futures = new ArrayList<Future<String>>(pageCount);
                for (int p = 1; p <= pageCount; p++) {
                    Page<BillShoppingSheet> page = billShoppingSheetService
                            .queryPageByTableNameGtId(tableName, p, pageSize,
                                    transferRecord.getStepEndId(), null);
                    List<BillShoppingSheet> shoppingSheetList = page.getResult();
                    if (shoppingSheetList != null) {
                        Runnable runable = new ImportShoppingSheetWorker(
                                importShoppingSheetService, shoppingSheetList, tnum);
                        if (runable != null) {
                            BillShoppingSheet bssBegin = shoppingSheetList.get(0);
                            BillShoppingSheet bssEnd = shoppingSheetList.get(shoppingSheetList
                                    .size() - 1);
                            if (logger.isInfoEnabled()) {
                                logger.info("==>> Handle Step " + p + " autoId:"
                                        + bssBegin.getAutoId() + " - " + bssEnd.getAutoId());
                            }
                            futures.add(executor.getThreadPoolExecutor().submit(runable, ""));
                        }
                    } else {
                        if (logger.isInfoEnabled()) {
                            logger.info("ShoppingSheetList is Null, page:" + p);
                        }
                        break;
                    }
                    ConcurrencyUtils.waitAllTaskFinished(futures, 1000L);
                }
            }
        }
    }

    private int calculatePageSize(long recordCount, int pageSize) {
        int pageCount = (int) recordCount / pageSize;
        if (recordCount % pageSize != 0) {
            pageCount++;
        }
        return pageCount;
    }

    public void setBillShoppingSheetService(BillShoppingSheetService billShoppingSheetService) {
        this.billShoppingSheetService = billShoppingSheetService;
    }

    public void setImportShoppingSheetService(ImportShoppingSheetService importShoppingSheetService) {
        this.importShoppingSheetService = importShoppingSheetService;
    }

    public void setTransferRecordDao(TransferRecordDao transferRecordDao) {
        this.transferRecordDao = transferRecordDao;
    }

    public void setExecutor(ThreadPoolTaskExecutor executor) {
        this.executor = executor;
    }

    public void setSizePerPage(Integer sizePerPage) {
        this.sizePerPage = sizePerPage;
    }

}
