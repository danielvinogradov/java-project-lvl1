package hexlet.code.games.util.engine;

import hexlet.code.games.util.engine.gamerounddata.GameRoundData;
import hexlet.code.user.User;
import hexlet.code.util.printer.Printer;

import java.util.Scanner;

/**
 * Дефолтный движок для любых игр (наследующих {@link hexlet.code.games.AbstractGame}).
 */
public final class DefaultEngine implements Engine {

    /**
     * Ссылка на инстанс Scanner. Инструмент для получения пользовательского
     * ввода. Передается в конструкторе.
     */
    private final Scanner scanner;

    /**
     * Ссылка на инстанс Printer. Инструмент для вывода. Передается в
     * конструкторе.
     */
    private final Printer printer;

    /**
     * Ссылка на объект текущего пользователя. Нужен для демонстрации
     * адресных сообщений.
     */
    private final User user;

    /**
     * Кол-во раундов игры. Единое для всех игр по условям ТЗ. Можно
     * переопределить в конструкторе.
     */
    private final int rounds;

    /**
     * Дефолтное значение для {@link #rounds}. Если не передать другое, будет
     * использоваться оно.
     */
    private static final int DEFAULT_ROUNDS_AMOUNT = 3;

    public DefaultEngine(Scanner scanner, Printer printer, User user) {
        this(scanner, printer, user, DEFAULT_ROUNDS_AMOUNT);
    }

    public DefaultEngine(Scanner scanner, Printer printer, User user, int rounds) {
        this.scanner = scanner;
        this.printer = printer;
        this.user = user;
        this.rounds = rounds;
    }

    @Override
    public void run(Playable game) {

        printer.println(game.getTitle());

        for (int i = 0; i < rounds; i++) {
            try {
                runRound(game);
            } catch (IncorrectUserAnswerException e) {
                return;
            }
        }

        printer.println(String.format("Congratulations, %s!", user.getName()));

    }

    private void runRound(Playable game) throws IncorrectUserAnswerException {
        final GameRoundData gameRoundData = game.getGameRoundData();

        printer.println(String.format("Question: %s", gameRoundData.getQuestion()));
        printer.print("Answer: ");

        String answer = scanner.next().trim();
        boolean isCorrect = gameRoundData.defineIsCorrect(answer);

        if (isCorrect) {
            printer.println("Correct!");
        } else {
            printer.println(String.format("'%s' is wrong answer ;(. Correct answer was '%s'.",
                    answer,
                    gameRoundData.getCorrectAnswer()));
            printer.println(String.format("Let's try again, %s!", user.getName()));
            throw new IncorrectUserAnswerException();
        }
    }

}
