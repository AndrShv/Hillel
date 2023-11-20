import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class project1 {
    public static void main(String[] args) {
        anagram("listen", "ilents");
        //semistr("level");
        //task11();
        //task10(42,18);
        //avgnum();
        //letters("Hello World");
        //defnum(4);
        //samenum(8);
        //factorial(5);
        int[] ar = {8, 45, 74, 82, 13};
        //minnum(ar);
        int[] bubbleAr = {14, 26, 32, 5};
        // bubbleSort(bubbleAr);
        System.out.println("Відсортований масив:");
        for (int num : bubbleAr) {
            System.out.print(num + " ");
        }
    }

    static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    static void minnum(int[] ar) {
        int minnum = ar[0];
        for (int i = 1; i < ar.length; i++) {
            if (ar[i] < minnum) {
                minnum = ar[i];
            }
        }
        System.out.println("Мінімальний елемент в масиві: " + minnum);
        System.out.println("///////////////////////////////////////");
    }

    static void factorial(int num) {
        long factorial = calculateFactorial(num);
        System.out.println("Факторіал " + num + " = " + factorial);
    }

    static long calculateFactorial(int n) {
        if (n < 0) {
            return -1;
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    static void samenum(int num) {
        int[] sameAr = {1, 45, 3, 9, 5, 8, 9, 5};
        for (int i = 0; i < sameAr.length; i++) {
            if (sameAr[i] == num) {
                System.out.println("true");
                System.out.println("sum = " + num * 2);
            } else {
                System.out.println("false");
            }
        }
    }

    static void defnum(int num) {

        if (isPrime(num)) {
            System.out.println(num + " - просте число");
        } else {
            System.out.println(num + " - не просте число");
        }
    }

    static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {


                return false;
            }
        }

        return true;
    }

    static void letters(String s) {
        int vowelCount = countVowels(s);
        System.out.println("Кількість голосних у рядку: " + vowelCount);
    }

    static int countVowels(String str) {
        int count = 0;
        str = str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }
        count++;
        return count;
    }

    static void avgnum() {
        int[] ar = {5, 4, 7, 12, 1};
        double average = calculateAverage(ar);
        System.out.println("Середнє значення чисел у масиві: " + average);
    }

    static double calculateAverage(int[] array) {
        if (array == null || array.length == 0) {
            System.out.println("Масив порожній або не існує");
            return 0;
        }

        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        double average = (double) sum / array.length;
        return average;
    }

    static void task10(int number1, int number2) {
        int gcd = findGCD(number1, number2);

        System.out.println("Найбільший спільний дільник для " + number1 + " і " + number2 + " = " + gcd);
    }

    static int findGCD(int a, int b) {
        if (b == 0) {


            return a;
        } else {
            return findGCD(b, a % b);
        }
    }

    static void fibonachi(int n) {
        int fibonacciResult = fibonacci(n);
        System.out.println("Число Фібоначчі для n=" + n + " : " + fibonacciResult);
    }

    static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    static void task11() {
        int[] array = {1, 2, 4, 5, 7, 8, 10};
        List<Integer> missingElements = findMissingElements(array);
        System.out.println("Пропущені елементи у масиві: " + missingElements);
    }

    static List<Integer> findMissingElements(int[] array) {
        List<Integer> missingElements = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            boolean found = false;
            for (int j : array) {
                if (i == j) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                missingElements.add(i);
            }
        }
        return missingElements;
    }

    static void semistr(String str) {
        if (isPalindrome(str)) {
            System.out.println(str + " - паліндром");
        } else {
            System.out.println(str + " - не паліндром");
        }
    }

    static boolean isPalindrome(String str) {
        str = str.replaceAll("\\s", "").toLowerCase();
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    static void anagram(String str1, String str2){
        if (areAnagrams(str1, str2)) {
            System.out.println(str1 + " і " + str2 + " - анаграми");
        }
        else {
            System.out.println(str1 + " і " + str2 + " - не анаграми");
        }
    }

    static boolean areAnagrams(String str1, String str2) {
        str1 = str1.replaceAll("\\s", "").toLowerCase();
        str2 = str2.replaceAll("\\s", "").toLowerCase();

        if (str1.length() != str2.length()) {


            return false;
        }
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        return Arrays.equals(charArray1, charArray2);
    }


}






