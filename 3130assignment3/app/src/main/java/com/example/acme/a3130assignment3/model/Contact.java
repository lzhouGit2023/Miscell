package com.example.acme.a3130assignment3.model;

import java.io.Serializable;

/*
Simple POJO class to hold Contact information
in Realtime database or Firestore database
 */
//We added more fields which are the other strings listed here besides name, email and id
public class Contact implements Serializable {

    public String id = "";
    public String name = "";
    public String email = "";
    public String businessNumber = "";//create new layouts accordingly
    public String business = "";
    public String address = "";
    public String provinceOrTerritory = "";

    public  Contact()
    {

    }

    public Contact(String name, String email, String business, String address, String businessNumber
            , String provinceOrTerritory)
    {
        this.name = name;
        this.email = email;
        this.business = business;
        this.address = address;
        this.businessNumber = businessNumber;
        this.provinceOrTerritory = provinceOrTerritory;

    }


    @Override
    public String toString()
    {
        return "Name: " + name + " e-mail: " + email;
    }//add other fields as well
}


