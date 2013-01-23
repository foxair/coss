package com.github.coss.app.index.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.github.coss.app.index.dao.TransferRecordDao;
import com.github.coss.app.index.po.TransferRecord;
import com.github.coss.common.core.orm.mybatis.BaseSqlMapDao;
import com.github.coss.common.core.orm.mybatis.Page;
import com.github.coss.common.core.orm.mybatis.QueryRequest;

@SuppressWarnings("unchecked")
@Repository("transferRecordDao")
public class TransferRecordDaoImpl extends BaseSqlMapDao<TransferRecord> implements
        TransferRecordDao {

    public int save(TransferRecord transferRecord) {
        return getSqlSessionTemplate().insert("transferRecord.insert", transferRecord);
    }

    public int update(TransferRecord transferRecord) {
        return getSqlSessionTemplate().update("transferRecord.update", transferRecord);
    }

    public synchronized int saveOrUpdate(TransferRecord transferRecord) {
        if (getUnique(transferRecord) == null)
            return save(transferRecord);
        else
            return update(transferRecord);
    }

    public int saveOrUpdateGtId(TransferRecord transferRecord) {
        if (getUnique(transferRecord) == null)
            return save(transferRecord);
        else
            return updateGtId(transferRecord);
    }

    private int updateGtId(TransferRecord transferRecord) {
        return getSqlSessionTemplate().update("transferRecord.updateGtId", transferRecord);
    }

    public int deleteById(Long id) {
        return getSqlSessionTemplate().delete("transferRecord.deleteById", id);
    }

    public int deleteByIds(List<Long> ids) {
        if (ids == null || ids.isEmpty()) {
            return 0;
        }
        return getSqlSessionTemplate().delete("transferRecord.deleteByIds", ids);
    }

    public TransferRecord getById(Long id) {
        TransferRecord object = (TransferRecord) getSqlSessionTemplate().selectOne(
                "transferRecord.getById", id);
        return object;
    }

    public List<TransferRecord> findByIds(List<Long> ids) {
        List<TransferRecord> transferRecordList = getSqlSessionTemplate().selectList(
                "transferRecord.findByIds", ids);
        return transferRecordList;
    }

    public TransferRecord getUnique(TransferRecord transferRecord) {
        TransferRecord tr = getSqlSessionTemplate().selectOne("transferRecord.getUnique",
                transferRecord);
        return tr;
    }

    public List<TransferRecord> find(TransferRecord transferRecord) {
        List<TransferRecord> transferRecordList = getSqlSessionTemplate().selectList(
                "transferRecord.find", transferRecord);
        return transferRecordList;
    }

    public Page<TransferRecord> queryPage(Integer pageIndex, Integer sizePerPage,
                                          TransferRecord transferRecord) {
        QueryRequest<TransferRecord> queryRequest = new QueryRequest<TransferRecord>(pageIndex,
                sizePerPage, transferRecord);
        return this.findPage(queryRequest);
    }

    public String getSqlMapNamesapce() {
        return "transferRecord";
    }

}
