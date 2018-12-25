package com.senyu.gdut.goledentwo.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by 森宇 on 2018/10/27.
 */

public class DoubleBean {

    private List<Double> data;

    public List<Double> getData(){
        return data;
    }
    public void setData(List<Double> data){
        this.data = data;
    }
}
