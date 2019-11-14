import java.util.*;

public class Zadanie4 {

    private static void algorithm() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите строку: ");
        String line = scanner.nextLine().toLowerCase();

        System.out.print("Введите строку для поиска: ");
        String word = scanner.nextLine().toLowerCase();

        word = word.toLowerCase();
        int i = line.indexOf(word);
        int count = 0;

        while (i >= 0) {
            count++;
            i = line.indexOf(word, i + 1);
        }

        System.out.print("Количество: " + count);
    }

    public static void main(String[] args) {
        algorithm();
    }
}