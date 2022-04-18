package hexlet.code.games.calculator;

import org.jetbrains.annotations.NotNull;

/**
 * Арифметическое выражение. Содержит его строковое представление и результат.
 */
public final class CalculatorExpression {

    /**
     * Строковое представление арифметического выражения. Например, "14 + 10".
     */
    private final String expression;

    /**
     * Результат вычисления выражения {@link #expression}.
     */
    private final int result;

    public CalculatorExpression(@NotNull String expression, int result) {
        this.expression = expression;
        this.result = result;
    }

    public String getExpression() {
        return expression;
    }

    public int getResult() {
        return result;
    }
}
