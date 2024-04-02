package day8;

import org.junit.*;

public class AnnotationsTest {

    @Test
    public void method1(){
        System.out.println("I'm method 1");
    }

    @Test
    public void method2(){
        System.out.println("Method 2!!!!");
    }

    @Test
    public void method3(){
        System.out.println("Method 3!!!!");
        String word = "hello";


        if (word.startsWith("H")){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
//            Assert.fail("the word did not starti with ");
        }


//        Assert.assertTrue("Word did not start with expected letter!",word.startsWith("h"));

    }

    @Before
    public void beforeMethod(){
        System.out.println("This is before method");
    }

    @After
    public void afterMethod(){
        System.out.println("This is after method");
    }

    @BeforeClass
    public static void beforeClassMethod(){
        System.out.println("THIS IS BEFORE CLASS");
    }

    @AfterClass
    public static void afterClassMethod(){
        System.out.println("THIS IS AFTER CLASS");
    }

}
