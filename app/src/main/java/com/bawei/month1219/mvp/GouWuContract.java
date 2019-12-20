package com.bawei.month1219.mvp;


import com.bawei.month1219.base.IBaseView;
import com.bawei.month1219.bean.GouWuResult;

public interface GouWuContract {
    interface GouWuView extends IBaseView {
        void success(GouWuResult gouWuResult);
        void fainal(String fainal);
    }
    interface GouWuModel{
        void GouWushow(DataCallBack dataCallBack);
        interface DataCallBack{
            void success(GouWuResult gouWuResult);
            void fainals(String fainal);
        }
    }
    interface GouWuPresent{
        void GouWushow();
    }
}
