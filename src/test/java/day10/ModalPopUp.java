package day10;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.Driver;

public class ModalPopUp {

    /*
    Test 1
    1. go to https://www.statista.com/
    2. inside try catch block, click on "Accept all"

    Test 2
    1. go to https://www.statista.com/
    2. inside try catch block, click on "Only Necessary"
     */

    static WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.statista.com/");
    }

    @Test
    public void testPopUp1() {
        try {
            WebElement acceptCookies = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
            acceptCookies.click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPopUp2() {
        try {
            WebElement onlyNecessary = driver.findElement(By.xpath("//button[@id='onetrust-reject-all-handler']"));
            onlyNecessary.click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
