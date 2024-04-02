package day5;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class OrangeHRMTest {
    /*
    CSS and linkText/partialLinkText locators should be used

    1. go to https://opensource-demo.orangehrmlive.com
    2. enter username, password and click on login
    3. click on Admin
    4. verify URL contains "admin"
    5. click on My Info
    6. verify URL contains "viewPersonalDetails"
    7. click on PIM
    8. print all firstnames + lastnames
     */


    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(2000);

        WebElement username = driver.findElement(By.cssSelector("input[name=username]"));
        username.sendKeys("Admin");

        WebElement password = driver.findElement(By.cssSelector("input[name=password]"));
        password.sendKeys("admin123");

        WebElement button = driver.findElement(By.cssSelector("button[type=submit]"));
        button.click();

//        WebElement dashboard  = driver.findElement(By.xpath("//i[@class='oxd-icon bi-list oxd-topbar-header-hamburger']"));
//        dashboard.click();

        Thread.sleep(5000);


        WebElement admin = driver.findElement(By.partialLinkText("Admin"));
        ////a[@class='oxd-main-menu-item active toggle']
        admin.click();
        Thread.sleep(2000);


        String url = driver.getCurrentUrl();
        System.out.println(url);

        Assert.assertTrue(url.contains("admin"));

//        if (url.contains("admin")){
//            System.out.println("Confirm");
//        }
//        else
//            System.out.println("Fail");

        WebElement myInfo = driver.findElement(By.linkText("My Info"));
        myInfo.click();

        String url1 = driver.getCurrentUrl();
        System.out.println(url1);

        Assert.assertTrue(url1.contains("viewPersonalDetails"));

        Thread.sleep(5000);

        WebElement pim = driver.findElement(By.linkText("PIM"));
        pim.click();

        Thread.sleep(5000);

        List<WebElement> first_names = driver.findElements(By.
                xpath("//div[@class='oxd-table-row oxd-table-row--with-border oxd-table-row--clickable']/div[3]"));

        List<WebElement> last_names = driver.findElements(By.
                xpath("//div[@class='oxd-table-row oxd-table-row--with-border oxd-table-row--clickable']/div[4]"));


        for(int i = 0; i < first_names.size(); i++){
            System.out.println(first_names.get(i).getText() + " " + last_names.get(i).getText());
        }

        driver.quit();


    }





}
