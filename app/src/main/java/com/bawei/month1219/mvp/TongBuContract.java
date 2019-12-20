package com.bawei.month1219.mvp;

import com.bawei.month1219.base.IBaseView;




public interface TongBuContract {
    interface TongBu extends IBaseView {
        void success(TongBu tongBu);
        void fainal(String fainal);
    }
    interface TongBuModel{
        void TongBuShow(String data, DataCallBack dataCallBack);
        interface DataCallBack{
            void success(TongBu tongBu);
            void fainal(String fainal);
        }
    }
    interface TongBuPresent{
        void TongBuShow(String data);
    }
}
