import java.util.Arrays;
import java.util.Scanner;

public class Zadanie3 {

    private static void algorithm() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        String[] words = str.split(" ");
        System.out.println("Количество слов: " + words.length);

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char first = word.charAt(0);
            char upperChar = Character.toUpperCase(first);
            words[i] = word.replace(first, upperChar);
        }

        Arrays.sort(words);
        System.out.println("Вывод: " + Arrays.toString(words));
    }

    public static void main(String[] args) {
        algorithm();
    }
}