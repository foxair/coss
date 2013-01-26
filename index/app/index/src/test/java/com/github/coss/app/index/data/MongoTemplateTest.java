package com.github.coss.app.index.data;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;

import com.github.coss.app.index.po.BillShoppingSheet;
import com.github.coss.app.index.vo.BillShoppingSheetVo;
import com.github.coss.common.test.BaseTestCase;

@ContextConfiguration({ "/META-INF/spring/mongo.xml" })
public class MongoTemplateTest extends BaseTestCase {

    @Resource
    private MongoOperations mongoTemplate;

    @Test
    public void testSaveBillShoppingSheetVo() {
        List<BillShoppingSheetVo> blist = new ArrayList<BillShoppingSheetVo>();
        for (long i = 1000L; i < 2000L; i++) {
            BillShoppingSheetVo bssv = new BillShoppingSheetVo();
            bssv.setId(i);
            blist.add(bssv);
        }
        mongoTemplate.insertAll(blist);
    }

    //@Test
    public void testRemove() {
        mongoTemplate.dropCollection("billShoppingSheetVo");
    }

    //@Test
    public void testCount() {
        Query query = new Query();
        query.addCriteria(Criteria.where("AutoId").gte(1003L));
        long count = mongoTemplate.count(query, BillShoppingSheet.class);
        System.out.println(count);
    }

}
