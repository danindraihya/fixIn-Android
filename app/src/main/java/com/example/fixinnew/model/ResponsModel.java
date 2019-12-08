package com.example.fixinnew.model;

import java.util.List;

public class ResponsModel {

    String status, message;
    List<DataModel> Data;

    public List<DataModel> getData() {
        return Data;
    }

    public void setData(List<DataModel> data) {
        Data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
