package com.example.fixinnew.model;

import java.util.List;

public class ResponsModelFotoBengkel {

    String status, message;
    List<FotoBengkelModel> data;

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

    public List<FotoBengkelModel> getData() {
        return data;
    }

    public void setData(List<FotoBengkelModel> data) {
        this.data = data;
    }
}
