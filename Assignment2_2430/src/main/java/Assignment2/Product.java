package Assignment2;

import java.util.Scanner;
import java.util.*;
import java.util.ArrayList;


/*
 * Program name:
 * Author: Yaser Habibi
 * Function:
*/


public class Product {

    private String productId;
    private String description;
    private String price;
    private int year;
    private String authors;
    private String yyear;
    private String publisher;
    private String maker;
    protected int productIndex = 0;
    public ArrayList <Product> products = new ArrayList<Product>();


    // 5 different constructors for Product Class
    public Product (ArrayList <Product> products) {
        this.products = products;
    }


    public Product () {

    }


    public Product (String productId){
        this.productId = productId;
    }


    public Product (String productId, String description, String price, int year, String maker){
        this.productId = productId;
        this.description = description;
        this.price = price;
        this.year = year;
        this.maker = maker;
    }


    public Product (String productId, String description, String price, int year){
	this.productId = productId;
	this.description = description;
	this.price = price;
	this.year = year;

    }

    public Product (String productId, String description, String price, String yyear, String maker){

        this.productId = productId;
        this.description = description;
        this.price = price;
        this.yyear = yyear;
        this.maker = maker;

    }


    public Product (String productId, String description, String price, int year, String authors, String publisher) {
        this.productId = productId;
        this.description = description;
        this.price = price;
        this.year = year;
        this.authors = authors;
        this.publisher = publisher;
    }

    // getters and setters
    public void setProductId (String productId){
        this.productId = productId;
    }
    public String getProductID (){
        return productId;
    }

    public void setDescription (String description){
        this.description = description;
    }
    public String getDescription (){
        return description;
    }

    public void setPrice (String price){
        this.price = price;
    }
    public String getPrice (){
        return price;
    }

    public void setYear (int year){
        this.year = year;
    }
    public int getYear (){
        return year;
    }

    public void setAuthors (String authors){
        this.authors = authors;
    }
    public String getAuthors (){
        return authors;
    }

    public void setPublisher (String publisher){
        this.publisher = publisher;
    }
    public String getPublisher (){
        return publisher;
    }

    public void setMaker (String maker){
        this.maker = maker;
    }
    public String getMaker (){
        return maker;
    }

    public String toString () {

        if (maker == null){
            maker = "";
        }
        if (publisher == null){
            publisher = "";
        }
        if (authors == null){
            authors = "";
        }
        String output = ("ProductID: " +productId +
                        "\nDescription: "+description +
                        "\nYear: "+year +
                        "\nPrice: " +price +
                        "\nMaker: " +maker +
                        "\nPublisher: " +publisher +
                        "\nAuthor: " +authors);
        return output;
    }







    public void fileRTest(){  // DELETE LATER...... ONLY FOR TESTING PURPOSES
        System.out.println("BEGINNING OF FILE READ TEST");


        for (int i = 0; i < products.size(); i++){
            System.out.println(products.get(i));
            System.out.println();

        }


        System.out.println("END OF FILE READ TEST");

    }




    // ONLY FOR TESTING PURPOSES
    public void testPrint (String productID, String description, String price, int year, String maker){
        Product mmm = new Product (productID, description, price, year, maker);
        System.out.println("testPrinting with proper form (electronics): "+ mmm.getProductID());
        System.out.println();
    }



    public void searching (String searchProductId, String searchDescription, String searchYear ){

        String pid;
        String dest[];
        String des;
        int yr;

        Product pducts = new Product(products);
        boolean boolArray [] = new boolean [3];
        String searchDescriptionArr[] = searchDescription.split("[, ]+");
        String [] param = {"ProductID", "Description",  "Year"};

        String subString;
        String secondSubString;
        int secondSubStringInt;
        int subStringInt;

        boolArray[0] = false;
        boolArray[1] = false;
        boolArray[2] = false;




        for (int i =0; i < products.size(); i++){
            pducts = products.get(i);
            //System.out.println("HEYYYYY"+products.get(i));
            pid = pducts.getProductID();
            des = pducts.getDescription();
            // splitting string by space and commas
            dest = des.split("[, ]+");
            yr = pducts.getYear();

            System.out.println();

            if (pid.contains(searchProductId)){
                boolArray[0] = true;

            }

            if (searchDescription.isEmpty()){
                boolArray[1] = true;

            }

            for (int y =0; y<dest.length; y++){
                for (int z =0; z< searchDescriptionArr.length; z++){
                    if (searchDescriptionArr[z].contains(dest[y])){
                        boolArray[1] = true;

                    }
                }

                if (boolArray[1] == false){
                    y=100000000;
                }
            }



            int intSearchYear = searchYear.length();

            if (yr == intSearchYear){
                boolArray[2] = true;
            }

            else if (searchYear.isEmpty()){
                boolArray[2] = true;
            }

            else {
                if (searchYear.contains("-")) {

                    if (searchYear.charAt(0) == '-') {

                        int tempYear = Integer.parseInt(searchYear.substring(1));

                        System.out.println(products.get(i).getYear());
                        System.out.println(tempYear);

                        if (tempYear >= products.get(i).getYear()){
                            System.out.println("BEFORE: "+boolArray[2]);

                            boolArray[2] = true;
                            System.out.println("AFTER: "+boolArray[2]);
                        }
                    }
                    else if (searchYear.length() == 9){
                        int temp1 = Integer.parseInt(searchYear.substring(0,4));
                        int temp2 = Integer.parseInt(searchYear.substring(5));
                        System.out.println(temp1);
                        System.out.println(temp2);

                        if (temp1 <= products.get(i).getYear() && temp2 >= products.get(i).getYear()){

                            boolArray[2] = true;

                        }
                    }

                    else if (searchYear.length() == 5){
                        int tempYear = Integer.parseInt(searchYear.substring(0,4));
                        if (tempYear <= products.get(i).getYear()){
                            boolArray[2] = true;
                        }
                    }
                }
            }

            int yrNumber = yr;




            if(searchProductId.isEmpty()){
                boolArray[0] = true;
            }



            System.out.println();
            System.out.println("FIRST: "+ boolArray[0]);
            System.out.println("SECOND: "+boolArray[1]);

            System.out.println("THIRD: "+boolArray[2]);
            System.out.println();


            if ((boolArray[0] ==true) &&  (boolArray[1] ==true) && (boolArray[2] ==true)){

                System.out.println("yooooo"+products.get(i)); // there used to be a '.tostring' after the 'get(i)'

            }
            boolArray[0] = false;
            boolArray[1] = false;
            boolArray[2] = false;

        }
    }


}
