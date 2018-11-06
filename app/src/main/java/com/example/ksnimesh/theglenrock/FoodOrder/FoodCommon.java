package com.example.ksnimesh.theglenrock.FoodOrder;

import com.example.ksnimesh.theglenrock.Model.User;
import com.example.ksnimesh.theglenrock.Sign_In;

public class FoodCommon {
    public static User currentUser;

    public static final String DELETE="Delete";



    public  static final String UPDATE ="Update";
    //public  static final String DELETE ="Delete";


    public static  String convertCodeToStatus(String status) {
        if(status.equals( "0" )){
            return  "Placed";
        }
        else if(status.equals( "1" )) {
            return "On my way";
        }
        else
        {return "Issued Your Order";}
    }

}
