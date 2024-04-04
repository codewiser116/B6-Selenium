package day12;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.Driver;

public class DragAndDropTest {

    @Test
    public void dragAndDrop1(){
        /*
            1. go to https://demoqa.com/droppable
            2. locate "Drag me" element
            3. click and hold it
            4. move to "Drop here" box
            5. release
         */

        WebDriver driver = Driver.getDriver();
        driver.get("https://demoqa.com/droppable");

        WebElement dragMe = driver.findElement(By.id("draggable"));
        WebElement dropHere = driver.findElement(By.xpath("//div[@id='draggable']//following-sibling::div"));

        Actions actions = new Actions(driver);

        /*
        HOW TO DRAG AND DROP?
        OPTION 1:
                actions
                .clickAndHold(dragMe)
                .moveToElement(dropHere)
                .release()
                .build()
                .perform();

        OPTION 2:
                actions.dragAndDrop(dragMe, dropHere).perform();
         */

        actions.dragAndDrop(dragMe, dropHere).perform();

    }


    @Test
    public void dragAndDrop2() throws InterruptedException {
        /*
            1. go to https://demoqa.com/droppable
            2. click on Accept
            3. click and Acceptable
            4. move it near to Drop Here, but don't drop
         */

        WebDriver driver = Driver.getDriver();
        driver.get("https://demoqa.com/droppable");
        driver.findElement(By.id("droppableExample-tab-accept")).click();

        WebElement acceptable = driver.findElement(By.id("acceptable"));

        Actions actions = new Actions(driver);

        actions.clickAndHold(acceptable)
                .moveByOffset(100, 0)
                .release()
                .build()
                .perform();

        Thread.sleep(2000);

        WebElement notAcceptable = driver.findElement(By.id("notAcceptable"));

        actions.clickAndHold(notAcceptable)
                .moveByOffset(410, -70)
                .release()
                .build()
                .perform();

    }

}
