package com.example.pfe.models;

public class station {
    public String Longx;
    public String LongY;
    public station() {
    }
    public station(String longx, String longY) {
        Longx = longx;
        LongY = longY;
    }

    public String getLongx() {
        return Longx;
    }

    public void setLongx(String longx) {
        Longx = longx;
    }

    public String getLongY() {
        return LongY;
    }

    public void setLongY(String longY) {
        LongY = longY;
    }


}
