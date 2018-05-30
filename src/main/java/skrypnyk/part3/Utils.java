package skrypnyk.part3;

import java.math.BigInteger;

public class Utils {
    public static void main(String[] args) {
        System.out.println("Sum of the digits in 100! = " + digitsCounter(factorialCounter(100)));
    }

    public static String factorialCounter(int number) {
        BigInteger factorial = BigInteger.ONE;      //creating BigInteger to place 100! value
        for (int i = 1; i <= number; i++) {         //cycle for factorial counting
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial.toString();
    }

    public static int digitsCounter(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += Character.getNumericValue(s.charAt(i));  //taking integers from string with factorial value
        }
        return sum;
    }
}
