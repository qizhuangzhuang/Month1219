package com.bawei.month1219.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.month1219.R;
import com.bawei.month1219.bean.RightDataBean;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class RightAdapter extends RecyclerView.Adapter<RightAdapter.ViewHolder> {
    public List<RightDataBean> list=new ArrayList<>();
    public Context context;

    public  void setClear(){
       list.clear();
    }



    public RightAdapter(List<RightDataBean> list, Context context) {
        this.list.addAll(list);
        this.context = context;
    }
    public void clear(){
        list.clear();
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_right, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        RightDataBean rightDataBean = list.get(i);

        String name = rightDataBean.getCommodityName();
        viewHolder.itemRight_name.setText(name);

        int price = rightDataBean.getPrice();
        viewHolder.itemRight_price.setText(price+"");

        String imgs = rightDataBean.getMasterPic();
        Glide.with(context).load(imgs).into(viewHolder.itemRight_img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView itemRight_img;
        public TextView itemRight_name;
        public TextView itemRight_price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemRight_img = (ImageView) itemView.findViewById(R.id.itemRight_img);
            itemRight_name = (TextView) itemView.findViewById(R.id.itemRight_name);
            itemRight_price = (TextView) itemView.findViewById(R.id.itemRight_price);
        }
    }
}
