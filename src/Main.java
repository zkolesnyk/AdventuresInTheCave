import java.util.Scanner;

public class Main {
    // информация об игроке
    static String name = "";
    // информация о противнике
    static String enemyName = "";
    // информация о сокровище
    static String treasureName = "";
    static Scanner in = new Scanner(System.in);

    static String room1 = "Ты проник через вход в пещеры.";
    static String room2 = "Ты продвигаешься дальше, вглубь пещеры.";
    static String room3 = "Ты доcтиг предельных глубин пещеры.";

    public static void main(String[] args) {
        treasureName = "Золотой меч";
        enemyName = "гоблина";
        room(true, true, room1);
        enemyName = "вомбата";
        room(true, true, room2);
        enemyName = "лорда хобгоблинов";
        treasureName = "груду драгоценностей.";
        room(true, true, room3);
    }

    private boolean intro() {
        System.out.println("О, храбрый рыцарь! Как твоё имя?");
        name = in.next();
        System.out.printf("Нам нужна твоя помощь, %s, нашу деревню захватили гоблины из северных пещер.%n", name);
        System.out.println("Примешь ли ты вызов? %n1) да%n2) нет%n");
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
                } else if (!enemy) {
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
                    } else if (!enemy) {
                        return;
                    }
                    break;
                case 2:
                    treasure = !treasure;
                    System.out.printf("Ты взял %s.%n", treasureName);
                    break;
            }
        }
    }
}
