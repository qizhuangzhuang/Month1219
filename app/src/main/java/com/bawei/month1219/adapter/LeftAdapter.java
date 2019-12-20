package com.bawei.month1219.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.bawei.month1219.R;
import com.bawei.month1219.bean.LeftDataBean;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

public class LeftAdapter extends RecyclerView.Adapter<LeftAdapter.ViewHolder> {


    public List<LeftDataBean> list=new ArrayList<>();
    public Context context;

    public LeftAdapter(List<LeftDataBean> list, Context context) {
        this.list.addAll(list);
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.left_adapter, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {


        final LeftDataBean leftDataBean = list.get(i);
        viewHolder.leftadapter_tx_.setText(leftDataBean.getName());

        viewHolder.leftadapter_tx_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().postSticky(leftDataBean);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView leftadapter_tx_;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            leftadapter_tx_ = (TextView) itemView.findViewById(R.id.leftadapter_tx_);
        }
    }
}
