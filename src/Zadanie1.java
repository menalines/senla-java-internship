import java.util.Scanner;

public class Zadanie1 {

    private static void algorithm() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите целое число: ");

        if (scanner.hasNextInt()) {
            int i = scanner.nextInt();

            if (i % 2 == 0) {
                System.out.println("Четное число");
            } else {
                System.out.println("Нечетное число");
            }

            if (i >= 1 && isSimpleNumber(i)) {
                System.out.println("Простое число");
            } else {
                System.out.println("Составное число");
            }
        } else {
            System.out.println("Вы ввели не целое число!");
        }
    }

    private static boolean isSimpleNumber(int number) {
        boolean simpleNumber = true;
        int count = 1;

        for (int i = 2; i <= number; i++) {
            if (number % i == 0) {
                count = count + 1;
            }

            if (count > 2) {
                simpleNumber = false;
                break;
            }
        }

        return simpleNumber;
    }

    public static void main(String[] args) {
        algorithm();
    }
}