package com.github.coss.app.index.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.coss.app.index.dao.BillShoppingSheetDao;
import com.github.coss.app.index.po.BillShoppingSheet;
import com.github.coss.app.index.service.BillShoppingSheetService;
import com.github.coss.app.index.vo.BillShoppingSheetVo;
import com.github.coss.common.core.orm.mybatis.Page;
import com.github.coss.common.core.orm.mybatis.SqlMapDao;
import com.github.coss.common.core.service.BaseService;

@Service("billShoppingSheetService")
@Transactional
public class BillShoppingSheetServiceImpl extends BaseService<BillShoppingSheet> implements
        BillShoppingSheetService {

    @Resource
    private BillShoppingSheetDao billShoppingSheetDao;

    public int save(BillShoppingSheet billShoppingSheet) {
        return billShoppingSheetDao.save(billShoppingSheet);
    }

    public int update(BillShoppingSheet billShoppingSheet) {
        return billShoppingSheetDao.update(billShoppingSheet);
    }

    public int saveOrUpdate(BillShoppingSheet billShoppingSheet) {
        if (billShoppingSheet.getAutoId() == null)
            return save(billShoppingSheet);
        else
            return update(billShoppingSheet);
    }

    public int deleteById(Serializable id) {
        return billShoppingSheetDao.deleteById(id);
    }

    public int deleteByIds(List<Serializable> ids) {
        return billShoppingSheetDao.deleteByIds(ids);
    }

    public BillShoppingSheet getById(Serializable id) {
        BillShoppingSheet object = (BillShoppingSheet) billShoppingSheetDao.getById(id);
        return object;
    }

    public List<BillShoppingSheet> findByIds(List<Serializable> ids) {
        List<BillShoppingSheet> billShoppingSheetList = billShoppingSheetDao.findByIds(ids);
        return billShoppingSheetList;
    }

    public List<BillShoppingSheet> find(BillShoppingSheet billShoppingSheet) {
        List<BillShoppingSheet> billShoppingSheetList = billShoppingSheetDao
                .find(billShoppingSheet);
        return billShoppingSheetList;
    }

    public Page<BillShoppingSheet> queryPage(Integer pageIndex, Integer sizePerPage,
                                             BillShoppingSheet billShoppingSheet) {
        return billShoppingSheetDao.queryPage(pageIndex, sizePerPage, billShoppingSheet);
    }

    public void setBillShoppingSheetDao(BillShoppingSheetDao dao) {
        this.billShoppingSheetDao = dao;
    }

    @SuppressWarnings("unchecked")
    public SqlMapDao<BillShoppingSheet> getSqlMapDao() {
        return (SqlMapDao<BillShoppingSheet>) this.billShoppingSheetDao;
    }

    @Override
    public Long getCount(BillShoppingSheet billShoppingSheet) {
        return this.billShoppingSheetDao.getCount(billShoppingSheet);
    }

    @Override
    public Page<BillShoppingSheet> queryPageByTableName(String tableName, int pageIndex,
                                                        int pageSize,
                                                        BillShoppingSheetVo billShoppingSheet) {
        return billShoppingSheetDao.queryPageByTableName(tableName, pageIndex, pageSize,
                billShoppingSheet);
    }

    @Override
    public Long getCountByTableName(String tableName, BillShoppingSheetVo billShoppingSheet) {
        return billShoppingSheetDao.getCountByTableName(tableName, billShoppingSheet);
    }

    @Override
    public Page<BillShoppingSheet> queryPageByTableNameGtId(String tableName, int pageIndex,
                                                            int pageSize, Long gtId,
                                                            BillShoppingSheetVo billShoppingSheet) {
        return billShoppingSheetDao.queryPageByTableNameGtId(tableName, pageIndex, pageSize, gtId,
                billShoppingSheet);
    }

    @Override
    public Long getCountByTableNameGtId(String tableName, Long gtId,
                                        BillShoppingSheetVo billShoppingSheet) {
        return billShoppingSheetDao.getCountByTableNameGtId(tableName, gtId, billShoppingSheet);
    }
}
