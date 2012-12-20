package com.enniu.app.index.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.enniu.common.core.orm.mybatis.BaseSqlMapDao;
import com.enniu.common.core.orm.mybatis.Page;
import com.enniu.common.core.orm.mybatis.QueryRequest;
import com.enniu.app.index.dao.ProductDao;
import com.enniu.app.index.po.Product;

@Repository("productDao")
public class ProductDaoImpl extends BaseSqlMapDao<Product> implements ProductDao {

    public int save(Product product) {
        return getSqlSessionTemplate().insert("product.insert", product);
    }

    public int update(Product product) {
        return getSqlSessionTemplate().update("product.update", product);
    }

    public int saveOrUpdate(Product product) {
        if (product.getId() == null)
            return save(product);
        else
            return update(product);
    }

    public int deleteById(Serializable id) {
        return getSqlSessionTemplate().delete("product.deleteById", id);
    }

    public int deleteByIds(List<Serializable> ids) {
        if (ids == null || ids.isEmpty()) {
            return 0;
        }
        return getSqlSessionTemplate().delete("product.deleteByIds", ids);
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
