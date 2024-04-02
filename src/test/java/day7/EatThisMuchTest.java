package day7;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import java.time.Duration;
import java.util.List;

public class EatThisMuchTest {

    /*
    1. go to https://www.eatthismuch.com/
    2. verify "Create your meal plan right here in seconds." is visible
    3. enter 2000 in "I want to eat"
    4. click on Generate
    5. verify the total calories of meal plan is > 1900 or < 2100
    6. verify "Today's Meal Plan" is visible
    7. verify there are 4 meals
     */

    static WebDriver driver;

    @Before
    public void before(){
        driver = Driver.getDriver();
        driver.get("https://www.eatthismuch.com/");
    }

    @Test
    public void testMealPlan1(){

        WebElement enter = driver.findElement(By.id("cal_input"));
        enter.sendKeys("2000");

        WebElement generate = driver.findElement(By.xpath("//button[@class='btn btn-lg btn-block btn-orange gen_button']"));
        generate.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement calories = driver.findElement(By.xpath("//div[@class='plan_calories text-medium']"));
        wait.until(ExpectedConditions.textToBePresentInElement(calories, "Calories"));

        String caloriesText = calories.getText(); //2008 Calories

        System.out.println(caloriesText);

        int caloriesNum = Integer.parseInt(caloriesText.split(" ")[0]);
        Assert.assertTrue(caloriesNum >= 1900 && caloriesNum <= 2100);

        String todaysMealPlan = driver.findElement(By.xpath("//div[@class='day_title col-auto mr-auto']")).getText();
        Assert.assertEquals("Today's Meal Plan", todaysMealPlan);

        List<WebElement> meals = driver.findElements(By.xpath("//div[@class='meal_box meal_container row']"));
        Assert.assertEquals("The meals number did not match",4, meals.size());
    }

    @Test
    public void testUserCanDeleteMealFromPlan(){
        /*
    1. enter 1800 in "I want to eat"
    2. select 7 meals
    3. open snack 1
    4. delete snack 1
    5. verify snack is deleted from plan
         */
    }

    @Test
    public void testUserCanRefreshMealFromPlan(){
        /*
    1. enter 1800 in "I want to eat"
    2. select 5 meals
    3. open breakfast
    4. refresh meal
    5. verify meal is refreshed
         */
    }



}
