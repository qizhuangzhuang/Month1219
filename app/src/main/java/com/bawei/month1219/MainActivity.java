package com.bawei.month1219;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;


import com.bawei.month1219.adapter.Fragment_Adapter;
import com.bawei.month1219.fragment.FenLeiFragMent;
import com.bawei.month1219.fragment.GouWuFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TabLayout tablayouts;
    private ViewPager viewpge;
    private ArrayList<Fragment> flist;
    private ArrayList<String> slist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        flist = new ArrayList<>();
        slist = new ArrayList<>();
        slist.add("分类");
        slist.add("购物车");

        flist.add(new FenLeiFragMent());
        flist.add(new GouWuFragment());



        //开始写适配器

        Fragment_Adapter fragment_adapter = new Fragment_Adapter(getSupportFragmentManager(), flist, slist);
        viewpge.setAdapter(fragment_adapter);
        tablayouts.setupWithViewPager(viewpge);
    }

    private void initView() {
        tablayouts = (TabLayout) findViewById(R.id.tablayouts);
        viewpge = (ViewPager) findViewById(R.id.viewpge);
    }
}
