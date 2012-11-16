package com.bing.biz.pdm.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import com.binq.biz.pdm.po.Product;
import com.binq.biz.pdm.service.ProductService;
import com.googlecode.coss.common.core.orm.mybatis.Page;
import com.googlecode.coss.common.test.BaseTestCase;

@ContextConfiguration({ "/META-INF/spring/biz-pdm-test.xml" })
public class ProductServiceTest extends BaseTestCase {
    @Resource
    private ProductService productService;

    @Test
    //@DbFit(when = "wiki/storage/allot.wiki")
    public void testSaveProduct() {
        Product product = new Product();
        product.setGmtCreate(new Date());
        product.setProductCode("A0005");
        product.setProductName("Test Product");
        product.setRetailPrice(100.3F);
        productService.save(product);
    }

    @Test
    public void testPage() {
        Page<Product> page = productService.queryPage(1, 2, null);
        List<Product> productList = page.getResult();
        System.out.println(productList.size());
        System.out.println(productList.size());
        Assert.assertTrue(productList.size() > 0);
    }
}
