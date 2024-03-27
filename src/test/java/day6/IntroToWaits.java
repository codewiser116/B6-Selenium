package day6;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class IntroToWaits {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        // this is implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebElement username = driver.findElement(By.cssSelector("input[name=username]"));
        username.sendKeys("Admin");

        WebElement password = driver.findElement(By.cssSelector("input[name=password]"));
        password.sendKeys("admin123");

        // this is an object of explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // THIS IS EXPLICIT WAIT
        WebElement button = driver.findElement(By.cssSelector("button[type=submit]"));
        wait.until(ExpectedConditions.elementToBeClickable(button));

        button.click();


        // THIS IS FLUENT WAIT
        /*
        This object will wait for specific condition to happen up to 60 seconds
        it will check if that condition happened every 1 second
        if NoSuchFrameException is thrown within those 60 seconds, it will ignore it

        if the condition was not met even after 60 sec, then it throws Exception
         */

        Wait fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(60)) // total duration that you can wait
                .ignoring(NoSuchFrameException.class) // the exception that should be ignored during those 60 seconds
                .pollingEvery(Duration.ofSeconds(1)); // how often you want the driver to go and check the element

        WebElement login = driver.findElement(By.id("banana"));

        fluentWait.until(ExpectedConditions.elementToBeClickable(login));



        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));




        WebElement admin = driver.findElement(By.partialLinkText("Admin"));
        ////a[@class='oxd-main-menu-item active toggle']
        admin.click();


        String url = driver.getCurrentUrl();
        System.out.println(url);
        if (url.contains("admin")){
            System.out.println("Confirm");
        }
        else
            System.out.println("Fail");

        WebElement myInfo = driver.findElement(By.linkText("My Info"));
        myInfo.click();

        String url1 = driver.getCurrentUrl();
        System.out.println(url1);
        if (url1.contains("viewPersonalDetails")){
            System.out.println("Confirm");
        }
        else
            System.out.println("Fail");

        WebElement pim = driver.findElement(By.linkText("PIM"));
        pim.click();


        List<WebElement> first_names = driver.findElements(By.
                xpath("//div[@class='oxd-table-row oxd-table-row--with-border oxd-table-row--clickable']/div[3]"));

        List<WebElement> last_names = driver.findElements(By.
                xpath("//div[@class='oxd-table-row oxd-table-row--with-border oxd-table-row--clickable']/div[4]"));


        for(int i = 0; i < first_names.size(); i++){
            System.out.println(first_names.get(i).getText() + " " + last_names.get(i).getText());
        }





        // we store the element in object to reuse it later
//        WebElement el = driver.findElement(By.id("banana"));
//        /*
//            some other code
//         */
//        wait.until(ExpectedConditions.elementToBeClickable(el));
//        el.click();
//
//        //------------------------------
//
//        WebElement element4 = wait.until(ExpectedConditions.elementToBeClickable(By.id("banana")));
//        element4.click();
//
//        //------------------------------
//
//        wait.until(ExpectedConditions.elementToBeClickable(By.id("banana"))).click();










//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("apple")));
//        WebElement element2 = driver.findElement(By.id("apple"));
//        element2.sendKeys("fsf");
//
//
//        WebElement element3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("")));
//        element3.click();
//
//
//        // we don't store the object, we use it right away
//        driver.findElement(By.id("")).click();
//
//
//
//        wait.until(ExpectedConditions.elementToBeClickable(By.id("someID")));
//
//
//
//
//
//
//
//
//        String word = "Hello";
//        System.out.println(word);
//
//        System.out.println("Hello");
//
//




        driver.quit();



    }


    public static double getNum(){
        return 0;
    }






}
