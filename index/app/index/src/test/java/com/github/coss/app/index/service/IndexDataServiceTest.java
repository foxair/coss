package com.github.coss.app.index.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import com.github.coss.app.index.vo.IndexData;
import com.github.coss.common.test.BaseDBTestCase;
import com.github.coss.common.utils.lang.DateTime.DateUtils;

@ContextConfiguration({ "/META-INF/spring/app-index-test.xml" })
public class IndexDataServiceTest extends BaseDBTestCase {
    @Resource
    private IndexDataService indexDataService;

    @Test
    public void testBankId() {
        Date startTime = DateUtils.parse("2012-03-01 00:00:00", "yyyy-MM-dd HH:mm:ss");
        Date endTime = DateUtils.parse("2012-03-15 00:00:00", "yyyy-MM-dd HH:mm:ss");
        List<IndexData> bssList = indexDataService.findByBankIdAndDate(0L, startTime, endTime);
        System.out.println(bssList);
    }

}
