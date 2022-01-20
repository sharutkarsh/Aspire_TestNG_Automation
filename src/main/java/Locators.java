
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Locators {
	
    //XPath Locators are stored here
	
	String login = "//input[@id=\"login\"]";
	String password ="//input[@id=\"password\"]";
	String LoginSubmit = "//button[@type=\"submit\"]";
	String InventoryIcon = "//*[@id=\"result_app_1\"]/div[2]";
	String ProductsTab = "//a[contains(text(),'Products')]";
	String ProductsOption ="//a/span[text()='Products']";
	String CreateProductButton= "//button[contains(text(),'Create')]";
	String ProductName = "//input[@placeholder=\"Product Name\"]";
	String ProdNameStr = "//span[@placeholder=\"Product Name\"]";
	String ProductSave = "//button[contains(text(),'Save')]";
	
	String UpdateQuantity = "//span[contains(text(),'Update Quantity')]";
	String CreateButon = "//button[contains(text(),'Create')]";
	String QuantField = "//input[@name=\"inventory_quantity\"]";
	String DropDwnloc = "(//a[@class=\"o_dropdown_button\"])[1]";
	String LocField = "(//input[@class=\"o_input ui-autocomplete-input\"])[1]";
	String VirtData = "//a[contains(text(),'Virtual Locations/HN')]";
	
	String AppIcon = "//a[@title=\"Applications\"]";
	String ManufacturingIcon = "//*[@id=\"result_app_2\"]/div[2]";
	String CreateButton= "//button[contains(text(),'Create')]";
	
	String ManuProdName = "(//input[@class=\"o_input ui-autocomplete-input\"])[1]";
	String SearchedResult = "//a[@class=\"ui-menu-item-wrapper ui-state-active\"]";
	
    String AddALine = "(//a[text()='Add a line'])[1]";
    String ProdLine = "(//input[@class=\"o_input ui-autocomplete-input\"])[6]";
    String ProdLinSearchRes = "//a[@class=\"ui-menu-item-wrapper ui-state-active\"]";
    String ProdUOMquant = "//input[@name=\"product_uom_qty\"]";
    String ProdQuant = "//input[@name=\"product_qty\"]";
	
	String ManuSave = "//button[@class=\"btn btn-primary o_form_button_save\"]";
	String ConfirmButton = "//span[text()='Confirm']";
	String MarkDone = "(//button[@name=\"button_mark_done\"])[2]";
	
	String ManRef = "//span[@placeholder=\"Manufacturing Reference\"]";
	String prodName = "//a[@name=\"product_id\"]/span";
	String Apply = "//span[text()='Apply']";
	
	
	
	
	
	
	
	
	

}