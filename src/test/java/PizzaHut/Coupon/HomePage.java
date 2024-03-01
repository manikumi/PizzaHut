package PizzaHut.Coupon;
import Framewrok.TestComponent.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HomePage  {
    WebDriver driver;

    //Locator for apply Vocher code
    By applyForVoucher = By.xpath("//span[.='Apply Coupon code or Gift Card']");
    //Locator to enter Vocher code
    By enterVoucherCode = By.name("voucherId");
    //Locator to press enter in keyboard for Voucher code
    By pressEnterVoucher = By.name("voucherId");
    //Locator for Discount activated
    By discountActivated = By.xpath("//span[.='OK']");
    //Locator for success message of Voucher applied
    By voucherSucessMessage = By.xpath("//span[.='Discount Activated']");
    //Locator to add single Pizza price more than 500
    By singlePizza = By.xpath("(//button[@class='button button--md button--green flex-1 font-semibold'])[2]");
    //Locator to add two pizza for value more than 500
    By twoPizza = By.xpath("//button[@class='button button--md button--green flex-1 font-semibold']");
    //Locator to verify total saving
    By totalSaving = By.xpath("//p[contains(.,'125')]");
    //Locator to click on deals
    By deals= By.xpath("//select[contains(@id,'dropdown')]");
    //Locator to select Pizza Size by dropdown
    By pizzaSizeDropdown= By.xpath("(//select[contains(@id,'dropdown')][1])[2]");
    //Locator of Spend More Meassage
    By spendMore= By.xpath("(//span[contains(text(),'Spend')])");

    //Method to click on apply for Voucher code
    public void clickApplyVoucher() {
        driver.findElement(applyForVoucher).click();
    }
    // Method to type voucher code
    public void applyVouchercode(String VoucherCode){
        driver.findElement(applyForVoucher).sendKeys(VoucherCode);
    }
    // Method to type voucher code
    public void typeVouchercode(String VoucherCode){
        driver.findElement(enterVoucherCode).sendKeys(VoucherCode);
    }
    // Method to press enter after typing voucher code
    public void pressEnterVoucher(Keys Enter){
        driver.findElement(pressEnterVoucher).sendKeys(Enter);
    }
    //Method to click ok on discount activated
    public void discountActivated() {
        driver.findElement(discountActivated).click();
    }
    // Method that return True or False depending on whether the message is displayed
    public Boolean voucherMessageDisplayed(){
        Boolean statusVoucher = driver.findElement(voucherSucessMessage).isDisplayed();
        return statusVoucher;
    }
    //Method to select large Pizza
    public void selectLargePizza(){
        Select dropdown= new Select(driver.findElement(pizzaSizeDropdown));
        dropdown.selectByIndex(2);
    }

    //Method to add Pizza
    public void addSinglePizza() {
        driver.findElement(singlePizza).click();
    }
    //Method to add Pizza
    public void addTwoPizza() {
        driver.findElement(twoPizza).click();
    }
    // Method that return True or False depending on whether the message is displayed
    public Boolean savingMessageDisplayed(){
        Boolean statusSaving = driver.findElement(totalSaving).isDisplayed();
        return statusSaving;
    }
    // Method that return True or False depending on whether the message is displayed
    public Boolean spendMoreMessageDisplyed(){
        Boolean spendMoreMsg= driver.findElement(spendMore).isDisplayed();
        return  spendMoreMsg;
    }

    //Method to click on deals
    public void dealsClick() {
        driver.findElement(deals);
    }
    // Constructor
// Gets called when object of this page is created in PizzaHut.Coupon.MainClass.java
    public HomePage(WebDriver driver)
    {
// "this" keyword is used here to distinguish global and local variable "driver"
//gets driver as parameter from PizzaHut.Coupon.MainClass.java and assigns to the driver instance in this class
        this.driver=driver;
    }
}
