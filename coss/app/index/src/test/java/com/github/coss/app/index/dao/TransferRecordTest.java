package com.github.coss.app.index.dao;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import com.github.coss.app.index.po.TransferRecord;
import com.github.coss.common.core.orm.mybatis.Page;
import com.github.coss.common.test.BaseTestCase;

@ContextConfiguration({ "/META-INF/spring/app-index-test.xml" })
public class TransferRecordTest extends BaseTestCase {

    @Resource
    private TransferRecordDao transferRecordDao;

    @Test
    public void testSave() {
        TransferRecord transferRecord = new TransferRecord();
        transferRecord.setTableNamePrefix("T_Bill_ShoppingSheet");
        transferRecord.setTableNameNum(-1);
        transferRecord.setStepEndId(123123L);
        transferRecord.setStepTime(new Date());
        transferRecordDao.save(transferRecord);
    }

    @Test
    public void testPage() {
        Page<TransferRecord> page = transferRecordDao.queryPage(1, 2, null);
        List<TransferRecord> transferRecordList = page.getResult();
        System.out.println(transferRecordList.size());
        System.out.println(transferRecordList.size());
        //assertEquals
        Assert.assertTrue(transferRecordList.size() > 0);
    }
}
