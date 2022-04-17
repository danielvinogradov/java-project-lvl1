package hexlet.code.games.calculator;

public final class CalculatorExpression {
    private final String expression;
    private final int result;

    public CalculatorExpression(String expression, int result) {
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
