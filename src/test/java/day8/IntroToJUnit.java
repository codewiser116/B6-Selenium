package day8;

import org.junit.Assert;
import org.junit.Test;

public class IntroToJUnit {

    /*
    instance method that accepts 2 ints
    and returns their sum
     */

    public int sum(int a, int b){
        return a + b;
    }

    // examples of unit testing
    @Test
    public void testSum1(){
        Assert.assertEquals(9, sum(5, 4));
    }

    @Test
    public void testSum2(){
        Assert.assertEquals(-10, sum(0, -10));
    }

    @Test
    public void testSum3(){
        Assert.assertEquals(-15, sum(-10, - 5));
    }
}
