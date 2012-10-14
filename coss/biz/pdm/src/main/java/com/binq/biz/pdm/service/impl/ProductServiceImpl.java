package com.binq.biz.pdm.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.binq.biz.pdm.dao.ProductDao;
import com.binq.biz.pdm.po.Product;
import com.binq.biz.pdm.service.ProductService;
import com.googlecode.coss.common.core.orm.mybatis.Page;
import com.googlecode.coss.common.core.orm.mybatis.SqlMapDao;
import com.googlecode.coss.common.core.service.BaseService;

@Service("productService")
@Transactional
public class ProductServiceImpl extends BaseService<Product> implements ProductService {

    @Resource
    private ProductDao productDao;

    public void save(Product product) {
        productDao.save(product);
    }

    public void update(Product product) {
        productDao.update(product);
    }

    public void saveOrUpdate(Product product) {
        if (product.getId() == null)
            save(product);
        else
            update(product);
    }

    public void deleteById(Serializable id) {
        productDao.deleteById(id);
    }

    public void deleteByIds(List<Serializable> ids) {
        productDao.deleteByIds(ids);
    }

    public Product getById(Serializable id) {
        Product object = (Product) productDao.getById(id);
        return object;
    }

    public List<Product> findByIds(List<Serializable> ids) {
        List<Product> productList = productDao.findByIds(ids);
        return productList;
    }

    public List<Product> find(Product product) {
        List<Product> productList = productDao.find(product);
        return productList;
    }

    public Page<Product> queryPage(Integer pageIndex, Integer sizePerPage, Product product) {
        return productDao.queryPage(pageIndex, sizePerPage, product);
    }

    public void setProductDao(ProductDao dao) {
        this.productDao = dao;
    }

    @SuppressWarnings("unchecked")
    public SqlMapDao<Product> getSqlMapDao() {
        return (SqlMapDao<Product>) this.productDao;
    }
}
