
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;



public class AspireTest extends Locators
{
	Locators lo = new Locators();
	public static WebDriver driver;
	String url= "https://aspireapp.odoo.com/";
	String Account= "user@aspireapp.com";
	String Password = "@sp1r3app";
	WebDriverWait wait = new WebDriverWait(driver, 20); 

	@Test
	public void Exercise_1() throws Exception
	{
		WebDriverManager.firefoxdriver().setup();
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//1. Login to web application
		driver.get(url);
		driver.findElement(By.xpath(lo.login)).sendKeys(Account);
		driver.findElement(By.xpath(lo.password)).sendKeys(Password);
		driver.findElement(By.xpath(lo.LoginSubmit)).click();
		Thread.sleep(5000);
		//2. Navigate to `Inventory` feature
		driver.findElement(By.xpath(lo.InventoryIcon)).click();
		
		//3. From the top-menu bar, select `Products -> Products` item, then create a new product
		Random ran = new Random();
		int rn = ran.nextInt((1000 - 1) + 1) + 1;
		driver.findElement(By.xpath(lo.ProductsTab)).click();
		driver.findElement(By.xpath(lo.ProductsOption)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(lo.CreateProductButton))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(lo.ProductName)).sendKeys("Auto Test "+rn);
		driver.findElement(By.xpath(lo.ProductSave)).click();
		
		//4. Update the quantity of new product is more than 10
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(lo.UpdateQuantity))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(lo.CreateButon))).click();
		driver.findElement(By.xpath(lo.QuantField)).clear();
		driver.findElement(By.xpath(lo.QuantField)).sendKeys("111111111");
		Thread.sleep(5000);
		driver.findElement(By.xpath(lo.LocField)).sendKeys("Virtual");
		driver.findElement(By.xpath(lo.DropDwnloc)).click();
		driver.findElement(By.xpath(lo.VirtData)).click();
		driver.findElement(By.xpath(lo.ProductSave)).click();
		
		
		
		
		
		
		
		

	}
	
	
	
	
//	@BeforeMethod
//	public void beforeMethod()
//	{
//		System.out.println("Starting the browser");
//	}
//	
//	@AfterMethod
//	public void afterMethod()
//	{
//		System.out.println("CLosing the browser");
//		driver.quit();
//	}
	
	
}