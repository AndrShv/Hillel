package StreamApiTasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StreamColors {
    public static void main(String[] args) {
        System.out.print("Введите букву для фильтрации: ");
        List<String> colors = Arrays.asList("Red", "Blue", "Green", "Yellow", "Purple", "Pink", "Orange", "Orangble");
        Scanner scanner = new Scanner(System.in);
        char filterLetter = scanner.next().charAt(0);
        List<String> filteredColors = colors.stream()
                        .filter(color -> color.toLowerCase()
                        .charAt(0) == Character.toLowerCase(filterLetter))
                        .collect(Collectors.toList());
        System.out.println("Цвета, начинающиеся на букву " + filterLetter + ": " + filteredColors);
    }
}
