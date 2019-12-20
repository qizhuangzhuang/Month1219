package com.bawei.month1219.mvp;


import com.bawei.month1219.base.IBaseView;
import com.bawei.month1219.bean.LeftResultBean;

public interface LeftContract {
    interface LeftView extends IBaseView {
        void success(LeftResultBean leftResultBean);
        void fainal(String fainal);
    }
    interface LeftModel{
        void show(DataCallBack dataCallBack);
        interface DataCallBack{
            void success(LeftResultBean leftResultBean);
            void fainals(String fainal);
        }
    }
    interface LeftPresent{
        void show();
    }
}
