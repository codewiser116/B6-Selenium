package day9;

import org.junit.Assert;
import org.junit.Test;

public class GradingSystemTests {


    /**
     *
     * if points >= 90 $ <= 100, return A
     * if points >= 80 $ < 90, return B
     * if points >= 70 $ < 80, return C
     * else return D
     *
     */

    public static char grade(int points){
        if (points <= 100 && points >= 90){
            return 'A';
        }
        else if (points < 90 && points >= 80){
            return 'B';
        }
        else if (points < 80 && points >= 70){
            return 'C';
        }else if (points < 70 && points >= 60){
            return 'D';
        }else if (points < 50 && points >= 40){
            return 'E';
        }
        else {
            return '0';
        }
    }

    @Test
    public void test1(){
        Assert.assertEquals('A',grade(93));
    }

    @Test
    public void test2(){
        Assert.assertTrue(grade(115) == 'D');
    }

    @Test
    public void test3(){
        Assert.assertEquals('B', grade(85));
    }

    @Test
    public void test4(){
        Assert.assertNotEquals('C', grade(98));
    }

    @Test
    public void test5(){

    }






}
