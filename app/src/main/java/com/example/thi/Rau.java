package com.example.thi;

public class Rau {
    private String marau;
    private String tenrau;
    private String gia;
    public Rau(String marau, String tenrau, String gia) {
        this.marau = marau;
        this.tenrau = tenrau;
        this.gia = gia;
    }

    public Rau() {

    }

    public String getMarau() {
        return marau;
    }

    public void setMarau(String marau) {
        this.marau = marau;
    }

    public String getTenrau() {
        return tenrau;
    }

    public void setTenrau(String tenrau) {
        this.tenrau = tenrau;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;

    }

    @Override
    public String toString() {
        return marau + "  |   " +  tenrau;
    }
}
