package com.bawei.month1219.mvp;

import com.bawei.month1219.base.BasePresent;
import com.bawei.month1219.bean.RightResultBean;


import java.util.Map;

public class RightPresent extends BasePresent<RightContract.RightView> implements RightContract.RightPresent{


    private RightModel rightModel;

    @Override
    protected void initModel() {
        rightModel = new RightModel();
    }

    @Override
    public void RightShow(Map<String, String> map) {
       rightModel.RightShow(map, new RightContract.RightModel.DataCallBack() {
           @Override
           public void success(RightResultBean rightResultBean) {
               getView().success(rightResultBean);
           }

           @Override
           public void fainal(String fainal) {
               getView().fainal(fainal);
           }
       });
    }
}
