package com.github.coss.app.index.service;

import java.util.List;

import com.github.coss.app.index.po.BillShoppingSheet;

public interface ImportShoppingSheetService {

    /**
     * 导入shoppingSheetList到mongodb
     * @param shoppingSheetList
     * @param tableNum 
     */
    public void importShoppingSheet(List<BillShoppingSheet> dataList, int tableNum);

}
