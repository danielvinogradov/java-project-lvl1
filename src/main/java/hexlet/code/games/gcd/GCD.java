package hexlet.code.games.gcd;

import hexlet.code.games.util.engine.Playable;
import hexlet.code.games.util.engine.gamerounddata.DefaultGameRoundData;
import hexlet.code.games.util.engine.gamerounddata.GameRoundData;

import java.util.Random;
import java.util.function.Predicate;

/**
 * Игра "Наибольший общий делитель (НОД)".
 */
public final class GCD implements Playable {

    private final Random random = new Random();

    @Override
    public GameRoundData getGameRoundData() {
        final String title = "Find the greatest common divisor of given numbers.";

        final int maxNum = 100;
        int a = random.nextInt(maxNum) + 1;
        int b = random.nextInt(maxNum) + 1;

        final String question = String.format("%d %d", a, b);

        final int correctAnswer = GCDUtil.calculateGCD(a, b);

        final String correctAnswerString = String.valueOf(correctAnswer);

        Predicate<String> predicate = (String s) -> s.equals(correctAnswerString);

        return new DefaultGameRoundData(title, question, correctAnswerString, predicate);

    }

}
