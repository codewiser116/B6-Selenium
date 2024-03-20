package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathOrAndStartsWith {
    public static void main(String[] args) throws InterruptedException {
        /*
        1. go to https://demoqa.com/automation-practice-form
        2. fill out:
        first name, last name, email, gender
        mobile, date of birth,
        subjects, hobbies
        current_address
        3. click on Submit

        ONLY USE XPATH: contains, starts-with, text(), and, or

         */

        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();



        WebElement firstName = driver.findElement(By.xpath("//input[@type='text' and @id='firstName']"));
        firstName.sendKeys("Bena");

        WebElement lastName = driver.findElement(By.xpath("//input[@placeholder='Last Name' or @id='lastName']"));
        lastName.sendKeys("Doe");

        WebElement email = driver.findElement(By.xpath("//input[contains(@id, 'userEmail')]"));
        email.sendKeys("bena@doe.com");

        Thread.sleep(2000);
        WebElement gender = driver.findElement(By.xpath("//div[@class='custom-control custom-radio custom-control-inline']"));
        Thread.sleep(2000);
        gender.click();

        WebElement mobile = driver.findElement(By.xpath("//input[@id='userNumber' or @placeholder='Mobile Number']"));
        mobile.sendKeys("1234567890");

        WebElement dob = driver.findElement(By.xpath("//input[@id='dateOfBirthInput']"));
        dob.click();
        Thread.sleep(1000);

        WebElement dateTpSelect = driver.findElement(By.xpath("//div[@aria-label='Choose Wednesday, March 6th, 2024']"));
        dateTpSelect.click();

        WebElement subject = driver.findElement(By.xpath("//input[@id='subjectsInput']"));
        WebElement musicCheckbox = driver.findElement(By.xpath("//input[@id='hobbies-checkbox-3']"));









    }
}
