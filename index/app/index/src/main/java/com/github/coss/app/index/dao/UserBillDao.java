package com.github.coss.app.index.dao;

import java.io.Serializable;
import java.util.List;

import com.github.coss.app.index.po.UserBill;
import com.github.coss.common.core.orm.mybatis.Page;

public interface UserBillDao {

    public int save(UserBill userBill);

    public int update(UserBill userBill);
    
    public int saveOrUpdate(UserBill userBill);
    
    public int deleteById(Serializable id);
    
    public int deleteByIds(List<Serializable> ids);

    public UserBill getById(Serializable id);
    
    public List<UserBill> findByIds(List<Serializable> ids);
    
    public List<UserBill> find(UserBill userBill);

    public Page<UserBill> queryPage(Integer pageIndex, Integer sizePerPage, UserBill userBill);
    
}
