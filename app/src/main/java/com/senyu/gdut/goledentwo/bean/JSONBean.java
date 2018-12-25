package com.senyu.gdut.goledentwo.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by 森宇 on 2018/10/23.
 */

public class JSONBean {
    public FinanceBean getResult() {
        return result;
    }

    public void setResult(FinanceBean result) {
        this.result = result;
    }

    private FinanceBean result;
}
