package com.github.coss.app.index.vo;

import com.github.coss.app.index.po.BillShoppingSheet;

public class BillShoppingSheetVo extends BillShoppingSheet {
    private Long    id;
    private Integer tableNum;
    private String  tableName;

    public BillShoppingSheetVo() {
        super();
        this.tableNum = -1;
    }

    /**
     * @return MySql数据库主键-MongoDB主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置MySql数据库主键-MongoDB主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return 来自MySql的分表编号
     */
    public Integer getTableNum() {
        return tableNum;
    }

    /**
     * 设置来自MySql的分表编号
     */
    public void setTableNum(Integer tableNum) {
        this.tableNum = tableNum;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

}
