package day10;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import java.time.Duration;

public class EatThisTest {

    @Test
    public void ah_testUserCanDeleteMealFromPlan() throws InterruptedException {
        WebDriver driver = Driver.getDriver();
        driver.get("https://www.eatthismuch.com/");
        WebElement enter1800 = driver.findElement(By.id("cal_input"));
        enter1800.sendKeys("1800");

        WebElement numberOfMeals7 = driver.findElement(By.id("num_meals_selector"));
        Select select = new Select(numberOfMeals7);
        select.selectByValue("7");

        WebElement generateButton = driver.findElement(By.cssSelector
                ("button[class='btn btn-lg btn-block btn-orange gen_button']"));
        generateButton.click();

        driver.findElement(By.xpath("//div[@class='cancel_popover btn btn-outline-secondary']")).click();


        WebElement firstMeal = driver.findElement(By.xpath
                ("(//ul[@class='meal_foods col-12 collection-list ui-sortable'])[1]/li"));

//        Actions actions = new Actions(driver);
//        actions.moveToElement(firstMeal).click().build().perform();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();arguments[0].click();", firstMeal);


        String text = firstMeal.getText();
        System.out.println(text);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(firstMeal));
        firstMeal.click();
        firstMeal.click();
//
//        WebElement deleteSnack1 = driver.findElement(By.cssSelector("div[class='control_button food_delete_icon']"));
//        deleteSnack1.click();



    }
}
