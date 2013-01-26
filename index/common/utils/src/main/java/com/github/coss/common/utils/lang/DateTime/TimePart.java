package com.github.coss.common.utils.lang.DateTime;

import java.util.Date;

public class TimePart {

    /**
     * 时间片段起始时间
     */
    private Date start;
    /**
     * 时间片段结束时间
     */
    private Date end;

    public TimePart(Date start, Date end) {
        this.start = start;
        this.end = end;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

}
