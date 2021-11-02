package com.example.springbootdemo.util;

/**
 * @author lizhen created on 2021-10-28 11:23
 */

public class BaseResult {


    private boolean obj;

    private String desc;

    public BaseResult(boolean obj, String desc) {
        this.obj = obj;
        this.desc = desc;
    }

    public boolean isObj() {
        return obj;
    }

    public void setObj(boolean obj) {
        this.obj = obj;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
