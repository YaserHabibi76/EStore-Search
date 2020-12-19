package Assignment2;

import java.util.Scanner;
import java.util.*;
import java.util.ArrayList;

/*
 * File name: Electronics.java
 * Author: Yaser Habibi
 * Function: An "eStore" will hold multiple kinds of products and allows us to add and search for them online.
    Electronics.java will help with electronic cases.

*/


public class Electronics extends Product {


    private String productId;
    private String description;
    private String price;
    private int year;
    private String maker;


    public Electronics (){

        // Initializing all values for Electronics
        setProductId(null);
        setDescription(null);
        setPrice(null);
        setYear(0);
        setMaker(null);

    }


    public Electronics (String productId, String description, String price, int year, String maker){
        this.productId = productId;
        this.description = description;
        this.price = price;
        this.year = year;
        this.maker = maker;

    }


    public void addTheElectronics (String productID, String Description, String Price, int Year, String Maker){
        products.add(new Electronics(productID, Description, Price, Year, Maker));


        //Add the electronics to the single products arraylist defined in EStoreSearch.java

        products.get(productIndex).setProductId(productID);
        products.get(productIndex).setDescription(Description);
        products.get(productIndex).setPrice(Price);
        products.get(productIndex).setYear(Year);
        products.get(productIndex).setAuthors(Maker);
        productIndex++;

    }


    // Overriding toString function from super class (Product.java)
    @Override
    public String toString () {
        String output;
        output = (super.toString() +
                "\nMaker: "+ maker);
        return output;
    }


    //Test print function
    public void testPrint(ArrayList <Product>products){
        Product pducts = new Product();
        String des;
        String pid;

        //printing everything in products arraylist
        for (int i =0; i< products.size(); i++){
            pducts = products.get(i);
            System.out.println("HEYYYYY"+products.get(i));
            pid = pducts.getProductID();
            des = pducts.getDescription();
        }



    }

}
