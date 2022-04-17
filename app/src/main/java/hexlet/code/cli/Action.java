package hexlet.code.cli;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * Перечисление возможных пользовательских действий.
 */
public enum Action {

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
     */
    CALCULATOR("Calc");

    /**
     * Описание действия.
     */
    private final String description;

    Action(String description) {
        this.description = description;
    }

    /**
     * Получает строковое представление всех элементов перечисления, разделенных переносом строки. Одна
     * строка имеет вид "{ordinal} – {description}". Элемент с порядковым номером 0 идет последним.
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
        Comparator<Action> actionComparator = (o1, o2) -> {
            if (o1.ordinal() == 0) {
                return 1;
            }

            if (o2.ordinal() == 0) {
                return -1;
            }

            return o1.ordinal() - o2.ordinal();
        };

        return Arrays.stream(Action.values())
                .sorted(actionComparator)
                .map(el -> String.format("%d – %s", el.ordinal(), el.description))
                .collect(Collectors.joining("\n"));
    }

    /**
     * Получить Action из его порядкового номера (ordinal).
     *
     * @param ordinal Порядковый номер.
     * @return Action, соответсвующий порядковому номеру.
     * @throws NullPointerException Action с переданным порядковым номером не существует.
     */
    public static Action fromInt(int ordinal) throws NullPointerException {
        for (Action action : Action.values()) {
            if (action.ordinal() == ordinal) {
                return action;
            }
        }

        throw new NullPointerException();
    }

}
