package StreamApiTasks;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
public class NumberList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть числа через кому: ");

        String input = scanner.nextLine();
        List<Integer> numbers = parseInput(input);

        // a. Знайдіть суму всіх парних чисел у списку.
        int sumOfEvenNumbers = numbers.stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Сума парних чисел: " + sumOfEvenNumbers);


        // b. Помножте кожне число у списку на 2 та виведіть результат.
        List<Integer> multipliedNum = numbers.stream()
                .map(number -> number * 2)
                .collect(Collectors.toList());
        System.out.println("Множення кожного числа на 2: " + multipliedNum);


        // c. Визначте максимальне число у списку.
        int maxNumber = numbers.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);
        System.out.println("Максимальне число: " + maxNumber);


        // d. Виведіть лише непарні числа у вигляді рядка, розділених комою.
        String oddNumbers = numbers.stream()
                .filter(number -> number % 2 != 0)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println("Непарні числа: " + oddNumbers);


        // e. Знайдіть середнє арифметичне всіх чисел у списку.
        double average = numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
        System.out.println("Середнє арифметичне: " + average);
    }


    private static List<Integer> parseInput(String input) {
        return List.of(input.split(","))
                .stream()
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
