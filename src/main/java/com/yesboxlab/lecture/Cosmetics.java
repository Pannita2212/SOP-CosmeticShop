package com.yesboxlab.lecture;

import java.io.Serializable;

public class Cosmetics implements Serializable {
    String cosmeticId, name, category;
    int stock;

    public String getCosmeticId() {
        return cosmeticId;
    }
    public void setCosmeticId(String cosmeticId) {
        this.cosmeticId = cosmeticId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public Cosmetics() {

    }

    //details about cosmetics
    public Cosmetics(String cosmeticId, String name, int stock, String category) {
        this.cosmeticId = cosmeticId;
        this.name = name;
        this.stock = stock;
        this.category = category;
    }

    public String buyCosmetics(int num) {
        if(this.stock == 0){
            return "Product out of stock";
        }else if(num>0 && num <= this.stock){
            this.stock -= num;
            return "You selected "+ this.name + " " + num +" piece(s)!!";
        }
        return "Order error!!!";
    }


}
