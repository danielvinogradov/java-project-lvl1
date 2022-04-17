package hexlet.code.games.calculator;

import org.jetbrains.annotations.NotNull;

import java.util.Random;

final class CalculatorUtil {

    private static final Random RANDOM = new Random();

    private static final int MAX_NUMBER = 100;

    public static CalculatorExpression getRandomCalculatorExpression() {
        final CalculatorOperation randomOperation = CalculatorOperation.getRandomOperation();
        final int a = RANDOM.nextInt(MAX_NUMBER);
        final int b = RANDOM.nextInt(MAX_NUMBER);
        final int result = calculate(randomOperation, a, b);
        final String expression = String.format("%d %s %d", a, randomOperation.getSign(), b);

        return new CalculatorExpression(expression, result);
    }

    /**
     * @param operation Операция, которую необходимо выполнить.
     * @param a Первый операнд.
     * @param b Второй операнд.
     * @return Результат выполнения операции над операндами.
     * @throws UnsupportedOperationException Переданная операция не поддерживается.
     */
    public static int calculate(@NotNull CalculatorOperation operation, int a, int b)
            throws UnsupportedOperationException {
        switch (operation) {
            case ADDITION:
                return sum(a, b);
            case SUBTRACTION:
                return subtract(a, b);
            case MULTIPLICATION:
                return multiply(a, b);
            default:
        }

        throw new UnsupportedOperationException();
    }

    private CalculatorUtil() {
    }

    private static int sum(int a, int b) {
        return a + b;
    }

    private static int subtract(int a, int b) {
        return a - b;
    }

    private static int multiply(int a, int b) {
        return a * b;
    }

}
