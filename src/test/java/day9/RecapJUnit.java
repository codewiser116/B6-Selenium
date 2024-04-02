package day9;

import org.junit.Assert;
import org.junit.Test;

public class RecapJUnit {

    // write 3 unit tests to check isOddMethod

    public boolean isOdd(int a){
        if (a % 2 != 0){
            return true;
        }
        return false;
    }

    @Test
    public void test1(){
        Assert.assertTrue(isOdd(3));
    }

    @Test
    public void test2(){
        Assert.assertFalse(isOdd(4000));
    }

    @Test
    public void test3(){
        Assert.assertTrue(isOdd(-89));
    }

    @Test
    public void test4(){
        Assert.assertFalse(isOdd(-20));
    }

    @Test
    public void test5(){
        Assert.assertFalse(isOdd(0));
    }




}
