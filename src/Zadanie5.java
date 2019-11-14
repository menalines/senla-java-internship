import java.util.Scanner;

public class Zadanie5 {

    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 100;

    private static boolean isPalindrome(int i) {
        int next = 0;
        int temp = i;

        while (temp != 0) {
            next = (next * 10) + (temp % 10);
            temp /= 10;
        }

        return i == next;
    }

    private static void algorithm() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число от 0 до 100: ");

        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();

            if (!(n < MIN_VALUE || n > MAX_VALUE)) {
                System.out.println("Результат");

                for (int i = MIN_VALUE; i < n + 1; i++) {
                    if (isPalindrome(i)) {
                        System.out.print(i + " ");
                    }
                }
            } else {
                System.out.println("Неправильный диапазон");
            }
        } else {
            System.out.println("Неправильный формат ввода.");
        }
    }

    public static void main(String[] args) {
        algorithm();
    }
}