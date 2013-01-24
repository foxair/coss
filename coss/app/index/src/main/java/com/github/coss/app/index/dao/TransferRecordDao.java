package com.github.coss.app.index.dao;

import java.util.List;

import com.github.coss.app.index.po.TransferRecord;
import com.github.coss.common.core.orm.mybatis.Page;

public interface TransferRecordDao {

    public int save(TransferRecord transferRecord);

    public int update(TransferRecord transferRecord);

    public int saveOrUpdate(TransferRecord transferRecord);

    public int deleteById(Long id);

    public int deleteByIds(List<Long> ids);

    public TransferRecord getById(Long id);

    public List<TransferRecord> findByIds(List<Long> ids);

    public List<TransferRecord> find(TransferRecord transferRecord);

    public TransferRecord getUnique(TransferRecord transferRecord);

    public Page<TransferRecord> queryPage(Integer pageIndex, Integer sizePerPage,
                                          TransferRecord transferRecord);

    /**
     * 保存或更新为最大的最后导入ID
     * @param transferRecord
     */
    public int saveOrUpdateGtId(TransferRecord transferRecord);

}
