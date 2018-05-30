package skrypnyk.part2;

import java.util.HashMap;
import java.util.Map;

public class Cities {
    static  Map<Integer, String> cities = new HashMap<>();

    public static void addCity(int key, String value){      //adding city
        cities.put(key, value);
    }

    public static int getIndex(String name){        //getting city index via city name
        int index = 0;
        for (Map.Entry<Integer, String> pair : cities.entrySet()){
            if (pair.getValue().equals(name)){
                index = pair.getKey();
            }
        }
        return index;
    }

    public static Map<Integer, String> getCities() {
        return cities;
    }
}
