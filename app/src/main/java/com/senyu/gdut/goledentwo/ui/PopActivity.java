package com.senyu.gdut.goledentwo.ui;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.google.gson.JsonArray;
import com.senyu.gdut.goledentwo.R;
import com.senyu.gdut.goledentwo.bean.FinanceBean;
import com.senyu.gdut.goledentwo.util.JsonUtil;
import com.senyu.gdut.goledentwo.util.OkHttp;


import org.json.JSONArray;
import org.w3c.dom.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import okhttp3.Request;

public class PopActivity extends AppCompatActivity {
    private TextView buyPriTV;
    private TextView quanPriTV;
    private TextView openTodayTV;
    private TextView closeYesTV;
    private TextView maxPriTV;
    private TextView minPriTV;
    private TextView timeTV;
    private TextView title;
    private LineChart mLineChart;
    private List<Double> mDataList;
    private List<Entry> entries = new ArrayList<>();
    private  StringBuilder chartDataurl = new StringBuilder();
    private  String url = "http://39.108.10.69:8080/Finance/QueryServlet?buypri=";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_pop);

        bindViews();
        FinanceBean bean = (FinanceBean)getIntent().getSerializableExtra("finance_data");
        initData(bean);
        gainChartData(bean.getVariety());



    }

    private void initChartData() {
        for(int i=0;i<mDataList.size();i++){
            entries.add(new Entry(Float.valueOf(String.valueOf(i)),Float.valueOf(mDataList.get(i).toString())));
        }
        LineDataSet dataSet = new LineDataSet(entries,"senyu");
        dataSet.setColors(Color.YELLOW, Color.WHITE, Color.RED, Color.GREEN);
        LineData lineData = new LineData(dataSet);
        mLineChart.setData(lineData);
        mLineChart.invalidate();
        Description des = new Description();
        des.setText("30条趋势");
        des.setTextColor(Color.YELLOW);
        mLineChart.setDescription(des);
        mLineChart.setBackgroundColor(getResources().getColor(R.color.colorDarkBG));
        mLineChart.getXAxis().setTextColor(Color.WHITE);
        mLineChart.setBorderColor(Color.YELLOW);
        mLineChart.getLineData().setValueTextColor(Color.YELLOW);
        mLineChart.getAxisLeft().setTextColor(Color.WHITE);
        mLineChart.getAxisRight().setTextColor(Color.WHITE);
    }

    private void gainChartData(String variety) {
        switch (variety){
            case "美元账户黄金":
                chartDataurl.append(url).append(1);
                break;
            case "美元账户白银":
                chartDataurl.append(url).append(2);
                break;
            case "美元账户铂金":
                chartDataurl.append(url).append(3);
                break;
            case "美元账户钯金":
                chartDataurl.append(url).append(4);
                break;
            case "人民币账户黄金":
                chartDataurl.append(url).append(5);
                break;
            case "人民币账户白银":
                chartDataurl.append(url).append(6);
                break;
            case "人民币账户铂金":
                chartDataurl.append(url).append(7);
                break;
            case "人民币账户钯金":
                chartDataurl.append(url).append(8);
                break;
        }
        setOKhttp(chartDataurl.toString());
    }

    private void setOKhttp(String url) {
        OkHttp.getAsync(url, new OkHttp.DataCallBack() {
            @Override
            public void requestFailure(Request request, IOException e) {

            }

            @Override
            public void requestSuccess(String result) throws Exception {

                mDataList = JsonUtil.parseDouble(result);
                Collections.reverse(mDataList);
                initChartData();
                Log.d("popActivity",mDataList.get(1).toString());
            }
        });
    }


    private void initData(FinanceBean bean) {
        buyPriTV.setText(Double.toString(bean.getBuypri()));
        quanPriTV.setText(Double.toString(bean.getQuantipri()));
        openTodayTV.setText(Double.toString(bean.getTodayopen()));
        closeYesTV.setText(Double.toString(bean.getCloseyes()));
        maxPriTV.setText(Double.toString(bean.getMaxpri()));
        minPriTV.setText(Double.toString(bean.getMinpri()));
        timeTV.setText(bean.getTime());
        title.setText(bean.getVariety());
        if(bean.getQuantipri()>=0){
            buyPriTV.setTextColor(getResources().getColor(R.color.rec_pri_red));
            quanPriTV.setTextColor(getResources().getColor(R.color.rec_pri_red));
        }else{
            buyPriTV.setTextColor(getResources().getColor(R.color.rec_pri_green));
            quanPriTV.setTextColor(getResources().getColor(R.color.rec_pri_green));
        }
    }

    private void bindViews() {
        buyPriTV = findViewById(R.id.tv_buy_pri);
        quanPriTV = findViewById(R.id.tv_quant_pri);
        openTodayTV = findViewById(R.id.today_open_data);
        closeYesTV = findViewById(R.id.close_yes_data);
        maxPriTV = findViewById(R.id.max_pri_data);
        minPriTV = findViewById(R.id.min_pri_data);
        timeTV = findViewById(R.id.time_tv);
        title = findViewById(R.id.pop_title_tv);
        mLineChart = findViewById(R.id.chart);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLineChart.clear();
        Log.d("onDestroy","pop调用");
    }
}
