package day11;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Driver;
import utils.SeleniumUtils;

import java.util.Set;

public class LetskodeitTest {
    /*
    1. go to https://www.letskodeit.com/practice
    2. print current url
    3. click on Open Tab
    4. switch to the new tab
    5. print current url
    6. driver.close()
    7. print current url

    Test #2
    1. go to https://www.letskodeit.com/practice
    2. print current url
    3. click on Open Window
    4. switch to the new window
    5. print current url
    6. switch back to the main page
    7. print current url
     */
    WebDriver driver = Driver.getDriver();

    @Before
    public void openUrl(){
        driver.get("https://www.letskodeit.com/practice");
        System.out.println(driver.getCurrentUrl());
    }

    @Test
    public void testWindow(){
        String mainWindowHandle = driver.getWindowHandle();

        WebElement newWindow = driver.findElement(By.id("openwindow"));

        SeleniumUtils.switchToNewTab(driver, newWindow);

        driver.switchTo().window(mainWindowHandle);
        System.out.println(driver.getCurrentUrl());
    }





    @Test
    public void testNewTab(){
        String mainWindowHandle = driver.getWindowHandle();

        WebElement openTab = driver.findElement(By.id("opentab"));

        SeleniumUtils.switchToNewTab(driver, openTab);

        driver.close();

        driver.switchTo().window(mainWindowHandle);
        System.out.println(driver.getCurrentUrl());

    }
}
