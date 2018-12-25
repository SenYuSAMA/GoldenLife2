package com.senyu.gdut.goledentwo.ui;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.senyu.gdut.goledentwo.MainActivity;
import com.senyu.gdut.goledentwo.MyAdapter;
import com.senyu.gdut.goledentwo.R;
import com.senyu.gdut.goledentwo.bean.FinanceBean;
import com.senyu.gdut.goledentwo.util.JsonUtil;
import com.senyu.gdut.goledentwo.util.OkHttp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import okhttp3.Request;

/**
 * A simple {@link Fragment} subclass.
 */
public class MarKetFragment extends android.support.v4.app.Fragment {
    private MyAdapter myAdapter;
    private RecyclerView mRecyclerView;
    private static String url = "http://39.108.10.69:8080/Finance/QueryServlet?action=all";
    private List<FinanceBean> mList = new ArrayList<>();

    public MarKetFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_market,null);
        mRecyclerView = view.findViewById(R.id.market_rec);
        setOKHttp(url);
        setRecyclerView();
        return view;
    }
    private void setRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        myAdapter = new MyAdapter(getActivity(),mList);
        myAdapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getActivity(),PopActivity.class);
                intent.putExtra("finance_data",mList.get(position));
                startActivity(intent);
            }
        });
        mRecyclerView.setAdapter(myAdapter);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
    }
    private void setOKHttp(String url) {
        OkHttp.getAsync(url, new OkHttp.DataCallBack() {
            @Override
            public void requestFailure(Request request, IOException e) {

            }

            @Override
            public void requestSuccess(String result) throws Exception {
                mList = JsonUtil.parseJson(result);
            }
        });
    }

}
