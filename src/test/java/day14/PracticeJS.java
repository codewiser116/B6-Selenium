package day14;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import utils.Driver;

import java.time.Duration;

public class PracticeJS {
    /*
    1. go to https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
    2. login
    3. click on PIM
    4. scroll down
    5. scroll up

    USE JAVASCRIPTEXECUTOR ONLY
     */

    @Test
    public void scrollDownTest() throws InterruptedException {
            WebDriver driver = Driver.getDriver();
            JavascriptExecutor js = (JavascriptExecutor) driver;
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
            Thread.sleep(2000);

            js.executeScript("document.querySelector('input[name=username]').value='Admin';");
            js.executeScript("document.querySelector('input[name=password]').value='admin123';");
            Thread.sleep(2000);

            js.executeScript("document.querySelector('form').submit();");
            Thread.sleep(2000);

//            js.executeScript("document.querySelector('a[href='/web/index.php/pim/viewPimModule']').click();");

            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList");

            Thread.sleep(2000);
            js.executeScript("window.scrollBy(0, 3000)");

//            Thread.sleep(2000);
//            js.executeScript("window.scrollBy(0, -3000)");
    }
}
