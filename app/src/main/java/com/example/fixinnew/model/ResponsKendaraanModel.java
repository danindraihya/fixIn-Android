package com.example.fixinnew.model;

import java.util.List;

public class ResponsKendaraanModel {

    String status;
    List<DataKendaraanModel> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<DataKendaraanModel> getData() {
        return data;
    }

    public void setData(List<DataKendaraanModel> data) {
        this.data = data;
    }
}
