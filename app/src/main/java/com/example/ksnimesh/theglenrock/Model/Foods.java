package com.example.ksnimesh.theglenrock.Model;

import com.google.firebase.database.Query;

public class Foods {
    private  String Name;
    private  String Image ;
    private String Description;
    private String Price;
    private String Discount;
    private String MenuID;

    public Foods(String name, String image, String description, String price, String discount, String menuID) {
        Name = name;
        Image = image;
        Description = description;
        Price = price;
        Discount = discount;
        MenuID = menuID;
    }

    public Foods() {

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public  String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getDiscount() {
        return Discount;
    }

    public void setDiscount(String discount) {
        Discount = discount;
    }

    public String getMenuID() {
        return MenuID;
    }

    public void setMenuID(String menuID) {
        MenuID = menuID;
    }

    public static Query orderByChild(String menuID) {
        return null;
    }
}
