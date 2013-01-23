package com.github.coss.app.index.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import com.github.coss.app.index.constant.IndexConstant;
import com.github.coss.app.index.dao.TransferRecordDao;
import com.github.coss.app.index.po.BillShoppingSheet;
import com.github.coss.app.index.po.TransferRecord;
import com.github.coss.app.index.service.ImportShoppingSheetService;
import com.github.coss.app.index.vo.BillShoppingSheetVo;

/**
 * ShoppingSheet表数据导入mongodb的任务处理逻辑
 * 多个线程执行
 * @author azheng
 */
@Service("importShoppingSheetService")
public class ImportShoppingSheetServiceImpl implements ImportShoppingSheetService {
    private static final Logger logger = LoggerFactory
                                               .getLogger(ImportShoppingSheetServiceImpl.class);

    @Resource(name = "mongoTemplate")
    private MongoOperations     mongoTemplate;
    @Resource
    private TransferRecordDao   transferRecordDao;

    @Override
    public void importShoppingSheet(List<BillShoppingSheet> dataList, int tnum) {
        if (dataList == null || dataList.isEmpty()) {
            return;
        } else {
            List<BillShoppingSheetVo> voList = getBillShoppingSheetVoList(dataList, tnum);
            try {
                mongoTemplate.insert(voList, "BillShoppingSheet");
                //每次处理完一批保存最后处理的Id
                BillShoppingSheet bss = dataList.get(dataList.size() - 1);
                TransferRecord transferRecord = new TransferRecord();
                transferRecord.setTableNamePrefix(IndexConstant.TABLE_NAME_Bill_ShoppingSheet);
                transferRecord.setTableNameNum(tnum);
                transferRecord.setStepEndId(bss.getAutoId());
                transferRecord.setStepTime(new Date());
                transferRecordDao.saveOrUpdateGtId(transferRecord);
            } catch (Exception e) {
                if (logger.isErrorEnabled()) {
                    logger.error(">>>>>>>>" + e.getMessage(), e);
                }
            }
        }
    }

    private List<BillShoppingSheetVo> getBillShoppingSheetVoList(List<BillShoppingSheet> billShoppingSheetList,
                                                                 int tnum) {
        List<BillShoppingSheetVo> billShoppingSheetVoList = new ArrayList<BillShoppingSheetVo>();
        for (BillShoppingSheet billShoppingSheet : billShoppingSheetList) {
            BillShoppingSheetVo billShoppingSheetVo = new BillShoppingSheetVo();
            // -------- 属性复制 -------- Begin
            billShoppingSheetVo.setAutoId(billShoppingSheet.getAutoId());
            billShoppingSheetVo.setAmountMoney(billShoppingSheet.getAmountMoney());
            billShoppingSheetVo.setBillId(billShoppingSheet.getBillId());
            billShoppingSheetVo.setUserId(billShoppingSheet.getUserId());
            billShoppingSheetVo.setTransDate(billShoppingSheet.getTransDate());
            billShoppingSheetVo.setPostDate(billShoppingSheet.getPostDate());
            billShoppingSheetVo.setDiscription(billShoppingSheet.getDiscription());
            billShoppingSheetVo.setTransType(billShoppingSheet.getTransType());
            billShoppingSheetVo.setCurrencytype(billShoppingSheet.getCurrencytype());
            billShoppingSheetVo.setTransOrgAmount(billShoppingSheet.getTransOrgAmount());
            billShoppingSheetVo.setTransAddr(billShoppingSheet.getTransAddr());
            billShoppingSheetVo.setCreateTime(billShoppingSheet.getCreateTime());
            billShoppingSheetVo.setCardNo(billShoppingSheet.getCardNo());
            billShoppingSheetVo.setLastModifyTime(billShoppingSheet.getLastModifyTime());
            billShoppingSheetVo.setBankId(billShoppingSheet.getBankId());
            billShoppingSheetVo.setCategoryId(billShoppingSheet.getCategoryId());
            billShoppingSheetVo.setKeywordId(billShoppingSheet.getKeywordId());
            billShoppingSheetVo.setTcategoryId(billShoppingSheet.getTcategoryId());
            billShoppingSheetVo.setTkeywordId(billShoppingSheet.getTkeywordId());
            billShoppingSheetVo.setTkeywordIds(billShoppingSheet.getTkeywordIds());
            // -------- 属性复制 -------- End
            //设置表编号和表名
            billShoppingSheetVo.setTableNum(tnum);
            //设置ID
            billShoppingSheetVo.setId(getId(tnum, billShoppingSheet.getAutoId()));
            billShoppingSheetVoList.add(billShoppingSheetVo);
        }
        return billShoppingSheetVoList;
    }

    private static long getId(int tnum, long autoId) {
        long id;
        long prefix;
        if (tnum == -1) {
            prefix = 1001;
        } else {
            prefix = 2000;
        }
        id = (prefix + tnum) * 1000000000L + autoId;
        return id;
    }
}
