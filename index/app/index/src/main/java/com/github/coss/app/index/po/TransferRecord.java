package com.github.coss.app.index.po;

import java.util.Date;

public class TransferRecord {

    private Long    id;
    private String  tableNamePrefix;
    private Integer tableNameNum;
    private Long    stepEndId;
    private Date    stepTime;

    public TransferRecord() {
        super();
    }

    public TransferRecord(String tableNamePrefix, Integer tableNameNum) {
        super();
        this.tableNamePrefix = tableNamePrefix;
        this.tableNameNum = tableNameNum;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setTableNamePrefix(String tableNamePrefix) {
        this.tableNamePrefix = tableNamePrefix;
    }

    public String getTableNamePrefix() {
        return this.tableNamePrefix;
    }

    public void setTableNameNum(Integer tableNameNum) {
        this.tableNameNum = tableNameNum;
    }

    public Integer getTableNameNum() {
        return this.tableNameNum;
    }

    public void setStepEndId(Long stepEndId) {
        this.stepEndId = stepEndId;
    }

    public Long getStepEndId() {
        return this.stepEndId;
    }

    public void setStepTime(Date stepTime) {
        this.stepTime = stepTime;
    }

    public Date getStepTime() {
        return this.stepTime;
    }

}
