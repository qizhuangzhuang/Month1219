package com.bawei.month1219.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;


import com.bawei.month1219.R;
import com.bawei.month1219.adapter.LeftAdapter;
import com.bawei.month1219.adapter.RightAdapter;
import com.bawei.month1219.base.BaseFragment;
import com.bawei.month1219.bean.LeftDataBean;
import com.bawei.month1219.bean.LeftListBean;
import com.bawei.month1219.bean.LeftResultBean;
import com.bawei.month1219.bean.RightDataBean;
import com.bawei.month1219.bean.RightResultBean;
import com.bawei.month1219.mvp.LeftContract;
import com.bawei.month1219.mvp.LeftPresnet;
import com.bawei.month1219.mvp.RightContract;
import com.bawei.month1219.mvp.RightPresent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.HashMap;
import java.util.List;

public class FenLeiFragMent extends BaseFragment<LeftPresnet> implements LeftContract.LeftView, RightContract.RightView {

    private RecyclerView left_recycles;
    private RecyclerView right_recycles;
    private RightPresent rightPresent;
    HashMap<String, String> map = new HashMap<>();
    private RightAdapter rightAdapter;

    @Override
    protected int initLayout() {
        return R.layout.fenelei;
    }

    @Override
    protected void initView(View view) {
        left_recycles = (RecyclerView) view.findViewById(R.id.left_recycles);
        right_recycles = (RecyclerView) view.findViewById(R.id.right_recycles);
    }

    @Override
    protected LeftPresnet initPresnet() {
        return new LeftPresnet();
    }


    @Override
    protected void initData(Bundle savedInstanceState) {
         presents.show();
         //注册
         EventBus.getDefault().register(this);
        rightPresent = new RightPresent();
        //疑问
        rightPresent.attach(this);
        map.put("page","1");
        map.put("count","5");
        map.put("categoryId","1001004002");
        rightPresent.RightShow(map);
//疑问

    }
    public void  initStart(){

        map.put("page","1");
        map.put("count","5");
        map.put("categoryId",categoryId);
        rightPresent.RightShow(map);

    }

    private String categoryId;
    @Subscribe
    public void JieQu(LeftDataBean leftDataBean){
        rightAdapter.clear();
        categoryId = leftDataBean.getId();
        initStart();
    }



    @Override
    public void success(LeftResultBean leftResultBean) {
        List<LeftListBean> result = leftResultBean.getResult();
        LeftListBean leftListBean = result.get(0);
        List<LeftDataBean> secondCategoryVo = leftListBean.getSecondCategoryVo();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        left_recycles.setLayoutManager(linearLayoutManager);
        LeftAdapter leftAdapter = new LeftAdapter(secondCategoryVo, getContext());
        left_recycles.setAdapter(leftAdapter);
    }

    @Override
    public void success(RightResultBean rightResultBean) {
        List<RightDataBean> result = rightResultBean.getResult();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        right_recycles.setLayoutManager(linearLayoutManager);
        rightAdapter = new RightAdapter(result, getContext());
        right_recycles.setAdapter(rightAdapter);

        rightAdapter.notifyDataSetChanged();
    }
   //问题
    @Override
    public void fainal(String fainal) {

    }
}
