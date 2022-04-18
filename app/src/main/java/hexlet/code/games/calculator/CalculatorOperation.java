package hexlet.code.games.calculator;

import java.util.List;
import java.util.Random;

/**
 * Арифметические операции.
 */
public enum CalculatorOperation {

    /**
     * Нахождение суммы.
     */
    ADDITION("+"),

    /**
     * Нахождение разности.
     */
    SUBTRACTION("-"),

    /**
     * Нахождение произведения.
     */
    MULTIPLICATION("*");

    /**
     * Знак, обозначающий операцию.
     */
    private final String sign;

    CalculatorOperation(String s) {
        sign = s;
    }

    /**
     * Закешированные значения перечисления, чтобы не вычислять их каждый раз при
     * получении случайного элемента.
     *
     * @see <a href="https://stackoverflow.com/a/1972399">Stack Overflow: Pick a random value from an enum?</a>
     */
    private static final List<CalculatorOperation> VALUES = List.of(values());

    /**
     * Размер. Тоже закешированный для предотвращения лишних вычислений.
     */
    private static final int SIZE = VALUES.size();

    private static final Random RANDOM = new Random();

    /**
     * Получить случайную операцию (случайный элемент перечисления).
     *
     * @return Случайная операция.
     */
    public static CalculatorOperation getRandomOperation() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }

    public String getSign() {
        return sign;
    }

}
