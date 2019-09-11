package com.yesboxlab.lecture;

public class Foundation extends Cosmetics {
    String brand, skin;
    double price;

    public Foundation(String cosmeticId, String name, String brand, double price, int stock, String skin, String category) {
        super(cosmeticId, name, stock, category);
        this.brand =brand;
        this.price = price;
        this.skin = skin;
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
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
