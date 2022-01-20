import org.testng.annotations.Test;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;



public class AspireTest extends Locators
{
    //Objects and variables declared here
	Locators lo = new Locators();
	WebDriver driver;
	String url= "https://aspireapp.odoo.com/";
	String Account= "user@aspireapp.com";
	String Password = "@sp1r3app";
	public static String ProdName;


    //First Test Case
	@Test
	public void Creating_New_Product() throws InterruptedException
	{

		WebDriverWait wait = new WebDriverWait(driver, 100); 

		//1. Login to web application
		launch_URL();
		Thread.sleep(3000);
		System.out.println("--->> Logged in to the application");
		
		//2. Navigate to `Inventory` feature
		driver.findElement(By.xpath(lo.InventoryIcon)).click();
		System.out.println("--->> Navigate to `Inventory` feature");

		//3. From the top-menu bar, select `Products -> Products` item, then create a new product
		Random ran = new Random();
		int rn = ran.nextInt((1000 - 1) + 1) + 1; // using randon number to be added in Product name
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(lo.ProductsTab))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(lo.ProductsOption))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(lo.CreateProductButton))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(lo.ProductName))).sendKeys("Auto Test "+rn);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(lo.ProductSave))).click();
		ProdName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(lo.ProdNameStr))).getText();
        // saved the Product name created
		System.out.println("--->> New Product created = "+ProdName);

		//4. Update the quantity of new product is more than 10
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(lo.UpdateQuantity))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(lo.CreateButon))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(lo.QuantField))).clear();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(lo.QuantField))).sendKeys("95");// quantity is more than 10

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(lo.LocField))).sendKeys("Virtual");
		WebElement el = driver.findElement(By.xpath(lo.DropDwnloc));
		Actions action = new Actions(driver);
		action.moveToElement(el).click().perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(lo.VirtData))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(lo.ProductSave))).click();
		System.out.println("--->> Updated the quantity for the product");
		Thread.sleep(3000);
	}

    
	// Second Test Case
	@Test (dependsOnMethods={"Creating_New_Product"})
	public void Creating_Manufacturing_Order_for_the_created_product() throws InterruptedException
	{   
		WebDriverWait wait = new WebDriverWait(driver, 100); 

		//5. From top-left page, click on `Application` icon
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(lo.AppIcon))).click();
		System.out.println("--->> Clicked on `Application` icon");

		//6. Navigate to `Manufacturing` feature, then 
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(lo.ManufacturingIcon))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(lo.CreateButton))).click();
				
		//creating a new Manufacturing Order item for the created Product on step #3
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(lo.ManuProdName))).sendKeys(ProdName);//ProdName
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(lo.SearchedResult))).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(lo.ProdQuant))).clear();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(lo.ProdQuant))).sendKeys("11.00");
		
        //Adding a product line
		driver.findElement(By.xpath(lo.AddALine)).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(lo.ProdUOMquant))).clear();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(lo.ProdUOMquant))).sendKeys("111");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(lo.ProdLine))).sendKeys(ProdName);//ProdName
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(lo.ProdLinSearchRes))).click();
        //Saving and Confirming the manufacturing order
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(lo.ManuSave))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(lo.ConfirmButton))).click();
		Actions act = new Actions(driver);
		Thread.sleep(3000);
		WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(lo.ConfirmButton))); 
		act.doubleClick(ele).perform();//Double click on element
		System.out.println("--->> Navigated to `Manufacturing` and created Manufacturing order");
		
		//7. Update the status of new Orders to “Done” successfully
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(lo.MarkDone))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(lo.Apply))).click();
		System.out.println("--->> Updated the status of new Orders to Done");

		//8. Validate the new Manufacturing Order is created with corrected information.
		if (driver.findElement(By.xpath(lo.ManRef)).isDisplayed()==true &&
				driver.findElement(By.xpath(lo.prodName)).isDisplayed()==true	) 
		{
			System.out.println("--->> Validating the created Manufacturing order  : ");
			System.out.println("--->> Manufacturing order : "+ driver.findElement(By.xpath(lo.ManRef)).getText());
			System.out.println("--->> Product Name : "+ driver.findElement(By.xpath(lo.prodName)).getText());
		}
		else 
			System.out.println("Someting is wrong ...!!");

	}

	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("----------------------- Test Started -----------------------");
	}

	@AfterMethod
	public void afterMethod()
	{
		System.out.println("----------------------- Test Ended -----------------------");

	}

	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("Starting the browser");
		WebDriverManager.firefoxdriver().setup();
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@AfterSuite
	public void afterSuite()
	{
		System.out.println("Closing the browser");
		driver.quit();
	}

	//method to launch the browL and login
	public void launch_URL()
	{
		driver.get(url);
		driver.findElement(By.xpath(lo.login)).sendKeys(Account);
		driver.findElement(By.xpath(lo.password)).sendKeys(Password);
		driver.findElement(By.xpath(lo.LoginSubmit)).click();
	}


}