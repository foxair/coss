package com.enniu.app.index.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.enniu.app.index.po.Product;
import com.mongodb.Mongo;

public class MongoAppTest {

    private static final Logger logger = LoggerFactory.getLogger(MongoAppTest.class);

    public static void main(String[] args) throws Exception {

        MongoOperations mongoOps = new MongoTemplate(new SimpleMongoDbFactory(new Mongo(), "test"));

        mongoOps.insert(new Product(1002L, "Product2", "Product2", 100.0F));
        Product p = mongoOps.findOne(new Query(new Criteria().where("id").is(1000L)),
                Product.class);

        System.out.println(">>>>" + p.getProductCode());

        mongoOps.dropCollection("person");
    }
}
