package day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PracticeCSS {
    public static void main(String[] args) throws InterruptedException {
        /**
         * 1. go to https://www.techlistic.com/p/selenium-practice-form.html
         * 2. fill out the form using CSS
         */

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");

        WebElement firstName = driver.findElement(By.cssSelector("input[name=firstname]"));
        firstName.sendKeys("Olya");

        WebElement lastName = driver.findElement(By.cssSelector("input[name=lastname]"));
        lastName.sendKeys("Test");

        WebElement gender=driver.findElement(By.cssSelector("input#sex-1"));
        gender.click();

        WebElement experience=driver.findElement(By.cssSelector("input#exp-1"));
        experience.click();

        WebElement date = driver.findElement(By.cssSelector("input#datepicker"));
        date.sendKeys("03/25/2024");

        WebElement profession = driver.findElement(By.cssSelector("input#profession-1"));
        profession.click();

        WebElement autoTools = driver.findElement(By.cssSelector("input#tool-2"));
        autoTools.click();

        WebElement continents = driver.findElement(By.cssSelector("select.input-xlarge[id=continents]"));
        Select select = new Select(continents);
        select.selectByVisibleText("Australia");

        WebElement commends = driver.findElement(By.cssSelector("select[id =selenium_commands]"));
        Select select1 = new Select(commends);
        select1.selectByVisibleText("Navigation Commands");

        Thread.sleep(2000);
        WebElement submit = driver.findElement(By.cssSelector("button#submit"));
        submit.click();




    }
}
