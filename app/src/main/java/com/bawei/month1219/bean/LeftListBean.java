package com.bawei.month1219.bean;

import java.util.List;

public class LeftListBean {
    private String id;
    private String name;
    private List<LeftDataBean> secondCategoryVo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<LeftDataBean> getSecondCategoryVo() {
        return secondCategoryVo;
    }

    public void setSecondCategoryVo(List<LeftDataBean> secondCategoryVo) {
        this.secondCategoryVo = secondCategoryVo;
    }
}
