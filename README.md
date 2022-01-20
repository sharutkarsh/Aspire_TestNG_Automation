# Aspire_TestNG_Automation

Steps to run this project on your system.

1. Firstly git pull this code on your system.
2. Now import/open this maven project on your Eclipse IDE
3. Expand the Aspire Test project on left side File Explorer
4. Now go to src/main/java
5. Run the AspireTest.java file 
6. It will launch the browser and run the automated test
7. At Bottom console tab will be there on IDE, there we can see the all the steps of the automation covered and the logs
8. Just next tab on Console there is, TestNG Result tab  where we can see the TestNG Test Case Results as pass and fail
9. On Project Explorer we can go to test-output folder where we can find the index.html report for the test run


I have divided these test steps in 2 parts 

@Test
public void Creating_New_Product()  = >> it contains selenium actions to launch url and create a product and update its quantity

//1. Login to web application
//2. Navigate to `Inventory` feature
//3. From the top-menu bar, select `Products -> Products` item, then create a new product
//4. Update the quantity of new product is more than 10


@Test (dependsOnMethods={"Creating_New_Product"})
	public void Creating_Manufacturing_Order_for_the_created_product()  = >> it contains selenium actions to create manufacturing orders for the product created

//5. From top-left page, click on `Application` icon
//6. Navigate to `Manufacturing` feature, then creating a new Manufacturing Order item for the created Product on step #3
//7. Update the status of new Orders to “Done” successfully
//8. Validate the new Manufacturing Order is created with corrected information.


Also, I have created 2 java files :

AspireTest.java  -- it contains the java selenium testNG code.
Locators.java  --  It contains all the xPath locators of all the elements used in this automated test.




