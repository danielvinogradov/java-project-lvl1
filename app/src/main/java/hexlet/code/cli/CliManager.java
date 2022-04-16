package hexlet.code.cli;

import hexlet.code.miniapps.Startable;
import hexlet.code.miniapps.paritychecker.ParityChecker;
import hexlet.code.miniapps.greeter.Greeter;
import org.jetbrains.annotations.NotNull;

import java.util.InputMismatchException;
import java.util.Scanner;

public final class CliManager {

    private String username;

    private final Scanner scanner;

    private static final String DEFAULT_USERNAME = "_Unknown user_";

    public CliManager(@NotNull String username, @NotNull Scanner scanner) {
        this.username = username;
        this.scanner = scanner;
    }

    public CliManager() {
        this(DEFAULT_USERNAME, new Scanner(System.in));
    }

    public void start() {
        runLoop();
        stop();
    }

    private void stop() {
        scanner.close();
    }

    private void runLoop() {
        boolean shouldContinue = true;

        while (shouldContinue) {
            System.out.println("Please enter the game number and press Enter.");
            System.out.println(Action.getStringRepresentation());

            try {
                int userChoice = scanner.nextInt();
                Action userAction = Action.fromInt(userChoice);
                Startable action = null;

                switch (userAction) {
                    case EXIT:
                        shouldContinue = false;
                        break;
                    case GREET:
                        action = new Greeter(username, scanner, this::setUsername);
                        break;
                    case CHECK_PARITY:
                        action = new ParityChecker(username, scanner);
                        break;
                    default:
                }

                if (action != null) {
                    action.start();
                }

            } catch (InputMismatchException e) {
                System.out.println("Wrong input!");
                scanner.next();
            } catch (Exception e) {
                System.out.println("Something went wrong!");
            }

        }
    }

    private void setUsername(@NotNull String username) {
        this.username = username;
    }
}
