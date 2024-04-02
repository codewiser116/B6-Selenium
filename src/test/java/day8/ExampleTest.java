package day8;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Driver;

public class ExampleTest {
    /*
    1. go to https://the-internet.herokuapp.com/
    2. click on Checkboxes
    3. verify checkbox 2 is selected
     */

    @Test
    public void verifyCheckbox2(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://the-internet.herokuapp.com/");

        WebElement checkboxes = driver.findElement(By.linkText("Checkboxes"));
        checkboxes.click();

        WebElement checkbox1 = driver.findElement(By.xpath("//br/preceding::input"));
        WebElement checkbox2 = driver.findElement(By.xpath("//br/following::input"));

        //  verify checkbox 2 is selected
        Assert.assertTrue(checkbox2.isSelected());

        //verify checkbox 1 is not selected
        Assert.assertFalse(checkbox1.isSelected());
    }

    /*
    1. go to https://the-internet.herokuapp.com/
    2. click on A/B Testing
    3. verify "Test Control" text is there
     */
    @Test
    public void verifyABText(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://the-internet.herokuapp.com/");

        WebElement abTesting = driver.findElement(By.linkText("A/B Testing"));
        abTesting.click();

        WebElement abTestControl = driver.findElement(By.xpath("//div[@class='example']/h3"));
        String textToVerify = abTestControl.getText();

        Assert.assertTrue(textToVerify.contains("Test Control"));

        driver.quit();
    }

    @Before
    public void method(){

    }
}
