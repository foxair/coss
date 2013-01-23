package com.github.coss.common.utils.lang.DateTime;

public enum TimeUnit {

    YEAR(1, "年"),
    MONTH(2, "月"),
    DAY(3, "日"),
    HOUR(4, "时"),
    MINUTE(5, "分"),
    SECOND(6, "秒");

    private int    value;
    private String name;

    private TimeUnit(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
