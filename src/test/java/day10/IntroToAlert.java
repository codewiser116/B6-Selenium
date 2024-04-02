package day10;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Driver;

public class IntroToAlert {

    static WebDriver driver;

    @Before
    public void beforeMethod(){
        driver = Driver.getDriver();
        driver.get("https://demo.guru99.com/test/delete_customer.php");

        WebElement customerIDField = driver.findElement(By.name("cusid"));
        customerIDField.sendKeys("abc123");

        WebElement submitButton = driver.findElement(By.name("submit"));
        submitButton.click();

        System.out.println(driver.switchTo().alert().getText()); // print message from 1st alert
    }

    /*
    1. go to https://demo.guru99.com/test/delete_customer.php
    2. enter some id
    3. click on submit
    4. print alert message
    5. click on ok
    6. print message from new alert ---> Customer Successfully Delete!
    7. ok
     */

    @Test
    public void testDelete(){

        driver.switchTo().alert().accept(); // accept 1st alert
        System.out.println(driver.switchTo().alert().getText()); // print message from 2nd alert

        driver.switchTo().alert().accept();
    }

    /*
    1. go to https://demo.guru99.com/test/delete_customer.php
    2. enter some id
    3. click on submit
    4. print alert message
    5. click on cancel
 */
    @Test
    public void testCancelDelete(){
        driver.switchTo().alert().dismiss();
    }

    @AfterClass
    public static void quitDriver(){
        driver.quit();
    }

}
