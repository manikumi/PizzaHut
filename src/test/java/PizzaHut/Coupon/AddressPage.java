package PizzaHut.Coupon;
import Framewrok.TestComponent.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class AddressPage  {
     WebDriver driver;

    //Locator for Enter your location for deliver
    By deliveryAddress = By.xpath("//input[@type='text' and @role='combobox']");
    // Method to type delivery address
    public void typeDeliveryAddress(String enter){
        driver.findElement(deliveryAddress).sendKeys(enter);
    }
    // Method to press enter after typing delivery address
    public void enterDeliveryAddress(Keys enter){
        driver.findElement(deliveryAddress).sendKeys(enter);
    }
    //Method to click enter for starting order at specified time
    public void startOderTime() {
        driver.findElement(By.xpath("//span[.='Start your order']")).click();
    }
    // Constructor
// Gets called when object of this page is created in PizzaHut.Coupon.MainClass.java
    public AddressPage(WebDriver driver)
    {
// "this" keyword is used here to distinguish global and local variable "driver"
//gets driver as parameter from PizzaHut.Coupon.MainClass.java and assigns to the driver instance in this class
        this.driver= driver;
    }
}
