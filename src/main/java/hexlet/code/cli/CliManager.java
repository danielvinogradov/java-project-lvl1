package hexlet.code.cli;

import hexlet.code.games.arithmeticprogression.ArithmeticProgression;
import hexlet.code.games.calculator.Calculator;
import hexlet.code.games.gcd.GCD;
import hexlet.code.games.paritychecker.ParityChecker;
import hexlet.code.games.prime.Prime;
import hexlet.code.miniapps.greeter.Greeter;
import hexlet.code.games.util.engine.DefaultEngine;
import hexlet.code.games.util.engine.Engine;
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
                System.out.printf("Your choice: %d%n%n", userChoice);
                Engine engine = new DefaultEngine(scanner, username);

                Action userAction = Action.fromInt(userChoice);

                if (username.equals(DEFAULT_USERNAME) && userAction != Action.GREET && userAction != Action.EXIT) {
                    new Greeter(username, scanner, this::setUsername).start();
                }

                switch (userAction) {
                    case EXIT:
                        shouldContinue = false;
                        break;
                    case GREET:
                        new Greeter(username, scanner, this::setUsername).start();
                        break;
                    case CHECK_PARITY:
                        engine.run(new ParityChecker());
                        break;
                    case CALCULATOR:
                        engine.run(new Calculator());
                        break;
                    case GCD:
                        engine.run(new GCD());
                        break;
                    case ARITHMETIC_PROGRESSION:
                        engine.run(new ArithmeticProgression());
                        break;
                    case PRIME:
                        engine.run(new Prime());
                        break;
                    default:
                }


            } catch (InputMismatchException e) {
                System.out.println("Wrong input!");
                scanner.next();
            } catch (Exception e) {
                System.out.println("Something went wrong!");
            }

            shouldContinue = false;

        }
    }

    private void setUsername(@NotNull String username) {
        this.username = username;
    }
}
