package com.yesboxlab.lecture;

public class Categories {
    String cat;

    public Cosmetics create(String cat){
        if(cat.equalsIgnoreCase("Lip")){
            return new Lip();
        }else if(cat.equalsIgnoreCase("Foundation")){
            return new Foundation();
        }
        return null;
    }
}


