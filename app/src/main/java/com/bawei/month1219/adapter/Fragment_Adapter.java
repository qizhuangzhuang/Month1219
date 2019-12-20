package com.bawei.month1219.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class Fragment_Adapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> flist;
    private ArrayList<String> slist;

    public Fragment_Adapter(FragmentManager fm, ArrayList<Fragment> flist, ArrayList<String> slist) {
        super(fm);
        this.flist = flist;
        this.slist = slist;
    }

    @Override
    public Fragment getItem(int i) {
        return flist.get(i);
    }

    @Override
    public int getCount() {
        return flist.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return slist.get(position);
    }
}
