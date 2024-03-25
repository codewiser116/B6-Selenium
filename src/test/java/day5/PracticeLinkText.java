package day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeLinkText {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");

        WebElement dragAndDrop = driver.findElement(By.linkText("Drag and Drop"));
        dragAndDrop.click();

        driver.navigate().back();

        WebElement dynamicLoading = driver.findElement(By.linkText("Dynamic Loading"));
        dynamicLoading.click();

        driver.navigate().back();

        WebElement fileUpload = driver.findElement(By.partialLinkText("Upload"));
        fileUpload.click();

        driver.quit();



    }
}
