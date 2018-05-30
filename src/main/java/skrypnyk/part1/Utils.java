package skrypnyk.part1;

import java.util.Scanner;

public class Utils {

    public static void main(String[] args) {

        String s = "";
        Scanner sc = new Scanner(System.in);

        while (!s.equals("stop")){                   //making program exit after writing "stop" to console input
            System.out.println("Write brackets quantity(write \"stop\" for exit this program): ");
            String bracketNumber = sc.nextLine();

            if (bracketNumber.equals("stop")) {      //stopping if in console write "stop"
                sc.close();
                s = "stop";
            } else {
                String checkInputException = checkInput(bracketNumber);
                if (checkInputException.equals("less than 0 exception")         //finding returned exception code
                        || checkInputException.equals("word input exception")) {
                } else {                                                 //else - starts findingCorrectExpressions method
                    System.out.println("Bracket expressions quantity: " + findCorrectExpressions(Integer.parseInt(bracketNumber)));
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                }
            }
        }
        sc.close();
    }

    public static String checkInput(String input) {  //checking console input
        try {
            if (Integer.parseInt(input) < 0) {//is input more then 0
                System.out.println("Wrong input!Brackets quantity should be 0 or more");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                return "less than 0 exception";     //return statement for test method
            }
        } catch (NumberFormatException ex) {        //is input == int
            System.out.println("Wrong input! Write number");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            return "word input exception";          //return statement for test method
        }
        return "without exceptions";
    }

    public static int findCorrectExpressions(int data) {      //finding correct brackets expressions
        int[] result = new int[data + 1];
        result[0] = 1;
        for (int i = 1; i <= data; i++) {
            result[i] = 0;
            for (int j = 0; j < i; j++) {
                result[i] += result[j] * result[i - 1 - j];
            }
        }
        return result[data];
    }

}
