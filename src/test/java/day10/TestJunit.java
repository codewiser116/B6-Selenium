package day10;

import org.junit.*;
import org.openqa.selenium.*;
import utils.Driver;

public class TestJunit {

 /*
 Test 1:
 1. go to https://the-internet.herokuapp.com
 2. click on JavaScript Alerts
 3. click on JS Alert
 4. print out alert message
 5. accept that alert
 6. print Result

  Test 2:
 1. go to https://the-internet.herokuapp.com
 2. click on JavaScript Alerts
 3. click on JS Confirm
 4. print out alert message
 5. dismiss that alert
 6. print Result --> You clicked: Cancel

   Test 3:
 1. go to https://the-internet.herokuapp.com
 2. click on JavaScript Alerts
 3. click on JS Prompt
 4. print out alert message
 5. send "Hello World"
 6. accept the alert
 6. print Result --> You entered: Hello World
  */

    static WebDriver driver;
    static String resultMessage;

    @Before
    public void beforeMethod() {
        driver = Driver.getDriver();
        driver.get("https://the-internet.herokuapp.com/");
        WebElement linkJSAlert = driver.findElement(By.linkText("JavaScript Alerts"));
        linkJSAlert.click();
    }

    @Test
    public void test1() {
        WebElement jsAlertBtn = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
        jsAlertBtn.click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        resultMessage = "You successfully clicked an alert";
    }

    @Test
    public void test2() {
        WebElement jsConfirmBtn = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
        jsConfirmBtn.click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();

        resultMessage = "You clicked: Cancel";
    }

    @Test
    public void test3(){
        WebElement jsPrompt = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
        jsPrompt.click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().sendKeys("Hello World");
        driver.switchTo().alert().accept();

        resultMessage = "You entered: ";
    }

    @After
    public void afterMethod(){
        WebElement result = driver.findElement(By.id("result"));
        Assert.assertTrue("The result didn't match! ",result.getText().contains(resultMessage));

        System.out.println(result.getText());
    }

    @AfterClass
    public static void afterClassMethod() {
        driver.quit();
    }





}
