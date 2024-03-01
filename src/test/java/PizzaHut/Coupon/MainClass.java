package PizzaHut.Coupon;

import Framewrok.TestComponent.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class MainClass   {
    WebDriver driver;
    @BeforeMethod(alwaysRun = true)
    public void invokeBrowser() throws InterruptedException {
        //WebDriverManager to launch browser
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    String pizzaPageTitle= "Pizza Menu, Order Veg & Non-Veg Pizza Online, Pizza Toppings | Pizza Hut India";

    @AfterMethod(alwaysRun = true)
    public void CloseBrowser() {
        driver.close();
    }

    //Positive Test Case-1: Validate the coupon code for Single Pizza value more Rs.500/-
    @Test(priority=0,groups = {"Regression"})
    public void PositiveTestOnSinglePizzasOrder() throws InterruptedException {
        PreRequiste pr = new PreRequiste(driver);
        // Creating object of Home Page and driver instance is passed as parameter to constructor of Homepage.Java
        HomePage homePage = new HomePage(driver);
        driver.get("https://www.pizzahut.co.in/");
        Thread.sleep(2000);
//Calling preRequiste method
        pr.preRequiste();
//verify if Pizzas page is slected by validating the title page
        Assert.assertEquals(pizzaPageTitle,driver.getTitle());
//Scroll by using JavaScriptExecutor
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,300)");
//Select Large Pizza
        homePage.selectLargePizza();
//Add Pizza to cart
        homePage.addSinglePizza();
        //waitForWhile();
//verify the savings message displayed
        Assert.assertTrue(homePage.savingMessageDisplayed());
        System.out.println("Coupon code is applied");
    }



    //Positive Test Case-2: Validate the coupon code for multiple Pizza value more Rs.500/-
    @Test(priority=1,groups = {"Regression"})
    public void PositiveTestOnMultiplePizzaOrders() throws InterruptedException {
        driver.get("https://www.pizzahut.co.in/");
        Thread.sleep(2000);
        PreRequiste pr = new PreRequiste(driver);
        // Creating object of Home Page and driver instance is passed as parameter to constructor of Homepage.Java
        HomePage homePage = new HomePage(driver);
        //TiTle of Pizza Page
//Calling preRequiste method
        pr.preRequiste();
//verify if Pizzas page is slected by validating the title page
        Assert.assertEquals(pizzaPageTitle,driver.getTitle());
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,300)");
//Add Pizza to cart
        for(int i=0; i<=2; i++) {
            homePage.addTwoPizza();
        }
        Thread.sleep(2000);
//verify the savings message displayed
        Assert.assertTrue(homePage.savingMessageDisplayed());
        System.out.println("Coupon code is applied");
    }

    //Negative Test Case -1 - Validating Coupon code for Pizza Value less than 500
    @Test(priority=3,groups = {"Regression"})
    public void NegativeTestOnPizzaLessThanValue() throws InterruptedException {
        driver.get("https://www.pizzahut.co.in/");
        Thread.sleep(2000);
        PreRequiste pr = new PreRequiste(driver);
        // Creating object of Home Page and driver instance is passed as parameter to constructor of Homepage.Java
        HomePage homePage = new HomePage(driver);
        //TiTle of Pizza Page
        //Calling preRequiste method
        pr.preRequiste();
        //verify if Pizzas page is slected by validating the title page
        Assert.assertEquals(pizzaPageTitle,driver.getTitle());
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,300)");
        //Add Pizza To cart
        homePage.addSinglePizza();
        //Verify Spend more message is displayed
        Assert.assertTrue(homePage.spendMoreMessageDisplyed());
        System.out.println("Coupon not applied");

    }

    //Negative Test Case-2 - Validating Coupon code for deal Pizza
    @Test(priority=4,groups = {"Regression"})
    public void NegativeOnDeals() throws InterruptedException {
        driver.get("https://www.pizzahut.co.in/");
        Thread.sleep(2000);
        PreRequiste pr = new PreRequiste(driver);
        // Creating object of Home Page and driver instance is passed as parameter to constructor of Homepage.Java
        HomePage homePage = new HomePage(driver);
        // Creating object of Deals Page and driver instance is passed as parameter to constructor of Deals Page
        DealsPage dealsPage= new DealsPage(driver);
        //TiTle of Pizza Page
        //Calling preRequiste method
        pr.preRequiste();
        Thread.sleep(2000);
        //Navigate to deals page
        dealsPage.navigateToDeals();
        //Click on Customize your deal
        dealsPage.customizeYourDeal();
        Thread.sleep(2000);
        //Choose Pizza
        dealsPage.choosePizza();
        //Add Pizza
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,300)");
        dealsPage.addPizza();
        //Choose Pizza
        dealsPage.choosePizza();
        //Add Pizza
        js.executeScript("window.scrollBy(0,300)");
        dealsPage.addPizza();
        //Add deal to basket
        dealsPage.addDealToBasket();
        //Verify Spend More Message
        Assert.assertTrue(dealsPage.spendMoreMessageDisplyed());
        System.out.println("Coupon not applied");

    }

}



