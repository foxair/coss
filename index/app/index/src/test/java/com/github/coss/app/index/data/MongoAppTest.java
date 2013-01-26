package com.github.coss.app.index.data;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.github.coss.app.index.po.BillShoppingSheet;
import com.mongodb.Mongo;

/**
 * MongoTemplate save  find test
 */
public class MongoAppTest {

    public static void main(String[] args) throws Exception {
        MongoOperations mongoOps = new MongoTemplate(new SimpleMongoDbFactory(new Mongo(), "test"));
        BillShoppingSheet p = mongoOps.findOne(new Query(Criteria.where("AutoId").is(10011L)),
                BillShoppingSheet.class);
        System.out.println(">>>>" + p.getDiscription());
        mongoOps.dropCollection("person");
    }
}
