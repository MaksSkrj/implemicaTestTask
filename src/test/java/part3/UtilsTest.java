package part3;

import org.junit.Assert;
import org.junit.Test;
import skrypnyk.part3.Utils;

public class UtilsTest {
    @Test
    public void factorialCounterTest(){
        final int excepted = 120;
        final int actual = Integer.parseInt(Utils.factorialCounter(5));

        Assert.assertEquals(excepted,actual);
    }

    @Test
    public void digitsCounterTest(){
        final int excepted = 648;
        final int actual = Utils.digitsCounter(Utils.factorialCounter(100));

        Assert.assertEquals(excepted, actual);
    }
}
