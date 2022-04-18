package hexlet.code.games.calculator;

import hexlet.code.games.AbstractGame;
import hexlet.code.games.util.engine.gamerounddata.DefaultGameRoundData;
import hexlet.code.games.util.engine.gamerounddata.GameRoundData;
import org.jetbrains.annotations.NotNull;

import java.util.Random;
import java.util.function.Predicate;

/**
 * Игра "Калькулятор".
 * <p>
 * Пользователю показывается случайное математическое выражение, например 35 + 16,
 * которое нужно вычислить и записать правильный ответ.
 */
public final class Calculator extends AbstractGame {

    /**
     * Максимальное генерируемое число.
     */
    public static final int MAX_GENERATED_OPERAND = 100;

    public Calculator(@NotNull Random random) {
        super("What is the result of the expression?", random);
    }

    @Override
    public GameRoundData getGameRoundData() {
        final CalculatorExpression calculatorExpression = CalculatorUtil.getRandomCalculatorExpression(getRandom(),
                MAX_GENERATED_OPERAND);
        final String correctAnswerString = String.valueOf(calculatorExpression.getResult());
        final Predicate<String> predicate = (String answer) -> {
            try {
                int correctAnswer = calculatorExpression.getResult();
                int userAnswer = Integer.parseInt(answer);
                return correctAnswer == userAnswer;
            } catch (Exception e) {
                return false;
            }
        };

        return new DefaultGameRoundData(calculatorExpression.getExpression(), correctAnswerString, predicate);
    }

}
