package com.github.coss.app.index.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import com.github.coss.app.index.po.UserBill;
import com.github.coss.common.core.orm.mybatis.Page;
import com.github.coss.common.test.BaseDBTestCase;

@ContextConfiguration({ "/META-INF/spring/app-index-test.xml" })
public class UserBillServiceTest extends BaseDBTestCase {
    @Resource
    private UserBillService userBillService;

    //@Test
    public void testSave() {
        UserBill userBill = new UserBill();
        userBillService.save(userBill);
    }

    @Test
    public void testPage() {
        Page<UserBill> page = userBillService.queryPage(1, 20, null);
        List<UserBill> userBillList = page.getResult();
        System.out.println(userBillList.size());
        //assertEquals
        Assert.assertTrue(userBillList.size() > 0);
        for (UserBill userBill : userBillList) {
            System.out.println(userBill.getCardNo());
        }
    }

}
