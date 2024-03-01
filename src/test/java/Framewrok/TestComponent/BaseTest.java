package Framewrok.TestComponent;

import PizzaHut.Coupon.MainClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseTest  {
    public WebDriver driver;
    @Test
    public String getScreeshot( String testCaseName) throws IOException, IOException {
        TakesScreenshot ts=	(TakesScreenshot) driver;
        File source= ts.getScreenshotAs(OutputType.FILE);
        File destination= new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
        FileUtils.copyFile(source, destination);
        return System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
    }

}
