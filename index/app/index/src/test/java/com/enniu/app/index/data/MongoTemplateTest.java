package com.enniu.app.index.data;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;

import com.enniu.app.index.po.Product;
import com.enniu.common.test.BaseTestCase;

@ContextConfiguration({ "/META-INF/spring/app-index-test.xml" })
public class MongoTemplateTest extends BaseTestCase {

    @Resource
    private MongoOperations mongoTemplate;

    //@Test
    public void testSaveProduct() {
        for (int i = 0; i < 10; i++) {
            mongoTemplate.insert(new Product(1000L + i, "p" + i, "product" + i, Float.valueOf(i)));
        }
    }

    //@Test
    public void testFindProduct() {
        Product p = mongoTemplate.findOne(new Query(Criteria.where("id").is(1005L)), Product.class);
        if (p != null) {
            System.out.println(">>>>" + p.getProductCode());
        }
    }

    //@Test
    public void testRemoveProduct() {
        mongoTemplate.dropCollection("product");
    }

    @Test
    public void testCountProduct() {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").gte(1003L));
        long count = mongoTemplate.count(query, Product.class);
        System.out.println(count);
    }

}
