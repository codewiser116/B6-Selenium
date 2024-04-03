package day10;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.*;
import utils.Driver;

import java.time.Duration;
import java.util.NoSuchElementException;

public class BrowserPopUp {


    @Test
    public void testBrowserPop(){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-popup-blocking");
        options.addArguments("start-maximized");
        options.addArguments("incognito");

        // Use preferences to disable geolocation permission prompt
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.geolocation", 2); // 2 means Block
        options.setExperimentalOption("prefs", prefs);

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.google.com/");

        WebElement search = driver.findElement(By.xpath("//textarea[@title='Search']"));
        search.sendKeys("doordash" + Keys.ENTER);

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='dialog']//div[text()='Use precise location']")));
            WebElement dialog = driver.findElement(By.xpath("//div[@role='dialog']//div[text()='Use precise location']"));
            dialog.click();
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }

    }

}
