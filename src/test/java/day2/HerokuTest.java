package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HerokuTest {
    public static void main(String[] args) {
        /*
        1. go to https://the-internet.herokuapp.com/
        2. print url (driver.getCurrentUrl())
        3. print title (driver.getTitle())
        4. click on "Checkboxes"
        5. print url
        6. select "checkbox1"
        7. driver.quit
         */
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");

        String url = driver.getCurrentUrl();
        System.out.println(url);

        String title = driver.getTitle();
        System.out.println(title);

        WebElement checkboxes = driver.findElement(By.xpath("//a[@href = '/checkboxes']"));
        checkboxes.click();

        String newUrl = driver.getCurrentUrl();
        System.out.println(newUrl);

        WebElement checkboxes1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        checkboxes1.click();



        String price1 = "$15.99";

        double price2 = 15.99;

        //get rid of dollar sign
        price1 = price1.substring(1); //15.99

        double actualPrice = Double.parseDouble(price1);

        if (actualPrice == price2){
            System.out.println("PASS");
        }



















    }
}
