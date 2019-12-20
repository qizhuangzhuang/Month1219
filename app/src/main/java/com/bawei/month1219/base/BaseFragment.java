package com.bawei.month1219.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/*
 *@Auther:祁壮壮
 *@Date: 2019/12/19
 *@Time:19:32
 *@Description功能: * */
public abstract class BaseFragment<P extends BasePresent> extends Fragment implements IBaseView {
    public P presents;

    public BaseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(initLayout(), container, false);
    }

    protected abstract int initLayout();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    protected abstract void initView(View view);

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        presents=  initPresnet();
        presents.attach(this);
        initData(savedInstanceState);
    }

    protected abstract P initPresnet();

    protected abstract void initData(Bundle savedInstanceState);

    @Override
    public void onDestroy() {
        super.onDestroy();
        presents.detch();
    }
}