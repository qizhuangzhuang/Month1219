package com.bawei.month1219.mvp;

import com.bawei.month1219.base.BasePresent;
import com.bawei.month1219.bean.GouWuResult;


public class GouWuPresent extends BasePresent<GouWuContract.GouWuView> implements GouWuContract.GouWuPresent {

    private GouWuModel gouWuModel;

    @Override
    protected void initModel() {
        gouWuModel = new GouWuModel();
    }

    @Override
    public void GouWushow() {
        gouWuModel.GouWushow(new GouWuContract.GouWuModel.DataCallBack() {
            @Override
            public void success(GouWuResult gouWuResult) {
                getView().success(gouWuResult);
            }

            @Override
            public void fainals(String fainal) {
                getView().fainal(fainal);
            }
        });
    }
}
