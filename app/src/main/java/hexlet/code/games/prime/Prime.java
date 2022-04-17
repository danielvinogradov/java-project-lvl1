package hexlet.code.games.prime;

import hexlet.code.games.util.UserBooleanAnswer;
import hexlet.code.games.util.engine.Playable;
import hexlet.code.games.util.engine.gamerounddata.DefaultGameRoundData;
import hexlet.code.games.util.engine.gamerounddata.GameRoundData;

import java.util.Random;
import java.util.function.Predicate;

public final class Prime implements Playable {

    private static final Random RANDOM = new Random();

    private static final int MAX = 100;

    @Override
    public GameRoundData getGameRoundData() {
        final String title = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

        final int n = RANDOM.nextInt(MAX);

        final String question = String.valueOf(n);

        boolean isPrime = true;

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                isPrime = false;
            }
        }

        final UserBooleanAnswer correctAnswer = UserBooleanAnswer.fromBoolean(isPrime);

        final String correctAnswerString = correctAnswer.getName();

        Predicate<String> predicate = (String answer) -> correctAnswer == UserBooleanAnswer.fromString(answer);

        return new DefaultGameRoundData(title, question, correctAnswerString, predicate);
    }
}
