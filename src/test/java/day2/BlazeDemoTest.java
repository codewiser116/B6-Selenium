package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BlazeDemoTest {
    public static void main(String[] args) {
        /*
        1. go to https://www.blazedemo.com/
        2. click on “destination of the week”
        3. print url (driver.getCurrentUrl())
        4. verify Destination of the week: Hawaii ! (element.getText())
        if (text contains Hawaii){
        pass}
         */

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.blazedemo.com/");

        WebElement destinationOfTheWeek = driver.findElement(By.xpath("//a[@href='vacation.html']"));
        destinationOfTheWeek.click();

        String url = driver.getCurrentUrl();
        System.out.println(url);

        WebElement destination = driver.findElement(By.xpath("(//div[@class='container'])[2]"));
        String destinationText = destination.getText();

        if (destinationText.contains("Hawaii")){
            System.out.println("PASS!");
        }else{
            System.out.println("FAIL!");
        }

        driver.quit(); //will quit the browser

        // BREAK UNTIL 10:15 AM

//        driver.findElement(By.)




    }
}
