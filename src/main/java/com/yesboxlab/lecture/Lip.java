package com.yesboxlab.lecture;

public class Lip extends Cosmetics {
    String brand, color;
    double price;

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


    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public Lip(String cosmeticId, String name, String brand, double price, int stock, String color, String category) {
        super(cosmeticId, name, stock, category);
        this.brand =brand;
        this.price = price;
        this.color = color;
    }

}
