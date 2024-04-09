package day14;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Driver;

public class IntroToJavascriptExecutor {


    @Test
    public void fillOutForm(){
       /*
       1. go to https://demoqa.com/text-box
       2. fill out the form
       3. click on submit
        */
        WebDriver driver = Driver.getDriver();
        driver.get("https://demoqa.com/text-box");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement username = driver.findElement(By.id("userName"));
        WebElement email = driver.findElement(By.id("userEmail"));
        WebElement currentAddress = driver.findElement(By.id("currentAddress"));

        // Using executeAsyncScript to simulate asynchronous behavior with setTimeout
        js.executeAsyncScript(
                "let args = arguments, callback = arguments[arguments.length - 1];" +
                        "setTimeout(function() {" +
                        "  args[0].value='codewise academy';" +
                        "  args[1].value='codewise@gmail.com';" +
                        "  args[2].value='2250 E Devon';" +
                        "  callback();" +
                        "}, 0);", // 0 ms delay, just for the sake of async simulation
                username, email, currentAddress);

        WebElement permAddress = driver.findElement(By.id("permanentAddress"));
        js.executeScript("arguments[0].value='permanent address';", permAddress);

        WebElement submitButton = driver.findElement(By.id("submit"));
        js.executeScript("arguments[0].click();", submitButton);


        /*
        Using synchronous script

        js.executeScript("document[0].value='codewise academy';", username);
        js.executeScript("document[0].value='codewise@gmail.com';", email);
        js.executeScript("document[0].value='2250 E Devon ave';", currentAddress);
         */



    }




}
