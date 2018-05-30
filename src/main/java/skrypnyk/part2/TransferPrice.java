package skrypnyk.part2;

public class TransferPrice {
    private static int[][] price;
    private static int[][] tripCost;
    private static int citiesValue;
    private static final int MAX_COST = 200000;

    public TransferPrice(int numberOfCities){ //array with transfer prices
        price = new int[numberOfCities][numberOfCities];
        citiesValue = numberOfCities;
        for (int i = 0; i < numberOfCities; i++){
            for(int y = 0; y < numberOfCities; y++){
                price[i][y] = MAX_COST;
            }
        }
        tripCost = price;
    }

    public static void setPrice(int departureCityIndex, int arrivalCityIndex, int transportationCost ){ //input txt data to array
        if (departureCityIndex < 0 || arrivalCityIndex < 0) {
            System.out.println("Incorrect values of city index.");
            return;
        } else if(transportationCost < 0) {
            System.out.println("Incorrect value of transportation costs.");
            return;
        }

        price[departureCityIndex][arrivalCityIndex - 1] = transportationCost;

    }


    public static void countPathPrice(){ // transfer price count & filling array
        for (int k = 0; k < citiesValue; k++)
            for (int i = 0; i < citiesValue; i++)
                for (int j = 0; j < citiesValue; j++)
                    tripCost[i][j] = Math.min(tripCost[i][j], tripCost[i][k] + tripCost[k][j]);
    }

    public static String getPathPrice(String departureCity, String arrivalCity){ //min cost between cities
        String pathCosts = "No path between " + departureCity.toUpperCase() + " and " + arrivalCity.toUpperCase();
        if (tripCost[Cities.getIndex(departureCity)][Cities.getIndex(arrivalCity)] < MAX_COST){
            pathCosts = "From " + departureCity.toUpperCase() +
                    " to " + arrivalCity.toUpperCase() +
                    " minimum  cost of path is " +
                    tripCost[Cities.getIndex(departureCity)][Cities.getIndex(arrivalCity)];
        }
        return pathCosts;
    }
}
