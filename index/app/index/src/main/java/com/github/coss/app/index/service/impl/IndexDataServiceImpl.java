package com.github.coss.app.index.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.github.coss.app.index.po.BillShoppingSheet;
import com.github.coss.app.index.service.IndexDataService;
import com.github.coss.app.index.vo.BillShoppingSheetVo;
import com.github.coss.app.index.vo.IndexData;
import com.github.coss.common.utils.lang.DateTime.DateUtils;
import com.github.coss.common.utils.lang.DateTime.TimePart;
import com.github.coss.common.utils.lang.DateTime.TimeUnit;

/**
 * 指数数据统计
 * @author azheng
 */
@Service("indexDataService")
public class IndexDataServiceImpl implements IndexDataService {

    @Resource
    private MongoOperations mongoTemplate;

    public Long countCategoryId(Long tcategoryId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("tcategoryId").is(tcategoryId));
        return mongoTemplate.count(query, BillShoppingSheet.class);
    }

    public List<IndexData> findByBankIdAndDate(Long bankId, Date startTime, Date endTime) {
        Query query = new Query();
        query.addCriteria(Criteria.where("bankId").is(bankId));
        query.addCriteria(Criteria.where("transDate").gte(startTime).lte(endTime));
        List<BillShoppingSheetVo> bssList = mongoTemplate.find(query, BillShoppingSheetVo.class,
                "BillShoppingSheet");
        //TODO build的数据需要加入到缓存
        return buildData(bssList, startTime, endTime);
    }

    public List<IndexData> buildData(List<BillShoppingSheetVo> bssList, Date startTime, Date endTime) {
        List<TimePart> timePartList = DateUtils.splitTimeUnit(startTime, endTime, TimeUnit.DAY, 1);
        Map<Date, IndexData> dataTemp = new HashMap<Date, IndexData>(timePartList.size());
        for (TimePart timePart : timePartList) {
            for (BillShoppingSheetVo bss : bssList) {
                if (DateUtils
                        .inDatePart(bss.getTransDate(), timePart.getStart(), timePart.getEnd())) {
                    IndexData indexData = dataTemp.get(timePart.getStart());
                    if (indexData == null) {
                        indexData = new IndexData(timePart.getStart());
                    } else {
                        indexData.setPartDate(timePart.getStart());
                        indexData.setAmount(indexData.getAmount() + bss.getAmountMoney());
                        indexData.setTransCount(indexData.getTransCount() + 1);
                    }
                    dataTemp.put(timePart.getStart(), indexData);
                }
            }
        }
        Iterator<Entry<Date, IndexData>> it = dataTemp.entrySet().iterator();
        List<IndexData> indexDataList = new ArrayList<IndexData>();
        while (it.hasNext()) {
            Entry<Date, IndexData> entry = it.next();
            indexDataList.add(entry.getValue());
        }
        return indexDataList;
    }
}
