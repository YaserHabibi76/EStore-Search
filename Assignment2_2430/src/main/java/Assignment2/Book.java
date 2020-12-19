package Assignment2;

import java.util.Scanner;
import java.util.*;
import java.util.ArrayList;

/*
 * File name: Book.java
 * Author: Yaser Habibi
 * Function: An "eStore" will hold multiple kinds of products and allows us to add and search for them online.
    Book.java will help with book cases.
*/


public class Book extends Product {

    private String productId;
    private String description;
    private String price;
    private int year;
    private String authors;
    private String publisher;
    private String maker;

    public Book () {

        // Initializing all values for Electronics
        setProductId(null);
        setDescription(null);
        setPrice(null);
        setYear(0);
        setAuthors(null);
        setPublisher(null);

    }


    public Book (String productId, String description, String price, int year, String authors, String publisher){
            this.productId = productId;
            this.description = description;
            this.price = price;
            this.year = year;
            this.authors = authors;
            this.publisher = publisher;
            this.maker = maker;

    }

    //public Book (String productId, String description, String price, int year


    // Overriding toString function from super class (Product.java)
    @Override
    public String toString () {
        String output;
        output = (super.toString() +
                 "\nAuthors: "+ authors +
                 "\nPublishers: "+publisher);
        return output;
    }



    public void addTheBooks (String productID, String Description, String Price, int Year, String Authors, String Publisher){
        products.add(new Book(productID, Description, Price, Year, Authors, Publisher));

        //Add the electronics to the single products arraylist defined in EStoreSearch.java

        products.get(productIndex).setProductId(productID);
        products.get(productIndex).setDescription(Description);
        products.get(productIndex).setPrice(Price);
        products.get(productIndex).setYear(Year);
        products.get(productIndex).setAuthors(Authors);
        products.get(productIndex).setPublisher(Publisher);
        productIndex++;

    }

}
