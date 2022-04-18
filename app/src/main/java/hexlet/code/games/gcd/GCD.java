package hexlet.code.games.gcd;

import hexlet.code.games.AbstractGame;
import hexlet.code.games.util.engine.gamerounddata.DefaultGameRoundData;
import hexlet.code.games.util.engine.gamerounddata.GameRoundData;
import org.jetbrains.annotations.NotNull;

import java.util.Random;
import java.util.function.Predicate;

/**
 * Игра "Наибольший общий делитель (НОД)".
 * <p>
 * Пользователю показывается два случайных числа, например, 25 50. Пользователь должен вычислить
 * и ввести наибольший общий делитель этих чисел.
 */
public final class GCD extends AbstractGame {

    public GCD(@NotNull Random random) {
        super("Find the greatest common divisor of given numbers.", random);
    }

    @Override
    public GameRoundData getGameRoundData() {
        Random random = getRandom();

        final int minNum = 1;
        final int maxNum = 100;
        int a = random.nextInt(maxNum - minNum) + minNum;
        int b = random.nextInt(maxNum - minNum) + minNum;

        final String question = String.format("%d %d", a, b);

        final int correctAnswer = GCDUtil.calculateGCD(a, b);

        final String correctAnswerString = String.valueOf(correctAnswer);

        Predicate<String> predicate = correctAnswerString::equals;

        return new DefaultGameRoundData(question, correctAnswerString, predicate);
    }

}
