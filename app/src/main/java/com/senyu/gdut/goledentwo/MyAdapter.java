package com.senyu.gdut.goledentwo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.senyu.gdut.goledentwo.bean.FinanceBean;

import java.util.List;

/**
 * Created by 森宇 on 2018/10/25.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {
    private Context mContext;
    private List<FinanceBean> mList;
    private RecyclerView recyclerView;
    private OnItemClickListener mClickListener;


    public MyAdapter(Context context,List<FinanceBean> list){
            this.mContext = context;
            this.mList = list;
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.mClickListener = listener;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        recyclerView = (RecyclerView) parent;
        MyHolder holder = new MyHolder(LayoutInflater.from(mContext).inflate(R.layout.rec_item,parent,false),mClickListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {
        holder.varietyTV.setText(mList.get(position).getVariety());
        holder.morePriceTV.setText(Double.toString(mList.get(position).getQuantipri()));
        holder.newPriceTV.setText(Double.toString(mList.get((position)).getBuypri()));
        if(getItemViewType(position)==1){
            holder.itemView.setBackgroundColor(mContext.getResources().getColor(R.color.guide_bg_grey));
        }

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView varietyTV;
        TextView newPriceTV;
        TextView morePriceTV;
        RelativeLayout rootView;
        private OnItemClickListener mListener;
        public MyHolder(View itemView,OnItemClickListener listener) {
            super(itemView);
            mListener = listener;
            itemView.setOnClickListener(this);
            rootView = itemView.findViewById(R.id.rec_item_rl);
            varietyTV = itemView.findViewById(R.id.item_tv);
            newPriceTV = itemView.findViewById(R.id.item_new_pri);
            morePriceTV = itemView.findViewById(R.id.item_more_pri);
        }

        @Override
        public void onClick(View v) {
            mListener.onItemClick(v,getPosition());
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(position%2==1){
            return 1;
        }
        else return 2;
    }
    public interface OnItemClickListener{
        public void onItemClick(View view,int position);
    }
}
