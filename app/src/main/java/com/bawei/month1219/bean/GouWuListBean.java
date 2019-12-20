package com.bawei.month1219.bean;

import java.io.Serializable;
import java.util.List;

public class GouWuListBean implements Serializable {
    private String categoryName;
    private List<GouWuDataBean> shoppingCartList;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<GouWuDataBean> getShoppingCartList() {
        return shoppingCartList;
    }

    public void setShoppingCartList(List<GouWuDataBean> shoppingCartList) {
        this.shoppingCartList = shoppingCartList;
    }
}
