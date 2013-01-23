package com.github.coss.app.index.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.github.coss.app.index.dao.UserBillDao;
import com.github.coss.app.index.po.UserBill;
import com.github.coss.common.core.orm.mybatis.BaseSqlMapDao;
import com.github.coss.common.core.orm.mybatis.Page;
import com.github.coss.common.core.orm.mybatis.QueryRequest;

@SuppressWarnings("unchecked")
@Repository("userBillDao")
public class UserBillDaoImpl extends BaseSqlMapDao<UserBill> implements UserBillDao {

    public int save(UserBill userBill) {
        return getSqlSessionTemplate().insert("userBill.insert", userBill);
    }

    public int update(UserBill userBill) {
        return getSqlSessionTemplate().update("userBill.update", userBill);
    }

    public int saveOrUpdate(UserBill userBill) {
        if (userBill.getBillId() == null)
            return save(userBill);
        else
            return update(userBill);
    }

    public int deleteById(Serializable id) {
        return getSqlSessionTemplate().delete("userBill.deleteById", id);
    }

    public int deleteByIds(List<Serializable> ids) {
        if (ids == null || ids.isEmpty()) {
            return 0;
        }
        return getSqlSessionTemplate().delete("userBill.deleteByIds", ids);
    }

    public UserBill getById(Serializable id) {
        UserBill object = (UserBill) getSqlSessionTemplate().selectOne("userBill.getById", id);
        return object;
    }

    public List<UserBill> findByIds(List<Serializable> ids) {
        List<UserBill> userBillList = getSqlSessionTemplate().selectList("userBill.findByIds", ids);
        return userBillList;
    }

    public List<UserBill> find(UserBill userBill) {
        List<UserBill> userBillList = getSqlSessionTemplate().selectList("userBill.find", userBill);
        return userBillList;
    }

    public Page<UserBill> queryPage(Integer pageIndex, Integer sizePerPage, UserBill userBill) {
        QueryRequest<UserBill> queryRequest = new QueryRequest<UserBill>(pageIndex, sizePerPage,
                userBill);
        return this.findPage(queryRequest);
    }

    public String getSqlMapNamesapce() {
        return "userBill";
    }

}
