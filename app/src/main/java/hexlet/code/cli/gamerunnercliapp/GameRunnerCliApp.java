package hexlet.code.cli.gamerunnercliapp;

import hexlet.code.cli.CliApp;
import hexlet.code.games.Game;
import hexlet.code.games.arithmeticprogression.ArithmeticProgression;
import hexlet.code.games.calculator.Calculator;
import hexlet.code.games.gcd.GCD;
import hexlet.code.games.paritychecker.ParityChecker;
import hexlet.code.games.prime.Prime;
import hexlet.code.games.util.engine.Playable;
import hexlet.code.miniapps.Startable;
import hexlet.code.miniapps.greeter.Greeter;
import hexlet.code.games.util.engine.DefaultEngine;
import hexlet.code.games.util.engine.Engine;
import hexlet.code.user.User;
import hexlet.code.util.printer.Printer;
import org.jetbrains.annotations.NotNull;

import java.util.EnumMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 * Консольное приложения для запуска игр.
 */
public final class GameRunnerCliApp implements CliApp {

    /**
     * Данные о текущем пользователе приложения (игроке).
     */
    private final User user;

    /**
     * Ссылка на сканер (ввод).
     */
    private final Scanner scanner;

    /**
     * Ссылка на принтер (вывод).
     */
    private final Printer printer;

    /**
     * Мапа с возможными играми. Изначально пустая, т.к. подразумевается, что пользователь может запускать
     * не все игры, поэтому инстансы игр не создаются при создании мапы. Инстансы игр создаются (если не
     * созданы ранее) при вызове {@link #provideGame(Game)}.
     */
    private final Map<Game, Playable> games;

    /**
     * Движок для игры. Запускает любую игру. Создается в конструкторе.
     */
    private final Engine engine;

    /**
     * Инстанс Random. Используется всеми играми, поэтому создается в game runner единожды.
     */
    private final Random random;

    /**
     * Mini-app. Приветствует пользователя и записывает получаемое пользовательское
     * имя в {@link #user}.
     */
    private final Startable greeter;

    public GameRunnerCliApp(@NotNull Scanner scanner, @NotNull Printer printer, @NotNull User user) {
        this.scanner = scanner;
        this.printer = printer;
        this.user = user;

        games = new EnumMap<>(Game.class);
        engine = new DefaultEngine(scanner, printer, user);
        random = new Random();
        greeter = new Greeter(scanner, printer, user);
    }

    /**
     * Возвращает инстанс игры. Создает его и добавляет в {@link #games}, если ранее не был создан.
     *
     * @param game Игра, которую необходимо предоставить.
     * @return Инстанс игры.
     * @throws UnsupportedOperationException Игра не поддерживается.
     */
    private Playable provideGame(@NotNull Game game) throws UnsupportedOperationException {
        if (!games.containsKey(game)) {
            switch (game) {
                case CHECK_PARITY:
                    games.put(game, new ParityChecker(random));
                    break;
                case CALCULATOR:
                    games.put(game, new Calculator(random));
                    break;
                case GCD:
                    games.put(game, new GCD(random));
                    break;
                case ARITHMETIC_PROGRESSION:
                    games.put(game, new ArithmeticProgression(random));
                    break;
                case PRIME:
                    games.put(game, new Prime(random));
                    break;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        return games.get(game);
    }

    /**
     * Начать выполнение программы.
     */
    public void start() {
        // запускает цикл программы (выход из цикла совершается через пользовательское действие)
        runLoop();
        // после завершения программы закрывает открытые потоки и др.
        onShutdown();
    }

    /**
     * Совершает необходимые действия перед завершением программы (закрывает
     * потоки и др.).
     */
    private void onShutdown() {
        scanner.close();
        printer.close();
    }

    /**
     * Запускает основной цикл. Останавливается по команде пользователя.
     */
    private void runLoop() {
        boolean shouldContinue = true;

        while (shouldContinue) {
            printer.printlb();
            printer.println(GameRunnerCliAppHelper.START_MESSAGE);
            printer.println(GameRunnerAction.getStringRepresentation());

            try {
                printer.print(String.format("%s: ", GameRunnerCliAppHelper.USER_CHOICE_MESSAGE));
                int userChoice = scanner.nextInt();
                GameRunnerAction userAction = GameRunnerAction.fromInt(userChoice);
                printer.printlb();

                List<GameRunnerAction> dontNeedUserNameGameActions = List.of(GameRunnerAction.EXIT,
                        GameRunnerAction.GREET);
                if (!dontNeedUserNameGameActions.contains(userAction) || !user.isNameSet()) {
                    greeter.start();
                }

                switch (userAction) {
                    case EXIT:
                        shouldContinue = false;
                        break;
                    case GREET:
                        greeter.start();
                        break;
                    case CHECK_PARITY:
                        engine.run(provideGame(Game.CHECK_PARITY));
                        break;
                    case CALCULATOR:
                        engine.run(provideGame(Game.CALCULATOR));
                        break;
                    case GCD:
                        engine.run(provideGame(Game.GCD));
                        break;
                    case ARITHMETIC_PROGRESSION:
                        engine.run(provideGame(Game.ARITHMETIC_PROGRESSION));
                        break;
                    case PRIME:
                        engine.run(provideGame(Game.PRIME));
                        break;
                    default:
                }

            } catch (InputMismatchException e) {
                printer.println(GameRunnerCliAppHelper.WRONG_USER_INPUT_MESSAGE);
                scanner.next();
            } catch (Exception e) {
                printer.println(GameRunnerCliAppHelper.UNKNOWN_ERROR_MESSAGE);
            }

        }
    }

}
