package day6;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.Driver;

import java.time.Duration;

public class PracticeWaits {
    static WebDriver driver;

    @Test
    public void test1() {
       driver = Driver.getDriver();
    }


    @Test
    public void test2(){
        driver = Driver.getDriver();
    }

}
