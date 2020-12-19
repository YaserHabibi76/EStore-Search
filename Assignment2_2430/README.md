************************************************************
                    Name: Yaser Habibi
                 nStudent Number: 1091939
                Email: yhabibi@uoguelph.ca
************************************************************




This java projects constructs a store storing books and electroics. Both Books and 
Electronics have their own unique properties. The user has the option to add/ search for books and electronics. This assignment uses inheritance, objects, different classes, hashmaps, arrays, File I/O, Gradle, and JUNIT testing. 




************************************************************
                Assumptions and Limitations
************************************************************

- User must enter a product ID with 6 digits. all other numbers will be rejected
- Product Year must be within 1000-9999, all other years will be rejected
- Duplicate product ID's will be rejected
- When searching, user is allowed to leave all search options blank
    - In this case, all products will be shown



************************************************************
                   How To run the program
************************************************************

When compiling, JUNIT testing will automatically occur. 

Compile: gradle build
Run: gradle run 
Testing program with JUNIT: gradle test
Clean program and delete compiled classes: gradle clean



************************************************************
                    Test Plan for Project
************************************************************

- Ensuring that all User Input is crash proof
- Some Error Check include, but not limited to
    - Exception Handling for reading in file
    - Ensuring that all products are read in correctly
    - Ensuring that only accurate productID's are stored (6 digits, no duplicates)
    - Ensured that the description entered for the products are not empty
    - Ensured that the year entered is between 1000-9999
        - Error handling for all other inputs
    - Multiple error handling cases dealt with in searching methods.
        - Lots of emphasis on testing search year for products
        - Dealt with all user input cases
            - If user inputs incorrect format. I put the search as default showing all  products that match a blank year case while also matching the other cases




************************************************************
                        Improvements
************************************************************

I would add more products to this store. However I will do this in a more efficient way to avoid code redunancy. I would also create more methods to shrink the length of code located in the main method.