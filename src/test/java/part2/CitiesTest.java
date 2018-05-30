package part2;

import org.junit.Assert;
import org.junit.Test;
import skrypnyk.part2.Cities;

public class CitiesTest {
    @Test
    public void addCityTest() {
        final String expected = "{0=gdansk}";
        final String actual;
        Cities.addCity(0, "gdansk");
        actual = Cities.getCities().toString();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getIndexTest() {
        final int expected = 0;
        final int actual;
        Cities.addCity(0, "gransk");
        actual = Cities.getIndex("gdansk");

        Assert.assertEquals(expected, actual);
    }
}
