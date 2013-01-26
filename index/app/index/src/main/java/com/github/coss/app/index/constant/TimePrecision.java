package com.github.coss.app.index.constant;

/**
 * 时间精度枚举
 * 
 * @author azheng
 */
public enum TimePrecision {
    // value必须能被1440整除，统计时用，具体参见IndicatorStatisticsUtils
    ONE_MINUTE(1, "1分钟"),
    //
    FIVE_MINUTE(5, "5分钟"),
    //
    HALF_HOUR(30, "半小时"),
    //
    HOUR(60, "1小时"),
    //
    THREE_HOUR(180, "3小时"),
    //
    HALF_DAY(720, "半天"),
    //
    DAY(1440, "天");

    private int    value;

    private String name;

    private TimePrecision(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
