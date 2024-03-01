package PizzaHut.Coupon;

import Framewrok.TestComponent.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DealsPage  {
    WebDriver driver;

   // locator to select Deals
    By dealsButton= By.xpath("(//span[.='Deals'])[2]");
    // Customize your deal locator
    By customizeDeal= By.xpath("(//button[contains(text(),'Customise your deal')])[2]");
    //Choose  pizza
    By choosePizza= By.xpath("(//span[.='Choose a pizza'])[1]");
    //Add Pizza
    By addPizza = By.xpath("(//span[.='Add'])[1]");
    //Add deal to basket
    By addAddDealToBasket = By.xpath("//span[.='Add deal to basket']");
    //Spend More
    By spendMore= By.xpath("(//span[contains(text(),'Spend')])");

    //Method to Naviagte Deals Button
    public void navigateToDeals(){
        WebElement dealsButton= driver.findElement(By.xpath("(//span[.='Deals'])[2]"));
        Actions action = new Actions(driver);
        action.click(dealsButton).build().perform();

    }

    public void customizeYourDeal(){
        driver.findElement(customizeDeal).click();
    }

    public void choosePizza(){
        driver.findElement(choosePizza).click();
    }

    public void addPizza(){
        driver.findElement(addPizza).click();
    }

    public void addDealToBasket(){
        driver.findElement(addAddDealToBasket).click();
    }

    public Boolean spendMoreMessageDisplyed(){
        Boolean spendMoreMsg= driver.findElement(spendMore).isDisplayed();
        return  spendMoreMsg;
    }

    public DealsPage(WebDriver driver)
    {
// "this" keyword is used here to distinguish global and local variable "driver"
//gets driver as parameter from PizzaHut.Coupon.MainClass.java and assigns to the driver instance in this class
        this.driver=driver;
    }

}
