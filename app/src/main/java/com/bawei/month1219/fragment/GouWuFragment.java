package com.bawei.month1219.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;


import com.bawei.month1219.R;
import com.bawei.month1219.adapter.EventBean;
import com.bawei.month1219.adapter.GouWuAdapter;
import com.bawei.month1219.base.BaseFragment;
import com.bawei.month1219.bean.GouWuDataBean;
import com.bawei.month1219.bean.GouWuListBean;
import com.bawei.month1219.bean.GouWuResult;
import com.bawei.month1219.mvp.GouWuContract;
import com.bawei.month1219.mvp.GouWuPresent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

public class GouWuFragment extends BaseFragment<GouWuPresent> implements GouWuContract.GouWuView {

    private RecyclerView gouwu_recycles;
    private CheckBox gouwu_zong_chengckbox;
    private TextView heji_price;
    private TextView tijiao_nums;
    private GouWuAdapter gouWuAdapter;

    @Override
    protected int initLayout() {
        return R.layout.gouwu;
    }

    @Override
    protected void initView(View view) {
        EventBus.getDefault().register(this);
        gouwu_recycles = (RecyclerView) view.findViewById(R.id.gouwu_recycles);
        gouwu_zong_chengckbox = (CheckBox) view.findViewById(R.id.gouwu_zong_chengckbox);
        heji_price = (TextView) view.findViewById(R.id.heji_price);
        tijiao_nums = (TextView) view.findViewById(R.id.tijiao_nums);
    }

    @Override
    protected GouWuPresent initPresnet() {
        return new GouWuPresent();
    }


    @Override
    protected void initData(Bundle savedInstanceState) {
        presents.GouWushow();
        gouwu_zong_chengckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = gouwu_zong_chengckbox.isChecked();
                gouWuAdapter.setChecked(checked);
                toPrice();
            }
        });
    }
    @Subscribe
    public void JieShou(EventBean eventBean){
        toPrice();
    }

    private void toPrice() {
        double tob=0;
        List<GouWuListBean> list = gouWuAdapter.getList();
        for (int i=0;i<list.size();i++){
            GouWuListBean gouWuListBean = list.get(i);
            List<GouWuDataBean> shoppingCartList = gouWuListBean.getShoppingCartList();
            for (int j=0;j<shoppingCartList.size();j++){

                GouWuDataBean gouWuDataBean = shoppingCartList.get(j);
                if (gouWuDataBean.isChecked()) {
                    int count = gouWuDataBean.getCount();
                    double price = gouWuDataBean.getPrice();
                    double temp = count * price;
                    tob += temp;
                }
            }
        }
        heji_price.setText(tob+"");
    }


    @Override
    public void success(GouWuResult gouWuResult) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        gouwu_recycles.setLayoutManager(linearLayoutManager);
        List<GouWuListBean> result = gouWuResult.getResult();
        gouWuAdapter = new GouWuAdapter(result, getContext());
        gouwu_recycles.setAdapter(gouWuAdapter);
    }

    @Override
    public void fainal(String fainal) {

    }
}
