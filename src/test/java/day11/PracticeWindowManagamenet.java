package day11;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Driver;

import java.util.List;
import java.util.Set;

public class PracticeWindowManagamenet {

    /*
    1. login to saucedemo.com
    2. print current URL
    3. click on Twitter
    4. print current URL
    5. switch to new tab
    6. print current URL
     */

    static WebDriver driver;

    @Before
    public  void before(){
        driver = Driver.getDriver();
        driver.get("https://saucedemo.com/");

        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement click = driver.findElement(By.id("login-button"));
        click.click();

        System.out.println("URL after we login: " + driver.getCurrentUrl());
    }

    @Test
    public void twitter(){
        WebElement twitter = driver.findElement(By.xpath("//a[text()='Twitter']"));
        windowHandle(twitter);
    }

    @Test
    public void facebook(){
        WebElement facebook = driver.findElement(By.xpath("//a[text()='Facebook']"));
        windowHandle(facebook);
    }

    @Test
    public void linkedin(){
        WebElement linkedin = driver.findElement(By.xpath("//a[text()='LinkedIn']"));
        windowHandle(linkedin);
    }




    public void windowHandle(WebElement element){
        String mainWindowHandle = driver.getWindowHandle();
        String url = driver.getCurrentUrl();

        System.out.println("url before click : " + url);
        element.click();

        Set<String> windows =  driver.getWindowHandles(); //mainWindow

        for (String windowHandle:windows){
            if (!windowHandle.equals(mainWindowHandle)){
                driver.switchTo().window(windowHandle);
            }
        }

        System.out.println("url after click : " + driver.getCurrentUrl());
    }




    @Test
    public void testErzhan(){
        List<WebElement> socialLinks = driver.findElements(By.xpath("//ul[@class='social']/li/a"));
        String mainWindow = driver.getCurrentUrl();
        for (WebElement element : socialLinks){
            element.click();
        }
        Set<String> windowHandles = driver.getWindowHandles();
        for (String string : windowHandles){
            if (!string.equals(mainWindow)){
                driver.switchTo().window(string);
                String socialURL = driver.getCurrentUrl();
                System.out.println("Tabs urls: " + socialURL);
            }
        }
    }






















}
