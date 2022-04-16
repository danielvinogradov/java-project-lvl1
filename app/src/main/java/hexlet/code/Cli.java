package hexlet.code;

import java.util.Scanner;

public final class Cli {

    private Cli() {
    }

    public static void greetUser() {
        System.out.println("May I have your name?");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        System.out.printf("Hello, %s!", name);
    }

}
