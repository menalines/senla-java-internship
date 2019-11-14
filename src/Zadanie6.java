import java.util.ArrayList;
import java.util.Scanner;

public class Zadanie6 {

    private static void algorithm() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите грузоподъемность рюкзака: ");

        if (scanner.hasNextInt()) {
            Bag bag = new Bag();
            bag.max = scanner.nextInt();
            ArrayList<Thing> things = new ArrayList<>();

            System.out.println("Введите 'quit' для окончания ввода вещей!");

            things = addNewThing(things);

            if (things != null) {
                calculate(bag, things);
            } else {
                System.out.println("Пустой :(");
            }
        } else {
            System.out.println("Неправильный формат ввода.");
        }
    }

    private static ArrayList<Thing> addNewThing(ArrayList<Thing> things) {
        Scanner scanner = new Scanner(System.in);
        Thing thing = new Thing();
        System.out.print("Введите вещь: ");

        if (scanner.hasNext()) {
            String line = scanner.nextLine();

            if (line.equals("quit")) {
                return things;
            } else {
                thing.title = line;

                System.out.print("Введите стоимость вещи: ");

                if (scanner.hasNextInt()) {
                    Integer cost = scanner.nextInt();

                    if (cost > 0) {
                        thing.cost = cost;

                        System.out.print("Введите вес вещи: ");

                        if (scanner.hasNextInt()) {
                            Integer weight = scanner.nextInt();

                            if (weight > 0) {
                                thing.weight = weight;
                                things.add(thing);

                                return addNewThing(things);
                            } else {
                                System.out.println("Неправильный формат ввода.");
                                return null;
                            }
                        }
                    } else {
                        System.out.println("Неправильный формат ввода.");
                        return null;
                    }
                }
            }
        }

        return null;
    }

    private static void calculate(Bag bag, ArrayList<Thing> things) {
        Integer needed = bag.max;
        int[] weights = new int[things.size()];
        int[] costs = new int[things.size()];

        for (int i = 0; i < things.size(); i++) {
            weights[i] = things.get(i).weight;
            costs[i] = things.get(i).cost;
        }

        int n = weights.length;
        int[][] dp = new int[needed + 1][n + 1];

        for (int j = 1; j <= n; j++) {
            for (int w = 1; w <= needed; w++) {
                if (weights[j - 1] <= w) {
                    dp[w][j] = Math.max(dp[w][j - 1], dp[w - weights[j - 1]][j - 1] + costs[j - 1]);
                } else {
                    dp[w][j] = dp[w][j - 1];
                }
            }
        }

        System.out.println("Ответ: " + dp[needed][n]);
    }

    public static void main(String[] args) {
        algorithm();
    }

    private static class Bag {
        Integer max = 0;
    }

    private static class Thing {
        String title = "";
        Integer weight = 0;
        Integer cost = 0;
    }
}