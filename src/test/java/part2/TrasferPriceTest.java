package part2;

import org.junit.Assert;
import org.junit.Test;
import skrypnyk.part2.Cities;
import skrypnyk.part2.TransferPrice;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class TrasferPriceTest {
    @Test
    public void getPathPriceTest() throws FileNotFoundException {
        final String expected = "From GDANSK to WARSZAWA minimum  cost of path is 3" + System.lineSeparator() +
                "From BYDGOSZCZ to WARSZAWA minimum  cost of path is 2" + System.lineSeparator();
        final String actual;
        StringBuilder sb = new StringBuilder();

        System.out.println("Write txt file with cities, transfer prices and travel rout");


        Scanner sc = new Scanner(new FileReader("part2.txt"));
        int numberOfTest = Integer.parseInt(sc.nextLine().replace("\uFEFF", ""));
        if (numberOfTest > 10) {
            System.out.println("Please check values from file. The number of tests must be <= 10");
            return;
        }
        int numberOfCities = Integer.parseInt(sc.nextLine().replace("\uFEFF", ""));
        if (numberOfCities > 10000) {
            System.out.println("Please check data.The number of cities must be <= 10000");
            return;
        }

        TransferPrice travelRate = new TransferPrice(numberOfCities); // Create a new class object with travel rate

        for (int cityIndex = 0; cityIndex < numberOfCities; cityIndex++) { // Adding cities
            Cities.addCity(cityIndex, sc.nextLine());
            int neighbours = Integer.parseInt(sc.nextLine());
            for (int y = 0; y < neighbours; y++) {
                String[] nrCost = sc.nextLine().split(" ");
                TransferPrice.setPrice(cityIndex, Integer.parseInt(nrCost[0]), Integer.parseInt(nrCost[1]));//Setting price of transfer between cities
            }
        }
        ArrayList<String> routes = new ArrayList<>();
        int routePath = Integer.parseInt(sc.nextLine());
        for (int z = 0; z < routePath; z++) {
            routes.add(sc.nextLine());
        }
        sc.close();

        travelRate.countPathPrice(); // Counting min transfer price

        for (String route : routes) {
            String[] pair = route.split(" ");
            System.out.println(travelRate.getPathPrice(pair[0], pair[1]));
            sb.append((travelRate.getPathPrice(pair[0], pair[1]))).append(System.lineSeparator());
        }

        actual = sb.toString();
        Assert.assertEquals(expected, actual);
    }

}
