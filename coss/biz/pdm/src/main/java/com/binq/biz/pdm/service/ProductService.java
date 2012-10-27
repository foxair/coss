package com.binq.biz.pdm.service;

import java.io.Serializable;
import java.util.List;

import com.binq.biz.pdm.po.Product;
import com.googlecode.coss.common.core.orm.mybatis.Page;

public interface ProductService {

    public int save(Product product);

    public int update(Product product);

    public int saveOrUpdate(Product product);

    public int deleteById(Serializable id);

    public int deleteByIds(List<Serializable> ids);

    public Product getById(Serializable id);

    public List<Product> findByIds(List<Serializable> ids);

    public List<Product> find(Product product);

    public Page<Product> queryPage(Integer pageIndex, Integer sizePerPage, Product product);

}
