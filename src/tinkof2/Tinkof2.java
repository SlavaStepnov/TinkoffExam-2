
package tinkof2;

//import java.util.Arrays;
import java.util.Scanner;

public class Tinkof2 {

    public static void main(String[] args) {
        /*
        Scanner scanner = new Scanner(System.in);
        String someString = scanner.next();
        String shr = "sheriff";
        char[] shrToChar = shr.toCharArray();
        
        int[] count = new int[shr.length()];
        for (int j = 0; j < shr.length(); j++) {
            for (int i = 0; i < someString.length(); i++) {
                if (someString.charAt(i) == shrToChar[j]) {
                    count[j]++;
                }
            }
        }
        Arrays.sort(count);
        System.out.println(count[0]);
        
        В принципе работает, но есть небольшая логическая ошибка
        Поэтому сделал второй вариант
        
        */
        
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        int result = maxSheriffWords(input);
        System.out.println(result);
    }
    public static int maxSheriffWords(String input) {
        // Создание массива с количеством букв, необходимых для слова "sheriff"
        int[] letterCount = new int[26]; // 26 букв в алфавите
        for (char c : "sheriff".toCharArray()) {
            letterCount[c - 'a']++;
        }

        // Подсчет количества букв в строке
        int[] inputCount = new int[26];
        for (char c : input.toCharArray()) {
            inputCount[c - 'a']++;
        }

        int maxWords = Integer.MAX_VALUE;
        // Находим минимальное количество букв, необходимых для каждой буквы в слове "sheriff"
        for (int i = 0; i < 26; i++) {
            if (letterCount[i] != 0) {
                int possibleWords = inputCount[i] / letterCount[i];
                maxWords = Math.min(maxWords, possibleWords);
            }
        }
        return maxWords;
    }
}