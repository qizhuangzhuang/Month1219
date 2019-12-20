package com.bawei.month1219.mvp;


import com.bawei.month1219.base.BasePresent;
import com.bawei.month1219.bean.LeftResultBean;

public class LeftPresnet extends BasePresent<LeftContract.LeftView> implements LeftContract.LeftPresent {

    private Model model;

    @Override
    protected void initModel() {
        model = new Model();
    }

    @Override
    public void show() {
        model.show(new LeftContract.LeftModel.DataCallBack() {
            @Override
            public void success(LeftResultBean leftResultBean) {
                getView().success(leftResultBean);
            }

            @Override
            public void fainals(String fainal) {
                    getView().fainal(fainal);
            }
        });

    }
}
