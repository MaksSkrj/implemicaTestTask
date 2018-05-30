package skrypnyk.part2;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) throws IOException {
        System.out.println("Write txt file with cities, transfer prices and travel rout");
        Scanner sc = new Scanner(System.in);
        String dataFileName = sc.nextLine(); //Read file with entity data
        sc = new Scanner(new FileReader(dataFileName));
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
        }

    }
}
