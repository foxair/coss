package com.github.coss.app.index.service;

import java.util.Date;
import java.util.List;

import com.github.coss.app.index.vo.IndexData;

/**
 * 指数数据统计
 * @author azheng
 */
public interface IndexDataService {

    /**
     * 统计类目的刷卡数量
     * @param tcategoryId
     * @return
     */
    public Long countCategoryId(Long tcategoryId);

    /**
     * 查询指定 bankId 和 日期范围 的刷卡记录
     * @param bankId
     * @param startTime
     * @param endTime
     * @return
     */
    public List<IndexData> findByBankIdAndDate(Long bankId, Date startTime, Date endTime);
}
