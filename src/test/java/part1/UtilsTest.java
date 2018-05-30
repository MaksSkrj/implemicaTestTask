package part1;

import org.junit.Assert;
import org.junit.Test;
import skrypnyk.part1.Utils;


public class UtilsTest {
    @Test
    public void findCorrectExpressionsTest(){
        final int expected = 14;
        final int actual = Utils.findCorrectExpressions(4);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkInputTest(){
        final String expected = "word input exception";
        final String actual = Utils.checkInput("hmgjfjf");
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void checkInputTest1(){
        final String expected = "less than 0 exception";
        final String actual = Utils.checkInput("-10");
        Assert.assertEquals(expected,actual);
    }
}
