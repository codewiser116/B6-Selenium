package day1;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.Driver;

public class IntroToSelenium {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        WebElement addBackpack = driver.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory ']"));
        addBackpack.click();

        WebElement bikeLight = driver.findElement(By.name("add-to-cart-sauce-labs-bike-light"));
        bikeLight.click();

        Thread.sleep(5000);

        WebElement tshirt = driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
        tshirt.click();

        // add bike light and t-shirt


    }
    @Test
    public void initTest(){
        Driver.getDriver().get("http://demo.guru99.com");
    }
}
