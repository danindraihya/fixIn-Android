package com.example.fixinnew.model;

import java.util.List;

public class ResponsLayanan {

    String status, message;
    List<DataLayanan> data;

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

    public List<DataLayanan> getData() {
        return data;
    }

    public void setData(List<DataLayanan> data) {
        this.data = data;
    }
}
