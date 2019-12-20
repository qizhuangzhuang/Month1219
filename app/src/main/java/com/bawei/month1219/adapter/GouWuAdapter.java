package com.bawei.month1219.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.bawei.month1219.R;
import com.bawei.month1219.bean.GouWuDataBean;
import com.bawei.month1219.bean.GouWuListBean;

import java.util.ArrayList;
import java.util.List;

public class GouWuAdapter extends RecyclerView.Adapter<GouWuAdapter.ViewHolder> {

    public List<GouWuListBean> list=new ArrayList<>();
    public Context context;
    public boolean isChecked;

    public List<GouWuListBean> getList() {
        return list;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;

        for (int i=0;i<list.size();i++){
            GouWuListBean gouWuListBean = list.get(i);
            List<GouWuDataBean> shoppingCartList = gouWuListBean.getShoppingCartList();
            for (int j=0;j<shoppingCartList.size();j++){
                GouWuDataBean gouWuDataBean = shoppingCartList.get(j);
                gouWuDataBean.setChecked(isChecked);
            }
        }
        notifyDataSetChanged();
    }

    public GouWuAdapter(List<GouWuListBean> list, Context context) {
        this.list.addAll(list);
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.gouwu_name, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        GouWuListBean gouWuListBean = list.get(i);
        viewHolder.gouwu_gouwuName.setText(gouWuListBean.getCategoryName());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        viewHolder.gouwu_recycles.setLayoutManager(linearLayoutManager);
        GouWuListBean gouWuListBean1 = list.get(i);
        List<GouWuDataBean> shoppingCartList = gouWuListBean1.getShoppingCartList();
        GouWuFen_Adapter gouWuFen_adapter = new GouWuFen_Adapter(shoppingCartList, context);
        viewHolder.gouwu_recycles.setAdapter(gouWuFen_adapter);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView gouwu_gouwuName;
        public RecyclerView gouwu_recycles;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            gouwu_gouwuName = (TextView) itemView.findViewById(R.id.gouwu_gouwuName);
            gouwu_recycles = (RecyclerView) itemView.findViewById(R.id.gouwu_recycles);
        }
    }
}
