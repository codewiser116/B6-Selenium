package day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Driver;

public class Checkboxes {
    public static void main(String[] args) {
        WebDriver driver = Driver.getDriver();
        driver.get("https://the-internet.herokuapp.com/");

        driver.findElement(By.linkText("Checkboxes")).click();

        WebElement checkbox1 = driver.findElement(By.xpath("//br/preceding::input"));
        WebElement checkbox2 = driver.findElement(By.xpath("//br/following::input"));

        if (checkbox1.isSelected()){
            System.out.println("Checkbox 1 is already selected!");
        }else{
            checkbox1.click();
        }

        if (checkbox2.isSelected()){
            System.out.println("Checkbox 2 is already selected!");
        }else{
            checkbox2.click();
        }



    }
}
