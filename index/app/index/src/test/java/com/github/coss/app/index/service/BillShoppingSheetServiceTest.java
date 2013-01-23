package com.github.coss.app.index.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import com.github.coss.app.index.po.BillShoppingSheet;
import com.github.coss.common.core.orm.mybatis.Page;
import com.github.coss.common.test.BaseDBTestCase;

@ContextConfiguration({ "/META-INF/spring/app-index-test.xml" })
public class BillShoppingSheetServiceTest extends BaseDBTestCase {
    @Resource
    private BillShoppingSheetService billShoppingSheetService;

    @Test
    public void testGtId() {
        Page<BillShoppingSheet> page = billShoppingSheetService.queryPageByTableNameGtId(
                "T_Bill_ShoppingSheet", 1, 20, 111140L, null);
        List<BillShoppingSheet> billShoppingSheetsList = page.getResult();
        System.out.println(billShoppingSheetsList.size());
        //assertEquals
        Assert.assertTrue(billShoppingSheetsList.size() > 0);
        for (BillShoppingSheet billShoppingSheet : billShoppingSheetsList) {
            System.out.println(billShoppingSheet.getCardNo());
        }
    }
}
