
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        ArrayList<String> resultantList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a String");
        String inputString = scanner.nextLine();
        char[] stringArray = new char[inputString.length()];

        if (!inputString.contains(" ")) {
            for (int i = 0; i < inputString.length(); i++) {
                stringArray[i] = inputString.charAt(i);
            }
            for (int j = 0; j < Math.pow(2, inputString.length()); j++) {
                String tempString = randomizeCharArray(stringArray, stringArray.length);
                if (!resultantList.contains(tempString)) {
                    resultantList.add(tempString);
                }
            }
            System.out.println(resultantList);
        } else {
            System.out.println("Invalid String");
        }
    }

    private static String randomizeCharArray(char[] stringArray, int arrayLength) {
        Random random = new Random();
        for (int i = arrayLength - 1; i > 0; i--) {
            int randomNumber = random.nextInt(i + 1);
            char temp = stringArray[i];
            stringArray[i] = stringArray[randomNumber];
            stringArray[randomNumber] = temp;
        }
        return new String(stringArray);
    }
}
