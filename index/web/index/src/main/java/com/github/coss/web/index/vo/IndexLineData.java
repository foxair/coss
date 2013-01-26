package com.github.coss.web.index.vo;

import java.util.List;

public class IndexLineData {
    private String        name;
    private List<List<?>> data;

    public IndexLineData(String name, List<List<?>> data) {
        super();
        this.name = name;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<List<?>> getData() {
        return data;
    }

    public void setData(List<List<?>> data) {
        this.data = data;
    }

}
