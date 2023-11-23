import java.util.ArrayList;
import java.util.Scanner;

public class LeetCode {
    public static void main(String[] args) {
        LeetCodeNum1(121);
        delNum();
        sqrt(6);
    }

    //задание: число - палидром
    static void LeetCodeNum1(int num) {
        Scanner scanner = new Scanner(System.in);
        if (isPalindrome(num)) {
            System.out.println(num + " - паліндром");
        } else {
            System.out.println(num + " - не паліндром");
        }
    }

    static boolean isPalindrome(int num) {
        int originalNumber = num;
        int reversedNumber = 0;
        while (num > 0) {
            int lastDigit = num % 10;
            reversedNumber = reversedNumber * 10 + lastDigit;
            num /= 10;
        }
        return originalNumber == reversedNumber;
    }

    //удаленое число
    static void delNum() {
        int[] ar = {4, 5, 7, 8, 10, 9};
        int numberToRemove = 8;
        int[] resultArray = removeNumberFromArray(ar, numberToRemove);
        System.out.print("Масив без числа " + numberToRemove + ": ");
        for (int num : resultArray) {
            System.out.print(num + " ");
        }
    }

    static int[] removeNumberFromArray(int[] array, int numberToRemove) {
        ArrayList<Integer> resultList = new ArrayList<Integer>();
        for (int num : array) {
            if (num != numberToRemove) {
                resultList.add(num);
            }
        }
        int[] resultArray = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            resultArray[i] = resultList.get(i);
        }
        return resultArray;
    }
    //поиск квадратного кореня
    static void sqrt(int number){
        Scanner scanner = new Scanner(System.in);
        if (number >= 0) {
            double squareRoot = Math.sqrt(number);
            System.out.println("Квадратний корінь числа " + number + " дорівнює " + squareRoot);
        } else {
            System.out.println("Для від'ємного числа квадратний корінь не визначений в межах дійсних чисел.");
        }
    }
}





