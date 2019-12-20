package com.bawei.month1219.bean;

import java.io.Serializable;
import java.util.List;

public class GouWuResult implements Serializable {
    private String message;
    private String status;
    private List<GouWuListBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<GouWuListBean> getResult() {
        return result;
    }

    public void setResult(List<GouWuListBean> result) {
        this.result = result;
    }
}
