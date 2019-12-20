package com.bawei.month1219.bean;

import java.io.Serializable;

public class RightDataBean implements Serializable {
    private int commodityId;
    private String commodityName;
    private String masterPic;
    private int price;
    private double saleNum;

    public int getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(int commodityId) {
        this.commodityId = commodityId;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getMasterPic() {
        return masterPic;
    }

    public void setMasterPic(String masterPic) {
        this.masterPic = masterPic;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(double saleNum) {
        this.saleNum = saleNum;
    }
}
