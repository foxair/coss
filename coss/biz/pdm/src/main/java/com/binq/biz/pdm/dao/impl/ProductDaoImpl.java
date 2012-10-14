package com.binq.biz.pdm.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.binq.biz.pdm.dao.ProductDao;
import com.binq.biz.pdm.po.Product;
import com.googlecode.coss.common.core.orm.mybatis.BaseSqlMapDao;
import com.googlecode.coss.common.core.orm.mybatis.Page;
import com.googlecode.coss.common.core.orm.mybatis.QueryRequest;

@Repository("productDao")
public class ProductDaoImpl extends BaseSqlMapDao<Product> implements ProductDao {

    public void save(Product product) {
        getSqlSessionTemplate().insert("product.insert", product);
    }

    public void update(Product product) {
        getSqlSessionTemplate().update("product.update", product);
    }

    public void saveOrUpdate(Product product) {
        if (product.getId() == null)
            save(product);
        else
            update(product);
    }

    public void deleteById(Serializable id) {
        getSqlSessionTemplate().delete("product.deleteById", id);
    }

    public void deleteByIds(List<Serializable> ids) {
        getSqlSessionTemplate().delete("product.deleteByIds", ids);
    }

    public Product getById(Serializable id) {
        Product object = (Product) getSqlSessionTemplate().selectOne("product.getById", id);
        return object;
    }

    public List<Product> findByIds(List<Serializable> ids) {
        List<Product> productList = getSqlSessionTemplate().selectList("product.findByIds", ids);
        return productList;
    }

    public List<Product> find(Product product) {
        List<Product> productList = getSqlSessionTemplate().selectList("product.find", product);
        return productList;
    }

    public Page<Product> queryPage(Integer pageIndex, Integer sizePerPage, Product product) {
        QueryRequest<Product> queryRequest = new QueryRequest<Product>(pageIndex, sizePerPage,
                product);
        return this.findPage(queryRequest);
    }

    public String getSqlMapNamesapce() {
        return "product";
    }

}
