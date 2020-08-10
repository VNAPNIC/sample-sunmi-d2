package com.example.sunmitest.bean;

/**
 * 清单
 * Created by 徐荣 on 2016/9/13.
 */
public class KVP {
    /**
     * 清单名
     */
    private String name;
    /**
     * 清单值
     */
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "KVP{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
