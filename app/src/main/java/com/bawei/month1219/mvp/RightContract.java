package com.bawei.month1219.mvp;



import com.bawei.month1219.base.IBaseView;
import com.bawei.month1219.bean.RightResultBean;

import java.util.Map;

public interface RightContract {
    interface RightView extends IBaseView {
        void success(RightResultBean rightResultBean);
        void fainal(String fainal);
    }
    interface RightModel{
        void RightShow(Map<String, String> map, DataCallBack dataCallBack);
        interface DataCallBack{
            void success(RightResultBean rightResultBean);
            void fainal(String fainal);
        }
    }
    interface RightPresent{
        void RightShow(Map<String, String> map);
    }
}
