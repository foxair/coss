package com.github.coss.app.index.constant;

/**
 * 时间区段枚举
 * 
 * @author azheng
 */
public enum TimeSlot {

    /** 当日  */
    TODAY("today", "当日", TimePrecision.HALF_HOUR),
    /** 本周 */
    WEEK("week", "本周", TimePrecision.HOUR),
    /** 上周  */
    PRE_WEEK("pre_week", "上周", TimePrecision.HOUR),
    /** 本月 */
    MONTH("month", "本月", TimePrecision.DAY),
    /** 上月 */
    PRE_MONTH("pre_month", "上月", TimePrecision.DAY);

    private String        value;

    private String        name;

    private TimePrecision precision;

    private TimeSlot(String value, String name) {
        this.value = value;
        this.name = name;
    }

    /**
     * @param value key
     * @param name 名称
     * @param precision 默认精度
     */
    private TimeSlot(String value, String name, TimePrecision precision) {
        this.value = value;
        this.name = name;
        this.precision = precision;
    }

    public TimePrecision getPrecision() {
        return precision;
    }

    public void setPrecision(TimePrecision precision) {
        this.precision = precision;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getName(String value) {
        TimeSlot s = get(value);
        if (s != null)
            return s.getName();
        return null;
    }

    public TimePrecision getPrecision(String value) {
        TimeSlot s = get(value);
        if (s != null)
            return s.getPrecision();
        return null;
    }

    public static TimeSlot get(String value) {
        if (value != null)
            for (TimeSlot ts : values())
                if (ts.value.equals(value))
                    return ts;
        return null;
    }
}
