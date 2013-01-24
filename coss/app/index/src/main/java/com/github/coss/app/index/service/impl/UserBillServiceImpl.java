package com.github.coss.app.index.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.coss.app.index.dao.UserBillDao;
import com.github.coss.app.index.po.UserBill;
import com.github.coss.app.index.service.UserBillService;
import com.github.coss.common.core.orm.mybatis.Page;
import com.github.coss.common.core.orm.mybatis.SqlMapDao;
import com.github.coss.common.core.service.BaseService;

@Service("userBillService")
@Transactional
public class UserBillServiceImpl extends BaseService<UserBill> implements UserBillService {

    @Resource
    private UserBillDao userBillDao;

    public int save(UserBill userBill) {
        return userBillDao.save(userBill);
    }

    public int update(UserBill userBill) {
        return userBillDao.update(userBill);
    }

    public int saveOrUpdate(UserBill userBill) {
        if (userBill.getBillId() == null)
            return save(userBill);
        else
            return update(userBill);
    }

    public int deleteById(Serializable id) {
        return userBillDao.deleteById(id);
    }

    public int deleteByIds(List<Serializable> ids) {
        return userBillDao.deleteByIds(ids);
    }

    public UserBill getById(Serializable id) {
        UserBill object = (UserBill) userBillDao.getById(id);
        return object;
    }

    public List<UserBill> findByIds(List<Serializable> ids) {
        List<UserBill> userBillList = userBillDao.findByIds(ids);
        return userBillList;
    }

    public List<UserBill> find(UserBill userBill) {
        List<UserBill> userBillList = userBillDao.find(userBill);
        return userBillList;
    }

    public Page<UserBill> queryPage(Integer pageIndex, Integer sizePerPage, UserBill userBill) {
        return userBillDao.queryPage(pageIndex, sizePerPage, userBill);
    }

    public void setUserBillDao(UserBillDao dao) {
        this.userBillDao = dao;
    }

    @SuppressWarnings("unchecked")
    public SqlMapDao<UserBill> getSqlMapDao() {
        return (SqlMapDao<UserBill>) this.userBillDao;
    }
}
