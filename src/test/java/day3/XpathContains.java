package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class XpathContains {
    public static void main(String[] args) {

        /*

        USE CONTAINS METHOD

        //tag[contains(@attribute, ‘value’)]

        //input[@class='input_username']   - regular xpath
        //input[contains(@class, 'input')] - xpath with contains method
       ------------------------------------------------------------------
        1. go to https://demoqa.com/text-box
        2. List <WebElement> userElements = driver.findElements();
        3. List <WebElement addressElements = driver.findElements();
         */

        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/text-box");

        List<WebElement> userElements = driver.findElements(By.xpath("//input[contains(@id, 'user')]"));
        System.out.println(userElements.size());

        userElements.get(0).sendKeys("Bena");
        userElements.get(1).sendKeys("bena@gmail.com");

        WebElement user = userElements.get(0);










    }
}
