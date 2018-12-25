package com.senyu.gdut.goledentwo.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.senyu.gdut.goledentwo.bean.DoubleBean;
import com.senyu.gdut.goledentwo.bean.FinanceBean;
import com.senyu.gdut.goledentwo.bean.JSONBean;

import java.util.List;

/**
 * Created by 森宇 on 2018/10/23.
 */

public class JsonUtil {
    public static List<FinanceBean> parseJson(String response ){
        Gson gson = new Gson();
        List<FinanceBean> bean = gson.fromJson(response,new TypeToken<List<FinanceBean>>(){}.getType());
        return bean;
    }
    public static List<Double>parseDouble(String response){
        Gson gson = new Gson();
        List<Double> bean = gson.fromJson(response,new TypeToken<List<Double>>(){}.getType());
        return bean;
    }
}
