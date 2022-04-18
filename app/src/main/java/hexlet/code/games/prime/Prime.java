package hexlet.code.games.prime;

import hexlet.code.games.AbstractGame;
import hexlet.code.games.util.UserBooleanAnswer;
import hexlet.code.games.util.engine.gamerounddata.DefaultGameRoundData;
import hexlet.code.games.util.engine.gamerounddata.GameRoundData;
import org.jetbrains.annotations.NotNull;

import java.util.Random;
import java.util.function.Predicate;

/**
 * Игра "Простое ли число?".
 */
public final class Prime extends AbstractGame {

    /**
     * Минимальное число.
     */
    public static final int MIN_GENERATED_NUM = 1;

    /**
     * Максимальное число.
     */
    private static final int MAX_GENERATED_NUM = 100;

    public Prime(@NotNull Random random) {
        super(UserBooleanAnswer.getBooleanAnswerGameTitle(), random);
    }

    @Override
    public GameRoundData getGameRoundData() {
        Random random = getRandom();
        final int n = random.nextInt(MAX_GENERATED_NUM - MIN_GENERATED_NUM) + 1;
        final String question = String.valueOf(n);

        boolean isPrime = true;
        for (int i = 2; i < n / 2; i++) {
            if (n % i == 0) {
                isPrime = false;
                break;
            }
        }

        final UserBooleanAnswer correctAnswer = UserBooleanAnswer.fromBoolean(isPrime);
        final String correctAnswerString = correctAnswer.getName();
        final Predicate<String> predicate = UserBooleanAnswer.getEqualityPredicate(correctAnswer);

        return new DefaultGameRoundData(question, correctAnswerString, predicate);
    }

}
