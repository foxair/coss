package com.binq.biz.pdm.dao;

import java.io.Serializable;
import java.util.List;

import com.binq.biz.pdm.po.Product;
import com.googlecode.coss.common.core.orm.mybatis.Page;

public interface ProductDao {

    public void save(Product product);

    public void update(Product product);

    public void saveOrUpdate(Product product);

    public void deleteById(Serializable id);

    public void deleteByIds(List<Serializable> ids);

    public Product getById(Serializable id);

    public List<Product> findByIds(List<Serializable> ids);

    public List<Product> find(Product product);

    public Page<Product> queryPage(Integer pageIndex, Integer sizePerPage, Product product);

}
