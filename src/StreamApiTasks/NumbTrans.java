package StreamApiTasks;

import java.util.*;

public class NumbTrans {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите римское число: ");
        String romanNumeral = scanner.nextLine().toUpperCase();
        int decimal = romanToDecimal(romanNumeral);
        System.out.println("Десятичное значение: " + decimal);
    }

    public static int romanToDecimal(String roman) {
        Map<Character, Integer> romanNumerals = new HashMap<>();
        romanNumerals.put('I', 1);
        romanNumerals.put('V', 5);
        romanNumerals.put('X', 10);
        romanNumerals.put('L', 50);
        romanNumerals.put('C', 100);
        romanNumerals.put('D', 500);
        romanNumerals.put('M', 1000);
        return roman.chars()
                .mapToObj(c -> (char) c)
                .mapToInt(romanNumerals::get)
                .reduce((a, b) -> a < b ? b - a : a + b)
                .orElse(0);

    }
}
