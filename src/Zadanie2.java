import java.util.*;

public class Zadanie2 {

    private static int nok(int a, int b) {
        int j;
        j = Math.max(a, b);

        while (true) {
            if ((j % a == 0) && (j % b == 0)) {
                return j;
            } else {
                j += 1;
            }
        }
    }

    private static int nod(int a, int b) {
        return b == 0 ? a : nod(b, a % b);
    }

    private static void algorithm() {
        Scanner scanner = new Scanner(System.in);
        int a, b;

        System.out.print("Введите элемент: ");

        if (scanner.hasNextInt()) {
            a = scanner.nextInt();
        } else {
            System.out.print("Неправильный формат");
            return;
        }

        System.out.print("Введите элемент: ");

        if (scanner.hasNextInt()) {
            b = scanner.nextInt();
        } else {
            System.out.print("Неправильный формат");
            return;
        }

        System.out.println("НОК: " + nok(a, b));
        System.out.println("НОД: " + nod(a, b));
    }

    public static void main(String[] args) {
        algorithm();
    }
}