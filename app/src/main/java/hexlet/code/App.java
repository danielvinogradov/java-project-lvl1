package hexlet.code;

import hexlet.code.cli.CliApp;
import hexlet.code.cli.gamerunnercliapp.GameRunnerCliApp;
import hexlet.code.user.DefaultUser;
import hexlet.code.user.User;
import hexlet.code.util.printer.ConsolePrinter;
import hexlet.code.util.printer.Printer;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Printer printer = new ConsolePrinter();
        User user = new DefaultUser();

        CliApp gameRunnerCliApp = new GameRunnerCliApp(scanner, printer, user);
        gameRunnerCliApp.start();
    }

}
