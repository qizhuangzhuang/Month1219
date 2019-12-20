package com.bawei.month1219.base;

import java.lang.ref.WeakReference;

/*
 *@Auther:祁壮壮
 *@Date: 2019/12/19
 *@Time:19:29
 *@Description功能: * */
public abstract class BasePresent<V extends IBaseView> {
    private WeakReference<V> weakReference;

    public BasePresent() {
        initModel();
    }

    protected abstract void initModel();


    public void attach(V v){
        weakReference = new WeakReference<>(v);
    }
    //与视图分离
    public void detch(){
        if (weakReference!=null){
            weakReference.clear();
            weakReference=null;
        }
    }
    //返回view
    public V getView(){
        V v1 = weakReference.get();
        return v1;
    }
}
