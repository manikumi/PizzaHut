package PizzaHut.Coupon;
import java.time.Duration;

import Framewrok.TestComponent.BaseTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
public class PreRequiste   {
    WebDriver driver;

    public void preRequiste() throws InterruptedException {
// Creating object of Address page and driver instance is passed as parameter to constructor of Address.Java
        AddressPage addressPage= new AddressPage(driver);
// Type Address
        addressPage.typeDeliveryAddress("Kengeri Metro");
// Address is passed as paramter which in turn will be assigned to the method in HomePage.Java
        Thread.sleep(2000);
//Click enter from keyboard
        addressPage.enterDeliveryAddress(Keys.ENTER);
        Thread.sleep(3000);
// Creating object of Home page and driver instance is passed as parameter to constructor of Homepage.Java
        HomePage homePage = new HomePage(driver);
//Click on apply Vocher code
        homePage.clickApplyVoucher();
//Enter voucher code
        homePage.typeVouchercode("HUT125");
        Thread.sleep(2000);
//press enter in keyboard after tying Voucher code
        homePage.pressEnterVoucher(Keys.ENTER);
        Thread.sleep(2000);
//Verify the voucher message displayed
        Assert.assertTrue(homePage.voucherMessageDisplayed());
        Thread.sleep(2000);
//Click Ok on discount activated
        homePage.discountActivated();

    }
    // Constructor
// Gets called when object of this page is created in PizzaHut.Coupon.MainClass.java
    public PreRequiste(WebDriver driver)
    {
// "this" keyword is used here to distinguish global and local variable "driver"
//gets driver as parameter from PizzaHut.Coupon.MainClass.java and assigns to the driver instance in this class
        this.driver=driver;
    }
}
