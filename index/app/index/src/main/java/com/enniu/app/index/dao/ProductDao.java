package com.enniu.app.index.dao;

import java.io.Serializable;
import java.util.List;

import com.enniu.common.core.orm.mybatis.Page;
import com.enniu.app.index.po.Product;

public interface ProductDao {

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
