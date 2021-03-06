package com.github.coss.web.index.vo;

public class IndexNodeData {
    private String  name;
    private Float[] data;

    public IndexNodeData(String name, Float[] data) {
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

    public Float[] getData() {
        return data;
    }

    public void setData(Float[] data) {
        this.data = data;
    }

}
