package com.yesboxlab.lecture;

public class Foundation extends Cosmetics {
    String brand, skin, coverage;
    double size, price;

    public Foundation(String cosmeticId, String name, String brand, double size, double price, int stock, String skin, String coverage) {
        super(cosmeticId, name, stock);
        this.brand =brand;
        this.size = size;
        this.price = price;
        this.skin = skin;
        this.coverage = coverage;
    }

    public Foundation() {

    }

    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getSkin() {
        return skin;
    }
    public void setSkin(String skin) {
        this.skin = skin;
    }
    public String getCoverage() {
        return coverage;
    }
    public void setCoverage(String coverage) {
        this.coverage = coverage;
    }

    public double getSize() {
        return size;
    }
    public void setSize(double size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
