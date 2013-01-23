package com.github.coss.app.index.service;

import java.io.Serializable;
import java.util.List;

import com.github.coss.app.index.po.BillShoppingSheet;
import com.github.coss.app.index.vo.BillShoppingSheetVo;
import com.github.coss.common.core.orm.mybatis.Page;

public interface BillShoppingSheetService {

    public int save(BillShoppingSheet billShoppingSheet);

    public int update(BillShoppingSheet billShoppingSheet);

    public int saveOrUpdate(BillShoppingSheet billShoppingSheet);

    public int deleteById(Serializable id);

    public int deleteByIds(List<Serializable> ids);

    public BillShoppingSheet getById(Serializable id);

    public List<BillShoppingSheet> findByIds(List<Serializable> ids);

    public List<BillShoppingSheet> find(BillShoppingSheet billShoppingSheet);

    public Page<BillShoppingSheet> queryPage(Integer pageIndex, Integer sizePerPage,
                                             BillShoppingSheet billShoppingSheet);

    public Long getCount(BillShoppingSheet billShoppingSheet);

    /**
     * 指定表名查询分页
     * @param tableName 分表名
     */
    public Page<BillShoppingSheet> queryPageByTableName(String tableName, int p, int pageSize,
                                                        BillShoppingSheetVo object);

    /**
     * 指定表名查询记录数
     * @param tableName 分表名
     */
    public Long getCountByTableName(String tableName, BillShoppingSheetVo object);

    /**
     * 指定表名和ID起始值查询分页
     * @param tableName
     * @param pageIndex
     * @param pageSize
     * @param gtId
     * @param billShoppingSheet
     * @return
     */
    Page<BillShoppingSheet> queryPageByTableNameGtId(String tableName, int pageIndex, int pageSize,
                                                     Long gtId,
                                                     BillShoppingSheetVo billShoppingSheet);

    /**
     * 指定表名和ID起始值查询记录数
     * @param tableName
     * @param gtId
     * @param billShoppingSheet
     * @return
     */
    Long getCountByTableNameGtId(String tableName, Long gtId, BillShoppingSheetVo billShoppingSheet);

}
