package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.Driver;
import utils.SeleniumUtils;

public class IntroToIframes {
    @Test
    public void testDemoGuru() throws InterruptedException {
       /*
       1. go to https://demo.guru99.com/test/guru99home/
       2. print title of the youtube video
        */
        WebDriver driver = Driver.getDriver();
        driver.get("https://demo.guru99.com/test/guru99home/");

        // 1. Locate the iframe tag
        WebElement youtubeIframe = driver.findElement(By.xpath("//div[@id='rt-showcase']//iframe"));

        // 2. Switch to the iframe
        driver.switchTo().frame(youtubeIframe);
//        driver.switchTo().frame(3);

        // 3. Interact with elements inside this iframe
        WebElement title = driver.findElement(By.xpath("//a[@class='ytp-title-link yt-uix-sessionlink']"));

        System.out.println(title.getText());


//        driver.switchTo().frame(WebElement element);
//        driver.switchTo().frame(String nameOrID);
//        driver.switchTo().frame(int index);
    }


    @Test
    public void practiceFrame(){
        /*
        1. go to https://the-internet.herokuapp.com/iframe
        2. write "Hello" in text editor
        3. position the text in the middle
         */

        WebDriver driver = Driver.getDriver();
        driver.get("https://the-internet.herokuapp.com/iframe");

        // 1. switch to iframe
        driver.switchTo().frame("mce_0_ifr");

        // 2. locate the text editor
        WebElement textEditor = driver.findElement(By.id("tinymce"));

        // 3. clear the text editor
        Actions actions = new Actions(driver);

        actions.keyDown(textEditor, Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND);
        actions.keyDown(textEditor, Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE);

        actions.build().perform();

        textEditor.sendKeys("Hello everyone");

        // 4. switch back to parent
        driver.switchTo().defaultContent();

        WebElement align = driver.findElement(By.xpath("//button[@title='Align center']"));
        SeleniumUtils.click(driver, align);

        // 5. print the text
        System.out.println(driver.findElement(By.xpath("//h3")).getText());

    }



}
