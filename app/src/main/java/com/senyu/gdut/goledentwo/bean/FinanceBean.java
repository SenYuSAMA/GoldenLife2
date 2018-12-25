package com.senyu.gdut.goledentwo.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by 森宇 on 2018/10/22.
 */

public class FinanceBean implements Serializable{
    @SerializedName("variety")
    private String variety;
    @SerializedName("time")
    private String time;
    @SerializedName("buypri")
    private double buypri;
    @SerializedName("sellpri")
    private double sellpri;
    @SerializedName("todayopen")
    private double todayopen;
    @SerializedName("closeyes")
    private double closeyes;
    @SerializedName("midpri")
    private double midpri;
    @SerializedName("maxpri")
    private double maxpri;
    @SerializedName("minpri")
    private double minpri;
    @SerializedName("quantipri")
    private double quantipri;


    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getBuypri() {
        return buypri;
    }

    public void setBuypri(double buypri) {
        this.buypri = buypri;
    }

    public double getSellpri() {
        return sellpri;
    }

    public void setSellpri(double sellpri) {
        this.sellpri = sellpri;
    }

    public double getTodayopen() {
        return todayopen;
    }

    public void setTodayopen(double todayopen) {
        this.todayopen = todayopen;
    }

    public double getCloseyes() {
        return closeyes;
    }

    public void setCloseyes(double closeyes) {
        this.closeyes = closeyes;
    }

    public double getMidpri() {
        return midpri;
    }

    public void setMidpri(double midpri) {
        this.midpri = midpri;
    }

    public double getMaxpri() {
        return maxpri;
    }

    public void setMaxpri(double maxpri) {
        this.maxpri = maxpri;
    }

    public double getMinpri() {
        return minpri;
    }

    public void setMinpri(double minpri) {
        this.minpri = minpri;
    }

    public double getQuantipri() {
        return quantipri;
    }

    public void setQuantipri(double quantipri) {
        this.quantipri = quantipri;
    }

    public FinanceBean(){}

    public FinanceBean(String variety, String time, double buypri, double sellpri, double todayopen, double closeyes, double midpri, double maxpri, double minpri, double quantipri) {
        this.variety = variety;
        this.time = time;
        this.buypri = buypri;
        this.sellpri = sellpri;
        this.todayopen = todayopen;
        this.closeyes = closeyes;
        this.midpri = midpri;
        this.maxpri = maxpri;
        this.minpri = minpri;
        this.quantipri = quantipri;
    }
}
