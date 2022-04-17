package hexlet.code.games.calculator;

import hexlet.code.games.util.engine.gamerounddata.DefaultGameRoundData;
import hexlet.code.games.util.engine.gamerounddata.GameRoundData;
import hexlet.code.games.util.engine.Playable;

import java.util.function.Predicate;

/**
 * Игра "Калькулятор".
 */
public final class Calculator implements Playable {

    @Override
    public GameRoundData getGameRoundData() {
        final String title = "What is the result of the expression?";
        final CalculatorExpression calculatorExpression = CalculatorUtil.getRandomCalculatorExpression();
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

        return new DefaultGameRoundData(title, calculatorExpression.getExpression(), correctAnswerString, predicate);
    }

}
