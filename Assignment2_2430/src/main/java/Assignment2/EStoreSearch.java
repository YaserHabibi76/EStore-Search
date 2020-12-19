package Assignment2;

import java.util.Scanner;
import java.util.*;
import java.util.ArrayList;

import java.io.PrintWriter; // write to text file
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


/*
 * Program name: EStoreSearch.java
 * Author: Yaser Habibi
 * Function: An "eStore" will hold multiple kinds of products and allows us to add and search for them online
*/

public class EStoreSearch {


    private static ArrayList<Product> products = new ArrayList<Product>();


    public EStoreSearch (ArrayList<Product> products){
        this.products = products;
    }


    public static void fileRead (String fileName){
        String Type;
        String ProductId;
        String Description;
        String Price;
        String Year;
        String Author;
        String Publisher;
        String Maker;


        Scanner inputStream = null;
        try {
            inputStream = new Scanner(new FileInputStream(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("the file was not there");
        }
        String fileLine = null;


    try{
        while (inputStream.hasNextLine()) {
            fileLine = inputStream.nextLine();

            if (fileLine.contains("type") && fileLine.length() != 0) {


                // substring is the type (Book or Electroncics), withOUT everything, including the quotations
                Type = fileLine.substring(8, fileLine.length() - 1);


                //parsing productId
                fileLine = inputStream.nextLine();
                ProductId = fileLine.substring(13, fileLine.length() - 1);


                //parsing description
                fileLine = inputStream.nextLine();
                Description = fileLine.substring(15, fileLine.length() - 1);


                //parsing price
                fileLine = inputStream.nextLine();
                Price = fileLine.substring(9, fileLine.length() - 1);

                Double PriceDouble = 0.0;
                try {
                    PriceDouble = Double.parseDouble(Price);
                } catch (NumberFormatException e) {
                    System.out.println("InValid Formatting");
                }


                //parsing year
                fileLine = inputStream.nextLine();
                Year = fileLine.substring(8, fileLine.length() - 1);

                int YearInt = 0;
                try {
                    YearInt = Integer.parseInt(Year);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid year from the file");
                }

                // performing book specific operations
                if (Type.equalsIgnoreCase("book")) {

                    //parsing author
                    fileLine = inputStream.nextLine();
                    Author = fileLine.substring(11, fileLine.length() - 1);

                    //parsing publisher
                    fileLine = inputStream.nextLine();
                    Publisher = fileLine.substring(13, fileLine.length() - 1);



                    try{

                        String s=String.valueOf(PriceDouble);
                        Product addProduct = new Product(ProductId, Description, s, YearInt, Author, Publisher);

                        products.add(addProduct);

                        Description = Description.toLowerCase();


                    } catch (Exception error){
                        System.out.println("Error adding products from file to arraylist..");

                    }


                // performing electronics specific operations
                } else if (Type.equalsIgnoreCase("electronics")) {

                    fileLine = inputStream.nextLine();
                    Maker = fileLine.substring(9, fileLine.length() - 1);

                    try{

                        String s=String.valueOf(PriceDouble);
                        Product addProduct = new Product(ProductId, Description, s, YearInt, Maker);
                        products.add(addProduct);
                        Description = Description.toLowerCase();
                    }catch(Exception error){
                        System.out.println("Error adding products from file to arraylist..");

                    }

                }

            }

        }
    } catch (Exception e){
        System.out.println("System Error: File was not read in properly...Terminating Program");
        System.exit(0);
    }
        System.out.println("File was read in properly :)");
        System.out.println();

        Product fileReadTest = new Product (products); // DELETE BEFORE SUBMITTING
        fileReadTest.fileRTest(); // DELETE BEFORE SUBMITTING


    }











    public static void main (String [] args){

        Scanner scan = new Scanner(System.in);

        boolean continueQuestions = true;
        String asqAnswer;
        String BookOrElec;


        String BookProductId;
        String BookDescription;
        String BookYear;
        String BookAuthor;
        String BookPublisher;

        //search variables
        String searchProductId;
        String searchDescription;
        String searchPrice;
        String searchYear;
        String searchAuthor;
        String searchPublisher;
        String searchMaker;

        int i=0;
        boolean searchFound = false;

        String fileName = "test.txt";
        fileRead(fileName);


        // Ask user to add, search, or quit program infinitly
        while (continueQuestions){
            System.out.println("Would you like to add, search, or quit? (add, search, quit):");
            asqAnswer = scan.nextLine();

            if (asqAnswer.equalsIgnoreCase("add")){
                System.out.println("Book or electronics? (Book, Electronics)");
                BookOrElec = scan.nextLine();

                if (BookOrElec.equalsIgnoreCase("Book")){

                    boolean proIdChecker = true;
                    boolean descriptionChecker = true;
                    boolean yearChecker = true;
                    int counter =0;
                    boolean duplicate = false;
                    String pid;

                    int yearStringToInt;


                    String productID;
                    String Description = "";
                    String des22;
                    String Author;
                    int Year;
                    String Publisher;
                    String Price;
                    int ccounter =0;
                    boolean productIdChecker = false;


                    System.out.println("Enter the productID: (6 digits) ");
                    productID = scan.nextLine();

                    Product bb = new Product();



                    // Error checking user input for productID's
                    for (int m =0; m< productID.length(); m++){
                        while ( (productID.length() != 6) || (productID.charAt(m) < '0') || (productID.charAt(m) > '9') ){
                            System.out.println();
                            System.out.println("Warning: productID must be 6 DIGITS long");

                            System.out.println("Please enter the productID Again (6 digits only): ");
                            productID = scan.nextLine();

                        }

                        // Error checking for duplicates.... keep asking until not duplicate ProductID
                        for (int x =0; x< products.size(); x++){

                            bb = products.get(x);
                            pid = bb.getProductID();

                            if (pid.equals(productID)){
                                System.out.println("Warning: duplicate productID's are not allowed");
                                duplicate = true;
                            }

                            while (duplicate ==true){
                                System.out.println("Please enter a new productID to add");
                                productID = scan.nextLine();
                                if (!(pid.equals(productID))){
                                    duplicate = false;
                                }

                            }

                        }

                    }


                    // If product ID is properly entered, continue with other questions
                    while(!duplicate){

                        // boolean checker for productID
                        if (productID.length() != 0){
                            proIdChecker = false;
                        }

                        // Error checking for the description entered. Description must be entered
                        while(descriptionChecker==true){

                            System.out.println("Enter description: ");
                            Description = scan.nextLine();

                            if (Description.length() != 0){
                                descriptionChecker = false;
                            }
                            else if (Description.length() == 0){
                                descriptionChecker = true;
                                System.out.println("Description must be entered!");

                            }
                        }

                        // Enter price of product
                        System.out.println("Enter price: ");
                        Price = scan.nextLine();


                        Year =0;

                        try {
                            //Error checking for year, must be a numerical value between 1000-9999
                            //Keep asking until correct input. If not integers values entered, terminate program
                            System.out.println("Enter year: ");
                            Year = scan.nextInt();
                            scan.nextLine();

                            while (!(Year >= 1000  &&  Year <= 9999)){
                                System.out.println("Warning: Year must be between 1000-9999...Please Try Again!");
                                Year = scan.nextInt();
                                scan.nextLine();
                            }

                        } // Exception handling
                        catch(Exception e) {
                            System.out.println("You did not enter an integer value for year... Terminating Program");
                            System.exit(0);

                        }




                        System.out.println("Enter author (or press enter if not applicable): ");
                        Author = scan.nextLine();


                        System.out.println("Enter publisher (or press enter if not applicable): ");
                        Publisher = scan.nextLine();

                        duplicate = true;

                        // add the book product to the single products arrayList
                        Product bkTmp = new Product( productID, Description, Price, Year, Author, Publisher);
                        products.add(bkTmp);




                    }




                }

                // If user chooses to add electronics to the single products ArrayList
                else if ((BookOrElec.equalsIgnoreCase("Electronics")) || (BookOrElec.equalsIgnoreCase("electronic"))){

                    boolean proIdChecker = true;
                    boolean descriptionChecker = true;
                    boolean yearChecker = true;
                    int counter =0;
                    boolean duplicate = false;
                    String pid;
                    boolean pidcorrection = true;

                    Electronics eq = new Electronics();
                    Book bb = new Book();
                    int yearStringToInt;


                    String Maker;
                    String productID;
                    String Description = "";
                    int Year=0;
                    String Price;



                    System.out.println("Enter productID: ");
                    productID = scan.nextLine();

                    // Error checking user input for productID's
                    for (int m =0; m< productID.length(); m++){
                        while ( (productID.length() != 6) || (productID.charAt(m) < '0') || (productID.charAt(m) > '9') ){
                            System.out.println();
                            System.out.println("Warning: productID must be 6 DIGITS long");

                            System.out.println("Please enter the productID Again (6 digits only): ");
                            productID = scan.nextLine();

                        }

                    }



                    Product bbb = new Product();

                    // Ensuring productID is new, since duplicate productID's are not allowed
                    // This will check productID's for both books and electronics
                    for (int z =0; z< products.size(); z++){

                        bbb = products.get(z);
                        pid = bbb.getProductID();

                        if (pid.equals(productID)){
                            System.out.println("Warning: duplicate productID's are not allowed");
                            duplicate = true;
                        }

                        while (duplicate ==true){
                            System.out.println("Please enter a new productID to add");
                            productID = scan.nextLine();
                            if (!(pid.equals(productID))){
                                duplicate = false;
                            }

                        }

                    }








                    while(!duplicate){

                        if (productID.length() != 0){
                            proIdChecker = false;
                        }
                        // Error checking for the description entered
                        while(descriptionChecker==true){

                            System.out.println("Enter description: ");
                            Description = scan.nextLine();

                            if (Description.length() != 0){
                                descriptionChecker = false;
                            }
                            else if (Description.length() == 0){
                                descriptionChecker = true;
                                System.out.println("Description must be entered!");

                            }
                        }


                        System.out.println("Enter price: ");
                        Price = scan.nextLine();


                        //Error checking for year
                        //Will continue to loop through until valid year is entered (1000-9999)
                        //If non-nemerical values are entered, then terminate program

                        try{
                            System.out.println("Enter year: ");
                            Year = scan.nextInt();
                            scan.nextLine();

                                while (!(Year >= 1000  &&  Year <= 9999)){
                                    System.out.println("Warning: Year must be between 1000-9999...Please Try Again!");
                                    Year = scan.nextInt();
                                    scan.nextLine();
                                }

                        } catch(Exception e) {
                            System.out.println("You did not enter an integer value for year... Terminating Program");
                            System.exit(0);

                        }





                        System.out.println("Enter Maker (or press enter if not applicable): ");
                        Maker = scan.nextLine();




                        duplicate = true;
                        // add the product to the single products arraylist
                        Product bcTmp = new Product( productID, Description, Price, Year, Maker);
                        products.add(bcTmp);


                        //test printing
                        bcTmp.testPrint(productID, Description, Price, Year, Maker); // DELETE BEFORE SUBMITTING


                    }


                }


            }

            else if ((asqAnswer.equalsIgnoreCase("search"))){


                // Ask user for productID, description, year.... pass the values into search function
                System.out.println("Enter productId to search (or press enter if not applicable)");
                searchProductId = scan.nextLine();

                System.out.println("Enter description to search (or press enter if not applicable)");
                searchDescription = scan.nextLine();


                System.out.println("Enter year to search (or press enter if not applicable)");
                searchYear = scan.nextLine();

                Product search = new Product (products);
                //call the searching function passing the desired search values
                search.searching(searchProductId, searchDescription, searchYear);

            }







            // quit options for the user... this will terminate the program
            else if ((asqAnswer.equalsIgnoreCase("Quit")) || (asqAnswer.equalsIgnoreCase("bye")) || (asqAnswer.equalsIgnoreCase("Goodbye")) ||
                        (asqAnswer.equalsIgnoreCase("Q")) || (asqAnswer.equalsIgnoreCase("exit"))){
                System.out.println();
                System.out.println("Thank you for coming :)");
                System.out.println("Bye Now");
                continueQuestions = false;
                System.exit(0);

            }

        }
    }
}
