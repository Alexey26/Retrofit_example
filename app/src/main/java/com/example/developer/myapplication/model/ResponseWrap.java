package com.example.developer.myapplication.model;


import java.util.ArrayList;

public class ResponseWrap {
    private ArrayList<User> data;

    public ResponseWrap(ArrayList<User> data) {
        this.data = data;
    }

    public ArrayList<User> getData() {
        return data;
    }

    public void setData(ArrayList<User> data) {
        this.data = data;
    }
}
