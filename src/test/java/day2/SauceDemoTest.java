package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SauceDemoTest {
    public static void main(String[] args) throws InterruptedException {
        /*
        1.go to https://www.saucedemo.com/
        2. login
        3. verify url = https://www.saucedemo.com/inventory.html (driver.getCurrentUrl)
        4. click on Menu button
        5. click on About
        6. verify url = https://saucelabs.com/
         */
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        String url2 = driver.getCurrentUrl();
        if (url2.equals("https://www.saucedemo.com/inventory.html")){
            System.out.println("PASS! The url is: https://www.saucedemo.com/inventory.html ");
        }else{
            System.out.println("FAIL! ((");
        }

        WebElement burgerMenu = driver.findElement(By.id("react-burger-menu-btn"));
        burgerMenu.click();

        Thread.sleep(2000);

        WebElement about = driver.findElement(By.id("about_sidebar_link"));
        about.click();

        String url = driver.getCurrentUrl();
        if (url.contains("https://saucelabs.com/")){
            System.out.println("Success");
        } else {
            System.out.println("Fall");
        }

        driver.quit();
    }
}
