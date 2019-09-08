package com.yesboxlab.lecture;

import java.io.*;
import java.util.LinkedList;

public class SingletonCosmetic {
    private static SingletonCosmetic INSTANCE;
    private LinkedList<Cosmetics> cosmetics = new LinkedList<>();

    public SingletonCosmetic() {
    }

    //    getter and setter
    public Cosmetics getCosmetics(int index) {
        readFile();
        return cosmetics.get(index);
    }
    public void setCosmetics(LinkedList<Cosmetics> cosmetics) {
        this.cosmetics = cosmetics;
    }
    //

    //Check INSTANCE
    public static SingletonCosmetic getInstance(){
        if(INSTANCE == null) {
            INSTANCE = new SingletonCosmetic();
        }
        return INSTANCE;
    }

    private void readFile() {
        try{
            FileInputStream f = new FileInputStream(new File("Cosmetics.txt"));
            ObjectInputStream o = new ObjectInputStream(f);
            cosmetics = (LinkedList<Cosmetics>) o.readObject();
            o.close(); f.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public LinkedList<Cosmetics> getAllCosmetics() {
        readFile();
        return cosmetics;
    }

    public void createCosmetic(Cosmetics cosmetic){
        try{
            FileOutputStream f = new FileOutputStream(new File("Cosmetics.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);
            cosmetics.add(cosmetic);
            o.writeObject(cosmetics);
            o.close(); f.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateCosmetic(int index, Cosmetics cosmetic){
        try{
            FileOutputStream f = new FileOutputStream(new File("Cosmetics.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            cosmetics.get(index).setCosmeticId(cosmetic.getCosmeticId());
            cosmetics.get(index).setName(cosmetic.getName());
            cosmetics.get(index).setStock(cosmetic.getStock());
            o.writeObject(cosmetic);
            o.close(); f.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void delCosmetic(int index){
        try{
            FileOutputStream f = new FileOutputStream(new File("Cosmetics.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);
            cosmetics.remove(index);
            o.writeObject(cosmetics);
            o.close(); f.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
