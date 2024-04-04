package day12;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.Driver;

public class IntroToActions {

    @Test
    public void test1(){
        /*
        1. go to https://www.browserstack.com/
        2. click on Get started free
         */

        WebDriver driver = Driver.getDriver();
        driver.get("https://www.browserstack.com/");

        WebElement getStartedButton = driver.findElement(By.id("signupModalProductButton"));

        Actions actions = new Actions(driver);
        actions.moveToElement(getStartedButton).click().build().perform();

    }

    @Test
    public void hoverOverTest(){
        /*
        1. go to https://magento.softwaretestingboard.com/
        2. hover over "Women"
        3. hover over "Tops"
        4. click on "Tees"

        locate parent element (Women)
        hover over parent element (WOmen)
        move to desired (child) element (locate Tops)
        interact with desired (child) element
         */

        WebDriver driver = Driver.getDriver();
        driver.get("https://magento.softwaretestingboard.com/");

        WebElement women = driver.findElement(By.xpath("//span[text()='Women']/.."));
        WebElement womenTops = driver.findElement(By.id("ui-id-9"));
        WebElement tees = driver.findElement(By.id("ui-id-13"));

        Actions actions = new Actions(driver);
        actions
                .moveToElement(women)
                .moveToElement(womenTops)
                .moveToElement(tees)
                .click()
                .build().perform();
    }

    @Test
    public void testHoverOVer2() throws InterruptedException {
        // hover over Men, hover over Bottoms, click on Shorts
        WebDriver driver = Driver.getDriver();
        driver.get("https://magento.softwaretestingboard.com/");

        WebElement men = driver.findElement(By.xpath("//span[text()='Men']"));
        WebElement bottom = driver.findElement(By.id("ui-id-18"));
        WebElement Shorts= driver.findElement(By.id("ui-id-24"));

        Actions actions = new Actions(driver);

        Action act = actions.moveToElement(men)
                .moveToElement(bottom)
                .moveToElement(Shorts)
                .click()
                .build();

        System.out.println("Something else");

        act.perform();
    }

    @Test
    public void testDoubleClick(){
    /*
        1. go to https://demoqa.com/buttons
        2. double click on button
        3. verify "You have done a double click" text appeared
     */
        WebDriver driver = Driver.getDriver();
        driver.get("https://demoqa.com/buttons");

        Actions actions = new Actions(driver);

        /*
        HOW TO DOUBLE CLICK?
         */
        WebElement doubleClickBtn = driver.findElement(By.id("doubleClickBtn"));
        actions.doubleClick(doubleClickBtn).build().perform();

        String doubleClickMsg = driver.findElement(By.id("doubleClickMessage")).getText();
        Assert.assertEquals("You have done a double click", doubleClickMsg);

        /*
        HOW TO RIGHT CLICK?
         */
        WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));
        actions.contextClick(rightClickBtn).perform();

        String rightClickMsg = driver.findElement(By.id("rightClickMessage")).getText();
        Assert.assertEquals("You have done a right click", rightClickMsg);


    }

    @After
    public void shotDownBrowser() throws InterruptedException {
        Thread.sleep(3000);
//        Driver.getDriver().quit();
    }






}
