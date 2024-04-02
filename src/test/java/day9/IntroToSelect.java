package day9;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import java.time.Duration;
import java.util.List;

public class IntroToSelect {
    /*
    1. go to amazon.com
    2. in search box enter "Apple"
    3. choose "Books" from categories dropdown
    4. verify every book title contains "Apple"
     */

    @Test
    public void testAmazonDropDown(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://www.amazon.com/");

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("apple");

        WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));

        Select select = new Select(dropdown);
        select.selectByVisibleText("Books");

        WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
        searchButton.click();

        List<WebElement> results = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));

        for (WebElement element : results){
            Assert.assertTrue("Book title doesn't contain apple: ==> " + element.getText(),
                    element.getText().toLowerCase().contains("apple"));
        }

        // assertTrue(boolean condition)
        // assertTrue(String message, boolean condition)

    }


    /*
    1. go to https://the-internet.herokuapp.com/dropdown
    2. select option 1 by text
    3. verify option 1 is selected
     */

    @Test
    public void testDropDownByText(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");

        WebElement dropDwn = driver.findElement(By.id("dropdown"));

        Select select = new Select(dropDwn);
        select.selectByVisibleText("Option 1");

        Assert.assertTrue(select.getAllSelectedOptions().getFirst().getText().equals("Option 1"));

        select.deselectByVisibleText("Option 1");

    }


    /*
    1. go to https://the-internet.herokuapp.com/dropdown
    2. select option 2 by value
    3. verify option 2 is selected
     */

    @Test
    public void testDropDownByValue(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");

        WebElement dropDwn = driver.findElement(By.xpath("//select[@id='dropdown']"));
        dropDwn.click();

        Select select = new Select(dropDwn);
        select.selectByValue("Option 2");

        Assert.assertTrue(select.getAllSelectedOptions().getFirst().getText().equals("Option 2"));
    }

    /*
    1. go to orangehrm website
    2. login
    3. select "Automation Tester" from job title
     */

    @Test
    public void testOrangeHRM() throws InterruptedException {
        WebDriver driver = Driver.getDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement submitBtn = driver.findElement(By.tagName("button"));

        username.sendKeys("Admin");
        password.sendKeys("admin123");
        submitBtn.click();

        WebElement pim = driver.findElement(By.linkText("PIM"));
        pim.click();

        WebElement jobTitleDropDown = driver.findElement(By.xpath("//label[text()='Job Title']/../..//div[@class='oxd-select-text-input']"));
        jobTitleDropDown.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-select-option']/span[text()='Automaton Tester']")));

        driver.findElement(By.xpath("//div[@class='oxd-select-option']/span[text()='Automaton Tester']")).click();


        // choose Software Architect


    }











}
