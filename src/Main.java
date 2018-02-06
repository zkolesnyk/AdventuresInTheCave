import java.util.Scanner;

public class Main {
    // информация об игроке
    private static String name = "";
    // информация о противнике
    private static String enemyName = "";
    // информация о сокровище
    private static String treasureName = "";
    private static Scanner in = new Scanner(System.in);

    private static String room1 = "Ты проник через вход в пещеры.";
    private static String room2 = "Ты продвигаешься дальше, вглубь пещеры.";
    private static String room3 = "Ты доcтиг предельных глубин пещеры.";

    public static void main(String[] args) {
        if (intro()) System.exit(0);
        treasureName = "Золотой меч";
        enemyName = "гоблина";
        room(true, true, room1);
        enemyName = "вомбата";
        room(true, true, room2);
        enemyName = "лорда хобгоблинов";
        treasureName = "груду драгоценностей.";
        room(true, true, room3);
    }

    private static boolean intro() {
        System.out.println("О, храбрый рыцарь! Как твоё имя?");
        name = in.next();
        System.out.printf("Нам нужна твоя помощь, %s, нашу деревню захватили гоблины из северных пещер.%n", name);
        System.out.println("Примешь ли ты вызов? \n1) да\n2) нет");
        int response = in.nextInt();
        return !(response == 1);
    }

    // отображает описание комнаты и варианты действий
    private static void room(boolean enemy, boolean treasure, String description) {
        while (true) {
            System.out.println(description);
            int response = 0;
            do {
                System.out.println("Что ты желаешь сделать?");
                if (enemy) {
                    System.out.printf("1) Напасть на подлого %s%n", enemyName);
                } else {
                    System.out.println("1) Перейти в следующую комнату.");
                }
                if (treasure) {
                    System.out.printf("2) Взять %s.%n", treasureName);
                }
                response = in.nextInt();
            } while (response < 1 || response > 2);
            switch (response) {
                case 1:
                    if (enemy) {
                        enemy = !enemy;
                        System.out.printf("Ты убил смертоносного %s.%n", enemyName);
                    } else return;
                    break;
                case 2:
                    treasure = !treasure;
                    System.out.printf("Ты взял %s.%n", treasureName);
                    break;
            }
        }
    }
}
