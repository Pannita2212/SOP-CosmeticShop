package com.yesboxlab.lecture;

public class Lip extends Cosmetics {
    String brand, color;
    double size, price;

    public Lip() {

    }


    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
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

    public Lip(String cosmeticId, String name, String brand, double size, double price, int stock, String color) {
        super(cosmeticId, name, stock);
        this.brand =brand;
        this.size = size;
        this.price = price;
        this.color = color;
    }

}
