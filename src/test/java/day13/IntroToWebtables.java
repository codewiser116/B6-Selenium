package day13;

import day12.DragAndDropTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Driver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IntroToWebtables {
    /*
    1. go to https://the-internet.herokuapp.com/tables
    2. print client info in following format
        FirstName LastName is due $$$ dollars for all clients from table 1
     */
    @Test
    public void printDues(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://the-internet.herokuapp.com/tables");

        List<WebElement> firstNames = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[2]"));
        List<WebElement> lastNames = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[1]"));
        List<WebElement> dues = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[4]"));

        for (int i = 0; i < firstNames.size(); i++){
            System.out.println(firstNames.get(i).getText() + " " + lastNames.get(i).getText() +
                    " is due " + dues.get(i).getText() + " dollars");
        }
    }


    @Test
    public void printDuesMoreThan50(){
        /*
        print only those people who are due more than > 50$ from second table
         */
        WebDriver driver = Driver.getDriver();
        driver.get("https://the-internet.herokuapp.com/tables");

        List<WebElement> firstNames = driver.findElements(By.xpath("//table[@id='table2']/tbody/tr/td[2]"));
        List<WebElement> lastNames = driver.findElements(By.xpath("//table[@id='table2']/tbody/tr/td[1]"));
        List<WebElement> dues = driver.findElements(By.xpath("//table[@id='table2']/tbody/tr/td[4]"));

        for (int i = 0; i < dues.size(); i++) {
            String due = dues.get(i).getText().substring(1);
            double dueint = Double.parseDouble(due);
            if (dueint > 50){
                System.out.println(firstNames.get(i).getText() + " " + lastNames.get(i).getText() + " " + dueint);
            }
        }
        driver.quit();

    }

    @Test
    public void printColumn(){
        /*
        1. go to https://demo.guru99.com/test/table.html
        2. print only second column values 2,5, 6 ,7
         */
        WebDriver driver = Driver.getDriver();
        driver.get("https://demo.guru99.com/test/table.html");

        List<WebElement> secondColum = driver.findElements(By.xpath("//table[@cellspacing='1']/tbody/tr/td[2]"));

        for (int i = 0; i < secondColum.size(); i++) {
            System.out.println(secondColum.get(i).getText());
        }
    }

    @Test
    public void sortNames(){
        /*
        1. go to https://omayo.blogspot.com/
        2. sort names in alphabetical order
        3. print out all names, ages, cities
         */
        WebDriver driver = Driver.getDriver();
        driver.get("https://omayo.blogspot.com/");

        List <List<WebElement>> tables = new ArrayList<>();
        List<String> names = new ArrayList<>();

        for (int i = 1; i <= driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size(); i++){
            List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]/td"));
            tables.add(rows);
            names.add(rows.get(0).getText());
        }

        Collections.sort(names);

        for (String name : names){

            for (int i = 0; i < tables.size(); i++) {
                String nameFromTable = tables.get(i).get(0).getText(); //kishore, manish, praveen, deethi

                if (name.equals(nameFromTable)){
                    System.out.println(name + " " + tables.get(i).get(1).getText() + " " + tables.get(i).get(2).getText());
                }

            }
        }







        /*
        Erzhan's version
         */
        List<WebElement> allStuff = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));

        ArrayList<String> myArray = new ArrayList<>();
        for (WebElement element : allStuff) {
            myArray.add(element.getText());
        }
        Collections.sort(myArray);

        for (String string : myArray) {
            System.out.println(string);
        }

    }

    @Test
    public void getStocks(){
        /*
        1. go to https://www.cnbc.com/
        2. locate the Unusual volumes table
        3. print out the names and prices of those stocks which are above 25.00$
         */
    }




}
