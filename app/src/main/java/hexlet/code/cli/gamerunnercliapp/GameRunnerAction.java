package hexlet.code.cli.gamerunnercliapp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * Перечисление возможных пользовательских действий.
 */
public enum GameRunnerAction {

    /**
     * Завершить выполнение программы.
     */
    EXIT("Exit"),

    /**
     * Поприветствовать пользователя.
     * {@link hexlet.code.miniapps.greeter.Greeter}
     */
    GREET("Greet"),

    /**
     * Игра "Проверка на четность".
     * {@link hexlet.code.games.paritychecker.ParityChecker}
     */
    CHECK_PARITY("Even"),

    /**
     * Игра "Калькулятор".
     * {@link hexlet.code.games.calculator.Calculator}
     */
    CALCULATOR("Calc"),

    /**
     * Игра "Наибольший общий делитель (НОД)".
     * {@link hexlet.code.games.gcd.GCD}
     */
    GCD("GCD"),

    /**
     * Игра "Арифметическая прогрессия".
     * {@link hexlet.code.games.arithmeticprogression.ArithmeticProgression}
     */
    ARITHMETIC_PROGRESSION("Progression"),

    /**
     * Игра "Простое ли число?".
     * {@link hexlet.code.games.prime.Prime}
     */
    PRIME("Prime");

    /**
     * Описание действия.
     */
    private final String description;

    GameRunnerAction(String description) {
        this.description = description;
    }

    /**
     * Получает строковое представление всех элементов перечисления, разделенных переносом строки. Одна
     * строка имеет вид "{ordinal} – {description}". Элементы идут по возрастанию, но элемент с порядковым
     * номером 0 идет последним.
     * <p>
     * Например,
     * <code>
     * 1 – Greet\n
     * 2 – Even\n
     * 0 – Exit
     * </code>
     *
     * @return Строковое представление элементов перечисления.
     */
    public static String getStringRepresentation() {
        Comparator<GameRunnerAction> actionComparator = (o1, o2) -> {
            if (o1.ordinal() == 0) {
                return 1;
            }

            if (o2.ordinal() == 0) {
                return -1;
            }

            return o1.ordinal() - o2.ordinal();
        };

        return Arrays.stream(GameRunnerAction.values())
                .sorted(actionComparator)
                .map(el -> String.format("%d – %s", el.ordinal(), el.description))
                .collect(Collectors.joining("\n"));
    }

    /**
     * Получить GameRunnerAction по его порядковому номеру (ordinal).
     *
     * @param ordinal Порядковый номер.
     * @return GameRunnerAction, соответсвующий порядковому номеру.
     * @throws NullPointerException GameRunnerAction с переданным порядковым номером не существует.
     */
    public static GameRunnerAction fromInt(int ordinal) throws NullPointerException {
        for (GameRunnerAction action : GameRunnerAction.values()) {
            if (action.ordinal() == ordinal) {
                return action;
            }
        }

        throw new NullPointerException();
    }

}
