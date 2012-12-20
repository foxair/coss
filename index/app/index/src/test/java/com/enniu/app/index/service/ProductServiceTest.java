package com.enniu.app.index.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import com.enniu.common.core.orm.mybatis.Page;
import com.enniu.common.test.BaseDBTestCase;
import com.enniu.app.index.po.Product;

@ContextConfiguration({ "/META-INF/spring/app-index-test.xml" })
public class ProductServiceTest extends BaseDBTestCase {
    @Resource
    private ProductService productService;

    @Test
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
        //assertEquals
        Assert.assertTrue(productList.size() > 0);
    }
}
