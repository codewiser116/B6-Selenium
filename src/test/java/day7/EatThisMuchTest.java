package day7;

import org.openqa.selenium.WebDriver;
import utils.Driver;

public class EatThisMuchTest {
    public static void main(String[] args) {

        WebDriver driver = Driver.getDriver();
        driver.get("https://www.eatthismuch.com/");

    }
}
