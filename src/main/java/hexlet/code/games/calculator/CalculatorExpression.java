package hexlet.code.games.calculator;

public final class CalculatorExpression {
    private final String expression;
    private final int result;

    public CalculatorExpression(String e, int r) {
        expression = e;
        result = r;
    }

    public String getExpression() {
        return expression;
    }

    public int getResult() {
        return result;
    }
}
