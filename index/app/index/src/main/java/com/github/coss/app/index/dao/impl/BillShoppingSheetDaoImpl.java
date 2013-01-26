package com.github.coss.app.index.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.github.coss.app.index.constant.IndexConstant;
import com.github.coss.app.index.dao.BillShoppingSheetDao;
import com.github.coss.app.index.po.BillShoppingSheet;
import com.github.coss.app.index.utils.IndexUtils;
import com.github.coss.app.index.vo.BillShoppingSheetVo;
import com.github.coss.common.core.orm.mybatis.BaseSqlMapDao;
import com.github.coss.common.core.orm.mybatis.Page;
import com.github.coss.common.core.orm.mybatis.QueryRequest;

@SuppressWarnings("unchecked")
@Repository("billShoppingSheetDao")
public class BillShoppingSheetDaoImpl extends BaseSqlMapDao<BillShoppingSheet> implements
        BillShoppingSheetDao {

    public int save(BillShoppingSheet billShoppingSheet) {
        return getSqlSessionTemplate().insert("billShoppingSheet.insert", billShoppingSheet);
    }

    public int update(BillShoppingSheet billShoppingSheet) {
        return getSqlSessionTemplate().update("billShoppingSheet.update", billShoppingSheet);
    }

    public int saveOrUpdate(BillShoppingSheet billShoppingSheet) {
        if (billShoppingSheet.getAutoId() == null)
            return save(billShoppingSheet);
        else
            return update(billShoppingSheet);
    }

    public int deleteById(Serializable id) {
        return getSqlSessionTemplate().delete("billShoppingSheet.deleteById", id);
    }

    public int deleteByIds(List<Serializable> ids) {
        if (ids == null || ids.isEmpty()) {
            return 0;
        }
        return getSqlSessionTemplate().delete("billShoppingSheet.deleteByIds", ids);
    }

    public BillShoppingSheet getById(Serializable id) {
        BillShoppingSheet object = (BillShoppingSheet) getSqlSessionTemplate().selectOne(
                "billShoppingSheet.getById", id);
        return object;
    }

    public List<BillShoppingSheet> findByIds(List<Serializable> ids) {
        List<BillShoppingSheet> billShoppingSheetList = getSqlSessionTemplate().selectList(
                "billShoppingSheet.findByIds", ids);
        return billShoppingSheetList;
    }

    public List<BillShoppingSheet> find(BillShoppingSheet billShoppingSheet) {
        List<BillShoppingSheet> billShoppingSheetList = getSqlSessionTemplate().selectList(
                "billShoppingSheet.find", billShoppingSheet);
        return billShoppingSheetList;
    }

    public Page<BillShoppingSheet> queryPage(Integer pageIndex, Integer sizePerPage,
                                             BillShoppingSheet billShoppingSheet) {
        QueryRequest<BillShoppingSheet> queryRequest = new QueryRequest<BillShoppingSheet>(
                pageIndex, sizePerPage, billShoppingSheet);
        return this.findPage(queryRequest);
    }

    public Long getCount(BillShoppingSheet billShoppingSheet) {
        return getSqlSessionTemplate().selectOne("billShoppingSheet.getCount", billShoppingSheet);
    }

    public String getSqlMapNamesapce() {
        return "billShoppingSheet";
    }

    @Override
    public Page<BillShoppingSheet> queryPageByTableName(String tableName, int pageIndex,
                                                        int pageSize,
                                                        BillShoppingSheetVo billShoppingSheet) {
        if (tableName == null) {
            tableName = IndexUtils.getTableNameByTableNum(
                    IndexConstant.TABLE_NAME_Bill_ShoppingSheet, -1);
        }
        QueryRequest<BillShoppingSheetVo> queryRequest = new QueryRequest<BillShoppingSheetVo>(
                pageIndex, pageSize, billShoppingSheet);
        Page<BillShoppingSheet> page = this.findPage("billShoppingSheet.queryPageByTableName",
                "billShoppingSheet.getCountByTableName", queryRequest);
        return page;
    }

    @Override
    public Long getCountByTableName(String tableName, BillShoppingSheetVo billShoppingSheet) {
        if (tableName == null) {
            tableName = IndexUtils.getTableNameByTableNum(
                    IndexConstant.TABLE_NAME_Bill_ShoppingSheet, -1);
        }
        return getSqlSessionTemplate().selectOne("billShoppingSheet.getCountByTableName",
                billShoppingSheet);
    }

    @Override
    public Page<BillShoppingSheet> queryPageByTableNameGtId(String tableName, int pageIndex,
                                                            int pageSize, Long gtId,
                                                            BillShoppingSheetVo billShoppingSheet) {
        if (billShoppingSheet == null) {
            billShoppingSheet = new BillShoppingSheetVo();
        }
        if (tableName == null) {
            tableName = IndexUtils.getTableNameByTableNum(
                    IndexConstant.TABLE_NAME_Bill_ShoppingSheet, -1);
        }
        billShoppingSheet.setTableName(tableName);
        billShoppingSheet.setAutoId(gtId);
        QueryRequest<BillShoppingSheetVo> queryRequest = new QueryRequest<BillShoppingSheetVo>(
                pageIndex, pageSize, billShoppingSheet);
        Page<BillShoppingSheet> page = this.findPage("billShoppingSheet.queryPageByTableNameGtId",
                "billShoppingSheet.getCountByTableNameGtId", queryRequest);
        return page;
    }

    @Override
    public Long getCountByTableNameGtId(String tableName, Long gtId,
                                        BillShoppingSheetVo billShoppingSheet) {
        if (billShoppingSheet == null) {
            billShoppingSheet = new BillShoppingSheetVo();
        }
        if (tableName == null) {
            tableName = IndexUtils.getTableNameByTableNum(
                    IndexConstant.TABLE_NAME_Bill_ShoppingSheet, -1);
        }
        billShoppingSheet.setTableName(tableName);
        billShoppingSheet.setAutoId(gtId);
        return getSqlSessionTemplate().selectOne("billShoppingSheet.getCountByTableNameGtId",
                billShoppingSheet);
    }
}
